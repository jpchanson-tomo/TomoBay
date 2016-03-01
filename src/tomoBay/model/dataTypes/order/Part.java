package tomoBay.model.dataTypes.order;
/** Copyright(C) 2015 Jan P.C. Hanson & Tomo Motor Parts Limited
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
import java.util.HashMap;
import java.util.Map;

import tomoBay.model.dataTypes.ServerStatus;
import tomoBay.model.winstock.Stock;
import tomoBay.helpers.BrandToCode;
/**
 *
 * @author Jan P.C. Hanson
 *
 */
public class Part
{
	/**the cost of the part**/
	private final double cost_M;
	/**enum for access to the map**/
	private enum stringTypes {PART_NO,BRAND,DESCRIPTION}
	/**map holding string properties of this part, partNo, brand, description**/
	private final Map<stringTypes, String> stringProperties_M;
	/**connection to winstock stock info**/
	private Stock winstock_M;
	/****/
	private static final String BADCHAR = Part.badChar();
	
	/**
	 * default ctor
	 */
	@SuppressWarnings("serial")
	public Part(String partNo, String brand)
	{
		super();
		this.winstock_M = new Stock();
		this.stringProperties_M = new HashMap<stringTypes,String>()
				{{
					put(stringTypes.PART_NO, partNo);
					put(stringTypes.BRAND, brand);
					put(stringTypes.DESCRIPTION, getDescription(partNo, brand));
				}};
		this.cost_M = this.getCost(partNo, brand);
		this.winstock_M = null;
	}

	/**
	 * retrieve the part number for this part
	 * @return String the part number for this part.
	 */
	public String partNo() {return this.stringProperties_M.get(stringTypes.PART_NO);}
	
	/**
	 * retrieve the brand associated with this part
	 * @return String the brand associated with this part
	 */
	public String brand() {return this.stringProperties_M.get(stringTypes.BRAND);}
	
	/**
	 * retrieve the description of this part
	 * @return String the description of this part
	 */
	public String description() {return this.stringProperties_M.get(stringTypes.DESCRIPTION);}
	
	/**
	 * retrieve the cost of this part
	 * @return double the cost of this part
	 */
	public double cost() {return this.cost_M;}
	
	/**
	 * retrieve the cost of this particular part from winstock
	 * @return double representing the cost of this part in pounds
	 */
	private double getCost(String partNo, String brand)
	{return this.winstock_M.requestLastCost(partNo, BrandToCode.convert(brand));}
	
	/**
	 * find the description of this part, using winstock
	 * @return String representing the description
	 */
	private String getDescription(String partNo, String brand)
	{
		String result = this.winstock_M.requestDescription(partNo, BrandToCode.convert(brand));
		int endOfString = result.indexOf(BADCHAR);
		if (result.contains(BADCHAR)) {result = result.substring(0, endOfString);}
		return result;
	}
	
	/**
	 * depending on whether the OS is linux or windows depends on which char this returns as a bad char
	 * used when filtering the description from winstock. THIS IS A HACK
	 * @return linux = �, windows = œ
	 */
	private static String badChar()
	{if (ServerStatus.os().toLowerCase().contains("linux")){return "�";} else {return "œ";}}
}

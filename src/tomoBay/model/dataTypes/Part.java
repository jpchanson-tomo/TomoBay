package tomoBay.model.dataTypes;
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
import tomoBay.model.winstock.Stock;
import tomoBay.helpers.BrandToCode;
/**
 *
 * @author Jan P.C. Hanson
 *
 */
public class Part
{
	/**the part number of this part**/
	private final String partNo_M;
	/**the brand of this part**/
	private final String brand_M;
	/**the cost of this part**/
	private final double cost_M;
	/**the description of the part**/
	private final String description_M;
	/**connection to winstock stock info**/
	private Stock winstock;
	
	/**
	 * default ctor
	 */
	public Part(String partNo, String brand)
	{
		super();
		this.winstock = new Stock();
		this.partNo_M = partNo;
		this.brand_M = brand;
		this.cost_M = this.getCost();
		this.description_M = this.getDescription();
		this.winstock = null;
	}

	/**
	 * retrieve the part number for this part
	 * @return String the part number for this part.
	 */
	public String partNo() {return this.partNo_M;}
	
	/**
	 * retrieve the brand associated with this part
	 * @return String the brand associated with this part
	 */
	public String brand() {return this.brand_M;}
	
	/**
	 * retrieve the description of this part
	 * @return String the description of this part
	 */
	public String description() {return this.description_M;}
	
	/**
	 * retrieve the cost of this part
	 * @return double the cost of this part
	 */
	public double cost() {return this.cost_M;}
	
	/**
	 * retrieve the cost of this particular part from winstock
	 * @return double representing the cost of this part in pounds
	 */
	private double getCost()
	{return winstock.requestLastCost(this.partNo_M, BrandToCode.convert(this.brand_M));}
	
	/**
	 * find the description of this part, using winstock
	 * @return String representing the description
	 */
	private String getDescription()
	{return winstock.requestDescription(this.partNo_M, BrandToCode.convert(this.brand_M));}
}

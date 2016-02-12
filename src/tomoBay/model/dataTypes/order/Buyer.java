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
import java.util.Map;
import java.util.HashMap;
import java.util.InputMismatchException;

import tomoBay.model.sql.queries.QueryInvoker;
import tomoBay.model.sql.queries.QueryInvoker.QueryType;

/**
 *
 * @author Jan P.C. Hanson
 *
 */
public class Buyer
{
	private static final String ERRORMSG ="a Buyer must be created with 7 elements: "
											+ "ID, NAME, STREET1, STREE2, CITY, COUNTY, "
											+ "POSTCODE and a phone number";
	/**enum for access to the map**/
	private enum stringTypes {ID,NAME,STREET1,STREET2,CITY,COUNTY,POSTCODE,EMAIL,PHONE}
	/**map holding string properties of this part, partNo, brand, description**/
	private final Map<stringTypes, String> stringProperties_M;
	
	/**
	 * CONSTRUCTOR, initialises object by grabbing the relevant information from the database,
	 * requires a valid buyerID in order to function properly
	 * @param buyerID
	 */
	@SuppressWarnings("serial")
	public Buyer(String buyerID)
	{
		String[] buyerInfo = QueryInvoker.execute(QueryType.SELECT_EBAY_BUYER, new String[] {buyerID}).get(0);
		this.stringProperties_M = new HashMap<stringTypes,String>()
		{{
			put(stringTypes.ID, buyerInfo[0]);
			put(stringTypes.NAME, buyerInfo[1]);
			put(stringTypes.STREET1, buyerInfo[2]);
			put(stringTypes.STREET2, buyerInfo[3]);
			put(stringTypes.CITY, buyerInfo[4]);
			put(stringTypes.COUNTY, buyerInfo[5]);
			put(stringTypes.POSTCODE, buyerInfo[6]);
			put(stringTypes.EMAIL, buyerInfo[7]);
			put(stringTypes.PHONE, buyerInfo[8]);
		}};
	}

	/**
	 * 
	 * @param buyerInfo
	 */
	@SuppressWarnings("serial")
	public Buyer(String[] buyerInfo)
	{
		if(buyerInfo.length!=8) {throw new InputMismatchException(ERRORMSG);}
		this.stringProperties_M = new HashMap<stringTypes,String>()
		{{
			put(stringTypes.ID, buyerInfo[0]);
			put(stringTypes.NAME, buyerInfo[1]);
			put(stringTypes.STREET1, buyerInfo[2]);
			put(stringTypes.STREET2, buyerInfo[3]);
			put(stringTypes.CITY, buyerInfo[4]);
			put(stringTypes.COUNTY, buyerInfo[5]);
			put(stringTypes.POSTCODE, buyerInfo[6]);
			put(stringTypes.EMAIL, buyerInfo[7]);
			put(stringTypes.PHONE, buyerInfo[8]);
		}};
	}
	
	/**
	 * retrieve the BuyerID for this buyer
	 * @return String containing the BuyerID
	 */
	public String buyerID() {return this.stringProperties_M.get(stringTypes.ID);}
	
	/**
	 * retrieve the name of this buyer
	 * @return String containing the name of this buyer
	 */
	public String name() {return this.stringProperties_M.get(stringTypes.NAME);}
	
	/**
	 * retrieve the first street line of the address of this buyer
	 * @return String containing the first street line
	 */
	public String street1() {return this.stringProperties_M.get(stringTypes.STREET1);}
	
	/**
	 * retrieve the second street line of the address of this buyer
	 * @return String containing the second street line
	 */
	public String street2() {return this.stringProperties_M.get(stringTypes.STREET2);}
	
	/**
	 * retrieve the county that this buyers address is associated with
	 * @return String containing the county
	 */
	public String county() {return this.stringProperties_M.get(stringTypes.COUNTY);}
	
	/**
	 * retrieve the city for this buyers listed address
	 * @return String containing the city for this buyer
	 */
	public String city() {return this.stringProperties_M.get(stringTypes.CITY);}
	
	/**
	 * retreive the postcode for this buyers address
	 * @return String containing the postcode of this buyer
	 */
	public String postcode() {return this.stringProperties_M.get(stringTypes.POSTCODE);}
	
	/**
	 * retrieve the email address associated with this buyer
	 * @return String containing the email address of this buyer
	 */
	public String email() {return this.stringProperties_M.get(stringTypes.EMAIL);}
	
	/**
	 * retrieve the phone number of this buyer
	 * @return long representing the phone number of this buyer
	 */
	public String phoneNo() {return this.stringProperties_M.get(stringTypes.PHONE);}
}

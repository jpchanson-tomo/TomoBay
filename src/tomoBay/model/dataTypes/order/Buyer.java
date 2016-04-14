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
import java.util.InputMismatchException;

import tomoBay.model.dataTypes.heteroTypeContainer.ClassRef;
import tomoBay.model.dataTypes.heteroTypeContainer.HeteroFieldContainer;
import tomoBay.model.sql.framework.SelectQueryInvoker;
import tomoBay.model.sql.framework.SelectQueryInvoker.SelectQueryTypeParams;
import tomoBay.model.sql.schema.buyerTable.BuyerTable;

/**
 * This class represents an eBay buyer and once instantiated contains all the pertinent information
 * on the particular buyer instance.
 * @author Jan P.C. Hanson
 *
 */
public class Buyer
{
	/**the error message that will be displayed should the incorrect no of arguments be used to create the Buyer**/
	private static final String ERRORMSG ="a Buyer must be created with 8 elements: "
											+ "ID, NAME, STREET1, STREE2, CITY, COUNTY, "
											+ "POSTCODE, EMAIL and a PHONE";
	/****/
	private final HeteroFieldContainer buyerInfo_M;
	
	/**
	 * CONSTRUCTOR, initialises object by grabbing the relevant information from the database,
	 * requires a valid buyerID in order to function properly
	 * @param buyerID
	 */
	public Buyer(String buyerID)
	{
		HeteroFieldContainer param = new HeteroFieldContainer();
		param.add(BuyerTable.BUYERID, buyerID);
		buyerInfo_M = SelectQueryInvoker.execute(SelectQueryTypeParams.SELECT_EBAY_BUYER, param).get(0);
	}

	/**
	 * 
	 * @param buyerInfo
	 */
	public Buyer(HeteroFieldContainer buyerInfo)
	{
		if(buyerInfo.size()!=8) {throw new InputMismatchException(ERRORMSG);}
		buyerInfo_M = buyerInfo;
	}
	
	/**
	 * retrieve the BuyerID for this buyer
	 * @return String containing the BuyerID
	 */
	public String buyerID() 
	{return this.buyerInfo_M.get(BuyerTable.BUYERID, ClassRef.STRING);}
	
	/**
	 * retrieve the name of this buyer
	 * @return String containing the name of this buyer
	 */
	public String name() 
	{return this.buyerInfo_M.get(BuyerTable.NAME, ClassRef.STRING);}
	
	/**
	 * retrieve the first street line of the address of this buyer
	 * @return String containing the first street line
	 */
	public String street1() 
	{return this.buyerInfo_M.get(BuyerTable.STREET1, ClassRef.STRING);}
	
	/**
	 * retrieve the second street line of the address of this buyer
	 * @return String containing the second street line
	 */
	public String street2() 
	{return this.buyerInfo_M.get(BuyerTable.STREET2, ClassRef.STRING);}
	
	/**
	 * retrieve the county that this buyers address is associated with
	 * @return String containing the county
	 */
	public String county() 
	{return this.buyerInfo_M.get(BuyerTable.COUNTY, ClassRef.STRING);}
	
	/**
	 * retrieve the city for this buyers listed address
	 * @return String containing the city for this buyer
	 */
	public String city() 
	{return this.buyerInfo_M.get(BuyerTable.CITY, ClassRef.STRING);}
	
	/**
	 * retreive the postcode for this buyers address
	 * @return String containing the postcode of this buyer
	 */
	public String postcode() 
	{return this.buyerInfo_M.get(BuyerTable.POSTCODE, ClassRef.STRING);}
	
	/**
	 * retrieve the email address associated with this buyer
	 * @return String containing the email address of this buyer
	 */
	public String email() 
	{return this.buyerInfo_M.get(BuyerTable.EMAIL, ClassRef.STRING);}
	
	/**
	 * retrieve the phone number of this buyer
	 * @return long representing the phone number of this buyer
	 */
	public String phoneNo() 
	{return this.buyerInfo_M.get(BuyerTable.PHONE, ClassRef.STRING);}
}

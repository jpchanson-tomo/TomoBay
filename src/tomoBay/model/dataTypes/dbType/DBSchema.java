package tomoBay.model.dataTypes.dbType;
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
/**
 * this enum contains all the fields used in the database, the fields of different tables
 * are prefixed differently to avoid confusion between similarly named fields.
 * 
 * - BUY_CONSTANT_NAME = ebay_buyers table
 * - ORD_CONSTANT_NAME = ebay_orders table
 * - TRN_CONSTANT_NAME = ebay_transactions table
 * - ITM_CONSTANT_NAME = ebay_items table
 * 
 * @author Jan P.C. Hanson
 *
 */
public enum DBSchema
{
	/**
	 * all the fields contained in the ebay_buyers table 
	 */
	/**VARCHAR(40)**/
	BUY_BUYER_ID, 
	/**VARCHAR(45)**/
	BUY_NAME, 
	/**VARCHAR(100)**/
	BUY_STREET1,
	/**VARCHAR(100)**/
	BUY_STREET2,
	/**VARCHAR(100)**/
	BUY_CITY,
	/**VARCHAR(100)**/
	BUY_COUNTY,
	/**VARCHAR(100)**/
	BUY_POSTCODE,
	/**VARCHAR(45)**/
	BUY_EMAIL, 
	/**VARCHAR(16)**/
	BUY_PHONE_NO,
	
	/**
	 * all the fields contained in the ebay_orders table 
	 */
	/**VARCHAR(30)**/
	ORD_ORDER_ID, 
	/**VARCHAR(40)**/
	ORD_BUYER_ID, 
	/**INT(20)**/
	ORD_SALES_REC_NO, 
	/**VARCHAR(200)**/
	ORD_SHIPPING_TYPE, 
	/**TIMESTAMP(19)**/
	ORD_CREATED_TIME, 
	/**TINYINT(1)**/
	ORD_PICKED, 
	/**TINYINT(1)**/
	ORD_PACKED, 
	/**TINYINT(1)**/
	ORD_SHIPPED, 
	/**TINYINT(1)**/
	ORD_INVOICED,
	
	/**
	 * all the fields contained in the ebay_transactions table 
	 */
	/**BIGINT(20)**/
	TRN_TRANSACTION_ID, 
	/**VARCHAR(30)**/
	TRN_ORDER_ID, 
	/**BIGINT(20)**/
	TRN_ITEM_ID, 
	/**INT(7)**/
	TRN_QUANTITY,
	/**FLOAT(12)**/
	TRN_PRICE, 
	/**TINYINT(1)**/
	TRN_PICKED, 
	/**TINYINT(1)**/
	TRN_PACKED, 
	/**TINYINT(1)**/
	TRN_SHIPPED,
	
	/**
	 * all the fields contained in the ebay_items table 
	 */
	/**BIGINT(13)**/
	ITM_ITEM_ID, 
	/**VARCHAR(83)**/
	ITM_TITLE, 
	/**VARCHAR(15)**/
	ITM_CONDITION, 
	/**VARCHAR(50)**/
	ITM_BRAND, 
	/**VARCHAR(100)**/
	ITM_PART_NO, 
	/**INT(6)**/
	ITM_NO_REQUIRED, 
	/**FLOAT(12)**/
	ITM_COST, 
	/**VARCHAR(60)**/
	ITM_NOTES;
	
	/**map of Strings to enum constants**/
	@SuppressWarnings("serial")
	private static final Map<DBSchema, String> toType_M = new HashMap<DBSchema,String>()
	{{
		put(DBSchema.BUY_BUYER_ID, "String");
		put(DBSchema.BUY_CITY, "String");
		put(DBSchema.BUY_COUNTY, "String");
		put(DBSchema.BUY_EMAIL, "String");
		put(DBSchema.BUY_NAME, "String");
//		put();
//		put();
//		put();
//		put();
//		put();
//		put();
//		put();
//		put();
//		put();
//		put();
//		put();
//		put();
//		put();
//		put();
//		put();
//		put();
//		put();
//		put();
	}};
	
	/**
	 * 
	 * @param field
	 * @return
	 */
	public static String typeOf(DBSchema field)
	{return DBSchema.toType_M.get(field);}
}

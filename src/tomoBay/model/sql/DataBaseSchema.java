package tomoBay.model.sql;
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
public enum DataBaseSchema
{
	/**
	 * all the fields contained in the ebay_buyers table 
	 */
	BUY_BUYER_ID, BUY_NAME, BUY_SHIPPING_ADDRESS, BUY_EMAIL, BUY_PHONE_NO,
	
	/**
	 * all the fields contained in the ebay_orders table 
	 */
	ORD_ORDER_ID, ORD_BUYER_ID, ORD_SALES_REC_NO, ORD_SHIPPING_TYPE, 
	ORD_CREATED_TIME, ORD_PICKED, ORD_PACKED, ORD_SHIPPED, ORD_INVOICED,
	
	/**
	 * all the fields contained in the ebay_transactions table 
	 */
	TRN_TRANSACTION_ID, TRN_ORDER_ID, TRN_ITEM_ID, TRN_QUANTITY,
	TRN_PRICE, TRN_PICKED, TRN_PACKED, TRN_SHIPPED,
	
	/**
	 * all the fields contained in the ebay_items table 
	 */
	ITM_ITEM_ID, TRN_TITLE, TRN_CONDITION, TRN_BRAND, 
	TRN_PART_NO, TRN_NO_REQUIRED, TRN_COST, TRN_NOTES
}

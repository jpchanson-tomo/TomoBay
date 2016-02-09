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
import java.util.List;
import java.util.Map;

import tomoBay.model.dataTypes.Part;
import tomoBay.model.sql.queries.QueryInvoker;
import tomoBay.model.sql.queries.QueryInvoker.QueryType;
/**
 *
 * @author Jan P.C. Hanson
 *
 */
public class Order
{
	/**the order data straight from the database**/
	List<String[]> rawData_M;
	/**map to hold the address data**/
	private Map<OrderDataFields, String> address_M;
	/**list of maps to hold the price data**/
	private List<Map<OrderDataFields, Double>> prices_M;
	/**list of maps to hold quantity data**/
	private List<Map<OrderDataFields, Integer>> quantities_M;
	/** list of maps to hold the part data**/
	private List<Part> partInfo_M;
	/**map to hold order specific information**/
	private Map<OrderDataFields, String> order_M;
	/** list of maps to hold the listing data**/
	private List<Map<OrderDataFields, String>> listing_M;
	/**
	 * default ctor
	 */
	public Order(String orderID)
	{
		super();
		this.rawData_M = this.grabRawData(orderID);
		this.grabRawData(orderID);
		
		this.order_M = PopulateOrderInfo.getInfo(this.rawData_M);
		this.address_M = PopulateBuyersInfo.getInfo(this.rawData_M);
		this.quantities_M = PopulateQuantitiesInfo.getInfo(this.rawData_M);
		this.prices_M = PopulatePricesInfo.getInfo(this.rawData_M);
		this.partInfo_M = PopulatePartInfo.getInfo(this.rawData_M);
		this.listing_M = PopulateListingFields.getInfo(this.rawData_M);
		
		rawData_M.clear();
		rawData_M = null;
	}
	
	/**
	 * 
	 * @return
	 */
	public String buyerName()
	{return this.address_M.get(OrderDataFields.NAME);}
	
	/**
	 * 
	 * @return
	 */
	public String buyerID()
	{return this.address_M.get(OrderDataFields.EBAY_ID);}
	
	/**
	 * 
	 * @return
	 */
	public String street1()
	{return this.address_M.get(OrderDataFields.STREET1);}
	
	/**
	 * 
	 * @return
	 */
	public String street2()
	{return this.address_M.get(OrderDataFields.STREET2);}
	
	/**
	 * 
	 * @return
	 */
	public String city() 
	{return this.address_M.get(OrderDataFields.CITY);}
	
	/**
	 * 
	 * @return
	 */
	public String county() 
	{return this.address_M.get(OrderDataFields.COUNTY);}
	
	/**
	 * 
	 * @return
	 */
	public String postCode() 
	{return this.address_M.get(OrderDataFields.POSTCODE);}
	
	/**
	 * 
	 * @return
	 */
	public String orderID() 
	{return this.order_M.get(OrderDataFields.ORDER_ID);}
	
	/**
	 * 
	 * @return
	 */
	public int SalesRecNo() 
	{return Integer.parseInt(this.order_M.get(OrderDataFields.SALES_REC_NO));}
	
	/**
	 * 
	 * @return
	 */
	public String shippingType() 
	{return this.order_M.get(OrderDataFields.SHIPPING_TYPE);}
	
	/**
	 * 
	 * @return
	 */
	public double orderPrice() 
	{return this.prices_M.get(0).get(OrderDataFields.ORDER_TOTAL);}
	
	/**
	 * 
	 * @return
	 */
	public double shippingCost() 
	{return this.prices_M.get(0).get(OrderDataFields.SHIPPING_COST);}
	
	/**
	 * 
	 * @return
	 */
	public int noOfTransactions() 
	{return this.quantities_M.get(0).get(OrderDataFields.TRANSACTION_QUANTITY);}
	
	/**
	 * 
	 * @param transaction
	 * @return
	 */
	public double transactionCost(int transaction) 
	{return this.prices_M.get(transaction).get(OrderDataFields.TRANSACTION_PRICE);}
	
	/**
	 * 
	 * @param transactionNo
	 * @return
	 */
	public int purchasedQuantity(int transactionNo) 
	{return this.quantities_M.get(transactionNo).get(OrderDataFields.PURCHASED_QUANTITY);}
	
	/**
	 * 
	 * @param transactionNo
	 * @return
	 */
	public String listingID(int transactionNo) 
	{return this.listing_M.get(transactionNo).get(OrderDataFields.LISTING_ID);}
	
	/**
	 * 
	 * @param transactionNo
	 * @return
	 */
	public String listingTitle(int transactionNo) 
	{return this.listing_M.get(transactionNo).get(OrderDataFields.LISTING_TITLE);}
	
	/**
	 * 
	 * @param transactionNo
	 * @return
	 */
	public String listingPartNos(int transactionNo) 
	{return this.listing_M.get(transactionNo).get(OrderDataFields.PART_NUMBER);}
	
	/**
	 * 
	 * @param transactionNo
	 * @return
	 */
	public String listingBrand(int transactionNo) 
	{return this.listing_M.get(transactionNo).get(OrderDataFields.BRAND);}
	
	/**
	 * 
	 * @param transactionNo
	 * @return
	 */
	public int listingSize(int transactionNo) 
	{return this.partInfo_M.;}
	
	/**
	 * 
	 * @param transactionNo
	 * @param partIndex
	 * @return
	 */
	public String partNo(int transactionNo, int partIndex)
	{return this.partInfo_M.get(transactionNo).get(OrderDataFields.PART_NUMBER)[partIndex];}
	
	/**
	 * 
	 * @param transactionNo
	 * @param partIndex
	 * @return
	 */
	public String partDescription(int transactionNo, int partIndex)
	{return this.partInfo_M.get(transactionNo).get(OrderDataFields.PART_DESCRIPTION)[partIndex];}
	
	/**
	 * 
	 * @param transactionNo
	 * @param partIndex
	 * @return
	 */
	public int partQuantity(int transactionNo, int partIndex)
	{return Integer.parseInt(this.partInfo_M.get(transactionNo).get(OrderDataFields.PART_QUANTITY)[partIndex]);}
	
	/**
	 * 
	 * @param transactionNo
	 * @param partIndex
	 * @return
	 */
	public double partCost(int transactionNo, int partIndex)
	{return Double.parseDouble(this.partInfo_M.get(transactionNo).get(OrderDataFields.PART_COSTS)[partIndex]);}
	
	/**
	 * populate the rawData_M List with data from the database
	 */
	private List<String[]> grabRawData(String orderID)
	{return QueryInvoker.execute(QueryType.SELECT_FULL_ORDER_LINE, new String[] {orderID});}
}

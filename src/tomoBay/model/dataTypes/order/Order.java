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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import tomoBay.helpers.BrandToCode;
import tomoBay.model.services.helpers.PartList;
import tomoBay.model.sql.queries.QueryInvoker;
import tomoBay.model.sql.queries.QueryInvoker.QueryType;
import tomoBay.model.winstock.Stock;
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
	/**map to hold the price data**/
	private List<Map<OrderDataFields, Double>> prices_M;
	/**map to hold quantity data**/
	private List<Map<OrderDataFields, Integer>> quantities_M;
	/****/
	private List<Map<OrderDataFields, String[]>> partInfo_M;
	/****/
	private Map<OrderDataFields, String> order_M;
	/****/
	private List<Map<OrderDataFields, String>> listing_M;
	/**
	 * default ctor
	 */
	public Order(String orderID)
	{
		super();
		this.rawData_M = this.grabRawData(orderID);
		this.grabRawData(orderID);
//		for(String[] data : this.rawData_M)
//		{
//			System.out.println(Arrays.toString(data));
//		}
		
		this.order_M = new PopulateOrderInfo(this.rawData_M).getInfo();
		this.address_M = new PopulateBuyersInfo(this.rawData_M).getInfo();
		this.quantities_M = new PopulateQuantitiesInfo(this.rawData_M).getInfo();
		this.prices_M = new PopulatePricesInfo(this.rawData_M).getInfo();
		
		this.partInfo_M = new ArrayList<Map<OrderDataFields, String[]>>();
		this.populatePartInfoFields();
		
		this.listing_M = new ArrayList<Map<OrderDataFields, String>>();
		this.populateListingFields();
		
		rawData_M.clear();
		rawData_M = null;
	}
	
	/**
	 * retrieve the address field requested
	 * @param addressField an OrderData enum constant representing a field in the address. The
	 * relevant enum constants are: OrderData.NAME, OrderData.STREET1, OrderData.STREET2, 
	 * OrderData.CITY, OrderData.COUNTY and OrderData.POSTCODE
	 * @return the string associated with that address field.
	 */
	public String getBuyerInfo(OrderDataFields addressField)
	{return this.address_M.get(addressField);}
	
	/**
	 * retrieve the price field requested.
	 * @param priceField the price field that you wish to find. relevant enum constants are:
	 * OrderDataFields.ORDER_TOTAL, OrderDataFields.TRANSACTION_PRICE, 
	 * OrderDataFields.SHIPPING_COST. If looking for the orderTotal then the transactionNo is
	 * still necessary but as long as it is smaller than the noOfTransactions then the return
	 * value will be the same for all transactions.janhanson
	 * @param transactionNo the index of the transaction that you wish to find information on.
	 * the number of transactions can be determined using the getQuantity() method and passing
	 * it the Order.OrderDataFields.TRANSACTION_QUANTITY constant.
	 * @param priceField
	 * @return
	 */
	public double getPriceInfo(int TransactionNo, OrderDataFields priceField)
	{return this.prices_M.get(TransactionNo).get(priceField);}
	
	/**
	 * retrieve the quantity field requested
	 * @param transactionNo the index of the transaction that you wish to find information on.
	 * the number of transactions can be determined using the getQuantity() method and passing
	 * it the Order.OrderDataFields.TRANSACTION_QUANTITY constant.
	 * @param quantityField the quantity field that you want information on. relevant enum constants
	 * are: orderDataFields.TRANSACTION_QUANTITY, OrderDataFields.PURCHASED_QUANTITY.
	 * If looking for the transaction Quantity (number of transactions) then the transactionNo is
	 * still necessary but use 0 to be safe (unless you know how many transactions there will be)
	 * @return
	 */
	public int getQuantityInfo(int TransactionNo, OrderDataFields quantityField)
	{return this.quantities_M.get(TransactionNo).get(quantityField);}
	
	/**
	 * retrieve the Part Info field requested
	 * @param transactionNo the index of the transaction that you wish to find information on.
	 * the number of transactions can be determined using the getQuantity() method and passing
	 * it the Order.OrderDataFields.TRANSACTION_QUANTITY constant.
	 * @param partField the quantity field that you want information on. relevant enum constants
	 * are: orderDataFields.PART_NUMBER, OrderDataFields.PART_DESCRIPTION and OrderDataFields.Part_QUANTITY.
	 * @return
	 */
	public String[] getPartInfo(int TransactionNo, OrderDataFields partField)
	{return this.partInfo_M.get(TransactionNo).get(partField);}
	
	/**
	 * retrieve order specific datafields
	 * @param orderDataField valid datafields are Order.OrderDataFields.SALES_REC_NO, 
	 * Order.OrderDataFields.SHIPPING_TYPE, Order.OrderDataFields.ORDER_DATE
	 * @return
	 */
	public String getOrderInfo(OrderDataFields orderDataField)
	{return this.order_M.get(orderDataField);}
	
	/**
	 * 
	 * @param transactionNo
	 * @param listingField
	 * @return
	 */
	public String getListingInfo(int transactionNo, OrderDataFields listingField)
	{return this.listing_M.get(transactionNo).get(listingField);}
	
	/**
	 * populate the rawData_M List with data from the database
	 */
	private List<String[]> grabRawData(String orderID)
	{return QueryInvoker.execute(QueryType.SELECT_FULL_ORDER_LINE, new String[] {orderID});}
	
	/**
	 * populate the PartInfo_M list of maps with data stored in rawData_M
	 */
	private void populatePartInfoFields()
	{
		for (int i = 0 ; i < this.rawData_M.size() ; ++i)
		{
			this.partInfo_M.add(new HashMap<OrderDataFields, String[]>());
			PartList parts = new PartList(this.rawData_M.get(i)[7]);
			
			this.partInfo_M.get(i)
			.put(OrderDataFields.PART_NUMBER     , new String[parts.size()]);
			
			this.partInfo_M.get(i)
			.put(OrderDataFields.PART_DESCRIPTION, this.getDescriptions(parts, i));
		
			this.partInfo_M.get(i)
			.put(OrderDataFields.PART_QUANTITY   , new String[parts.size()]);
			
			for (int j = 0 ; j < parts.size() ; ++j)
			{
				this.partInfo_M.get(i).get(OrderDataFields.PART_NUMBER)[j] = parts.getPartNumber(j);
				this.partInfo_M.get(i).get(OrderDataFields.PART_QUANTITY)[j] = String.valueOf(parts.getPartQty(j));
			}
		}
	}
	
	private void populateListingFields()
	{
		for(int i = 0 ; i < this.rawData_M.size() ; ++i)
		{
			this.listing_M.add(new HashMap<OrderDataFields,String>());
			this.listing_M.get(i).put(OrderDataFields.LISTING_ID, this.rawData_M.get(i)[4]);
			this.listing_M.get(i).put(OrderDataFields.LISTING_TITLE, this.rawData_M.get(i)[5]);
			this.listing_M.get(i).put(OrderDataFields.BRAND, this.rawData_M.get(i)[6]);
			this.listing_M.get(i).put(OrderDataFields.PART_NUMBER, this.rawData_M.get(i)[7]);
		}
	}
	
	/**
	 * 
	 * @param parts
	 * @param BrandCode
	 * @return
	 */
	private String[] getDescriptions(PartList parts, int index)
	{
		String[] descs = new String[parts.size()];
		Stock stock = new Stock();
		for(int j = 0 ; j < parts.size() ; ++j)
		{descs[j]=stock.requestDescription(parts.getPartNumber(j), BrandToCode.convert(this.rawData_M.get(index)[6]));}
		return descs;
	}
}

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

import org.apache.log4j.Logger;

import tomoBay.exceptions.OrderException;
import tomoBay.helpers.StackTraceToString;
import tomoBay.model.eBayAPI.EbayAccounts;
import tomoBay.model.sql.queries.QueryInvoker;
import tomoBay.model.sql.queries.QueryInvoker.QueryType;
/**
 *
 * @author Jan P.C. Hanson
 *
 */
public class Order
{
	static Logger log = Logger.getLogger(Order.class.getName());
	/**the buyer of this order**/
	private final Buyer buyer_M;
	/**the transactions associated with this order**/
	private final Transaction[] transactions_M;
	/**the sales record number of this order**/
	private final int salesRecNo_M;
	/**the shipping type used for this order**/
	private final String shippingType_M;
	/**the orderID identifying this order**/
	private final String orderID_M;
	/**the time this order was created**/
	private final String createdTime_M;
	/**the total sale price of this order**/
	private final double orderTotal_M;
	/**the ebay account that this order is associated with**/
	private final String account_M;
	
	/**
	 * initialise this order using the orderID provided
	 * @param orderID
	 */
	public Order(String orderID)
	{
		super();
		try
		{
			this.orderID_M = orderID;
			this.transactions_M = Order.getTransactionList(orderID);
			String[] orderInfo = Order.getOrderInfo(orderID);
			this.buyer_M = new Buyer(orderInfo[4]);
			this.salesRecNo_M = Integer.parseInt(orderInfo[0]);
			this.shippingType_M = orderInfo[1];
			this.createdTime_M = orderInfo[2];
			this.orderTotal_M = Double.parseDouble(orderInfo[3]);
			this.account_M = EbayAccounts.name(Integer.parseInt(orderInfo[6]));
		}
		catch (Exception e)
		{
			log.warn("could not instantitate Order:"+orderID +" "+StackTraceToString.toString(e));
			e.printStackTrace();
			throw new OrderException("could not instantiate Order: "+orderID +"\n"+StackTraceToString.toString(e));
		}
	}
	
	/**
	 * The order ID is a string(numerical) that uniquely identifies this order from all others
	 * @return String containing the orderID
	 */
	public String orderID() {return this.orderID_M;}
	
	/**
	 * Retrieve the Buyer that placed this order.
	 * @return Buyer object containing all the information on the buyer
	 */
	public Buyer buyer() {return this.buyer_M;}
	
	/**
	 * An order is made up of transactions, this method retrieves the specified transaction, given
	 * the index parameter. Should you select a transaction that does not exist you'll probably
	 * get an IndexOutOfBounds exception
	 * @param index the index of the transaction you wish to return
	 * @return Transaction object containing all pertinent information to do with that transaction.
	 */
	public Transaction transaction(int index) {return this.transactions_M[index];}
	
	/**
	 * use this method to find out how many transactions are associated with this order, 
	 * @return int representing the number of transactions available in this order.
	 */
	public int noOfTransactions() {return this.transactions_M.length;}
	
	/**
	 * retrieve the sales record number associated with this order
	 * @return int representing the salesRecordNumber
	 */
	public int salesRecNo() {return this.salesRecNo_M;}
	
	/**
	 * retrieve the account that this order is associated with
	 * @return String containing the name of the ebay account
	 */
	public String account() {return this.account_M;}
	
	/**
	 * retrieve the shipping type used for this order as a string
	 * @return String representing the shipping type
	 */
	public String shippingType() {return this.shippingType_M;}
	
	/**
	 * retrieve the time at which this order was created
	 * @return String representing the time at which the order was created.
	 */
	public String createdTime() {return this.createdTime_M;}
	
	/**
	 * retrieve the total price associated with this order, i.e. how much the customer paid.
	 * @return double representing the amount the customer paid for this order.
	 */
	public double totalPrice() {return this.orderTotal_M;}
	
	/**
	 * 
	 * @return
	 */
	public double shippingCost()
	{
		double result=0.0;
		for(int i = 0 ; i < this.noOfTransactions() ; ++i)
		{
			if(this.transactions_M[i].shippingCost() > result)
			{result = this.transactions_M[i].shippingCost();}
		}
		return result;
	}
	
	/**
	 * helper method, retrieves the order specific information from the database, in order to 
	 * be able to populate the properties of this object.
	 * @param orderID the orderID associated with this order
	 * @return String[] containing the information specific to this order.
	 */
	private static final String[] getOrderInfo(String orderID)
	{
		return QueryInvoker.execute(
									QueryType.SELECT_EBAY_ORDER_BY_ID, 
									new String[] {orderID}
									).get(0);
	}
	
	/**
	 * helper method, retrieves the transactions associated with this order by querying the
	 * database and using the results to generate Transaction objects.
	 * @param orderID the orderID associated with this order
	 * @return Transaction[] that can be used to populate the final Transaction[] member variable.
	 */
	private static final Transaction[] getTransactionList(String orderID)
	{
		List<String[]> query = QueryInvoker.execute(
									QueryType.SELECT_TRANSACTION_BY_ORDERID, 
									new String[] {orderID}
									);
		Transaction[] result = new Transaction[query.size()];
		
		for(int i=0 ; i < query.size() ; ++i) {result[i]=new Transaction(query.get(i)[0]);}
		
		return result;
	}
}

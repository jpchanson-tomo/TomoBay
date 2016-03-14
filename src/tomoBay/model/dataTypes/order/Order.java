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
import tomoBay.model.dataTypes.heteroTypeContainer.ClassRef;
import tomoBay.model.dataTypes.heteroTypeContainer.HeteroFieldContainer;
import tomoBay.model.eBayAPI.EbayAccounts;
import tomoBay.model.sql.queries.SelectQueryInvoker;
import tomoBay.model.sql.queries.SelectQueryInvoker.SelectQueryTypeParams;
import tomoBay.model.sql.schema.ordersTable.OrdersTable;
import tomoBay.model.sql.schema.transactionsTable.TransactionsTable;
/**
 * This class represents an eBay order, and the relevant information associated with it. Once
 * instantiated this object will contain a Buyer object and an array of Transaction objects, and while
 * this Order object will contain general information relevant to this eBay order, in order to gain 
 * more in depth details of the order i.e. buyer information or detailed information about the items
 * that have been sold, it is necessary to query these contained objects.
 * @author Jan P.C. Hanson
 *
 */
public class Order
{
	static final Logger log = Logger.getLogger(Order.class.getName());
	/**the buyer of this order**/
	private final Buyer buyer_M;
	/**the transactions associated with this order**/
	private final Transaction[] transactions_M;
	/**Container for all the order information retrieved by the query**/
	private final HeteroFieldContainer order_info_M;
	
	/**
	 * initialise this order using the orderID provided
	 * @param orderID
	 */
	public Order(String orderID)
	{
		super();
		try
		{
			this.order_info_M =Order.getOrderInfo(orderID);
			this.transactions_M = Order.getTransactionList(orderID);
			this.buyer_M = new Buyer(this.order_info_M.get(OrdersTable.BUYERID, ClassRef.STRING));
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
	public String orderID() {return this.order_info_M.get(OrdersTable.ORDER_ID, ClassRef.STRING);}
	
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
	public int salesRecNo() 
	{return this.order_info_M.get(OrdersTable.SALES_REC_NO, ClassRef.INTEGER);}
	
	/**
	 * retrieve the account that this order is associated with
	 * @return String containing the name of the ebay account
	 */
	public String account() 
	{return EbayAccounts.name(this.order_info_M.get(OrdersTable.ACCOUNT, ClassRef.INTEGER));}
	
	/**
	 * retrieve the shipping type used for this order as a string
	 * @return String representing the shipping type
	 */
	public String shippingType() 
	{return this.order_info_M.get(OrdersTable.SHIPPING_TYPE, ClassRef.STRING);}
	
	/**
	 * retrieve the time at which this order was created
	 * @return String representing the time at which the order was created.
	 */
	public String createdTime() 
	{return this.order_info_M.get(OrdersTable.CREATED_TIME, ClassRef.TIMESTAMP).toString();}
	
	/**
	 * retrieve the invoice number from this order(if it has one)
	 * @return 0 if the order is uninvoiced, otherwise an actual invoice number. in some cases this 
	 * method will return 1, this indicates that the order has been manually invoiced or that it was
	 * automatically invoiced before this capability was put in place.
	 */
	public int invoiceNo()
	{return this.order_info_M.get(OrdersTable.INVOICED, ClassRef.INTEGER);}
	
	/**
	 * retrieve the total price associated with this order, i.e. how much the customer paid.
	 * @return double representing the amount the customer paid for this order.
	 */
	public float totalPrice() 
	{return this.order_info_M.get(OrdersTable.ORDER_TOTAL, ClassRef.FLOAT);}
	
	/**
	 * 
	 * @return
	 */
	public double shippingCost()
	{
		double result=0.0;
		for(final Transaction tran : this.transactions_M)
		{
			if(tran.shippingCost() > result)
			{result = tran.shippingCost();}
		}
		return result;
	}
	
	/**
	 * helper method, retrieves the order specific information from the database, in order to 
	 * be able to populate the properties of this object.
	 * @param orderID the orderID associated with this order
	 * @return String[] containing the information specific to this order.
	 */
	private static final HeteroFieldContainer getOrderInfo(String orderID)
	{
		HeteroFieldContainer params = new HeteroFieldContainer();
		params.add(OrdersTable.ORDER_ID, orderID);
		return SelectQueryInvoker.execute(
									SelectQueryTypeParams.SELECT_EBAY_ORDER_BY_ID, 
									params
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
		HeteroFieldContainer params = new HeteroFieldContainer();
		params.add(OrdersTable.ORDER_ID, orderID);
		List<HeteroFieldContainer> query = SelectQueryInvoker.execute(
									SelectQueryTypeParams.SELECT_TRANSACTION_BY_ORDERID, 
									params
									);
		Transaction[] result = new Transaction[query.size()];
		
		for(int i=0 ; i < query.size() ; ++i) 
		{result[i]=new Transaction(query.get(i).get(TransactionsTable.TRANSACTION_ID, ClassRef.LONG));}
		
		return result;
	}
}

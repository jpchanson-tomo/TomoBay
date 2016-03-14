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

import tomoBay.model.dataTypes.heteroTypeContainer.ClassRef;
import tomoBay.model.dataTypes.heteroTypeContainer.HeteroFieldContainer;
import tomoBay.model.sql.queries.SelectQueryInvoker;
import tomoBay.model.sql.queries.SelectQueryInvoker.SelectQueryTypeParams;
import tomoBay.model.sql.schema.transactionsTable.TransactionsTable;

/**
 * This class represents an eBay transaction, each transaction contains 1 Listing. This transaction 
 * contains more general information about the transaction such as price and shipping cost etc 
 * whereas the Listing object contains information more relevant to the actual product being sold.
 * 
 * @author Jan P.C. Hanson
 *
 */
public class Transaction
{
	/**the listing associated with this transaction**/
	private final Listing listing_M;
	/**Container for all the order information retrieved by the query**/
	private final HeteroFieldContainer transaction_info_M;
	
	/**
	 * CONSTRUCTOR, initialise object using the transactionID provided to query the database for
	 * the rest of the information.
	 * @param transactionID
	 */
	public Transaction(Long transactionID)
	{
		super();
		this.transaction_info_M = Transaction.getTransactionInfo(transactionID);
		this.listing_M = new Listing(this.transaction_info_M.get(TransactionsTable.ITEM_ID, ClassRef.LONG));
	}
	
	/**
	 * retrieve the listing associated with this transaction
	 * @return Listing
	 */
	public Listing listing() {return this.listing_M;}
	
	/**
	 * retrieve the quantity of this listing purchased
	 * @return int representing how many of this listing are billed to this transaction
	 */
	public int qtyPurchased() 
	{return this.transaction_info_M.get(TransactionsTable.QUANTITY, ClassRef.INTEGER);}
	
	/**
	 * retrieve the price associated with this transaction
	 * @return double representing the transaction price
	 */
	public double transactionPrice() 
	{return this.transaction_info_M.get(TransactionsTable.PRICE, ClassRef.FLOAT)*this.qtyPurchased();}
	
	/**
	 * retrieve the shipping cost associated with this transaction
	 * @return double representing the shipping cost
	 */
	public float shippingCost() 
	{return this.transaction_info_M.get(TransactionsTable.SHIPPING_COST, ClassRef.FLOAT);}
	
	/**
	 * retrieve the transaction information for this order from the database based on the order
	 * ID passed in as a parameter.
	 * @param orderID String containing the orderID for the order that should have info on it 
	 * found
	 * @return
	 */
	private static final HeteroFieldContainer getTransactionInfo(Long transactionID)
	{
		HeteroFieldContainer params = new HeteroFieldContainer();
		params.add(TransactionsTable.TRANSACTION_ID, transactionID);
		return SelectQueryInvoker.execute(
									SelectQueryTypeParams.SELECT_EBAY_TRANSACTION_BY_ID, 
									params
									).get(0);
	}
}
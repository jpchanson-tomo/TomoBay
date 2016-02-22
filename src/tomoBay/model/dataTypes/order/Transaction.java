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

import tomoBay.model.sql.queries.QueryInvoker;
import tomoBay.model.sql.queries.QueryInvoker.QueryType;

/**
 *
 * @author Jan P.C. Hanson
 *
 */
public class Transaction
{
	/**the listing associated with this transaction**/
	private final Listing listing_M;
	/**the quantity of the listing purchased**/
	private final int qty_M;
	/**the price associated with this transaction**/
	private final double price_M;
	/**the shipping cost associated with this transaction**/
	private final double shippingCost_M;
	
	/**
	 * CONSTRUCTOR, initialise object using the transactionID provided to query the database for
	 * the rest of the information.
	 * @param transactionID
	 */
	public Transaction(String transactionID)
	{
		super();
		String[] transactionInfo = Transaction.getTransactionInfo(transactionID);
		this.qty_M = Integer.parseInt(transactionInfo[1]);
		this.price_M = Double.parseDouble(transactionInfo[2]);
		this.shippingCost_M = Double.parseDouble(transactionInfo[3]);
		this.listing_M = new Listing(Long.parseLong(transactionInfo[0]));
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
	public int qtyPurchased() {return this.qty_M;}
	
	/**
	 * retrieve the price associated with this transaction
	 * @return double representing the transaction price
	 */
	public double transactionPrice() {return this.price_M*this.qty_M;}
	
	/**
	 * retrieve the shipping cost associated with this transaction
	 * @return double representing the shipping cost
	 */
	public double shippingCost() {return this.shippingCost_M;}
	
	/**
	 * retrieve the transaction information for this order from the database based on the order
	 * ID passed in as a parameter.
	 * @param orderID String containing the orderID for the order that should have info on it 
	 * found
	 * @return
	 */
	private static final String[] getTransactionInfo(String transactionID)
	{
		return QueryInvoker.execute(
									QueryType.SELECT_EBAY_TRANSACTION_BY_ID, 
									new String[] {transactionID}
									).get(0);
	}
}
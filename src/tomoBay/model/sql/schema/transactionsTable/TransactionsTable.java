package tomoBay.model.sql.schema.transactionsTable;
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
import tomoBay.model.dataTypes.dbSchema.AbstractField;
import tomoBay.model.dataTypes.dbSchema.AbstractTypeSchema;

import tomoBay.model.sql.schema.itemsTable.ItemsTable;
import tomoBay.model.sql.schema.ordersTable.OrdersTable;
/**
 * This represents the ebay_transactions table in the database, An order usually consists of one
 * transaction but there are occaisions where a customer will order  multiple listings in one order
 * when this is the case there will be multiple transactions associated with a particular order. It
 * is worth noting that in this scenario there will also be multiple sales record numbers for the 
 * order (hence why the sales record numbers may have breaks between orders). It is also worth
 * noting that in the case where there are multiple transactions on an order; there orderID will be
 * a single (large number) rather than a combination of the transactionID and the itemID with a 
 * hyphen between them. 
 * 
 * @author Jan P.C. Hanson
 *
 */
public final class TransactionsTable implements AbstractTypeSchema
{
	/**The transactionID column of the ebay_transactions table 
	 * - BIGINT(20)
	 * - Primary Key
	 * 
	 * @see tomoBay.model.sql.schema.transactionsTable.TransactionID
	 **/
	public static final TransactionID TRANSACTION_ID = new TransactionID();
	
	/**
	 * The orderID column of the ebay_transactions table
	 * - VARCHAR(30)
	 * - Foreign Key ebay_orders table
	 * 
	 * @see tomoBay.model.sql.schema.ordersTable.OrderID
	 * @see tomoBay.model.sql.schema.ordersTable.OrdersTable
	 **/
	public static final AbstractField ORDER_ID = OrdersTable.ORDER_ID;
	
	/**
	 * The itemID column of the ebay_transactions table
	 * - BIGINT(20)
	 * - Foreign Key ebay_items table
	 *
	 * @see tomoBay.model.sql.schema.itemsTable.ItemID
	 * @see tomoBay.model.sql.schema.itemsTable.ItemsTable
	 **/
	public static final AbstractField ITEM_ID = ItemsTable.ITEM_ID;
	
	/**
	 * the quantity column of the ebay_transactions table
	 * - INT(7)
	 * 
	 * @see tomoBay.model.sql.schema.transactionsTable.Quantity
	 **/
	public static final Quantity QUANTITY = new Quantity();
	
	/**
	 * The price column of the ebay_transactions table
	 * - FLOAT()
	 * 
	 * @see tomoBay.model.sql.schema.transactionsTable.Price
	 **/
	public static final Price PRICE = new Price();
	
	/**
	 * The shippingCost column of the ebay_transactions table
	 * - FLOAT()
	 * 
	 * @see tomoBay.model.sql.schema.transactionsTable.ShippingCost
	 **/
	public static final ShippingCost SHIPPING_COST = new ShippingCost();
	
	/**
	 * private ctor ensures this class is never instantiated
	 */
	private TransactionsTable()
	{super();}

}

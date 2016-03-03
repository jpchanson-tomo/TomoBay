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
import tomoBay.model.dataTypes.dbSchema.AbstractDBField;
import tomoBay.model.dataTypes.dbSchema.AbstractDBSchema;

import tomoBay.model.sql.schema.itemsTable.ItemsTable;
import tomoBay.model.sql.schema.ordersTable.OrdersTable;
/**
 * This represents the ebay_transactions table in the database
 * @author Jan P.C. Hanson
 *
 */
public final class TransactionsTable implements AbstractDBSchema
{
	/**The transactionID column of the ebay_transactions table BIGINT(20) [PK] 
	 * @see {@link tomoBay.model.sql.schema.transactionsTable.TransactionID}
	 **/
	public static final TransactionID TRANSACTION_ID = new TransactionID();
	
	/**
	 * The orderID column of the ebay_transactions table VARCHAR(30) [FK - ebay_orders]
	 * @see {@link tomoBay.model.sql.schema.ordersTable.OrderID}
	 **/
	public static final AbstractDBField ORDER_ID = OrdersTable.ORDER_ID;
	
	/**
	 * The itemID column of the ebay_transactions table BIGINT(20) [FK - ebay_items]
	 * @see {@link tomoBay.model.sql.schema.itemssTable.ItemID}
	 **/
	public static final AbstractDBField ITEM_ID = ItemsTable.ITEM_ID;
	
	/**
	 * the quantity column of the ebay_transactions table INT(7)
	 * @see {@link tomoBay.model.sql.schema.transactionsTable.Quantity}
	 **/
	public static final Quantity QUANTITY = new Quantity();
	
	/**
	 * The price column of the ebay_transactions table FLOAT()
	 * @see {@link tomoBay.model.sql.schema.transactionsTable.Price}
	 **/
	public static final Price PRICE = new Price();
	
	/**
	 * The shippingCost column of the ebay_transactions table FLOAT()
	 * @see {@link tomoBay.model.sql.schema.transactionsTable.ShippingCost}
	 **/
	public static final ShippingCost SHIPPING_COST = new ShippingCost();
	
	/**
	 * private ctor ensures this class is never instantiated
	 */
	private TransactionsTable()
	{super();}

}

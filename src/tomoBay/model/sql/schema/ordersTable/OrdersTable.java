package tomoBay.model.sql.schema.ordersTable;
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
import tomoBay.model.dataTypes.heteroTypeContainer.AbstractField;
import tomoBay.model.dataTypes.heteroTypeContainer.AbstractTypeSchema;
import tomoBay.model.sql.schema.accountsTable.AccountsTable;
import tomoBay.model.sql.schema.buyerTable.BuyerTable;
/**
 * This class represents the ebay_orders table in the database
 * @author Jan P.C. Hanson
 *
 */
public final class OrdersTable implements AbstractTypeSchema
{
	/**
	 * this is the orderID field of the ebay_orders table in the database, and is the primary key for
	 * this table.
	 * - VARCHAR(30)
	 * - Primary Key
	 * 
	 * @see tomoBay.model.sql.schema.ordersTable.OrderID
	 **/
	public static final OrderID ORDER_ID = new OrderID();
	/**
	 * this is the buyerId field of the ebay_orders table, it is a foreign key for the ebay_buyers table
	 * - VARCHAR(40)
	 * - Foreign Key ebay_buyers
	 * 
	 * @see tomoBay.model.sql.schema.ordersTable.OrderID
	 * @see tomoBay.model.sql.schema.buyerTable.BuyerTable
	 */
	public static final AbstractField BUYERID = BuyerTable.BUYERID;
	/**
	 * this is the salesRecNo field of the ebay_orders table in the database, it is a number generated
	 * by ebay chronologically i.e. the first sale would be 1 the second 2 and so on.
	 * - INT(10)
	 * 
	 * @see tomoBay.model.sql.schema.buyerTable.SalesRecNo
	 */
	public static final SalesRecNo SALES_REC_NO = new SalesRecNo();
	/**
	 * this is the shippingType field of the ebay_orders table of the database and is a textual 
	 * representation of the shipping service used to dispatch this order.
	 * - VARCHAR(200)
	 * 
	 * @see tomoBay.model.sql.schema.ordersTable.ShippingType
	 */
	public static final ShippingType SHIPPING_TYPE = new ShippingType();
	/**
	 * this is the createdTime field of the ebay_orders table in the database. The value of this field
	 * is grabbed using the ebayAPI and is the time and date at which this order was created.
	 * - TIMESTAMP()
	 * 
	 * @see tomoBay.model.sql.schema.ordersTable.CreatedTime
	 */
	public static final CreatedTime CREATED_TIME = new CreatedTime();
	/**
	 * this is the invoiced field of the ebay_orders table in the database. it is a numerical value 
	 * that defines whether this order has been invoiced or not. If the order has not been invoiced
	 * then it will have a value of 0, if it has been invoiced then the value contained will be the 
	 * invoice number.
	 * - INT(11)
	 * 
	 * @see tomoBay.model.sql.schema.ordersTable.Invoiced
	 */
	public static final Invoiced INVOICED = new Invoiced();
	/**
	 * this is the orderTotal field of the ebay_orders table in the database, it represents the total
	 * price for the order.
	 * - FLOAT()
	 * 
	 * @see tomoBay.model.sql.schema.ordersTable.OrderTotal
	 */
	public static final OrderTotal ORDER_TOTAL = new OrderTotal();
	/**
	 * this is the account field of the ebay_orders table in the database. it is a foreign key to the 
	 * ebay_accounts table and represents the account that this order is associated with.
	 * - INT(3)
	 * - Foreign Key ebay_accounts
	 * 
	 * @see tomoBay.model.sql.schema.accountsTable.AccountsTable
	 * @see tomoBay.model.sql.schema.accountsTable.Id
	 */
	public static final AbstractField ACCOUNT = AccountsTable.ID;

	/**
	 * private ctor ensures this class is NEVER INSTANTIATED
	 */
	private OrdersTable()
	{super();}

}

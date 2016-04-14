package tomoBay.model.sql.schema.orderStatusTable;
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
import tomoBay.model.sql.schema.ordersTable.OrdersTable;
import tomoBay.model.dataTypes.heteroTypeContainer.AbstractField;
import tomoBay.model.dataTypes.heteroTypeContainer.AbstractTypeSchema;
/**
 * This class represents the order_status table in the database
 * @author Jan P.C. Hanson
 *
 */
public final class OrderStatusTable implements AbstractTypeSchema
{

	/**
	 * this is the orderID field of the order_status table in the database, it is the primary key for
	 * this table.
	 * - VARCHAR(20)
	 * - primary key
	 * 
	 * @see tomoBay.model.sql.schema.ordersTable.OrderID
	 */
	public static final AbstractField ORDER_ID = OrdersTable.ORDER_ID;
	
	/**
	 * this is the picking field of the order_status table in the database. It takes a binary value, 
	 * 0 means that this order has not yet been picked, 1 indicates that it has been picked.
	 * - TINYINT(1)
	 * 
	 * @see tomoBay.model.sql.schema.orderStatusTable.Picking
	 */
	public static final Picking PICKING = new Picking();
	
	/**
	 * This is the packing field of the order_status table in the database, It takes a binary value,
	 * 0 indicates that this order has not yet been packed, 1 indicates that it has been packed.
	 * - TINYINT(1)
	 * 
	 * @see tomoBay.model.sql.schema.orderStatusTable.Packing
	 */
	public static final Packing PACKING = new Packing();
	
	/**
	 * This is the shipping field of the order_status table in the database, Ot takes a binary value,
	 * 0 indicates that this order has not yet been packed, 1 indicates that it has been packed.
	 * - TINYINT(1)
	 * 
	 * @see tomoBay.model.sql.schema.orderStatusTable.Shipping
	 */
	public static final Shipping SHIPPING = new Shipping();
	
	/**
	 * This is the invoiceNo field of the order_status table in the database, it takes an integer value
	 * a 0 indicates that there is currently no invoice number associated with this order, other numbers
	 * represent the invoice number associated with this order.
	 * - INT(11)
	 * - Foreign Key ebay_orders
	 * 
	 * @see tomoBay.model.sql.schema.orderStatusTab
	 */
	public static final AbstractField INVOICE_NO = OrdersTable.INVOICED;
	
	/**
	 * private CTOR ensures that this type is never instantiated
	 */
	private OrderStatusTable()
	{super();}

}

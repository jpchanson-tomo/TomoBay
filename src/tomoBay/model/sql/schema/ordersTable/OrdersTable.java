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
import tomoBay.model.dataTypes.dbSchema.AbstractDBField;
import tomoBay.model.dataTypes.dbSchema.AbstractDBSchema;

import tomoBay.model.sql.schema.accountsTable.AccountsTable;
import tomoBay.model.sql.schema.buyerTable.BuyerTable;
import tomoBay.model.sql.schema.itemsTable.ItemsTable;
/**
 * This class represents the ebay_orders table in the database
 * @author Jan P.C. Hanson
 *
 */
public final class OrdersTable implements AbstractDBSchema
{
	/**the **/
	public static final OrderID ORDER_ID = new OrderID();
	/****/
	public static final AbstractDBField BUYERID = BuyerTable.BUYERID;
	/****/
	public static final SalesRecNo SALES_REC_NO = new SalesRecNo();
	/****/
	public static final AbstractDBField ITEM_ID = ItemsTable.ITEM_ID;
	/****/
	public static final ShippingType SHIPPING_TYPE = new ShippingType();
	/****/
	public static final CreatedTime CREATED_TIME = new CreatedTime();
	/****/
	public static final Invoiced INVOICED = new Invoiced();
	/****/
	public static final OrderTotal ORDER_TOTAL = new OrderTotal();
	/****/
	public static final AbstractDBField ACCOUNT = AccountsTable.ID;

	/**
	 * private ctor ensures this class is never instantiated
	 */
	private OrdersTable()
	{super();}

}

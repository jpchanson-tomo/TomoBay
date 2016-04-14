package tomoBay.model.sql.queries.concreteQueries.insert;
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
import java.sql.SQLException;

import tomoBay.model.dataTypes.heteroTypeContainer.HeteroFieldContainer;
import tomoBay.model.sql.framework.QueryUtility;
import tomoBay.model.sql.framework.queryTypes.modify.AbstractModifyQueryParams;
import tomoBay.model.sql.schema.ordersTable.OrdersTable;

/**
 * This class represents a class that inserts order data into the orders table of the database.
 * 
 * this query takes the following paramters:
 * - OrdersTable.ORDER_ID
 * - OrdersTable.BUYERID
 * - OrdersTable.SALES_REC_NO
 * - OrdersTable.SHIPPING_TYPE
 * - OrdersTable.CREATED_TIME
 * - OrdersTable.ORDER_TOTAL
 * - OrdersTable.ACCOUNT
 * 
 * Which must be passed to the execute(HeteroFieldContainer parameters) method when running the query
 * 
 * @author Jan P.C. Hanson
 *
 */
public  final class InsertEbayOrders extends AbstractModifyQueryParams
{
	/**SQL query string**/
	private static final String query ="INSERT IGNORE INTO ebay_orders (orderID, buyerID, salesRecNo, shippingType, createdTime, orderTotal, account)"
			+ "VALUES (?,?,?,?,?,?,?);";
	
	/**
	 * default constructor
	 */
	public InsertEbayOrders()
	{super();}

	/* (non-Javadoc)
	 * @see tomoBay.model.sql.framework.queryTypes.modify.AbstractModifyQueryParams#queryString()
	 */
	@Override
	protected String queryString()
	{return InsertEbayOrders.query;}

	/* (non-Javadoc)
	 * @see tomoBay.model.sql.framework.queryTypes.modify.AbstractModifyQueryParams#setParameters()
	 */
	@Override
	protected void setParameters(HeteroFieldContainer parameter) throws ClassCastException, SQLException
	{
		QueryUtility.setVARCHARParam(this, parameter, OrdersTable.ORDER_ID, 1);
		QueryUtility.setVARCHARParam(this, parameter, OrdersTable.BUYERID, 2);
		QueryUtility.setINTEGERParam(this, parameter, OrdersTable.SALES_REC_NO, 3);
		QueryUtility.setVARCHARParam(this, parameter, OrdersTable.SHIPPING_TYPE, 4);
		QueryUtility.setTIMESTAMPParam(this, parameter, OrdersTable.CREATED_TIME, 5);
		QueryUtility.setFLOATParam(this, parameter, OrdersTable.ORDER_TOTAL, 6);
		QueryUtility.setINTEGERParam(this, parameter, OrdersTable.ACCOUNT, 7);
	}
}
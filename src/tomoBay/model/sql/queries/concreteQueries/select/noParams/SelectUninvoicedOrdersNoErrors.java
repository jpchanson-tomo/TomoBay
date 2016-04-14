package tomoBay.model.sql.queries.concreteQueries.select.noParams;
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

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tomoBay.model.dataTypes.heteroTypeContainer.HeteroFieldContainer;
import tomoBay.model.sql.framework.queryTypes.select.AbstractSelectNoParamsQuery;
import tomoBay.model.sql.schema.ordersTable.OrdersTable;
/**
 *
 * @author Jan P.C. Hanson
 *
 */
public  final class SelectUninvoicedOrdersNoErrors extends AbstractSelectNoParamsQuery
{
	/**SQL query string**/
	private static final String query = "SELECT * FROM ebay_orders "
										+ "WHERE ebay_orders.orderID NOT IN "
										+ "( 	SELECT ebay_orders.orderID FROM ebay_orders "
										+ "		INNER JOIN ebay_transactions ON ebay_orders.orderID=ebay_transactions.orderID "
										+ "		INNER JOIN ebay_items ON ebay_transactions.itemID=ebay_items.itemID "
										+ "		WHERE invoiced <> 0 OR "
										+ "		(ebay_items.notes IS NOT NULL AND ebay_items.notes NOT LIKE '') "
										+ ")"
										+ "ORDER BY createdTime ASC;";
	
	/**
	 * default constructor
	 */
	public SelectUninvoicedOrdersNoErrors()
	{super();}
	
	/**
	 * formats the ResultSet (returned from the executed query) as a string
	 * @param results the ResultSet (post query execution)
	 * @return String containing the formatted results.
	 * @throws SQLException
	 */
	@Override
	protected List<HeteroFieldContainer> format(ResultSet results) throws SQLException
	{
		List<HeteroFieldContainer> rows = new ArrayList<HeteroFieldContainer>();
		while (results.next())
		{
			HeteroFieldContainer cols = new HeteroFieldContainer();
			cols.add(OrdersTable.ORDER_ID,results.getString("orderID"));
			cols.add(OrdersTable.BUYERID,results.getString("buyerID"));
			cols.add(OrdersTable.SALES_REC_NO,results.getInt("salesRecNo"));
			cols.add(OrdersTable.SHIPPING_TYPE,results.getString("shippingType"));
			cols.add(OrdersTable.CREATED_TIME,results.getTimestamp("createdTime"));
			cols.add(OrdersTable.INVOICED,results.getInt("invoiced"));
			cols.add(OrdersTable.ORDER_TOTAL,results.getFloat("orderTotal"));
			cols.add(OrdersTable.ACCOUNT,results.getInt("account"));
			rows.add(cols);
		}
		return rows;
	}

	/* (non-Javadoc)
	 * @see tomoBay.model.sql.framework.queryTypes.AbstractDBQuery#queryString()
	 */
	@Override
	protected String queryString()
	{return SelectUninvoicedOrdersNoErrors.query;}
}
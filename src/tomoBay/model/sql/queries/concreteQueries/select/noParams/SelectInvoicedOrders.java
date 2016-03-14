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
import tomoBay.model.sql.queries.AbstractSelectNoParamsQuery;
import tomoBay.model.sql.schema.ordersTable.OrdersTable;
/**
 * This class represents a query that selects all data from the orders table that is not
 * currently invoiced as determined by the value of the 'invoiced' field where a value of 0 
 * indicates that the order is not invoicable, a value of 1 indicates that the order is partially
 * invoicable and a value of 2 indicates that the order has been invoiced.
 * @author Jan P.C. Hanson
 *
 */
public  final class SelectInvoicedOrders extends AbstractSelectNoParamsQuery
{
	/**SQL query string**/
	private static final String query = "SELECT * FROM ebay_orders WHERE invoiced <> 0 ORDER BY createdTime DESC;";
	
	/**
	 * default constructor
	 */
	public SelectInvoicedOrders()
	{super();}
	
	/**
	 * execute the query
	 * @param parameter NOT USED for this query.
	 * @return List<String[]> representing the results of the query. Each element in the list
	 * represents a row of the database and each element of the String[] represents a field.
	 * 
	 * The available fields for each element of the string[] are:
	 * - String[0] = orderID
	 * - String[1] = buyerID
	 * - String[2] = salesRecNo
	 * - String[3] = shippingType
	 * - String[4] = createdTime
	 * - String[5] = picked
	 * - String[6] = packed
	 * - String[7] = shipped
	 * - String[8] = invoiced
	 * 
	 * @throws SQLException
	 */
	public List<HeteroFieldContainer> execute() throws SQLException
	{
		List<HeteroFieldContainer> result = this.format(super.initQuery(query));
		super.cleanup();
		
		return result;
	}
	
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
}

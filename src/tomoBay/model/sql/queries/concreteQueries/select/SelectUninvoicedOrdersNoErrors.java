package tomoBay.model.sql.queries.concreteQueries.select;
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

import tomoBay.model.sql.queries.AbstractSelectQueryNoParams;
/**
 *
 * @author Jan P.C. Hanson
 *
 */
public  final class SelectUninvoicedOrdersNoErrors extends AbstractSelectQueryNoParams
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
	public List<String[]> execute(String[] parameter) throws SQLException
	{
		List<String[]> result = this.format(this.initQuery(query));
		this.cleanup();
		
		return result;
	}
	
	/**
	 * formats the ResultSet (returned from the executed query) as a string
	 * @param results the ResultSet (post query execution)
	 * @return String containing the formatted results.
	 * @throws SQLException
	 */
	@Override
	protected List<String[]> format(ResultSet results) throws SQLException
	{
		List<String[]> rows = new ArrayList<String[]>();
		while (results.next())
		{
			String[] cols = new String[6];
			cols[0] = results.getString("orderID");
			cols[1] = results.getString("buyerID");
			cols[2] = results.getString("salesRecNo");
			cols[3] = results.getString("shippingType");
			cols[4] = results.getString("createdTime");
			cols[5] = results.getString("invoiced");
			rows.add(cols);
		}
		return rows;
	}
}
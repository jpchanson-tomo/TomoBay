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
 *
 * @author Jan P.C. Hanson
 *
 */
public  final class SelectUncalculatedOrders extends AbstractSelectNoParamsQuery
{
	/**SQL query string**/
	private String query ="SELECT orderID FROM ebay_orders WHERE invoiceID = 0;";
	//
	/**
	 * default constructor
	 */
	public SelectUncalculatedOrders()
	{super();}
	
	/**
	 * execute the query
	 * @param NotUsed NOT USED
	 * @return List<String[]> representing the results of the query. Each element in the list
	 * represents a row of the database and each element of the String[] represents a field.
	 * 
	 * The available fields for each element of the string[] are:
	 * cols[0] = results.getString("orderID");
	 * @throws SQLException
	 */
	public List<HeteroFieldContainer> execute() throws SQLException
	{
		List<HeteroFieldContainer> selectResults = this.format(super.initQuery(query));
		super.cleanup();
		
		return selectResults;
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
			cols.add(OrdersTable.ORDER_ID ,results.getString("orderID"));
			rows.add(cols);
		}
		return rows;
	}
}
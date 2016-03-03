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

import tomoBay.model.sql.queries.AbstractSelectQueryWithParams;
/**
 *
 * @author Jan P.C. Hanson
 *
 */
public final class SelectBrandByInv extends AbstractSelectQueryWithParams
{
	/**SQL query string**/
	private String query ="SELECT brand FROM ebay_items "
						+ "INNER JOIN ebay_transactions ON ebay_items.itemID=ebay_transactions.itemID "
						+ "INNER JOIN ebay_orders ON ebay_orders.orderID=ebay_transactions.orderID "
						+ "WHERE invoiced=?;";
	//
	/**
	 * default constructor
	 */
	public SelectBrandByInv()
	{super();}
	
	/**
	 * execute the query
	 * @param parameter invoice number  
	 * @return List<String[]> representing the results of the query. Each element in the list
	 * represents a row of the database and each element of the String[] represents a field.
	 * 
	 * The available fields for each element of the string[] are:
	 * - String[0] = brand
	 * 
	 * @throws SQLException
	 */
	public List<String[]> execute(String[] parameter) throws SQLException
	{
		super.initQuery(query);
		
		this.statement_M.setString(1, parameter[0]);
		
		ResultSet rs = this.statement_M.executeQuery();
		List<String[]> selectResults = this.format(rs);

		this.cleanup();
		
		return selectResults;
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
			String[] cols = new String[1];
			cols[0] = results.getString("brand");
			rows.add(cols);
		}
		return rows;
	}
}
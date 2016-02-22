package tomoBay.model.sql.queries.concreteQueries;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tomoBay.model.sql.ConnectionManager;
import tomoBay.model.sql.queries.AbstractDBQuery;
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

/**
 *
 * @author Jan P.C. Hanson
 *
 */
public  final class SelectOutOfHoursOrders implements AbstractDBQuery
{
	/**reference to the JDBC Statement**/
	private PreparedStatement selectStatement_M = null;
	/**reference to the JDBC Database connection**/
	private Connection connection_M = null;
	/**SQL query string**/
	private String query ="SELECT out_of_hours.date as OutOfHours, ebay_orders.salesRecNo, ebay_orders.createdTime, ebay_orders.orderTotal "
						+ "FROM out_of_hours "
						+ "INNER JOIN ebay_orders ON out_of_hours.salesRecNo=ebay_orders.salesRecNo "
						+ "WHERE date>=? AND date<=?; ";
	//
	/**
	 * default constructor
	 */
	public SelectOutOfHoursOrders()
	{super();}
	
	/**
	 * execute the query
	 * @param startAndEnd define the date range to look for orders in:
	 * 
	 * The available fields are:
	 * cols[0] = start date (inclusive) 'yyyy-mm-dd'
	 * cols[1] = end date (inclusive) 'yyyy-mm-dd'
	 * 
	 * @return List<String[]> representing the results of the query. Each element in the list
	 * represents a row of the database and each element of the String[] represents a field.
	 * 
	 * The available fields for each element of the string[] are:
	 * cols[0] = Date of out of hours 
	 * cols[1] = sales record number (integer)
	 * cols[2] = createdTime (timestamp/string)
	 * cols[3] = orderTotalPrice double/float;
	 * @throws SQLException
	 */
	public List<String[]> execute(String[] startAndEnd) throws SQLException
	{
		this.initQuery();
		this.selectStatement_M.setDate(1, Date.valueOf(startAndEnd[0]));
		this.selectStatement_M.setDate(2, Date.valueOf(startAndEnd[1]));
		ResultSet rs = this.selectStatement_M.executeQuery();
		
		List<String[]> selectResults = this.formatResults(rs);

		this.connection_M.commit();
		this.cleanup();
		
		
		return selectResults;
	}
	
	/**
	 * formats the ResultSet (returned from the executed query) as a string
	 * @param results the ResultSet (post query execution)
	 * @return String containing the formatted results.
	 * @throws SQLException
	 */
	private List<String[]> formatResults(ResultSet results) throws SQLException
	{
		List<String[]> rows = new ArrayList<String[]>();
		while (results.next())
		{
			String[] cols = new String[4];
			cols[0] = results.getString("OutOfHours");
			cols[1] = results.getString("salesRecNo");
			cols[2] = results.getString("createdTime");
			cols[3] = results.getString("orderTotal");
			rows.add(cols);
		}
		return rows;
	}
	
	/**
	 * initialise the connection and statement and set transaction variables.
	 * @throws SQLException
	 */
	private void initQuery() throws SQLException
	{
		this.connection_M = ConnectionManager.instance().getConnection();
		this.connection_M.setAutoCommit(false);
		this.selectStatement_M = this.connection_M.prepareStatement(query);
	}
	
	/**
	 * do cleanup after the query has been executed
	 * @throws SQLException
	 */
	private void cleanup() throws SQLException
	{
		if (this.selectStatement_M != null) {this.selectStatement_M.close();}
		if (connection_M != null) {connection_M.close();}
	}
}
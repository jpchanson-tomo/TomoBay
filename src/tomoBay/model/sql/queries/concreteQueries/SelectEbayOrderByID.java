package tomoBay.model.sql.queries.concreteQueries;

import java.sql.Connection;
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
public  final class SelectEbayOrderByID implements AbstractDBQuery
{
	/**reference to the JDBC Statement**/
	private PreparedStatement selectStatement_M = null;
	/**reference to the JDBC Database connection**/
	private Connection connection_M = null;
	/**SQL query string**/
	private String query ="SELECT salesRecNo,shippingType,createdTime,orderTotal,buyerID,invoiced "
			+ "FROM ebay_orders WHERE orderID=?";
	//
	/**
	 * default constructor
	 */
	public SelectEbayOrderByID()
	{super();}
	
	/**
	 * execute the query
	 * @param parameter single element array containing the orderID
	 * @return List<String[]> representing the results of the query. Each element in the list
	 * represents a row of the database and each element of the String[] represents a field.
	 * 
	 * The available fields for each element of the string[] are:
	 * - String[0] = salesRecNo
	 * - String[1] = shippingType
	 * - String[2] = createdTime
	 * - String[3] = orderTotal
	 * - String[4] = buyerID
	 * 
	 * @throws SQLException
	 */
	public List<String[]> execute(String[] parameter) throws SQLException
	{
		this.initQuery();
		this.selectStatement_M.setString(1, parameter[0]);
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
			String[] cols = new String[6];
			cols[0] = results.getString("salesRecNo");
			cols[1] = results.getString("shippingType");
			cols[2] = results.getString("createdTime");
			cols[3] = results.getString("orderTotal");
			cols[4] = results.getString("buyerID");
			cols[5] = results.getString("invoiced");
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
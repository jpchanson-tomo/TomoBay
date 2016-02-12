package tomoBay.model.sql.queries.concreteQueries;
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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tomoBay.model.sql.ConnectionManager;
import tomoBay.model.sql.queries.AbstractDBQuery;

/**
 * This class represents a query that selects all data from the transactions table of the 
 * database given a particular orderID.
 * @author Jan P.C. Hanson
 *
 */
public class SelectTransactionByOrder implements AbstractDBQuery
{
	/**reference to the JDBC Statement**/
	private PreparedStatement statement_M = null;
	/**reference to the JDBC Database connection**/
	private Connection connection_M = null;
	/**SQL query string**/
//	private static final String query = "SELECT * FROM ebay_transactions WHERE orderID=?;";
	private static final String query = "SELECT transactionID FROM ebay_transactions WHERE orderID=?;";
	
	/**
	 * default constructor
	 */
	public SelectTransactionByOrder()
	{super();}
	
	/**
	 * execute the query
	 * @param parameter single element String array with that element being the order number to
	 * look up.
	 * @return List<String[]> representing the results of the query. Each element in the list
	 * represents a row of the database and each element of the String[] represents a field.
	 * 
	 * The available fields for each element of the string[] are:
	 * - String[0] = transactionID
	 * - String[1] = orderID
	 * - String[2] = itemID
	 * - String[3] = quantity
	 * - String[4] = price
	 * - String[5] = picked
	 * - String[6] = packed
	 * - String[7] = shipped
	 * 
	 * @throws SQLException
	 */
	public List<String[]> execute(String[] parameter) throws SQLException
	{
		this.initQuery();
		this.statement_M.setString(1, parameter[0]);
		ResultSet resultset = statement_M.executeQuery();
		
		List<String[]> result = this.formatResults(resultset);
		
		this.connection_M.commit();
		
		this.cleanup();
		
		return result;
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
			String[] cols = new String[1];
			cols[0] = results.getString("transactionID");
//			cols[1] = results.getString("orderID");
//			cols[2] = results.getString("itemID");
//			cols[3] = results.getString("quantity");
//			cols[4] = results.getString("price");
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
		this.statement_M = this.connection_M.prepareStatement(query);
	}
	
	/**
	 * do cleanup after the query has been executed
	 * @throws SQLException
	 */
	private void cleanup() throws SQLException
	{
		if (statement_M != null) {statement_M.close();}
		if (connection_M != null) {connection_M.close();}
	}
}
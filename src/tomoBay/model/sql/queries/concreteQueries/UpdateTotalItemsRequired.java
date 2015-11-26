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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tomoBay.model.sql.ConnectionManager;
import tomoBay.model.sql.queries.AbstractDBQuery;
/**
 * this class represents a query that updates the total number of items needed in the items table
 * with data taken from the transactions transactions table. given a specific item id.
 * @author Jan P.C. Hanson
 *
 */
public class UpdateTotalItemsRequired implements AbstractDBQuery
{
	/**reference to the JDBC Statement**/
	private PreparedStatement statement_M = null;
	/**reference to the JDBC Database connection**/
	private Connection connection_M = null;
	/**SQL query string**/
	private String query ="UPDATE ebay.ebay_items "
					+ "SET noRequired=(SELECT SUM(ebay_transactions.quantity) AS required "
					+ "FROM ebay.ebay_transactions WHERE ebay_transactions.itemID=?) "
					+ "WHERE ebay_items.itemID=?;";
	
	/**
	 * default constructor
	 */
	public UpdateTotalItemsRequired()
	{super();}
	
	/**
	 * execute the query
	 * @param parameter an array of strings where the 0th element is the parameter for the 
	 * first column, the 1st element is the parameter for the 2nd column and so on. 
	 * This query only needs 1 input so any element above the 0th element will be ignored.
	 * - col1 = required:int(6)
	 * @return List<String[]> representing the results of the query. The list contains only 1 
	 * column the itemID, so each list element contains a String[1] which contains 
	 * @throws SQLException
	 */
	public List<String[]> execute(String[] parameter) throws SQLException
	{
		this.initQuery();
		this.connection_M.prepareStatement(query);
		
		this.statement_M.setLong(1, Long.parseLong(parameter[0]));//ebay_transactions.itemID
		this.statement_M.setLong(2, Long.parseLong(parameter[0]));//ebay_items.itemID
		
		int resultCode = this.statement_M.executeUpdate();
		List<String[]> res = new ArrayList<String[]>();
		res.add(new String[] {resultCode+""});

		this.connection_M.commit();
		this.cleanup();
		
		return res;
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
		if (this.statement_M != null) {this.statement_M.close();}
		if (connection_M != null) {connection_M.close();}
	}
}

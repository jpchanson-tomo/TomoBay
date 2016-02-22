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
 * this class defines a database transaction comprised of two queries: the first updates the 
 * prestige specific parts table with available stock data based on partNo. The second query updates
 * the items table with a note (assuming there is an error) given a particular item id.
 * @author Jan P.C. Hanson
 *
 */
public  final class UpdateAvailableStockPSA implements AbstractDBQuery
{
	/**reference to the JDBC Statement**/
	private PreparedStatement statement1_M = null;
	/**reference to the JDBC Statement**/
	private PreparedStatement statement2_M = null;
	/**reference to the JDBC Database connection**/
	private Connection connection_M = null;
	/**SQL query string**/
	private String query ="UPDATE parts_psa SET available=? WHERE partNo=?;";
	
	private String query2 = "UPDATE ebay_items SET notes=? WHERE itemID=?;";
	
	/**
	 * default constructor
	 */
	public UpdateAvailableStockPSA()
	{super();}
	
	/**
	 * execute the query
	 * @param parameter an array of strings where the 0th element is the parameter for the 
	 * first column, the 1st element is the parameter for the 2nd column and so on. 
	 * The Ebay Orders Table only has 4 columns so any element above the 3rd element will be ignored.
	 * - col1 = parts_psa.available:int(6)
	 * - col2 = parts_psa.partNo:varchar(50)
	 * - col3 = ebay_items.notes:varchar(60)
	 * - col4 = ebay_items.itemID:bigint(11)
	 * @return List<String[]> representing the results of the query. The list contains only 2 
	 * columns the first is a resultcode for the first query, the second is the resultcode for
	 * the second query.
	 * @throws SQLException
	 */
	public List<String[]> execute(String[] parameter) throws SQLException
	{
		this.initQuery();
		
		this.statement1_M.setInt(1, Integer.parseInt(parameter[0]));//available
		this.statement1_M.setString(2, parameter[1]);//partNo for first query
		int resultCode = this.statement1_M.executeUpdate();
		
		this.statement2_M.setString(1, parameter[2]);//Notes
		this.statement2_M.setLong(2, Long.parseLong(parameter[3]));//itemID for second query
		int resultCode2 = this.statement2_M.executeUpdate();
		
		List<String[]> res = new ArrayList<String[]>();
		res.add(new String[] {resultCode+" "+resultCode2});

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
		this.statement1_M = this.connection_M.prepareStatement(query);
		this.statement2_M = this.connection_M.prepareStatement(query2);
	}
	
	/**
	 * do cleanup after the query has been executed
	 * @throws SQLException
	 */
	private void cleanup() throws SQLException
	{
		if (this.statement1_M != null) {this.statement1_M.close();}
		if (connection_M != null) {connection_M.close();}
	}
}
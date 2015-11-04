package openDMS.model.sql.queries.concreteQueries;
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
import openDMS.model.sql.queries.AbstractDBQuery;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import openDMS.model.sql.ConnectionManager;
/**
 *
 * @author Jan P.C. Hanson
 *
 */
public class UpdateAvailableStockPSA implements AbstractDBQuery
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
	 * @param parameter element 1 = qty available, element 2 = partNo, element 3 = notes, 
	 * element 4 = itemID, 
	 * @return List<String[]> representing the results of the query. The list contains only 1 
	 * column the itemID, so each list element contains a String[1] which contains 
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
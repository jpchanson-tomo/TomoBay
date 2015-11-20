package tomoBay.model.sql.queries.concreteQueries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tomoBay.model.sql.ConnectionManager;
import tomoBay.model.sql.queries.AbstractDBQuery;

/**
 *
 * @author Jan P.C. Hanson
 *
 */
public class UpdateAvailableStockFord implements AbstractDBQuery
{
	/**reference to the JDBC Statement**/
	private PreparedStatement statement1_M = null;
	/**reference to the JDBC Statement**/
	private PreparedStatement statement2_M = null;
	/**reference to the JDBC Database connection**/
	private Connection connection_M = null;
	/**SQL query string**/
	private String query ="UPDATE parts_ford SET available=? WHERE partNo=?;";
	
	private String query2 = "UPDATE ebay_items SET notes=? WHERE itemID=?;";
	
	/**
	 * default constructor
	 */
	public UpdateAvailableStockFord()
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
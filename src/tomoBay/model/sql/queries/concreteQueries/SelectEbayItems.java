package tomoBay.model.sql.queries.concreteQueries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
public class SelectEbayItems implements AbstractDBQuery
{
	/**reference to the JDBC Statement**/
	private PreparedStatement selectStatement_M = null;
	/**reference to the JDBC Database connection**/
	private Connection connection_M = null;
	/**SQL query string**/
	private String query ="SELECT * FROM ebay_items;";
	//
	/**
	 * default constructor
	 */
	public SelectEbayItems()
	{super();}
	
	/**
	 * execute the query
	 * @param NOT USED
	 * @return List<String[]> representing the results of the query. The list contains only 1 
	 * column the itemID, so each list element contains a String[1] which contains an itemID.
	 * @throws SQLException
	 */
	public List<String[]> execute(String[] parameter) throws SQLException
	{
		this.initQuery();
		this.connection_M.prepareStatement(query);
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
			String[] cols = new String[8];
			cols[0] = String.valueOf(results.getLong("itemID"));
			cols[1] = results.getString("title");
			cols[2] = results.getString("sellCondition");
			cols[3] = results.getString("brand");
			cols[4] = results.getString("partNo");
			cols[5] = String.valueOf(results.getInt("noRequired"));
			cols[6] = String.valueOf(results.getFloat("cost"));
			cols[7] = results.getString("notes");
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
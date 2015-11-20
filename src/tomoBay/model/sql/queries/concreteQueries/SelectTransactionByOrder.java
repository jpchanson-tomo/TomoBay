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
public class SelectTransactionByOrder implements AbstractDBQuery
{
	/**reference to the JDBC Statement**/
	private PreparedStatement statement_M = null;
	/**reference to the JDBC Database connection**/
	private Connection connection_M = null;
	/**SQL query string**/
	private static final String query = "SELECT * FROM ebay_transactions WHERE orderID=?;";
	
	/**
	 * default constructor
	 */
	public SelectTransactionByOrder()
	{super();}
	
	/**
	 * execute the query
	 * @param parameter single element String array with that element being the order number to
	 * look up.
	 * @return String representing the results of the query. each item of the list is a seperate
	 * row, each element of the String[] represents a column. String[0]=buyerID, String[1]=name,
	 * String[2]=shippingAddress.
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
			String[] cols = new String[8];
			cols[0] = results.getString("transactionID");
			cols[1] = results.getString("orderID");
			cols[2] = results.getString("itemID");
			cols[3] = results.getString("quantity");
			cols[4] = results.getString("price");
			cols[5] = results.getString("picked");
			cols[6] = results.getString("packed");
			cols[7] = results.getString("shipped");
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
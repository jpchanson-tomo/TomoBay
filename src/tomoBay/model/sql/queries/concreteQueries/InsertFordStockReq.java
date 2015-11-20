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
public class InsertFordStockReq implements AbstractDBQuery
{
	/**reference to the JDBC Statement**/
	private PreparedStatement statement_M = null;
	/**reference to the JDBC Database connection**/
	private Connection connection_M = null;
	/**SQL query string**/
	private String query ="INSERT IGNORE INTO ebay.parts_ford (parts_ford.partNo, parts_ford.required)"
			+ " VALUES(?, ?) ;";
	
	/**
	 * default constructor
	 */
	public InsertFordStockReq()
	{super();}
	
	/**
	 * execute the query
	 * @param parameter an array of strings where the 0th element is the parameter for the 
	 * first column, the 1st element is the parameter for the 2nd column and so on. The Ebay
	 * Orders Table only has 4 columns so any element above the 3rd element will be ignored.
	 * col1 =partNo:VARCHAR(20), col2=required:INT(6)
	 * @return List<String[]> representing the results of the query. The list contains only 1 
	 * String[] which in turn contains only 1 element, this is the resultcode for the query.
	 * @throws SQLException
	 */
	public List<String[]> execute(String[] parameter) throws SQLException
	{
		List<String[]> res = new ArrayList<String[]>();
		this.initQuery();
		this.connection_M.prepareStatement(query);
		this.statement_M.setString(1, parameter[0]); //partNumber
		this.statement_M.setInt(2, Integer.parseInt(parameter[1])); //required amount
		int resultCode = statement_M.executeUpdate();
		this.connection_M.commit();
		this.cleanup();
		
		res.add(new String[] {resultCode+""});
		
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
		statement_M = connection_M.prepareStatement(query);
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
package openDMS.model.sql.queries.concreteQueries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import openDMS.model.sql.ConnectionManager;
import openDMS.model.sql.queries.AbstractDBQuery;

/**
 *
 * @author Jan P.C. Hanson
 *
 */
public class UpdateItemBrandAndPartNo implements AbstractDBQuery
{
	/**reference to the JDBC Statement**/
	private PreparedStatement statement_M = null;
	/**reference to the JDBC Database connection**/
	private Connection connection_M = null;
	/**SQL query string**/
	private String query ="UPDATE ebay.ebay_items "
					+ "SET brand=?,partNo=? "
					+ "WHERE itemID=?";
	
	/**
	 * default constructor
	 */
	public UpdateItemBrandAndPartNo()
	{super();}
	
	/**
	 * execute the query
	 * @param 
	 * @return List<String[]> representing the results of the query. The list contains only 1 
	 * String[] which in turn contains only 1 element, this is the resultcode for the query.
	 * @throws SQLException
	 */
	public List<String[]> execute(String[] parameter) throws SQLException
	{
		List<String[]> res = new ArrayList<String[]>();
		this.initQuery();
		this.statement_M.setString(1, parameter[0]);	//brand
		this.statement_M.setString(2, parameter[1]);	//partNo
		this.statement_M.setLong(3, Long.parseLong(parameter[2]));	//itemID
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
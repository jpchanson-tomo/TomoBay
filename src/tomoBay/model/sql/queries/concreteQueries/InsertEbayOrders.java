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
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import tomoBay.model.sql.ConnectionManager;
import tomoBay.model.sql.queries.AbstractDBQuery;

/**
 * This class represents a class that inserts order data into the orders table of the database.
 * @author Jan P.C. Hanson
 *
 */
public  final class InsertEbayOrders implements AbstractDBQuery
{
	/**reference to the JDBC Statement**/
	private PreparedStatement statement_M = null;
	/**reference to the JDBC Database connection**/
	private Connection connection_M = null;
	/**SQL query string**/
	private String query ="INSERT IGNORE INTO ebay_orders (orderID, buyerID, salesRecNo, shippingType, createdTime, orderTotal, account)"
			+ "VALUES (?,?,?,?,?,?,?);";
	
	/**
	 * default constructor
	 */
	public InsertEbayOrders()
	{super();}
	
	/**
	 * execute the query
	 * @param parameter an array of strings where the 0th element is the parameter for the 
	 * first column, the 1st element is the parameter for the 2nd column and so on. 
	 * The Ebay Orders Table only has 5 columns so any element above the 4th element will be ignored.
	 * - col1 = orderID:int(30)
	 * - col2 = buyerID:varchar(40)
	 * - col3 = salesRecNo:int(10)
	 * - col4 = shippingType:varchar(200)
	 * - col5 = createdTime:datetime 
	 * @return List<String[]> representing the results of the query. The list contains only 1 
	 * String[] which in turn contains only 1 element, this is the resultcode for the query.
	 * @throws SQLException
	 */
	public List<String[]> execute(String[] parameter) throws SQLException
	{
		List<String[]> res = new ArrayList<String[]>();
		try
		{
			this.initQuery();
			this.statement_M.setString(1, parameter[0]);						//orderID
			this.statement_M.setString(2, parameter[1]);						//buyerID
			this.statement_M.setInt(3, Integer.parseInt(parameter[2]));			//salesRecNo
			this.statement_M.setString(4, parameter[3]);						//shippingType
			this.statement_M.setTimestamp(5, this.makeTimestamp(parameter[4]));	//createdTime
			this.statement_M.setFloat(6, Float.parseFloat(parameter[5]));		//orderTotal
			this.statement_M.setInt(7, Integer.parseInt(parameter[6]));	 		//account
			int resultCode = statement_M.executeUpdate();
			this.connection_M.commit();
			this.cleanup();
			
			res.add(new String[] {resultCode+""});
			
			return res;
		} 
		catch (ParseException e)
		{
			e.printStackTrace();
			res.add(new String[] {"Something went wrong with the query, please seek help!!!"});
			return res;
		}
	}
	
	/**
	 * turns the string passed in in yyyy-MM-dd HH:mm:ss.S format into a timestamp
	 * @param dateTime string in yyyy-MM-dd HH:mm:ss.S format
	 * @return Timestamp
	 * @throws ParseException
	 */
	private Timestamp makeTimestamp(String dateTime) throws ParseException
	{
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
		java.util.Date date = df.parse(dateTime);
		return new Timestamp(date.getTime());
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

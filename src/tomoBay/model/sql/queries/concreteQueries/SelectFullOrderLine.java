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
 *
 * @author Jan P.C. Hanson
 *
 */
public  final class SelectFullOrderLine implements AbstractDBQuery
{
	/**reference to the JDBC Statement**/
	private PreparedStatement statement_M = null;
	/**reference to the JDBC Database connection**/
	private Connection connection_M = null;
	/**SQL query string**/
	private static final String query = 
			"SELECT ebay_orders.orderID, ebay_orders.shippingType, ebay_orders.createdTime, ebay_orders.salesRecNo, "
					+ "ebay_items.itemID, ebay_items.title, ebay_items.brand, ebay_items.partNo, "
					+ "ebay_transactions.quantity, ebay_transactions.price, ebay_items.notes , "
					+ "ebay_buyers.buyerID, ebay_buyers.name, ebay_buyers.street1, ebay_buyers.street2,"
					+ "ebay_buyers.city, ebay_buyers.county, ebay_buyers.postcode, ebay_transactions.shippingCost, "
					+ "ebay_orders.orderTotal, ebay_orders.invoiced, ebay_items.itemID "
					+ "FROM ebay_orders "
					+ "INNER JOIN ebay_transactions ON ebay_orders.orderID=ebay_transactions.orderID "
					+ "INNER JOIN ebay_items ON ebay_transactions.itemID=ebay_items.itemID "
					+ "INNER JOIN ebay_buyers ON ebay_orders.buyerID=ebay_buyers.buyerID "
					+ "WHERE ebay_orders.orderID = ? ";
	
	/**
	 * default constructor
	 */
	public SelectFullOrderLine()
	{super();}
	
	/**
	 * execute the query
	 * @param parameter orderId (1 element array only)
	 * @return List<String[]> representing the results of the query. Each element in the list
	 * represents a row of the database and each element of the String[] represents a field.
	 * 
	 * The available fields for each element of the string[] are:
	 * - String[0] = orderID
	 * - String[1] = shippingType
	 * - String[2] = salesRecNo
	 * - String[3] = createdTime
	 * - String[4] = itemID
	 * - String[5] = title
	 * - String[6] = brand
	 * - String[7] = partNo
	 * - String[8] = quantity
	 * - String[9] = price
	 * - String[10] = notes
	 * - String[11] = buyerID
	 * - String[12] = name
	 * - String[13] = street1
	 * - String[14] = street2
	 * - String[15] = city
	 * - String[16] = county
	 * - String[17] = postcode
	 * - String[18] = shippingCost 
	 * - String[19] = orderTotal
	 * - String[20] = invoiced
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
			String[] cols = new String[21];
			cols[0] = results.getString("orderID");
			cols[1] = results.getString("shippingType");
			cols[2] = results.getString("salesRecNo");
			cols[3] = results.getString("createdTime");
			cols[4] = results.getString("itemID");
			cols[5] = results.getString("title");
			cols[6] = results.getString("brand");
			cols[7] = results.getString("partNo");
			cols[8] = results.getString("quantity");
			cols[9] = results.getString("price");
			cols[10] = results.getString("notes");
			cols[11] = results.getString("buyerID");
			cols[12] = results.getString("name");
			cols[13] = results.getString("street1");
			cols[14] = results.getString("street2");
			cols[15] = results.getString("city");
			cols[16] = results.getString("county");
			cols[17] = results.getString("postcode");
			cols[18] = results.getString("shippingCost");
			cols[19] = results.getString("orderTotal");
			cols[20] = results.getString("invoiced");
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
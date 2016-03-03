package tomoBay.model.sql.queries.concreteQueries.select;


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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tomoBay.model.sql.queries.AbstractSelectQueryNoParams;
/**
 *
 * @author Jan P.C. Hanson
 *
 */
public  final class SelectUncalculatedInvoices extends AbstractSelectQueryNoParams
{
	/**SQL query string**/
	private String query ="SELECT ebay_transactions.orderID, ebay_transactions.transactionID, "
						+ "ebay_transactions.quantity, ebay_transactions.price, ebay_items.partNo, "
						+ "ebay_items.brand, ebay_items.title, ebay_transactions.shippingCost "
						+ "FROM ebay_transactions "
						+ "INNER JOIN ebay_items ON ebay_transactions.itemID=ebay_items.itemID "
						+ "LEFT JOIN ebay_orders ON ebay_transactions.orderID= ebay_orders.orderID "
						+ "WHERE ebay_orders.invoiced=0 AND (ebay_items.notes NOT LIKE '%ERROR%' OR ebay_items.notes IS NULL) "
						+ "ORDER BY ebay_transactions.orderID ASC;";
	//
	/**
	 * default constructor
	 */
	public SelectUncalculatedInvoices()
	{super();}
	
	/**
	 * execute the query
	 * @param NotUsed NOT USED
	 * @return List<String[]> representing the results of the query. Each element in the list
	 * represents a row of the database and each element of the String[] represents a field.
	 * 
	 * The available fields for each element of the string[] are:
	 * cols[0] = results.getString("orderID");
	 * cols[0] = results.getString("transactionID");
	 * cols[0] = results.getString("quantity");
	 * cols[0] = results.getString("price");
	 * Cols[0] = results.getString("partNo");
	 * cols[0] = results.getString("brand");
	 * @throws SQLException
	 */
	public List<String[]> execute(String[] NotUsed) throws SQLException
	{
		List<String[]> selectResults = this.format(super.initQuery(query));
		super.cleanup();
		return selectResults;
	}
	
	/**
	 * formats the ResultSet (returned from the executed query) as a string
	 * @param results the ResultSet (post query execution)
	 * @return String containing the formatted results.
	 * @throws SQLException
	 */
	@Override
	protected List<String[]> format(ResultSet results) throws SQLException
	{
		List<String[]> rows = new ArrayList<String[]>();
		while (results.next())
		{
			String[] cols = new String[8];
			cols[0] = results.getString("orderID");
			cols[1] = results.getString("transactionID");
			cols[2] = results.getString("quantity");
			cols[3] = results.getString("price");
			cols[4] = results.getString("partNo");
			cols[5] = results.getString("brand");
			cols[6] = results.getString("title");
			cols[7] = results.getString("shippingCost");
			rows.add(cols);
		}
		return rows;
	}
}
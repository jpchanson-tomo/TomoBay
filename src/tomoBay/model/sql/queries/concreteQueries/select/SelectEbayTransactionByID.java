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

import tomoBay.model.sql.queries.AbstractSelectQueryWithParams;
/**
 *
 * @author Jan P.C. Hanson
 *
 */
public  final class SelectEbayTransactionByID extends AbstractSelectQueryWithParams
{
	/**SQL query string**/
	private String query ="SELECT itemID,quantity,price,shippingCost FROM ebay_transactions WHERE transactionID=?";
	//
	/**
	 * default constructor
	 */
	public SelectEbayTransactionByID()
	{super();}
	
	/**
	 * execute the query
	 * @param parameters single element array containing the transactrionID
	 * @return List<String[]> representing the results of the query. Each element in the list
	 * represents a row of the database and each element of the String[] represents a field.
	 * 
	 * The available fields for each element of the string[] are:
	 * - String[0] = itemID
	 * - String[1] = quantity
	 * - String[2] = price
	 * - String[3] = shippingCost
	 * 
	 * @throws SQLException
	 */
	public List<String[]> execute(String[] parameters) throws SQLException
	{
		super.initQuery(query);
		super.statement_M.setString(1, parameters[0]);
		
		ResultSet rs = super.statement_M.executeQuery();
		List<String[]> selectResults = this.format(rs);

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
			String[] cols = new String[4];
			cols[0] = results.getString("itemID");
			cols[1] = results.getString("quantity");
			cols[2] = results.getString("price");
			cols[3] = results.getString("shippingCost");
			rows.add(cols);
		}
		return rows;
	}
}
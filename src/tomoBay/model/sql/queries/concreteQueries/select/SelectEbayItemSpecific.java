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
 * This class represents a query that selects a specific item from the items table of the 
 * database, based on the itemID.
 * @author Jan P.C. Hanson
 *
 */
public  final class SelectEbayItemSpecific extends AbstractSelectQueryWithParams
{
	/**SQL query string**/
	private String query ="SELECT * FROM ebay_items WHERE itemID=?;";
	//
	/**
	 * default constructor
	 */
	public SelectEbayItemSpecific()
	{super();}
	
	/**
	 * execute the query
	 * @param parameter single element array where that single element corresponds to the 
	 * itemID you wish to query. (all further elements will be ignored)
	 * @return List<String[]> representing the results of the query. The list contains only 1 
	 * column the itemID, so each list element contains a String[1] which contains an itemID.
	 * @throws SQLException
	 */
	public List<String[]> execute(String[] parameter) throws SQLException
	{
		this.initQuery(query);
		
		this.statement_M.setLong(1, Long.parseLong(parameter[0]));
		
		ResultSet rs = this.statement_M.executeQuery();
		List<String[]> selectResults = this.format(rs);

		this.cleanup();
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
			String[] cols = new String[7];
			cols[0] = String.valueOf(results.getLong("itemID"));
			cols[1] = results.getString("title");
			cols[2] = results.getString("sellCondition");
			cols[3] = results.getString("brand");
			cols[4] = results.getString("partNo");
			cols[5] = results.getString("notes");
			cols[6] = results.getString("account");
			rows.add(cols);
		}
		return rows;
	}
}
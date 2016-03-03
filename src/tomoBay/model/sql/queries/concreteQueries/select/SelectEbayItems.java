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
 * This class represents a query that selects all the fields in the items table of the database.
 * @author Jan P.C. Hanson
 *
 */
public  final class SelectEbayItems extends AbstractSelectQueryNoParams
{
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
	 * @param NotUsed NOT USED
	 * @return List<String[]> representing the results of the query. Each element in the list
	 * represents a row of the database and each element of the String[] represents a field.
	 * 
	 * The available fields for each element of the string[] are:
	 * - String[0] = itemID
	 * - String[1] = title
	 * - String[2] = sellCondition
	 * - String[3] = brand
	 * - String[4] = partNo
	 * - String[5] = notes
	 * 
	 * @throws SQLException
	 */
	public List<String[]> execute(String[] NotUsed) throws SQLException
	{
		List<String[]> selectResults = this.format(this.initQuery(query));
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
			String[] cols = new String[6];
			cols[0] = String.valueOf(results.getLong("itemID"));
			cols[1] = results.getString("title");
			cols[2] = results.getString("sellCondition");
			cols[3] = results.getString("brand");
			cols[4] = results.getString("partNo");
			cols[5] = results.getString("notes");
			rows.add(cols);
		}
		return rows;
	}
}
package tomoBay.model.sql.queries.concreteQueries.select;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
import tomoBay.model.sql.queries.AbstractSelectQueryNoParams;

/**
 *
 * @author Jan P.C. Hanson
 *
 */
public final class SelectAccounts extends AbstractSelectQueryNoParams
{
	/**SQL query string**/
	private String query ="SELECT * FROM ebay_accounts;";
	//
	/**
	 * default constructor
	 */
	public SelectAccounts()
	{super();}
	
	/**
	 * execute the query
	 * @param NOTUSED
	 * @return List<String[]> representing the results of the query. Each element in the list
	 * represents a row of the database and each element of the String[] represents a field.
	 * 
	 * The available fields for each element of the string[] are:
	 * - String[0] = id
	 * - String[1] = accountName
	 * - String[2] = apiKey
	 * - String[3] = serverAddr
	 * - String[4] = lookbackDays
	 * 
	 * @throws SQLException
	 */
	public List<String[]> execute(String[] NOTUSED) throws SQLException
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
			String[] cols = new String[5];
			cols[0] = results.getString("id");
			cols[1] = results.getString("accountName");
			cols[2] = results.getString("apiKey");
			cols[3] = results.getString("serverAddr");
			cols[4] = results.getString("lookbackDays");
			rows.add(cols);
		}
		return rows;
	}
}
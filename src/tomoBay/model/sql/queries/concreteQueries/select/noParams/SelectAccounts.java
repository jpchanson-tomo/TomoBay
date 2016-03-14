package tomoBay.model.sql.queries.concreteQueries.select.noParams;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tomoBay.model.dataTypes.heteroTypeContainer.HeteroFieldContainer;
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
import tomoBay.model.sql.queries.AbstractSelectNoParamsQuery;
import tomoBay.model.sql.schema.accountsTable.AccountsTable;

/**
 *
 * @author Jan P.C. Hanson
 *
 */
public final class SelectAccounts extends AbstractSelectNoParamsQuery
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
	public List<HeteroFieldContainer> execute() throws SQLException
	{
		List<HeteroFieldContainer> selectResults = this.format(super.initQuery(query));
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
	protected List<HeteroFieldContainer> format(ResultSet results) throws SQLException
	{
		List<HeteroFieldContainer> rows = new ArrayList<HeteroFieldContainer>();
		while (results.next())
		{
			HeteroFieldContainer cols = new HeteroFieldContainer();
			cols.add(AccountsTable.ID, results.getInt("id"));
			cols.add(AccountsTable.ACCOUNT_NAME, results.getString("accountName"));
			cols.add(AccountsTable.API_KEY, results.getString("apiKey"));
			cols.add(AccountsTable.SERVER_ADDR, results.getString("serverAddr"));
			cols.add(AccountsTable.LOOKBACK_DAYS, results.getInt("lookbackDays"));
			rows.add(cols);
		}
		return rows;
	}
}
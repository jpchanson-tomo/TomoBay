package tomoBay.model.sql.queries.concreteQueries.select.params;
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

import tomoBay.model.dataTypes.heteroTypeContainer.ClassRef;
import tomoBay.model.dataTypes.heteroTypeContainer.HeteroFieldContainer;
import tomoBay.model.sql.queries.AbstractSelectParamsQuery;
import tomoBay.model.sql.schema.transactionsTable.TransactionsTable;

/**
 * This class represents a query that selects all data from the transactions table of the 
 * database given a particular orderID.
 * @author Jan P.C. Hanson
 *
 */
public  final class SelectTransactionByOrder extends AbstractSelectParamsQuery
{
	/**SQL query string**/
	private static final String query = "SELECT transactionID, itemID FROM ebay_transactions WHERE orderID=?;";
	
	/**
	 * default constructor
	 */
	public SelectTransactionByOrder()
	{super();}
	
	/**
	 * execute the query
	 * @param parameter single element String array with that element being the order number to
	 * look up.
	 * @return List<HeteroFieldContainer> representing the results of the query. Each element in the list
	 * represents a row of the database and each element of the HeteroFieldContainer represents a field.
	 * 
	 * The available fields for each element of the HeteroFieldContainer are:
	 * - String[0] = transactionID
	 * - String[1] = itemID
	 * 
	 * @throws SQLException
	 */
	public List<HeteroFieldContainer> execute(HeteroFieldContainer parameter) throws SQLException
	{
		super.initQuery(query);
		super.statement_M.setString(1, parameter.get(TransactionsTable.ORDER_ID, ClassRef.STRING));
		
		ResultSet resultset = statement_M.executeQuery();
		List<HeteroFieldContainer> result = this.format(resultset);
		
		super.cleanup();
		return result;
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
			cols.add(TransactionsTable.TRANSACTION_ID, results.getLong("transactionID"));
			cols.add(TransactionsTable.ITEM_ID,results.getLong("itemID"));
			rows.add(cols);
		}
		return rows;
	}
}
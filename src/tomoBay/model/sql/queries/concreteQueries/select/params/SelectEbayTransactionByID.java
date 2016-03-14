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
 *
 * @author Jan P.C. Hanson
 *
 */
public  final class SelectEbayTransactionByID extends AbstractSelectParamsQuery
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
	 * @return List<HeteroFieldContainer> representing the results of the query. Each element in the list
	 * represents a row of the database and each element of the HeteroFieldContainer represents a field.
	 * 
	 * The available fields for each element of the HeteroFieldContainer are:
	 * - String[0] = itemID
	 * - String[1] = quantity
	 * - String[2] = price
	 * - String[3] = shippingCost
	 * 
	 * @throws SQLException
	 */
	public List<HeteroFieldContainer> execute(HeteroFieldContainer parameters) throws SQLException
	{
		super.initQuery(query);
		super.statement_M.setLong(1, parameters.get(TransactionsTable.TRANSACTION_ID, ClassRef.LONG));
		
		ResultSet rs = super.statement_M.executeQuery();
		List<HeteroFieldContainer> selectResults = this.format(rs);

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
			cols.add(TransactionsTable.ITEM_ID, results.getLong("itemID"));
			cols.add(TransactionsTable.QUANTITY, results.getInt("quantity"));
			cols.add(TransactionsTable.PRICE, results.getFloat("price"));
			cols.add(TransactionsTable.SHIPPING_COST, results.getFloat("shippingCost"));
			rows.add(cols);
		}
		return rows;
	}
}
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

import tomoBay.model.dataTypes.heteroTypeContainer.HeteroFieldContainer;
import tomoBay.model.sql.framework.QueryUtility;
import tomoBay.model.sql.framework.queryTypes.select.AbstractSelectParamsQuery;
import tomoBay.model.sql.schema.transactionsTable.TransactionsTable;
/**
 * This class represents a query that selects the itemId, quantity, price and shippingCost field from
 * the ebay_transactions table in the database, that correspond to the transactionId passed in as a 
 * parameter to the execute(HeteroFieldContainer parameter) method.
 * 
 * This query takes the following parameter:
 * - TransactionsTable.TRANSACTION_ID
 * 
 * The query returns a List<HeteroFieldContainer> containing the following fields:
 * - TransactionsTable.ITEM_ID
 * - TransactionsTable.QUANTITY
 * - TransactionsTable.PRICE
 * - TransactionsTable.SHIPPING_COST
 * 
 * @author Jan P.C. Hanson
 *
 */
public  final class SelectEbayTransactionByID extends AbstractSelectParamsQuery
{
	/**SQL query string**/
	private static final String query ="SELECT itemID,quantity,price,shippingCost FROM ebay_transactions WHERE transactionID=?";
	
	/**
	 * default constructor
	 */
	public SelectEbayTransactionByID()
	{super();}
	
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

	/* (non-Javadoc)
	 * @see tomoBay.model.sql.framework.queryTypes.select.AbstractSelectParamsQuery#setParameters(tomoBay.model.dataTypes.heteroTypeContainer.HeteroFieldContainer)
	 */
	@Override
	protected void setParameters(HeteroFieldContainer parameter) throws ClassCastException, SQLException
	{QueryUtility.setBIGINTParam(this, parameter, TransactionsTable.TRANSACTION_ID, 1);}

	/* (non-Javadoc)
	 * @see tomoBay.model.sql.framework.queryTypes.AbstractDBQuery#queryString()
	 */
	@Override
	protected String queryString()
	{return SelectEbayTransactionByID.query;}
}
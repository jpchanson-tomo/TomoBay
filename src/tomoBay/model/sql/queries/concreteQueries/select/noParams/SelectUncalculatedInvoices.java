package tomoBay.model.sql.queries.concreteQueries.select.noParams;


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
import tomoBay.model.sql.framework.queryTypes.select.AbstractSelectNoParamsQuery;
import tomoBay.model.sql.schema.itemsTable.ItemsTable;
import tomoBay.model.sql.schema.transactionsTable.TransactionsTable;
/**
 *
 * @author Jan P.C. Hanson
 *
 */
public  final class SelectUncalculatedInvoices extends AbstractSelectNoParamsQuery
{
	/**SQL query string**/
	private static final String query ="SELECT ebay_transactions.orderID, ebay_transactions.transactionID, "
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
			cols.add(TransactionsTable.ORDER_ID,results.getString("orderID"));
			cols.add(TransactionsTable.TRANSACTION_ID,results.getLong("transactionID"));
			cols.add(TransactionsTable.QUANTITY,results.getInt("quantity"));
			cols.add(TransactionsTable.PRICE,results.getFloat("price"));
			cols.add(ItemsTable.PART_NO,results.getString("partNo"));
			cols.add(ItemsTable.BRAND,results.getString("brand"));
			cols.add(ItemsTable.TITLE,results.getString("title"));
			cols.add(TransactionsTable.SHIPPING_COST,results.getFloat("shippingCost"));
			rows.add(cols);
		}
		return rows;
	}

	/* (non-Javadoc)
	 * @see tomoBay.model.sql.framework.queryTypes.AbstractDBQuery#queryString()
	 */
	@Override
	protected String queryString()
	{return SelectUncalculatedInvoices.query;}
}
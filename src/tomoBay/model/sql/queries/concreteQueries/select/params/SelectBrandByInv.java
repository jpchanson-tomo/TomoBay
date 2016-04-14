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
import tomoBay.model.sql.schema.itemsTable.ItemsTable;
import tomoBay.model.sql.schema.ordersTable.OrdersTable;
/**
 * This class represents a Query that selects the Brand value associated with a particular invoice
 * number passed in as a parameter to the execute(HeteroFieldContainer parameter) method.
 * 
 * This query takes the following parameter:
 * - OrdersTable.INVOICED
 * 
 * The query returns a List<HeteroFieldContainer> containing the following fields:
 * - ItemsTable.BRAND
 * 
 * @author Jan P.C. Hanson
 *
 */
public final class SelectBrandByInv extends AbstractSelectParamsQuery
{
	/**SQL query string**/
	private static final String query ="SELECT brand FROM ebay_items "
						+ "INNER JOIN ebay_transactions ON ebay_items.itemID=ebay_transactions.itemID "
						+ "INNER JOIN ebay_orders ON ebay_orders.orderID=ebay_transactions.orderID "
						+ "WHERE invoiced=?;";
	//
	/**
	 * default constructor
	 */
	public SelectBrandByInv()
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
			cols.add(ItemsTable.BRAND, results.getString("brand"));
			rows.add(cols);
		}
		return rows;
	}

	/* (non-Javadoc)
	 * @see tomoBay.model.sql.framework.queryTypes.select.AbstractSelectParamsQuery#setParameters(tomoBay.model.dataTypes.heteroTypeContainer.HeteroFieldContainer)
	 */
	@Override
	protected void setParameters(HeteroFieldContainer parameter) throws ClassCastException, SQLException
	{QueryUtility.setINTEGERParam(this, parameter, OrdersTable.INVOICED, 1);}

	/* (non-Javadoc)
	 * @see tomoBay.model.sql.framework.queryTypes.AbstractDBQuery#queryString()
	 */
	@Override
	protected String queryString()
	{return SelectBrandByInv.query;}
}
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
import tomoBay.model.sql.schema.itemsTable.ItemsTable;
import tomoBay.model.sql.schema.ordersTable.OrdersTable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tomoBay.model.dataTypes.heteroTypeContainer.HeteroFieldContainer;
import tomoBay.model.sql.framework.QueryUtility;
import tomoBay.model.sql.framework.queryTypes.select.AbstractSelectParamsQuery;
/**
 * This class represents a query that selects the brand and part number fields associated with a 
 * particular orderID passed in to the execute(HeteroFieldContainer parameter) method.
 * 
 * This query takes the following parameter:
 * - OrdersTable.ORDER_ID
 * 
 * The query returns a List<HeteroFieldContainer> containing the following fields:
 * - ItemsTable.BRAND
 * - ItemsTable.PART_NO
 * 
 * @author Jan P.C. Hanson
 *
 */
public final class SelectBrandAndPartNoByOrderID extends AbstractSelectParamsQuery
{
	/**SQL query string**/
	private static final String query ="SELECT brand, partNo FROM ebay_items "
						+ "INNER JOIN ebay_transactions ON ebay_items.itemID=ebay_transactions.itemID "
						+ "INNER JOIN ebay_orders ON ebay_orders.orderID=ebay_transactions.orderID "
						+ "WHERE  ebay_orders.orderID=?;";
	//
	/**
	 * default constructor
	 */
	public SelectBrandAndPartNoByOrderID()
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
			cols.add(ItemsTable.PART_NO, results.getString("partNo"));
			rows.add(cols);
		}
		return rows;
	}

	/* (non-Javadoc)
	 * @see tomoBay.model.sql.framework.queryTypes.select.AbstractSelectParamsQuery#setParameters(tomoBay.model.dataTypes.heteroTypeContainer.HeteroFieldContainer)
	 */
	@Override
	protected void setParameters(HeteroFieldContainer parameter) throws ClassCastException, SQLException
	{QueryUtility.setVARCHARParam(this, parameter, OrdersTable.ORDER_ID, 1);}

	/* (non-Javadoc)
	 * @see tomoBay.model.sql.framework.queryTypes.AbstractDBQuery#queryString()
	 */
	@Override
	protected String queryString()
	{return SelectBrandAndPartNoByOrderID.query;}
}

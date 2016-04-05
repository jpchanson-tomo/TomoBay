package tomoBay.model.sql.queries.concreteQueries.select.params;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tomoBay.model.dataTypes.heteroTypeContainer.ClassRef;
import tomoBay.model.dataTypes.heteroTypeContainer.HeteroFieldContainer;
import tomoBay.model.sql.queries.AbstractSelectParamsQuery;
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

/**
 *
 * @author Jan P.C. Hanson
 *
 */
public final class SelectBrandAndPartNoByOrderID extends AbstractSelectParamsQuery
{
	/**SQL query string**/
	private String query ="SELECT brand, partNo FROM ebay_items "
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
	 * execute the query
	 * @param parameter invoice number  
	 * @return List<String[]> representing the results of the query. Each element in the list
	 * represents a row of the database and each element of the String[] represents a field.
	 * 
	 * The available fields for each element of the string[] are:
	 * - String[0] = brand
	 * 
	 * @throws SQLException
	 */
	public List<HeteroFieldContainer> execute(HeteroFieldContainer parameter) throws SQLException
	{
		super.initQuery(query);
		
		this.statement_M.setString(1, parameter.get(OrdersTable.ORDER_ID, ClassRef.STRING));
		
		ResultSet rs = this.statement_M.executeQuery();
		List<HeteroFieldContainer> selectResults = this.format(rs);

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
}
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

/**
 * This class represents a query that selects all the fields in the items table of the database.
 * @author Jan P.C. Hanson
 *
 */
public  final class SelectEbayItems extends AbstractSelectNoParamsQuery
{
	/**SQL query string**/
	private static final String query ="SELECT * FROM ebay_items;";
	//
	/**
	 * default constructor
	 */
	public SelectEbayItems()
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
			cols.add(ItemsTable.ITEM_ID, results.getLong("itemID"));
			cols.add(ItemsTable.TITLE, results.getString("title"));
			cols.add(ItemsTable.CONDITION, results.getString("sellCondition"));
			cols.add(ItemsTable.BRAND, results.getString("brand"));
			cols.add(ItemsTable.PART_NO, results.getString("partNo"));
			cols.add(ItemsTable.NOTES, results.getString("notes"));
			cols.add(ItemsTable.ACCOUNT, results.getInt("account"));
			rows.add(cols);
		}
		return rows;
	}

	/* (non-Javadoc)
	 * @see tomoBay.model.sql.framework.queryTypes.AbstractDBQuery#queryString()
	 */
	@Override
	protected String queryString()
	{return SelectEbayItems.query;}
}
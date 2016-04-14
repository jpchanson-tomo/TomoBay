package tomoBay.model.sql.queries.concreteQueries.insert;
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
import java.sql.SQLException;

import tomoBay.model.dataTypes.heteroTypeContainer.HeteroFieldContainer;
import tomoBay.model.sql.framework.QueryUtility;
import tomoBay.model.sql.framework.queryTypes.modify.AbstractModifyQueryParams;
import tomoBay.model.sql.schema.itemsTable.ItemsTable;
/**
 * This class represents a query that inserts item details into the items table of the database.
 * 
 * This query requires the following parameters:
 * - ItemsTable.ITEM_ID
 * - ItemsTable.TITLE
 * - ItemsTable.CONDITION
 * - ItemsTable.BRAND
 * - ItemsTable.PART_NO
 * - ItemsTable.ACCOUNT
 * 
 * These should be stored in a HeteroFieldContainer an passed to the execute(HeteroFieldContainer parameters) 
 * method when you wish to run the query.
 * 
 * @author Jan P.C. Hanson
 *
 */
public  final class InsertEbayItems extends AbstractModifyQueryParams
{
	/**SQL query string**/
	private static final String query ="INSERT IGNORE INTO ebay_items "
			+ "(itemID, title, sellCondition, brand, partNo, account)"
			+ "VALUES (?,?,?,?,?,?);";
	
	/**
	 * default constructor
	 */
	public InsertEbayItems()
	{super();}

	/* (non-Javadoc)
	 * @see tomoBay.model.sql.framework.queryTypes.modify.AbstractModifyQueryParams#queryString()
	 */
	@Override
	protected String queryString()
	{return InsertEbayItems.query;}

	/* (non-Javadoc)
	 * @see tomoBay.model.sql.framework.queryTypes.modify.AbstractModifyQueryParams#setParameters(tomoBay.model.dataTypes.heteroTypeContainer.HeteroFieldContainer)
	 */
	@Override
	protected void setParameters(HeteroFieldContainer parameter) throws ClassCastException, SQLException
	{
		QueryUtility.setBIGINTParam(this, parameter, ItemsTable.ITEM_ID, 1);
		QueryUtility.setVARCHARParam(this, parameter, ItemsTable.TITLE, 2);
		QueryUtility.setVARCHARParam(this, parameter, ItemsTable.CONDITION,3);
		QueryUtility.setVARCHARParam(this, parameter, ItemsTable.BRAND, 4);
		QueryUtility.setVARCHARParam(this, parameter, ItemsTable.PART_NO, 5);
		QueryUtility.setINTEGERParam(this, parameter, ItemsTable.ACCOUNT, 6);
	}
}
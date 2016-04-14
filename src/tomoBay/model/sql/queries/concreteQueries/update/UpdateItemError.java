package tomoBay.model.sql.queries.concreteQueries.update;
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
 * This class represents a query that updates the brand and partNo of a particular item in the 
 * items table of the database.
 * 
 * This query takes the following parameters:
 * - ItemsTable.BRAND
 * - ItemsTable.PART_NO
 * - ItemsTable.NOTES
 * - ItemsTable.ITEM_ID
 * 
 * These should be stored in a HeteroFieldContainer and passed to the execute(HeteroFieldContainer parameters) 
 * method in order to run the query.
 * 
 * @author Jan P.C. Hanson
 *
 */
public  final class UpdateItemError extends AbstractModifyQueryParams
{
	/**SQL query string**/
	private static final String query ="UPDATE ebay_items "
					+ "SET brand=?,partNo=?,notes=?"
					+ "WHERE itemID=?";
	
	/**
	 * default constructor
	 */
	public UpdateItemError()
	{super();}

	/* (non-Javadoc)
	 * @see tomoBay.model.sql.framework.queryTypes.modify.AbstractModifyQueryParams#queryString()
	 */
	@Override
	protected String queryString()
	{return UpdateItemError.query;}

	/* (non-Javadoc)
	 * @see tomoBay.model.sql.framework.queryTypes.modify.AbstractModifyQueryParams#setParameters(tomoBay.model.dataTypes.heteroTypeContainer.HeteroFieldContainer)
	 */
	@Override
	protected void setParameters(HeteroFieldContainer parameter) throws ClassCastException, SQLException
	{
		QueryUtility.setVARCHARParam(this, parameter, ItemsTable.BRAND, 1);
		QueryUtility.setVARCHARParam(this, parameter, ItemsTable.PART_NO, 2);
		QueryUtility.setVARCHARParam(this, parameter, ItemsTable.NOTES, 3);
		QueryUtility.setBIGINTParam(this, parameter, ItemsTable.ITEM_ID, 4);
	}
}
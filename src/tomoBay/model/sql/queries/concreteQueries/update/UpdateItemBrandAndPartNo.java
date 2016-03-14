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

import tomoBay.model.dataTypes.heteroTypeContainer.ClassRef;
import tomoBay.model.dataTypes.heteroTypeContainer.HeteroFieldContainer;
import tomoBay.model.sql.queries.AbstractModifyQuery;
import tomoBay.model.sql.schema.itemsTable.ItemsTable;
import tomoBay.model.sql.schema.nonDBFields.NonDBFields;

/**
 * This class represents a query that updates the brand and partNo of a particular item in the 
 * items table of the database.
 * 
 * @author Jan P.C. Hanson
 *
 */
public  final class UpdateItemBrandAndPartNo extends AbstractModifyQuery
{
	/**SQL query string**/
	private String query ="UPDATE ebay_items "
					+ "SET brand=?,partNo=? "
					+ "WHERE itemID=?";
	
	/**
	 * default constructor
	 */
	public UpdateItemBrandAndPartNo()
	{super();}
	
	/**
	 * execute the query
	 * @param parameter an array of strings where the 0th element is the parameter for the 
	 * first column, the 1st element is the parameter for the 2nd column and so on. 
	 * This query only requires 2 inputs so any element above the 1st element will be ignored.
	 * - col1 = brand:varchar(20)
	 * - col2 = partNo:varchar(100) 
	 * - col3 = itemID:bigint(13)
	 * @return List<String[]> representing the results of the query. The list contains only 1 
	 * String[] which in turn contains only 1 element, this is the resultcode for the query.
	 * @throws SQLException
	 */
	public HeteroFieldContainer execute(HeteroFieldContainer parameter) throws SQLException
	{
		super.initQuery(query);
		super.statement_M.setString(1, parameter.get(ItemsTable.BRAND, ClassRef.STRING));
		super.statement_M.setString(2, parameter.get(ItemsTable.PART_NO, ClassRef.STRING));
		super.statement_M.setLong(3, parameter.get(ItemsTable.ITEM_ID, ClassRef.LONG));
		
		int resultCode = super.statement_M.executeUpdate();
		super.cleanup();
		
		parameter.add(NonDBFields.RESULT_CODE, resultCode);
		return parameter;
	}
}
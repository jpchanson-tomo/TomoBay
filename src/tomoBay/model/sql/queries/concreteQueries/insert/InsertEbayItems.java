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

import tomoBay.model.dataTypes.heteroTypeContainer.ClassRef;
import tomoBay.model.dataTypes.heteroTypeContainer.HeteroFieldContainer;
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
import tomoBay.model.sql.queries.AbstractModifyQuery;
import tomoBay.model.sql.schema.itemsTable.ItemsTable;
import tomoBay.model.sql.schema.nonDBFields.NonDBFields;

/**
 * This class represents a query that inserts item details into the items table of the database.
 * @author Jan P.C. Hanson
 *
 */
public  final class InsertEbayItems extends AbstractModifyQuery
{
	/**SQL query string**/
	private String query ="INSERT IGNORE INTO ebay_items "
			+ "(itemID, title, sellCondition, brand, partNo, account)"
			+ "VALUES (?,?,?,?,?,?);";
	
	/**
	 * default constructor
	 */
	public InsertEbayItems()
	{super();}
	
	/**
	 * execute the query
	 * @param parameter an array of strings where the 0th element is the parameter for the 
	 * first column, the 1st element is the parameter for the 2nd column and so on. 
	 * The Ebay Orders Table only has 5 columns so any element above the 5th element will be ignored.
	 * - col1 =itemID:varchar(11)
	 * - col2=title:varchar(83) 
	 * - col3=sellCondition:varchar(15)
	 * - col4=brand:varchar(45)
	 * - col5=partNo:varchar(100) 
	 * @return List<String[]> representing the results of the query. The list contains only 1 
	 * String[] which in turn contains only 1 element, this is the resultcode for the query.
	 * @throws SQLException
	 */
	public HeteroFieldContainer execute(HeteroFieldContainer parameter) throws SQLException
	{
		this.initQuery(query);
		this.statement_M.setLong(1, parameter.get(ItemsTable.ITEM_ID, ClassRef.LONG));
		this.statement_M.setString(2, parameter.get(ItemsTable.TITLE, ClassRef.STRING));
		this.statement_M.setString(3, parameter.get(ItemsTable.CONDITION, ClassRef.STRING));
		this.statement_M.setString(4, parameter.get(ItemsTable.BRAND, ClassRef.STRING));
		this.statement_M.setString(5, parameter.get(ItemsTable.PART_NO, ClassRef.STRING));
		this.statement_M.setInt(6, parameter.get(ItemsTable.ACCOUNT, ClassRef.INTEGER));
		
		int resultCode = statement_M.executeUpdate();
		this.cleanup();
		
		parameter.add(NonDBFields.RESULT_CODE, resultCode);
		return parameter;
	}
}
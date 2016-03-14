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
import tomoBay.model.sql.queries.AbstractModifyQuery;
import tomoBay.model.sql.schema.nonDBFields.NonDBFields;
import tomoBay.model.sql.schema.outOfHoursTable.OutOfHoursTable;
/**
 *
 * @author Jan P.C. Hanson
 *
 */
public  final class InsertOutOfHoursOrders extends AbstractModifyQuery
{
	/**SQL query string**/
	private String query ="INSERT IGNORE INTO out_of_hours (salesRecNo, date)"
			+ "VALUES (?,?);";
	
	/**
	 * default constructor
	 */
	public InsertOutOfHoursOrders()
	{super();}
	
	/**
	 * execute the query
	 * @param parameter an array of strings where the 0th element is the parameter for the 
	 * first column
	 * - col1 = int(10):salesRecNo
	 * @return List<String[]> representing the results of the query. The list contains only 1 
	 * String[] which in turn contains only 1 element, this is the resultcode for the query.
	 * @throws SQLException
	 */
	public HeteroFieldContainer execute(HeteroFieldContainer parameter) throws SQLException
	{
		this.initQuery(query);
		this.statement_M.setInt(1, parameter.get(OutOfHoursTable.SALES_REC_NO, ClassRef.INTEGER));						//salesRecNo
		this.statement_M.setDate(2, parameter.get(OutOfHoursTable.DATE, ClassRef.DATE));					//date
		
		int resultCode = statement_M.executeUpdate();
		this.cleanup();
		
		parameter.add(NonDBFields.RESULT_CODE, resultCode);
		return parameter;
	}
}
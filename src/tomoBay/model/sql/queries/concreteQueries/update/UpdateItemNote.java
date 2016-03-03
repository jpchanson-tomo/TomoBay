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
import java.util.ArrayList;
import java.util.List;

import tomoBay.model.sql.queries.AbstractUpdateQuery;
/**
 *
 * @author Jan P.C. Hanson
 *
 */
public  final class UpdateItemNote extends AbstractUpdateQuery
{
	/**SQL query string**/
	private String query ="UPDATE ebay_items "
					+ "SET notes=?"
					+ "WHERE itemID=?";
	
	/**
	 * default constructor
	 */
	public UpdateItemNote()
	{super();}
	
	/**
	 * execute the query
	 * @param parameter an array of strings where the 0th element is the parameter for the 
	 * first column, the 1st element is the parameter for the 2nd column and so on. 
	 * This query only requires 2 inputs so any element above the 1st element will be ignored.
	 * - col1 = notes:varchar(60)
	 * - col2 = itemID:bigint(11) 
	 * @return List<String[]> representing the results of the query. The list contains only 1 
	 * String[] which in turn contains only 1 element, this is the resultcode for the query.
	 * @throws SQLException
	 */
	public List<String[]> execute(String[] parameter) throws SQLException
	{
		List<String[]> res = new ArrayList<String[]>();
		super.initQuery(query);
		super.statement_M.setString(1, parameter[0]);	//notes
		super.statement_M.setLong(2, Long.parseLong(parameter[1]));	//itemID
		
		int resultCode = super.statement_M.executeUpdate();
		super.cleanup();
		
		res.add(new String[] {resultCode+""});
		return res;
	}
}

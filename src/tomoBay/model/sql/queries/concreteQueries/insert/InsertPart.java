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
import tomoBay.model.sql.queries.AbstractInsertQuery;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Jan P.C. Hanson
 *
 */
public  final class InsertPart extends AbstractInsertQuery
{
	/**SQL query string**/
	private String query ="INSERT IGNORE INTO parts (partNo, description, brand)"
			+ " VALUES(?, ?, ?) ;";
	
	/**
	 * default constructor
	 */
	public InsertPart()
	{super();}
	
	/**
	 * execute the query
	 * @param parameter an array of strings where the 0th element is the parameter for the 
	 * first column, the 1st element is the parameter for the 2nd column and so on. 
	 * The Ebay Orders Table only has 4 columns so any element above the 3rd element will be ignored.
	 * - col1 = partNo:VARCHAR(17) 
	 * - col2 = description:VARCHAR(55)
	 * - col3 = brand:VARCHAR(45)
	 * @return List<String[]> representing the results of the query. The list contains only 1 
	 * String[] which in turn contains only 1 element, this is the resultcode for the query.
	 * @throws SQLException
	 */
	public List<String[]> execute(String[] parameter) throws SQLException
	{
		List<String[]> res = new ArrayList<String[]>();
		this.initQuery(query);
		this.statement_M.setString(1, parameter[0]); //partNumber
		this.statement_M.setString(2, parameter[1]); //description
		this.statement_M.setString(3, parameter[2]); //brand
		
		int resultCode = statement_M.executeUpdate();
		this.cleanup();
		
		res.add(new String[] {resultCode+""});
		return res;
	}
}
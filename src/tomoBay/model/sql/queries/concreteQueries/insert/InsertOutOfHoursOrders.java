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

import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import tomoBay.model.sql.queries.AbstractInsertQuery;
/**
 *
 * @author Jan P.C. Hanson
 *
 */
public  final class InsertOutOfHoursOrders extends AbstractInsertQuery
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
	public List<String[]> execute(String[] parameter) throws SQLException
	{
		List<String[]> res = new ArrayList<String[]>();
		this.initQuery(query);
		this.statement_M.setString(1, parameter[0]);						//salesRecNo
		this.statement_M.setDate(2, this.toDate(parameter[1]));					//date
		
		int resultCode = statement_M.executeUpdate();
		this.cleanup();
		
		res.add(new String[] {resultCode+""});
		return res;
	}
	/**
	 * converts a string to an sql date if it can otherwise it will return null;
	 * @param dateString yyyy-mm-dd
	 * @return java.sql.Date representing the string passed in, if it cannot parse the string
	 * it will return null.
	 */
	private Date toDate(String dateString)
	{
		try
		{
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date parsed = format.parse(dateString);
			Date sqlDate = new Date(parsed.getTime());
			return sqlDate;
		} 
		catch (ParseException e)
		{e.printStackTrace();return null;}
	}
}
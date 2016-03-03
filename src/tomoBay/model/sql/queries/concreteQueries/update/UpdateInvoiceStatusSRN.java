package tomoBay.model.sql.queries.concreteQueries.update;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
import tomoBay.model.sql.queries.AbstractUpdateQuery;
/**
 *
 * @author Jan P.C. Hanson
 *
 */
public  final class UpdateInvoiceStatusSRN extends AbstractUpdateQuery
{
	/**SQL query string**/
	private String query ="UPDATE ebay_orders SET invoiced=? WHERE salesRecNo=? AND account=?";
	
	/**
	 * default constructor
	 */
	public UpdateInvoiceStatusSRN()
	{super();}
	
	/**
	 * execute the query
	 * @param parameter The list contains only 2
	 * elements 1st element is invoiced status (0=not invoiceable, 1=partially invoiceable,
	 * 3=invoiced), the second element is the orderID
	 * @return List<String[]> representing the results of the query. The list contains only 1 
	 * String[] which in turn contains only 1 element, this is the resultcode for the query.
	 * @throws SQLException
	 */
	public List<String[]> execute(String[] parameter) throws SQLException
	{
		List<String[]> res = new ArrayList<String[]>();
		super.initQuery(query);
		super.statement_M.setInt(1, Integer.parseInt(parameter[0]));	//invoiced status code
		super.statement_M.setString(2, parameter[1]);//orderID
		super.statement_M.setString(3, parameter[2]);//account
		
		int resultCode = super.statement_M.executeUpdate();
		super.cleanup();
		
		res.add(new String[] {resultCode+""});
		return res;
	}
}
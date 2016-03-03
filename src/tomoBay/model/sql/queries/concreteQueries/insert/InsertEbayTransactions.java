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
import java.util.ArrayList;
import java.util.List;

import tomoBay.model.sql.queries.AbstractInsertQuery;
/**
 * This class represents a query that inserts transaction data into the transactions table of
 * the database.
 * @author Jan P.C. Hanson
 *
 */
public  final class InsertEbayTransactions extends AbstractInsertQuery
{
	/**SQL query string**/
	private String query ="INSERT IGNORE INTO ebay_transactions "
			+ "(transactionID, orderID, itemID, quantity, price, shippingCost)"
			+ "VALUES (?,?,?,?,?,?);";
	
	/**
	 * default constructor
	 */
	public InsertEbayTransactions()
	{super();}
	
	/**
	 * execute the query
	 * @param parameter an array of strings where the 0th element is the parameter for the 
	 * first column, the 1st element is the parameter for the 2nd column and so on. 
	 * The Ebay Orders Table only has 4 columns so any element above the 3rd element will be ignored.
	 * - col1 = transactionID:bigint(20)
	 * - col2 = orderID:varchar(30)
	 * - col3 = itemID:bigint(20) 
	 * - col4 = quantity:int(7) 
	 * - col5 = price:float
	 * @return List<String[]> representing the results of the query. The list contains only 1 
	 * String[] which in turn contains only 1 element, this is the resultcode for the query.
	 * @throws SQLException
	 */
	public List<String[]> execute(String[] parameter) throws SQLException
	{
		List<String[]> res = new ArrayList<String[]>();
		this.initQuery(query);
		this.statement_M.setLong(1, Long.parseLong(parameter[0]));	//transactionID
		this.statement_M.setString(2, parameter[1]);				//orderID
		this.statement_M.setLong(3, Long.parseLong(parameter[2]));	//itemID
		this.statement_M.setInt(4, Integer.parseInt(parameter[3]));	//quantity
		this.statement_M.setFloat(5, Float.parseFloat(parameter[4]));//price
		this.statement_M.setFloat(6, Float.parseFloat(parameter[5]));//shipping cost
		
		int resultCode = statement_M.executeUpdate();
		this.cleanup();
		
		res.add(new String[] {resultCode+""});
		return res;
	}
}

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
 * This class represents a query that inserts buyer details into the database
 * @author Jan P.C. Hanson
 *
 */
public  final class InsertEbayBuyers extends AbstractInsertQuery
{
	/**SQL query string**/
	private String query ="INSERT IGNORE INTO ebay_buyers "
			+ "(buyerID, name, street1, street2, city, county, postcode, email, phoneNo)"
			+ "VALUES (?,?,?,?,?,?,?,?,?) "
			+ "ON DUPLICATE KEY UPDATE buyerID=values(buyerID), name=values(name), "
			+ "street1=values(street1), street2=values(street2), city=values(city), "
			+ "county=values(county), postcode=values(postcode), email=values(email), "
			+ "phoneNo=values(phoneNo);";
	
	/**
	 * default constructor
	 */
	public InsertEbayBuyers()
	{super();}
	
	/**
	 * execute the query
	 * @param parameter an array of strings where the 0th element is the parameter for the 
	 * first column, the 1st element is the parameter for the 2nd column and so on. 
	 * The Ebay Orders Table only has 3 columns so any element above the 2nd element will be ignored:
	 * - col1 =buyerID:varchar(40) 
	 * - col2=name:varchar(45) 
	 * - col3=address:varchar(150),  
	 * @return List<String[]> representing the results of the query. The list contains only 1 
	 * String[] which in turn contains only 1 element, this is the resultcode for the query.
	 * @throws SQLException
	 */
	public List<String[]> execute(String[] parameter) throws SQLException
	{
		List<String[]> res = new ArrayList<String[]>();
		super.initQuery(query);
		super.statement_M.setString(1, parameter[0]);//buyerID
		super.statement_M.setString(2, parameter[1]);//name
		super.statement_M.setString(3, parameter[2]);//street1
		super.statement_M.setString(4, parameter[3]);//street2
		super.statement_M.setString(5, parameter[4]);//city
		super.statement_M.setString(6, parameter[5]);//county
		super.statement_M.setString(7, parameter[6]);//postcode
		super.statement_M.setString(8, parameter[7]);//email
		super.statement_M.setString(9, parameter[8]);//phoneNo
		
		int resultCode = statement_M.executeUpdate();
		super.cleanup();
		
		res.add(new String[] {resultCode+""});
		
		return res;
	}
}
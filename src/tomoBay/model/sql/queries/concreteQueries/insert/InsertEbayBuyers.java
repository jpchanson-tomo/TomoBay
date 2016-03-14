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
import tomoBay.model.sql.schema.buyerTable.BuyerTable;
import tomoBay.model.sql.schema.nonDBFields.NonDBFields;
/**
 * This class represents a query that inserts buyer details into the database
 * @author Jan P.C. Hanson
 *
 */
public  final class InsertEbayBuyers extends AbstractModifyQuery
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
	public HeteroFieldContainer execute(HeteroFieldContainer parameter) throws SQLException
	{
		super.initQuery(query);
		super.statement_M.setString(1, parameter.get(BuyerTable.BUYERID, ClassRef.STRING));
		super.statement_M.setString(2, parameter.get(BuyerTable.NAME, ClassRef.STRING));
		super.statement_M.setString(3, parameter.get(BuyerTable.STREET1, ClassRef.STRING));
		super.statement_M.setString(4, parameter.get(BuyerTable.STREET2, ClassRef.STRING));
		super.statement_M.setString(5, parameter.get(BuyerTable.CITY, ClassRef.STRING));
		super.statement_M.setString(6, parameter.get(BuyerTable.COUNTY, ClassRef.STRING));
		super.statement_M.setString(7, parameter.get(BuyerTable.POSTCODE, ClassRef.STRING));
		super.statement_M.setString(8, parameter.get(BuyerTable.EMAIL, ClassRef.STRING));
		super.statement_M.setString(9, parameter.get(BuyerTable.PHONE, ClassRef.STRING));
		int resultCode = statement_M.executeUpdate();
		super.cleanup();
		
		parameter.add(NonDBFields.RESULT_CODE, resultCode);
		return parameter;
	}
}
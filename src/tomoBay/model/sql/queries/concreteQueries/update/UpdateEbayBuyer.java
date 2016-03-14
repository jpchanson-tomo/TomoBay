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
import tomoBay.model.sql.schema.buyerTable.BuyerTable;
import tomoBay.model.sql.schema.nonDBFields.NonDBFields;
/**
 *
 * @author Jan P.C. Hanson
 *
 */
public final class UpdateEbayBuyer extends AbstractModifyQuery
{
	/**SQL query string**/
	private String query = "UPDATE ebay_buyers SET name=?,street1=?,street2=?, city=?,county=?,"
							+ "postcode=?, email=?, phoneNo=? WHERE buyerID=?;";
	//
	/**
	 * default constructor
	 */
	public UpdateEbayBuyer()
	{super();}
	
	/**
	 * execute the query
	 * @param parameter 8 element array 
	 * @return List<String[]> representing the results of the query. Each element in the list
	 * represents a row of the database and each element of the String[] represents a field.
	 * 
	 * The available fields for each element of the string[] are:
	 * - col[0] = resultCode
	 * 
	 * @throws SQLException
	 */
	public HeteroFieldContainer execute(HeteroFieldContainer parameter) throws SQLException
	{
		this.initQuery(query);
		this.statement_M.setString(1, parameter.get(BuyerTable.NAME, ClassRef.STRING));
		this.statement_M.setString(2, parameter.get(BuyerTable.STREET1, ClassRef.STRING));
		this.statement_M.setString(3, parameter.get(BuyerTable.STREET2, ClassRef.STRING));
		this.statement_M.setString(4, parameter.get(BuyerTable.CITY, ClassRef.STRING));
		this.statement_M.setString(5, parameter.get(BuyerTable.COUNTY, ClassRef.STRING));
		this.statement_M.setString(6, parameter.get(BuyerTable.POSTCODE, ClassRef.STRING));
		this.statement_M.setString(7, parameter.get(BuyerTable.EMAIL, ClassRef.STRING));
		this.statement_M.setString(8, parameter.get(BuyerTable.PHONE, ClassRef.STRING));
		this.statement_M.setString(9, parameter.get(BuyerTable.BUYERID, ClassRef.STRING));
		
		int resultCode = this.statement_M.executeUpdate();
		this.cleanup();
		
		parameter.add(NonDBFields.RESULT_CODE, resultCode);
		return parameter;
	}
}
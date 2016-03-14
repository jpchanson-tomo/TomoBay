package tomoBay.model.sql.queries.concreteQueries.select.params;
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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tomoBay.model.dataTypes.heteroTypeContainer.ClassRef;
import tomoBay.model.dataTypes.heteroTypeContainer.HeteroFieldContainer;
import tomoBay.model.sql.queries.AbstractSelectParamsQuery;
import tomoBay.model.sql.schema.buyerTable.BuyerTable;
import tomoBay.model.sql.schema.ordersTable.OrdersTable;
/**
 *
 * @author Jan P.C. Hanson
 *
 */
public  final class SelectEbayBuyer extends AbstractSelectParamsQuery
{
	/**SQL query string**/
	private String query ="SELECT * FROM ebay_buyers WHERE buyerID=?";
	//
	/**
	 * default constructor
	 */
	public SelectEbayBuyer()
	{super();}
	
	/**
	 * execute the query
	 * @param parameter single element array containing the buyerID
	 * @return List<String[]> representing the results of the query. Each element in the list
	 * represents a row of the database and each element of the String[] represents a field.
	 * 
	 * The available fields for each element of the string[] are:
	 * - String[0] = buyerID
	 * - String[1] = name
	 * - String[2] = street1
	 * - String[3] = street2
	 * - String[4] = county
	 * - String[5] = city
	 * - String[6] = postcode
	 * - String[7] = email
	 * - String[8] = phone no
	 * 
	 * @throws SQLException
	 */
	public List<HeteroFieldContainer> execute(HeteroFieldContainer parameter) throws SQLException
	{
		super.initQuery(query);
		
		super.statement_M.setString(1, parameter.get(OrdersTable.BUYERID, ClassRef.STRING));
		
		ResultSet rs = super.statement_M.executeQuery();
		List<HeteroFieldContainer> selectResults = this.format(rs);

		super.cleanup();
		
		return selectResults;
	}
	
	/**
	 * formats the ResultSet (returned from the executed query) as a string
	 * @param results the ResultSet (post query execution)
	 * @return String containing the formatted results.
	 * @throws SQLException
	 */
	@Override
	protected List<HeteroFieldContainer> format(ResultSet results) throws SQLException
	{
		List<HeteroFieldContainer> rows = new ArrayList<HeteroFieldContainer>();
		while (results.next())
		{
			HeteroFieldContainer cols = new HeteroFieldContainer();
			cols.add(BuyerTable.BUYERID, results.getString("buyerID"));
			cols.add(BuyerTable.NAME, results.getString("name"));
			cols.add(BuyerTable.STREET1, results.getString("street1"));
			cols.add(BuyerTable.STREET2, results.getString("street2"));
			cols.add(BuyerTable.COUNTY, results.getString("county"));
			cols.add(BuyerTable.CITY, results.getString("city"));
			cols.add(BuyerTable.POSTCODE, results.getString("postcode"));
			cols.add(BuyerTable.EMAIL, results.getString("email"));
			cols.add(BuyerTable.PHONE, results.getString("phoneNo"));
			rows.add(cols);
		}
		return rows;
	}
}
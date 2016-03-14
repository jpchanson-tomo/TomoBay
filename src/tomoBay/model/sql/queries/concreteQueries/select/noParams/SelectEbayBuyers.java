package tomoBay.model.sql.queries.concreteQueries.select.noParams;
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

import tomoBay.model.dataTypes.heteroTypeContainer.HeteroFieldContainer;
import tomoBay.model.sql.queries.AbstractSelectNoParamsQuery;
import tomoBay.model.sql.schema.buyerTable.BuyerTable;
/**
 *
 * @author Jan P.C. Hanson
 *
 */
public final class SelectEbayBuyers extends AbstractSelectNoParamsQuery
{
	/**SQL query string**/
	private final String query ="SELECT * FROM ebay_buyers ORDER BY name ASC";
	
	/**
	 * default constructor
	 */
	public SelectEbayBuyers()
	{super();}
	
	/**
	 * execute the query
	 * @param NOTUSED
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
	@Override
	public List<HeteroFieldContainer> execute() throws SQLException
	{
		List<HeteroFieldContainer>  selectResults = this.format(super.initQuery(this.query));
		super.cleanup();
		
		return selectResults;
	}

	/* (non-Javadoc)
	 * @see tomoBay.model.sql.queries.AbstractSelectQueryNoParams#format(java.sql.ResultSet)
	 */
	@Override
	protected List<HeteroFieldContainer> format(ResultSet resultSet) throws SQLException
	{
		List<HeteroFieldContainer> rows = new ArrayList<HeteroFieldContainer>();
		while (resultSet.next())
		{
			HeteroFieldContainer cols = new HeteroFieldContainer();
			cols.add(BuyerTable.BUYERID, resultSet.getString("buyerID"));
			cols.add(BuyerTable.NAME, resultSet.getString("name"));
			cols.add(BuyerTable.STREET1, resultSet.getString("street1"));
			cols.add(BuyerTable.STREET2, resultSet.getString("street2"));
			cols.add(BuyerTable.COUNTY, resultSet.getString("county"));
			cols.add(BuyerTable.CITY, resultSet.getString("city"));
			cols.add(BuyerTable.POSTCODE, resultSet.getString("postcode"));
			cols.add(BuyerTable.EMAIL, resultSet.getString("email"));
			cols.add(BuyerTable.PHONE, resultSet.getString("phoneNo"));
			rows.add(cols);
		}
		return rows;
	}
}
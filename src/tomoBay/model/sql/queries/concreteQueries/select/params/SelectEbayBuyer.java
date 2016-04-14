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

import tomoBay.model.dataTypes.heteroTypeContainer.HeteroFieldContainer;
import tomoBay.model.sql.framework.QueryUtility;
import tomoBay.model.sql.framework.queryTypes.select.AbstractSelectParamsQuery;
import tomoBay.model.sql.schema.buyerTable.BuyerTable;
import tomoBay.model.sql.schema.ordersTable.OrdersTable;
/**
 * This class represents a query that selects all the information contained within the ebay_buyers
 * table, where the buyerID corresponds to the parameter provided to the execute(HeteroFieldContainer parameter) method.
 * 
 * This query takes the following parameter:
 * - OrdersTable.BUYERID
 * 
 * The query returns a List<HeteroFieldContainer> containing the following fields:
 * - BuyerTable.BUYERID
 * - BuyerTable.NAME
 * - BuyerTable.STREET1
 * - BuyerTable.STREET2
 * - BuyerTable.COUNTY
 * - BuyerTable.CITY
 * - BuyerTable.POSTCODE
 * - BuyerTable.EMAIL
 * - BuyerTable.PHONE
 * 
 * @author Jan P.C. Hanson
 *
 */
public  final class SelectEbayBuyer extends AbstractSelectParamsQuery
{
	/**SQL query string**/
	private static final String query ="SELECT * FROM ebay_buyers WHERE buyerID=?";
	
	/**
	 * default constructor
	 */
	public SelectEbayBuyer()
	{super();}
	
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

	/* (non-Javadoc)
	 * @see tomoBay.model.sql.framework.queryTypes.select.AbstractSelectParamsQuery#setParameters(tomoBay.model.dataTypes.heteroTypeContainer.HeteroFieldContainer)
	 */
	@Override
	protected void setParameters(HeteroFieldContainer parameter) throws ClassCastException, SQLException
	{QueryUtility.setVARCHARParam(this, parameter, OrdersTable.BUYERID, 1);}

	/* (non-Javadoc)
	 * @see tomoBay.model.sql.framework.queryTypes.AbstractDBQuery#queryString()
	 */
	@Override
	protected String queryString()
	{return SelectEbayBuyer.query;}
}
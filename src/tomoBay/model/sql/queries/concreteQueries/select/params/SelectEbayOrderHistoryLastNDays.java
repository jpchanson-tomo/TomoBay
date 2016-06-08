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
import tomoBay.model.sql.schema.itemsTable.ItemsTable;
import tomoBay.model.sql.schema.nonDBFields.NonDBFields;
/**
 * This class represents a query that displays the history of Listings ordered over the last N days. 
 * The parameter N is provided in the HeteroFieldContainer that this query takes in its execute()
 * method.
 * 
 * This query takes the following parameter field:
 * - **NonDBFields.Custom_INT_FIELD**	this represents N, the number of days to history to retrieve.
 * 
 * The query returns a List<HeteroFieldContainer> containing the following fields:
 * - **ItemsTable.PART_NO**	The composite part number that makes up this listing
 * - **NonDBFields.Custom_INT_FIELD** 	this represents the number of orders containing this listing
 * within the last N days
 *  
 * @author Jan P.C. Hanson
 *
 */
public final class SelectEbayOrderHistoryLastNDays extends AbstractSelectParamsQuery
{
	private static final String QUERY_M = 	"SELECT ebay_items.partNo,"+
														"COUNT(ebay_orders.orderID) AS noOfOrders "+ 
														"FROM ebay_orders "+
														"INNER JOIN ebay_transactions ON ebay_orders.orderID=ebay_transactions.orderID "+
														"INNER JOIN ebay_items ON ebay_transactions.itemID=ebay_items.itemID "+
														"WHERE ebay_items.account IS NOT NULL "+
														"AND ebay_orders.createdTime BETWEEN DATE_SUB(NOW(), INTERVAL ? DAY) AND NOW() "+
														"GROUP BY ebay_items.partNo;";

	/**
	 * default ctor
	 */
	public SelectEbayOrderHistoryLastNDays()
	{super();}

	/* (non-Javadoc)
	 * @see tomoBay.model.sql.framework.queryTypes.select.AbstractSelectParamsQuery#setParameters(tomoBay.model.dataTypes.heteroTypeContainer.HeteroFieldContainer)
	 */
	@Override
	protected void setParameters(HeteroFieldContainer parameter) throws ClassCastException, SQLException
	{QueryUtility.setINTEGERParam(this, parameter, NonDBFields.Custom_INT_FIELD, 1);}
	
	/* (non-Javadoc)
	 * @see tomoBay.model.sql.framework.queryTypes.select.AbstractSelectQuery#format(java.sql.ResultSet)
	 */
	@Override
	protected List<HeteroFieldContainer> format(ResultSet resultSet) throws SQLException
	{
		List<HeteroFieldContainer> rows = new ArrayList<HeteroFieldContainer>();
		while (resultSet.next())
		{
			HeteroFieldContainer cols = new HeteroFieldContainer();
			cols.add(ItemsTable.PART_NO, resultSet.getString("partNo"));
			cols.add(NonDBFields.Custom_INT_FIELD,resultSet.getInt("noOfOrders"));
			rows.add(cols);
		}
		return rows;
	}

	/* (non-Javadoc)
	 * @see tomoBay.model.sql.framework.queryTypes.AbstractDBQuery#queryString()
	 */
	@Override
	protected String queryString()
	{return SelectEbayOrderHistoryLastNDays.QUERY_M;}

}

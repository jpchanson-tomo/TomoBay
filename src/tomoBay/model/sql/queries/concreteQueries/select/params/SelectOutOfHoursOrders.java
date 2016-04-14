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
import tomoBay.model.sql.schema.nonDBFields.NonDBFields;
import tomoBay.model.sql.schema.ordersTable.OrdersTable;
import tomoBay.model.sql.schema.outOfHoursTable.OutOfHoursTable;
/**
 * this class represents a query that selects the sales record number, order total, created time 
 * and date for an order(via salesRecNo) that remains unsold after business hours on the date range
 * passed as parameters to the execute(HeteroFieldContainer parameter) method.
 * 
 * This query takes the following parameter:
 * - OutOfHoursTable.DATE
 * - NonDBFields.DATE_COMPARISON
 * 
 * The query returns a List<HeteroFieldContainer> containing the following fields:
 * - OutOfHoursTable.DATE
 * - OrdersTable.SALES_REC_NO
 * - OrdersTable.CREATED_TIME
 * - OrdersTable.ORDER_TOTAL
 * 
 * @author Jan P.C. Hanson
 *
 */
public  final class SelectOutOfHoursOrders extends AbstractSelectParamsQuery
{
	/**SQL query string**/
	private static final String query ="SELECT out_of_hours.date, ebay_orders.salesRecNo, ebay_orders.createdTime, ebay_orders.orderTotal "
						+ "FROM out_of_hours "
						+ "INNER JOIN ebay_orders ON out_of_hours.salesRecNo=ebay_orders.salesRecNo "
						+ "WHERE date>=? AND date<=?; ";
	//
	/**
	 * default constructor
	 */
	public SelectOutOfHoursOrders()
	{super();}
	
	/* (non-Javadoc)
	 * @see tomoBay.model.sql.queries.AbstractSelectQueryWithParams#format(java.sql.ResultSet)
	 */
	@Override
	protected List<HeteroFieldContainer> format(ResultSet results) throws SQLException
	{
		List<HeteroFieldContainer> rows = new ArrayList<HeteroFieldContainer>();
		while (results.next())
		{
			HeteroFieldContainer cols = new HeteroFieldContainer();
			cols.add(OutOfHoursTable.DATE, results.getDate("date"));
			cols.add(OrdersTable.SALES_REC_NO,results.getInt("salesRecNo"));
			cols.add(OrdersTable.CREATED_TIME,results.getTimestamp("createdTime"));
			cols.add(OrdersTable.ORDER_TOTAL,results.getFloat("orderTotal"));
			rows.add(cols);
		}
		return rows;
	}

	/* (non-Javadoc)
	 * @see tomoBay.model.sql.framework.queryTypes.select.AbstractSelectParamsQuery#setParameters(tomoBay.model.dataTypes.heteroTypeContainer.HeteroFieldContainer)
	 */
	@Override
	protected void setParameters(HeteroFieldContainer parameter) throws ClassCastException, SQLException
	{
		QueryUtility.setDATEParam(this, parameter, OutOfHoursTable.DATE, 1);
		QueryUtility.setDATEParam(this, parameter, NonDBFields.DATE_COMPARISON, 2);
	}

	/* (non-Javadoc)
	 * @see tomoBay.model.sql.framework.queryTypes.AbstractDBQuery#queryString()
	 */
	@Override
	protected String queryString()
	{return SelectOutOfHoursOrders.query;}
}
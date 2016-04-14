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
import tomoBay.model.sql.schema.ordersTable.OrdersTable;
/**
 * This class represents a query that selects all the fields from the ebay_orders table where the 
 * orderID is equal to the parameter passed in to the execute(HeteroFieldContainer parameter) method.
 * 
 * This query takes the following parameter field:
 * - OrdersTable.ORDER_ID
 * 
 * The query returns a List<HeteroFieldContainer> containing the following fields:
 * - OrdersTable.ORDER_ID
 * - OrdersTable.BUYERID
 * - OrdersTable.SALES_REC_NO
 * - OrdersTable.SHIPPING_TYPE
 * - OrdersTable.CREATED_TIME
 * - OrdersTable.INVOICED
 * - OrdersTable.ORDER_TOTAL
 * - OrdersTable.ACCOUNT
 * 
 * @author Jan P.C. Hanson
 *
 */
public  final class SelectEbayOrderByID extends AbstractSelectParamsQuery
{
	/**SQL query string**/
	private static final String query ="SELECT * "
			+ "FROM ebay_orders WHERE orderID=?";
	
	/**
	 * default constructor
	 */
	public SelectEbayOrderByID()
	{super();}
	

	/* (non-Javadoc)
	 * @see tomoBay.model.sql.framework.queryTypes.select.AbstractSelectParamsQuery#format(java.sql.ResultSet)
	 */
	@Override
	protected List<HeteroFieldContainer> format(ResultSet results) throws SQLException
	{
		List<HeteroFieldContainer> rows = new ArrayList<HeteroFieldContainer>();
		while (results.next())
		{
			HeteroFieldContainer cols = new HeteroFieldContainer();
			cols.add(OrdersTable.ORDER_ID, results.getString("orderID"));
			cols.add(OrdersTable.BUYERID,results.getString("buyerID"));
			cols.add(OrdersTable.SALES_REC_NO,results.getInt("salesRecNo"));
			cols.add(OrdersTable.SHIPPING_TYPE,results.getString("shippingType"));
			cols.add(OrdersTable.CREATED_TIME,results.getTimestamp("createdTime"));
			cols.add(OrdersTable.INVOICED,results.getInt("invoiced"));
			cols.add(OrdersTable.ORDER_TOTAL,results.getFloat("orderTotal"));
			cols.add(OrdersTable.ACCOUNT,results.getInt("account"));
			rows.add(cols);
		}
		return rows;
	}

	/* (non-Javadoc)
	 * @see tomoBay.model.sql.framework.queryTypes.select.AbstractSelectParamsQuery#setParameters(tomoBay.model.dataTypes.heteroTypeContainer.HeteroFieldContainer)
	 */
	@Override
	protected void setParameters(HeteroFieldContainer parameter) throws ClassCastException, SQLException
	{QueryUtility.setVARCHARParam(this, parameter, OrdersTable.ORDER_ID, 1);}

	/* (non-Javadoc)
	 * @see tomoBay.model.sql.framework.queryTypes.AbstractDBQuery#queryString()
	 */
	@Override
	protected String queryString()
	{return SelectEbayOrderByID.query;}
}
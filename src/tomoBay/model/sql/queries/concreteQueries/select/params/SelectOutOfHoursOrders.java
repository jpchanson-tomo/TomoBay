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
import tomoBay.model.sql.queries.AbstractSelectParamsQuery;
import tomoBay.model.sql.schema.nonDBFields.NonDBFields;
import tomoBay.model.sql.schema.ordersTable.OrdersTable;
import tomoBay.model.sql.schema.outOfHoursTable.OutOfHoursTable;
import tomoBay.model.dataTypes.heteroTypeContainer.ClassRef;
import tomoBay.model.dataTypes.heteroTypeContainer.HeteroFieldContainer;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Jan P.C. Hanson
 *
 */
public  final class SelectOutOfHoursOrders extends AbstractSelectParamsQuery
{
	/**SQL query string**/
	private String query ="SELECT out_of_hours.date, ebay_orders.salesRecNo, ebay_orders.createdTime, ebay_orders.orderTotal "
						+ "FROM out_of_hours "
						+ "INNER JOIN ebay_orders ON out_of_hours.salesRecNo=ebay_orders.salesRecNo "
						+ "WHERE date>=? AND date<=?; ";
	//
	/**
	 * default constructor
	 */
	public SelectOutOfHoursOrders()
	{super();}
	
	/**
	 * execute the query
	 * @param startAndEnd define the date range to look for orders in:
	 * 
	 * The available fields are:
	 * - cols[0] = start date (inclusive) 'yyyy-mm-dd'
	 * - cols[1] = end date (inclusive) 'yyyy-mm-dd'
	 * 
	 * @return List<HeteroFieldContainer> representing the results of the query. Each element in the list
	 * represents a row of the database and each element of the HeteroFieldContainer represents a field.
	 * 
	 * The available fields for each element of the HeteroFieldContainer are:
	 * - cols[0] = Date of out of hours 
	 * - cols[1] = sales record number (integer)
	 * - cols[2] = createdTime (timestamp/string)
	 * - cols[3] = orderTotalPrice double/float;
	 * @throws SQLException
	 */
	public List<HeteroFieldContainer> execute(HeteroFieldContainer startAndEnd) throws SQLException
	{
		super.initQuery(query);
		
		super.statement_M.setDate(1, startAndEnd.get(OutOfHoursTable.DATE, ClassRef.DATE));
		super.statement_M.setDate(2, startAndEnd.get(NonDBFields.DATE_COMPARISON, ClassRef.DATE));
		
		ResultSet rs = this.statement_M.executeQuery();
		List<HeteroFieldContainer> selectResults = this.format(rs);

		super.cleanup();
		
		return selectResults;
	}
	
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
}
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
import tomoBay.model.sql.schema.nonDBFields.NonDBFields;
import tomoBay.model.sql.schema.ordersTable.OrdersTable;
/**
 * This class represents a query that updates the 'invoiced' field of particular order on the 
 * orders table of the database with appropriate data:
 * - 0 = not invoiceable
 * - 1 = partially invoiceable
 * - 2 = order has been invoiced 
 * @author Jan P.C. Hanson
 *
 */
public  final class UpdateInvoiceStatus extends AbstractModifyQuery
{
	/**SQL query string**/
	private String query ="UPDATE ebay_orders SET invoiced=? WHERE orderID=?";
	
	/**
	 * default constructor
	 */
	public UpdateInvoiceStatus()
	{super();}
	
	/**
	 * execute the query
	 * @param parameter The list contains only 2
	 * elements 1st element is invoiced status (0=not invoiceable, 1=partially invoiceable,
	 * 3=invoiced), the second element is the orderID
	 * @return List<String[]> representing the results of the query. The list contains only 1 
	 * String[] which in turn contains only 1 element, this is the resultcode for the query.
	 * @throws SQLException
	 */
	public HeteroFieldContainer execute(HeteroFieldContainer parameter) throws SQLException
	{
		super.initQuery(query);
		super.statement_M.setInt(1, parameter.get(OrdersTable.INVOICED, ClassRef.INTEGER));
		super.statement_M.setString(2, parameter.get(OrdersTable.ORDER_ID, ClassRef.STRING));
		
		int resultCode = statement_M.executeUpdate();
		super.cleanup();
		
		parameter.add(NonDBFields.RESULT_CODE, resultCode);
		return parameter;
	}
}
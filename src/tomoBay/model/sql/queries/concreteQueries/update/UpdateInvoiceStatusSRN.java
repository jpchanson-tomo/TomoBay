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

import tomoBay.model.dataTypes.heteroTypeContainer.HeteroFieldContainer;
import tomoBay.model.sql.framework.QueryUtility;
import tomoBay.model.sql.framework.queryTypes.modify.AbstractModifyQueryParams;
import tomoBay.model.sql.schema.ordersTable.OrdersTable;
/**
 * This class represents a query that updates the invoice status of a particular order.
 * 
 * This query takes the following parameters:
 * - OrdersTable.INVOICED
 * - OrdersTable.SALES_REC_NO
 * 
 * These should be stored in a HeteroFieldContainer and passed to the execute(HeteroFieldContainer parameters) 
 * method in order to run the query.
 * 
 * @author Jan P.C. Hanson
 *
 */
public  final class UpdateInvoiceStatusSRN extends AbstractModifyQueryParams
{
	/**SQL query string**/
	private static final String query ="UPDATE ebay_orders SET invoiced=? WHERE salesRecNo=? AND account=?";
	
	/**
	 * default constructor
	 */
	public UpdateInvoiceStatusSRN()
	{super();}

	/* (non-Javadoc)
	 * @see tomoBay.model.sql.framework.queryTypes.modify.AbstractModifyQueryParams#queryString()
	 */
	@Override
	protected String queryString()
	{return UpdateInvoiceStatusSRN.query;}

	/* (non-Javadoc)
	 * @see tomoBay.model.sql.framework.queryTypes.modify.AbstractModifyQueryParams#setParameters(tomoBay.model.dataTypes.heteroTypeContainer.HeteroFieldContainer)
	 */
	@Override
	protected void setParameters(HeteroFieldContainer parameter) throws ClassCastException, SQLException
	{
		QueryUtility.setINTEGERParam(this, parameter, OrdersTable.INVOICED, 1);
		QueryUtility.setINTEGERParam(this, parameter, OrdersTable.SALES_REC_NO, 2);
		QueryUtility.setINTEGERParam(this, parameter, OrdersTable.ACCOUNT, 3);
	}
}
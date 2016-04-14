package tomoBay.model.sql.queries.concreteQueries.insert;
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
import tomoBay.model.sql.schema.orderStatusTable.OrderStatusTable;
/**
 * This Class represents a Query that inserts an order into the order_status table in the database.
 * 
 * This Query requires the following parameters:
 * - OrderStatusTable.ORDER_ID
 * 
 * Which should be passed to the execute(HeteroFieldContainer parameters)
 * 
 * @author Jan P.C. Hanson
 *
 */
public final class InsertOrderInOrderStatus extends AbstractModifyQueryParams
{
	private static final String query_M = "INSERT INTO order_status(orderID) VALUES(?);";
	
	/**
	 * default ctor
	 */
	public InsertOrderInOrderStatus()
	{super();}

	/* (non-Javadoc)
	 * @see tomoBay.model.sql.framework.queryTypes.modify.AbstractModifyQueryParams#queryString()
	 */
	@Override
	protected String queryString()
	{return InsertOrderInOrderStatus.query_M;}

	/* (non-Javadoc)
	 * @see tomoBay.model.sql.framework.queryTypes.modify.AbstractModifyQueryParams#setParameters(tomoBay.model.dataTypes.heteroTypeContainer.HeteroFieldContainer)
	 */
	@Override
	protected void setParameters(HeteroFieldContainer parameter) throws ClassCastException, SQLException
	{QueryUtility.setVARCHARParam(this, parameter, OrderStatusTable.ORDER_ID, 1);}

}
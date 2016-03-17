package tomoBay.model.services.outOfHoursService;

import java.util.List;

import tomoBay.helpers.checkTime.CheckTime;
import tomoBay.model.dataTypes.heteroTypeContainer.ClassRef;
import tomoBay.model.dataTypes.heteroTypeContainer.HeteroFieldContainer;
import tomoBay.model.services.AbstractServiceState;
import tomoBay.model.sql.queries.ModifyQueryInvoker;
import tomoBay.model.sql.queries.ModifyQueryInvoker.QueryType;
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
import tomoBay.model.sql.queries.SelectQueryInvoker;
import tomoBay.model.sql.queries.SelectQueryInvoker.SelectQueryTypeNoParams;
import tomoBay.model.sql.schema.ordersTable.OrdersTable;
import tomoBay.model.sql.schema.outOfHoursTable.OutOfHoursTable;

/**
 *
 * @author Jan P.C. Hanson
 *
 */
public final class OnRunning implements AbstractServiceState
{

	/**
	 * default ctor
	 */
	public OnRunning()
	{super();}

	/* (non-Javadoc)
	 * @see tomoBay.model.services.AbstractServiceState#execute()
	 */
	@Override
	public String execute()
	{
		final List<HeteroFieldContainer> results = SelectQueryInvoker.execute(SelectQueryTypeNoParams.SELECT_UNINVOICED_ORDERS);
		String orders="";
		for (HeteroFieldContainer data : results)
		{
			HeteroFieldContainer params = new HeteroFieldContainer();
			params.add(OutOfHoursTable.SALES_REC_NO, data.get(OrdersTable.SALES_REC_NO, ClassRef.INTEGER));
			params.add(OutOfHoursTable.DATE, this.getDate());
			ModifyQueryInvoker.execute(QueryType.INSERT_OUT_OF_HOURS, params);
			orders+=data.get(OrdersTable.SALES_REC_NO, ClassRef.INTEGER)+", ";
		}
		return "Exiting: "+orders+" in Out of Hours table";
	}

	/**
	 * 
	 * @return
	 */
	private java.sql.Date getDate()
	{return new java.sql.Date(CheckTime.OutOfHoursDate().getTime());}
}

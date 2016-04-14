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
import tomoBay.model.sql.schema.outOfHoursTable.OutOfHoursTable;
/**
 * This class represents a query that inserts a new entry into the outOfHours table in the database.
 * 
 * This query takes the following parameters:
 * - OutOfHoursTable.SALES_REC_NO
 * - OutOfHoursTable.DATE
 * 
 * These should be wrapped in a HeteroFieldContainer and passed to the execute(HeteroFieldContainer parameters)
 * method in order to run the query.
 * 
 * @author Jan P.C. Hanson
 *
 */
public  final class InsertOutOfHoursOrders extends AbstractModifyQueryParams
{
	/**SQL query string**/
	private static final String query ="INSERT IGNORE INTO out_of_hours (salesRecNo, date)"
			+ "VALUES (?,?);";
	
	/**
	 * default constructor
	 */
	public InsertOutOfHoursOrders()
	{super();}

	/* (non-Javadoc)
	 * @see tomoBay.model.sql.framework.queryTypes.modify.AbstractModifyQueryParams#queryString()
	 */
	@Override
	protected String queryString()
	{return InsertOutOfHoursOrders.query;}

	/* (non-Javadoc)
	 * @see tomoBay.model.sql.framework.queryTypes.modify.AbstractModifyQueryParams#setParameters(tomoBay.model.dataTypes.heteroTypeContainer.HeteroFieldContainer)
	 */
	@Override
	protected void setParameters(HeteroFieldContainer parameter) throws ClassCastException, SQLException
	{
		QueryUtility.setINTEGERParam(this, parameter, OutOfHoursTable.SALES_REC_NO, 1);
		QueryUtility.setDATEParam(this, parameter, OutOfHoursTable.DATE, 2);
	}
}
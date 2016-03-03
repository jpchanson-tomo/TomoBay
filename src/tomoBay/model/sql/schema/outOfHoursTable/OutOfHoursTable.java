package tomoBay.model.sql.schema.outOfHoursTable;
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
import tomoBay.model.dataTypes.dbSchema.AbstractDBField;
import tomoBay.model.dataTypes.dbSchema.AbstractDBSchema;

import tomoBay.model.sql.schema.ordersTable.OrdersTable;
/**
 * This class represents the out_of_hours table in the database implementation
 * 
 * @author Jan P.C. Hanson
 *
 */
public class OutOfHoursTable implements AbstractDBSchema
{
	/**
	 * the salesRecNo field in the out_of_hours table INT(10) [PK]
	 * @see {@link tomoBay.model.sql.schema.outOfHoursTable.SalesRecNo}
	 **/
	public static final AbstractDBField SALES_REC_NO = OrdersTable.SALES_REC_NO;
	
	/**
	 * the date field in the out_of_hours table DATE [PK]
	 * @see {@link tomoBay.model.sql.schema.outOfHoursTable.Date}
	 **/
	public static final Date DATE = new Date();
}

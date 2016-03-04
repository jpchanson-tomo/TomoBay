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
import tomoBay.model.dataTypes.dbSchema.AbstractField;
import tomoBay.model.dataTypes.dbSchema.AbstractTypeSchema;

import tomoBay.model.sql.schema.ordersTable.OrdersTable;
/**
 * This class represents the out_of_hours table in the database implementation
 * 
 * @author Jan P.C. Hanson
 *
 */
public class OutOfHoursTable implements AbstractTypeSchema
{
	/**
	 * the salesRecNo field in the out_of_hours table of the database, this is part of a composite 
	 * primary key for the out_of_hours table and a foreign key for the ebay_orders table.
	 * - INTEGER(10)
	 * - Primary Key
	 * - Foreign Key ebay_orders table
	 * 
	 * @see tomoBay.model.sql.schema.ordersTable.SalesRecNo
	 * @see tomoBay.model.sql.schema.ordersTable.OrdersTable
	 **/
	public static final AbstractField SALES_REC_NO = OrdersTable.SALES_REC_NO;
	
	/**
	 * the date field in the out_of_hours table of the database. This is the second part of the composite
	 * primary key for this table.
	 * - DATE()
	 * - Primary Key
	 * 
	 * @see tomoBay.model.sql.schema.outOfHoursTable.Date
	 **/
	public static final Date DATE = new Date();
	
	/**
	 * private ctor ensures this class is NEVER INSTANTIATED
	 */
	private OutOfHoursTable()
	{super();}
}

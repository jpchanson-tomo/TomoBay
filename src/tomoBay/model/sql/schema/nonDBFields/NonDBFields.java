package tomoBay.model.sql.schema.nonDBFields;

import tomoBay.model.dataTypes.heteroTypeContainer.AbstractTypeSchema;
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
import tomoBay.model.sql.schema.outOfHoursTable.Date;

/**
 *
 * @author Jan P.C. Hanson
 *
 */
public class NonDBFields implements AbstractTypeSchema
{
	/**
	 * this is a return value from an insert or update query it is an integer value
	 * - Integer
	 * - NON DB FIELD
	 */
	public static final ResultCode RESULT_CODE = new ResultCode();
	
	/**
	 * this is a Date field that can be used as a comparison value against the OutOfHoursTable.Date
	 * - Date
	 * - NON DB FIELD (indirect)
	 */
	public static final Date DATE_COMPARISON = new Date();

	/**
	 * this is an input or return to/from a custom integer field, i.e. one defined in a 
	 * query but is not directly a database field.
	 * - INTEGER
	 * - NON DB FIELD
	 */
	public static final CustomIntegerField Custom_INT_FIELD = new CustomIntegerField();
	
	/**
	 * ensures that this class is NEVER INSTANTIATED
	 */
	private NonDBFields()
	{super();}

}

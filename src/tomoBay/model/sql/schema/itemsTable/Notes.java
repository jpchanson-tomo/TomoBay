package tomoBay.model.sql.schema.itemsTable;
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
import tomoBay.model.dataTypes.heteroTypeContainer.AbstractField;
import tomoBay.model.dataTypes.heteroTypeContainer.TypeDef;
/**
 * This is the notes field of the ebay_items table in the database. This field represents whether
 * there is an error with a particular listing or not, and if there is; what type of error it is.
 * This field could potentially be used for other information as well. 
 * - Type: VARCHAR
 * - Size: 60
 * 
 * @note it is probably worth(at some point) making this field an integer value as a foreign key to
 * to a notes table.
 * 
 * @author Jan P.C. Hanson
 *
 */
public final class Notes implements AbstractField
{
	/**the size of this field**/
	private static final int size_M = 60;

	/**
	 * dfefault ctor
	 */
	public Notes()
	{super();}

	/* (non-Javadoc)
	 * @see tomoBay.model.dataTypes.dbSchema.AbstractDBField#type()
	 */
	@Override
	public String type()
	{return TypeDef.STRING;}

	/* (non-Javadoc)
	 * @see tomoBay.model.dataTypes.dbSchema.AbstractDBField#size()
	 */
	@Override
	public int size()
	{return Notes.size_M;}
}
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
 * this is the condition field of the ebay_items table, this field represents the selling condition
 * of the listing.
 * - Type: VARCHAR
 * - Size: 15
 * @author Jan P.C. Hanson
 *
 */
public final class Condition implements AbstractField
{
	/**the size of this field**/
	private static final int size_M = 15;

	/**
	 * dfefault ctor
	 */
	public Condition()
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
	{return Condition.size_M;}
}
package tomoBay.model.sql.schema.nonDBFields;
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
import tomoBay.model.dataTypes.heteroTypeContainer.TypeDef;
import tomoBay.model.dataTypes.heteroTypeContainer.AbstractField;
/**
 *	This class represents the input or return to/from a custom integer field, i.e. one defined in a 
 * query but is not directly a database field. 
 *
 *	- Type: Integer
 * - Size: -1 i.e. the size should not be taken as representative of the actual size of this field as
 * it may change
 *  * 
 * @author Jan P.C. Hanson
 *
 */
public final class CustomIntegerField implements AbstractField
{
	private static final int SIZE_M = -1;
	/**
	 * default ctor
	 */
	public CustomIntegerField()
	{super();}

	/* (non-Javadoc)
	 * @see tomoBay.model.dataTypes.heteroTypeContainer.AbstractField#type()
	 */
	@Override
	public String type()
	{return TypeDef.INTEGER;}

	/* (non-Javadoc)
	 * @see tomoBay.model.dataTypes.heteroTypeContainer.AbstractField#size()
	 */
	@Override
	public int size()
	{return CustomIntegerField.SIZE_M;}

}

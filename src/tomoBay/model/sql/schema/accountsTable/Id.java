package tomoBay.model.sql.schema.accountsTable;
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
 * This represents the id field of the ebay_accounts table in the database. This is the primary key 
 * of this table and is an arbitrary auto incremented integer with no physical significance other than
 * uniquely identifying a database record
 * - Primary Key
 * - Type: INT
 * - Size: 3
 * 
 * @author Jan P.C. Hanson
 *
 */
public final class Id implements AbstractField
{
	/**the size of this field**/
	private static final int size_M = 3;

	/**
	 * dfefault ctor
	 */
	public Id()
	{super();}

	/* (non-Javadoc)
	 * @see tomoBay.model.dataTypes.dbSchema.AbstractDBField#type()
	 */
	@Override
	public String type()
	{return TypeDef.INTEGER;}

	/* (non-Javadoc)
	 * @see tomoBay.model.dataTypes.dbSchema.AbstractDBField#size()
	 */
	@Override
	public int size()
	{return Id.size_M;}
}
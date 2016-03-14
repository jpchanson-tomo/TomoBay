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
 * this is the brand field of the ebay_items table in the database. This field represents the brand 
 * of the part being sold.
 * 
 * It is worth noting that the information for this field comes from the eBay API, under ItemType -> item
 * specifics. The system will not pick up brand information unless it is in the Brand field of the 
 * eBay listing
 * - Type: VARCHAR
 * - Size: 50
 * @author Jan P.C. Hanson
 */
public final class Brand implements AbstractField
{
	/**the size of this field**/
	private static final int size_M = 50;

	/**
	 * dfefault ctor
	 */
	public Brand()
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
	{return Brand.size_M;}
}
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
 * This is the partNo field of the ebay_items table in the database. it represents the part number
 * associated with a particular product that is part of a listing. 
 * - Type: VARCHAR
 * - Size: 55
 * 
 * @par Format 
 * Multiple part numbers can be used as part of this field but if this is the case then the 
 * part numbers must obey the following format restrictions: 
 * 
 * - 1a2b34cd(1)2134l34k3(5)sdf3432(2) this would denote 3 parts, the first part has a quantity of 1
 * the second part has a quantity of 5 and the third part has a quantity of 5  
 * 
 * - 1a2b34cd(1)2134l34k3(5)sdf3432 this would denote 3 parts, the first part has a quantity of 1 the
 * second part has a quantity of 5 and the third part has a quantity of 1. The last part number is 
 * permitted to be without a quantity value IFF it has a quantity of 1.  
 * 
 * - 1a2b34cd(10) this would denote 1 part with a quantity of 10.  
 * 
 * - 1a2b34cd 1 unit of a single part 
 * 
 * 
 * @author Jan P.C. Hanson
 *
 */
public final class PartNo implements AbstractField
{
	/**the size of this field**/
	private static final int size_M = 55;

	/**
	 * dfefault ctor
	 */
	public PartNo()
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
	{return PartNo.size_M;}
}
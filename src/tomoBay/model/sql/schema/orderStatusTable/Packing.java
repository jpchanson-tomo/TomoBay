package tomoBay.model.sql.schema.orderStatusTable;

import tomoBay.model.dataTypes.heteroTypeContainer.AbstractField;
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

/**
 * this is the packing field of the order_status table in the database. It takes a binary value, 
 * 0 means that this order has not yet been packed, 1 indicates that it has been packed.
 * - TINYINT(1)
 * @author Jan P.C. Hanson
 *
 */
public final class Packing implements AbstractField
{
	/**
	 * default ctor
	 */
	public Packing()
	{super();}

	/* (non-Javadoc)
	 * @see tomoBay.model.dataTypes.heteroTypeContainer.AbstractField#type()
	 */
	@Override
	public String type()
	{return TypeDef.BOOLEAN;}

	/* (non-Javadoc)
	 * @see tomoBay.model.dataTypes.heteroTypeContainer.AbstractField#size()
	 */
	@Override
	public int size()
	{return 1;}
}
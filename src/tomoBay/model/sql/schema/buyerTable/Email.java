package tomoBay.model.sql.schema.buyerTable;
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
import tomoBay.model.dataTypes.dbSchema.TypeDef;
/**
 * The email field of the ebay_buyers table in the database. i.e. the email address that the buyer
 * registered with eBay.
 * - Type: VARCHAR
 * - Size: 100
 * @author Jan P.C. Hanson
 *
 */
public class Email implements AbstractField
{
	/**the size of this field**/
	private static final int size_M = 100;
	
	/**
	 * default ctor
	 */
	public Email()
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
	{return Email.size_M;}
}
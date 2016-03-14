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
 * This represents the apiKey field in the ebay_accounts table of the database. This field stores the
 * api key associated with this account. needed for authenticating ebay api calls
 * - Type: VARCHAR
 * - Size: 900
 * @author Jan P.C. Hanson
 *
 */
public final class ApiKey implements AbstractField
{
	/**the size of this field**/
	private static final int size_M = 900;

	/**
	 * dfefault ctor
	 */
	public ApiKey()
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
	{return ApiKey.size_M;}
}
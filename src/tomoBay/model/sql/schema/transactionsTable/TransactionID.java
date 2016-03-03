package tomoBay.model.sql.schema.transactionsTable;
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
import tomoBay.model.dataTypes.dbSchema.DBType;
import tomoBay.model.dataTypes.dbSchema.AbstractDBField;
/**
 * This class represents the transactionID field of the ebay_transactions table in the database
 * - Type: BIGINT
 * - SIZE: 20
 * - [PK]
 * @author Jan P.C. Hanson
 *
 */
final class TransactionID implements AbstractDBField
{
	/**the size of this field**/
	private static final int size_M = 20;

	/**
	 * dfefault ctor
	 */
	public TransactionID()
	{super();}

	/* (non-Javadoc)
	 * @see tomoBay.model.dataTypes.dbSchema.AbstractDBField#type()
	 */
	@Override
	public String type()
	{return DBType.BIGINT;}

	/* (non-Javadoc)
	 * @see tomoBay.model.dataTypes.dbSchema.AbstractDBField#size()
	 */
	@Override
	public int size()
	{return TransactionID.size_M;}
}
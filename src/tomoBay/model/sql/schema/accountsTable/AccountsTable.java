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
import tomoBay.model.dataTypes.dbSchema.AbstractDBSchema;
/**
 *
 * @author Jan P.C. Hanson
 *
 */
public class AccountsTable implements AbstractDBSchema
{
	/****/
	public static final Id ID = new Id();
	/****/
	public static final ApiKey API_KEY = new ApiKey();
	/****/
	public static final ServerAddr SERVER_ADDR = new ServerAddr();
	/****/
	public static final AccountName ACCOUNT_NAME = new AccountName();
	/****/
	public static final LookbackDays ITEM_ID = new LookbackDays();

	/**
	 * private Ctor ensures this class is never instantiated
	 */
	public AccountsTable()
	{super();}

}

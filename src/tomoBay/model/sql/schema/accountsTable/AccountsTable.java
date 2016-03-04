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
import tomoBay.model.dataTypes.dbSchema.AbstractTypeSchema;
/**
 * This represents the structure of the ebay_accounts table in the database. The static values 
 * contained inside this class are for use with the tomoBay.model.dataTypes.dbSchema.HeteroFieldContainer
 * @author Jan P.C. Hanson
 *
 */
public class AccountsTable implements AbstractTypeSchema
{
	/**
	 * The id field of the ebay_accounts table 
	 * - INT(3) 
	 * - [PK]
	 * @see tomoBay.model.sql.schema.accountsTable.Id
	 **/
	public static final Id ID = new Id();
	/**
	 * the accountName field of the ebay_accounts table 
	 * - VARCHAR(20)
	 * @see tomoBay.model.sql.schema.accountsTable.ApiKey
	 **/
	public static final ApiKey API_KEY = new ApiKey();
	/**
	 * the apiKey field of the ebay_accounts table 
	 * - VARCHAR(900)
	 * @see tomoBay.model.sql.schema.accountsTable.ServerAddr
	 **/
	public static final ServerAddr SERVER_ADDR = new ServerAddr();
	/**
	 * the serverAddr field of the ebay_accounts table
	 * - VARCHAR(45)
	 * @see tomoBay.model.sql.schema.accountsTable.AccountName
	 */
	public static final AccountName ACCOUNT_NAME = new AccountName();
	/**
	 * the accountName field of the ebay_accounts table
	 * - VARCHAR(20)
	 * @see tomoBay.model.sql.schema.accountsTable.LookbackDays
	 */
	public static final LookbackDays ITEM_ID = new LookbackDays();

	/**
	 * private Ctor ensures this class is NEVER INSTANTIATED
	 */
	public AccountsTable()
	{super();}
}

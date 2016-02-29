package tomoBay.model.eBayAPI;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import tomoBay.model.sql.queries.QueryInvoker;
import tomoBay.model.sql.queries.QueryInvoker.QueryType;

/**
 * This class provides static access to information on the ebay accounts that have been registered
 * with the system.
 * @author Jan P.C. Hanson
 *
 */
public final class EbayAccounts
{
	/**internal map of maps holding the account info**/
	private static Map<String, Map<AccountInfo,String>> accountMap_M
						= EbayAccounts.listToMap(QueryInvoker.execute(QueryType.SELECT_ACCOUNTS, null));
	/**public enum defining the data fields**/
	public enum AccountInfo {ID, API_KEY, SERVER_ADDRESS, LOOKBACK_DAYS}
	
	/**
	 * private ctor so that this class can never be instantiated
	 */
	private EbayAccounts()
	{super();}
	
	/**
	 * @return String[] containing the names of all the accounts that are currently registered on the
	 * system.
	 */
	public static String[] accounts()
	{
		String[] accountNames = new String[EbayAccounts.accountMap_M.size()];
		accountNames = EbayAccounts.accountMap_M.keySet().toArray(accountNames);
		return accountNames;
	}
	
	public static String name(int id)
	{
		for(Map.Entry<String,Map<AccountInfo, String>> entry : EbayAccounts.accountMap_M.entrySet()) 
		{if(entry.getValue().containsValue(String.valueOf(id)))	{return entry.getKey();}}
		return"ID not found";
	}
	/**
	 * allows for the retrieval of specific data fields for accounts that are currently registered on
	 * the system. the public enum EbayAccounts.AccountInfo contains the fields that can be retrieved
	 * @param accountName the name of the account to fetch info from. If you need a list of account
	 * names please refer to EbayAccounts.accounts()
	 * @param field the data field to retrieve, as defined in the EbayAccounts.AccountInfo enum type
	 * @return String containing the requested data field.
	 */
	public static String get(String accountName, AccountInfo field)
	{return EbayAccounts.accountMap_M.get(accountName.toLowerCase()).get(field);}

	
	public static boolean registerAccount(String accountName, String apiKey, String server, int lookback) 
	{
		/**@TODO use query to add account to database**/
		EbayAccounts.refresh();
		return false;
	}
	
	/**
	 * refresh the account information.
	 */
	public static void refresh()
	{accountMap_M = EbayAccounts.listToMap(QueryInvoker.execute(QueryType.SELECT_ACCOUNTS, null));}
	
	/**
	 * 
	 * @param rawInput
	 * @return
	 */
	private static Map<String,Map<AccountInfo,String>> listToMap(List<String[]> rawInput)
	{
		Map<String,Map<AccountInfo,String>> result = new HashMap<String,Map<AccountInfo,String>>();
		for (String[] input : rawInput) 
		{
			Map<AccountInfo, String> info = new HashMap<AccountInfo,String>();
			info.put(AccountInfo.ID, input[0]);
			info.put(AccountInfo.API_KEY, input[2]);
			info.put(AccountInfo.SERVER_ADDRESS, input[3]);
			info.put(AccountInfo.LOOKBACK_DAYS, input[4]);
			
			result.put(input[1], info);
		}
		return result;
	}
}

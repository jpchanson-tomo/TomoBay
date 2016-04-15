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
import java.util.List;

import tomoBay.model.dataTypes.heteroTypeContainer.ClassRef;
import tomoBay.model.dataTypes.heteroTypeContainer.HeteroFieldContainer;
import tomoBay.model.sql.framework.SelectQueryInvoker;
import tomoBay.model.sql.framework.SelectQueryInvoker.SelectQueryTypeNoParams;
import tomoBay.model.sql.schema.accountsTable.AccountsTable;

/**
 * This class provides static access to information on the ebay accounts that have been registered
 * with the system.
 * @author Jan P.C. Hanson
 *
 */
public final class EbayAccounts
{
	/**heterofieldcontainer holding the account information**/
	private static List<HeteroFieldContainer> accountInfo_M 
										= SelectQueryInvoker.execute(SelectQueryTypeNoParams.SELECT_ACCOUNTS);
	
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
		String[] accountNames = new String[EbayAccounts.accountInfo_M.size()];
		for(int i=0 ; i<accountInfo_M.size() ; ++i) 
		{accountNames[i]=EbayAccounts.accountInfo_M.get(i).get(AccountsTable.ACCOUNT_NAME, ClassRef.STRING);}
		return accountNames;
	}
	
	/**
	 * convert an account ID to a textual name value.
	 * @param id the id of the account as it is on the database
	 * @return String containg a textual name for this account
	 */
	public static String name(int id)
	{
		for(int i=0 ; i<accountInfo_M.size() ; ++i) 
		{
			if(EbayAccounts.accountInfo_M.get(i).get(AccountsTable.ID, ClassRef.INTEGER)==id)	
			{return EbayAccounts.accountInfo_M.get(i).get(AccountsTable.ACCOUNT_NAME, ClassRef.STRING);}
		}
		throw new IllegalArgumentException("accountID "+id+" not found");
	}
	
	/**
	 * retrieve the id for the account name specified
	 * @param accountName the account name to find the id of
	 * @return int the id of the account specified
	 */
	public static int id (String accountName)
	{
		for(int i=0 ; i<accountInfo_M.size() ; ++i) 
		{
			if(EbayAccounts.accountInfo_M.get(i).get(AccountsTable.ACCOUNT_NAME, ClassRef.STRING).equalsIgnoreCase(accountName.trim()))	
			{return EbayAccounts.accountInfo_M.get(i).get(AccountsTable.ID, ClassRef.INTEGER);}
		}
		throw new IllegalArgumentException("account "+accountName+" not found");
	}
	
	/**
	 * retrieve the ebay api key for the account name specified
	 * @param  accountNamethe account name to find the api key of
	 * @return String containing the ebay api key for the account specified
	 */
	public static String apiKey (String accountName)
	{
		String targetAccount = accountName.trim();
		String currentAccount;
		
		for(int i=0 ; i<accountInfo_M.size() ; ++i) 
		{
			currentAccount 
			= EbayAccounts.accountInfo_M.get(i).get(AccountsTable.ACCOUNT_NAME, ClassRef.STRING).trim();
			
			if(currentAccount.equalsIgnoreCase(targetAccount))	
			{return EbayAccounts.accountInfo_M.get(i).get(AccountsTable.API_KEY, ClassRef.STRING);}
		}
		throw new IllegalArgumentException("account "+accountName+" not found");
	}

	/**
	 * retrieve the ebay server address for the account name specified
	 * @param accountName the account name to find the ebay server address of
	 * @return String containing the ebay server address for the account specified
	 */
	public static String serverAddress(String accountName)
	{
		String targetAccount = accountName.trim();
		String currentAccount;
		
		for(int i=0 ; i<accountInfo_M.size() ; ++i) 
		{
			currentAccount 
			= EbayAccounts.accountInfo_M.get(i).get(AccountsTable.ACCOUNT_NAME, ClassRef.STRING).trim();
			
			if(currentAccount.equalsIgnoreCase(targetAccount))	
			{return EbayAccounts.accountInfo_M.get(i).get(AccountsTable.SERVER_ADDR, ClassRef.STRING);}
		}
		throw new IllegalArgumentException("account "+accountName+" not found");
	}
	
	/**
	 * retrieve the number of days previous to the current day that the system should retrieve orders
	 * from the ebay API for. 
	 * @param accountName the account name to find this value for
	 * @return int representing the number of lookback days
	 */
	public static int lookbackDays(String accountName)
	{
		String targetAccount = accountName.trim();
		String currentAccount;
		
		for(int i=0 ; i<accountInfo_M.size() ; ++i) 
		{
			currentAccount 
			= EbayAccounts.accountInfo_M.get(i).get(AccountsTable.ACCOUNT_NAME, ClassRef.STRING).trim();
			
			if(currentAccount.equalsIgnoreCase(targetAccount))	
			{return EbayAccounts.accountInfo_M.get(i).get(AccountsTable.LOOKBACK_DAYS, ClassRef.INTEGER);}
		}
		throw new IllegalArgumentException("account "+accountName+" not found");
	}
	
	/**
	 * register a new account on the system
	 * @param accountName the name of the new account, must be distinct from any other account name
	 * @param apiKey the api key associated with this account
	 * @param server the server address that this account should use when performing api calls
	 * @param lookback the number of days prior to the current day that the system should use when 
	 * looking for new orders.
	 * @return
	 */
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
	{accountInfo_M = SelectQueryInvoker.execute(SelectQueryTypeNoParams.SELECT_ACCOUNTS);}
}

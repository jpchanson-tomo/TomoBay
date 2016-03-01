package tomoBay.model.services.basicEbayUpdateService;

import org.apache.log4j.Logger;

import tomoBay.helpers.StackTraceToString;
import tomoBay.model.eBayAPI.EbayAccounts;
import tomoBay.model.eBayAPI.OrdersCall;
import tomoBay.model.services.AbstractServiceState;
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

import com.ebay.soap.eBLBaseComponents.OrderType;

/**
 *
 * @author Jan P.C. Hanson
 *
 */
public final class OnRunning implements AbstractServiceState
{
	static private Logger log = Logger.getLogger(OnRunning.class.getName());
	
	/**
	 * default ctor
	 */
	public OnRunning()
	{super();}

	/* (non-Javadoc)
	 * @see tomoBay.model.services.AbstractServiceState#execute()
	 */
	@Override
	public String execute()
	{
		try
		{
			log.warn("ebay update started");
			for(String account : EbayAccounts.accounts())
			{
				log.warn("updating: "+account);
				String usrKey = EbayAccounts.get(account, EbayAccounts.AccountInfo.API_KEY);
				String server =  EbayAccounts.get(account, EbayAccounts.AccountInfo.SERVER_ADDRESS);
				int lookbackDays = Integer.parseInt(EbayAccounts.get(account, EbayAccounts.AccountInfo.LOOKBACK_DAYS));
				int accID = Integer.parseInt(EbayAccounts.get(account, EbayAccounts.AccountInfo.ID));
				
				OrdersCall oCall = new OrdersCall(usrKey, server);
				OrderType[] orders = oCall.call(lookbackDays);
//				
//				for(OrderType o : orders) {System.out.println(o.getOrderID());}
				
				OrdersTable.populate(orders, accID);
				TransactionsTable.populate(orders);
				BuyersTable.populate(orders);
				ItemsAndPartsTable.populate(usrKey, server, accID, orders);
			}
			return "finished ebay update";
		} 
		catch (Exception e)
		{
			log.error("could not perform ebayUpdate: "+StackTraceToString.toString(e));
			return "error";
		}
	}
}

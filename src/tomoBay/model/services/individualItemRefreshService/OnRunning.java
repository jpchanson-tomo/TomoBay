package tomoBay.model.services.individualItemRefreshService;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import tomoBay.helpers.StackTraceToString;
import tomoBay.model.eBayAPI.EbayAccounts;
import tomoBay.model.eBayAPI.EbayAccounts.AccountInfo;
import tomoBay.model.eBayAPI.ItemCall;
import tomoBay.model.services.AbstractServiceState;
import tomoBay.model.sql.queries.QueryInvoker;
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
import tomoBay.model.sql.queries.QueryInvoker.QueryType;

import com.ebay.soap.eBLBaseComponents.ItemType;
import com.ebay.soap.eBLBaseComponents.NameValueListType;

/**
 *
 * @author Jan P.C. Hanson
 *
 */
public final class OnRunning implements AbstractServiceState
{
	static private Logger log = Logger.getLogger(OnRunning.class.getName());
	private Long listingID_M;

	/**
	 * 
	 */
	public OnRunning(Long listingID)
	{
		super();
		this.listingID_M = listingID;
	}

	/* (non-Javadoc)
	 * @see tomoBay.model.services.AbstractServiceState#execute()
	 */
	@Override
	public String execute()
	{
		try
		{
			String account = QueryInvoker.execute(QueryType.SELECT_EBAY_ITEM_SPECIFIC,
																new String[] {this.listingID_M.toString()})
															.get(0)[6];
			ItemType item = this.getItemData(String.valueOf(this.listingID_M), account);
			Map<String, String> specifics = this.getSpecifics(item);
			String brand = specifics.get("Brand"); 
			String partNo = specifics.get("Manufacturer Part Number");
			System.out.println(brand+" : "+partNo);
			
			new RePopulateEbayItem().populate(partNo, brand, Long.parseLong(item.getItemID()));
		
			log.warn(this.listingID_M+" refreshed");
			return this.listingID_M+" refreshed";
		}
		catch(Exception e)
		{e.printStackTrace();log.error("could not refresh "+this.listingID_M+" "+StackTraceToString.toString(e));return "error";}
	}
	

	/**
	 * use the itemID passed in to find out information about a specific eBay item.
	 * @param itemID the ID of a particular eBay Item (listing)
	 * @return ItemType eBay API datatype containing the details of a particular item.
	 */
	private ItemType getItemData(String itemID, String account)
	{
		try
		{
			int acc = Integer.parseInt(account);
			String APIkey = EbayAccounts.get(EbayAccounts.name(acc), AccountInfo.API_KEY);
			String server = EbayAccounts.get(EbayAccounts.name(acc), AccountInfo.SERVER_ADDRESS);
			ItemCall item = new ItemCall(APIkey, server);
			return item.call(itemID);
		}
		catch(Exception e)
		{
			log.error("cannot get ItemData "+StackTraceToString.toString(e));
			return null;
		}
	}
	
	/**
	 * Read the Brand and the manufacturer part number into a map for convenience
	 * @param item the item to store the brand and manufacturer part number of.
	 * @return Map<String,String> containing the above data.
	 */
	private Map<String, String> getSpecifics(ItemType item)
	{
		Map<String, String> itemSpecifics = new HashMap<String, String>();
		try
		{
			NameValueListType[] tmp = item.getItemSpecifics().getNameValueList();
		
			for(int i = 0; i < tmp.length; ++i)
			{
				String res = "";
				for(String itemSpecific : tmp[i].getValue())
				{res+= itemSpecific;}
				itemSpecifics.put(tmp[i].getName(), res);
				System.out.println(tmp[i].getName());
			}
		}
		catch (NullPointerException e)
		{
			itemSpecifics.put("Brand", "not available");
			itemSpecifics.put("Manufacturer Part Number", "not available");
		}
		return itemSpecifics;
	}
}

package tomoBay.model.services.basicEbayUpdateService;
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

import tomoBay.model.eBayAPI.ItemCall;
import tomoBay.model.sql.queries.QueryInvoker;
import tomoBay.model.sql.queries.QueryInvoker.QueryType;

import com.ebay.sdk.ApiException;
import com.ebay.sdk.SdkException;
import com.ebay.soap.eBLBaseComponents.ItemType;
import com.ebay.soap.eBLBaseComponents.NameValueListType;
import com.ebay.soap.eBLBaseComponents.OrderType;
/**
 * updates the items table with the information gleaned from a specific ebay item call.
 * @author Jan P.C. Hanson
 *
 */
public final class ItemsAndPartsTable
{
	/**
	 * default ctor
	 */
	public ItemsAndPartsTable()
	{super();}
	
	/**
	 * populates the Orders Table in the database with data grabbed from the ebay API
	 * @param credentials API credentials.
	 * @param orders list of orders.
	 * @throws Exception 
	 * @throws SdkException 
	 * @throws ApiException 
	 */
	public static void populate(String apiKey, String server, int accID, OrderType[] orders) 
			throws ApiException, SdkException, Exception
	{
		List<String[]> items = QueryInvoker.execute(QueryType.SELECT_EBAY_ITEMS_NOT_IN_TRANSACTIONS,new String[] {});
		
		for (String[] item : items)
		{
			ItemCall itemreq = new ItemCall(apiKey, server);
			ItemType itemType = itemreq.call(item[0]);
			Map<String, String> specifics = ItemsAndPartsTable.getSpecifics(itemType);
			
			ItemsAndPartsTable.populatePartsTable(itemType, specifics);
			
			String[] result = 
					{
						itemType.getItemID(),
						itemType.getTitle(),
						itemType.getConditionDisplayName(),
						specifics.get("Brand"),
						specifics.get("Manufacturer Part Number"),
						String.valueOf(accID)
					};
			QueryInvoker.execute(QueryType.INSERT_EBAY_ITEMS,result);
		}
	}
	
	/**
	 * 
	 * @param item
	 * @return
	 */
	private static Map<String, String> getSpecifics(ItemType item)
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
				item.getBuyItNowPrice().getValue();
			}
		}
		catch (NullPointerException e)
		{
			itemSpecifics.put("Brand", "not  available");
			itemSpecifics.put("Manufacturer Part Number", "not available");
		}
		return itemSpecifics;
	}
	
	private static void populatePartsTable(ItemType itemType, Map<String, String> specifics)
	{
		
	}
}
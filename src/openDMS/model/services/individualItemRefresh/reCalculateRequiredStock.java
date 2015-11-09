package openDMS.model.services.individualItemRefresh;
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
import com.ebay.soap.eBLBaseComponents.NameValueListType;
import java.util.HashMap;
import java.util.Map;

import com.ebay.soap.eBLBaseComponents.ItemType;

/**
 *
 * @author Jan P.C. Hanson
 *
 */
public class reCalculateRequiredStock
{
	public reCalculateRequiredStock()
	{super();}
	
	/**
	 * calculate the amount of stock required to fulfil an order for a particular ebay item, 
	 * update the database with the calculated values.
	 * @param item The item to update.
	 */
	public void calculate(ItemType item)
	{
		int itemQty = item.getQuantity();
		Map<String, String> specifics = this.getSpecifics(item);
		specifics.get("Brand");
		specifics.get("Manufacturer Part Number");
	}
	
	/**
	 * get the item specifics associated with a particular eBay item (listing)
	 * @param item the item to query
	 * @return Map<String, String> mapping a brand and Manufacturer Part Number 
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
}

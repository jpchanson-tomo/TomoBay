package tomoBay.model.services.individualItemRefresh;
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
import java.util.Map;

/**
 *
 * @author Jan P.C. Hanson
 *
 */
import tomoBay.helpers.ConfigReader;
import tomoBay.model.eBayAPI.ItemCall;
import tomoBay.model.services.AbstractConfiguration;
import tomoBay.model.services.AbstractService;
import tomoBay.model.services.helpers.PartList;

import com.ebay.soap.eBLBaseComponents.ItemType;
import com.ebay.soap.eBLBaseComponents.NameValueListType;
/**
 *
 * @author Jan P.C. Hanson
 *
 *
 */
public class IndividualItemRefreshService implements AbstractService
{
	
	private long listingID_M;
	
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run()
	{
		System.out.println(this.listingID_M);
		ItemType item = this.getItemData(String.valueOf(this.listingID_M));
		Map<String, String> specifics = this.getSpecifics(item);
		String brand = specifics.get("Brand");
		String partNo = specifics.get("Manufacturer Part Number");
		PartList partlist = new PartList(partNo);
		
		new RePopulateEbayItem().resetBrandTable(partlist, partNo, brand, Long.parseLong(item.getItemID()));
		new RePopulateEbayItem().populate(partNo, brand, Long.parseLong(partNo));
		new ReCalculateRequiredStock().calculate(partlist, brand, partNo, item);
		new ReCalculateAvailableStock().calculate(partlist, brand, partNo, item.getItemID());
		
	}
	
	/* (non-Javadoc)
	 * @see openDMS.model.services.AbstractService#setConfig(openDMS.model.services.AbstractConfiguration)
	 */
	@Override
	public <E> void setConfig(AbstractConfiguration<E> config)
	{this.listingID_M = (Long) config.configure();}
	
	
	/**
	 * use the itemID passed in to find out information about a specific eBay item.
	 * @param itemID the ID of a particular eBay Item (listing)
	 * @return ItemType eBay API datatype containing the details of a particular item.
	 */
	private ItemType getItemData(String itemID)
	{
		try
		{
			String[] credentials = ConfigReader.read("./config/", "ebay.cfg");
			ItemCall item = new ItemCall(credentials[4], credentials[3]);
			return item.call(itemID);
		}
		catch(Exception e)
		{
			e.printStackTrace();
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
				item.getBuyItNowPrice().getValue();
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
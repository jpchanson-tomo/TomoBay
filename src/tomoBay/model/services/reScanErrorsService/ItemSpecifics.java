package tomoBay.model.services.reScanErrorsService;
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
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import tomoBay.model.eBayAPI.EbayAccounts;
import tomoBay.model.eBayAPI.ItemCall;

import com.ebay.soap.eBLBaseComponents.ItemType;
import com.ebay.soap.eBLBaseComponents.NameValueListType;
/**
 * This class represents the item specifics (Brand, ManufacturerPartNumber etc), it takes care
 * of retrieving the information from the eBay API and making it easily accessible.
 * @author Jan P.C. Hanson
 *
 */
public final class ItemSpecifics
{
	/**holder containing the credentials to access the eBay API**/
	private final String apiKey_M;
	
	private final String server_M;
	/**map containing the item Specifics, this is what the user uses indirectly**/
	private Map<String, String> itemSpecifics_M;
	/**String containing the itemID**/
	private final long itemID_M;
	
	/**
	 * constructor creates an ItemSpecifics object for the itemID passed in as an argument.
	 * @param itemID the id of the item that you need the specifics of
	 * @param account the ebay account to use for the query.
	 */
	public ItemSpecifics(long itemID, int account)
	{
		super();
		String accName = EbayAccounts.name(account);
		this.itemID_M = itemID;
		this.apiKey_M = EbayAccounts.apiKey(accName);
		this.server_M = EbayAccounts.serverAddress(accName);
		this.itemSpecifics_M = new HashMap<String,String>();
		
		this.populateMap(this.performAPIcall(itemID));
	}
	
	/**
	 * provides the itemID associated with this ItemSpecifics object
	 * @return String itemID.
	 */
	public long getID()
	{return this.itemID_M;}
	
	/**
	 * returns a particular Item specific
	 * @param key generally 'ManufacturerPartNumber' or 'Brand'
	 * @return the data associated with that key.
	 */
	public String get(String key)
	{return this.itemSpecifics_M.get(key);}
	
	/**
	 * performs the API call and return an ItemType containing the item information requested, 
	 * or if for some reason the call fails a null pointer is returned. and the stack trace is
	 * printed to the console.
	 * @param itemID the itemID for the item that you wish to find information on.
	 */
	private ItemType performAPIcall(long itemID)
	{
		ItemCall itemscan = new ItemCall(this.apiKey_M,this.server_M);
		try
		{return itemscan.call(itemID);} 
		
		catch (Exception e)
		{e.printStackTrace();
			return null;}
	}
	
	/**
	 * this method takes an ItemType as a parameter and uses it to iterate through the NameValueListType[]
	 * contained within it adding the appropriate names and values to the this.itemSpecifics_M map.
	 * Before adding the 'name' field to the key of the map it removes the spaces in the name, so
	 * to access 'Manufacturer Part Number' you would request 'ManufacturerPartNumber' etc.
	 * @param item the ItemType returned from the API call.
	 */
	private void populateMap(ItemType item)
	{
		for (NameValueListType specific : item.getItemSpecifics().getNameValueList())
		{
			String value = Arrays.toString(specific.getValue());
			value = value.substring(1, value.length()-1);
			this.itemSpecifics_M.put(specific.getName().replace(" ", ""), value);
		}
	}
}

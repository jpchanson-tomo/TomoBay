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

import openDMS.helpers.ConfigReader;
import openDMS.model.eBayAPI.APIcontext;
import openDMS.model.eBayAPI.ItemCall;
import openDMS.model.services.AbstractConfiguration;
/**
 *
 * @author Jan P.C. Hanson
 *
 */
import openDMS.model.services.AbstractService;
import openDMS.model.services.stockUpdate.StockRequiredQueryFactory;

import com.ebay.soap.eBLBaseComponents.ItemType;
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
		ItemType item = this.getItemData(String.valueOf(this.listingID_M));
		
		int required = reCalculateRequiredStock.calculate(item);
		
		
	}
	
	/* (non-Javadoc)
	 * @see openDMS.model.services.AbstractService#setConfig(openDMS.model.services.AbstractConfiguration)
	 */
	@Override
	public <E> void setConfig(AbstractConfiguration<E> config)
	{
		this.listingID_M = (Long) config.configure();
	}
	
	
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
}
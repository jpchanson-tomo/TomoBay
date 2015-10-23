package openDMS.model.services.basicEbayUpdate;
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
import openDMS.model.eBayAPI.OrdersCall;
import openDMS.model.services.AbstractService;

import com.ebay.soap.eBLBaseComponents.OrderType;
/**
 * This class represents the start of the execution flow for the eBay Service, The service 
 * quereies the eBay API for Order and Item information and 
 * @author Jan P.C. Hanson
 *
 */
public class BasicEbayUpdateService implements AbstractService
{
	
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run()
	{
		try
		{
			//index 0 = blank, index 1 = sandbox server string, index 2 = sandbox user token
			//index 3 = production server string, index 4 = production user token.
			String[] credentials = ConfigReader.read("./config/", "ebay.cfg");
			OrdersCall oCall = new OrdersCall(credentials[4], credentials[3]);
			OrderType[] orders = oCall.call(1);

			OrdersTable.populate(credentials, orders);
			TransactionsTable.populate(credentials, orders);
			BuyersTable.populate(credentials, orders);
			ItemsTable.populate(credentials, orders);
		} 
		catch (Exception e)
		{e.printStackTrace();}
	}	
}

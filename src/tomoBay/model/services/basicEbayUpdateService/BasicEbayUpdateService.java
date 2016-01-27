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
import tomoBay.helpers.Config;
import tomoBay.helpers.ConfigReader;
import tomoBay.model.eBayAPI.OrdersCall;
import tomoBay.model.services.AbstractConfiguration;
import tomoBay.model.services.AbstractService;

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
	public String call()
	{
		try
		{
			System.out.println("ebay update started");
			String usrKey = ConfigReader.getConf(Config.EBAY_PROD_KEY);
			String server =  ConfigReader.getConf(Config.EBAY_PROD_SRV);
			
			OrdersCall oCall = new OrdersCall(usrKey, server);
			OrderType[] orders = oCall.call(Integer.parseInt(ConfigReader.getConf(Config.EBAY_LOOKBCK)));
			
			OrdersTable.populate(orders);
			TransactionsTable.populate(orders);
			BuyersTable.populate(orders);
			ItemsTable.populate(new String[] {usrKey,server}, orders);
			return "finished ebay update";
			
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return "error";
		}
	}

	/* (non-Javadoc)
	 * @see openDMS.model.services.AbstractService#setConfig(openDMS.model.services.AbstractConfiguration)
	 */
	@Override
	public <E> void setConfig(AbstractConfiguration<E> config)
	{}
}

package openDMS.model.services;
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

import openDMS.model.services.factories.AbstractServiceFactory;
import openDMS.model.services.factories.BasicEbayServiceFactory;
import openDMS.model.services.factories.IndividualItemRefreshServiceFactory;
import openDMS.model.services.factories.StockUpdateServiceFactory;
import openDMS.model.services.factories.TestServiceFactory;
/**
 *
 * @author Jan P.C. Hanson
 *
 */
public class ServiceFactory
{
	/**defensive enum to limit the inputs to the make method**/
	public enum ServiceType 
			{
				EBAY_SERVICE, TEST_SERVICE, STOCK_UPDATE_SERVICE,
				INDVIDUAL_ITEM_REFRESH_SERVICE
			}
	/**internal map holds service factories**/
	@SuppressWarnings("serial")
	private static final Map<ServiceType, AbstractServiceFactory> serviceFactoryMap
						= new HashMap<ServiceType, AbstractServiceFactory>()
			{{
				put(ServiceType.EBAY_SERVICE, new BasicEbayServiceFactory());
				put(ServiceType.TEST_SERVICE, new TestServiceFactory());
				put(ServiceType.STOCK_UPDATE_SERVICE, new StockUpdateServiceFactory());
				put(ServiceType.INDVIDUAL_ITEM_REFRESH_SERVICE, new IndividualItemRefreshServiceFactory());
			}};

	/**
	 * make the service requested using an ServiceType enum value
	 * @param service the service requested
	 * @return
	 */
	public static AbstractService make(ServiceType service)
	{return ServiceFactory.serviceFactoryMap.get(service).make();}
}

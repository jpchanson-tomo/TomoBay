package tomoBay.model.services;
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

import tomoBay.model.services.factories.AbstractServiceFactory;
import tomoBay.model.services.factories.BasicEbayServiceFactory;
import tomoBay.model.services.factories.CheckErrorsFactory;
import tomoBay.model.services.factories.EmailErrorsServiceFactory;
import tomoBay.model.services.factories.IndividualItemRefreshServiceFactory;
import tomoBay.model.services.factories.InvoiceServiceFactory;
import tomoBay.model.services.factories.OutOfHoursServiceFactory;
import tomoBay.model.services.factories.ReScanErrorsServiceFactory;
import tomoBay.model.services.factories.StockUpdateServiceFactory;
import tomoBay.model.services.factories.TestServiceFactory;
/**
 * This factory is responsible for creating services which can be passed to the TriggerService
 * or ServicesScheduler objects.
 * 
 * The types of object that can be created are defined by the internal enum.
 * @author Jan P.C. Hanson
 *
 */
public class ServiceFactory
{
	/**defensive enum to limit the inputs to the make method**/
	public enum ServiceType 
			{
				EBAY_SERVICE, TEST_SERVICE, STOCK_UPDATE_SERVICE, INVOICE_SERVICE, CHECK_ERRORS,
				RESCAN_ERRORS_SERVICE, OUT_OF_HOURS_SERVICE,
			}
	public enum ConfiguredServiceType
			{
				INDVIDUAL_ITEM_REFRESH_SERVICE, EMAIL_ERRORS_SERVICE
			}
	/**internal map holds service factories**/
	@SuppressWarnings("serial")
	private static final Map<ServiceType, AbstractServiceFactory> serviceFactoryMap
					= new HashMap<ServiceType, AbstractServiceFactory>()
	{{
		put(ServiceType.EBAY_SERVICE, new BasicEbayServiceFactory());
		put(ServiceType.TEST_SERVICE, new TestServiceFactory());
		put(ServiceType.STOCK_UPDATE_SERVICE, new StockUpdateServiceFactory());
		put(ServiceType.INVOICE_SERVICE, new InvoiceServiceFactory());
		put(ServiceType.CHECK_ERRORS, new CheckErrorsFactory());
		put(ServiceType.RESCAN_ERRORS_SERVICE, new ReScanErrorsServiceFactory());
		put(ServiceType.OUT_OF_HOURS_SERVICE, new OutOfHoursServiceFactory());
	}};
	@SuppressWarnings("serial")
	private static final 
	Map<ConfiguredServiceType, AbstractServiceFactory> configuredServiceFactoryMap
					= new HashMap<ConfiguredServiceType, AbstractServiceFactory>()
	{{
		put(ConfiguredServiceType.INDVIDUAL_ITEM_REFRESH_SERVICE, new IndividualItemRefreshServiceFactory());
		put(ConfiguredServiceType.EMAIL_ERRORS_SERVICE, new EmailErrorsServiceFactory());
	}};		

	/**
	 * make the service requested using an ServiceType enum value
	 * @param service the service requested 
	 * @return AbstractService as requested.
	 */
	public static AbstractService make(ServiceType service)
	{return ServiceFactory.serviceFactoryMap.get(service).make();}
	
	/**
	 * make a configured service using the AbstractConfiguration provided
	 * @param service the service to make only ServiceType enum constants are valid
	 * @param config the AbstractConfiguration appropriate to the Service being made
	 * @return AbstractService, configured as requested.
	 */
	public static AbstractService make(ConfiguredServiceType service, AbstractConfiguration<?> config)
	{
		AbstractService configuredService = ServiceFactory.configuredServiceFactoryMap.get(service).make();
		configuredService.setConfig(config);
		
		return configuredService;
	}
}

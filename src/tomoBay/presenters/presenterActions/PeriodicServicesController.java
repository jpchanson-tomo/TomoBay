package tomoBay.presenters.presenterActions;
import tomoBay.model.services.ServiceFactory;
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
import tomoBay.model.services.ServiceScheduler;
import tomoBay.model.services.ServiceFactory.ServiceType;
import tomoBay.model.services.emailErrorsService.EmailErrorsConfig;
/**
 *
 * @author Jan P.C. Hanson
 *
 */
public class PeriodicServicesController implements AbstractPresenterAction
{
	private static ServiceScheduler services_M;
	
	public PeriodicServicesController()
	{super();}

	/* (non-Javadoc)
	 * @see tomoBay.presenters.presenterActions.AbstractPresenterAction#execute(java.lang.String)
	 */
	@Override
	public String execute(String data)
	{
		return PeriodicServicesController.executeStatic(data);
	}
	
	/**
	 * 
	 * @param data
	 * @return
	 */
	private static synchronized String executeStatic(String data)
	{
		if(data.equals("START"))
		{
//			System.out.println("started");
//			PeriodicServicesController.services_M = new ServiceScheduler(5);
//			PeriodicServicesController.addServices();
//			PeriodicServicesController.services_M.start(20);
			return "Services Started";
		}
		else if(data.equals("STOP"))
		{
//			System.out.println("stopped");
//			PeriodicServicesController.services_M.clear();
//			PeriodicServicesController.services_M = null;
			return "Services Stopped";
		}
		
		return "data does not contain a valid command";
	}
	
	/**
	 * 
	 */
	private static void addServices()
	{
		services_M.add(ServiceFactory.make(ServiceFactory.ServiceType.EBAY_SERVICE));
		services_M.add(ServiceFactory.make(ServiceFactory.ServiceType.RESCAN_ERRORS_SERVICE));
		services_M.add(ServiceFactory.make(ServiceFactory.ServiceType.CHECK_ERRORS));
		String data = "<EMAIL>"
				+ "<TO>tomomotorbay@gmail.com</TO>"
				+ "<TO>paul@tomoparts.co.uk</TO>"
				+ "<TO>steve@tomoparts.co.uk</TO>"
				+ "<SUBJECT>ERRORS TO FIX!!!!!</SUBJECT>"
				+ "</EMAIL>";
		services_M.add(ServiceFactory.make(
				ServiceType.EMAIL_ERRORS_SERVICE,
				new EmailErrorsConfig().configure(data)
					));
//		services_M.add(ServiceFactory.make(ServiceFactory.ServiceType.INVOICE_SERVICE));
	}
}

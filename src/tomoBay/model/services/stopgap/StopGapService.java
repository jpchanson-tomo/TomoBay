package tomoBay.model.services.stopgap;
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
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

import tomoBay.model.services.TriggerService;
import tomoBay.model.services.emailErrorsService.EmailErrorsConfig;
import tomoBay.model.services.helpers.EbayOrderCancellationStatus;
import tomoBay.exceptions.ServiceException;
import tomoBay.helpers.checkTime.CheckTime;
import tomoBay.model.services.AbstractConfiguration;
import tomoBay.model.services.AbstractService;
import tomoBay.model.services.ServiceFactory;
import tomoBay.model.services.ServiceFactory.ServiceType;

/**
 *
 * @author Jan P.C. Hanson
 *
 */
public class StopGapService implements AbstractService
{

	/* (non-Javadoc)
	 * @see tomoBay.model.services.AbstractService#run()
	 */
	@Override
	public String call() throws ServiceException
	{
		List<Future<String>> threadList = new ArrayList<Future<String>>();
		try
		{
				System.out.println("start");
				System.out.println("start: EBAY SERVICE");
				threadList.add(TriggerService.start(ServiceFactory.make(ServiceType.EBAY_SERVICE)));
				System.out.println("started: wait(120000)");
				Thread.sleep(120000);
				System.out.println("finished: EBAY SERVICE");			
			
				System.out.println("started: RESCAN ERRORS");
				TriggerService.start(ServiceFactory.make(ServiceType.RESCAN_ERRORS_SERVICE));
				System.out.println("started: wait(120000)");
				Thread.sleep(120000);
				System.out.println("finished: RESCAN ERRORS");			
			
				System.out.println("started: CHECK ERRORS");
				TriggerService.start(ServiceFactory.make(ServiceType.CHECK_ERRORS));
				System.out.println("started: wait(120000)");
				Thread.sleep(120000);
				System.out.println("finished: CHECK ERRORS");			
			
				System.out.println("started: EMAIL ERRORS");
				String data = "<EMAIL>"
					+ "<TO>tomomotorbay@gmail.com</TO>"
					+ "<TO>paul@tomoparts.co.uk</TO>"
					+ "<TO>steve@tomoparts.co.uk</TO>"
					+ "<SUBJECT>ERRORS TO FIX!!!!!</SUBJECT>"
					+ "</EMAIL>";
				TriggerService.start(ServiceFactory.make(
												ServiceType.EMAIL_ERRORS_SERVICE,
												new EmailErrorsConfig().configure(data)
													));
				System.out.println("started: wait(120000)");
				Thread.sleep(120000);
				System.out.println("finished: EMAIL ERRORS");
//			
			
				System.out.println("started: INVOICE SERVICE");
				TriggerService.start(ServiceFactory.make(ServiceType.INVOICE_SERVICE));
				Thread.sleep(120000);
				System.out.println("finished: INVOICE SERVICE");
			
			System.out.println("end");
			for (Future<String> thread : threadList) {System.out.println(thread.toString()+" cancelled="+thread.cancel(true));}
			System.out.println("threads cleaned up?");
			return "ALL DONE";
		} 
		
		catch (Exception e)
		{
			e.printStackTrace();
			return "ERROR";
		}

	}

	/* (non-Javadoc)
	 * @see tomoBay.model.services.AbstractService#setConfig(tomoBay.model.services.AbstractConfiguration)
	 */
	@Override
	public <E> void setConfig(AbstractConfiguration<E> config)
	{
		// TODO Auto-generated method stub

	}

}

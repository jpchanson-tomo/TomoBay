package tomoBay.presenters.presenterActions;

import java.util.concurrent.Future;

import tomoBay.model.services.ServiceFactory;
import tomoBay.model.services.TriggerService;
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
import tomoBay.model.services.ServiceFactory.ServiceType;
import tomoBay.model.services.individualItemRefreshService.IndividualItemRefreshConfig;

/**
 *
 * @author Jan P.C. Hanson
 *
 */
public class ReScanListing implements AbstractPresenterAction
{
	/**
	 * default ctor
	 */
	public ReScanListing()
	{super();}

	/* (non-Javadoc)
	 * @see tomoBay.presenters.presenterActions.AbstractPresenterAction#execute(java.lang.String)
	 */
	@Override
	public String execute(String data)
	{System.out.println("re scanning - " + data);
		try
		{
			long listingID = Long.parseLong(data);
			Future<?> s = TriggerService.start(ServiceFactory.make
								(ServiceType.INDVIDUAL_ITEM_REFRESH_SERVICE, 
								new IndividualItemRefreshConfig().configure(listingID)));
			while (s.isDone()!=true && s.isCancelled()!=true){}
			return s.get().toString();
		}
		catch (Exception e)
		{e.printStackTrace();return "error"+e.getMessage();}
	}
}

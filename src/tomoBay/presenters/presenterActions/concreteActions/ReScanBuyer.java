package tomoBay.presenters.presenterActions.concreteActions;

import java.util.concurrent.ExecutionException;

import tomoBay.model.services.ServiceFactory;
import tomoBay.model.services.TriggerService;
import tomoBay.model.services.ServiceFactory.ConfiguredServiceType;
import tomoBay.model.services.reScanBuyerService.ReScanBuyerServiceConfig;
import tomoBay.presenters.presenterActions.AbstractPresenterAction;
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

/**
 *
 * @author Jan P.C. Hanson
 *
 */
public final class ReScanBuyer implements AbstractPresenterAction
{

	/**
	 * 
	 */
	public ReScanBuyer()
	{super();}

	/* (non-Javadoc)
	 * @see tomoBay.presenters.presenterActions.AbstractPresenterAction#execute(java.lang.String)
	 */
	@Override
	public String execute(String data)
	{
		try
		{
			return TriggerService.start(
							ServiceFactory.make(
												ConfiguredServiceType.RE_SCAN_BUYER_SERVICE, 
												new ReScanBuyerServiceConfig().configure(data)
												)
										).get().toString();
		} 
		catch (InterruptedException e){e.printStackTrace();return "Error: presenterAction interupted";} 
		catch (ExecutionException e){e.printStackTrace();return "Error: thread execution problem";}
	}

}

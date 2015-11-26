package tomoBay.presenters.root;
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
import tomoBay.model.services.ServiceFactory;
import tomoBay.model.services.TriggerService;
import tomoBay.model.services.ServiceFactory.ServiceType;
import tomoBay.presenters.AbstractPresenter;
/**
 * this is the presenter for the root of the webApp. The root presenter is the 
 * default presenter which is responsible for providing the dynamic information to be displayed
 * on the dashboard.
 * @author Jan P.C. Hanson
 *
 */
public class RootPresenter implements AbstractPresenter
{
	/**
	 * default constructor
	 */
	public RootPresenter()
	{super();}
	
	/* (non-Javadoc)
	 * @see openDMS.presenters.AbstractPresenter#present(openDMS.view.views.AbstractView)
	 */
	@Override
	public String present()
	{
		String output = "";
		
		
		TriggerService.start(ServiceFactory.make(ServiceType.TEST_SERVICE));
		System.out.println("Root page loaded");
		
		return output;
	}
}

package tomoBay.presenters.presenterActions.concreteActions;
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
import tomoBay.model.dataTypes.ServerStatus;
import tomoBay.presenters.presenterActions.AbstractPresenterAction;
/**
 *
 * @author Jan P.C. Hanson
 *
 */
public class PeriodicServicesController implements AbstractPresenterAction
{
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
		if(data.toUpperCase().equals("START"))
		{
			ServerStatus.instance().setStatus(ServerStatus.RunLevel.RUNNING);
			return "Services Started";
		}
		else if(data.toUpperCase().equals("PAUSE"))
		{
			ServerStatus.instance().setStatus(ServerStatus.RunLevel.PAUSED);
			return "Services Stopped";
		}
		
		return "data does not contain a valid command";
	}
}

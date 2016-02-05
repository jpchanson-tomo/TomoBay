package tomoBay.model.services.checkErrorsService;
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
import org.apache.log4j.Logger;

import tomoBay.exceptions.ServiceException;
import tomoBay.model.services.AbstractConfiguration;
import tomoBay.model.services.AbstractService;
/**
 *
 * @author Jan P.C. Hanson
 *
 */
public final class CheckErrorsService extends AbstractService
{
	static Logger log = Logger.getLogger(CheckErrorsService.class.getName());
	
	public CheckErrorsService()
	{super();}

	/* (non-Javadoc)
	 * @see tomoBay.model.services.AbstractService#setConfig(tomoBay.model.services.AbstractConfiguration)
	 */
	@Override
	public <E> void setConfig(AbstractConfiguration<E> config)
	{}

	/* (non-Javadoc)
	 * @see tomoBay.model.services.AbstractService#onRunning()
	 */
	@Override
	protected String onRunning() throws ServiceException
	{return new OnRunning().execute();}

	/* (non-Javadoc)
	 * @see tomoBay.model.services.AbstractService#onPaused()
	 */
	@Override
	protected String onPaused() throws ServiceException
	{return "Check Errors Paused";}

	/* (non-Javadoc)
	 * @see tomoBay.model.services.AbstractService#onStopped()
	 */
	@Override
	protected String onStopped() throws ServiceException
	{return "Server Stopped";}

	/* (non-Javadoc)
	 * @see tomoBay.model.services.AbstractService#onError()
	 */
	@Override
	protected String onError() throws ServiceException
	{return "Server Error";}
}

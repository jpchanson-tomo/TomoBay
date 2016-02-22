package tomoBay.model.services.reScanBuyerService;

import tomoBay.exceptions.ServiceException;
import tomoBay.model.services.AbstractConfiguration;
import tomoBay.model.services.AbstractService;
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
public final class ReScanBuyerService extends AbstractService
{
	private String buyerID_M;

	/**
	 * default ctor
	 */
	public ReScanBuyerService()
	{super();}

	/* (non-Javadoc)
	 * @see tomoBay.model.services.AbstractService#setConfig(tomoBay.model.services.AbstractConfiguration)
	 */
	@Override
	public <E> void setConfig(AbstractConfiguration<E> config)
	{this.buyerID_M = (String) config.configure();}

	/* (non-Javadoc)
	 * @see tomoBay.model.services.AbstractService#onRunning()
	 */
	@Override
	protected String onRunning() throws ServiceException
	{return new OnRunning(this.buyerID_M).execute();}

	/* (non-Javadoc)
	 * @see tomoBay.model.services.AbstractService#onPaused()
	 */
	@Override
	protected String onPaused() throws ServiceException
	{return this.onRunning();}

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

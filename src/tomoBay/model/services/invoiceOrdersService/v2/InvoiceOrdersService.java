package tomoBay.model.services.invoiceOrdersService.v2;
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
import tomoBay.exceptions.ServiceException;
import tomoBay.helpers.ClassInfo;
import tomoBay.helpers.checkTime.CheckTime;
import tomoBay.model.services.AbstractConfiguration;
import tomoBay.model.services.AbstractService;
import tomoBay.model.services.invoiceOrdersService.v2.OnRunning;
/**
 *
 * @author Jan P.C. Hanson
 *
 */
public class InvoiceOrdersService extends AbstractService
{

	/**
	 * 
	 */
	public InvoiceOrdersService()
	{
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see tomoBay.model.services.AbstractService#setConfig(tomoBay.model.services.AbstractConfiguration)
	 */
	@Override
	public <E> void setConfig(AbstractConfiguration<E> config)
	{
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see tomoBay.model.services.AbstractService#onRunning()
	 */
	@Override
	protected String onRunning() throws ServiceException
	{
		if(CheckTime.isInRange())
		{return new OnRunning().execute();}
		return "out of hours: "+this.onPaused();
	}

	/* (non-Javadoc)
	 * @see tomoBay.model.services.AbstractService#onPaused()
	 */
	@Override
	protected String onPaused() throws ServiceException
	{return "0 invoices raised "+ClassInfo.name(this)+ " paused";}

	/* (non-Javadoc)
	 * @see tomoBay.model.services.AbstractService#onStopped()
	 */
	@Override
	protected String onStopped() throws ServiceException
	{return "service stopped";}

	/* (non-Javadoc)
	 * @see tomoBay.model.services.AbstractService#onError()
	 */
	@Override
	protected String onError() throws ServiceException
	{return "ERROR IN "+this.getClass().getName();}

}

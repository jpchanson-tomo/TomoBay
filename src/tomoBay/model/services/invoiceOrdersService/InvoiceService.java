package tomoBay.model.services.invoiceOrdersService;
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
import tomoBay.helpers.checkTime.CheckTime;
import tomoBay.model.services.AbstractConfiguration;
import tomoBay.model.services.AbstractService;
/**
 * This service runs through all the orders on the system that havent yet been invoiced and 
 * checks them against stock levels to see how invoiceable they are (invoiceable/partially
 * invoiceable/not invoiceable) and raises invoices for the ones which are invoiceable. It also
 * records the current invoiceability status for all orders not currently invoiced on the database.
 * @author Jan P.C. Hanson
 *
 */
public final class InvoiceService extends AbstractService
{

	/* (non-Javadoc)
	 * @see openDMS.model.services.AbstractService#setConfig(openDMS.model.services.AbstractConfiguration)
	 */
	@Override
	public <E> void setConfig(AbstractConfiguration<E> config)
	{}

	/* (non-Javadoc)
	 * @see tomoBay.model.services.AbstractService#onRunning()
	 */
	@Override
	public String onRunning() throws ServiceException
	{
		if(CheckTime.isInRange())
		{return new OnRunning().execute();}
		return this.onPaused()+"out of hours : 0 invoices raised";
	}

	/* (non-Javadoc)
	 * @see tomoBay.model.services.AbstractService#onPaused()
	 */
	@Override
	public String onPaused() throws ServiceException
	{return "InvoiceService Paused";}

	/* (non-Javadoc)
	 * @see tomoBay.model.services.AbstractService#onStoppped()
	 */
	@Override
	public String onStopped() throws ServiceException
	{return "Server Stopped";}

	/* (non-Javadoc)
	 * @see tomoBay.model.services.AbstractService#onError()
	 */
	@Override
	public String onError() throws ServiceException
	{return "Server Error";}
}

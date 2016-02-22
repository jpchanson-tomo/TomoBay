package tomoBay.model.services.updateOrderStatusService;
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
import tomoBay.model.services.AbstractConfiguration;
import tomoBay.model.services.AbstractService;
/**
 * This service is responsible for updateing the status of an order i.e. moving it from picking
 * to packing to shipping etc.
 * @author Jan P.C. Hanson
 *
 */
public final class UpdateOrderStatusService extends AbstractService
{
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
	public String onRunning() throws ServiceException
	{return "";}

	/* (non-Javadoc)
	 * @see tomoBay.model.services.AbstractService#onPaused()
	 */
	@Override
	public String onPaused() throws ServiceException
	{return null;}

	/* (non-Javadoc)
	 * @see tomoBay.model.services.AbstractService#onStopped()
	 */
	@Override
	public String onStopped() throws ServiceException
	{return null;}

	/* (non-Javadoc)
	 * @see tomoBay.model.services.AbstractService#onError()
	 */
	@Override
	public String onError() throws ServiceException
	{return null;}

}

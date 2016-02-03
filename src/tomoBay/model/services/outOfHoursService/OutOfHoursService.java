package tomoBay.model.services.outOfHoursService;
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
import tomoBay.model.sql.queries.QueryInvoker;
import tomoBay.model.sql.queries.QueryInvoker.QueryType;

import java.text.SimpleDateFormat;
import java.util.List;

import tomoBay.exceptions.ServiceException;
import tomoBay.helpers.checkTime.CheckTime;
import tomoBay.model.services.AbstractConfiguration;
import tomoBay.model.services.AbstractService;
/**
 *
 * @author Jan P.C. Hanson
 *
 */
public class OutOfHoursService implements AbstractService
{

	/* (non-Javadoc)
	 * @see tomoBay.model.services.AbstractService#call()
	 */
	@Override
	public String call() throws ServiceException
	{
		if(CheckTime.isInRange()==false)
		{
			List<String[]> results = QueryInvoker.execute(QueryType.SELECT_UNINVOICED_ORDERS, new String[] {});
			String orders="";
			for (String[] data : results)
			{
				QueryInvoker.execute(QueryType.INSERT_OUT_OF_HOURS, new String[] {data[2], this.getDate()});
				orders+=data[2]+", ";
			}
			return "Exiting: "+orders+" in Out of Hours table";
		}
		else
		{return "Exiting: Not Out Of Hours";}
	}

	/* (non-Javadoc)
	 * @see tomoBay.model.services.AbstractService#setConfig(tomoBay.model.services.AbstractConfiguration)
	 */
	@Override
	public <E> void setConfig(AbstractConfiguration<E> config)
	{}
	
	/**
	 * 
	 * @return
	 */
	private String getDate()
	{return new SimpleDateFormat("yyyy-MM-dd").format(CheckTime.OutOfHoursDate());}
}

package openDMS.model.services;
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
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/**
 *
 * @author Jan P.C. Hanson
 *
 */
public class ServicesScheduler
{
	/****/
	ScheduledThreadPoolExecutor serviceScheduler_M;
	/****/
	List<ScheduledFuture<?>> services_M;
	
	/**
	 * 
	 * @param noOfThreads
	 */
	public ServicesScheduler(int noOfThreads)
	{
		this.serviceScheduler_M = new ScheduledThreadPoolExecutor(noOfThreads);
		this.serviceScheduler_M.setMaximumPoolSize(noOfThreads+2);
		this.services_M = new ArrayList<ScheduledFuture<?>>();
	}
	
	/**
	 * 
	 * @param service
	 */
	public void add(AbstractService service, long delay, long rate)
	{
		this.services_M.add(this.serviceScheduler_M.scheduleWithFixedDelay(service, delay, rate, TimeUnit.MINUTES));
	}
	
	/**
	 * 
	 */
	public void start()
	{
		try 
		{
			for(int i = 0 ; i < this.services_M.size() ; ++i)
			{
				this.services_M.get(i).get();
			}
		}
		catch(InterruptedException | ExecutionException e)
		{e.printStackTrace();}
		
		serviceScheduler_M.shutdown();
		
	}
}

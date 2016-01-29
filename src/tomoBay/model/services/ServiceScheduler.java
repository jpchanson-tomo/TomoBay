package tomoBay.model.services;
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
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

import tomoBay.model.services.basicEbayUpdateService.BasicEbayUpdateService;
/**
 * This class defines a service scheduler, it runs services intervalicaly, with the interval 
 * being defined from the previous termination of that service thread. Contains a threadpool
 * which should be changed to reflect the number of services stored in the queue, for small
 * numbers of services; and set to a sensible value for larger numbers of services.
 * @author Jan P.C. Hanson
 *
 */
public class ServiceScheduler
{
	static Logger log = Logger.getLogger(ServiceScheduler.class.getName());
	/**Scheduled thread pool**/
	private ScheduledThreadPoolExecutor serviceScheduler_M;
	/**List of scheduled services**/
	private List<AbstractService> services_M; 
	/**List of Scheduled futures representing service threads return values**/
//	private List<ScheduledFuture<?>> servicesResults_M;
	private List<Future<?>> servicesResults_M;
	
	/**
	 * constructor creates a thread pool with the number of threads specified in the arguments.
	 * @param noOfThreads the number of threads to populate the pool with.
	 */
	public ServiceScheduler(int noOfThreads)
	{
		this.serviceScheduler_M = new ScheduledThreadPoolExecutor(noOfThreads);
		this.services_M = new ArrayList<AbstractService>();
//		this.servicesResults_M = new ArrayList<ScheduledFuture<?>>();
		this.servicesResults_M = new ArrayList<Future<?>>();
	}
	
	/**
	 * add a service to the list of services to run at the periods specified in the method 
	 * parameters.
	 */
	public void add(AbstractService service)
	{this.services_M.add(service);}
	
	public void clear()
	{this.services_M.clear();}
	/**
	 * starts the periodic services.
	 * @param rateInMins 
	 */
	public void start(long rateInMins)
	{
		while(this.services_M.size() > 0)
		{
			try 
			{
				for(int i = 0 ; i < this.services_M.size() ; ++i)
				{
					log.warn(this.serviceScheduler_M.submit(this.services_M.get(i)).get().toString());
				}
				Thread.sleep(rateInMins*60*1000);
			}
			catch(InterruptedException | ExecutionException e)
			{e.printStackTrace();}
		}
		serviceScheduler_M.shutdown();
		log.warn("scheduler shut down");
	}
	
	/**
	 * stops the periodic services
	 */
	public void stop()
	{this.serviceScheduler_M.shutdownNow();}
}

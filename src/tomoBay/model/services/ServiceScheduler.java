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
	 * parameters. After the initial 'delay' (in minutes) the 'service' executes, once execution
	 * has finished, the service will be executed again after the number of minutes specified in
	 * the 'rate' parameter.
	 * @param service the service to add
	 * @param delay the initial delay before running the service
	 * @param rate the rate at which to  repeat the service.
	 */
	public void add(AbstractService service)
	{
//		this.services_M.add(this.serviceScheduler_M.scheduleWithFixedDelay(service, delay, rate, TimeUnit.MINUTES));
		this.services_M.add(service);
//		this.servicesResults_M.add(this.serviceScheduler_M.schedule(service, delay, TimeUnit.MINUTES));
	}
	
	/**
	 * starts the service.
	 */
	public void start(long rateInMins)
	{
		while(this.services_M.size() > 0)
		{
			try 
			{
				for(int i = 0 ; i < this.services_M.size() ; ++i)
				{
					System.out.println(this.serviceScheduler_M.submit(this.services_M.get(i)).get().toString());
				}
				Thread.sleep(rateInMins*60*1000);
			}
			catch(InterruptedException | ExecutionException e)
			{e.printStackTrace();}
		}
		serviceScheduler_M.shutdown();
		System.out.println("scheduler shut down");
	}
}

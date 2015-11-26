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
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
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
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/**
 * This object defines a way of triggering services upon request, it contains a threadpool which
 * is not user customiseable. The default number of threads in the threadpool is 10, should this
 * value need altering it will have to be done within the code.
 * @author Jan P.C. Hanson
 *
 */
public class TriggerService
{
	/**the number of core threads**/
	private static final int INITIALTHREADS = 2;
	/**the maximum number of threads**/
	private static final int MAXTHREADS = 10;
	/**thread pool thread queue**/
	private static final BlockingQueue<Runnable> THREADPOOL  
						= new ArrayBlockingQueue<Runnable>(MAXTHREADS);
	/**the thread pool executor**/
	private static final ThreadPoolExecutor THREADPOOLEXECUTOR = new ThreadPoolExecutor
	(INITIALTHREADS,MAXTHREADS,0l,TimeUnit.MILLISECONDS,THREADPOOL);
	
	/**
	 * constructor, default
	 */
	public TriggerService()
	{super();}
	
	/**
	 * tries to start a particular service, if there arn't enough threads available it will
	 * be placed in a BlockingQueue until there is a free thread.
	 * @param service the service to be started.
	 */
	public static void start(AbstractService service)
	{TriggerService.THREADPOOLEXECUTOR.execute(service);}
}

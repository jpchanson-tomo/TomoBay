package tomoBay;
import tomoBay.model.services.ServiceFactory;
import tomoBay.model.services.ServiceScheduler;
/**
 * The entry point into the program, this is a stopgap solution to get invoices ,of orders that
 * are completely fulfillable, printed automatically
 * 
 * @author Jan P.C. Hanson
 *
 */
public class MAIN
{
	public static void main(String[] args) throws Exception
	{
		System.setProperty("Log4jContextSelector", "org.apache.logging.log4j.core.async.AsyncLoggerContextSelector");
		
		ServiceScheduler services = new ServiceScheduler(2);
		services.add(ServiceFactory.make(ServiceFactory.ServiceType.STOPGAP_SERVICE), 0, 20);
		services.start();
		
	}
}
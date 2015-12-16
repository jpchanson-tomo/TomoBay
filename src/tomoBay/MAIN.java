package tomoBay;
import tomoBay.model.services.ServiceFactory;
import tomoBay.model.services.ServiceScheduler;
import tomoBay.model.services.TriggerService;
import tomoBay.model.services.ServiceFactory.ServiceType;
import tomoBay.model.services.emailErrorsService.EmailErrorsConfig;
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
		services.add(ServiceFactory.make(ServiceFactory.ServiceType.EBAY_SERVICE), 0, 10);
//		services.add(ServiceFactory.make(ServiceFactory.ServiceType.INVOICE_SERVICE), 2, 5);
		
//		TriggerService.start(ServiceFactory.make(ServiceFactory.ServiceType.CHECK_ERRORS));
//		TriggerService.start(ServiceFactory.make(ServiceType.RESCAN_ERRORS_SERVICE));
		
//		String data = "<EMAIL>"
//					+ "<TO>tomomotorbay@gmail.com</TO>"
//					+ "<SUBJECT>ERRORS TO FIX!!!!!</SUBJECT>"
//					+ "</EMAIL>";
//		TriggerService.start(ServiceFactory.make(
//												ServiceType.EMAIL_ERRORS_SERVICE,
//												new EmailErrorsConfig().configure(data)
//												));
		
		
		
		
		services.start();
		
	}
}
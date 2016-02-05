package tomoBay;
import org.apache.log4j.Logger;

import tomoBay.model.dataTypes.ServerStatus;
import tomoBay.model.services.ServiceFactory;
import tomoBay.model.services.ServiceFactory.ConfiguredServiceType;
import tomoBay.model.services.ServiceScheduler;
import tomoBay.model.services.emailErrorsService.EmailErrorsConfig;
import tomoBay.model.services.invoiceOrdersService.invoice.Invoice;
import tomoBay.view.HttpServer;
/**
 * The entry point into the program, this is a stopgap solution to get invoices ,of orders that
 * are completely fulfillable, printed automatically
 * 
 * @author Jan P.C. Hanson
 *
 */
public class MAIN
{
	static private Logger log = Logger.getLogger(Invoice.class.getName());
	
	public static void main(String[] args) throws Exception
	{
		System.setProperty("Log4jContextSelector", "org.apache.logging.log4j.core.async.AsyncLoggerContextSelector");
		
		log.warn("*******************************PROGRAM START*******************************");
		final HttpServer server = new HttpServer();
		server.start(1337);
		ServerStatus.instance().setStatus(ServerStatus.RunLevel.RUNNING);
		
		final ServiceScheduler services = new ServiceScheduler(6);
		services.add(ServiceFactory.make(ServiceFactory.ServiceType.INVOICE_SERVICE));
		services.add(ServiceFactory.make(ServiceFactory.ServiceType.EBAY_SERVICE));
		services.add(ServiceFactory.make(ServiceFactory.ServiceType.OUT_OF_HOURS_SERVICE));
		services.add(ServiceFactory.make(ServiceFactory.ServiceType.RESCAN_ERRORS_SERVICE));
		services.add(ServiceFactory.make(ServiceFactory.ServiceType.CHECK_ERRORS));
		final String data = "<EMAIL>"
				+ "<TO>tomomotorbay@gmail.com</TO>"
				+ "<TO>paul@tomoparts.co.uk</TO>"
				+ "<TO>steve@tomoparts.co.uk</TO>"
				+ "<SUBJECT>ERRORS TO FIX!!!!!</SUBJECT>"
				+ "</EMAIL>";
		services.add(ServiceFactory.make(
										ConfiguredServiceType.EMAIL_ERRORS_SERVICE,
										new EmailErrorsConfig().configure(data)
										));
		services.start(20);
		
//		TransactionData id = new TransactionData();
//		for(String[] transaction : id.get("200636949016"))
//		{
//			System.out.println(Arrays.toString(transaction));
//		}
	}
}
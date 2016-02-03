package tomoBay;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;

import tomoBay.helpers.checkTime.CheckTime;
import tomoBay.model.services.ServiceFactory;
import tomoBay.model.services.ServiceFactory.ServiceType;
import tomoBay.model.services.ServiceScheduler;
import tomoBay.model.services.emailErrorsService.EmailErrorsConfig;
import tomoBay.model.services.invoiceOrdersService.invoice.Invoice;
import tomoBay.model.services.populateInvoicesService.InvoiceData;
import tomoBay.model.sql.queries.QueryInvoker;
import tomoBay.model.sql.queries.QueryInvoker.QueryType;
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
		HttpServer server = new HttpServer();
		server.start(1337);
		
		ServiceScheduler services = new ServiceScheduler(6);
		services.add(ServiceFactory.make(ServiceFactory.ServiceType.INVOICE_SERVICE));
		services.add(ServiceFactory.make(ServiceFactory.ServiceType.EBAY_SERVICE));
		services.add(ServiceFactory.make(ServiceFactory.ServiceType.OUT_OF_HOURS_SERVICE));
		services.add(ServiceFactory.make(ServiceFactory.ServiceType.RESCAN_ERRORS_SERVICE));
		services.add(ServiceFactory.make(ServiceFactory.ServiceType.CHECK_ERRORS));
		String data = "<EMAIL>"
				+ "<TO>tomomotorbay@gmail.com</TO>"
				+ "<TO>paul@tomoparts.co.uk</TO>"
				+ "<TO>steve@tomoparts.co.uk</TO>"
				+ "<SUBJECT>ERRORS TO FIX!!!!!</SUBJECT>"
				+ "</EMAIL>";
		services.add(ServiceFactory.make(
				ServiceType.EMAIL_ERRORS_SERVICE,
				new EmailErrorsConfig().configure(data)
					));
		services.start(20);
		
		
//		InvoiceData id = new InvoiceData();
//		for(String[] transaction : id.getMap("200636949016"))
//		{
//			System.out.println(Arrays.toString(transaction));
//		}
	}
}
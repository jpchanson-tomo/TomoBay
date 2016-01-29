package tomoBay;
import org.apache.log4j.Logger;
import org.w3c.dom.NodeList;

import com.ebay.soap.eBLBaseComponents.OrderArrayType;
import com.ebay.soap.eBLBaseComponents.OrderType;
import com.ebay.soap.eBLBaseComponents.TransactionType;

import tomoBay.helpers.Config;
import tomoBay.helpers.ConfigReader;
import tomoBay.helpers.ShippingPriority;
import tomoBay.helpers.XMLParser;
import tomoBay.helpers.checkTime.CheckTime;
import tomoBay.model.dataTypes.order.Order;
import tomoBay.model.dataTypes.order.OrderDataFields;
import tomoBay.model.eBayAPI.OrderTransactionsCall;
import tomoBay.model.eBayAPI.OrdersCall;
import tomoBay.model.services.ServiceFactory;
import tomoBay.model.services.ServiceScheduler;
import tomoBay.model.services.ServiceFactory.ServiceType;
import tomoBay.model.services.emailErrorsService.EmailErrorsConfig;
import tomoBay.model.services.invoiceOrdersService.invoice.Invoice;
import tomoBay.model.winstock.Stock;
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
		
		ServiceScheduler services = new ServiceScheduler(5);
//		services.add(ServiceFactory.make(ServiceFactory.ServiceType.STOPGAP_SERVICE), 0, 1);
//		services.add(ServiceFactory.make(ServiceFactory.ServiceType.INVOICE_SERVICE));
		services.add(ServiceFactory.make(ServiceFactory.ServiceType.EBAY_SERVICE));
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
		
		
//		Order order = new Order("200733860016");
//		System.out.println(order.getBuyerInfo(OrderDataFields.NAME));
//		System.out.println(order.getBuyerInfo(OrderDataFields.STREET1));
//		System.out.println(order.getBuyerInfo(OrderDataFields.STREET2));
//		System.out.println(order.getBuyerInfo(OrderDataFields.CITY));
//		System.out.println(order.getBuyerInfo(OrderDataFields.COUNTY));
//		System.out.println(order.getBuyerInfo(OrderDataFields.POSTCODE));
//		System.out.println(order.getPriceInfo(0, OrderDataFields.ORDER_TOTAL));
//		System.out.println(order.getPriceInfo(0, OrderDataFields.SHIPPING_COST));
//		
//		int noTransactions = order.getQuantityInfo(0, OrderDataFields.TRANSACTION_QUANTITY);
//		
//		for (int i = 0 ; i < noTransactions ; ++i)
//		{
//			for(int j = 0 ; j < order.getPartInfo(i, OrderDataFields.PART_QUANTITY).length ; ++j)
//			{
//				System.out.println(order.getPartInfo(i, OrderDataFields.PART_NUMBER)[j]+" , "
//				+order.getPartInfo(i, OrderDataFields.PART_DESCRIPTION)[j]+" , "
//				+order.getPartInfo(i, OrderDataFields.PART_QUANTITY)[j]+" , "
//				);
//			}
//			System.out.println
//			(
//				order.getPriceInfo(i, OrderDataFields.TRANSACTION_PRICE)+" "
//			);
//		}
		
	}
}
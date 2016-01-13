package tomoBay;
import com.ebay.soap.eBLBaseComponents.OrderArrayType;
import com.ebay.soap.eBLBaseComponents.OrderType;
import com.ebay.soap.eBLBaseComponents.TransactionType;

import tomoBay.helpers.ConfigReader;
import tomoBay.model.eBayAPI.OrderTransactionsCall;
import tomoBay.model.eBayAPI.OrdersCall;
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
//		services.add(ServiceFactory.make(ServiceFactory.ServiceType.EBAY_SERVICE), 0, 20);
		services.start();
		
		
		
//		String[] credentials = ConfigReader.read("./config/", "ebay.cfg");
//		String[] orderIds = new String[] {"200733860016"};
//		OrderArrayType order = new OrderTransactionsCall(credentials[4], credentials[3]).call(orderIds);
//		OrderType ord = order.getOrder(0);
//		System.out.println
//				(
//					"order Total: " + ord.getTotal().getValue() + "\n"
//					+ "order SubTotal: " + ord.getSubtotal().getValue() + "\n"
//					+"number of transactions: " + ord.getTransactionArray().getTransactionLength()
//				);
//		
//		for (TransactionType transaction : ord.getTransactionArray().getTransaction())
//		{
//			System.out.println
//				(
////						"transaction  total: " + transaction.getTotalPrice().getValue() + "\n"
//						"transaction  transaction price " + transaction.getTransactionPrice().getValue() + "\n"
//						+"transaction qty: " + transaction.getQuantityPurchased() + "\n"
//				);
//			
//		}
	}
}
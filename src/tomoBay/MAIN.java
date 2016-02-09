package tomoBay;
import org.apache.log4j.Logger;

import tomoBay.helpers.BrandToCode;
import tomoBay.model.dataTypes.ServerStatus;
import tomoBay.model.dataTypes.financial.GBP;
import tomoBay.model.dataTypes.financial.VAT;
import tomoBay.model.dataTypes.order.Order;
import tomoBay.model.dataTypes.order.OrderDataFields;
import tomoBay.model.services.ServiceFactory;
import tomoBay.model.services.ServiceFactory.ConfiguredServiceType;
import tomoBay.model.services.ServiceScheduler;
import tomoBay.model.services.emailErrorsService.EmailErrorsConfig;
import tomoBay.model.services.helpers.PartList;
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
//		System.setProperty("Log4jContextSelector", "org.apache.logging.log4j.core.async.AsyncLoggerContextSelector");
//		
		log.warn("*******************************PROGRAM START*******************************");
		final HttpServer server = new HttpServer();
		server.start(1337);
		ServerStatus.instance().setStatus(ServerStatus.RunLevel.RUNNING);
		
		final ServiceScheduler services = new ServiceScheduler(6);
//		services.add(ServiceFactory.make(ServiceFactory.ServiceType.INVOICE_SERVICE));
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

		
//		List<String[]> items = QueryInvoker.execute(QueryType.SELECT_EBAY_ITEMS, new String[]{});
//		int n = 0;
//		for (String[] item : items)
//		{
//			PartList parts = new PartList(item[4]);
//			for (int i = 0 ; i < parts.size() ; ++i)
//			{
//				String[] input = {
//									parts.getPartNumber(i),
//									getDescription(i,parts,item[3]),
//									item[3]
//								};
//				QueryInvoker.execute(QueryType.INSERT_PART, input);
//				
//				String[] input2 = {
//									item[0],
//									parts.getPartNumber(i),
//									getDescription(i,parts,item[3]),
//									item[3]
//								};
//				System.out.println(Arrays.toString(input));
//				System.out.println(Arrays.toString(input2));
//				QueryInvoker.execute(QueryType.INSERT_PART_MAPPING, input2);
//			}
//			n++;
//		}
//		
//		System.out.println(n);
		
//		Order order = new Order("331614897832-1241551309014");
//		System.out.println(order.buyerID());
//		System.out.println(order.buyerName());
//		System.out.println(order.noOfTransactions());
//		System.out.println(order.orderPrice());
//		System.out.println(order.orderID());
		
		
		
	}
	
//	private static String getDescription(int index, PartList parts, String brand)
//	{
//		String result = new Stock()
//					.requestDescription(parts.getPartNumber(index), BrandToCode.convert(brand));
//		int endOfString = result.indexOf("�");
////		int endOfString = result.indexOf("œ");
//		result = result.substring(0, endOfString);
//		return result;
//	}
}
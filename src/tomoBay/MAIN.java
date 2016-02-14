package tomoBay;
import org.apache.log4j.Logger;

import tomoBay.model.dataTypes.ServerStatus;
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
	static private Logger log = Logger.getLogger(MAIN.class.getName());
	
	public static void main(String[] args) throws Exception
	{
		System.setProperty("Log4jContextSelector", "org.apache.logging.log4j.core.async.AsyncLoggerContextSelector");
		
		log.warn("*******************************PROGRAM START*******************************");
		final HttpServer server = new HttpServer();
		server.start(1337);
		ServerStatus.instance().setStatus(ServerStatus.RunLevel.RUNNING);
//		
//		final ServiceScheduler services = new ServiceScheduler(6);
////		services.add(ServiceFactory.make(ServiceFactory.ServiceType.INVOICE_SERVICE));
//		services.add(ServiceFactory.make(ServiceFactory.ServiceType.EBAY_SERVICE));
//		services.add(ServiceFactory.make(ServiceFactory.ServiceType.OUT_OF_HOURS_SERVICE));
//		services.add(ServiceFactory.make(ServiceFactory.ServiceType.RESCAN_ERRORS_SERVICE));
//		services.add(ServiceFactory.make(ServiceFactory.ServiceType.CHECK_ERRORS));
//		final String data = "<EMAIL>"
//				+ "<TO>tomomotorbay@gmail.com</TO>"
//				+ "<TO>paul@tomoparts.co.uk</TO>"
//				+ "<TO>steve@tomoparts.co.uk</TO>"
//				+ "<SUBJECT>ERRORS TO FIX!!!!!</SUBJECT>"
//				+ "</EMAIL>";
//		services.add(ServiceFactory.make(
//										ConfiguredServiceType.EMAIL_ERRORS_SERVICE,
//										new EmailErrorsConfig().configure(data)
//										));
//		services.start(20);

		
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
////		Order order = new Order("201752468016");
//		Order order = new Order("331548764167-1222649327014");
////		Order order = new Order("331549945006-1231178167014");
//		AbstractSalesDayBookLine invoice = new StandardInvoice(order);
//		
//		System.out.println(invoice.totalIncVat());
//		System.out.println(invoice.totalExVat());
//		
//		
//		System.out.println(order.transaction(0).listing().listingCost());
//		System.out.println(invoice.getLineItem(0).partNo(invoice));
//		System.out.println(invoice.getLineItem(0).description(invoice));
//		System.out.println(invoice.getLineItem(0).quantity(invoice));
//		System.out.println(invoice.getLineItem(0).price()+"\n");
//		
////		System.out.println(order.transaction(1).listing().listingCost());
//		System.out.println(invoice.getLineItem(1).partNo(invoice));
//		System.out.println(invoice.getLineItem(1).description(invoice));
//		System.out.println(invoice.getLineItem(1).quantity(invoice));
//		System.out.println(invoice.getLineItem(1).price());
//		
//		OrderInfo test = new OrderInfo();
//		System.out.println(test.execute("202228298016"));
//		
//		System.out.println(result);
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
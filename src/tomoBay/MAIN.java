package tomoBay;
import org.apache.log4j.Logger;

import tomoBay.model.dataTypes.ServerStatus;
import tomoBay.model.services.ServiceFactory;
import tomoBay.model.services.ServiceFactory.ConfiguredServiceType;
import tomoBay.model.services.ServiceScheduler;
import tomoBay.model.services.emailErrorsService.EmailErrorsConfig;
import tomoBay.view.HttpServer;
/**
 * The entry point into the program, this is a stopgap solution to get invoices ,of orders that
 * are completely fulfillable, printed automatically
 * 
 * @author Jan P.C. Hanson
 *
 */
public final class MAIN
{
	static final private Logger log = Logger.getLogger(MAIN.class);
	
	public static final void main(String[] args) throws Exception
	{
		System.setProperty("Log4jContextSelector", "org.apache.logging.log4j.core.async.AsyncLoggerContextSelector");
		log.warn("*******************************PROGRAM START*******************************");
		final HttpServer server = new HttpServer();
		server.start(1337);
		
		ServerStatus.instance().setStatus(ServerStatus.RunLevel.RUNNING);
		final ServiceScheduler services = new ServiceScheduler(5);
		services.add(ServiceFactory.make(ServiceFactory.ServiceType.EBAY_SERVICE));
		services.add(ServiceFactory.make(ServiceFactory.ServiceType.OUT_OF_HOURS_SERVICE));
		services.add(ServiceFactory.make(ServiceFactory.ServiceType.RESCAN_ERRORS_SERVICE));
		services.add(ServiceFactory.make(ServiceFactory.ServiceType.CHECK_ERRORS));
		final String data = "<EMAIL>"
				+ "<TO>tomomotorbay@gmail.com</TO>"
//				+ "<TO>paul@tomoparts.co.uk</TO>"
				+ "<TO>steve@tomoparts.co.uk</TO>"
				+ "<SUBJECT>ERRORS TO FIX!!!!!</SUBJECT>"
				+ "</EMAIL>";
		services.add(ServiceFactory.make(
										ConfiguredServiceType.EMAIL_ERRORS_SERVICE,
										new EmailErrorsConfig().configure(data)
										));
		services.start(20);
		
		
//		GetSessionID sesid = new GetSessionID("AgAAAA**AQAAAA**aAAAAA**0GbQVg**nY+sHZ2PrBmdj6wVnY+sEZ2PrA2dj6wMk4GnD5GDogSdj6x9nY+seQ**zycDAA**AAMAAA**vuf8mZAWVaWRvLQ3FV/HyJdJ6kfngurBszal33drU7jupoq3YVruEMlZdpeBjxqvkcqyNkMa64UotHZ+2H2Am3yJ7dUDTju5gAYxuqQt9p4+fTJVnQ3ndUpYJGtO/gCEWGTM4WP4i8sdTgrw+B4tsu9ZyQFr1uYdr6BYqPgD1K/CNV/xUOmtIqmoPI1m6guV5hpXI+Th3814tJub+zThmJBQIusb47qO8Lx7VSJc/gyDY6TQwctfu5Xvs3EN/8g4iuUR+wZzzg2/k8eL+6SuSgrC4W31ZDboFQWs13t3AiD7vsWhiNdeELTHigRZSokHbzbmq191pX7DdmWjYon3Z2G2nu/pdQuc5P2tAgGzhxcIlfN8XS+FCZupuWXM44FpRfYORKCHioE7gcvIAvOPbA5xRVUVOqRKr+Qz/Qq2ItiEwWDbv4DbyElLjmcMfCjioBd9L4BF2DvaZ/9n6DPK7XpHhbfDJHDelm2RV0Li7FNPWRyRFg52gmCKR2DN3f9GQ3xUpM1r9EgjdlauwFBr6e7hC3iZkV4AwEYBBG3k9UR330ZZISE7HFkFMSDJfFoLVj6zWsx3Vylky7WLzj+tvrWtEQTILP6x46WkQjAEz/it3t1z2ECthkdjBFh/1X1VMS16YErN45m6WJcvOg8F6nxQ5YxqWYHqqJXVzRzwCGe35yfAHargvftaVqVJgi1B5pxOjtbgLmoqknwYc9lsSQMkWPfCsjFGXqh1WZnfH1U5srQb64X+eF1bFAY/29VK","https://api.ebay.com/wsapi");
//		sesid.call("Jan_Phillip_Cam-JanPhill-6fd5-4-buavjdfm");
//		HeteroFieldContainer parameters = new HeteroFieldContainer();
//		parameters.add(OrderStatusTable.ORDER_ID, "331710471405-1263043868014");
//		ModifyQueryInvoker.execute(ModifyQueryTypeParams.INSERT_ORDER_IN_ORDER_STATUS, parameters);
//		ModifyQueryInvoker.execute(QueryType.DELETE_ORDER_FROM_ORDER_STATUS, parameters);
//		List<HeteroFieldContainer> t = SelectQueryInvoker.execute(SelectQueryTypeParams.SELECT_EBAY_ORDER_BY_ID, parameters);
//		for(HeteroFieldContainer f : t)
//		{
//			System.out.println(f.get(OrdersTable.INVOICED, ClassRef.INTEGER));
//		}
//		System.out.println(parameters.get(NonDBFields.RESULT_CODE, ClassRef.INTEGER));
	}
}
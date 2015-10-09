package openDMS.ebay;
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
import openDMS.model.services.EbayService;
import openDMS.model.services.ServicesScheduler;
import openDMS.model.services.TestService;
import openDMS.view.HttpServer;

/**
 * The entry point into the program
 * 
 * @author Jan P.C. Hanson
 *
 */
public class MAIN
{
	private static final String userToken = "AgAAAA**AQAAAA**aAAAAA**s6cKVg**nY+sHZ2PrBmdj6wVnY+sEZ2PrA2dj6wFk4GhDpGFoAidj6x9nY+seQ**MpQDAA**AAMAAA**4Aqt9SemYN6DehoPdEsoWuFqCELKvJyBaHL5q1gdWL40la/sjo+abdJSSvNmW8aGcgrgiEXsXJdO+C8RV4lVLvjLnZM0Sadri0BUqP1EK4OTdZWMh8DqaqAqiCi/RhzB+OvHmUd7g5aztZn+wTAIDdglX1cBsJNWnDo4Y9CmK0Et0tbiEiMabvPyO8zwR/Touug6qWkQK488NxJtdo+ZrNZKQ33XXOIoC+nwj8py85vXzxq029DvF31Wmk6ZZcnAuBnpWu8l6h1V+nEPy5V4f1lCIiJdSs++wKP0Dw8FkIXsiTOO4c4LF67gU35LNlaiE/GunY/yJuDeXQ6AJB0RLoFQck+LaEJ2OGH6ZPyzITTWTkf8qY6PBTRE7tCe8okI/Qnbcc6Y6Rol80uJtDQ27Jf7H1XoHoVOgQtTWcZa0BYP7Vbqo54lGyOsVnAHGZ4so+T9WvhZ/MJOacbou9YUptwPYfZwQsTnl0BvVgd6bt5XPsao54A+9ujPhZM5gk0/l9CnG4g47P+jiUtVyw4Gp4cD4fUzRMGK5hQ2jwm+/zK+kokExZbhpIiJBozA7n+5UPRwlmxh8fg1YBW0J0S7/BXBk4zNmpkYOwVQR4kj56/t5fcI9cYfzonRpnn7VUonD21KE6/1lZVsF0/OKoi8OU+xEJZlc8f1E3gv5MYN/qkcjDIn0lq6Fp+1fx6Yod2x1cUfIIXLsdQhqhcZ82LhdfWY/5QdoYGNN2M30yq+6tp4krIx5xBZvBzE8I1sqaRM";
	private static final String server = "https://api.sandbox.ebay.com/wsapi";
	
	public static void main(String[] args) throws Exception
	{
		System.out.println("starting program");
		System.setProperty("Log4jContextSelector", "org.apache.logging.log4j.core.async.AsyncLoggerContextSelector");
		
		ServicesScheduler services = new ServicesScheduler(2);
		HttpServer uiServer = new HttpServer();
		services.add(new TestService(),0,1);
		services.add(new EbayService(), 1, 3);
		
		uiServer.start(1337);
		services.start();
		
		
		
//		ApiCallData callData = new ApiCallData(userToken, server);
//		
////		ApiOrderData oData = new ApiOrderData();
////		ApiItemData iData = new ApiItemData();
////		ApiTransactionData tData = new ApiTransactionData();
////		
////		
////		OrdersCall orders = new OrdersCall(userToken, server);
////		ItemCall item = new ItemCall(userToken, server);
////		
////		
////		orders.call(oData, 5);
////		tData.addData(oData.accessData(0).getTransactionArray().getTransaction()[0]);
////		item.call(iData, tData.accessData(0).getItem().getItemID());
////		
////		System.out.println(oData.accessData(0).getBuyerUserID());
////		System.out.println(iData.accessData(0).getDescription());
////		
//		GetOrderListCommand tmp = new GetOrderListCommand();
//		GetTransactionListCommand tmp2 = new GetTransactionListCommand();
//		GetItemCommand tmp3 = new GetItemCommand();
//		
//		System.out.println(tmp.execute(callData, 0, ""));
//		System.out.println(tmp2.execute(tmp.getCallData(), 0, ""));
//		System.out.println(tmp2.execute(tmp.getCallData(), 1, ""));
//		System.out.println(tmp2.execute(tmp.getCallData(), 2, ""));
//		System.out.println(tmp3.execute(callData, 0, "110169881252"));
//		System.out.println(tmp3.execute(callData, 0, "110169823130"));
//
//		
////		QueryInvoker invoker = new QueryInvoker(userToken, server);
////		System.out.println(invoker.execute("getOrders", 0, ""));
////		System.out.println(invoker.execute("getTransactions",0,""));
////		System.out.println(invoker.execute("getTransactions",1,""));
////		System.out.println(invoker.execute("getTransactions",2,""));
////		System.out.println(invoker.execute("getItem",0,"110169881252"));
////		System.out.println(invoker.execute("getItem",0,"110169823130"));
		
		System.out.println("end of program");
	}
}

package openDMS.ebay;

import openDMS.ebay.query.data.ApiOrderData;
import openDMS.ebay.query.recievers.OrdersCall;

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
	
	public static void main(String[] args)
	{
		System.setProperty("Log4jContextSelector", "org.apache.logging.log4j.core.async.AsyncLoggerContextSelector");
		
		ApiOrderData data = new ApiOrderData();
		OrdersCall orders = new OrdersCall(userToken, server);
		
		orders.call(data, 5);
		
		System.out.println(data.accessData(0).getBuyerUserID());
		
	}
}

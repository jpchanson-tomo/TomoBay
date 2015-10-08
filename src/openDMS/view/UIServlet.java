package openDMS.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import openDMS.presenters.root.RootPresenter;
import openDMS.view.views.RootView;

/**
 *
 * @author Jan P.C. Hanson
 *
 */
public class UIServlet extends HttpServlet
{
	private static final String userToken = "AgAAAA**AQAAAA**aAAAAA**s6cKVg**nY+sHZ2PrBmdj6wVnY+sEZ2PrA2dj6wFk4GhDpGFoAidj6x9nY+seQ**MpQDAA**AAMAAA**4Aqt9SemYN6DehoPdEsoWuFqCELKvJyBaHL5q1gdWL40la/sjo+abdJSSvNmW8aGcgrgiEXsXJdO+C8RV4lVLvjLnZM0Sadri0BUqP1EK4OTdZWMh8DqaqAqiCi/RhzB+OvHmUd7g5aztZn+wTAIDdglX1cBsJNWnDo4Y9CmK0Et0tbiEiMabvPyO8zwR/Touug6qWkQK488NxJtdo+ZrNZKQ33XXOIoC+nwj8py85vXzxq029DvF31Wmk6ZZcnAuBnpWu8l6h1V+nEPy5V4f1lCIiJdSs++wKP0Dw8FkIXsiTOO4c4LF67gU35LNlaiE/GunY/yJuDeXQ6AJB0RLoFQck+LaEJ2OGH6ZPyzITTWTkf8qY6PBTRE7tCe8okI/Qnbcc6Y6Rol80uJtDQ27Jf7H1XoHoVOgQtTWcZa0BYP7Vbqo54lGyOsVnAHGZ4so+T9WvhZ/MJOacbou9YUptwPYfZwQsTnl0BvVgd6bt5XPsao54A+9ujPhZM5gk0/l9CnG4g47P+jiUtVyw4Gp4cD4fUzRMGK5hQ2jwm+/zK+kokExZbhpIiJBozA7n+5UPRwlmxh8fg1YBW0J0S7/BXBk4zNmpkYOwVQR4kj56/t5fcI9cYfzonRpnn7VUonD21KE6/1lZVsF0/OKoi8OU+xEJZlc8f1E3gv5MYN/qkcjDIn0lq6Fp+1fx6Yod2x1cUfIIXLsdQhqhcZ82LhdfWY/5QdoYGNN2M30yq+6tp4krIx5xBZvBzE8I1sqaRM";
	private static final String server = "https://api.sandbox.ebay.com/wsapi";
	private static final String productionToken = "AgAAAA**AQAAAA**aAAAAA**4tcTVg**nY+sHZ2PrBmdj6wVnY+sEZ2PrA2dj6wFkoujC5mDqAqdj6x9nY+seQ**kQQDAA**AAMAAA**ilVcADfxf7JwysgfZrD35zyh0fs4LpTwAGFfiOIv7Bka9ztFrnmfhHaYVHJmNvmf63bF1fkz1gjdTE3Uq6cGnyQiLJw/v6850sx/O61iOiC6jzDR2Z+a6euBFkoepDu76cFdyYsNSftTuaEe901/EJFsD1zLszVwgJRtGmC1fw4TqmqOH8rncBjWpq16DWNJpzdISwgiEEPy9FZ7zErE8Ss84tu7RGO/uQtOiSglq6pXaGtnjOY7McNE8gtxIavzL6veZbC+7GjdaF3jp1ib5U1bUYrW4vfF+uXDRRmJzU4qP8/GGSy5ZpwUGt1E/5Od1rvgQXp/baEuwFtzUXI/A0jmMlA6weVGaTD+KS2eH8GsVSSJtl8nVTqRV4HBI57d1ASV5DVgok0uvSAaGaMn4Mmka5ps8EgyhbECl0S29CpdOeXL/O+bcEL0dp1ETUerkq7wWyoMC1bvhw2cMjBEBDyTf59IioXxYzNsxu6vk7ZaZLVkzlhxh3dCL7mOm1ptDjXeqtqEQrJ4zGclHEP0DGPnnu8Ch0JUc40V78Ee6qDo9aB8V5/3nqY2JjXjbIaeVwiSaJZb93H/SNxeZnVMU4gIt6yd9l3VA3sv8ZthnJ5EclNHBV4oqZ+LHD3uSDgt8a+/j4018l21Jbf8d0cDA9TBqBkgQNcKSSI3RUfIZtK3P/gQ0tAxSREU5Y7rWgsH24LdVYb/1v27c8nR7BmIc5TfGMY4if5R/lhtJtM9HBMuWp+bbtj5OQCW32mH7myz";
	private static final String productionServer = "https://api.ebay.com/wsapi";
	/**!!!WARNING DO NOT MODIFY.... EVER .... NOT THREAD SAFE !!!**/
	private static Map<String, String> views_M;
	
	/**
	 * needed to avoid warnings
	 */
	private static final long serialVersionUID = -417534770555839323L;
	
	/**
	 * instantiates a servlet using the views provided.
	 * @param views
	 */
	public UIServlet(Map<String, String> views)
	{
		super();
		UIServlet.views_M = views;
	}

	/**
	 * service method, this controls how the servlet responds to particular URL query strings
	 * @param request the http request to the servlet
	 * @param response the http response to the servlet
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException
	{
		PrintWriter out = response.getWriter();
		
		RootView test = new RootView();
		String viewParam = request.getParameter("view");

		if (UIServlet.views_M.containsKey(viewParam))
		{
			out.write(UIServlet.views_M.get(viewParam));
		}

		else
		{
			out.write(new RootPresenter().present(test));
//			out.write(UIServlet.views_M.get("root"));
		}
		
		
		
		
		
		
		
		
		
		
		
//		String command = request.getParameter("command");
//		String parameter = request.getParameter("param");
//		
//		ApiCallData callData = new ApiCallData(productionToken, productionServer);
//		GetOrderListCommand orders = new GetOrderListCommand();
//		GetTransactionListCommand transactions = new GetTransactionListCommand();
//		GetItemCommand item = new GetItemCommand();
//		
//		if(command.equals("getOrders"))
//		{
//			orders.execute(callData, 0, "");
//			transactions.execute(orders.getCallData(), 0, "");
//			for (int i = 0; i < orders.getCallData().accessOrderData().size(); ++i)
//			{
//				out.print(transactions.execute(orders.getCallData(), i, ""));
//			}
//			
//		}
//		
//		else if (command.equals("getItem"))
//		{
//			out.print(item.execute(callData, 0, parameter));
//		}
//		
//		else
//		{out.print("no valid command specified.....sorry");}		
	}
}

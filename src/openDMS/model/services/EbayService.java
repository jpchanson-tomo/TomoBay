package openDMS.model.services;
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
import openDMS.ebay.query.commands.GetItemCommand;
import openDMS.ebay.query.commands.GetOrderListCommand;
import openDMS.ebay.query.commands.GetTransactionListCommand;
import openDMS.ebay.query.data.ApiCallData;
/**
 *
 * @author Jan P.C. Hanson
 *
 */
public class EbayService implements AbstractService
{
	
	private static final String productionToken = "AgAAAA**AQAAAA**aAAAAA**4tcTVg**nY+sHZ2PrBmdj6wVnY+sEZ2PrA2dj6wFkoujC5mDqAqdj6x9nY+seQ**kQQDAA**AAMAAA**ilVcADfxf7JwysgfZrD35zyh0fs4LpTwAGFfiOIv7Bka9ztFrnmfhHaYVHJmNvmf63bF1fkz1gjdTE3Uq6cGnyQiLJw/v6850sx/O61iOiC6jzDR2Z+a6euBFkoepDu76cFdyYsNSftTuaEe901/EJFsD1zLszVwgJRtGmC1fw4TqmqOH8rncBjWpq16DWNJpzdISwgiEEPy9FZ7zErE8Ss84tu7RGO/uQtOiSglq6pXaGtnjOY7McNE8gtxIavzL6veZbC+7GjdaF3jp1ib5U1bUYrW4vfF+uXDRRmJzU4qP8/GGSy5ZpwUGt1E/5Od1rvgQXp/baEuwFtzUXI/A0jmMlA6weVGaTD+KS2eH8GsVSSJtl8nVTqRV4HBI57d1ASV5DVgok0uvSAaGaMn4Mmka5ps8EgyhbECl0S29CpdOeXL/O+bcEL0dp1ETUerkq7wWyoMC1bvhw2cMjBEBDyTf59IioXxYzNsxu6vk7ZaZLVkzlhxh3dCL7mOm1ptDjXeqtqEQrJ4zGclHEP0DGPnnu8Ch0JUc40V78Ee6qDo9aB8V5/3nqY2JjXjbIaeVwiSaJZb93H/SNxeZnVMU4gIt6yd9l3VA3sv8ZthnJ5EclNHBV4oqZ+LHD3uSDgt8a+/j4018l21Jbf8d0cDA9TBqBkgQNcKSSI3RUfIZtK3P/gQ0tAxSREU5Y7rWgsH24LdVYb/1v27c8nR7BmIc5TfGMY4if5R/lhtJtM9HBMuWp+bbtj5OQCW32mH7myz";
	private static final String productionServer = "https://api.ebay.com/wsapi";
	
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run()
	{
		
		
		
//		ApiCallData callData = new ApiCallData(productionToken, productionServer);
//		GetOrderListCommand tmp = new GetOrderListCommand();
//		GetTransactionListCommand tmp2 = new GetTransactionListCommand();
//		GetItemCommand tmp3 = new GetItemCommand();
//		
//		
//		System.out.println(tmp.execute(callData, 0, ""));
//		System.out.println(tmp2.execute(tmp.getCallData(), 0, ""));
//		System.out.println(tmp2.execute(tmp.getCallData(), 1, ""));
//		System.out.println(tmp2.execute(tmp.getCallData(), 2, ""));
//		System.out.println(tmp3.execute(callData, 0, "110169881252"));
//		System.out.println(tmp3.execute(callData, 0, "110169823130"));
	}

}

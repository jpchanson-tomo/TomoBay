package openDMS.ebay.query.commands;

import openDMS.ebay.query.data.ApiCallData;
import openDMS.ebay.query.recievers.OrdersCall;

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

/**
 * This is a concrete command that returns a list of orders from the last day.
 * @author Jan P.C. Hanson
 *
 */
public class GetOrderListCommand extends AbstractEbayQuery
{
	/* (non-Javadoc)
	 * @see openDMS.ebay.query.commands.AbstractEbayQuery#execute()
	 */
	@Override
	public String execute(ApiCallData callData, int NOTUSED, String NOTUSEDEITHER)
	{
		super.callData_M = callData;
		
		super.callData_M.accessOrderData().clearData();
		
		OrdersCall orders = new OrdersCall(super.callData_M.getUserToken(), super.callData_M.getServerString());
		orders.call(super.callData_M.accessOrderData(), 5);
		String result="\n<orders>\n";
		
		for (int x = 0; x < super.callData_M.accessOrderData().size(); ++x)
		{
			result += "<orderNo>"+super.callData_M.accessOrderData().accessData(x).getOrderID()+"</orderNo>\n";
		}
		return result+"</orders>\n";
	}
	
	/* (non-Javadoc)
	 * @see openDMS.ebay.query.commands.AbstractEbayQuery#getCallData()
	 */
	@Override
	public ApiCallData getCallData()
	{return super.callData_M;}
}
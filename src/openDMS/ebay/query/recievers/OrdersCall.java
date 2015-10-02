package openDMS.ebay.query.recievers;
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
import openDMS.ebay.query.data.APIcontext;
import openDMS.ebay.query.data.ApiOrderData;

import com.ebay.sdk.call.GetOrdersCall;
import com.ebay.soap.eBLBaseComponents.GetOrdersRequestType;
import com.ebay.soap.eBLBaseComponents.OrderType;

/**
 *
 * @author Jan P.C. Hanson
 *
 */
public class OrdersCall extends AbstractAPIcall
{
	/**holder for the call object**/
	GetOrdersCall order_M;
	/**holder for request object**/
	GetOrdersRequestType ordreq_M;
	
	/**
	 * constructor, calls superconstructor
	 * @param usrToken
	 * @param server
	 */
	public OrdersCall(String usrToken, String server)
	{
		super(usrToken, server);
		this.order_M 
		= new GetOrdersCall(APIcontext.instance().apiContext(super.usrToken_M, super.server_M));
		this.ordreq_M = new GetOrdersRequestType();
	}

	/**
	 * This method performs a call to the API grabbing a list of orders for the specified 
	 * number of days.
	 * @param data an ApiOrderData object to populate with the orders 
	 * @param numOfDays
	 * @return ApiOrderData, populated with the orders retrieved from the API call.
	 */
	public ApiOrderData call(ApiOrderData data, int numOfDays)
	{      
        try
        {
        	this.ordreq_M.setNumberOfDays(numOfDays);
        	this.order_M.executeByApiName("GetOrders", this.ordreq_M);
        	this.order_M.setNumberOfDays(numOfDays);
        	OrderType[] ord = this.order_M.getOrders();

        	for (OrderType o: ord){data.addData(o);}
        }
        catch (Exception e){e.printStackTrace();}
       
        return data;
	}
}

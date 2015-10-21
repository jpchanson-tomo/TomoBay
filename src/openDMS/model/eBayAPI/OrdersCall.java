package openDMS.model.eBayAPI;
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
import com.ebay.sdk.ApiException;
import com.ebay.sdk.SdkException;
import com.ebay.sdk.call.GetOrdersCall;
import com.ebay.soap.eBLBaseComponents.DetailLevelCodeType;
import com.ebay.soap.eBLBaseComponents.GetOrdersRequestType;
import com.ebay.soap.eBLBaseComponents.OrderType;
import com.ebay.soap.eBLBaseComponents.SortOrderCodeType;

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
	 * constructor, initialises the OrdersCall using the credentials passed in.
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
	 * @return OrderType[] and array where each element contains order specific data type
	 * @throws Exception 
	 * @throws SdkException 
	 * @throws ApiException 
	 */
	public OrderType[] call(int numOfDays) throws ApiException, SdkException, Exception
	{
		DetailLevelCodeType[] detail = {DetailLevelCodeType.RETURN_ALL};
		
        this.ordreq_M.setNumberOfDays(numOfDays);
        this.ordreq_M.setSortingOrder(SortOrderCodeType.DESCENDING);
        this.ordreq_M.setDetailLevel(detail);
        this.order_M.executeByApiName("GetOrders", this.ordreq_M);
        this.order_M.setDetailLevel(detail);
        this.order_M.setNumberOfDays(numOfDays);
        this.order_M.setSortingOrder(SortOrderCodeType.DESCENDING);
        
        
        return this.order_M.getOrders();
	}
}

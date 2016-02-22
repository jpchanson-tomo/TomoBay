package tomoBay.model.eBayAPI;
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
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.ebay.sdk.ApiException;
import com.ebay.sdk.SdkException;
import com.ebay.sdk.call.GetOrdersCall;
import com.ebay.soap.eBLBaseComponents.DetailLevelCodeType;
import com.ebay.soap.eBLBaseComponents.GetOrdersRequestType;
import com.ebay.soap.eBLBaseComponents.OrderIDArrayType;
import com.ebay.soap.eBLBaseComponents.OrderType;
import com.ebay.soap.eBLBaseComponents.PaginationType;
import com.ebay.soap.eBLBaseComponents.SortOrderCodeType;
/**
 * This represents an eBay API call that requests information about an order
 * @author Jan P.C. Hanson
 *
 */
public class OrdersCall extends AbstractAPIcall
{
	static Logger log = Logger.getLogger(OrdersCall.class.getName());
	/**holder for the call object**/
	private GetOrdersCall order_M;
	/**holder for request object**/
	private GetOrdersRequestType ordreq_M;
	/****/
	private static final int PAGE_NO_MIN = 1;
	
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
	 * @param numOfDays the number of days to get data for
	 * @return OrderType[] and array where each element contains order specific data type
	 * @throws Exception 
	 * @throws SdkException 
	 * @throws ApiException 
	 */
	public OrderType[] call(int numOfDays) throws ApiException, SdkException, Exception
	{
		List<OrderType[]> results = new ArrayList<OrderType[]>();
		this.setUpCall(numOfDays);
        PaginationType pagination = this.setUpPagination();
        int page = OrdersCall.PAGE_NO_MIN;
        do
        {
        	pagination.setPageNumber(page);
        	this.order_M.setPagination(pagination);
        	results.add(this.order_M.getOrders());
        	log.warn("has more orders : "+this.order_M.getReturnedHasMoreOrders());
        	++page;
        }
        while(this.order_M.getReturnedHasMoreOrders());
        
        return this.reformResults(results);
	}
	
	/**
	 * this method performs a call to the API grabbing the order associated with the ID passed in.
	 * @param orderID
	 * @return
	 * @throws ApiException
	 * @throws SdkException
	 * @throws Exception
	 */
	public OrderType[] call(String orderID) throws ApiException, SdkException, Exception
	{
		OrderIDArrayType order = new OrderIDArrayType();
		order.setOrderID(new String[] {orderID});
		this.order_M.setOrderIDArray(order);
		return this.order_M.getOrders();
	}
	
	/**
	 * this method does some setup for the API call
	 * @param numOfDays the number of days to look back for results
	 */
	private void setUpCall(int numOfDays)
	{
		DetailLevelCodeType[] detail = {DetailLevelCodeType.RETURN_ALL};
		this.ordreq_M.setNumberOfDays(numOfDays);
        this.ordreq_M.setSortingOrder(SortOrderCodeType.DESCENDING);
        this.ordreq_M.setDetailLevel(detail);
        
        this.order_M.setDetailLevel(detail);
        this.order_M.setNumberOfDays(numOfDays);
        this.order_M.setSortingOrder(SortOrderCodeType.DESCENDING);
//      this.order_M.executeByApiName("GetOrders", this.ordreq_M);
	}
	
	/**
	 * do setup for the pagination.
	 * @return PaginationType containing this setup.
	 */
	private PaginationType setUpPagination()
	{
		PaginationType pagination = new PaginationType();
		pagination.setEntriesPerPage(100);
		pagination.setPageNumber(OrdersCall.PAGE_NO_MIN);
		
		return pagination;
	}
	
	/**
	 * convert the List<OrderType[]> passed in as an argument to a single OrderType[] containing
	 * all of the elements in the same order.
	 * @param results the List<OrderType[]> to convert
	 * @return OrderType[] containing all the elements of the arrays in the List<OrderType[]> 
	 */
	private OrderType[] reformResults(List<OrderType[]> results)
	{
		OrderType[] result;
		int resultSize = 0;
		if(results.size()==1) {result = results.get(0);}
		else
        {
			for(int i = 0 ; i < results.size() ; ++i){resultSize += results.get(i).length;}
			result = new OrderType[resultSize -1 ];
        
        	int lastArrayEnd = 0;
        	for(int i = 0 ; i < results.size() ; ++i)
        	{
        		for(int j = 0 ; j < results.get(i).length ; ++j)
        		{
        			result[lastArrayEnd + j] = results.get(i)[j];
        		}
        		lastArrayEnd += (results.get(i).length - 1);
        	}
        }
        
        return result;
	}
}

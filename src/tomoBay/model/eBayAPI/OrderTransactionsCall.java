package tomoBay.model.eBayAPI;

import com.ebay.sdk.ApiException;
import com.ebay.sdk.SdkException;
import com.ebay.sdk.call.GetOrderTransactionsCall;
import com.ebay.soap.eBLBaseComponents.OrderArrayType;
import com.ebay.soap.eBLBaseComponents.OrderIDArrayType;

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
 *
 * @author Jan P.C. Hanson
 *
 */
public final class OrderTransactionsCall extends AbstractAPIcall
{
	private GetOrderTransactionsCall call;
	
	public OrderTransactionsCall(String usrToken, String server)
	{
		super(usrToken, server);
		call 
		= new GetOrderTransactionsCall(APIcontext.instance().apiContext(super.usrToken_M, super.server_M));
	}
	
	public OrderArrayType call(String[] orderIds) throws ApiException, SdkException, Exception
	{
		OrderIDArrayType orderIDArray = new OrderIDArrayType();
		orderIDArray.setOrderID(orderIds);
		this.call.setOrderIDArray(orderIDArray);
		return call.getOrderTransactions();
	}
}

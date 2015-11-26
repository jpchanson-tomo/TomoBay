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
import java.util.Calendar;

import com.ebay.sdk.ApiException;
import com.ebay.sdk.SdkException;
import com.ebay.sdk.TimeFilter;
import com.ebay.sdk.call.GetSellerListCall;
import com.ebay.soap.eBLBaseComponents.ItemType;
/**
 *This represents an eBay API call requesting information about a listing.
 * @author Jan P.C. Hanson
 *
 */
public class ListingsCall extends AbstractAPIcall
{
	
	GetSellerListCall listingsCall_M;

	/**
	 * initialise the ListingsCall
	 * @param usrToken your api key
	 * @param server sandbox or production server string
	 */
	public ListingsCall(String usrToken, String server)
	{
		super(usrToken, server);
		this.listingsCall_M 
		= new GetSellerListCall(APIcontext.instance().apiContext(super.usrToken_M, super.server_M));
	}
	
	
	/**
	 * 
	 * @param startDateRange the start of the date range to get information for
	 * @param endDateRange the end of the date range to get information for
	 * @return ItemType an eBay type that contains the information about a particular order.
	 * @throws ApiException
	 * @throws SdkException
	 * @throws Exception
	 */
	public ItemType[] call(int startDateRange, int endDateRange) throws ApiException, SdkException, Exception
	{
		
		Calendar start = Calendar.getInstance();
		Calendar end = Calendar.getInstance();
		end.setTime(Calendar.getInstance().getTime());
		end.roll(Calendar.MONTH, endDateRange);
		start.setTime(Calendar.getInstance().getTime());
		start.roll(Calendar.MONTH, startDateRange);
		TimeFilter time = new TimeFilter(start, end);

		
		this.listingsCall_M.setEndTimeFilter(time);

		return this.listingsCall_M.getSellerList();
	}

}

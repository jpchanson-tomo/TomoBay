package openDMS.ebay.query.recievers;

import openDMS.ebay.query.data.APIcontext;
import openDMS.ebay.query.data.ApiItemData;

import com.ebay.sdk.call.GetItemCall;
import com.ebay.soap.eBLBaseComponents.DetailLevelCodeType;
import com.ebay.soap.eBLBaseComponents.GetItemRequestType;
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
public class ItemCall extends AbstractAPIcall
{
	/**holder for the call object**/
	GetItemCall item_M;
	/**holder for request object**/
	GetItemRequestType itemreq_M;
	
	/**
	 * constructor, calls superconstructor and 
	 * @param usrToken
	 * @param server
	 */
	public ItemCall(String usrToken, String server)
	{
		super(usrToken, server);
		this.item_M 
		= new GetItemCall(APIcontext.instance().apiContext(super.usrToken_M, super.server_M));
		this.itemreq_M = new GetItemRequestType();
	}

	/**
	 * This method performs a call to the API grabbing a list of orders for the specified 
	 * number of days.
	 * @param data an ApiOrderData object to populate with the orders 
	 * @param numOfDays
	 * @return ApiOrderData, populated with the orders retrieved from the API call.
	 */
	public ApiItemData call(ApiItemData data, String itemId)
	{     
		DetailLevelCodeType[] detail = {DetailLevelCodeType.RETURN_ALL};
		ApiItemData itemdata = data;
        try
        {
        	this.itemreq_M.setItemID(itemId);
	        this.itemreq_M.setIncludeItemSpecifics(true);
	        this.itemreq_M.setDetailLevel(detail);
	        this.item_M.executeByApiName("GetItem", this.itemreq_M);
	        this.item_M.setItemID(itemId);
	        this.item_M.setIncludeItemSpecifics(true);
	        this.item_M.setDetailLevel(detail);
	        
	        itemdata.addData(this.item_M.getItem());
        }
        catch (Exception e){e.printStackTrace();}
       
        return itemdata;
	}
}

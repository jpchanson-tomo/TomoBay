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
import com.ebay.sdk.call.GetItemCall;
import com.ebay.soap.eBLBaseComponents.DetailLevelCodeType;
import com.ebay.soap.eBLBaseComponents.GetItemRequestType;
import com.ebay.soap.eBLBaseComponents.ItemType;
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
	 * This method performs a call to the API grabbing a item data for the specified 
	 * itemID.
	 * @param data an ApiOrderData object to populate with the orders 
	 * @param itemID the itemID found from the order data
	 * @return ItemType containing all item specific data
	 * @throws Exception 
	 * @throws SdkException 
	 * @throws ApiException 
	 */
	public ItemType call(String itemId) throws ApiException, SdkException, Exception
	{     
		DetailLevelCodeType[] detail = {DetailLevelCodeType.RETURN_ALL};
        
        this.itemreq_M.setItemID(String.valueOf(itemId));
	    this.itemreq_M.setIncludeItemSpecifics(true);
	    this.itemreq_M.setDetailLevel(detail);
	    this.item_M.executeByApiName("GetItem", this.itemreq_M);
	    this.item_M.setItemID(String.valueOf(itemId));
	    this.item_M.setIncludeItemSpecifics(true);
	    this.item_M.setDetailLevel(detail);

        return this.item_M.getItem();
	}
}

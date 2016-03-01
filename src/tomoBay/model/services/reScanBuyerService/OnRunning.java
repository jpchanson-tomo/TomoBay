package tomoBay.model.services.reScanBuyerService;

import tomoBay.model.eBayAPI.EbayAccounts;
import tomoBay.model.eBayAPI.OrdersCall;
import tomoBay.model.services.AbstractServiceState;
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
import com.ebay.soap.eBLBaseComponents.OrderType;

/**
 *
 * @author Jan P.C. Hanson
 *
 */
public final class OnRunning implements AbstractServiceState
{
	/**the ebay buyerID**/
	private String buyerID_M;
	
	/**
	 * default ctor
	 */
	public OnRunning(String buyerID)
	{
		super();
		this.buyerID_M = buyerID;
	}

	/* (non-Javadoc)
	 * @see tomoBay.model.services.AbstractServiceState#execute()
	 */
	@Override
	public String execute()
	{
		try
		{
			String[] order = DBActions.getLatestOrderID(this.buyerID_M);
			String account = EbayAccounts.name(Integer.parseInt(order[1]));
			String usrKey = EbayAccounts.get(account, EbayAccounts.AccountInfo.API_KEY);
			String server = EbayAccounts.get(account, EbayAccounts.AccountInfo.SERVER_ADDRESS);
			
			OrderType buyerInfo = new OrdersCall(usrKey, server).call(order[0])[0];
			String[]  updateInfo;
				
			if(buyerInfo.isIsMultiLegShipping()==true){updateInfo = this.getGSPaddress(buyerInfo);}
			else{updateInfo = this.getAddress(buyerInfo);}
			
			if(DBActions.updateBuyerTable(updateInfo).equals("1")) 
			{return "Buyer '"+this.buyerID_M+"' refreshed";}
			
			else {return "Buyer '"+this.buyerID_M+"' refresh error";}
		} 
		
		catch (ApiException e){e.printStackTrace();return "Error: ebayAPI problem";} 
		catch (SdkException e){e.printStackTrace();return "Error: ebay SDK problem";}
		catch (Exception e) {e.printStackTrace();return "Error: check buyerID";}
	}
	
	/**
	 * get the address of the buyer and convert it to a string array
	 * @param buyerInfo the raw OrderType taken frm the API call
	 * @return String[] containing the buyer information
	 * col[0] - buyerID
	 * col[1] - name
	 * col[2] - street1
	 * col[3] - street2
	 * col[4] - city
	 * col[5] - county
	 * col[6] - postcode
	 * col[7] - email
	 * col[8] - phone number
	 */
	private String[] getAddress(OrderType buyerInfo)
	{
		String[]  updateInfo =
			{
				this.buyerID_M,
				buyerInfo.getShippingAddress().getName(),
				buyerInfo.getShippingAddress().getStreet1(),
				buyerInfo.getShippingAddress().getStreet2(),
				buyerInfo.getShippingAddress().getCityName(),
				buyerInfo.getShippingAddress().getStateOrProvince(),
				buyerInfo.getShippingAddress().getPostalCode(),
				buyerInfo.getTransactionArray().getTransaction(0).getBuyer().getEmail(),
				buyerInfo.getShippingAddress().getPhone()
			};
		return updateInfo;
	}
	
	/**
	 * get the GSP (global shipping program) address of the buyer specified and convert it to 
	 * a string array.
	 * @param buyerInfo the raw OrderType taken frm the API call
	 * @return String[] containing the GSP buyer information
	 * col[0] - buyerID
	 * col[1] - name
	 * col[2] - street1
	 * col[3] - street2
	 * col[4] - city
	 * col[5] - county
	 * col[6] - postcode
	 * col[7] - email
	 * col[8] - phone number
	 */
	private String[] getGSPaddress(OrderType buyerInfo)
	{
		String[]  updateInfo =
			{
				this.buyerID_M,
				buyerInfo.getMultiLegShippingDetails().getSellerShipmentToLogisticsProvider().getShipToAddress().getReferenceID(),
				buyerInfo.getMultiLegShippingDetails().getSellerShipmentToLogisticsProvider().getShipToAddress().getName(),
				buyerInfo.getMultiLegShippingDetails().getSellerShipmentToLogisticsProvider().getShipToAddress().getStreet1(),
				buyerInfo.getMultiLegShippingDetails().getSellerShipmentToLogisticsProvider().getShipToAddress().getCityName(),
				buyerInfo.getMultiLegShippingDetails().getSellerShipmentToLogisticsProvider().getShipToAddress().getStateOrProvince(),
				buyerInfo.getMultiLegShippingDetails().getSellerShipmentToLogisticsProvider().getShipToAddress().getPostalCode(),
				buyerInfo.getTransactionArray().getTransaction(0).getBuyer().getEmail(),
				buyerInfo.getShippingAddress().getPhone()
			};	
		return updateInfo;
	}

}

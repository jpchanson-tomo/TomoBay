package tomoBay.model.services.reScanBuyerService;

import tomoBay.model.dataTypes.heteroTypeContainer.ClassRef;
import tomoBay.model.dataTypes.heteroTypeContainer.HeteroFieldContainer;
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

import tomoBay.model.sql.schema.buyerTable.BuyerTable;
import tomoBay.model.sql.schema.nonDBFields.NonDBFields;
import tomoBay.model.sql.schema.ordersTable.OrdersTable;

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
			HeteroFieldContainer order = DBActions.getLatestOrderID(this.buyerID_M);
			String account = EbayAccounts.name(order.get(OrdersTable.ACCOUNT, ClassRef.INTEGER));
			String usrKey = EbayAccounts.apiKey(account);
			String server = EbayAccounts.serverAddress(account);
			
			OrderType buyerInfo = new OrdersCall(usrKey, server)
													.call(order.get(OrdersTable.ORDER_ID, ClassRef.STRING))[0];
			
			HeteroFieldContainer  updateInfo = new HeteroFieldContainer();
				
			if(buyerInfo.isIsMultiLegShipping()==true){OnRunning.getGSPaddress(buyerInfo, updateInfo);}
			else{OnRunning.getAddress(buyerInfo, updateInfo);}
			
			if(DBActions.updateBuyerTable(updateInfo).get(NonDBFields.RESULT_CODE, ClassRef.INTEGER)==1) 
			{return "Buyer '"+this.buyerID_M+"' refreshed";}
			
			else {return "Buyer '"+this.buyerID_M+"' refresh error";}
		} 
		
		catch (ApiException e){e.printStackTrace();return "Error: ebayAPI problem";} 
		catch (SdkException e){e.printStackTrace();return "Error: ebay SDK problem";}
		catch (Exception e) {e.printStackTrace();return "Error: check buyerID";}
	}
	
	/**
	 * retrieves the personal address associated with the order passed in as an argument.
	 * @param order the OrderType representing a particular order (from ebay API)
	 * @return HeteroFieldContainer containing the address fields for this buyer
	 */
	private static void getAddress(OrderType order, HeteroFieldContainer container)
	{
		
		container.add(BuyerTable.BUYERID, order.getBuyerUserID());
		container.add(BuyerTable.NAME, order.getShippingAddress().getName());
		container.add(BuyerTable.STREET1, order.getShippingAddress().getStreet1());
		container.add(BuyerTable.STREET2, order.getShippingAddress().getStreet2());
		container.add(BuyerTable.CITY, order.getShippingAddress().getCityName());
		container.add(BuyerTable.COUNTY, order.getShippingAddress().getStateOrProvince());
		container.add(BuyerTable.POSTCODE, order.getShippingAddress().getPostalCode());
		container.add(BuyerTable.EMAIL, order.getTransactionArray().getTransaction(0).getBuyer().getEmail());
		container.add(BuyerTable.PHONE, order.getShippingAddress().getPhone());
	}
	
	/**
	 * retrieves the global shipping program address associated with the order passed in as an argument.
	 * This method will return a null pointer if the order is not applicable to the global shipping program
	 * @param order the OrderType representing a particular order (from ebay API)
	 * @return HeteroFieldContainer containing the address fields for this buyer
	 */
	private static void getGSPaddress(OrderType order, HeteroFieldContainer container)
	{
		container.add(BuyerTable.BUYERID, order.getBuyerUserID());
		container.add(BuyerTable.NAME, order.getMultiLegShippingDetails().getSellerShipmentToLogisticsProvider().getShipToAddress().getReferenceID());
		container.add(BuyerTable.STREET1, order.getMultiLegShippingDetails().getSellerShipmentToLogisticsProvider().getShipToAddress().getName());
		container.add(BuyerTable.STREET2, order.getMultiLegShippingDetails().getSellerShipmentToLogisticsProvider().getShipToAddress().getStreet1());
		container.add(BuyerTable.CITY, order.getMultiLegShippingDetails().getSellerShipmentToLogisticsProvider().getShipToAddress().getCityName());
		container.add(BuyerTable.COUNTY, order.getMultiLegShippingDetails().getSellerShipmentToLogisticsProvider().getShipToAddress().getStateOrProvince());
		container.add(BuyerTable.POSTCODE, order.getMultiLegShippingDetails().getSellerShipmentToLogisticsProvider().getShipToAddress().getPostalCode());
		container.add(BuyerTable.EMAIL, order.getTransactionArray().getTransaction(0).getBuyer().getEmail());
		container.add(BuyerTable.PHONE, order.getShippingAddress().getPhone());
	}

}

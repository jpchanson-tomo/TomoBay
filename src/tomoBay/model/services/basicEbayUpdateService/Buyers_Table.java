package tomoBay.model.services.basicEbayUpdateService;
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
import java.sql.SQLException;

import tomoBay.model.dataTypes.heteroTypeContainer.HeteroFieldContainer;
import tomoBay.model.sql.queries.ModifyQueryInvoker;
import tomoBay.model.sql.queries.ModifyQueryInvoker.QueryType;
import tomoBay.model.sql.schema.buyerTable.BuyerTable;

import com.ebay.soap.eBLBaseComponents.OrderType;
/**
 * updates the buyers table of the database with the information gleaned from an ebay api call
 * @author Jan P.C. Hanson
 *
 */
final class Buyers_Table
{
	/**
	 * default ctor
	 */
	public Buyers_Table()
	{super();}
	
	/**
	 * populates the Orders Table in the database with data grabbed from the ebay API
	 * @param credentials API credentials.
	 * @param orders list of orders.
	 * @throws SQLException 
	 */
	public static void populate(OrderType[] orders) throws SQLException
	{
		for (OrderType order : orders)
		{
			HeteroFieldContainer insertVals = new HeteroFieldContainer();
			
			if(order.isIsMultiLegShipping()==true)
			{Buyers_Table.getGSPaddress(order, insertVals);}
			
			else
			{Buyers_Table.getAddress(order, insertVals);}
			
			ModifyQueryInvoker.execute(QueryType.INSERT_EBAY_BUYERS,insertVals);
		}
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
package openDMS.ebay.query.commands;
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

import openDMS.ebay.query.data.ApiCallData;
import openDMS.ebay.query.recievers.OrdersCall;

import com.ebay.soap.eBLBaseComponents.TransactionType;
/**
 *
 * @author Jan P.C. Hanson
 *
 */
public class GetTransactionListCommand extends AbstractEbayQuery
{
	List<TransactionType[]> transactionArrayList;
	
	/**
	 * default constructor
	 */
	public GetTransactionListCommand()
	{transactionArrayList = new ArrayList<TransactionType[]>();}
	
	/* 
	 * find transactions linked to a particular orderID
	 * @param orderID the order id to find transactions for.
	 */
	@Override
	public String execute(ApiCallData callData, int index, String NOTUSED)
	{
		super.callData_M = callData;
		super.callData_M.accessTransactionData().clearData();
		
		TransactionType[] transactions = 
				super.callData_M.accessOrderData().accessData(index).getTransactionArray().getTransaction();
		
		for(TransactionType transaction : transactions)
		{super.callData_M.accessTransactionData().addData(transaction);}
		
		return this.printResults(callData, index);
	}

	/* (non-Javadoc)
	 * @see openDMS.ebay.query.commands.AbstractEbayQuery#getCallData()
	 */
	@Override
	public ApiCallData getCallData()
	{return super.callData_M;}
	
	/**
	 * 
	 * @param callData
	 * @param a
	 * @return String containing formatted results
	 */
	private String printResults(ApiCallData callData, int a)
	{
		String result="";
		for(int n = 0 ; n < callData.accessTransactionData().size() ; ++n)
		{
			result+="<Transaction>\n";
			result+="<OrderID>"+super.callData_M.accessOrderData().accessData(a).getOrderID()+"</OrderID>\n";
			result+="<TransactionID>"+super.callData_M.accessTransactionData().accessData(n).getTransactionID()+"<TransactionID>\n";
			result+="<ItemID>"+super.callData_M.accessTransactionData().accessData(n).getItem().getItemID()+"</ItemID>\n";
			result+="<Quantity>"+super.callData_M.accessTransactionData().accessData(n).getQuantityPurchased()+"</Quantity>\n";
			result+="<OrderDate>"+super.callData_M.accessOrderData().accessData(a).getCreatedTime().getTime().toString()+"</OrderDate>\n";
			result+="<OrderDate>"+super.callData_M.accessOrderData().accessData(a).getPaidTime().toString()+"</OrderDate>\n";
			result+="<BuyerName>"+super.callData_M.accessOrderData().accessData(a).getBuyerUserID()+"</BuyerName>\n";
			result+="<Name>"+super.callData_M.accessOrderData().accessData(a).getShippingAddress().getName()+"</Name>\n";
			result+="<IntName>"+super.callData_M.accessOrderData().accessData(a).getShippingAddress().getInternationalName()+"</IntName>\n";
			result+="<IntStreet>"+super.callData_M.accessOrderData().accessData(a).getShippingAddress().getInternationalStreet()+"</IntStreet>\n";
			result+="<IntState>"+super.callData_M.accessOrderData().accessData(a).getShippingAddress().getInternationalStateAndCity()+"</IntState>\n";
			result+="<Country>"+super.callData_M.accessOrderData().accessData(a).getShippingAddress().getCountryName()+"</Country>\n";
			result+="<Street1>"+super.callData_M.accessOrderData().accessData(a).getShippingAddress().getStreet()+"</Street1>\n";
			result+="<Street2>"+super.callData_M.accessOrderData().accessData(a).getShippingAddress().getStreet1()+"</Street2>\n";
			result+="<Street3>"+super.callData_M.accessOrderData().accessData(a).getShippingAddress().getStreet2()+"</Street3>\n";
			result+="<City>"+super.callData_M.accessOrderData().accessData(a).getShippingAddress().getCityName()+"</City>\n";
			result+="<State>"+super.callData_M.accessOrderData().accessData(a).getShippingAddress().getStateOrProvince()+"</State>\n";
			result+="<PostCode>"+super.callData_M.accessOrderData().accessData(a).getShippingAddress().getPostalCode()+"</PostCode>\n";
			result+="<SalesRecNo>"+super.callData_M.accessOrderData().accessData(a).getShippingDetails().getSellingManagerSalesRecordNumber()+"</SalesRecNo>\n";
			result+="<ShippingType>"+super.callData_M.accessOrderData().accessData(a).getShippingServiceSelected().getShippingService()+"</ShippingType>\n";
			result+="</Transaction>\n\n";
		}
		return result;
	}
}

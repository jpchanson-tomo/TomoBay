package openDMS.ebay.query.commands;

import openDMS.ebay.query.data.ApiCallData;

import com.ebay.soap.eBLBaseComponents.TransactionType;
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
public class GetTransactionListCommand extends AbstractEbayQuery
{

	/* 
	 * find transactions linked to a particular orderID
	 * @param orderID the order id to find transactions for.
	 */
	@Override
	public String execute(ApiCallData callData, int a, String b)
	{
		super.callData_M = callData;
		super.callData_M.accessTransactionData().clearData();
		
		TransactionType[] transactions = 
				super.callData_M.accessOrderData().accessData(a).getTransactionArray().getTransaction();
		
		String result="";
		
		for(TransactionType transaction : transactions)
		{super.callData_M.accessTransactionData().addData(transaction);}
		
		
		for(int n = 0 ; n < callData.accessTransactionData().size() ; ++n)
		{
			result+="<TransactionID>"+callData.accessTransactionData().accessData(n).getTransactionID()+"<TransactionID>\n";
			result+="<OrderID>"+callData.accessOrderData().accessData(a).getOrderID()+"</OrderID>\n";
			result+="<ItemID>"+callData.accessTransactionData().accessData(n).getItem().getItemID()+"</ItemID>\n";
			result+="<ItemTitle>"+callData.accessTransactionData().accessData(n).getItem().getTitle()+"</ItemID>\n";		
		}
		return "<Transaction>\n"+result+"</Transaction>\n";
	}

	/* (non-Javadoc)
	 * @see openDMS.ebay.query.commands.AbstractEbayQuery#getCallData()
	 */
	@Override
	public ApiCallData getCallData()
	{return super.callData_M;}

}

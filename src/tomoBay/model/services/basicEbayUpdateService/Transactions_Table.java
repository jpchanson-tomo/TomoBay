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
import tomoBay.model.services.helpers.EbayOrderCancellationStatus;
import tomoBay.model.sql.queries.ModifyQueryInvoker;
import tomoBay.model.sql.queries.ModifyQueryInvoker.QueryType;
import tomoBay.model.sql.schema.transactionsTable.TransactionsTable;

import com.ebay.soap.eBLBaseComponents.OrderType;
import com.ebay.soap.eBLBaseComponents.TransactionType;
/**
 * updates the database transactions table with information taken from the ebay orders API call.
 * @author Jan P.C. Hanson
 *
 */
final class Transactions_Table
{
	/**
	 * default ctor
	 */
	public Transactions_Table()
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
			if(order != null)
			{
				TransactionType[] transactionArray = order.getTransactionArray().getTransaction();
				for(TransactionType transaction : transactionArray)
				{
					double shippingCost = 0.00;
					try {shippingCost = transaction.getActualShippingCost().getValue();}
					catch (Exception e){}
					
					HeteroFieldContainer insertVals = new HeteroFieldContainer(); 
					
					insertVals.add(TransactionsTable.TRANSACTION_ID, Long.parseLong(transaction.getTransactionID()));
					insertVals.add(TransactionsTable.ORDER_ID, order.getOrderID());
					insertVals.add(TransactionsTable.ITEM_ID, Long.parseLong(transaction.getItem().getItemID()));
					insertVals.add(TransactionsTable.QUANTITY, transaction.getQuantityPurchased());
					insertVals.add(TransactionsTable.PRICE, (float)transaction.getTransactionPrice().getValue());
					insertVals.add(TransactionsTable.SHIPPING_COST, (float)shippingCost);
	
					if(EbayOrderCancellationStatus.isCancelled(order.getCancelStatus())==true)
					{ModifyQueryInvoker.execute(QueryType.INSERT_EBAY_TRANSACTIONS,insertVals);}
				}
			}
		}
	}
}
package tomoBay.model.services.populateInvoicesService;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * This class provides functionality to retrieve transaction data 
 * @author Jan P.C. Hanson
 *
 */
public final class TransactionData
{
	private Map<String, List<String[]>> OrderToTransactions_M;
	
	private final DBActions db;
	
	
	/**
	 * default ctor
	 */
	public TransactionData()
	{
		super();
		db = new DBActions();
		this.OrderToTransactions_M = new HashMap<String, List<String[]>>();
		this.populateOrderToTransactionMap();
	}
	
	/**
	 * retrieve the transactions associated with a particular orderID
	 * @param orderID
	 * @return
	 */
	public List<String[]> get(String orderID)
	{
		return this.OrderToTransactions_M.get(orderID);
	}
	
	/**
	 * populate the OrderToTransactions_M map where the key is the transactionID and the value is 
	 * the orderID, as one orderID can be associated with multiple unique transactions.
	 */
	private void populateOrderToTransactionMap()
	{
		final List<String[]> orders = db.getTransactionData();
		String previousOrderID="";
		for(String[] order : orders)
		{
			if(previousOrderID.equals(order[0])==false)
			{
				this.OrderToTransactions_M.put(order[0], new ArrayList<String[]>());
				this.populateOrderDataArray(order);
				previousOrderID = order[0];
			}
			else
				{this.populateOrderDataArray(order);}
		}
	}
	
	/**
	 * populate the map for the given orderID key with the rest of the data.
	 * @param order
	 */
	private void populateOrderDataArray(String[] order)
	{
		this.OrderToTransactions_M.get(order[0])
			.add(new String[] {order[1],order[2],order[3],order[4],order[5],order[6], order[7]});
	}
}

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

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import tomoBay.model.sql.queries.QueryInvoker;
import tomoBay.model.sql.queries.QueryInvoker.QueryType;
/**
 *
 * @author Jan P.C. Hanson
 *
 */
public class InvoiceData
{
	private Map<String, List<String[]>> OrderToTransactions_M;
	
	
	/**
	 * default ctor
	 */
	public InvoiceData()
	{
		super();
		this.OrderToTransactions_M = new HashMap<String, List<String[]>>();
		this.populateOrderToTransactionMap();
	}
	
	public List<String[]> getMap(String orderID)
	{
		return this.OrderToTransactions_M.get(orderID);
	}
	/**
	 * populate the OrderToTransactions_M map where the key is the transactionID and the value is 
	 * the orderID, as one orderID can be associated with multiple unique transactions.
	 */
	public void populateOrderToTransactionMap()
	{
		List<String[]> uncalculatedInvoices = QueryInvoker.execute(QueryType.SELECT_UNCALCULATED_INVOICES, new String[] {});
		
		for(String[] order : uncalculatedInvoices)
		{
			List<String[]> transactions = QueryInvoker.execute(QueryType.SELECT_TRANSACTION_BY_ORDERID, order);
			
			this.OrderToTransactions_M.put(order[0], transactions);
		}
	}
}

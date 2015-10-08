package openDMS.ebay.query;
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
import java.util.Map;

import openDMS.ebay.query.commands.AbstractEbayQuery;
import openDMS.ebay.query.commands.GetItemCommand;
import openDMS.ebay.query.commands.GetOrderListCommand;
import openDMS.ebay.query.commands.GetTransactionListCommand;
import openDMS.ebay.query.data.ApiCallData;
/**
 *
 * @author Jan P.C. Hanson
 *
 */
public class QueryInvoker
{
	/**holder for all the command objects available to the client**/
	private Map<String, AbstractEbayQuery> commandMap_M;
	/**holder for initial callData object**/
	private ApiCallData callData_M;
	
	
	/**
	 * constructor, initialises the QueryInvoker object.
	 */
	public QueryInvoker(String userToken, String serverString)
	{
		this.callData_M = new ApiCallData(userToken, serverString);
		this.commandMap_M = new HashMap<String, AbstractEbayQuery>();
		this.populateCommandMap();
	}
	
	/**
	 * executes the command selected from the invoker. It is worth noting that not all commands
	 * use the same parameters, some dont use any some just the index, some the stringParam and 
	 * some use both.
	 * @return String representative of the result of the query.
	 */
	public String execute(String command, int index, String stringParam)
	{
		AbstractEbayQuery query = this.commandMap_M.get(command);
		String result = query.execute(this.callData_M, index, stringParam);
		
		this.callData_M = query.getCallData();
		
		return result;
	}
	
	/**
	 * fills the commandMap_M with command objects.
	 */
	private void populateCommandMap()
	{
		this.commandMap_M.put("getOrders", new GetOrderListCommand());
		this.commandMap_M.put("getTransactions", new GetTransactionListCommand());
		this.commandMap_M.put("getItem", new GetItemCommand());
	}
}

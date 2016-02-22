package tomoBay.model.services.invoiceOrdersService;
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
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import tomoBay.model.dataTypes.dbType.DBSchema;
import tomoBay.model.sql.queries.QueryInvoker;
import tomoBay.model.sql.queries.QueryInvoker.QueryType;
/**
 * This class represents a list of orders that are uninvoiced and contain no errors, as well as
 * functionality to manipulate this order list.
 * 
 * @author Jan P.C. Hanson
 *
 */
public final class ValidUninvoicedOrderList
{
	/**the list of orders**/
	private List<String[]> orderList_M;
	
	/**
	 * default ctor, generates the list of orders that this object represents
	 */
	public ValidUninvoicedOrderList()
	{
		super();
		this.generateList();
	}
	
	/**
	 * returns the list of orders.
	 * @return list of orders.
	 */
	public List<Map<DBSchema,String>> get()
	{
		
		List<Map<DBSchema, String>> results = new ArrayList<Map<DBSchema, String>>();
		for(String[] order : this.orderList_M)
		{
			Map<DBSchema, String> result = new HashMap<DBSchema, String>();
			result.put(DBSchema.ORD_ORDER_ID, order[0]);
			result.put(DBSchema.ORD_SHIPPING_TYPE, order[3]);
			result.put(DBSchema.ORD_SALES_REC_NO, order[2]);
			result.put(DBSchema.ORD_CREATED_TIME, order[4]);
			results.add(result);
		}
		
		return results;
	}
	
	/**
	 * retrieve the size of the ValidUninvoicedOrderList
	 * @return int representing the size.
	 */
	public int size()
	{return this.orderList_M.size();}
	
	/**
	 * orders this list of orders first by pickeability, then by shipping status, then by date.
	 */
	public void sortList()
	{
		SortOrders sort = new SortOrders();
		this.orderList_M = sort.sortDefault(this.orderList_M, 3);
	}
	
	public String print()
	{
		String result="";
		for(String[] order : this.orderList_M) {result+=Arrays.deepToString(order)+"\n";}
		return result;
	}
	
	/**
	 * generates the list of orders and stores them internally, this method is only called by 
	 * the constructor and this.reGenerateList().
	 */
	private void generateList()
	{this.orderList_M = QueryInvoker.execute(QueryType.SELECT_UNINVOICED_ORDERS_NO_ERRORS, null);}
}

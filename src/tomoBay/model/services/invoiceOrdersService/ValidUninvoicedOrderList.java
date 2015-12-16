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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import tomoBay.model.sql.DataBaseSchema;
/**
 * This class represents a list of orders that are uninvoiced and contain no errors, as well as
 * functionality to manipulate this order list.
 * 
 * @author Jan P.C. Hanson
 *
 */
public class ValidUninvoicedOrderList
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
	public List<Map<DataBaseSchema,String>> get()
	{
		Map<DataBaseSchema, String> result = new HashMap<DataBaseSchema, String>();
		List<Map<DataBaseSchema, String>> results = new ArrayList<Map<DataBaseSchema, String>>();
		for(String[] order : this.orderList_M)
		{
			result.clear();
			result.put(DataBaseSchema.ORD_ORDER_ID, order[0]);
			result.put(DataBaseSchema.ORD_BUYER_ID, order[1]);
			result.put(DataBaseSchema.ORD_SALES_REC_NO, order[2]);
			result.put(DataBaseSchema.ORD_SHIPPING_TYPE, order[3]);
			result.put(DataBaseSchema.ORD_CREATED_TIME, order[4]);
			result.put(DataBaseSchema.ORD_PICKED, order[5]);
			result.put(DataBaseSchema.ORD_PACKED, order[6]);
			result.put(DataBaseSchema.ORD_SHIPPED, order[7]);
			result.put(DataBaseSchema.ORD_INVOICED, order[8]);
			results.add(result);
		}
		
		return results;
	}
	
	/**
	 * orders this list of orders first by pickeability, then by shipping status, then by date.
	 */
	public void sortList()
	{
		SortOrders sort = new SortOrders();
		this.orderList_M = sort.sortDefault(this.orderList_M, 8, 3);
	}
	
	/**
	 * removes orders from the list that are uninvoiceable or partially invoiceable. Will only 
	 * produce the desired result if the data has first been sorted using this.sortList()
	 */
	public void removeUninvoiceableOrders()
	{
		for(int i = 0 ; i < this.orderList_M.size() ; ++i) 
		{
			if(this.orderList_M.get(i)[8].equals("0")==false)
				
			{this.orderList_M.remove(i);}
		}
	}
	
	/**
	 * re-generates the list of orders.
	 */
	public void reGenerateList()
	{this.generateList();}
	
	/**
	 * returns true if the orderlist exists, false if it is empty.
	 * @return
	 */
	public boolean exists()
	{if (this.orderList_M.size()>0) {return true;} else {return false;}}	
	/**
	 * generates the list of orders and stores them internally, this method is only called by 
	 * the constructor and this.reGenerateList().
	 */
	private void generateList()
	{}
}

package openDMS.ebay.query.data;

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

import com.ebay.soap.eBLBaseComponents.OrderType;
/**
 *
 * @author Jan P.C. Hanson
 *
 */
public class ApiOrderData
{
	/**holder for OrderTypes**/
	private List<OrderType> orders_M;
	
	/**
	 * constructor
	 */
	public ApiOrderData()
	{this.orders_M = new ArrayList<OrderType>();}
	
	/**
	 * add OrderType data to the ApiCallData
	 * @param order the OrderType to add
	 */
	public void addData(OrderType order)
	{this.orders_M.add(order);}
	
	/**
	 * access NameValueListType data of the ApiCallData
	 * @param index the index of the data you wish to access
	 * @return OrderType
	 */
	public OrderType accessData(int index)
	{return this.orders_M.get(index);}
	
	/**
	 * removes data at a specific index
	 * @param index
	 */
	public void removeData(int index)
	{this.orders_M.remove(index);}
	
	/**
	 * clears all data from this object
	 */
	public void clearData()
	{this.orders_M.clear();}
	
	/**
	 * return the number of entries in the ApiOrderData
	 * @return int representing the number of entries.
	 */
	public int size()
	{return this.orders_M.size();}
}

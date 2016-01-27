package tomoBay.model.dataTypes.order;
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
import java.util.List;
import java.util.Map;
/**
 *
 * @author Jan P.C. Hanson
 *
 */
public class PopulateOrderInfo
{
	/**raw data**/
	private List<String[]> rawData_M;
	/**map to hold the address data**/
	private Map<OrderDataFields, String> order_M;
	
	/**
	 * 
	 */
	public PopulateOrderInfo(List<String[]> rawData)
	{
		super();
		this.rawData_M = rawData;
		this.populateOrderFields();
	}
	
	public Map<OrderDataFields, String> getInfo()
	{return this.order_M;}
	
	/**
	 * populate the address_M map with the address data stored in rawData_M
	 */
	private void populateOrderFields()
	{
		this.order_M = new HashMap<OrderDataFields, String>();
		this.order_M.put(OrderDataFields.SALES_REC_NO, this.rawData_M.get(0)[2]);
		this.order_M.put(OrderDataFields.ORDER_DATE, this.rawData_M.get(0)[3]);
		this.order_M.put(OrderDataFields.SHIPPING_TYPE, this.rawData_M.get(0)[1]);
	}
}
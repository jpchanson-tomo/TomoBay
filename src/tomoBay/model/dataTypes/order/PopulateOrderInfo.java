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
public final class PopulateOrderInfo
{
	/**
	 * 
	 */
	public PopulateOrderInfo()
	{super();}
	
	/**
	 * 
	 * @param rawData
	 * @return
	 */
	public static final Map<OrderDataFields, String> getInfo(List<String[]> rawData)
	{
		Map<OrderDataFields, String> order = new HashMap<OrderDataFields, String>();
		order.put(OrderDataFields.ORDER_ID, rawData.get(0)[0]);
		order.put(OrderDataFields.SALES_REC_NO, rawData.get(0)[2]);
		order.put(OrderDataFields.ORDER_DATE, rawData.get(0)[3]);
		order.put(OrderDataFields.SHIPPING_TYPE, rawData.get(0)[1]);
		return order;
	}
}
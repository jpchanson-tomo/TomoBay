package tomoBay.model.dataTypes.order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
public final class PopulateQuantitiesInfo
{
	/**
	 * default ctor
	 */
	public PopulateQuantitiesInfo()
	{super();}
	
	/**
	 * 
	 * @param rawData
	 * @return
	 */
	public static final List<Map<OrderDataFields, Integer>> getInfo(List<String[]> rawData)
	{
		List<Map<OrderDataFields, Integer>> quantities = new ArrayList<Map<OrderDataFields, Integer>>();
		
		for (int i = 0 ; i < rawData.size() ; ++i)
		{
			quantities.add(new HashMap<OrderDataFields, Integer>());
			quantities.get(i)
			.put(OrderDataFields.TRANSACTION_QUANTITY, rawData.size());
			quantities.get(i)
			.put(OrderDataFields.PURCHASED_QUANTITY  , Integer.parseInt(rawData.get(i)[8]));
		}
		
		return quantities;
	}
}
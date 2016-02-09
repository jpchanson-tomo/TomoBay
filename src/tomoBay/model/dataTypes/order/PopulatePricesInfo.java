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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Jan P.C. Hanson
 *
 */
public final class PopulatePricesInfo
{
	/**
	 * default ctor
	 */
	public PopulatePricesInfo()
	{super();}
	
	public final static List<Map<OrderDataFields, Double>> getInfo(List<String[]> rawData)
	{
		List<Map<OrderDataFields, Double>> prices = new ArrayList<Map<OrderDataFields, Double>>();
		for(int i = 0 ; i < rawData.size() ; ++i)
		{
			prices.add(new HashMap<OrderDataFields, Double>());
			prices.get(i)
			.put(OrderDataFields.ORDER_TOTAL      , Double.parseDouble(rawData.get(0)[9]));
			prices.get(i)
			.put(OrderDataFields.TRANSACTION_PRICE, Double.parseDouble(rawData.get(i)[19]));
			prices.get(i)
			.put(OrderDataFields.SHIPPING_COST    , Double.parseDouble(rawData.get(0)[18]));
		}
		return prices;
	}
}
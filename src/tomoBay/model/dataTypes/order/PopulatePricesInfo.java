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
public class PopulatePricesInfo
{
	/**raw data**/
	private List<String[]> rawData_M;
	/**map to hold quantity data**/
	private List<Map<OrderDataFields, Double>> prices_M;
	
	/**
	 * 
	 */
	public PopulatePricesInfo(List<String[]> rawData)
	{
		super();
		this.prices_M = new ArrayList<Map<OrderDataFields, Double>>();
		this.rawData_M = rawData;
		this.populateOrderFields();
	}
	
	public List<Map<OrderDataFields, Double>> getInfo()
	{return this.prices_M;}
	
	/**
	 * populate the address_M map with the address data stored in rawData_M
	 */
	private void populateOrderFields()
	{
		for(int i = 0 ; i < this.rawData_M.size() ; ++i)
		{
			this.prices_M.add(new HashMap<OrderDataFields, Double>());
			this.prices_M.get(i)
			.put(OrderDataFields.ORDER_TOTAL      , Double.parseDouble(this.rawData_M.get(0)[9]));
			this.prices_M.get(i)
			.put(OrderDataFields.TRANSACTION_PRICE, Double.parseDouble(this.rawData_M.get(i)[19]));
			this.prices_M.get(i)
			.put(OrderDataFields.SHIPPING_COST    , Double.parseDouble(this.rawData_M.get(0)[18]));
		}
	}
}
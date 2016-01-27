package tomoBay.helpers;

import java.util.HashMap;
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
public class Shipping_Priority
{
	private Map<String, Integer> priorityMap_M;
	
	/**
	 * 
	 */
	public Shipping_Priority()
	{
		super();
		this.priorityMap_M = new HashMap<String, Integer>();
		this.populatePriorityMap();
	}
	
	/**
	 * 
	 * @param shippingType
	 * @return
	 */
	public int getPriority(String shippingType)
	{return this.priorityMap_M.get(shippingType);}
	
	/**
	 * 
	 * @return
	 */
	public int size()
	{return this.priorityMap_M.size();}
	
	/**
	 * 
	 */
	private void populatePriorityMap()
	{
		String[] shippingTypes = ConfigReader.getConfs(Config.Ship_Type);
		for (int i = 0 ; i < shippingTypes.length ; ++i)
		{this.priorityMap_M.put(shippingTypes[i], i);}
	}
}

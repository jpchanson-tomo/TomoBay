package tomoBay.helpers;
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
/**
 * This class encapsulates the functionality for querying the shipping priority of a particular 
 * shipping type. The actual hierarchy of shipping types is taken from the config file.
 * @author Jan P.C. Hanson
 *
 */
public class Shipping_Priority
{
	private static Map<String, Integer> priorityMap_M;
	private static Shipping_Priority instance_M = new Shipping_Priority();
	
	/**
	 * singleton ctor, ensures that this class is never instantiated
	 */
	private Shipping_Priority()
	{
		super();
		Shipping_Priority.priorityMap_M = new HashMap<String, Integer>();
		Shipping_Priority.populatePriorityMap();
	}
	
	/**
	 * singleton instance method
	 * @return Shipping_Priority instance of this object
	 */
	public static Shipping_Priority instance()
	{return Shipping_Priority.instance_M;}
	
	/**
	 * gets the priority of a particular shipping type.
	 * @param shippingType String representing the shipping type you wish to find the priority of.
	 * @return integer representing the priority 0 being the highest priority and priority decreasing
	 * as the value increases.
	 */
	public static int getPriority(String shippingType)
	{return Shipping_Priority.priorityMap_M.get(shippingType);}
	
	/**
	 * get the number of shipping types in the hierarchy of shipping types
	 * @return int representing the size of the shipping type hierarchy
	 */
	public static int size()
	{return Shipping_Priority.priorityMap_M.size();}
	
	/**
	 * refreshes the internal representation of the shipping type hierarchy with any changes made to 
	 * the config file.
	 */
	public static void refresh()
	{
		Shipping_Priority.priorityMap_M.clear();
		Shipping_Priority.priorityMap_M = null;
		Shipping_Priority.populatePriorityMap();
	}
	
	/**
	 * populates the internal map containing the shipping priorities
	 */
	private static void populatePriorityMap()
	{
		String[] shippingTypes = ConfigReader.getConfs(Config.Ship_Type);
		for (int i = 0 ; i < shippingTypes.length ; ++i)
		{Shipping_Priority.priorityMap_M.put(shippingTypes[i], i);}
	}
}

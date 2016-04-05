package tomoBay.view.views.salesOrderView;

import gnu.trove.map.hash.THashMap;

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



import tomoBay.presenters.helpers.pickeability.PickeableStatus;

/**
 *
 * @author Jan P.C. Hanson
 *
 */
public final class OrderStatusContext
{

	private final static Map<Integer, String> statusMap = new THashMap<Integer,String>()
	{{
		put(PickeableStatus.ERROR.getStatusCode(),"ERROR");
		put(PickeableStatus.UNPICKEABLE.getStatusCode(),"Unpickeable");
		put(PickeableStatus.PARTIAL.getStatusCode(),"Partial");
		put(PickeableStatus.PICKEABLE.getStatusCode(),"Pickeable");
		put(PickeableStatus.PICKEABLE_PROCESSING.getStatusCode(),"Pickeable - Processing");
		put(PickeableStatus.PARTIAL_PROCESSING.getStatusCode(),"Partial - Processing");
		put(PickeableStatus.UNPICKEABLE_PROCESSING.getStatusCode(),"Unpickeable - Processing");
	}};
	
	/**
	 * 
	 */
	public OrderStatusContext()
	{super();}
	
	public static String get(int key)
	{return OrderStatusContext.statusMap.get(key);}

}

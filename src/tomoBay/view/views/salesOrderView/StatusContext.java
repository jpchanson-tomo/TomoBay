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

/**
 *
 * @author Jan P.C. Hanson
 *
 */
public final class StatusContext
{

	private final static Map<Integer, String> statusMap = new THashMap<Integer,String>()
	{{
		put(3,"ERROR");
		put(2,"Unpickeable");
		put(1,"Partial");
		put(0,"Pickeable");
		put(-1,"Pickeable - Processing");
		put(-2,"Partial - Processing");
		put(-3,"Unpickeable - Processing");
	}};
	
	/**
	 * 
	 */
	public StatusContext()
	{super();}
	
	public static String get(int key)
	{return StatusContext.statusMap.get(key);}

}

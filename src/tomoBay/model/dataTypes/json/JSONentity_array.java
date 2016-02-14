package tomoBay.model.dataTypes.json;
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

import java.util.Iterator;

import tomoBay.model.dataTypes.DualList;
/**
 *
 * @author Jan P.C. Hanson
 *
 */
public final class JSONentity_array extends JSONentity
{
	/**
	 * 
	 */
	public JSONentity_array()
	{super();}
	
	/**
	 * 
	 * @return String
	 */
	public String toString()
	{
		String objBody="[ ";
		Iterator<String> jsonIter = super.children_M.iterator();
		for(int i = 0 ; i < super.children_M.size() ; ++i)
		{
			objBody+=super.children_M.getValueByIndex(i);
			jsonIter.next();
			if(jsonIter.hasNext()){objBody+=", ";}
		}
		objBody+=" ]";
		return (objBody);
	}
}
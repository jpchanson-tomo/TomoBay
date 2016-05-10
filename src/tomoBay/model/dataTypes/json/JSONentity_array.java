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
/**
 * This class represents a JSON array. 
 * 
 * @author Jan P.C. Hanson
 *
 */
public final class JSONentity_array extends JSONentity
{
	/**
	 * default ctor
	 */
	public JSONentity_array()
	{super();}
	
	/**
	 * converts this JSON array to a string.
	 * 
	 * @return String representing the data in this array as a JSON formatted string.
	 */
	public String toString()
	{
		String objBody="[ ";
		Iterator<Integer> jsonIter = super.children_M.iterator();
		for(int i : super.children_M)
		{
			objBody+=super.children_M.getValue2(i);
			jsonIter.next();
			if(jsonIter.hasNext()){objBody+=", ";}
		}
		objBody+=" ]";
		return (objBody);
	}
}
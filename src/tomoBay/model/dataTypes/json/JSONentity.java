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
import tomoBay.model.dataTypes.DualList;
/**
 *
 * @author Jan P.C. Hanson
 *
 */
public abstract class JSONentity
{
	protected DualList<String, JSONentity> children_M;
	
	/**
	 * 
	 */
	public JSONentity()
	{
		super();
		this.children_M = new DualList<String, JSONentity>();
	}
	
	/**
	 * 
	 * @param key
	 * @param value
	 */
	public JSONentity add(String key, JSONentity value)
	{this.children_M.put("\""+key+"\"", value);return this;}
	
	/**
	 * 
	 */
	@Override
	public abstract String toString();
}

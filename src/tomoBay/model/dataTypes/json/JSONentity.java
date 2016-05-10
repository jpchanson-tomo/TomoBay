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
 * This class acts as the abstract base for all derived JSON  classes.
 * 
 * @author Jan P.C. Hanson
 *
 */
public abstract class JSONentity
{
	protected DualList<String, String> children_M;
	
	/**
	 * default ctor
	 */
	public JSONentity()
	{
		super();
		this.children_M = new DualList<String, String>();
	}
	
	/**
	 * add pre-formatted text to this derived JSON entity
	 * @param key String representing the key for a key value pair containing the preformatted text. 
	 * If this parameter is null or empty then the pre-formatted text will be added without a key.
	 * @param value The pre-formatted text to add.
	 * @return JSONentity allowing the user to chain these class methods to create larger JSON formatted
	 * strings.
	 */
	public JSONentity addPreFormatted(String key, String value)
	{
		if(key.isEmpty() || key==null) {this.children_M.put("", value);}
		else{this.children_M.put("\""+key+"\":",value);}
		return this;
	}
	
	/**
	 * A leaf node is simply a key value pair
	 * @param key the string key
	 * @param value the string value
	 * @return
	 */
	public JSONentity addLeaf(String key, String value)
	{
		if(key.isEmpty() || key==null) {this.children_M.put("", "\""+value+"\"");}
		else{this.children_M.put("\""+key+"\":", "\""+value+"\"");}
		return this;
	}
	
	/**
	 * 
	 * @param key
	 * @param value
	 */
	public JSONentity addBranch(String key, JSONentity value)
	{
		if(key.isEmpty() || key==null) {this.children_M.put("", value.toString());}
		else{this.children_M.put("\""+key+"\":", value.toString());}
		return this;
	}
	
	/**
	 * 
	 * @return
	 */
	public JSONentity clear()
	{this.children_M.clear();return this;}
	
	public void finalize() throws Throwable
	{
		super.finalize();
		this.children_M.clear();
		this.children_M=null;
	}
	/**
	 * 
	 */
	@Override
	public abstract String toString();
}

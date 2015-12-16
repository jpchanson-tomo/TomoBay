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
import java.util.ArrayList;
import java.util.List;

import tomoBay.exceptions.DualListException;
/**
 * A DualList is essentially two lists linked by the same index, so the same index refers to 
 * values in two lists at the same position, one called key, one called value. Useful when you
 * need key value pairs but only need to access them by index.
 * @author Jan P.C. Hanson
 *
 */
public class DualList<K,V>
{
	/**the key list**/
	private List<K> key_M;
	/**the value list**/
	private List<V> value_M;
	
	/**
	 * default ctor.
	 */
	public DualList()
	{
		super();
		this.key_M = new ArrayList<K>();
		this.value_M = new ArrayList<V>();
	}
	
	/**
	 * add a key value pair to the indexed map
	 * @param key the key to add
	 * @param value the value to add
	 */
	public void put(K key, V value)
	{
		this.key_M.add(key);
		this.value_M.add(value);
	}
	
	/**
	 * Returns the Key at the specified position in the DualList
	 * @param index specifies the position in the DualList
	 * @return K the key at the specified position
	 */
	public K getKeybyIndex(int index)
	{return this.key_M.get(index);}
	
	/**
	 * returns the value at the specified position in the DualList
	 * @param index Specifies the position in the DualList
	 * @return V the value at the specified position.
	 */
	public V getValueByIndex(int index)
	{return this.value_M.get(index);}
	
	/**
	 * Removes the element at the specified position in this list (optional operation). 
	 * Shifts any subsequent elements to the left (subtracts one from their indices).
	 * @param index
	 */
	public void removeAtIndex(int index)
	{
		this.key_M.remove(index);
		this.value_M.remove(index);
	}
	
	/**
	 * Removes all elements from the DualList. The DualList should be empty when this call 
	 * returns
	 */
	public void clear()
	{
		this.key_M.clear();
		this.value_M.clear();
	}
	
	/**
	 * returns the size of the DualList
	 * @return int size of DualList
	 * @throws DualListException 
	 */
	public int size()
	{
		if (this.key_M.size() == this.value_M.size())
		{return this.key_M.size();}
		else
		{throw new DualListException("DualList inconsistency error");}
	}
}

package tomoBay.model.dataTypes;
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
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/**
 * 
 *
 * @author Jan P.C. Hanson
 *
 * @param <K> the key type for individual DataSets in the list
 * @param <V> the value type for individual DataSets in the list
 */
public class DataSetList<K, V> implements Iterable<Map<K,V>>
{
	/**internal List of maps, holds the data**/
	List<Map<K,V>> dataSet_M;

	public DataSetList()
	{
		super();
		this.dataSet_M = new ArrayList<Map<K,V>>();
	}
	
	/**
	 * add a new DataSet to the list.
	 */
	public void addDataSet()
	{this.dataSet_M.add(new HashMap<K,V>());}
	
	/**
	 * retrieve a particular DataSet from the list
	 * @param index the index of the DataSet to retrieve
	 * @return
	 */
	public Map<K,V> getDataSet(int index)
	{return this.dataSet_M.get(index);}
	/**
	 * add a new data field to the specified DataSet
	 * @param index the index of the DataSet within the DataSetList
	 * @param key the name of the data field to add
	 * @param value the data contained within that data field
	 */
	public void addDataField(int index, K key, V value)
	{this.dataSet_M.get(index).put(key, value);}
	
	/**
	 * retrieve the value of a particular data field within an indexed DataSet
	 * @param index the index of the DataSet to get the dataField value of
	 * @param key the field name to retrieve data from
	 * @return V the value contained within the named data field at the specified index
	 */
	public V getDataField(int index, K key)
	{return this.dataSet_M.get(index).get(key);}
	/* (non-Javadoc)
	 * @see java.lang.Iterable#iterator()
	 */
	@Override
	public Iterator<Map<K,V>> iterator()
	{return new DataSetListIterator<Map<K,V>>(this.dataSet_M);}
	
	
	
	/**********************************************************************************ITERATOR
	 * Iterator for the DataSetList
	 * @author Jan P.C. Hanson
	 * @param <T>
	 */
	private class DataSetListIterator<T> implements Iterator<T>
	{
		/**the current index of the list**/
		private int index_M = 0;
		/**internal copy of the list **/
		private List<T> list_M;
		
		/**
		 * 
		 * @param list
		 */
		public DataSetListIterator(List<T> list)
		{
			super();
			this.list_M = list;
		}
		/* (non-Javadoc)
		 * @see java.util.Iterator#hasNext()
		 */
		@Override
		public boolean hasNext()
		{
			if(this.index_M < this.list_M.size()) {return true;}
			else{return false;}
		}
		/* (non-Javadoc)
		 * @see java.util.Iterator#next()
		 */
		@Override
		public T next()
		{
			if(this.hasNext())
			{
				T dataSet = this.list_M.get(this.index_M);
				++this.index_M;
				return dataSet;
			}
			else
			{throw new IndexOutOfBoundsException
				("reached end of array: "+this.index_M+":"+this.list_M.size());}
		}
	}//**************************************************************************ENDOF ITERATOR
}

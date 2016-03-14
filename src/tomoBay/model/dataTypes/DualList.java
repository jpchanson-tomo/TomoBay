package tomoBay.model.dataTypes;
/**_________________________________________________________________________________________________ 
 * Copyright(C) 2015 Jan P.C. Hanson & Tomo Motor Parts Limited
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
 * _________________________________________________________________________________________________
 */
import java.util.Arrays;
import java.util.Iterator;
/******************************************************************************************DualList
 * A DualList can be seen as two parralel lists of generic type, or alternatively a list containing
 * value pairs. It provides functionality to add and remove value pairs either at a specified index 
 * or from a default position.
 *
 * @author Jan P.C. Hanson
 *
 **************************************************************************************************/
public final class DualList<V1,V2> implements Iterable<Integer>
{///////////////////////////////////////////////////////////////////////////////////////////////////
	/**the array holding the value1 values**/
	private V1[] value1_M;
	/**the array holding the value2 values**/
	private V2[] value2_M;
	/**the size of this pairList i.e. how many elements independently stored in the arrays**/
	private int size;
	
	/**
	 * create an empty PairList
	 */
	@SuppressWarnings("unchecked")
	public DualList()
	{
		this.size = 0;
		this.value1_M = (V1[])new Object[size];
		this.value2_M = (V2[])new Object[size];
	}
	
	/**
	 * add a value pair to the DualList
	 * @param value1 
	 * @param value2
	 */
	public void put(V1 value1, V2 value2)
	{
		this.value1_M = Arrays.copyOf(this.value1_M, size+1);
		this.value2_M = Arrays.copyOf(this.value2_M, size+1);
		this.value1_M[size] = value1;
		this.value2_M[size] = value2;
		++this.size;
	}
	
	/**
	 * add a value pair to this DualList at the index specified
	 * @param value1 the first value in the value pair
	 * @param value2 the second value in the value pair
	 * @param index the index at which to add the value pair
	 */
	public void put(V1 value1, V2 value2, int index)
	{
		this.value1_M = Arrays.copyOf(this.value1_M, size+1);
		this.value2_M = Arrays.copyOf(this.value2_M, size+1);
		
		System.arraycopy(this.value1_M, index, this.value1_M, index+1, this.size-index);
		System.arraycopy(this.value2_M, index, this.value2_M, index+1, this.size-index);
		
		this.value1_M[index] = value1;
		this.value2_M[index] = value2;
		++this.size;
	}

	/**
	 * grows the list by the size of the DualList to append, and adds its contents after the end of 
	 * the current contents.
	 * @param dualList the DualList whose values should be appended to this one
	 * @return DualList 
	 */
	public DualList<V1,V2> append(DualList<V1,V2> dualList)
	{
		V1[] tmpVal1 = Arrays.copyOf(this.value1_M, this.size+dualList.size);
		V2[] tmpVal2 = Arrays.copyOf(this.value2_M, this.size+dualList.size);
		
		System.arraycopy(dualList.value1_M, 0, tmpVal1, size, dualList.size);
		System.arraycopy(dualList.value2_M, 0, tmpVal2, size, dualList.size);
		
		this.value1_M = tmpVal1;
		this.value2_M = tmpVal2;
		
		this.size = size + dualList.size();
		return this;
	}
	
	/**
	 * Returns the value1 at the specified position in the DualList
	 * @param index specifies the position in the DualList
	 * @return K the key at the specified position
	 */
	public V1 getValue1(int index)
	{return this.value1_M[index];}
	
	/**
	 * returns the value2 at the specified position in the DualList
	 * @param index Specifies the position in the DualList
	 * @return V the value at the specified position.
	 */
	public V2 getValue2(int index)
	{return this.value2_M[index];}

	/**
	 * removes the last value pair in the list.
	 */
	public void remove()
	{
		this.value1_M = Arrays.copyOf(this.value1_M, size-1);
		this.value2_M = Arrays.copyOf(this.value2_M, size-1);
		--this.size;
	}
	
	/**
	 * Removes the element at the specified position in this list (optional operation). 
	 * Shifts any subsequent elements to the left (subtracts one from their indices).
	 * @param index the index at which to remove a value pair
	 */
	public void remove(int index)
	{
		String[] tmpVal1 = new String[size-1];
		String[] tmpVal2 = new String[size-1];
		
		System.arraycopy(this.value1_M, 0, tmpVal1, 0, index-1);
		System.arraycopy(this.value1_M, index+1, tmpVal1, index+1, size-index-1);
		
		System.arraycopy(this.value2_M, 0, tmpVal2, 0, index-1);
		System.arraycopy(this.value2_M, index+1, tmpVal2, index+1, size-index-1);
		--this.size;
	}
	
	/**
	 * clears the dualList, when this method returns the DualList will be of size 0.
	 */
	public void clear()
	{
		System.arraycopy(this.value1_M, 0, this.value1_M, 0, 0);
		System.arraycopy(this.value2_M, 0, this.value2_M, 0, 0);
		size=0;
	}
	
	/**
	 * retrieve the size of the DualList
	 * @return int the size of the DualList
	 */
	public int size() {return this.size;}
	
	/**
	 * meaningful toString() method.
	 * @return String comprised of comma separated value pairs
	 */
	public String toString()
	{
		String result = "";
		for(int index : this)
		{result+= "["+this.value1_M[index] + ":" + this.value2_M[index] +"],";}
		return result;
	}
	
	/**
	 * provides a meaningful toString() method with the addition of being able to specify a user
	 * defined seperator for the list pairs.
	 * @param separator user defined string to be inserted between value pairs.
	 * @return String pairs of values seperated by the separator specified
	 */
	public String toString(String separator)
	{
		String result = "";
		for(int index : this)
		{result+= "["+this.value1_M[index] + ":" + this.value2_M[index] +"]"+separator;}
		return result;
	}

	/**
	 * finalizer.
	 */
	public void finalize() throws Throwable 
	{
		this.value1_M = null;
		this.value2_M = null;
		super.finalize();
	}
	/**
	 * provides an iterator over the DualList. Unusually, however, the iterator is of type Integer.
	 * this was done as there is the priority of the values is up to the user, there is no key/value
	 * relationship, and as such making this class iterable over one type of value doesnt make sense.
	 * This iterator provides syntactic suger allowing the use of the enhanced for loop as a shorthand
	 * for a standard loop.
	 * @return Iterator of type Integer
	 */
	@Override
	public Iterator<Integer> iterator()
	{return new childIterator();}
	
	/****************************************************************************************ITERATOR
	 * this private inner class provides an iterator for the above 
	 * 
	 * @author Jan P.C. Hanson
	 * @param <C>
	 *
	 ***********************************************************************************************/
	private final class childIterator implements Iterator<Integer>
	{////////////////////////////////////////////////////////////////////////////////////////////////
		int index = 0;
		
		/* (non-Javadoc)
		 * @see java.util.Iterator#hasNext()
		 */
		@Override
		public boolean hasNext()
		{if(index < value1_M.length) {return true;} else {return false;}}

		/* (non-Javadoc)
		 * @see java.util.Iterator#next()
		 */
		@Override
		public Integer next()
		{if(this.hasNext()){return (++index)-1;} {return null;}}
	}////////////////////////////////////////////////////////////////////////////////////////////////
}///////////////////////////////////////////////////////////////////////////////////////////////////
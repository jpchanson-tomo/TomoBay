package tomoBay.model.dataTypes.heteroTypeContainer;
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
import gnu.trove.map.hash.THashMap;

import java.util.Map;
/**
 * This class represents a container of AbstractField types and a value associated with this field.
 * If you REALLY need to store heterogenous types in a container then this class may be useful, but 
 * CONSIDER ALL OTHER OPTIONS FIRST.
 * @author Jan P.C. Hanson
 *
 */
public class HeteroFieldContainer
{
	/**internal storage representation for a DBFieldContainer*/
	private Map<String, Map<AbstractField, Object>> fieldMap_M;
	
	/**
	 * default ctor, initialises the HeteroFieldContainer
	 */
	public HeteroFieldContainer()
	{fieldMap_M = new THashMap<String, Map<AbstractField, Object>>();}
	
	/**
	 * add an arbitrary value to this Field container with the stipulation that this value is of 
	 * the same type as the AbstractField passed in as an argument. If the field already exists within
	 * the HeteroFieldContainer then the new value will replace the existing one.
	 * @param field AbstractField to add
	 * @param value the value of the AbstractField to add
	 * @throws ClassCastException due to mismatched types
	 */
	public <T> void add(AbstractField field, T value) throws ClassCastException 
	{
		if (value==null || (HeteroFieldContainer.isSameType(field, value.getClass()) 
																	&& this.fieldMap_M.containsKey(field.type())))
		{this.fieldMap_M.get(field.type()).put(field, value);}
		
		else
		{
			this.fieldMap_M.put(field.type(), new THashMap<AbstractField, Object>());
			this.fieldMap_M.get(field.type()).put(field, value);
		}
	}
	
	/**
	 * retrieve the the value of an AbstractField from this HeteroFieldContainer, the field should be 
	 * of the same type as the type field.
	 * @param field AbstractField to retrieve the value of
	 * @param classDef the type of the field you wish to retrieve
	 * @return <T> the value of the AbstractDBField of Type type.
	 * @throws ClassCastException due to mismatched types
	 */
	@SuppressWarnings("unchecked")
	public <T> T get(AbstractField field, Class<T> classRef) throws ClassCastException
	{
		T result=null;
		if(this.fieldMap_M.containsKey(field.type())==false) 
		{throw new NullPointerException("HeteroFieldContainer does not contain field "+field.getClass().getSimpleName());}
		if(HeteroFieldContainer.isSameType(field, classRef))
		{result = (T) this.fieldMap_M.get(field.type()).get(field);}
		return result;
	}
	
	/**
	 * clear this heterogenous field type
	 */
	public void clear() {this.fieldMap_M.clear();}
	
	/**
	 * retrieves the size of this HeteroFieldContainer
	 * @return int representing the number of fields contained within.
	 */
	public int size() 
	{
		int size=0;
		for(Map<AbstractField, Object> field : this.fieldMap_M.values())
		{
			size += field.size();
		}
		return size;
	}
	
	/**
	 * dtor
	 * @throws Throwable 
	 */
	public void finalize() throws Throwable{super.finalize();this.clear(); this.fieldMap_M=null;}
	
	/**
	 * performs a type check, assuming that field and type are of the same type then this method
	 * returns true, otherwise it will throw an exception.
	 * @param field the AbstractField that you wish to check
	 * @param classDef the type that this AbstractField should reference
	 * @return true if both field and type represent the same type otherwise throws Exception
	 * @throws ClassCastException due to mismatched types
	 */
	private static <T> boolean isSameType(AbstractField field, Class<T> classDef) throws ClassCastException
	{
		if (field.type().equalsIgnoreCase(classDef.getCanonicalName()))
		{return true;}
		
		else
		{throw new ClassCastException(field.getClass().getSimpleName()+" is a '"+field.type()+"' not an '"+classDef.getCanonicalName()+"'");}
	}
}
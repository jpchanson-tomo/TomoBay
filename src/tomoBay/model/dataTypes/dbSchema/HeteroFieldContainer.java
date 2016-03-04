package tomoBay.model.dataTypes.dbSchema;
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
import java.util.Map;
import java.util.HashMap;
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
	{fieldMap_M = new HashMap<String, Map<AbstractField, Object>>();}
	
	/**
	 * add an arbitrary value to this Field container with the stipulation that this value is of 
	 * the same type as the AbstractField passed in as an argument. 
	 * @param field AbstractField to add
	 * @param value the value of the AbstractField to add
	 * @throws ClassCastException due to mismatched types
	 */
	public <T> void add(AbstractField field, T value) throws ClassCastException 
	{
		if (HeteroFieldContainer.isSameType(field, value.getClass()) 
																		&& this.fieldMap_M.containsKey(field.type()))
		{this.fieldMap_M.get(field.type()).put(field, value);}
		
		else
		{
			this.fieldMap_M.put(field.type(), new HashMap<AbstractField, Object>());
			this.fieldMap_M.get(field.type()).put(field, value);
		}
	}
	
	/**
	 * retrieve the the value of an AbstractField from this HeteroFieldContainer, the field should be 
	 * of the same type as the type field.
	 * @param field AbstractField to retrieve the value of
	 * @param type the type of the field you wish to retrieve
	 * @return <T> the value of the AbstractDBField of Type type.
	 * @throws ClassCastException due to mismatched types
	 */
	@SuppressWarnings("unchecked")
	public <T> T get(AbstractField field, Class<T> type) throws ClassCastException
	{
		T result=null;
		if(this.fieldMap_M.containsKey(field)==false) 
		{throw new NullPointerException("HeteroFieldContainer does not contain field"+field.getClass().getSimpleName());}
		if(HeteroFieldContainer.isSameType(field, type))
		{result = (T) this.fieldMap_M.get(field.type()).get(field);}
		
		return result;
	}
	
	/**
	 * performs a type check, assuming that field and type are of the same type then this method
	 * returns true, otherwise it will throw an exception.
	 * @param field the AbstractField that you wish to check
	 * @param type the type that this AbstractField should reference
	 * @return true if both field and type represent the same type otherwise throws Exception
	 * @throws ClassCastException due to mismatched types
	 */
	private static <T> boolean isSameType(AbstractField field, Class<T> type) throws ClassCastException
	{
		if (field.type().equalsIgnoreCase(type.getSimpleName()))
		{return true;}
		
		else
		{throw new ClassCastException(field.getClass().getSimpleName()+" is a "+field.type()+" not an "+type.getSimpleName());}
	}
}
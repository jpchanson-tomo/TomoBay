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
 * This class represents a container of AbstractDBField types and a value associated with this field.
 * The purpose of this class is to provide a uniform way to provide information to a query, or to 
 * retrieve data from a query.
 * @author Jan P.C. Hanson
 *
 */
public class DBFieldContainer
{
	/**internal storage representation for a DBFieldContainer*/
	private Map<String, Map<AbstractDBField, Object>> fieldMap_M;
	
	/**
	 * default ctor, initialises the DBFieldContainer
	 */
	public DBFieldContainer()
	{fieldMap_M = new HashMap<String, Map<AbstractDBField, Object>>();}
	
	/**
	 * add an arbitrary value to this DBField container with the stipulation that this value is of 
	 * the same type as the AbstractDBField passed in as an argument. 
	 * @param field AbstractDBField to add
	 * @param value the value of the AbstractDBField to add
	 * @throws ClassCastException due to mismatched types
	 */
	public <T> void add(AbstractDBField field, T value) throws ClassCastException 
	{
		if (DBFieldContainer.isSameType(field, value.getClass()) 
																		&& this.fieldMap_M.containsKey(field.type()))
		{this.fieldMap_M.get(field.type()).put(field, value);}
		
		else
		{
			this.fieldMap_M.put(field.type(), new HashMap<AbstractDBField, Object>());
			this.fieldMap_M.get(field.type()).put(field, value);
		}
	}
	
	/**
	 * retrieve the the value of an AbstractDBField from this DBFieldContainer, the field should be 
	 * of the same type as the type field.
	 * @param field AbstractDBField to retrieve the value of
	 * @param type the type of the field you wish to retrieve
	 * @return <T> the value of the AbstractDBField of Type type.
	 * @throws ClassCastException due to mismatched types
	 */
	@SuppressWarnings("unchecked")
	public <T> T get(AbstractDBField field, Class<T> type) throws ClassCastException
	{
		T result=null;
		
		if(DBFieldContainer.isSameType(field, type))
		{result = (T) this.fieldMap_M.get(field.type()).get(field);}
		
		return result;
	}
	
	/**
	 * performs a type check, assuming that field and type are of the same type then this method
	 * returns true, otherwise it will throw an exception.
	 * @param field the AbstractDBField that you wish to check
	 * @param type the type that this AbstractDBField should reference
	 * @return true if both field and type represent the same type otherwise throws Exception
	 * @throws ClassCastException due to mismatched types
	 */
	private static <T> boolean isSameType(AbstractDBField field, Class<T> type) throws ClassCastException
	{
		if (field.type().equalsIgnoreCase(type.getSimpleName()))
		{return true;}
		
		else
		{throw new ClassCastException(field.getClass().getSimpleName()+" is a "+field.type()+" not an "+type.getSimpleName());}
	}
}
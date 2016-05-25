package tomoBayTests.testHelpers;
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
import java.lang.reflect.Field;
/**
 * ~
 * This interface allows the user access and create a PrivateField object, this allows the user direct
 * access to the private field of an object.
 * 
 * This functionality is DISGUSTING, and UNDER NO CIRCUMSTANCES SHOULD THIS FUNCTIONALITY BE USED
 * IN PRODUCTION CODE.
 * 
 * @author Jan P.C. Hanson
 *
 */
public interface FieldReflection
{
	/**
	 *	This is a disgusting class that should NEVER TO BE USED IN PRODUCTION CODE, it represents the private
	 *	field of an object defined in the constructor arguments.
	 *	
	 * @author Jan P.C. Hanson
	 *	
	 *	@param <T> the type of the private field
	 */
	class PrivateField<T>
	{
		/**the instance of the object under test**/
		private final Object objectInstance_M;
		/**the object holding the reflected field**/
		private final Field privateField_M;
		
		/**
		 * Constructs and instantiates a private field using the name of the field and the instance of the
		 * object providing that field
		 * @param objectUnderTest the instance of the object that contains this field.
		 * @param fieldName the name of the field as defined in the instance class.
		 * @throws SecurityException this class is dodgy, but you just tried to do something heinous
		 * @throws NoSuchFieldException the field does not exist, check your spelling dummy
		 */
		public PrivateField(Object objectUnderTest, String fieldName) 
		throws NoSuchFieldException, SecurityException
		{
			super();
			this.objectInstance_M = objectUnderTest; 
			this.privateField_M = this.objectInstance_M.getClass().getDeclaredField(fieldName);
			this.privateField_M.setAccessible(true);
		}
		
		/**
		 * get the current value of the field
		 * @return T the value of the field
		 * @throws IllegalArgumentException this class is dodgy, but you just tried to do something heinous
		 * @throws IllegalAccessException this class is dodgy, but you just tried to do something heinous
		 */
		@SuppressWarnings("unchecked")
		public T getField() 
		throws IllegalArgumentException, IllegalAccessException
		{return (T) this.privateField_M.get(this.objectInstance_M);}
	
		/**
		 * sets the current value of the private field to the value provided
		 * @param value the value of type T that you wish the private field to take
		 * @throws IllegalArgumentException this class is dodgy, but you just tried to do something heinous
		 * @throws IllegalAccessException this class is dodgy, but you just tried to do something heinous
		 */
		public void setField(T value) 
		throws IllegalArgumentException, IllegalAccessException
		{this.privateField_M.set(this.objectInstance_M, value);}
	}
}

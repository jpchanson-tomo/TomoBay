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
/**
 * This class contains only definitions for database types, to be used in conjunction with a derived
 * AbstractDBField type.
 * @author Jan P.C. Hanson
 *
 */
public final class TypeDef
{
	/**a String**/
	public static final String STRING = TypeDef.nameOf(ClassRef.STRING);
	/**an Integer**/
	public static final String INTEGER = TypeDef.nameOf(ClassRef.INTEGER);
	/**a Double**/
	public static final String DOUBLE = TypeDef.nameOf(ClassRef.INTEGER);
	/**a Float**/
	public static final String FLOAT = TypeDef.nameOf(ClassRef.FLOAT);
	/**a Long**/
	public static final String LONG = TypeDef.nameOf(ClassRef.LONG);
	/**a java.sql.Timestamp**/
	public static final String TIMESTAMP = TypeDef.nameOf(ClassRef.TIMESTAMP);
	/**a Byte**/
	public static final String BYTE = TypeDef.nameOf(ClassRef.BYTE);
	/**a java.util.Date**/
	public static final String DATE = TypeDef.nameOf(ClassRef.DATE);
	/**a Boolean**/
	public static final String BOOLEAN = TypeDef.nameOf(ClassRef.BOOLEAN);
	
	/**
	 * helper method, converts a class object to its name
	 * @param clazz the class to find the name of
	 * @return String representing the name of the class
	 */
	private static final String nameOf(Class<?> clazz) {return clazz.getCanonicalName();}
}

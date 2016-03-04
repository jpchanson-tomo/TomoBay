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
import tomoBay.helpers.NoImports;
/**
 * This class contains only definitions for database types, to be used in conjunction with a derived
 * AbstractDBField type.
 * @author Jan P.C. Hanson
 *
 */
@SuppressWarnings("unused")
public final class TypeDef
{
	/**a String**/
	public static final String STRING = "String";
	/**an Integer**/
	public static final String INTEGER = "integer";
	/**a Double**/
	public static final String DOUBLE = "double";
	/**a Float**/
	public static final String FLOAT = "float";
	/**a Long**/
	public static final String LONG = "long";
	/**a java.sql.Timestamp**/
	public static final String TIMESTAMP = "timestamp";
	/**a Byte**/
	public static final String BYTE = "byte";
	/**a java.util.Date**/
	public static final String DATE = "date";
}

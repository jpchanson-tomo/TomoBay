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
import java.sql.Date;
import java.sql.Timestamp;
/**
 * This class acts an enum of sorts, and provides access to parameterised Class objects, specifically
 * for use in conjunction with HeteroFieldContainer objects to retrieve fields.
 * 
 * @author Jan P.C. Hanson
 *
 */
public final class ClassRef
{
	/**a String**/
	public static final Class<String> STRING = String.class;
	/**an Integer**/
	public static final Class<Integer> INTEGER = Integer.class;
	/**a Double**/
	public static final Class<Double> DOUBLE = Double.class;
	/**a Float**/
	public static final Class<Float> FLOAT = Float.class;
	/**a Long**/
	public static final Class<Long> LONG = Long.class;
	/**a java.sql.Timestamp**/
	public static final Class<Timestamp> TIMESTAMP = Timestamp.class;
	/**a Byte**/
	public static final Class<Byte> BYTE = Byte.class;
	/**a java.util.Date**/
	public static final Class<Date> DATE = Date.class;
	/**a Boolean**/
	public static final Class<Boolean> BOOLEAN = Boolean.class;
	/**
	 * private ctor
	 */
	private ClassRef()
	{super();}

}

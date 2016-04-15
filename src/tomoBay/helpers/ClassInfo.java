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
import tomoBay.helpers.NoImports;
/**
 * This Class provides static methods to query the info of the given class. Helper for loggers
 * and the like. AVOID USING UNLESS ABSOLUTELY NEEDED.....THIS USES REFLECTION.....ITS FUGLY
 * 
 * @author Jan P.C. Hanson
 *
 */
@SuppressWarnings("unused")
public final class ClassInfo
{

	/**
	 * default ctor
	 */
	public ClassInfo()
	{super();}
	
	/**
	 * retrieves the name of the object passed in
	 * @param c the object to get the name of
	 * @return String representing the name of the object
	 */
	public static String name(Object c)
	{return c.getClass().getName();}
	
	/**
	 * returns the type of the object passed in.
	 * @param c the object to get info on
	 * @return String representing the type of the object
	 */
	public static String type(Object c)
	{return c.getClass().getTypeName();}
}

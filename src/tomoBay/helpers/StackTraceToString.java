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

import java.io.PrintWriter;
import java.io.StringWriter;
/**
 * This is a helper class that provides functionality to convert an Exception stack trace to a String,
 * this can be useful when logging exceptions to be visible in the application. 
 * @author Jan P.C. Hanson
 *
 */
public class StackTraceToString
{
	public StackTraceToString()
	{super();}
	
	/**
	 * Converts the stack trace of the exception provided into a string
	 * @param e Exception to be converted
	 * @return String representation of the stack trace.
	 */
	public static String toString(Exception e)
	{
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		e.printStackTrace(pw);
		return sw.toString();
	}
}

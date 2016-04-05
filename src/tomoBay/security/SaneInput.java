package tomoBay.security;
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
 *
 * @author Jan P.C. Hanson
 *
 */
public final class SaneInput
{

	/**
	 * 
	 */
	public SaneInput()
	{super();}
	
	/**
	 * sanitise the string so that it will have no problems on converting to json
	 * @param string
	 */
	public static final String json(String string)
	{
		String result = string;
		if(result==null) {return "";}
		if(result.contains("\n")) {result = result.replace("\n", "");}
		if(result.contains("\"")) {result = result.replace("\"","");}
		if(result.contains("\\")) {result = result.replace("\\","");}
		return result.trim();
	}

}

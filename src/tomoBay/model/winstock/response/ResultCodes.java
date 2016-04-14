package tomoBay.model.winstock.response;

import java.util.HashMap;
import java.util.Map;

import tomoBay.exceptions.NotAValidResultCodeException;

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
 * This enum defines a series of result codes applicable to the winstock responses. as well as 
 * allowing the user of this enum to 
 * @author Jan P.C. Hanson
 *
 */
public enum ResultCodes
{
	SUCCESS(0),
	TERMINATOR_ERROR(10),
	INVOICING_ERROR(100),
	ERROR_SYNTAX(-1),
	SYNTAX_ERROR(0xff),
	PRINTING_ERROR(101);
	
	/**map of the constant values to the enum constants**/
	private static final Map<Integer, ResultCodes> codesByValue = new HashMap<Integer, ResultCodes>();
	/**initialiser for the codesByValue map**/
	static
	{
		for(ResultCodes code : ResultCodes.values())
		{codesByValue.put(code.codes_M, code);}
	}
	
	/**holder for the integer values of the enum constants**/
	private int codes_M;
	
	/**
	 * private constructor to allow the enum constants to be associated with integer values
	 * @param codes
	 */
	private ResultCodes(int codes)
	{this.codes_M = codes;}
	
	/**
	 * this method allows the user to retrieve the enum const based on an integer value.
	 * @param codeNumber the numerical value to equate to an enum constant 
	 * @return ResultCodes appropriate to the integer passed in.
	 * @throws NotAValidResultCodeException 
	 */
	public static ResultCodes forValue(int codeNumber) throws NotAValidResultCodeException
	{
		if (ResultCodes.codesByValue.get(codeNumber)==null) 
		{throw new NotAValidResultCodeException(String.valueOf(codeNumber)+" is not in the list of valid result codes");}
		return ResultCodes.codesByValue.get(codeNumber);
	}
}

package tomoBay.model.winstock.payloads;
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
import java.util.HashMap;
import java.util.Map;

import tomoBay.exceptions.PayloadException;
/**
 * This Enum contains all the types that can be loaded into an AbstractPayload
 * @author Jan P.C. Hanson
 *
 */
public enum PayloadType
{
	PRINT_TYPE(35),
	PUT_INVOICE_TYPE(34),
	
	TYPE(-1),
	COMPANY(-1),
	INVOICE_NO(-1),
	PACKING_LISTS(-1),
	PRINT_COPIES(-1),
	QUANTITY(-1),
	PRICE(-1),
	INSTOCK(-1),
	INV_LINES(-1),
	
	INVOICE_ACCOUNT(9),
	NAME(51),
	ADDRESS1(51),
	ADDRESS2(51),
	CITY(51),
	COUNTY(51),
	POSTCODE(10),
	ORDER_NO(21),
	PART_NO(17),
	DESCRIPTION(31),
	;
	
	/**needed to assign values to constants**/
	private int value_M;
	
	/**map of the constant values to the enum constants**/
	private static final Map<PayloadType, Integer> payloadTypeByValue = new HashMap<PayloadType, Integer>();
	/**initialiser for the codesByValue map**/
	static
	{
		for(PayloadType type : PayloadType.values())
		{payloadTypeByValue.put(type, type.value_M);}
	}
	
	/**
	 * private ctor to allow integer values to be associated with enum constants
	 * @param value
	 */
	private PayloadType(int value)
	{this.value_M = value;}
	
	/**
	 * retrieves the integer value associated with the particular enum constant
	 * @param type the specific PayloadType to check
	 * @return int equal to the value associated with the enum constant
	 * @throws PayloadException
	 */
	public static int value(PayloadType type) throws PayloadException
	{return PayloadType.payloadTypeByValue.get(type);}
}

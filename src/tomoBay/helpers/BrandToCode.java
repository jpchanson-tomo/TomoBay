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
import gnu.trove.map.hash.THashMap;

import java.util.Map;

/**
 * This helper class converts a generic brand string into a brand code specific to the winstock
 * http api.
 * @author Jan P.C. Hanson
 *
 */
@SuppressWarnings("unused")
public class BrandToCode
{
	/**definition of the Citroes brandCode**/
	private static final String PSA = "C";
	/**definition of the Ford brandCode**/
	private static final String FORD = "F";
	/**definition of the prestige brandCode**/
	private static final String PRESTIGE = "P";
	
	/**
	 * mapping of string brandcode to integer brandcode
	 */
	private static final Map<String, Integer> intMap_M = new THashMap<String, Integer>()
	{{
		put("C", 3);
		put("F", 0);
		put("P", 8);
	}};
	
	/**
	 * defualt ctor
	 */
	public BrandToCode()
	{super();}
	
	/**
	 * converts a string like "citroen" or "fOrd" to a brandcode specific to winstock.
	 * @param brand String like "Citroen" or "Ford" to a brandcode
	 * @return String brand identifier, C for peugeot/citroen/psa, F for ford, P for everything 
	 * else.
	 */
	@Deprecated
	public static String convert(String brand)
	{
		if (brand.toLowerCase().contains("citroen")
			|| brand.toLowerCase().contains("peugeot")
			|| brand.toLowerCase().contains("psa"))
		{return BrandToCode.PSA;}
		else if (brand.toLowerCase().contains("ford"))
		{return BrandToCode.FORD;}
		else
		{return BrandToCode.PRESTIGE;}
	}
	
	/**
	 * converts converts a string like "citroen" or "fOrd" to a brandcode integer specific to winstock.
	 * @param brand brand String like "Citroen" or "Ford" to a brandcode
	 * @return String brand identifier, C for peugeot/citroen/psa, F for ford, P for everything 
	 * else.
	 */
	public static int convertToInt(String brand)
	{return BrandToCode.intMap_M.get(BrandToCode.convert(brand));}
}

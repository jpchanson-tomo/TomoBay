package tomoBay.model.dataTypes.financial;

import java.math.RoundingMode;
import java.text.DecimalFormat;
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

import tomoBay.model.services.invoiceOrdersService.invoice.Prices;

/**
 * This class provides methods that allow the mainpulation of money from great british pounds
 * to pennies, and from pennies to pounds.
 * @author Jan P.C. Hanson
 *
 */
public final class GBP
{

	/**
	 * default ctor
	 */
	public GBP()
	{super();}

	/**
	 * converts the given amount of pound into pennies (rounding down in the process)
	 * @param pounds the number of GBP to convert
	 * @return int value representing the number of pennies.
	 */
	public static final int toPennies(double pounds)
	{
		double numericalPrice = Double.parseDouble(GBP.toString(pounds));
		int result = 0;
		
		result = new Double(numericalPrice*100).intValue();
		
		return result;
	}
	
	/**
	 * converts the given integer into a pounds value
	 * @param pennies the number of pennies 
	 * @return double value representing a decimal amount of currency
	 */
	public static final double fromPennies(int pennies)
	{return ((double)pennies)/100;}
	
	/**
	 * converts the given integer to a string representing the number of pennies
	 * @param pennies
	 * @return
	 */
	public static final String toString(int pennies)
	{return String.valueOf(pennies);}
	
	/**
	 * converts the given value to a string (rounded down)
	 * @param pounds double value to convert to a string
	 * @return String containing the value in ##.## format.
	 */
	public static final String toString(double pounds)
	{
		DecimalFormat toDecimal = new DecimalFormat("##.##");
		toDecimal.setRoundingMode(RoundingMode.DOWN);
		return toDecimal.format(pounds);
	}
}

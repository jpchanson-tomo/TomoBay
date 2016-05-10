package tomoBay.model.dataTypes.financial;
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
 * This class provides methods that allow the manipulation of values to do with VAT. This class
 * does not care about sign and all methods will use the absolute value of the value provided.
 * 
 * @author Jan P.C. Hanson
 *
 */
@SuppressWarnings("unused")
public final class VAT
{

	/**
	 * default ctor
	 */
	public VAT()
	{super();}

	/**
	 * add vat to the value provided as argument
	 * @param value double value for VAT to be added to.
	 * @return double representing the original value with VAT added.
	 */
	public static final double add(double value)
	{return Math.abs(value)*1.2;}
	
	/**
	 * add vat to the value provided as argument
	 * @param value int value for vat to be added to.
	 * @return int representing the original value with VAT added.
	 */
	public static final int add(int value)
	{return VAT.doubleToInt(Math.abs(value)*1.2);}
	
	/**
	 * subtract vat to the value provided as argument
	 * @param value double representing the value to have VAT removed from.
	 * @return double representing the initial value with the VAT removed
	 */
	public static final double subtract(double value)
	{return Math.abs(value)/1.2;}
	
	/**
	 * subtract vat to the value provided as argument
	 * @param value int representing the value to have VAT removed from
	 * @return int representing the initial value with the VAT removed
	 */
	public static final int subtract(int value)
	{return VAT.doubleToInt(Math.abs(value)/1.2);}
	
	/**
	 * provides the value for VAT due on a particular value
	 * @param value double value for which VAT should be calculated
	 * @return the VAT that should be applied to the given value
	 */
	public static final double due(double value)
	{return Math.abs(value)/6;}
	
	/**
	 * provides the value for VAT due on a particular value
	 * @param value int value for which VAT should be calculated
	 * @return the VAT that should be applied to the given value.
	 */
	public static final int due(int value)
	{return VAT.doubleToInt(Math.abs(value)/6);}
	
	/**
	 * 
	 * @param value
	 * @return
	 */
	private static final int doubleToInt( double value)
	{return new Double(value).intValue();}
}

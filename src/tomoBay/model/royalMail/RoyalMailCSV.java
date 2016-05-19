package tomoBay.model.royalMail;
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
 * This class just holds references to the column indices for a RoyalMail CSV corresponding to the
 * tomoBay CSV format as defined in the Royal Mail DMO.
 * 
 * @author Jan P.C. Hanson
 *
 */
@SuppressWarnings("unused")
public final class RoyalMailCSV
{
	/**defines the position in the CSV of the service reference column**/
	public static final int SERVICE_REF = 0;
	/**defines the position in the CSV of the service column**/
	public static final int SERVICE = 1;
	/**defines the position in the CSV of the recipient column**/
	public static final int RECIPIENT= 2;
	/**defines the position in the CSV of the first address line column**/
	public static final int ADDRESS_LINE_1= 3;
	/**defines the position in the CSV of the second address line column**/
	public static final int ADDRESS_LINE_2= 4;
	/**defines the position in the CSV of the postcode column**/
	public static final int POSTCODE = 5;
	/**defines the position in the CSV of the post town column**/
	public static final int POST_TOWN= 6;
	/**defines the position in the CSV of the country code column**/
	public static final int COUNTRY_CODE= 7;
	/**defines the position in the CSV of the reference column**/
	public static final int REFERENCE= 8;
	/**defines the position in the CSV pf the items column**/
	public static final int ITEMS = 9;
	/**defines the position in the CSV of the weight column**/
	public static final int WEIGHT = 10;
	/**defines the position in the CSV of the service enhancement column**/
	public static final int SERVICE_ENHANCEMENT= 11;
	/**defines the position in the CSV of the service format column**/
	public static final int SERVICE_FORMAT= 12;
	
	/**
	 * private default ctor, ensures that this class is never instantiated.
	 */
	private RoyalMailCSV()
	{super();}

}

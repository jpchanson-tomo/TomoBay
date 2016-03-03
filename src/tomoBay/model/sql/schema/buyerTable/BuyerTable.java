package tomoBay.model.sql.schema.buyerTable;
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
import tomoBay.model.dataTypes.dbSchema.AbstractDBSchema;
/**
 *
 * @author Jan P.C. Hanson
 *
 */
public final class BuyerTable implements AbstractDBSchema
{
	/**The buyerID column of the ebay_buyers table**/
	public static final BuyerID BUYERID = new BuyerID();
	/**The name column of the ebay_buyers table**/
	public static final Name NAME = new Name();
	/**The street1 column of the ebay_buyers table**/
	public static final Street STREET1 = new Street();
	/**The street2 column of the ebay_buyers table**/
	public static final Street STREET2 = STREET1;
	/**The city column of the ebay_buyers table**/
	public static final City CITY = new City();
	/**The county column of the ebay_buyers table**/
	public static final County COUNTY = new County();
	/**The postcode column of the ebay_buyers table**/
	public static final Postcode POSTCODE = new Postcode();
	/**The email column of the ebay_buyers table**/
	public static final Email EMAIL = new Email();
	/**The phoneNo column of the ebay_buyers table**/
	public static final Phone PHONE = new Phone();
	
	/**
	 * private ctor ensures this class is never instantiated
	 */
	private BuyerTable()
	{super();}
}

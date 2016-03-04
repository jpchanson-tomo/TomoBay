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
import tomoBay.model.dataTypes.dbSchema.AbstractTypeSchema;
/**
 * This represents the structure of the ebay_buyers table in the database. The static values 
 * contained inside this class are for use with the tomoBay.model.dataTypes.dbSchema.HeteroFieldContainer
 * @author Jan P.C. Hanson
 *
 */
public final class BuyerTable implements AbstractTypeSchema
{
	/**
	 * The buyerID column of the ebay_buyers table
	 * - VARCHAR(40)
	 * - Primary Key
	 * 
	 * @see tomoBay.model.sql.schema.buyerTable.BuyerID
	 **/
	public static final BuyerID BUYERID = new BuyerID();
	/**
	 * The name column of the ebay_buyers table
	 * - VARCHAR(45)
	 * 
	 * @see tomoBay.model.sql.schema.buyerTable.Name
	 **/
	public static final Name NAME = new Name();
	/**
	 * The street1 column of the ebay_buyers table
	 * - VARCHAR(80)
	 * 
	 * @see tomoBay.model.sql.schema.buyerTable.Street
	 **/
	public static final Street STREET1 = new Street();
	/**
	 * The street2 column of the ebay_buyers table
	 * - VARCHAR(80)
	 * 
	 * @see tomoBay.model.sql.schema.buyerTable.Street
	 **/
	public static final Street STREET2 = STREET1;
	/**
	 * The city column of the ebay_buyers table
	 * - VARCHAR(80)
	 * 
	 * @see tomoBay.model.sql.schema.buyerTable.City
	 **/
	public static final City CITY = new City();
	/**
	 * The county column of the ebay_buyers table
	 * - VARCHAR(80)
	 * 
	 * @see tomoBay.model.sql.schema.buyerTable.County
	 **/
	public static final County COUNTY = new County();
	/**
	 * The postcode column of the ebay_buyers table
	 * - VARCHAR(15)
	 * 
	 * @see tomoBay.model.sql.schema.buyerTable.Postcode
	 **/
	public static final Postcode POSTCODE = new Postcode();
	/**
	 * The email column of the ebay_buyers table
	 * - VARCHAR(100)
	 * 
	 * @see tomoBay.model.sql.schema.buyerTable.Email
	 **/
	public static final Email EMAIL = new Email();
	/**
	 * The phoneNo column of the ebay_buyers table
	 * - VARCHAR(16)
	 * 
	 * @see tomoBay.model.sql.schema.buyerTable.Phone
	 **/
	public static final Phone PHONE = new Phone();
	
	/**
	 * private ctor ensures this class is NEVER INSTANTIATED
	 */
	private BuyerTable()
	{super();}
}

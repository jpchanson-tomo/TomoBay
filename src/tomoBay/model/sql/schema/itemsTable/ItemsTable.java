package tomoBay.model.sql.schema.itemsTable;
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
import tomoBay.model.dataTypes.heteroTypeContainer.AbstractField;
import tomoBay.model.dataTypes.heteroTypeContainer.AbstractTypeSchema;
import tomoBay.model.sql.schema.accountsTable.AccountsTable;
/**
 * This represents the structure of the ebay_items table of the database. This table is a representation
 * of ebay listings grabbed using the eBayAPI
 * @see tomoBay.model.eBayAPI
 * @author Jan P.C. Hanson
 *
 */
public final class ItemsTable implements AbstractTypeSchema
{
	/**
	 * the itemID field of the ebay_items table, this is the primary key
	 * - BIGINT(13)
	 * - Primary key
	 * 
	 * @see tomoBay.model.sql.schema.itemsTable.ItemID
	 */
	public static final ItemID ITEM_ID = new ItemID();
	/**
	 * the title field of the ebay_items table, this is the title of the ebay listing.
	 * - VARCHAR(83)
	 * 
	 * @see tomoBay.model.sql.schema.itemsTable.Title
	 */
	public static final Title TITLE = new Title();
	/**
	 * the condition field of the ebay_items table. this field represents the selling condition of a
	 * particular item.
	 * - VARCHAR(15)
	 * 
	 * @see tomoBay.model.sql.schema.itemsTable.Condition
	 */
	public static final Condition CONDITION = new Condition();
	/**
	 * the brand field of the ebay_items table, this is what the ebay SDK calls an 'item specific'. In
	 * order for the system to pick up brand properly the ebay seller must put the brand in the 'Brand'
	 * field on the listing
	 * - VARCHAR(50)
	 * 
	 * @see tomoBay.model.sql.schema.itemsTable.Brand
	 */
	public static final Brand BRAND = new Brand();
	/**
	 * the partNo field of the ebay_items table. this is what the eba SDK calls an 'item specific'. In 
	 * order for the system to pick up part numbers properly they must be placed in the 'Manufacturer Part Number'
	 * field of the item specifics on the eBay listing.
	 * - VARCHAR(55)
	 * 
	 * @see tomoBay.model.sql.schema.itemsTable.PartNo
	 */
	public static final PartNo PART_NO = new PartNo();
	/**
	 * the notes field of the ebay_items table, this is a field that reflects whether there is some 
	 * kind of error associated with this item i.e. part number in the wrong format, brand missing etc.
	 * Notes are of the form 'ERROR(18234823482348)check Brand or PartNo' where the long number is the
	 * ebay listing id
	 * - VARCHAR(60)
	 * 
	 * @see tomoBay.model.sql.schema.itemsTable.ItemsTable#ITEM_ID
	 * @see tomoBay.model.sql.schema.itemsTable.Notes
	 */
	public static final Notes NOTES = new Notes();
	/**
	 * the account field of the ebay_items table. this field is a foreign key to the 
	 * ebay_accounts(tomoBay.model.sql.schema.accountsTable.AccountsTable) table and represents the 
	 * account that a particular item is associated with.
	 * - INT(11)
	 * 
	 * @see tomoBay.model.sql.schema.accountsTable.Id
	 */
	public static final AbstractField ACCOUNT = AccountsTable.ID;
	
	/**
	 * private ctor ensures this class is never instantiated
	 */
	private ItemsTable()
	{super();}

}

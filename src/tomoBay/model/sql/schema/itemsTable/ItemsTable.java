package tomoBay.model.sql.schema.itemsTable;
import tomoBay.model.dataTypes.dbSchema.AbstractDBField;
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
import tomoBay.model.sql.schema.accountsTable.AccountsTable;
/**
 *
 * @author Jan P.C. Hanson
 *
 */
public final class ItemsTable implements AbstractDBSchema
{
	/****/
	public static final ItemID ITEM_ID = new ItemID();
	/****/
	public static final Title TITLE = new Title();
	/****/
	public static final Condition CONDITION = new Condition();
	/****/
	public static final Brand BRAND = new Brand();
	/****/
	public static final PartNo PART_NO = new PartNo();
	/****/
	public static final Notes NOTES = new Notes();
	/****/
	public static final AbstractDBField ACCOUNT = AccountsTable.ID;
	
	/**
	 * private ctor ensures this class is never instantiated
	 */
	private ItemsTable()
	{super();}

}

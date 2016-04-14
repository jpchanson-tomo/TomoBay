package tomoBay.model.services.individualItemRefreshService;
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
import tomoBay.model.dataTypes.heteroTypeContainer.HeteroFieldContainer;
import tomoBay.model.sql.framework.ModifyQueryInvoker;
import tomoBay.model.sql.framework.ModifyQueryInvoker.ModifyQueryTypeParams;
import tomoBay.model.sql.schema.itemsTable.ItemsTable;
/**
 * This class takes data provided to it and uses this to re populate the database so that
 * the changes can be picked up by the system.
 * @author Jan P.C. Hanson
 *
 */
public final class RePopulateEbayItem
{
	/**
	 * default ctor
	 */
	public RePopulateEbayItem()
	{super();}
	
	/**
	 * update the database with the new brand and part number information gleaned from an ItemCall
	 * @param partNo the composite part number associated with this eBay Item
	 * @param brand the brand string associated with this eBay Item
	 * @param itemID the eBay ItemID.
	 */
	public void populate(String brand, String partNo, long itemID)
	{
		HeteroFieldContainer params = new HeteroFieldContainer();
		params.add(ItemsTable.BRAND, brand);
		params.add(ItemsTable.PART_NO, partNo);
		params.add(ItemsTable.ITEM_ID, itemID);
		
		ModifyQueryInvoker.execute(ModifyQueryTypeParams.UPDATE_ITEM_BRAND_AND_PARTNO, params);
	}
}

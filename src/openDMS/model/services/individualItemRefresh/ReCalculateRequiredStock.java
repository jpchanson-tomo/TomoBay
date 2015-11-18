package openDMS.model.services.individualItemRefresh;
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
import java.util.List;

import openDMS.helpers.BrandToCode;
import openDMS.model.services.helpers.PartList;
import openDMS.model.services.stockUpdate.StockRequiredQueryFactory;
import openDMS.model.services.stockUpdate.StockRequiredQueryFactory.StockQueryType;
import openDMS.model.sql.queries.QueryInvoker;
import openDMS.model.sql.queries.QueryInvoker.QueryType;

import com.ebay.soap.eBLBaseComponents.ItemType;

/**
 *
 * @author Jan P.C. Hanson
 *
 */
public class ReCalculateRequiredStock
{
	/**
	 * default ctor
	 */
	public ReCalculateRequiredStock()
	{super();}
	
	/**
	 * calculate the amount of stock required to fulfil an order for a particular ebay item, 
	 * update the database with the calculated values.
	 * @param item The item to update.
	 * @param partlist the partlist created by the composite part list retrieved from an ItemCall
	 * @param brand the brand string associaiated with this eBay Item.
	 * @param partNo the composite part number taken from the ItemCall
	 */
	public void calculate(PartList partList, String brand, String partNo, ItemType item)
	{
		int itemQty = Integer.parseInt(QueryInvoker.execute
											(
												QueryType.SELECT_EBAY_ITEM_SPECIFIC, 
												new String[] {item.getItemID()}).get(0)[5]
											);
		
		this.updateDB(partList, partNo, brand, itemQty);
	}
	
	/**
	 * updates the database with the required stock level 
	 * @param partList the partlist constructed using the composite part number retrieved from 
	 * the ItemCall.
	 * @param partNo the composite part number retrieved from the the ItemCall
	 * @param brand the brand retrieved from the item specifics (stored in ItemCall)
	 * @param qty the quantity as taken from the ebay_items table of the database.
	 */
	private void updateDB(PartList partList, String partNo, String brand, int qty)
	{
		StockRequiredQueryFactory enumFactory = new StockRequiredQueryFactory();
		enumFactory.setBrand(BrandToCode.convert(brand));
		
		for(int i = 0 ; i < partList.size() ; ++i)
		{this.insertOrUpdate(enumFactory, partList, qty, i);}
	}
	
	/**
	 * This method either inserts data into the database iff the part number doesnt already 
	 * exist on the system. If the part number does exist on the system then it updates the 
	 * part number already in existance with new data.
	 * @param enumFactory the StockUpdateQueryFactory that allows the selection of appropriate
	 * queries through the returned enum constants(based on brand code)
	 * @param parts the PartList associated with this eBay Item
	 * @param qty the quantity of a particular eBay item that is on order at this point in time.
	 * @param count integer generated by for loop, allows indexing of the appropriate part in the
	 * PartList.
	 */
	private void insertOrUpdate
	(StockRequiredQueryFactory enumFactory, PartList parts, int qty, int count)
	{
		List<String[]> part = QueryInvoker.execute//used to trigger exception
				(enumFactory.make(StockQueryType.SELECT), new String[]{parts.getPartNumber(count)});
		try
		{
			int total = ((parts.getPartQty(count) * qty)
						+Integer.parseInt(part.get(0)[1]));
			System.out.println("update: "+parts.getPartQty(count)+"+"+Integer.parseInt(part.get(0)[1])+"*"+qty+"="+total);
			QueryInvoker.execute(enumFactory.make(StockQueryType.UPDATE), 
					new String[] {String.valueOf(total),parts.getPartNumber(count)}); 
		}
		catch(IndexOutOfBoundsException ioobe)
		{
			int total = (parts.getPartQty(count)) * qty;
			System.out.println("insert"+total);
			QueryInvoker.execute(enumFactory.make(StockQueryType.INSERT), 
					new String[] {parts.getPartNumber(count), String.valueOf(total)});
		}
	}
}

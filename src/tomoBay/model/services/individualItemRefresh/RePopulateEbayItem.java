package tomoBay.model.services.individualItemRefresh;

import java.util.List;

import tomoBay.helpers.BrandToCode;
import tomoBay.model.services.helpers.PartList;
import tomoBay.model.services.stockUpdate.StockRequiredQueryFactory;
import tomoBay.model.services.stockUpdate.StockRequiredQueryFactory.StockQueryType;
import tomoBay.model.sql.queries.QueryInvoker;
import tomoBay.model.sql.queries.QueryInvoker.QueryType;

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

/**
 *
 * @author Jan P.C. Hanson
 *
 */
public class RePopulateEbayItem
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
	public void populate(String partNo, String brand, long itemID)
	{
		
		QueryInvoker.execute(QueryType.UPDATE_ITEM_BRAND_AND_PARTNO, 
				new String[] {brand,partNo,String.valueOf(itemID)});
	}
	
	/**
	 * 
	 * @param parts
	 * @param partNoDB
	 * @param brand
	 * @param itemID
	 */
	public void resetBrandTable(PartList parts, String partNoDB, String brand, long itemID)
	{
		/**
		 * select specific ebay item 
		 * use partlist to parse partNo
		 * use required value and partlist to calculate decomposed stock level for this item
		 * remove above stock level from brand tables
		 */

		String[] item = QueryInvoker.execute(QueryType.SELECT_EBAY_ITEM_SPECIFIC, new String[] {String.valueOf(itemID)}).get(0);

		StockRequiredQueryFactory enumFactory = new StockRequiredQueryFactory();
		enumFactory.setBrand(BrandToCode.convert(brand));
		PartList partlist = new PartList(item[4]);

		for(int i = 0 ; i < parts.size() ; ++i)
		{
			List<String[]> original = QueryInvoker.execute
					(enumFactory.make(StockQueryType.SELECT), 
							new String[] {partlist.getPartNumber(i)});
			
			String updateQty = String.valueOf(Integer.parseInt(original.get(0)[1]) 
											- (Integer.parseInt(item[5])
											* partlist.getPartQty(i))
											 );
			QueryInvoker.execute(enumFactory.make(StockQueryType.UPDATE), new String[] {updateQty, partlist.getPartNumber(i)});
		}
	}
}

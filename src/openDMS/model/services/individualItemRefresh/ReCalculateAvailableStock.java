package openDMS.model.services.individualItemRefresh;

import openDMS.helpers.BrandToCode;
import openDMS.model.services.helpers.PartList;
import openDMS.model.sql.queries.QueryInvoker;
import openDMS.model.sql.queries.QueryInvoker.QueryType;
import openDMS.model.winstock.Stock;

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
public class ReCalculateAvailableStock
{
	/**
	 * default ctor
	 */
	public ReCalculateAvailableStock()
	{super();}
	
	/**
	 * calculates the amount of available stock for a PartList.
	 * @param parts the PartsList for this particular eBay Item
	 * @param brand the brand associated with this eBay Item
	 * @param partNo the composite partNumber for this eBay item
	 * @param itemID the eBay Item ID.
	 */
	public void calculate(PartList parts, String brand, String partNo, String itemID)
	{
		for(int i = 0 ; i < parts.size() ; ++i)
		{
			int stockLevel = this.getStockLevel(String.valueOf(parts.getPartNumber(i)), BrandToCode.convert(brand));
			
			if(stockLevel==-8008135)
			{
				this.insertStockIntoDB
				(BrandToCode.convert(brand), parts.getPartNumber(i), stockLevel,
						"ERROR(PartNo or Brand): " + partNo + " : " + brand, itemID);
			}
			else
			{
				this.insertStockIntoDB
				(BrandToCode.convert(brand), parts.getPartNumber(i), stockLevel, "", itemID);
			}
		}
	}
	
	/**
	 * This method talks to winstock and returns an available stock level for a particular part number, 
	 * given that it has an associated brand.
	 * @param partNo the part number to find the available stock level of.
	 * @param brandCode a code representing the brand associated with the item.
	 * @return an integer representing the amount of available stock.
	 */
	private int getStockLevel(String partNo, String brandCode)
	{return new Stock().requestStockLevel(partNo.toUpperCase(), brandCode);}
	
	/**
	 * This method inserts the available stock information into the appropriate tables of the 
	 * database, which in this case is the brand specific tables.
	 * @param brandCode a code representing the brand associated with the eBay item.
	 * @param partNo the individual part number to be updated
	 * @param available the amount of available stock for this item
	 * @param notes error messages ad notes that should be associated with a particular eBay item.
	 * @param itemID the item ID that uniquely identifies a particular eBay item.
	 */
	private void insertStockIntoDB
	(String brandCode, String partNo, int available, String notes, String itemID)
	{
		String[] queryPayload = {String.valueOf(available), partNo, notes, itemID};
		QueryType query;
		
		switch (brandCode)
		{
			case "C":
				query = QueryInvoker.QueryType.UPDATE_AVAILABLE_STOCK_PSA;
			break;
			case "F":
				query = QueryInvoker.QueryType.UPDATE_AVAILABLE_STOCK_FORD;
			break;
			case "P":
				query = QueryInvoker.QueryType.UPDATE_AVAILABLE_STOCK_PRESTIGE;
			break;
			default:
				query = null;
				throw new NullPointerException("brandCode not recognised");
		}
		
		QueryInvoker.execute(query, queryPayload);
	}
}

package openDMS.model.services.stockUpdate;
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
import openDMS.model.services.AbstractService;
import openDMS.model.sql.queries.QueryInvoker;
import openDMS.model.sql.queries.QueryInvoker.QueryType;
import openDMS.model.winstock.Stock;
/**
 *
 * @author Jan P.C. Hanson
 *
 */
public class StockUpdateService implements AbstractService
{
	
	/**
	 * default ctor
	 */
	public StockUpdateService()
	{super();}
	
	/* (non-Javadoc)
	 * @see openDMS.model.services.AbstractService#run()
	 */
	@Override
	public void run()
	{
		StockRequired req = new StockRequired();
		req.calculate();
			
		List<String[]> tmp = QueryInvoker.execute(QueryInvoker.QueryType.SELECT_EBAY_ITEMS, new String[] {});
		for(String[] t : tmp)
		{
			PartList parts = new PartList(t[4]);
			for(int i = 0 ; i < parts.size() ; ++i)
			{
				int stockLevel = this.getStockLevel(String.valueOf(parts.getPartNumber(i)), BrandToCode.convert(t[3]));
				
				if(stockLevel==-8008135)
				{
					this.insertStockIntoDB
					(BrandToCode.convert(t[3]), parts.getPartNumber(i), stockLevel,
							"ERROR(PartNo or Brand): " + t[4] + " : " + t[3], t[0]);
				}
				else
				{
					this.insertStockIntoDB
					(BrandToCode.convert(t[3]), parts.getPartNumber(i), stockLevel, "", t[0]);
				}
			}
			parts.destroy();
		}
	}

	

	private int getStockLevel(String partNo, String brandCode)
	{return new Stock().requestStockLevel(partNo.toUpperCase(), brandCode);}
	
	/**
	 * 
	 * @param brandCode
	 * @param partNo
	 * @param available
	 * @param notes
	 * @param itemID
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

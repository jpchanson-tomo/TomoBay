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
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import openDMS.helpers.BrandToCode;
import openDMS.model.services.AbstractService;
import openDMS.model.sql.queries.QueryInvoker;
import openDMS.model.winstock.Stock;
/**
 *
 * @author Jan P.C. Hanson
 *
 */
public class StockUpdateService implements AbstractService
{
	/**
	 *  1) get list of items
	 *  2) FOR each item
	 *  3)	store part numbers in array
	 *  4)	store quantities in array
	 *  5) 	FOR each element of array (i)
	 *  6)		add quantity[i] of partNumber[i] to relevant brand database
	 *  7)	ENDFOR
	 *  8) ENDFOR
	 *  9)
	 * 10) FOR each record[i] of brand DB
	 * 11) 	check stock level on winstock
	 * 12)	update record[i] with stock level returned from (11)
	 * 13) ENDFOR
	 * 14) REPEAT (10)-(13) for each brand DB
	 */
	
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
		try
		{
			List<String[]> items = this.getItemList();	//get list of items
			for(String[] item : items)
			{
				PartList parts = new PartList(item[4]);
				System.out.println(item[1]);
				System.out.println(item[4] + ", " +BrandToCode.convert(item[3]));
				System.out.println(Arrays.deepToString(parts.getPartNumbers())+Arrays.toString(parts.getPartQtys())+"\n");
			}
		} 
		catch (SQLException e)
		{e.printStackTrace();}
		
		
	}

	private List<String[]> getItemList() throws SQLException
	{return QueryInvoker.execute(QueryInvoker.QueryType.SELECT_EBAY_ITEMS, new String[] {});}
	
	
	
	private int getStockLevel(String partNo, char brandCode)
	{
		return new Stock().requestStockLevel(partNo, brandCode);
	}
	
	private String splitPartNo(String partNo)
	{
		
		return null;
	}
	
	private void insertStockIntoDB()
	{
		
	}
}

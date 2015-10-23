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
import java.util.List;

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
	 * 1) get list of items
	 * 2) for each item in list query winstockDB for item stock level
	 * 3) insert stock level into TomoBayDB
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
			List<String[]> items = this.getItemList();	
			for(String[] item : items)
			{
				System.out.println(this.getStockLevel(item[4], this.convertBrandToCode(item[3])));
			}
		} 
		catch (SQLException e)
		{e.printStackTrace();}
		
		
	}

	private List<String[]> getItemList() throws SQLException
	{return QueryInvoker.execute(QueryInvoker.QueryType.SELECT_EBAY_ITEMS, new String[] {});}
	
	private int getStockLevel(String partNo, char brandCode)
	{return new Stock().requestStockLevel(partNo, brandCode);}
	
	private void insertStockIntoDB()
	{
		
	}
	
	private char convertBrandToCode(String brand)
	{
		if (brand.toLowerCase().contains("citroen")
			|| brand.toLowerCase().contains("peugeot")
			|| brand.toLowerCase().contains("psa"))
		{return 'C';}
		else if (brand.toLowerCase().contains("ford"))
		{return 'F';}
		else
		{return 'P';}
	}
}

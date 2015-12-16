package tomoBay.model.services.stockUpdateService;
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

import tomoBay.helpers.BrandToCode;
import tomoBay.model.services.helpers.PartList;
import tomoBay.model.services.stockUpdateService.StockRequiredQueryFactory.StockQueryType;
import tomoBay.model.sql.queries.QueryInvoker;
/**
 * 
 * This class calculates the stock required for all orders on the system at the point in time 
 * at which the service is run.
 * @author Jan P.C. Hanson
 *
 */
public class StockRequired
{
	/**
	 * default ctor
	 */
	public StockRequired()
	{super();}
	
	/**
	 * calculate the amount of required stock for each part number.
	 */
	public void calculate()
	{
		StockRequiredQueryFactory enumFactory = new StockRequiredQueryFactory();
		this.clearTables();
		List<String[]> items = this.getItemList();	//get list of items
		for(String[] item : items)
		{
			enumFactory.setBrand(BrandToCode.convert(item[3]));
			PartList parts = new PartList(item[4]);
			this.iterateThroughPartsList(parts, item, enumFactory);
			parts.destroy();
		}
	}

	/**
	 * gets a list of items from the items table of the database
	 * @return
	 * @throws SQLException
	 */
	private List<String[]> getItemList()
	{ return QueryInvoker.execute(QueryInvoker.QueryType.SELECT_EBAY_ITEMS, new String[] {}); }
	
	/**
	 * iterates through the parts list for a particular listing and adds the quantity of each
	 * part number to the specific brands parts db.
	 * @param parts
	 * @param item list of items 
	 * @param enumFactory the StockRequiredQueryFactory 
	 * @throws SQLException
	 */
	private void iterateThroughPartsList(PartList parts, String[] item, StockRequiredQueryFactory enumFactory)
	{
		for(int i = 0 ; i < parts.size() ; ++i)
		{this.insertORUpdate(enumFactory, parts, item, i);}
	}
	
	/**
	 * depending on whether the Select query returns results or not decides whether an
	 * IndexOutOfBoundsException is thrown, which in turn decides whether the system will insert
	 * or update a particular record.
	 * @param parts
	 * @param item list of items 
	 * @param enumFactory the StockRequiredQueryFactory 
	 * @param count the loop count variable
	 */
	private void insertORUpdate
	(StockRequiredQueryFactory enumFactory, PartList parts, String[] item, int count) 
	{
		List<String[]> tmp = QueryInvoker.execute
				(enumFactory.make(StockQueryType.SELECT), new String[]{parts.getPartNumber(count)});
		try
		{
			int total = (parts.getPartQty(count)+Integer.parseInt(tmp.get(0)[1]))*Integer.parseInt(item[5]);
			
			QueryInvoker.execute(enumFactory.make(StockQueryType.UPDATE), 
					new String[] {String.valueOf(total),parts.getPartNumber(count)}); //used to trigger exception
		}
		catch(IndexOutOfBoundsException ioobe)
		{
			int total = (parts.getPartQty(count)) * Integer.parseInt(item[5]);
			
			QueryInvoker.execute(enumFactory.make(StockQueryType.INSERT), 
					new String[] {parts.getPartNumber(count), String.valueOf(total)});
		}
	}
	
	/**
	 * clears the tables of any required qty information. Allowing the part numbers to remain
	 * is just less data that needs inserting. 
	 * @throws SQLException
	 */
	private void clearTables()
	{
		QueryInvoker.execute(QueryInvoker.QueryType.CLEAR_PARTS_PSA, new String[] {});
		QueryInvoker.execute(QueryInvoker.QueryType.CLEAR_PARTS_FORD, new String[] {});
		QueryInvoker.execute(QueryInvoker.QueryType.CLEAR_PARTS_PRESTIGE, new String[] {});
	}
}

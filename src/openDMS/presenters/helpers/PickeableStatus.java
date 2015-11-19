package openDMS.presenters.helpers;
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
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import openDMS.helpers.BrandToCode;
import openDMS.model.services.helpers.PartList;
import openDMS.model.sql.queries.QueryInvoker;
import openDMS.model.sql.queries.QueryInvoker.QueryType;
import openDMS.model.winstock.Stock;
/**
 *
 * @author Jan P.C. Hanson
 *
 */
public class PickeableStatus
{
	/**
	 * default ctor
	 */
	public PickeableStatus()
	{super();}
	
	/**
	 * 
	 * @param orderNo
	 * @return
	 */
	public String status(String orderNo)
	{
		String result="ERROR";
		Set<Boolean> itemStatus = new HashSet<Boolean>();
		
		List<String[]> orderTransactions 
		= QueryInvoker.execute(QueryType.SELECT_TRANSACTION_BY_ORDERID, new String[] {orderNo});
		
		List<String[]> items = new ArrayList<String[]>();
		
		for (int i = 0 ; i < orderTransactions.size() ; ++i)
		{
			String tmpID = String.valueOf(orderTransactions.get(i)[2]);
			
			List<String[]> tmpList 
			= QueryInvoker.execute(QueryType.SELECT_EBAY_ITEM_SPECIFIC, 
									new String[] {tmpID});
			items.addAll(tmpList);
			
			
		}
		
		for (String[] item : items)
		{
			Stock stockAvailable = new Stock();
			PartList partlist = new PartList(item[4]);
			
			
			for (int i = 0 ; i < partlist.size() ; ++i)
			{
				int available = stockAvailable.requestStockLevel(partlist.getPartNumber(i), 
						BrandToCode.convert(item[3]));
				
				int required = partlist.getPartQty(i);
				
				boolean status = available == required ? true : false;
				
				itemStatus.add(status);
			}
			
		}
		
		if (itemStatus.size()==1 && itemStatus.contains(true)) {result="Pickeable";}
		else if (itemStatus.size()==1) {result="Unpickeable";}
		else {result = "Partial";}
		return result;
	}
}

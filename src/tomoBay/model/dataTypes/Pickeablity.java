package tomoBay.model.dataTypes;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import tomoBay.helpers.BrandToCode;
import tomoBay.model.services.helpers.PartList;
import tomoBay.model.services.helpers.PickeableStatus;
import tomoBay.model.sql.queries.QueryInvoker;
import tomoBay.model.sql.queries.QueryInvoker.QueryType;
import tomoBay.model.winstock.Stock;
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
public class Pickeablity
{
	/**
	 * default ctor
	 */
	public Pickeablity()
	{super();}
	
	/**
	 * calculates the InvoiceableStatus for a particular order, Invoiceable/UnInvoiceable/Partial
	 * @param orderNo the order number to check
	 * @return InvoiceableStatus Invoiceable/UnInvoiceable/Partial/ERROR
	 */
	public PickeableStatus status(String orderNo)
	{
		List<String[]> orderTransactions 
		= QueryInvoker.execute(QueryType.SELECT_TRANSACTION_BY_ORDERID, new String[] {orderNo});

		List<String[]> items = new ArrayList<String[]>();
		
		this.assembleItemsList(orderTransactions, items);
		
		Set<Boolean> itemStatus = this.checkStockLevelOfItems(items);
		
		PickeableStatus result;
		if (itemStatus.size()==1 && itemStatus.contains(true)) {result=PickeableStatus.PICKEABLE;}
		else if (itemStatus.size()==1 && itemStatus.contains(false)) {result=PickeableStatus.UNPICKEABLE;}
		else if (itemStatus.size()==2){result = PickeableStatus.PARTIAL;}
		else {result = PickeableStatus.ERROR;}
		
		return result;
	}
	
	/**
	 * modifies the transactionVar list passed in as an argument so that it contains the list
	 * of transactions associated with this order.
	 * @param transactionVar
	 * @param itemsVar
	 */
	private void assembleItemsList
	(List<String[]> transactionVar, List<String[]> itemsVar)
	{
		for (int i = 0 ; i < transactionVar.size() ; ++i)
		{
			String tmpID = String.valueOf(transactionVar.get(i)[2]);
			
			List<String[]> tmpList 
			= QueryInvoker.execute(QueryType.SELECT_EBAY_ITEM_SPECIFIC, 
									new String[] {tmpID});
			itemsVar.addAll(tmpList);
		}
	}
	
	/**
	 * Takes the list of items generated in this.assembleItemsList and checks a PartList 
	 * associated with each item against Stock held in winstock. For every item with enough
	 * stock level it adds a true value to a Set<Boolean> i.e. if everything is in stock the
	 * set will only contain 1 element = true, if everything is out of stock the set will
	 * contain only 1 element = false, but if some items are in stock and others arn't it will
	 * contain 2 elements true and false.
	 * @param itemsVar the list of items to check off against Stock levels
	 * @return Set<Boolean> in stock - size=1 value={true}; out of stock - size=1 values={false};
	 * partial stock - size = 2 values = {true,false}
	 */
	private Set<Boolean> checkStockLevelOfItems(List<String[]> itemsVar)
	{
		Set<Boolean> itemStatus = new HashSet<Boolean>();
		for (String[] item : itemsVar)
		{
			Stock stockAvailable = new Stock();
			PartList partlist = new PartList(item[4]);
			
			for (int i = 0 ; i < partlist.size() ; ++i)
			{
				int available = stockAvailable.requestStockLevel(partlist.getPartNumber(i), 
						BrandToCode.convert(item[3]));
				
				int required = partlist.getPartQty(i);
				
				boolean status = available >= required ? true : false;
				
				itemStatus.add(status);
			}
		}
		return itemStatus;
	}
}
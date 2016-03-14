package tomoBay.model.dataTypes;

import gnu.trove.set.hash.THashSet;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import tomoBay.helpers.BrandToCode;
import tomoBay.model.dataTypes.heteroTypeContainer.ClassRef;
import tomoBay.model.dataTypes.heteroTypeContainer.HeteroFieldContainer;
import tomoBay.model.services.helpers.PickeableStatus;
import tomoBay.model.sql.queries.SelectQueryInvoker;
import tomoBay.model.sql.queries.SelectQueryInvoker.SelectQueryTypeParams;
import tomoBay.model.sql.schema.itemsTable.ItemsTable;
import tomoBay.model.sql.schema.ordersTable.OrdersTable;
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
public final class Pickeablity
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
		HeteroFieldContainer param = new HeteroFieldContainer();
		param.add(OrdersTable.ORDER_ID, orderNo);
		
		List<HeteroFieldContainer> orderTransactions 
		= SelectQueryInvoker.execute(SelectQueryTypeParams.SELECT_TRANSACTION_BY_ORDERID, param);

		List<HeteroFieldContainer> items = new ArrayList<HeteroFieldContainer>();
		
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
	(List<HeteroFieldContainer> transactionVar, List<HeteroFieldContainer> itemsVar)
	{
		for (int i = 0 ; i < transactionVar.size() ; ++i)
		{
			HeteroFieldContainer itemID = new HeteroFieldContainer();
			itemID.add(ItemsTable.ITEM_ID, transactionVar.get(i).get(ItemsTable.ITEM_ID, ClassRef.LONG));
			List<HeteroFieldContainer> tmpList 
			= SelectQueryInvoker.execute(SelectQueryTypeParams.SELECT_EBAY_ITEM_SPECIFIC, 
									itemID);
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
	private Set<Boolean> checkStockLevelOfItems(List<HeteroFieldContainer> itemsVar)
	{
		Set<Boolean> itemStatus = new THashSet<Boolean>();
		for (HeteroFieldContainer item : itemsVar)
		{
			Stock stockAvailable = new Stock();
			PartList partlist = new PartList(item.get(ItemsTable.PART_NO, ClassRef.STRING));
			
			for (int i = 0 ; i < partlist.size() ; ++i)
			{
				int available = stockAvailable.requestStockLevel(partlist.getPartNumber(i), 
						BrandToCode.convert(item.get(ItemsTable.BRAND, ClassRef.STRING)));
				
				int required = partlist.getPartQty(i);
				
				boolean status = available >= required ? true : false;
				
				itemStatus.add(status);
			}
		}
		return itemStatus;
	}
}
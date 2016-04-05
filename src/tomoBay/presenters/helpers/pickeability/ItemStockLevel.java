package tomoBay.presenters.helpers.pickeability;
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
import gnu.trove.set.hash.THashSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import tomoBay.helpers.BrandToCode;
import tomoBay.model.dataTypes.PartList;
import tomoBay.model.dataTypes.heteroTypeContainer.ClassRef;
import tomoBay.model.dataTypes.heteroTypeContainer.HeteroFieldContainer;
import tomoBay.model.sql.queries.SelectQueryInvoker;
import tomoBay.model.sql.queries.SelectQueryInvoker.SelectQueryTypeParams;
import tomoBay.model.sql.schema.itemsTable.ItemsTable;
import tomoBay.model.sql.schema.ordersTable.OrdersTable;
import tomoBay.model.winstock.Stock;
/**
 *
 * @author Jan P.C. Hanson
 *
 */
final class ItemStockLevel
{

	/**
	 * 
	 */
	public ItemStockLevel()
	{super();}
	
	/**
	 * @param orderId
	 * @return
	 */
	static final Set<Boolean> check(String orderId)
	{
		HeteroFieldContainer param = new HeteroFieldContainer();
		param.add(OrdersTable.ORDER_ID, orderId);

		List<HeteroFieldContainer> items = new ArrayList<HeteroFieldContainer>();
		ItemStockLevel.assembleItemsList(
				SelectQueryInvoker.execute(SelectQueryTypeParams.SELECT_TRANSACTION_BY_ORDERID, param),
				items
									);

		return  ItemStockLevel.checkStockLevelOfItems(items);
	}
	
	/**
	 * modifies the transactionVar list passed in as an argument so that it contains the list
	 * of transactions associated with this order.
	 * @param transactionVar
	 * @param itemsVar
	 */
	private static void assembleItemsList
	(List<HeteroFieldContainer> transactionVar, List<HeteroFieldContainer> itemsVar)
	{
		for (int i = 0 ; i < transactionVar.size() ; ++i)
		{
			final HeteroFieldContainer itemID = new HeteroFieldContainer();
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
	private static Set<Boolean> checkStockLevelOfItems(List<HeteroFieldContainer> itemsVar)
	{
		final Set<Boolean> itemStatus = new THashSet<Boolean>();
		for (HeteroFieldContainer item : itemsVar)
		{
			final Stock stockAvailable = new Stock();
			final PartList partlist = new PartList(item.get(ItemsTable.PART_NO, ClassRef.STRING));
			
			for (int i = 0 ; i < partlist.size() ; ++i)
			{
				final int available = stockAvailable.requestStockLevel(partlist.getPartNumber(i), 
						BrandToCode.convert(item.get(ItemsTable.BRAND, ClassRef.STRING)));
				
				final int required = partlist.getPartQty(i);
				
				final boolean status = available >= required ? true : false;
				
				itemStatus.add(status);
			}
		}
		return itemStatus;
	}
}

package tomoBay.model.services.checkErrorsService;

import java.util.List;

import org.apache.log4j.Logger;

import tomoBay.helpers.BrandToCode;
import tomoBay.model.dataTypes.PartList;
import tomoBay.model.dataTypes.heteroTypeContainer.ClassRef;
import tomoBay.model.dataTypes.heteroTypeContainer.HeteroFieldContainer;
import tomoBay.model.services.AbstractServiceState;
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
import tomoBay.model.sql.framework.ModifyQueryInvoker;
import tomoBay.model.sql.framework.SelectQueryInvoker;
import tomoBay.model.sql.framework.ModifyQueryInvoker.ModifyQueryTypeParams;
import tomoBay.model.sql.framework.SelectQueryInvoker.SelectQueryTypeNoParams;
import tomoBay.model.sql.schema.itemsTable.ItemsTable;
import tomoBay.model.winstock.Stock;

/**
 *
 * @author Jan P.C. Hanson
 *
 */
public final class OnRunning implements AbstractServiceState
{
	static Logger log = Logger.getLogger(OnRunning.class.getName());
	/**
	 * default ctor
	 */
	public OnRunning()
	{super();}

	/* (non-Javadoc)
	 * @see tomoBay.model.services.AbstractServiceState#execute()
	 */
	@Override
	public String execute()
	{
		log.warn("check errors started");
		PartList partlist;
		Stock errorCheck = new Stock();
		List<HeteroFieldContainer> orders = SelectQueryInvoker.execute(SelectQueryTypeNoParams.SELECT_EBAY_ITEMS);
		for (HeteroFieldContainer order: orders)
		{
//			System.out.println(order.get(ItemsTable.PART_NO, ClassRef.STRING)+" : "+order.get(ItemsTable.ACCOUNT, ClassRef.INTEGER));
			partlist = new PartList(order.get(ItemsTable.PART_NO, ClassRef.STRING));
			for (String partNo : partlist.getPartNumbers())
			{
				int result = errorCheck.requestStockLevel(partNo, 
											BrandToCode.convertToInt(order.get(ItemsTable.BRAND, ClassRef.STRING))+"");
				
				if (result == -8008135)
				{this.updateItemNote(order);}
			}
		}
		return "check errors finished";
	}
	
	/**
	 * this method updates the notes field in the database to reflect the error that has been found
	 * @param order HeteroFieldcontainer containing the values taken from the select query in the 
	 * execute method.
	 */
	private void updateItemNote(HeteroFieldContainer order)
	{
		String errorMsg = "ERROR("+order.get(ItemsTable.ITEM_ID, ClassRef.LONG)
								+"): check part numbers and brand";
		
		HeteroFieldContainer insertVals = new HeteroFieldContainer();
		insertVals.add(ItemsTable.ITEM_ID, order.get(ItemsTable.ITEM_ID, ClassRef.LONG));
		insertVals.add(ItemsTable.NOTES, errorMsg);
		
		ModifyQueryInvoker.execute(ModifyQueryTypeParams.UPDATE_ITEM_NOTE, insertVals);
		
		log.warn(errorMsg);
	}
}

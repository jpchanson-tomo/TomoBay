package tomoBay.model.services.reScanErrorsService;

import java.util.List;

import org.apache.log4j.Logger;

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
import tomoBay.model.sql.schema.itemsTable.ItemsTable;

/**
 *
 * @author Jan P.C. Hanson
 *
 */
public final class OnRunning implements AbstractServiceState
{
	static Logger log = Logger.getLogger(ReScanErrorsService.class.getName());
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
		log.warn("rescan errors started");
		ReScanErrorsDBActions database = new ReScanErrorsDBActions();
		ReScanErrorsWinstockActions winstock = new ReScanErrorsWinstockActions();
		
		List<HeteroFieldContainer> errorList = database.retrieveAllErrorItems();
		
		for (HeteroFieldContainer error : errorList)
		{
			ItemSpecifics item = new ItemSpecifics(
											error.get(ItemsTable.ITEM_ID, ClassRef.LONG), 
											error.get(ItemsTable.ACCOUNT, ClassRef.INTEGER)
																);
			if (winstock.partNoHasError(item) == false)
			{database.updateDBwithCorrectedInfo(item);}
		}
		return "rescan errors finished";
	}
}

package tomoBay.model.services.checkErrorsService;

import java.util.List;

import org.apache.log4j.Logger;

import tomoBay.helpers.BrandToCode;
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
import tomoBay.model.services.helpers.PartList;
import tomoBay.model.sql.queries.QueryInvoker;
import tomoBay.model.sql.queries.QueryInvoker.QueryType;
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
		List<String[]> orders = QueryInvoker.execute(QueryType.SELECT_EBAY_ITEMS, new String[] {});
		for (String[] order: orders)
		{
			partlist = new PartList(order[4]);
			for (String partNo : partlist.getPartNumbers())
			{
				int result = errorCheck.requestStockLevel(partNo, BrandToCode.convert(order[3]));
				String errorMsg = "ERROR("+order[0]+"): check part numbers and brand";
				if (result == -8008135)
				{QueryInvoker.execute(QueryType.UPDATE_ITEM_NOTE, new String[] {errorMsg, order[0]});log.warn(errorMsg);}
			}
		}
		return "check errors finished";
	}
}

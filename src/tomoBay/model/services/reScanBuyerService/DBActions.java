package tomoBay.model.services.reScanBuyerService;
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
import tomoBay.model.dataTypes.heteroTypeContainer.HeteroFieldContainer;
import tomoBay.model.sql.framework.ModifyQueryInvoker;
import tomoBay.model.sql.framework.SelectQueryInvoker;
import tomoBay.model.sql.framework.ModifyQueryInvoker.ModifyQueryTypeParams;
import tomoBay.model.sql.framework.SelectQueryInvoker.SelectQueryTypeParams;
import tomoBay.model.sql.schema.ordersTable.OrdersTable;
/**
 *
 * @author Jan P.C. Hanson
 *
 */
public final class DBActions
{

	/**
	 * 
	 */
	public DBActions()
	{super();}
	
	/**
	 * get the latest orderID for the buyer passed in as an argument
	 * @param buyerID identifier for the buyer
	 * @return String containing the orderID = String[0] of the latest order as well as the account
	 * associated with this order String[1].
	 */
	public static HeteroFieldContainer getLatestOrderID(String buyerID)
	{
		HeteroFieldContainer param = new HeteroFieldContainer();
		param.add(OrdersTable.BUYERID, buyerID);
		return SelectQueryInvoker.execute(SelectQueryTypeParams.SELECT_EBAY_ORDER_BY_BUYER, param).get(0);
	}
	
	/**
	 * updates the buyer table in the database with the new buyer information.
	 * @param updateInfo The new buyer information
	 * @return String result code.
	 */
	public static HeteroFieldContainer updateBuyerTable(HeteroFieldContainer updateInfo)
	{return ModifyQueryInvoker.execute(ModifyQueryTypeParams.UPDATE_EBAY_BUYER, updateInfo);}

}

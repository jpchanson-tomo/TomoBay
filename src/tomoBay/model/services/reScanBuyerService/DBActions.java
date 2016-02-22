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
import tomoBay.model.sql.queries.QueryInvoker.QueryType;
import tomoBay.model.sql.queries.QueryInvoker;
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
	 * @return String containing the orderID of the latest order.
	 */
	public static String getLatestOrderID(String buyerID)
	{return QueryInvoker.execute(QueryType.SELECT_EBAY_ORDER_BY_BUYER, new String[] {buyerID}).get(0)[0];}
	
	/**
	 * updates the buyer table in the database with the new buyer information.
	 * @param updateInfo The new buyer information
	 * @return String result code.
	 */
	public static String updateBuyerTable(String[] updateInfo)
	{return QueryInvoker.execute(QueryType.UPDATE_EBAY_BUYER, updateInfo).get(0)[0];}

}

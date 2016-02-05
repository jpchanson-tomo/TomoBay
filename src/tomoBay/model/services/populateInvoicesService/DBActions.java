package tomoBay.model.services.populateInvoicesService;
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
import java.util.List;

import tomoBay.model.sql.queries.QueryInvoker;
import tomoBay.model.sql.queries.QueryInvoker.QueryType;
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
	 * retrieve a list of transaction information from the database
	 * @return
	 * - col[0] = (String)orderID
	 * - col[1] = (int) transactionID
	 * - col[2] = (int) quantity
	 * - col[3] = (float) price
	 * - col[4] = (String) partNo
	 * - col[5] = (String) brand
	 * - col[6] = (float) shippingCost
	 */
	public List<String[]> getTransactionData()
	{return QueryInvoker.execute(QueryType.SELECT_UNCALCULATED_INVOICES, new String[] {});}
	
	/**
	 * retrieve a list of orders whose invoices havent been calculated.
	 * @return List<String[]> containing a list of single element string[] i.e. essentially this
	 * is a list of orderID's.
	 */
	public List<String[]> getUnCalculatedOrders()
	{return QueryInvoker.execute(QueryType.SELECT_UNCALCULATED_ORDERS, new String[] {});}
	
	
	public List<String[]> insertInvoiceLines()
	{
		return null;
	}
}

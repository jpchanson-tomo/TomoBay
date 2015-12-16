package tomoBay.model.services.basicEbayUpdateService;
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
import java.sql.SQLException;

import tomoBay.model.sql.queries.QueryInvoker;
import tomoBay.model.sql.queries.QueryInvoker.QueryType;

import com.ebay.soap.eBLBaseComponents.OrderType;
/**
 * updates the buyers table of the database with the information gleaned from an ebay api call
 * @author Jan P.C. Hanson
 *
 */
public class BuyersTable
{
	/**
	 * default ctor
	 */
	public BuyersTable()
	{super();}
	
	/**
	 * populates the Orders Table in the database with data grabbed from the ebay API
	 * @param credentials API credentials.
	 * @param orders list of orders.
	 * @throws SQLException 
	 */
	public static void populate(String[] credentials, OrderType[] orders) throws SQLException
	{
		for (OrderType order : orders)
		{
			String[] insertVals = 
				{
					order.getBuyerUserID(),
					order.getShippingAddress().getName()+" "+order.getShippingAddress().getInternationalName(),
					(
						order.getShippingAddress().getInternationalStreet() + ", "
						+ order.getShippingAddress().getInternationalStateAndCity() + ", "
						+ order.getShippingAddress().getStreet() + ", "
						+ order.getShippingAddress().getStreet1() + ", "
						+ order.getShippingAddress().getStreet2() + ", "
						+ order.getShippingAddress().getCityName() + ", "
						+ order.getShippingAddress().getCounty() + ", "
						+ order.getShippingAddress().getStateOrProvince() + ", "
						+ order.getShippingAddress().getPostalCode() + ", "
						+ order.getShippingAddress().getCounty()
					),
					order.getTransactionArray().getTransaction(0).getBuyer().getEmail(),
					order.getShippingAddress().getPhone()
				};
			QueryInvoker.execute(QueryType.INSERT_EBAY_BUYERS,insertVals);
		}
	}
}
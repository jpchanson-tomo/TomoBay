package tomoBay.model.services.basicEbayUpdate;
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
import java.sql.Timestamp;



import tomoBay.model.sql.queries.QueryInvoker;
import tomoBay.model.sql.queries.QueryInvoker.QueryType;

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
import com.ebay.soap.eBLBaseComponents.OrderType;
/**
 * updates the database orders table with information taken from the ebay api orders call.
 * @author Jan P.C. Hanson
 *
 */
public class OrdersTable
{
	/**
	 * default ctor
	 */
	public OrdersTable()
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
			Timestamp ts = new Timestamp(order.getCreatedTime().getTime().getTime());
			String[] insertVals = 
				{
					order.getOrderID(),
					order.getBuyerUserID(),
					String.valueOf(order.getShippingDetails().getSellingManagerSalesRecordNumber()),
					order.getShippingServiceSelected().getShippingService(),
					ts.toString()
				};
			QueryInvoker.execute(QueryType.INSERT_EBAY_ORDERS, insertVals);
		}
	}
}

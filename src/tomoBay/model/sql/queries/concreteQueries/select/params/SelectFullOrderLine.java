package tomoBay.model.sql.queries.concreteQueries.select.params;
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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tomoBay.model.dataTypes.heteroTypeContainer.ClassRef;
import tomoBay.model.dataTypes.heteroTypeContainer.HeteroFieldContainer;
import tomoBay.model.sql.queries.AbstractSelectParamsQuery;
import tomoBay.model.sql.schema.buyerTable.BuyerTable;
import tomoBay.model.sql.schema.itemsTable.ItemsTable;
import tomoBay.model.sql.schema.ordersTable.OrdersTable;
import tomoBay.model.sql.schema.transactionsTable.TransactionsTable;
/**
 *
 * @author Jan P.C. Hanson
 *
 */
public  final class SelectFullOrderLine extends AbstractSelectParamsQuery
{
	/**SQL query string**/
	private static final String query = 
			"SELECT ebay_orders.orderID, ebay_orders.shippingType, ebay_orders.createdTime, ebay_orders.salesRecNo, "
					+ "ebay_items.itemID, ebay_items.title, ebay_items.brand, ebay_items.partNo, "
					+ "ebay_transactions.quantity, ebay_transactions.price, ebay_items.notes , "
					+ "ebay_buyers.buyerID, ebay_buyers.name, ebay_buyers.street1, ebay_buyers.street2,"
					+ "ebay_buyers.city, ebay_buyers.county, ebay_buyers.postcode, ebay_transactions.shippingCost, "
					+ "ebay_orders.orderTotal, ebay_orders.invoiced, ebay_items.itemID "
					+ "FROM ebay_orders "
					+ "INNER JOIN ebay_transactions ON ebay_orders.orderID=ebay_transactions.orderID "
					+ "INNER JOIN ebay_items ON ebay_transactions.itemID=ebay_items.itemID "
					+ "INNER JOIN ebay_buyers ON ebay_orders.buyerID=ebay_buyers.buyerID "
					+ "WHERE ebay_orders.orderID = ? ";
	
	/**
	 * default constructor
	 */
	public SelectFullOrderLine()
	{super();}
	
	/**
	 * execute the query
	 * @param parameter orderId (1 element array only)
	 * @return List<HeteroFieldContainer> representing the results of the query. Each element in the list
	 * represents a row of the database and each element of the HeteroFieldContainer represents a field.
	 * 
	 * The available fields for each element of the HeteroFieldContainer are:
	 * - String[0] = orderID
	 * - String[1] = shippingType
	 * - String[2] = salesRecNo
	 * - String[3] = createdTime
	 * - String[4] = itemID
	 * - String[5] = title
	 * - String[6] = brand
	 * - String[7] = partNo
	 * - String[8] = quantity
	 * - String[9] = price
	 * - String[10] = notes
	 * - String[11] = buyerID
	 * - String[12] = name
	 * - String[13] = street1
	 * - String[14] = street2
	 * - String[15] = city
	 * - String[16] = county
	 * - String[17] = postcode
	 * - String[18] = shippingCost 
	 * - String[19] = orderTotal
	 * - String[20] = invoiced
	 * 
	 * @throws SQLException
	 */
	public List<HeteroFieldContainer> execute(HeteroFieldContainer parameter) throws SQLException
	{
		super.initQuery(query);
		super.statement_M.setString(1, parameter.get(OrdersTable.ORDER_ID, ClassRef.STRING));
		
		ResultSet resultset = super.statement_M.executeQuery();
		List<HeteroFieldContainer> result = this.format(resultset);
		
		this.cleanup();
		return result;
	}
	
	/**
	 * formats the ResultSet (returned from the executed query) as a string
	 * @param results the ResultSet (post query execution)
	 * @return String containing the formatted results.
	 * @throws SQLException
	 */
	@Override
	protected List<HeteroFieldContainer> format(ResultSet results) throws SQLException
	{
		List<HeteroFieldContainer> rows = new ArrayList<HeteroFieldContainer>();
		while (results.next())
		{
			HeteroFieldContainer cols = new HeteroFieldContainer();
			cols.add(OrdersTable.ORDER_ID,results.getString("orderID"));
			cols.add(OrdersTable.SHIPPING_TYPE,results.getString("shippingType"));
			cols.add(OrdersTable.SALES_REC_NO, results.getInt("salesRecNo"));
			cols.add(OrdersTable.CREATED_TIME, results.getTimestamp("createdTime"));
			cols.add(OrdersTable.ORDER_TOTAL, results.getFloat("orderTotal"));
			cols.add(OrdersTable.INVOICED,results.getInt("invoiced"));
			cols.add(ItemsTable.ITEM_ID, results.getLong("itemID"));
			cols.add(ItemsTable.TITLE, results.getString("title"));
			cols.add(ItemsTable.BRAND, results.getString("brand"));
			cols.add(ItemsTable.PART_NO, results.getString("partNo"));
			cols.add(ItemsTable.NOTES, results.getString("notes"));
			cols.add(TransactionsTable.QUANTITY, results.getInt("quantity"));
			cols.add(TransactionsTable.PRICE, results.getFloat("price"));
			cols.add(TransactionsTable.SHIPPING_COST,results.getFloat("shippingCost"));
			cols.add(BuyerTable.BUYERID,results.getString("buyerID"));
			cols.add(BuyerTable.NAME, results.getString("name"));
			cols.add(BuyerTable.STREET1,results.getString("street1"));
			cols.add(BuyerTable.STREET2,results.getString("street2"));
			cols.add(BuyerTable.CITY,results.getString("city"));
			cols.add(BuyerTable.COUNTY,results.getString("county"));
			cols.add(BuyerTable.POSTCODE,results.getString("postcode"));
			rows.add(cols);
		}
		return rows;
	}
}
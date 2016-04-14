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

import tomoBay.model.dataTypes.heteroTypeContainer.HeteroFieldContainer;
import tomoBay.model.sql.framework.QueryUtility;
import tomoBay.model.sql.framework.queryTypes.select.AbstractSelectParamsQuery;
import tomoBay.model.sql.schema.buyerTable.BuyerTable;
import tomoBay.model.sql.schema.itemsTable.ItemsTable;
import tomoBay.model.sql.schema.ordersTable.OrdersTable;
import tomoBay.model.sql.schema.transactionsTable.TransactionsTable;
/**
 * This class represents a query that provides the majority of information associated with a particular
 * orderID as passed to the execute(HeteroFieldContainer parameter) method.
 * 
 * This query takes the following parameter:
 * - OrdersTable.ORDER_ID
 * 
 * The query returns a List<HeteroFieldContainer> containing the following fields:
 * - OrdersTable.ORDER_ID
 * - OrdersTable.SHIPPING_TYPE
 * - OrdersTable.SALES_REC_NO
 * - OrdersTable.CREATED_TIME
 * - OrdersTable.ORDER_TOTAL
 * - OrdersTable.INVOICED
 * - ItemsTable.ITEM_ID
 * - ItemsTable.TITLE
 * - ItemsTable.BRAND
 * - ItemsTable.PART_NO
 * - ItemsTable.NOTES
 * - TransactionsTable.QUANTITY
 * - TransactionsTable.PRICE
 * - TransactionsTable.SHIPPING_COST
 * - BuyerTable.BUYERID
 * - BuyerTable.NAME
 * - BuyerTable.STREET1
 * - BuyerTable.STREET2
 * - BuyerTable.CITY
 * - BuyerTable.COUNTY
 * - BuyerTable.POSTCODE
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

	/* (non-Javadoc)
	 * @see tomoBay.model.sql.framework.queryTypes.select.AbstractSelectParamsQuery#setParameters(tomoBay.model.dataTypes.heteroTypeContainer.HeteroFieldContainer)
	 */
	@Override
	protected void setParameters(HeteroFieldContainer parameter) throws ClassCastException, SQLException
	{QueryUtility.setVARCHARParam(this, parameter, OrdersTable.ORDER_ID, 1);}

	/* (non-Javadoc)
	 * @see tomoBay.model.sql.framework.queryTypes.AbstractDBQuery#queryString()
	 */
	@Override
	protected String queryString()
	{return SelectFullOrderLine.query;}
}
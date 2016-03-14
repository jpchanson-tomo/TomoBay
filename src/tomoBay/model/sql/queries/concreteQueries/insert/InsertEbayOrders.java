package tomoBay.model.sql.queries.concreteQueries.insert;
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

import tomoBay.model.dataTypes.heteroTypeContainer.ClassRef;
import tomoBay.model.dataTypes.heteroTypeContainer.HeteroFieldContainer;
import tomoBay.model.sql.queries.AbstractModifyQuery;
import tomoBay.model.sql.schema.nonDBFields.NonDBFields;
import tomoBay.model.sql.schema.ordersTable.OrdersTable;

/**
 * This class represents a class that inserts order data into the orders table of the database.
 * @author Jan P.C. Hanson
 *
 */
public  final class InsertEbayOrders extends AbstractModifyQuery
{
	/**SQL query string**/
	private String query ="INSERT IGNORE INTO ebay_orders (orderID, buyerID, salesRecNo, shippingType, createdTime, orderTotal, account)"
			+ "VALUES (?,?,?,?,?,?,?);";
	
	/**
	 * default constructor
	 */
	public InsertEbayOrders()
	{super();}
	
	/**
	 * execute the query
	 * @param parameter an array of strings where the 0th element is the parameter for the 
	 * first column, the 1st element is the parameter for the 2nd column and so on. 
	 * The Ebay Orders Table only has 5 columns so any element above the 4th element will be ignored.
	 * - col1 = orderID:int(30)
	 * - col2 = buyerID:varchar(40)
	 * - col3 = salesRecNo:int(10)
	 * - col4 = shippingType:varchar(200)
	 * - col5 = createdTime:datetime 
	 * @return List<String[]> representing the results of the query. The list contains only 1 
	 * String[] which in turn contains only 1 element, this is the resultcode for the query.
	 * @throws SQLException
	 */
	public HeteroFieldContainer execute(HeteroFieldContainer parameter) throws SQLException
	{
		this.initQuery(query);
		this.statement_M.setString(1, parameter.get(OrdersTable.ORDER_ID, ClassRef.STRING));
		this.statement_M.setString(2, parameter.get(OrdersTable.BUYERID, ClassRef.STRING));
		this.statement_M.setInt(3, parameter.get(OrdersTable.SALES_REC_NO, ClassRef.INTEGER));
		this.statement_M.setString(4, parameter.get(OrdersTable.SHIPPING_TYPE, ClassRef.STRING));
		this.statement_M.setTimestamp(5, parameter.get(OrdersTable.CREATED_TIME, ClassRef.TIMESTAMP));
		this.statement_M.setFloat(6, parameter.get(OrdersTable.ORDER_TOTAL, ClassRef.FLOAT));
		this.statement_M.setInt(7, parameter.get(OrdersTable.ACCOUNT, ClassRef.INTEGER));
			
		int resultCode = statement_M.executeUpdate();
		this.cleanup();
			
		parameter.add(NonDBFields.RESULT_CODE, resultCode);
		return parameter;
	}
}

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
import tomoBay.model.sql.schema.transactionsTable.TransactionsTable;
/**
 * This class represents a query that inserts transaction data into the transactions table of
 * the database.
 * @author Jan P.C. Hanson
 *
 */
public  final class InsertEbayTransactions extends AbstractModifyQuery
{
	/**SQL query string**/
	private String query ="INSERT IGNORE INTO ebay_transactions "
			+ "(transactionID, orderID, itemID, quantity, price, shippingCost)"
			+ "VALUES (?,?,?,?,?,?);";
	
	/**
	 * default constructor
	 */
	public InsertEbayTransactions()
	{super();}
	
	/**
	 * execute the query
	 * @param parameter an array of strings where the 0th element is the parameter for the 
	 * first column, the 1st element is the parameter for the 2nd column and so on. 
	 * The Ebay Orders Table only has 4 columns so any element above the 3rd element will be ignored.
	 * - col1 = transactionID:bigint(20)
	 * - col2 = orderID:varchar(30)
	 * - col3 = itemID:bigint(20) 
	 * - col4 = quantity:int(7) 
	 * - col5 = price:float
	 * @return List<String[]> representing the results of the query. The list contains only 1 
	 * String[] which in turn contains only 1 element, this is the resultcode for the query.
	 * @throws SQLException
	 */
	public HeteroFieldContainer execute(HeteroFieldContainer parameter) throws SQLException
	{
		this.initQuery(query);
		this.statement_M.setLong(1, parameter.get(TransactionsTable.TRANSACTION_ID, ClassRef.LONG));
		this.statement_M.setString(2, parameter.get(TransactionsTable.ORDER_ID, ClassRef.STRING));
		this.statement_M.setLong(3, parameter.get(TransactionsTable.ITEM_ID, ClassRef.LONG));
		this.statement_M.setInt(4, parameter.get(TransactionsTable.QUANTITY, ClassRef.INTEGER));
		this.statement_M.setFloat(5, parameter.get(TransactionsTable.PRICE, ClassRef.FLOAT));
		this.statement_M.setFloat(6, parameter.get(TransactionsTable.SHIPPING_COST, ClassRef.FLOAT));
		
		int resultCode = statement_M.executeUpdate();
		this.cleanup();
		
		parameter.add(NonDBFields.RESULT_CODE, resultCode);
		return parameter;
	}
}

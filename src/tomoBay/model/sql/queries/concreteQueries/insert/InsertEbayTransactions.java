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

import tomoBay.model.dataTypes.heteroTypeContainer.HeteroFieldContainer;
import tomoBay.model.sql.framework.QueryUtility;
import tomoBay.model.sql.framework.queryTypes.modify.AbstractModifyQueryParams;
import tomoBay.model.sql.schema.transactionsTable.TransactionsTable;
/**
 * This class represents a query that inserts transaction data into the transactions table of
 * the database.
 * 
 * This query requires the following parameters:
 * - TransactionsTable.TRANSACTION_ID
 * - TransactionsTable.ORDER_ID
 * - TransactionsTable.ITEM_ID
 * - TransactionsTable.QUANTITY
 * - TransactionsTable.PRICE
 * - TransactionsTable.SHIPPING_COST
 * 
 * These should be stored in a HeteroFieldContainer and passed to the execute(HeteroFieldContainer parameters) 
 * method when you wish to run the query.
 * 
 * @author Jan P.C. Hanson
 *
 */
public  final class InsertEbayTransactions extends AbstractModifyQueryParams
{
	/**SQL query string**/
	private static final String query ="INSERT IGNORE INTO ebay_transactions "
			+ "(transactionID, orderID, itemID, quantity, price, shippingCost)"
			+ "VALUES (?,?,?,?,?,?);";
	
	/**
	 * default constructor
	 */
	public InsertEbayTransactions()
	{super();}

	/* (non-Javadoc)
	 * @see tomoBay.model.sql.framework.queryTypes.modify.AbstractModifyQueryParams#queryString()
	 */
	@Override
	protected String queryString()
	{return InsertEbayTransactions.query;}

	/* (non-Javadoc)
	 * @see tomoBay.model.sql.framework.queryTypes.modify.AbstractModifyQueryParams#setParameters(tomoBay.model.dataTypes.heteroTypeContainer.HeteroFieldContainer)
	 */
	@Override
	protected void setParameters(HeteroFieldContainer parameter) throws ClassCastException, SQLException
	{
		QueryUtility.setBIGINTParam(this, parameter, TransactionsTable.TRANSACTION_ID, 1);
		QueryUtility.setVARCHARParam(this, parameter, TransactionsTable.ORDER_ID, 2);
		QueryUtility.setBIGINTParam(this, parameter, TransactionsTable.ITEM_ID, 3);
		QueryUtility.setINTEGERParam(this, parameter, TransactionsTable.QUANTITY, 4);
		QueryUtility.setFLOATParam(this, parameter, TransactionsTable.PRICE, 5);
		QueryUtility.setFLOATParam(this, parameter, TransactionsTable.SHIPPING_COST, 6);
	}
}
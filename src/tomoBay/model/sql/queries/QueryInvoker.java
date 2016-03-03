package tomoBay.model.sql.queries;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import tomoBay.model.sql.queries.factories.insert.InsertEbayBuyersFactory;
import tomoBay.model.sql.queries.factories.insert.InsertEbayItemsFactory;
import tomoBay.model.sql.queries.factories.insert.InsertEbayOrdersFactory;
import tomoBay.model.sql.queries.factories.insert.InsertEbayTransactionsFactory;
import tomoBay.model.sql.queries.factories.insert.InsertOutOfHoursFactory;
import tomoBay.model.sql.queries.factories.insert.InsertPartFactory;
import tomoBay.model.sql.queries.factories.insert.InsertPartMappingFactory;
import tomoBay.model.sql.queries.factories.select.SelectAccountsFactory;
import tomoBay.model.sql.queries.factories.select.SelectBrandByInvNoFactory;
import tomoBay.model.sql.queries.factories.select.SelectEbayBuyerFactory;
import tomoBay.model.sql.queries.factories.select.SelectEbayBuyersFactory;
import tomoBay.model.sql.queries.factories.select.SelectEbayItemSpecificFactory;
import tomoBay.model.sql.queries.factories.select.SelectEbayItemsErrorFactory;
import tomoBay.model.sql.queries.factories.select.SelectEbayItemsFactory;
import tomoBay.model.sql.queries.factories.select.SelectEbayItemsNotInTransactionsFactory;
import tomoBay.model.sql.queries.factories.select.SelectEbayOrderByBuyerFactory;
import tomoBay.model.sql.queries.factories.select.SelectEbayOrderByIDFactory;
import tomoBay.model.sql.queries.factories.select.SelectEbayOrdersFactory;
import tomoBay.model.sql.queries.factories.select.SelectEbayTransactionByIDFactory;
import tomoBay.model.sql.queries.factories.select.SelectFullOrderLineFactory;
import tomoBay.model.sql.queries.factories.select.SelectInvoicedOrdersFactory;
import tomoBay.model.sql.queries.factories.select.SelectOutOfHoursOrdersFactory;
import tomoBay.model.sql.queries.factories.select.SelectTransactionByOrderIDFactory;
import tomoBay.model.sql.queries.factories.select.SelectUncalculatedInvoicesFactory;
import tomoBay.model.sql.queries.factories.select.SelectUncalculatedOrdersFactory;
import tomoBay.model.sql.queries.factories.select.SelectUninvoicedOrdersFactory;
import tomoBay.model.sql.queries.factories.select.SelectUninvoicedOrdersNoErrorsFactory;
import tomoBay.model.sql.queries.factories.update.UpdateEbayBuyerFactory;
import tomoBay.model.sql.queries.factories.update.UpdateInvoiceStatusFactory;
import tomoBay.model.sql.queries.factories.update.UpdateInvoiceStatusSRNFactory;
import tomoBay.model.sql.queries.factories.update.UpdateItemBrandAndPartNoFactory;
import tomoBay.model.sql.queries.factories.update.UpdateItemErrorFactory;
import tomoBay.model.sql.queries.factories.update.UpdateItemNoteFactory;
/**
 * This object is responsible for providing the user with Query objects as specified by the
 * internal enum, which defines all possible queries that can be executed on the database.
 * 
 * These queries objects can either be created using the make() method or directly executed
 * using the execute() method. 
 * 
 * acceptable input values for those methods is defined in QueryType.
 * @author Jan P.C. Hanson
 *
 */
public final class QueryInvoker
{
	/** Defensive enum defines the acceptable inputs to the factory**/
	public enum QueryType 
		{
			/**@see {@link tomoBay.model.sql.queries.concreteQueries.insert.InsertEbayBuyers}**/
			INSERT_EBAY_BUYERS,
			/**@see {@link tomoBay.model.sql.queries.concreteQueries.insert.InsertEbayItems}**/
			INSERT_EBAY_ITEMS,
			/**@see {@link tomoBay.model.sql.queries.concreteQueries.insert.InsertEbayOrders}**/
			INSERT_EBAY_ORDERS,
			/**@see {@link tomoBay.model.sql.queries.concreteQueries.insert.InsertEbayTransactions}**/
			INSERT_EBAY_TRANSACTIONS,
			/**@see {@link tomoBay.model.sql.queries.concreteQueries.insert.InsertOutOfHours}**/
			INSERT_OUT_OF_HOURS,
			/**@see {@link tomoBay.model.sql.queries.concreteQueries.insert.InsertPart}**/
			INSERT_PART,
			/**@see {@link tomoBay.model.sql.queries.concreteQueries.insert.InsertPartMapping}**/
			INSERT_PART_MAPPING,
			
			/**@see {@link tomoBay.model.sql.queries.concreteQueries.select.SelectEbayItemsNotInTransactions}**/
			SELECT_EBAY_ITEMS_NOT_IN_TRANSACTIONS,
			/**@see {@link tomoBay.model.sql.queries.concreteQueries.select.SelectEbayOrders}**/
			SELECT_EBAY_ORDERS,
			/**@see {@link tomoBay.model.sql.queries.concreteQueries.select.SelectEbayItems}**/
			SELECT_EBAY_ITEMS,
			/**@see {@link tomoBay.model.sql.queries.concreteQueries.select.SelectEbayItemSpecific}**/
			SELECT_EBAY_ITEM_SPECIFIC,
			/**@see {@link tomoBay.model.sql.queries.concreteQueries.select.SelectTransactionByOrder}**/
			SELECT_TRANSACTION_BY_ORDERID,
			/**@see {@link tomoBay.model.sql.queries.concreteQueries.select.SelectUninvoicedOrders}**/
			SELECT_UNINVOICED_ORDERS,
			/**@see {@link tomoBay.model.sql.queries.concreteQueries.select.SelectUninvoicedOrdersNoErrors}**/
			SELECT_UNINVOICED_ORDERS_NO_ERRORS,
			/**@see {@link tomoBay.model.sql.queries.concreteQueries.select.SelectEbayItemsError}**/
			SELECT_EBAY_ITEMS_ERROR,
			/**@see {@link tomoBay.model.sql.queries.concreteQueries.select.SelectFullOrderLine}**/
			SELECT_FULL_ORDER_LINE,
			/**@see {@link tomoBay.model.sql.queries.concreteQueries.select.SelectInvoicedOrders}**/
			SELECT_INVOICED_ORDERS,
			/**@see {@link tomoBay.model.sql.queries.concreteQueries.select.SelectUncalculatedInvoices}**/
			SELECT_UNCALCULATED_INVOICES,
			/**@see {@link tomoBay.model.sql.queries.concreteQueries.select.SelectOutOfHoursOrders}**/
			SELECT_OUT_OF_HOURS_ORDERS,
			/**@see {@link tomoBay.model.sql.queries.concreteQueries.select.SelectUncalculatedOrders}**/
			SELECT_UNCALCULATED_ORDERS,
			/**@see {@link tomoBay.model.sql.queries.concreteQueries.select.SelectEbayBuyer}**/
			SELECT_EBAY_BUYER,
			/**@see {@link tomoBay.model.sql.queries.concreteQueries.select.SelectEbayBuyers}**/
			SELECT_EBAY_BUYERS,
			/**@see {@link tomoBay.model.sql.queries.concreteQueries.select.SelectEbayTransactionByID}**/
			SELECT_EBAY_TRANSACTION_BY_ID,
			/**@see {@link tomoBay.model.sql.queries.concreteQueries.select.SelectEbayOrderByID}**/
			SELECT_EBAY_ORDER_BY_ID,
			/**@see {@link tomoBay.model.sql.queries.concreteQueries.select.SelectEbayOrderByBuyer}**/
			SELECT_EBAY_ORDER_BY_BUYER,
			/**@see {@link tomoBay.model.sql.queries.concreteQueries.select.SelectBrandByInvNo}**/
			SELECT_BRAND_BY_INV_NO,
			/**@see {@link tomoBay.model.sql.queries.concreteQueries.select.SelectAccounts}**/
			SELECT_ACCOUNTS,
			
			/**@see {@link tomoBay.model.sql.queries.concreteQueries.update.UpdateItemBrandAndPartNo}**/
			UPDATE_ITEM_BRAND_AND_PARTNO,
			/**@see {@link tomoBay.model.sql.queries.concreteQueries.update.UpdateInvoiceStatus}**/
			UPDATE_INVOICE_STATUS,
			/**@see {@link tomoBay.model.sql.queries.concreteQueries.update.UpdateInvoiceStatusSRN}**/
			UPDATE_INVOICE_STATUS_SRN,
			/**@see {@link tomoBay.model.sql.queries.concreteQueries.update.UpdateItemError}**/
			UPDATE_ITEM_ERROR,
			/**@see {@link tomoBay.model.sql.queries.concreteQueries.update.UpdateItemNote}**/
			UPDATE_ITEM_NOTE,
			/**@see {@link tomoBay.model.sql.queries.concreteQueries.update.UpdateEbayBuyer}**/
			UPDATE_EBAY_BUYER,
		}
	/**internal map holds factory objects created static final to make threadsafe**/
	@SuppressWarnings("serial")
	private static final Map<QueryType, AbstractQueryFactory> factoryMap_M
											= new HashMap<QueryType, AbstractQueryFactory>()
		{{
			put(QueryType.INSERT_EBAY_BUYERS, new InsertEbayBuyersFactory());
			put(QueryType.INSERT_EBAY_ITEMS, new InsertEbayItemsFactory());
			put(QueryType.INSERT_EBAY_ORDERS, new InsertEbayOrdersFactory());
			put(QueryType.INSERT_EBAY_TRANSACTIONS, new InsertEbayTransactionsFactory());
			put(QueryType.INSERT_OUT_OF_HOURS, new InsertOutOfHoursFactory());
			put(QueryType.INSERT_PART, new InsertPartFactory());
			put(QueryType.INSERT_PART_MAPPING, new InsertPartMappingFactory());

			put(QueryType.SELECT_EBAY_ITEMS_NOT_IN_TRANSACTIONS, new SelectEbayItemsNotInTransactionsFactory());
			put(QueryType.SELECT_EBAY_ORDERS, new SelectEbayOrdersFactory());
			put(QueryType.SELECT_EBAY_ITEMS, new SelectEbayItemsFactory());
			put(QueryType.SELECT_EBAY_ITEM_SPECIFIC, new SelectEbayItemSpecificFactory());
			put(QueryType.SELECT_TRANSACTION_BY_ORDERID, new SelectTransactionByOrderIDFactory());
			put(QueryType.SELECT_UNINVOICED_ORDERS, new SelectUninvoicedOrdersFactory());
			put(QueryType.SELECT_UNINVOICED_ORDERS_NO_ERRORS, new SelectUninvoicedOrdersNoErrorsFactory());
			put(QueryType.SELECT_EBAY_ITEMS_ERROR, new SelectEbayItemsErrorFactory());
			put(QueryType.SELECT_FULL_ORDER_LINE, new SelectFullOrderLineFactory());
			put(QueryType.SELECT_INVOICED_ORDERS, new SelectInvoicedOrdersFactory());
			put(QueryType.SELECT_UNCALCULATED_INVOICES, new SelectUncalculatedInvoicesFactory());
			put(QueryType.SELECT_OUT_OF_HOURS_ORDERS, new SelectOutOfHoursOrdersFactory());
			put(QueryType.SELECT_UNCALCULATED_ORDERS, new SelectUncalculatedOrdersFactory());
			put(QueryType.SELECT_EBAY_BUYER, new SelectEbayBuyerFactory());
			put(QueryType.SELECT_EBAY_BUYERS, new SelectEbayBuyersFactory());
			put(QueryType.SELECT_EBAY_TRANSACTION_BY_ID, new SelectEbayTransactionByIDFactory());
			put(QueryType.SELECT_EBAY_ORDER_BY_ID, new SelectEbayOrderByIDFactory());
			put(QueryType.SELECT_EBAY_ORDER_BY_BUYER, new SelectEbayOrderByBuyerFactory());
			put(QueryType.SELECT_BRAND_BY_INV_NO, new SelectBrandByInvNoFactory());
			put(QueryType.SELECT_ACCOUNTS, new SelectAccountsFactory());
			
			put(QueryType.UPDATE_ITEM_BRAND_AND_PARTNO, new UpdateItemBrandAndPartNoFactory());
			put(QueryType.UPDATE_INVOICE_STATUS, new UpdateInvoiceStatusFactory());
			put(QueryType.UPDATE_ITEM_ERROR, new UpdateItemErrorFactory());
			put(QueryType.UPDATE_ITEM_NOTE, new UpdateItemNoteFactory());
			put(QueryType.UPDATE_INVOICE_STATUS_SRN, new UpdateInvoiceStatusSRNFactory());
			put(QueryType.UPDATE_EBAY_BUYER, new UpdateEbayBuyerFactory());
		}};
	
	/**
	 * make the requested data base query.
	 * @param query
	 * @return
	 */
	public static AbstractDBQuery make(QueryType query)
	{return QueryInvoker.factoryMap_M.get(query).make();}
	
	/**
	 * execute a requested query
	 * @param query one of the enum values provided by QueryType enum.
	 * @param parameters String[] of parameters specific to the query you are using, see
	 * individual query docs.
	 * @return List<String[]>
	 * @throws SQLException
	 */
	public static List<String[]> execute(QueryType query, String[] parameters)
	{
		try
		{return QueryInvoker.make(query).execute(parameters);}
		catch(SQLException e)
		{
			e.printStackTrace();
			return null;
		}
	}
}

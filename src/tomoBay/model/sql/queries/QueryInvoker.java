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

import tomoBay.model.sql.queries.factories.ClearPartsFordFactory;
import tomoBay.model.sql.queries.factories.ClearPartsPSAFactory;
import tomoBay.model.sql.queries.factories.ClearPartsPrestigeFactory;
import tomoBay.model.sql.queries.factories.InsertEbayBuyersFactory;
import tomoBay.model.sql.queries.factories.InsertEbayItemsFactory;
import tomoBay.model.sql.queries.factories.InsertEbayOrdersFactory;
import tomoBay.model.sql.queries.factories.InsertEbayTransactionsFactory;
import tomoBay.model.sql.queries.factories.InsertFordStockReqFactory;
import tomoBay.model.sql.queries.factories.InsertOutOfHoursFactory;
import tomoBay.model.sql.queries.factories.InsertPSAStockReqFactory;
import tomoBay.model.sql.queries.factories.InsertPrestigeStockReqFactory;
import tomoBay.model.sql.queries.factories.SelectEbayItemSpecificFactory;
import tomoBay.model.sql.queries.factories.SelectEbayItemsErrorFactory;
import tomoBay.model.sql.queries.factories.SelectEbayItemsFactory;
import tomoBay.model.sql.queries.factories.SelectEbayItemsNotInTransactionsFactory;
import tomoBay.model.sql.queries.factories.SelectEbayOrdersFactory;
import tomoBay.model.sql.queries.factories.SelectFordStockReqFactory;
import tomoBay.model.sql.queries.factories.SelectFullOrderLineFactory;
import tomoBay.model.sql.queries.factories.SelectInvoicedOrdersFactory;
import tomoBay.model.sql.queries.factories.SelectOutOfHoursOrdersFactory;
import tomoBay.model.sql.queries.factories.SelectPSAStockReqFactory;
import tomoBay.model.sql.queries.factories.SelectPrestigeStockReqFactory;
import tomoBay.model.sql.queries.factories.SelectTransactionByOrderIDFactory;
import tomoBay.model.sql.queries.factories.SelectUncalculatedInvoicesFactory;
import tomoBay.model.sql.queries.factories.SelectUncalculatedOrdersFactory;
import tomoBay.model.sql.queries.factories.SelectUninvoicedOrdersFactory;
import tomoBay.model.sql.queries.factories.SelectUninvoicedOrdersNoErrorsFactory;
import tomoBay.model.sql.queries.factories.UpdateAvailableStockFordFactory;
import tomoBay.model.sql.queries.factories.UpdateAvailableStockPSAFactory;
import tomoBay.model.sql.queries.factories.UpdateAvailableStockPrestigeFactory;
import tomoBay.model.sql.queries.factories.UpdateFordStockReqFactory;
import tomoBay.model.sql.queries.factories.UpdateInvoiceStatusFactory;
import tomoBay.model.sql.queries.factories.UpdateInvoiceStatusSRNFactory;
import tomoBay.model.sql.queries.factories.UpdateItemBrandAndPartNoFactory;
import tomoBay.model.sql.queries.factories.UpdateItemErrorFactory;
import tomoBay.model.sql.queries.factories.UpdateItemNoteFactory;
import tomoBay.model.sql.queries.factories.UpdatePSAStockReqFactory;
import tomoBay.model.sql.queries.factories.UpdatePrestigeStockReqFactory;
import tomoBay.model.sql.queries.factories.UpdateTotalItemsRequiredFactory;
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
public class QueryInvoker
{
	/** Defensive enum defines the acceptable inputs to the factory**/
	public enum QueryType 
		{
			/**@see {@link tomoBay.model.sql.queries.concreteQueries.InsertEbayBuyers}**/
			INSERT_EBAY_BUYERS,
			/**@see {@link tomoBay.model.sql.queries.concreteQueries.InsertEbayItems}**/
			INSERT_EBAY_ITEMS,
			/**@see {@link tomoBay.model.sql.queries.concreteQueries.InsertEbayOrders}**/
			INSERT_EBAY_ORDERS,
			/**@see {@link tomoBay.model.sql.queries.concreteQueries.InsertEbayTransactions}**/
			INSERT_EBAY_TRANSACTIONS,
			/**@see {@link tomoBay.model.sql.queries.concreteQueries.InsertPSAStockReq}**/
			INSERT_PSA_STOCK_REQ,
			/**@see {@link tomoBay.model.sql.queries.concreteQueries.InsertFordStockReq}**/
			INSERT_FORD_STOCK_REQ,
			/**@see {@link tomoBay.model.sql.queries.concreteQueries.InsertPrestigeStockReq}**/
			INSERT_PRESTIGE_STOCK_REQ,
			/**@see {@link tomoBay.model.sql.queries.concreteQueries.InsertOutOfHours}**/
			INSERT_OUT_OF_HOURS,
			
			/**@see {@link tomoBay.model.sql.queries.concreteQueries.SelectEbayItemsNotInTransactions}**/
			SELECT_EBAY_ITEMS_NOT_IN_TRANSACTIONS,
			/**@see {@link tomoBay.model.sql.queries.concreteQueries.SelectEbayOrders}**/
			SELECT_EBAY_ORDERS,
			/**@see {@link tomoBay.model.sql.queries.concreteQueries.SelectEbayItems}**/
			SELECT_EBAY_ITEMS,
			/**@see {@link tomoBay.model.sql.queries.concreteQueries.SelectPSAStockReqByPart}**/
			SELECT_PSA_STOCK_REQ,
			/**@see {@link tomoBay.model.sql.queries.concreteQueries.SelectFordStockReqByPart}**/
			SELECT_FORD_STOCK_REQ,
			/**@see {@link tomoBay.model.sql.queries.concreteQueries.SelectPrestigeStockReqByPart}**/
			SELECT_PRESTIGE_STOCK_REQ,
			/**@see {@link tomoBay.model.sql.queries.concreteQueries.SelectEbayItemSpecific}**/
			SELECT_EBAY_ITEM_SPECIFIC,
			/**@see {@link tomoBay.model.sql.queries.concreteQueries.SelectTransactionByOrder}**/
			SELECT_TRANSACTION_BY_ORDERID,
			/**@see {@link tomoBay.model.sql.queries.concreteQueries.SelectUninvoicedOrders}**/
			SELECT_UNINVOICED_ORDERS,
			/**@see {@link tomoBay.model.sql.queries.concreteQueries.SelectUninvoicedOrdersNoErrors}**/
			SELECT_UNINVOICED_ORDERS_NO_ERRORS,
			/**@see {@link tomoBay.model.sql.queries.concreteQueries.SelectEbayItemsError}**/
			SELECT_EBAY_ITEMS_ERROR,
			/**@see {@link tomoBay.model.sql.queries.concreteQueries.SelectFullOrderLine}**/
			SELECT_FULL_ORDER_LINE,
			/**@see {@link tomoBay.model.sql.queries.concreteQueries.SelectInvoicedOrders}**/
			SELECT_INVOICED_ORDERS,
			/**@see {@link tomoBay.model.sql.queries.concreteQueries.SelectUncalculatedInvoices}**/
			SELECT_UNCALCULATED_INVOICES,
			/**@see {@link tomoBay.model.sql.queries.concreteQueries.SelectOutOfHoursOrders}**/
			SELECT_OUT_OF_HOURS_ORDERS,
			/**@see {@link tomoBay.model.sql.queries.concreteQueries.SelectUncalculatedOrders}**/
			SELECT_UNCALCULATED_ORDERS,
			
			/**@see {@link tomoBay.model.sql.queries.concreteQueries.UpdateItemBrandAndPartNo}**/
			UPDATE_ITEM_BRAND_AND_PARTNO,
			/**@see {@link tomoBay.model.sql.queries.concreteQueries.UpdateTotalItemsRequired}**/
			UPDATE_TOTAL_ITEMS_REQUIRED,
			/**@see {@link tomoBay.model.sql.queries.concreteQueries.UpdatePSAStockReq}**/
			UPDATE_PSA_STOCK_REQ,
			/**@see {@link tomoBay.model.sql.queries.concreteQueries.UpdateFordStockReq}**/
			UPDATE_FORD_STOCK_REQ,
			/**@see {@link tomoBay.model.sql.queries.concreteQueries.UpdatePrestigeStockReq}**/
			UPDATE_PRESTIGE_STOCK_REQ,
			/**@see {@link tomoBay.model.sql.queries.concreteQueries.UpdateAvailableStockPSA}**/
			UPDATE_AVAILABLE_STOCK_PSA,
			/**@see {@link tomoBay.model.sql.queries.concreteQueries.UpdateAvailableStockFord}**/
			UPDATE_AVAILABLE_STOCK_FORD,
			/**@see {@link tomoBay.model.sql.queries.concreteQueries.UpdateAvailableStockPrestige}**/
			UPDATE_AVAILABLE_STOCK_PRESTIGE,
			/**@see {@link tomoBay.model.sql.queries.concreteQueries.UpdateInvoiceStatus}**/
			UPDATE_INVOICE_STATUS,
			/**@see {@link tomoBay.model.sql.queries.concreteQueries.UpdateInvoiceStatusSRN}**/
			UPDATE_INVOICE_STATUS_SRN,
			/**@see {@link tomoBay.model.sql.queries.concreteQueries.UpdateItemError}**/
			UPDATE_ITEM_ERROR,
			/**@see {@link tomoBay.model.sql.queries.concreteQueries.UpdateItemNote}**/
			UPDATE_ITEM_NOTE,
			
			/**@see {@link tomoBay.model.sql.queries.concreteQueries.ClearPartsPSA}**/
			CLEAR_PARTS_PSA,
			/**@see {@link tomoBay.model.sql.queries.concreteQueries.ClearPartsFord}**/
			CLEAR_PARTS_FORD,
			/**@see {@link tomoBay.model.sql.queries.concreteQueries.ClearPartsPrestige}**/
			CLEAR_PARTS_PRESTIGE
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
			put(QueryType.INSERT_PSA_STOCK_REQ, new InsertPSAStockReqFactory());
			put(QueryType.INSERT_FORD_STOCK_REQ, new InsertFordStockReqFactory());
			put(QueryType.INSERT_PRESTIGE_STOCK_REQ, new InsertPrestigeStockReqFactory());
			put(QueryType.INSERT_OUT_OF_HOURS, new InsertOutOfHoursFactory());

			put(QueryType.SELECT_EBAY_ITEMS_NOT_IN_TRANSACTIONS, new SelectEbayItemsNotInTransactionsFactory());
			put(QueryType.SELECT_EBAY_ORDERS, new SelectEbayOrdersFactory());
			put(QueryType.SELECT_EBAY_ITEMS, new SelectEbayItemsFactory());
			put(QueryType.SELECT_PSA_STOCK_REQ, new SelectPSAStockReqFactory());
			put(QueryType.SELECT_PSA_STOCK_REQ, new SelectPSAStockReqFactory());
			put(QueryType.SELECT_FORD_STOCK_REQ, new SelectFordStockReqFactory());
			put(QueryType.SELECT_PRESTIGE_STOCK_REQ, new SelectPrestigeStockReqFactory());
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

			put(QueryType.UPDATE_ITEM_BRAND_AND_PARTNO, new UpdateItemBrandAndPartNoFactory());
			put(QueryType.UPDATE_TOTAL_ITEMS_REQUIRED, new UpdateTotalItemsRequiredFactory());
			put(QueryType.UPDATE_PSA_STOCK_REQ, new UpdatePSAStockReqFactory());
			put(QueryType.UPDATE_FORD_STOCK_REQ, new UpdateFordStockReqFactory());
			put(QueryType.UPDATE_PRESTIGE_STOCK_REQ, new UpdatePrestigeStockReqFactory());
			put(QueryType.UPDATE_AVAILABLE_STOCK_PSA, new UpdateAvailableStockPSAFactory());
			put(QueryType.UPDATE_AVAILABLE_STOCK_FORD, new UpdateAvailableStockFordFactory());
			put(QueryType.UPDATE_AVAILABLE_STOCK_PRESTIGE, new UpdateAvailableStockPrestigeFactory());
			put(QueryType.UPDATE_INVOICE_STATUS, new UpdateInvoiceStatusFactory());
			put(QueryType.UPDATE_ITEM_ERROR, new UpdateItemErrorFactory());
			put(QueryType.UPDATE_ITEM_NOTE, new UpdateItemNoteFactory());
			put(QueryType.UPDATE_INVOICE_STATUS_SRN, new UpdateInvoiceStatusSRNFactory());
			
			put(QueryType.CLEAR_PARTS_PSA, new ClearPartsPSAFactory());
			put(QueryType.CLEAR_PARTS_FORD, new ClearPartsFordFactory());
			put(QueryType.CLEAR_PARTS_PRESTIGE, new ClearPartsPrestigeFactory());
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

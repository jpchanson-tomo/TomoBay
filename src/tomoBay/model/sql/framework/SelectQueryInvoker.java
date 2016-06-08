package tomoBay.model.sql.framework;
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
import gnu.trove.map.hash.THashMap;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import tomoBay.model.dataTypes.heteroTypeContainer.HeteroFieldContainer;
import tomoBay.model.sql.framework.queryFactories.AbstractSelectNoParamsQueryFactory;
import tomoBay.model.sql.framework.queryFactories.AbstractSelectParamsQueryFactory;
import tomoBay.model.sql.queries.factories.select.noParams.SelectAccountsFactory;
import tomoBay.model.sql.queries.factories.select.noParams.SelectEbayBuyersFactory;
import tomoBay.model.sql.queries.factories.select.noParams.SelectEbayItemsErrorFactory;
import tomoBay.model.sql.queries.factories.select.noParams.SelectEbayItemsFactory;
import tomoBay.model.sql.queries.factories.select.noParams.SelectEbayItemsNotInTransactionsFactory;
import tomoBay.model.sql.queries.factories.select.noParams.SelectEbayOrdersFactory;
import tomoBay.model.sql.queries.factories.select.noParams.SelectInvoicedOrdersFactory;
import tomoBay.model.sql.queries.factories.select.noParams.SelectUncalculatedInvoicesFactory;
import tomoBay.model.sql.queries.factories.select.noParams.SelectUncalculatedOrdersFactory;
import tomoBay.model.sql.queries.factories.select.noParams.SelectUninvoicedOrdersFactory;
import tomoBay.model.sql.queries.factories.select.noParams.SelectUninvoicedOrdersNoErrorsFactory;
import tomoBay.model.sql.queries.factories.select.params.SelectBrandAndPartNoByOrderIDFactory;
import tomoBay.model.sql.queries.factories.select.params.SelectBrandByInvNoFactory;
import tomoBay.model.sql.queries.factories.select.params.SelectBuyerByAccAndSRNFactory;
import tomoBay.model.sql.queries.factories.select.params.SelectEbayBuyerFactory;
import tomoBay.model.sql.queries.factories.select.params.SelectEbayItemSpecificFactory;
import tomoBay.model.sql.queries.factories.select.params.SelectEbayOrderByBuyerFactory;
import tomoBay.model.sql.queries.factories.select.params.SelectEbayOrderByIDFactory;
import tomoBay.model.sql.queries.factories.select.params.SelectEbayOrderHistoryLastNDaysFactory;
import tomoBay.model.sql.queries.factories.select.params.SelectEbayTransactionByIDFactory;
import tomoBay.model.sql.queries.factories.select.params.SelectFullOrderLineFactory;
import tomoBay.model.sql.queries.factories.select.params.SelectOutOfHoursOrdersFactory;
import tomoBay.model.sql.queries.factories.select.params.SelectTransactionByOrderIDFactory;
/**
 * This object is responsible for providing the user with SelectQuery objects as specified by the
 * internal enum, which defines all possible Select queries that can be executed on the database.
 * 
 * These Select query objects can either be created using the make() method or directly executed
 * using the execute() method. 
 * 
 * acceptable input values for those methods is defined in QueryType.
 * @author Jan P.C. Hanson
 *
 */
public final class SelectQueryInvoker
{
	/** Defensive enum defines the acceptable inputs to the factory**/
	public enum SelectQueryTypeNoParams 
		{
			/**@see tomoBay.model.sql.queries.concreteQueries.select.SelectEbayItemsNotInTransactions**/
			SELECT_EBAY_ITEMS_NOT_IN_TRANSACTIONS,
			/**@see tomoBay.model.sql.queries.concreteQueries.select.SelectEbayOrders}**/
			SELECT_EBAY_ORDERS,
			/**@see tomoBay.model.sql.queries.concreteQueries.select.SelectEbayItems**/
			SELECT_EBAY_ITEMS,
			/**@see tomoBay.model.sql.queries.concreteQueries.select.SelectUninvoicedOrders**/
			SELECT_UNINVOICED_ORDERS,
			/**@see tomoBay.model.sql.queries.concreteQueries.select.SelectUninvoicedOrdersNoErrors**/
			SELECT_UNINVOICED_ORDERS_NO_ERRORS,
			/**@see tomoBay.model.sql.queries.concreteQueries.select.SelectEbayItemsError**/
			SELECT_EBAY_ITEMS_ERROR,
			/**@see tomoBay.model.sql.queries.concreteQueries.select.SelectInvoicedOrders**/
			SELECT_INVOICED_ORDERS,
			/**@see tomoBay.model.sql.queries.concreteQueries.select.SelectUncalculatedInvoices**/
			SELECT_UNCALCULATED_INVOICES,
			/**@see tomoBay.model.sql.queries.concreteQueries.select.SelectUncalculatedOrders**/
			SELECT_UNCALCULATED_ORDERS,
			/**@see tomoBay.model.sql.queries.concreteQueries.select.SelectEbayBuyers**/
			SELECT_EBAY_BUYERS,
			/**@see tomoBay.model.sql.queries.concreteQueries.select.SelectAccounts**/
			SELECT_ACCOUNTS,
		}
	/** Defensive enum defines the acceptable inputs to the factory**/
	public enum SelectQueryTypeParams 
	{
		/**@see tomoBay.model.sql.queries.concreteQueries.select.SelectEbayOrderByID**/
		SELECT_EBAY_ORDER_BY_ID,
		/**@see tomoBay.model.sql.queries.concreteQueries.select.SelectEbayOrderByBuyer**/
		SELECT_EBAY_ORDER_BY_BUYER,
		/**@see tomoBay.model.sql.queries.concreteQueries.select.SelectBrandByInvNo**/
		SELECT_BRAND_BY_INV_NO,
		/**@see tomoBay.model.sql.queries.concreteQueries.select.SelectEbayBuyer**/
		SELECT_EBAY_BUYER,
		/**@see tomoBay.model.sql.queries.concreteQueries.select.SelectEbayItemSpecific**/
		SELECT_EBAY_ITEM_SPECIFIC,
		/**@see tomoBay.model.sql.queries.concreteQueries.select.SelectTransactionByOrder**/
		SELECT_TRANSACTION_BY_ORDERID,
		/**@see tomoBay.model.sql.queries.concreteQueries.select.SelectFullOrderLine**/
		SELECT_FULL_ORDER_LINE,
		/**@see tomoBay.model.sql.queries.concreteQueries.select.SelectOutOfHoursOrders**/
		SELECT_OUT_OF_HOURS_ORDERS,
		/**@see tomoBay.model.sql.queries.concreteQueries.select.SelectEbayTransactionByID**/
		SELECT_EBAY_TRANSACTION_BY_ID,
		/**@see tomoBay.model.sql.queries.concreteQueries.select.SelectBrandAndPartNoByOrderID**/
		SELECT_BRAND_AND_PARTNO_BY_ORDERID,
		/**@see tomoBay.model.sql.queries.concreteQueries.select.SelectBuyerByAccAndSRN**/
		SELECT_EBAY_BUYER_BY_ACCOUNT_AND_SRN,
		
		SELECT_EBAY_ORDER_HISTORY_LAST_N_DAYS
	}
	/**internal map holds factory objects created static final to make threadsafe**/
	private static final Map<SelectQueryTypeNoParams, AbstractSelectNoParamsQueryFactory> noParamsMap_M
											= new THashMap<SelectQueryTypeNoParams, AbstractSelectNoParamsQueryFactory>()
		{{
			put(SelectQueryTypeNoParams.SELECT_EBAY_ITEMS_NOT_IN_TRANSACTIONS, new SelectEbayItemsNotInTransactionsFactory());
			put(SelectQueryTypeNoParams.SELECT_EBAY_ORDERS, new SelectEbayOrdersFactory());
			put(SelectQueryTypeNoParams.SELECT_EBAY_ITEMS, new SelectEbayItemsFactory());
			put(SelectQueryTypeNoParams.SELECT_UNINVOICED_ORDERS, new SelectUninvoicedOrdersFactory());
			put(SelectQueryTypeNoParams.SELECT_UNINVOICED_ORDERS_NO_ERRORS, new SelectUninvoicedOrdersNoErrorsFactory());
			put(SelectQueryTypeNoParams.SELECT_EBAY_ITEMS_ERROR, new SelectEbayItemsErrorFactory());
			put(SelectQueryTypeNoParams.SELECT_INVOICED_ORDERS, new SelectInvoicedOrdersFactory());
			put(SelectQueryTypeNoParams.SELECT_UNCALCULATED_INVOICES, new SelectUncalculatedInvoicesFactory());
			put(SelectQueryTypeNoParams.SELECT_UNCALCULATED_ORDERS, new SelectUncalculatedOrdersFactory());
			put(SelectQueryTypeNoParams.SELECT_EBAY_BUYERS, new SelectEbayBuyersFactory());
			put(SelectQueryTypeNoParams.SELECT_ACCOUNTS, new SelectAccountsFactory());
		}};
		
	private static final Map<SelectQueryTypeParams, AbstractSelectParamsQueryFactory> paramsMap_M
											= new THashMap<SelectQueryTypeParams, AbstractSelectParamsQueryFactory>()
		{{
			put(SelectQueryTypeParams.SELECT_EBAY_ITEM_SPECIFIC, new SelectEbayItemSpecificFactory());
			put(SelectQueryTypeParams.SELECT_TRANSACTION_BY_ORDERID, new SelectTransactionByOrderIDFactory());
			put(SelectQueryTypeParams.SELECT_FULL_ORDER_LINE, new SelectFullOrderLineFactory());
			put(SelectQueryTypeParams.SELECT_OUT_OF_HOURS_ORDERS, new SelectOutOfHoursOrdersFactory());
			put(SelectQueryTypeParams.SELECT_EBAY_BUYER, new SelectEbayBuyerFactory());
			put(SelectQueryTypeParams.SELECT_EBAY_TRANSACTION_BY_ID, new SelectEbayTransactionByIDFactory());
			put(SelectQueryTypeParams.SELECT_EBAY_ORDER_BY_ID, new SelectEbayOrderByIDFactory());
			put(SelectQueryTypeParams.SELECT_EBAY_ORDER_BY_BUYER, new SelectEbayOrderByBuyerFactory());
			put(SelectQueryTypeParams.SELECT_BRAND_BY_INV_NO, new SelectBrandByInvNoFactory());
			put(SelectQueryTypeParams.SELECT_BRAND_AND_PARTNO_BY_ORDERID, new SelectBrandAndPartNoByOrderIDFactory());
			put(SelectQueryTypeParams.SELECT_EBAY_BUYER_BY_ACCOUNT_AND_SRN, new SelectBuyerByAccAndSRNFactory());
			put(SelectQueryTypeParams.SELECT_EBAY_ORDER_HISTORY_LAST_N_DAYS, new SelectEbayOrderHistoryLastNDaysFactory());
		}};
	
	/**
	 * execute a requested query
	 * @param query one of the enum values provided by noParamsMap_M enum.
	 * @return List<HeteroFieldContainer> where each element in the list corresponds to a database
	 * record, and each record (HeteroFieldContainer) contains the fields specific to the query that 
	 * was called (see individual query documentation)
	 */
	public static List<HeteroFieldContainer> execute(SelectQueryTypeNoParams query)
	{
		try
		{
			return SelectQueryInvoker.noParamsMap_M.get(query).make().execute();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * executes the requested query (one that requires parameters)
	 * @param query one of the enum constants contained in the paramsMap_M Enum
	 * @param parameters HeteroFiledContainer containing the fields and values that are required for
	 * the individual query (see individual query documentation)
	 * @return List<HeteroFieldContainer> where each element in the list corresponds to a database
	 * record, and each record (HeteroFieldContainer) contains the fields specific to the query that 
	 * was called (see individual query documentation)
	 */
	public static List<HeteroFieldContainer> execute(SelectQueryTypeParams query , HeteroFieldContainer parameters)
	{
		try
		{return SelectQueryInvoker.paramsMap_M.get(query).make().execute(parameters);}
		catch(SQLException e)
		{
			e.printStackTrace();
			return null;
		}
	}
}

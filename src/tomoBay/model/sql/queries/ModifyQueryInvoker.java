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

import gnu.trove.map.hash.THashMap;

import java.sql.SQLException;
import java.util.Map;

import tomoBay.model.dataTypes.heteroTypeContainer.HeteroFieldContainer;
import tomoBay.model.sql.queries.factories.insert.InsertEbayBuyersFactory;
import tomoBay.model.sql.queries.factories.insert.InsertEbayItemsFactory;
import tomoBay.model.sql.queries.factories.insert.InsertEbayOrdersFactory;
import tomoBay.model.sql.queries.factories.insert.InsertEbayTransactionsFactory;
import tomoBay.model.sql.queries.factories.insert.InsertOutOfHoursFactory;
import tomoBay.model.sql.queries.factories.update.UpdateEbayBuyerFactory;
import tomoBay.model.sql.queries.factories.update.UpdateInvoiceStatusFactory;
import tomoBay.model.sql.queries.factories.update.UpdateInvoiceStatusSRNFactory;
import tomoBay.model.sql.queries.factories.update.UpdateItemBrandAndPartNoFactory;
import tomoBay.model.sql.queries.factories.update.UpdateItemErrorFactory;
import tomoBay.model.sql.queries.factories.update.UpdateItemNoteFactory;
/**
 * This object is responsible for providing the user with Insert or Update Query objects as specified by the
 * internal enum, which defines all possible Insert or Update queries that can be executed on the database.
 * 
 * These Insert or Update query objects can either be created using the make() method or directly executed
 * using the execute() method. 
 * 
 * acceptable input values for those methods is defined in QueryType.
 * @author Jan P.C. Hanson
 *
 */
public final class ModifyQueryInvoker
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
	private static final Map<QueryType, AbstractModifyQueryFactory> factoryMap_M
											= new THashMap<QueryType, AbstractModifyQueryFactory>()
		{{
			put(QueryType.INSERT_EBAY_BUYERS, new InsertEbayBuyersFactory());
			put(QueryType.INSERT_EBAY_ITEMS, new InsertEbayItemsFactory());
			put(QueryType.INSERT_EBAY_ORDERS, new InsertEbayOrdersFactory());
			put(QueryType.INSERT_EBAY_TRANSACTIONS, new InsertEbayTransactionsFactory());
			put(QueryType.INSERT_OUT_OF_HOURS, new InsertOutOfHoursFactory());
			
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
	public static AbstractModifyQuery make(QueryType query)
	{return ModifyQueryInvoker.factoryMap_M.get(query).make();}
	
	/**
	 * execute a requested query
	 * @param query one of the enum values provided by QueryType enum.
	 * @param parameters String[] of parameters specific to the query you are using, see
	 * individual query docs.
	 * @return List<String[]>
	 * @throws SQLException
	 */
	public static HeteroFieldContainer execute(QueryType query, HeteroFieldContainer parameters)
	{
		try
		{return ModifyQueryInvoker.make(query).execute(parameters);}
		catch(SQLException e)
		{
			e.printStackTrace();
			return null;
		}
	}
}

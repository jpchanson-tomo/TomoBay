package openDMS.model.sql.queries;

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

import openDMS.model.sql.queries.factories.InsertEbayBuyersFactory;
import openDMS.model.sql.queries.factories.InsertEbayItemsFactory;
import openDMS.model.sql.queries.factories.InsertEbayOrdersFactory;
import openDMS.model.sql.queries.factories.InsertEbayTransactionsFactory;
import openDMS.model.sql.queries.factories.SelectEbayItemsFactory;
import openDMS.model.sql.queries.factories.SelectEbayItemsNotInTransactionsFactory;
import openDMS.model.sql.queries.factories.SelectEbayOrdersFactory;
import openDMS.model.sql.queries.factories.SelectItemsWithBlankFieldsFactory;
import openDMS.model.sql.queries.factories.UpdateItemBrandAndPartNoFactory;
import openDMS.model.sql.queries.factories.UpdateTotalItemsRequiredFactory;
/**
 *
 * @author Jan P.C. Hanson
 *
 */
public class QueryInvoker
{
	/**Defensive enum to limit the acceptable inputs to the factory**/
	public enum QueryType 
		{
			INSERT_EBAY_BUYERS, INSERT_EBAY_ITEMS, INSERT_EBAY_ORDERS, INSERT_EBAY_TRANSACTIONS,
			
			SELECT_EBAY_ITEMS_NOT_IN_TRANSACTIONS, SELECT_EBAY_ORDERS, SELECT_ITEMS_WITH_BLANK_FIELDS,
			SELECT_EBAY_ITEMS,
			
			UPDATE_ITEM_BRAND_AND_PARTNO, UPDATE_TOTAL_ITEMS_REQUIRED
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
			put(QueryType.SELECT_EBAY_ITEMS_NOT_IN_TRANSACTIONS, new SelectEbayItemsNotInTransactionsFactory());
			put(QueryType.SELECT_EBAY_ORDERS, new SelectEbayOrdersFactory());
			put(QueryType.SELECT_EBAY_ITEMS, new SelectEbayItemsFactory());
			put(QueryType.SELECT_ITEMS_WITH_BLANK_FIELDS, new SelectItemsWithBlankFieldsFactory());
			put(QueryType.UPDATE_ITEM_BRAND_AND_PARTNO, new UpdateItemBrandAndPartNoFactory());
			put(QueryType.UPDATE_TOTAL_ITEMS_REQUIRED, new UpdateTotalItemsRequiredFactory());
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
	public static List<String[]> execute(QueryType query, String[] parameters) throws SQLException
	{return QueryInvoker.make(query).execute(parameters);}
}

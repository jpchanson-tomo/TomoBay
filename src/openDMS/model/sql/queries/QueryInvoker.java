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

import openDMS.model.sql.queries.factories.ClearPartsFordFactory;
import openDMS.model.sql.queries.factories.ClearPartsPSAFactory;
import openDMS.model.sql.queries.factories.ClearPartsPrestigeFactory;
import openDMS.model.sql.queries.factories.InsertEbayBuyersFactory;
import openDMS.model.sql.queries.factories.InsertEbayItemsFactory;
import openDMS.model.sql.queries.factories.InsertEbayOrdersFactory;
import openDMS.model.sql.queries.factories.InsertEbayTransactionsFactory;
import openDMS.model.sql.queries.factories.InsertFordStockReqFactory;
import openDMS.model.sql.queries.factories.InsertPSAStockReqFactory;
import openDMS.model.sql.queries.factories.InsertPrestigeStockReqFactory;
import openDMS.model.sql.queries.factories.SelectEbayItemSpecificFactory;
import openDMS.model.sql.queries.factories.SelectEbayItemsFactory;
import openDMS.model.sql.queries.factories.SelectEbayItemsNotInTransactionsFactory;
import openDMS.model.sql.queries.factories.SelectEbayOrdersFactory;
import openDMS.model.sql.queries.factories.SelectFordStockReqFactory;
import openDMS.model.sql.queries.factories.SelectPSAStockReqFactory;
import openDMS.model.sql.queries.factories.SelectPrestigeStockReqFactory;
import openDMS.model.sql.queries.factories.UpdateAvailableStockFordFactory;
import openDMS.model.sql.queries.factories.UpdateAvailableStockPSAFactory;
import openDMS.model.sql.queries.factories.UpdateAvailableStockPrestigeFactory;
import openDMS.model.sql.queries.factories.UpdateFordStockReqFactory;
import openDMS.model.sql.queries.factories.UpdateItemBrandAndPartNoFactory;
import openDMS.model.sql.queries.factories.UpdatePSAStockReqFactory;
import openDMS.model.sql.queries.factories.UpdatePrestigeStockReqFactory;
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
			INSERT_PSA_STOCK_REQ, INSERT_FORD_STOCK_REQ, INSERT_PRESTIGE_STOCK_REQ,
			
			SELECT_EBAY_ITEMS_NOT_IN_TRANSACTIONS, SELECT_EBAY_ORDERS, SELECT_ITEMS_WITH_BLANK_FIELDS,
			SELECT_EBAY_ITEMS, SELECT_PSA_STOCK_REQ, SELECT_FORD_STOCK_REQ, SELECT_PRESTIGE_STOCK_REQ,
			SELECT_ALL_PSA_PARTS, SELECT_EBAY_ITEM_SPECIFIC,
			
			UPDATE_ITEM_BRAND_AND_PARTNO, UPDATE_TOTAL_ITEMS_REQUIRED, UPDATE_PSA_STOCK_REQ,
			UPDATE_FORD_STOCK_REQ, UPDATE_PRESTIGE_STOCK_REQ, UPDATE_AVAILABLE_STOCK_PSA,
			UPDATE_AVAILABLE_STOCK_FORD, UPDATE_AVAILABLE_STOCK_PRESTIGE,
			
			CLEAR_PARTS_PSA, CLEAR_PARTS_FORD, CLEAR_PARTS_PRESTIGE
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

			put(QueryType.SELECT_EBAY_ITEMS_NOT_IN_TRANSACTIONS, new SelectEbayItemsNotInTransactionsFactory());
			put(QueryType.SELECT_EBAY_ORDERS, new SelectEbayOrdersFactory());
			put(QueryType.SELECT_EBAY_ITEMS, new SelectEbayItemsFactory());
			put(QueryType.SELECT_PSA_STOCK_REQ, new SelectPSAStockReqFactory());
			put(QueryType.SELECT_PSA_STOCK_REQ, new SelectPSAStockReqFactory());
			put(QueryType.SELECT_FORD_STOCK_REQ, new SelectFordStockReqFactory());
			put(QueryType.SELECT_PRESTIGE_STOCK_REQ, new SelectPrestigeStockReqFactory());
			put(QueryType.SELECT_EBAY_ITEM_SPECIFIC, new SelectEbayItemSpecificFactory());

			put(QueryType.UPDATE_ITEM_BRAND_AND_PARTNO, new UpdateItemBrandAndPartNoFactory());
			put(QueryType.UPDATE_TOTAL_ITEMS_REQUIRED, new UpdateTotalItemsRequiredFactory());
			put(QueryType.UPDATE_PSA_STOCK_REQ, new UpdatePSAStockReqFactory());
			put(QueryType.UPDATE_FORD_STOCK_REQ, new UpdateFordStockReqFactory());
			put(QueryType.UPDATE_PRESTIGE_STOCK_REQ, new UpdatePrestigeStockReqFactory());
			put(QueryType.UPDATE_AVAILABLE_STOCK_PSA, new UpdateAvailableStockPSAFactory());
			put(QueryType.UPDATE_AVAILABLE_STOCK_FORD, new UpdateAvailableStockFordFactory());
			put(QueryType.UPDATE_AVAILABLE_STOCK_PRESTIGE, new UpdateAvailableStockPrestigeFactory());

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

package openDMS.model.services.stockUpdate;
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
import java.util.HashMap;
import java.util.Map;

import openDMS.model.sql.queries.QueryInvoker;
import openDMS.model.sql.queries.QueryInvoker.QueryType;
/**
 *
 * @author Jan P.C. Hanson
 *
 */
public class StockRequiredQueryFactory
{
	/**Enum used to contain brand options**/
	public enum BrandCode {C /**Citroen**/, F/**ford**/ , P /**prestige**/}
	/**Enum used to contain query**/
	public enum StockQueryType {UPDATE, INSERT, SELECT}
	/**Holder for the brand currently set**/
	private BrandCode currentBrand;
	/**
	 * 
	 */
	@SuppressWarnings("serial")
	private static final Map<BrandCode, QueryInvoker.QueryType[]> brandToQuery_M 
			= new HashMap<BrandCode, QueryInvoker.QueryType[]>()
			{{
				put(BrandCode.C, new QueryInvoker.QueryType[] 
						{
							QueryInvoker.QueryType.UPDATE_PSA_STOCK_REQ,
							QueryInvoker.QueryType.INSERT_PSA_STOCK_REQ,
							QueryInvoker.QueryType.SELECT_PSA_STOCK_REQ
						});
				put(BrandCode.F, new QueryInvoker.QueryType[] 
						{
							QueryInvoker.QueryType.UPDATE_FORD_STOCK_REQ,
							QueryInvoker.QueryType.INSERT_FORD_STOCK_REQ,
							QueryInvoker.QueryType.SELECT_FORD_STOCK_REQ
						});
				put(BrandCode.P, new QueryInvoker.QueryType[] 
						{
							QueryInvoker.QueryType.UPDATE_PRESTIGE_STOCK_REQ,
							QueryInvoker.QueryType.INSERT_PRESTIGE_STOCK_REQ,
							QueryInvoker.QueryType.SELECT_PRESTIGE_STOCK_REQ
						});
			}};
	/**
	 * 
	 * @param brand
	 */
	public void setBrand(String brandCode)
	{currentBrand = BrandCode.valueOf(brandCode);}
	
	/**
	 * 
	 * @param specificQuery
	 * @return
	 */
	public QueryType make(StockQueryType specificQuery)
	{
		if(currentBrand == null) {throw new NullPointerException("No Brand has been set");}
		QueryType query = null;
		switch(specificQuery)
		{
			case UPDATE:
				query = StockRequiredQueryFactory.brandToQuery_M.get(this.currentBrand)[0];
			break;
			case INSERT:
				query = StockRequiredQueryFactory.brandToQuery_M.get(this.currentBrand)[1];
			break;
			case SELECT:
				query = StockRequiredQueryFactory.brandToQuery_M.get(this.currentBrand)[2];
			break;
		}
		return query;
	}
}

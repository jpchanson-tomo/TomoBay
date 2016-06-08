package tomoBay.presenters.presenterActions.concreteActions;
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
import tomoBay.model.dataTypes.heteroTypeContainer.HeteroFieldContainer;
import tomoBay.model.sql.framework.SelectQueryInvoker;
import tomoBay.model.sql.framework.SelectQueryInvoker.SelectQueryTypeParams;
import tomoBay.model.sql.schema.nonDBFields.NonDBFields;
import tomoBay.presenters.presenterActions.AbstractPresenterAction;

import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.Json;

import java.io.StringReader;
import java.util.List;
/**
 * This class represents functionality to 
 * @author Jan P.C. Hanson
 *
 */
public final class StockReOrderAnalysis implements AbstractPresenterAction
{
	/**name of the JSON object property containing the lookback value**/
	private static final String LOOKBACK_PROPERTY = "lookback";
	/**name of the JSON object property containing the threshold reorder value**/
	private static final String THRESHOLD_PROPERTY = "threshold";
	
	/**
	 * default ctor
	 */
	public StockReOrderAnalysis()
	{super();}

	/* (non-Javadoc)
	 * @see tomoBay.presenters.presenterActions.AbstractPresenterAction#execute(java.lang.String)
	 */
	@Override
	public String execute(String data)
	{
		JsonObject json = this.convertToJSon(data);
		List<HeteroFieldContainer> listingHistory = this.grabDBdata(json.getInt(LOOKBACK_PROPERTY));
		List<String[]> processedResults = this.processDBdata(listingHistory);
		List<String[]> suggestions = this.createSuggestedOrders(processedResults, json.getInt(THRESHOLD_PROPERTY));
		return this.formatResultAsJSON(suggestions);
	}

	/**
	 * convert a JSON formatted string to a JsonObject
	 * @param data the JSON formatted string
	 * @return JsonObject
	 */
	private JsonObject convertToJSon(String data)
	{
		JsonReader reader = Json.createReader(new StringReader(data));
		JsonObject jsonObj = reader.readObject();
		reader.close();
		return jsonObj;
	}
	
	/**
	 * grab the history of the last 'lookback' days worth of listings part numbers and the number of 
	 * those listings sold
	 * @param lookback the number of days worth of history to retrieve
	 * @return
	 */
	private List<HeteroFieldContainer> grabDBdata(int lookback)
	{
		HeteroFieldContainer params = new HeteroFieldContainer();
		params.add(NonDBFields.Custom_INT_FIELD, lookback);
		return SelectQueryInvoker.execute(
													SelectQueryTypeParams.SELECT_EBAY_ORDER_HISTORY_LAST_N_DAYS, 
													params
													); 
	}
	
	/**
	 * Takes the database data and processes it so that the composite part number provided by the
	 * database is converted to individual parts, the quantities of these parts(within the listing)
	 * are then multiplied by the quantity of the listing ordered over the number of days to provide
	 * the total list of parts sold over the time period specified
	 * @param dbData the data 
	 * @return
	 */
	private List<String[]> processDBdata(List<HeteroFieldContainer> dbData)
	{
		return null;
	}
	
	/**
	 * @param processedDBData
	 * @param threshold
	 * @return
	 */
	private List<String[]> createSuggestedOrders(List<String[]> processedDBData, int threshold)
	{
		return null;
	}
	
	/**
	 * formats the processed data 
	 * @param processedResults
	 * @return
	 */
	private String formatResultAsJSON(List<String[]> processedResults)
	{
		return null;
	}
}

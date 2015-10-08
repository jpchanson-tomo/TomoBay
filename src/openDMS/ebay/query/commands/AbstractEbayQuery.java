package openDMS.ebay.query.commands;
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
import openDMS.ebay.query.data.ApiCallData;
/**
 * The purpose of this class is to define a common interface that all eBay API calls should
 * subscribe to. It is the abstract base class of all derived eBay API calls. 
 * 
 * @author Jan P.C. Hanson
 *
 */
public abstract class AbstractEbayQuery
{
	/**holder fo te ApiCallData**/
	protected ApiCallData callData_M;
	
	/**
	 * This provides the actual guts of the query.
	 * @param callData the calldata object from the previous query
	 * @param index an integer parameter that may or may not be used by commands
	 * @param string a string parameter that may or may not be used by commands.
	 * @return String representing the results of this query.
	 */
	public abstract String execute(ApiCallData callData, int index, String string);
	
	/**
	 * retrieve the call data object associated with this object
	 * @return
	 */
	public abstract ApiCallData getCallData();
}

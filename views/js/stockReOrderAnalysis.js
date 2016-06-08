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

/////////////////////////////////////////////////////////////////////////////////////////////IMPORTS
//no imports
///////////////////////////////////////////////////////////////////////////////////////ENDOF IMPORTS

////////////////////////////////////////////////////////////////////////////////////////////////CTOR
/**
 * This class provides access to functionality that analyses the current level of stock of all parts
 * sold in the last 'lookback' number of days and provides ordering suggestions if the level falls
 * below a threshold amount.
 * @param resultContainer the CSS selector for the element that should contain the results of the 
 * analysis
 * @param lookback the number of days to analyse the stock levels over
 * @param reOrderThreshold the threshold stock level(in number of days) at which to provide re-order
 * suggestions
 * @author Jan P.C. Hanson
 */
function StockReOrderAnalysis(resultContainer, lookback, reOrderThreshold)
{
	/**the CSS string that defines the element to place the results in**/
	this.container_M = resultContainer;
	/**the number of days to analyse results over**/
	this.lookback_M = lookback;
	/**the threshold stock level(in number of days) at which to provide re-order suggestions**/
	this.reOrderThreshold_M = reOrderThreshold;
	test();
	/**test**/
	function test()
	{
		d = {lookback:lookback};
		d.threshold = reOrderThreshold;
		$.get("/res/?page=ROOT_PRESENTER&type=STOCK_REORDER_ANALYSIS&data="+JSON.stringify(d))
		.done(function(data){alert(data);})
		.fail(function(){alert("fail")});
	}
};
//////////////////////////////////////////////////////////////////////////////////////////ENDOF CTOR

///////////////////////////////////////////////////////////////////////////////////PROTOTYPE METHODS

/////////////////////////////////////////////////////////////////////////////ENDOF PROTOTYPE METHODS
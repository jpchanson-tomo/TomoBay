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

/**
 * The purpose of this class is to define a common interface that all eBay API calls should
 * subscribe to. It is the abstract base class of all derived eBay API calls. 
 * 
 * @author Jan P.C. Hanson
 *
 */
public abstract class AbstractEbayQuery
{
	
	
	/**
	 * This provides the actual guts of the query.
	 * @return String representing the results of this query.
	 */
	public abstract String execute();
}

package tomoBay.model.services.emailErrorsService;
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
import java.util.List;

import tomoBay.model.sql.queries.QueryInvoker;
import tomoBay.model.sql.queries.QueryInvoker.QueryType;
/**
 * This class represents the list of errors that exist within the ebay_items table in the database,
 * and the functionality to retrieve that list as well as some other bits and bobs like find 
 * out if errors exist.
 * @author Jan P.C. Hanson
 *
 */
public final class ErrorsList
{
	/**the list of errors**/
	private List<String[]> errorList_M;
	
	/**
	 * default ctor, generates a the list of errors that this object represents
	 */
	public ErrorsList()
	{
		super();
		this.generateErrorList();
	}
	
	/**
	 * generate a list of items from the database that contain error messages.
	 * @return List<String[]> containing all items that contain error messages.
	 */
	public List<String[]> get()
	{return this.errorList_M;}
	
	/**
	 * returns true if errors exist in the ebay listings false if not
	 * @return true if errors exist in the ebay listings false if not
	 */
	public boolean exist()
	{
		if(this.errorList_M.size() > 0) {return true;}
		else {return false;}
	}
	
	/**
	 * generate the list of errors. this method is only called by the constructor
	 */
	private void generateErrorList()
	{this.errorList_M = QueryInvoker.execute(QueryType.SELECT_EBAY_ITEMS_ERROR, new String[] {});}
}

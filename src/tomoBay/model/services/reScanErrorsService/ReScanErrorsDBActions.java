package tomoBay.model.services.reScanErrorsService;
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
 * This class encapsulates all the interactions that this class has with the database.
 * @author Jan P.C. Hanson
 *
 */
public class ReScanErrorsDBActions
{
	/**
	 * default ctor
	 */
	public ReScanErrorsDBActions()
	{super();}
	
	/**
	 * returns a list of items from the database that contain errors in the 'notes' field of the
	 * ebay_items table.
	 * @return List<String[]> where each 
	 */
	public List<String[]> retrieveAllErrorItems()
	{return QueryInvoker.execute(QueryType.SELECT_EBAY_ITEMS_ERROR, new String[] {});}
	
	/**
	 * updates the database with corrected information, as provided in the ItemSpecifics passed
	 * in as an argument.
	 * @param item the ItemSpecifics containing the corrected information
	 */
	public void updateDBwithCorrectedInfo(ItemSpecifics item)
	{
		String[] correctedInfo= {
									item.get("Brand"), 
									item.get("ManufacturerPartNumber"),
									"",//blank note indicates no error.
									item.getID()
								};		
		QueryInvoker.execute(QueryType.UPDATE_ITEM_ERROR,correctedInfo);
	}
}

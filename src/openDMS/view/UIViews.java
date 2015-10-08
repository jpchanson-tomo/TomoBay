package openDMS.view;
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

import openDMS.helpers.FileToString;
/**
 * This represents the Views for the system. it provides functionality to create the views as 
 * a mapping of String keys to html strings. 
 * 
 * @author Jan P.C. Hanson
 *
 */
public class UIViews
{
	/**mapping of String identifiers to html strings**/
	private Map<String, String> views_M;
	
	/**
	 * default constructor
	 */
	public UIViews()
	{
		super();
		this.views_M = new HashMap<String, String>();
	}
	
	/**
	 * creates the views
	 * @return Map<String, String> the html contained in the files stored in the 'res' folder
	 * mapped to string identifiers.
	 */
	public Map<String, String> createViews()
	{
		this.populateRootView();
		this.populateEbayView();
		return this.views_M;
	}
	
	/**
	 * populate the internal map with the html for the root view
	 */
	private void populateRootView()
	{
		this.views_M.put("root", FileToString.convert("./res/", "index.html", "utf-8"));
	}
	
	/**
	 * populat5e the internal map with the html for the ebay view
	 */
	private void populateEbayView()
	{
		this.views_M.put("ebayHeader", FileToString.convert("./res/ebay/", "eBayHeader.html", "utf-8"));
		this.views_M.put("ebayHeader", FileToString.convert("./res/ebay/", "eBayFooter.html", "utf-8"));
	}
}

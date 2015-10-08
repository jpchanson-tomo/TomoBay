package openDMS.view.views;
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
 *
 * @author Jan P.C. Hanson
 *
 */
public class EbayView implements AbstractView
{
	/**mapping of enum constant keys to html strings**/
	private Map<Part, String> viewPart_M;
	/**enum containing constants relating to the view parts**/
	public enum Part implements AbstractViewPart{HEADER, FOOTER};
	
	/**
	 * default constructor
	 */
	public EbayView()
	{
		super();
		viewPart_M = new HashMap<Part, String>();
		this.populateMap();
	}
	
	/* (non-Javadoc)
	 * @see openDMS.view.AbstractView#make(openDMS.view.AbstractView.PART)
	 */
	@Override
	public String make(AbstractViewPart part)
	{return this.viewPart_M.get(part);}
	
	/**
	 * populates the map with the 
	 */
	protected void populateMap()
	{
		this.viewPart_M.put(EbayView.Part.HEADER, FileToString.convert("./res/ebay/", "eBayHeader.html", "utf-8"));
		this.viewPart_M.put(EbayView.Part.FOOTER, FileToString.convert("./res/ebay/", "eBayFooter.html", "utf-8"));
	}
	
}

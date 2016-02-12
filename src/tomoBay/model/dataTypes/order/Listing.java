package tomoBay.model.dataTypes.order;

import tomoBay.model.services.helpers.PartList;
import tomoBay.model.sql.queries.QueryInvoker;
import tomoBay.model.sql.queries.QueryInvoker.QueryType;
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
 *
 * @author Jan P.C. Hanson
 *
 */
public class Listing
{
	/**the listing ID for this listing as exists on eBay**/
	private final long listingID_M;
	/**the title of the ebay listing**/
	private final String title_M;
	/**the parts associated with this listing**/
	private final Part[] parts_M;
	/**the quantities fo the parts stored in parts_M**/
	private final int[] partQtys_M;
	
	
	public Listing(long listingID)
	{
		String[] listingInfo = Listing.getListingInfo(listingID);
		this.listingID_M = listingID;
		this.title_M = listingInfo[1];
		
		PartList partsTmp = new PartList(listingInfo[4]);
		Part[] partsArray = new Part[partsTmp.size()];
		int[] qtysArray = new int[partsTmp.size()];
		for(int i=0 ; i<partsTmp.size() ; ++i) 
		{
			partsArray[i]=new Part(partsTmp.getPartNumber(i),listingInfo[3]);
			qtysArray[i] = partsTmp.getPartQty(i);
		}
		partsTmp.destroy();
		
		this.parts_M = partsArray;
		this.partQtys_M = qtysArray;
	}
	
	/**
	 * retrieve the listingID associated with this listing
	 * @return long representing the listingID
	 */
	public long listingID() {return this.listingID_M;}
	
	/**
	 * retreive the title of the listing as it appears on ebay
	 * @return String containing the listing title.
	 */
	public String title() {return this.title_M;}
	
	/**
	 * retreive the number of parts that exist in this listing.
	 * @return int representing the number of parts associated with this listing.
	 */
	public int noOfParts() {return this.parts_M.length;}
	
	/**
	 * retrieve the part specified in the parameter
	 * @param index the index of the part to retrieve, you can check how many parts exist in
	 * this listing by calling noOfParts();
	 * @return Part representing the specified part.
	 */
	public Part part(int index) {return this.parts_M[index];}
	
	/**
	 * retrieve the qty of the part at this index.
	 * @param index the index of the part who's qty you wish to know, you can check how many 
	 * parts exist in this listing by calling noOfParts().
	 * @return
	 */
	public int qty(int index) {return this.partQtys_M[index];}
	
	/**
	 * retrieve the accumulated base cost of all parts associated with this listing.
	 * @return double representing the cumulative price of all items associated with the listing.
	 */
	public double listingCost()
	{
		double result=0;
		
		for(int i=0 ; i<this.parts_M.length ; ++i)
		{result+= this.partQtys_M[i] * (this.parts_M[i].cost());}
		
		return result;
	}
	/**
	 * internal method, gets the data for a listing from the database
	 * @param listingID long containing the listingID
	 * @return String[] containing the results of the query.
	 */
	private static final String[] getListingInfo(long listingID)
	{
		return QueryInvoker.execute(
									QueryType.SELECT_EBAY_ITEM_SPECIFIC, 
									new String[] {String.valueOf(listingID)}
									).get(0);
	}
}

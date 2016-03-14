package tomoBay.model.dataTypes.order;
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
import tomoBay.model.dataTypes.PartList;
import tomoBay.model.dataTypes.heteroTypeContainer.ClassRef;
import tomoBay.model.dataTypes.heteroTypeContainer.HeteroFieldContainer;
import tomoBay.model.sql.queries.SelectQueryInvoker;
import tomoBay.model.sql.queries.SelectQueryInvoker.SelectQueryTypeParams;
import tomoBay.model.sql.schema.itemsTable.ItemsTable;
/**
 * This class represents an eBay Listing and once instantiated, contains all the information pertinent
 * to a listing. The key part of the listing is the fact that it is a container for the parts associated
 * with this particular eBay listing. This class provides the functionality to retrieve these parts 
 * and various bits of information about them.
 * 
 * @author Jan P.C. Hanson
 *
 */
public class Listing
{
	/**the parts associated with this listing**/
	private final Part[] parts_M;
	/**the quantities fo the parts stored in parts_M**/
	private final int[] partQtys_M;
	/**the container for the listing information from the database**/
	private final HeteroFieldContainer ListingInfo_M;
	
	/**
	 * constructor, instantiates this listing based on the listingID provided (aka in the database as
	 * itemID)
	 * @param listingID the itemID that uniquely identifies a particular listing
	 */
	public Listing(long listingID)
	{
		this.ListingInfo_M = Listing.getListingInfo(listingID);
		
		final PartList partsTmp = new PartList(this.ListingInfo_M.get(ItemsTable.PART_NO, ClassRef.STRING));
		Part[] partsArray = new Part[partsTmp.size()];
		int[] qtysArray = new int[partsTmp.size()];
		
		for(int i=0 ; i<partsTmp.size() ; ++i) 
		{
			partsArray[i]=new Part(partsTmp.getPartNumber(i),this.brand());
			qtysArray[i] = partsTmp.getPartQty(i);
		}
		
		this.parts_M = partsArray;
		this.partQtys_M = qtysArray;
	}
	
	/**
	 * retrieve the listingID associated with this listing
	 * @return long representing the listingID
	 */
	public long listingID() 
	{return this.ListingInfo_M.get(ItemsTable.ITEM_ID, ClassRef.LONG);}
	
	/**
	 * retreive the title of the listing as it appears on ebay
	 * @return String containing the listing title.
	 */
	public String title() 
	{return this.ListingInfo_M.get(ItemsTable.TITLE, ClassRef.STRING);}
	
	/**
	 * retrieve the brand that is associated with this listing(as it appears on eBay)
	 * @return String containing the brand
	 */
	public String brand()
	{return this.ListingInfo_M.get(ItemsTable.BRAND, ClassRef.STRING);}
	
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
	public String partNos() 
	{return this.ListingInfo_M.get(ItemsTable.PART_NO, ClassRef.STRING);}
	
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
	private static final HeteroFieldContainer getListingInfo(long listingID)
	{
		HeteroFieldContainer param = new HeteroFieldContainer();
		param.add(ItemsTable.ITEM_ID, listingID);
		return SelectQueryInvoker.execute(
									SelectQueryTypeParams.SELECT_EBAY_ITEM_SPECIFIC, 
									param
									).get(0);
	}
}

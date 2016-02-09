package tomoBay.model.dataTypes.order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
public final class PopulateListingFields
{
	/**
	 * default ctor
	 */
	public PopulateListingFields()
	{super();}
	
	/**
	 * 
	 * @return
	 */
	public static final List<Map<OrderDataFields, String>> getInfo(List<String[]> rawData)
	{
		List<Map<OrderDataFields, String>> listing = new ArrayList<Map<OrderDataFields, String>>();
		
		for(int i = 0 ; i < rawData.size() ; ++i)
		{
			listing.add(new HashMap<OrderDataFields,String>());
			listing.get(i).put(OrderDataFields.LISTING_ID, rawData.get(i)[4]);
			listing.get(i).put(OrderDataFields.LISTING_TITLE, rawData.get(i)[5]);
			listing.get(i).put(OrderDataFields.BRAND, rawData.get(i)[6]);
			listing.get(i).put(OrderDataFields.PART_NUMBER, rawData.get(i)[7]);
		}
		return listing;
	}
}
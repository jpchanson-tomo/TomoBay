package openDMS.presenters.helpers;
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
import java.util.ArrayList;
import java.util.List;

import openDMS.model.services.helpers.InvoiceableStatus;
/**
 *
 * @author Jan P.C. Hanson
 *
 */
public class SortOrders
{
	/**
	 * default ctor
	 */
	public SortOrders()
	{super();}
	
	/**
	 * sort an input list of Strings i.e. the results of an eBay orders query, by shipping type
	 * and then by date.
	 * @param input
	 * @return sorted list of strings.
	 */
	public List<String[]> sortDefault(List<String[]> input)
	{return this.sortByPickeability(input);}
	
	/**
	 * sort the list<String> by Invoice status descending (see InvoiceableStatus enum)
	 * @param input list of strings unordered
	 * @return List<String> sorted by date descending
	 */
	private List<String[]> sortByPickeability(List<String[]> input)
	{
		List<List<String[]>> categoryList = new ArrayList<List<String[]>>(InvoiceableStatus.size());
		
		for(int i = 0 ; i < InvoiceableStatus.size() ; ++i) {categoryList.add(new ArrayList<String[]>());}
		
		for (int i = 0 ; i < input.size() ; ++i)
		{
			categoryList.get(Integer.parseInt((input.get(i)[8])))
						.add(input.get(i));
		}
		return reAssembleCategories(categoryList);
	}
	
	/**
	 * sort the List<String> by shipping type descending (see ShippingPriority enum)
	 * @param input list of strings sorted by date descending.
	 * @return List<String> sorted by ShippingPriority then date
	 */
	private List<String[]> sortByShipping(List<String[]> input)
	{
		List<List<String[]>> categoryList = new ArrayList<List<String[]>>(ShippingPriority.size());
		
		for(int i = 0 ; i < ShippingPriority.size() ; ++i) {categoryList.add(new ArrayList<String[]>());}
		
		for (int i = 0 ; i < input.size() ; ++i)
		{
			categoryList.get( ShippingPriority.valueOf(input.get(i)[3]).getPriority() )
						.add(input.get(i));
		}
		return reAssembleCategories(categoryList);
	}
	
	/**
	 * reassemble the categories into one list
	 * @param input List<List<String[]>> 
	 * @return category sorted list of strings with previous sort order preserved
	 */
	private List<String[]> reAssembleCategories(List<List<String[]>> input)
	{
		List<String[]> result = new ArrayList<String[]>();
		
		for (int i = 0 ; i < ShippingPriority.size() ; ++i)
		{
			result.addAll(input.get(i));
		}
		return result;
	}
}

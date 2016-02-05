package tomoBay.model.services.invoiceOrdersService;
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

import tomoBay.helpers.ShippingPriority;
/**
 * This class contains functionality for performing a category based sorting algorithm first 
 * ordering the data passed in by shipping type and the now sorted data by Pickeability. this 
 * leads to data that is first displayed by pickeability then within each pickability type it 
 * is then sorted by shipping type.
 * 
 * @see {@link tomoBay.helpers.ShippingPriority}
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
	 * @param input the data to sort (should already be sorted by date
	 * @param invoiceableIndex the index of the invoice status within the data
	 * @param shippingIndex the index of the shippingType within the data
	 * @return sorted list of strings.
	 */
	public List<String[]> sortDefault(List<String[]> input, int shippingIndex)
	{
		List<String[]> sortedData = input;
		sortedData = this.sortByShipping(input, shippingIndex);
		return sortedData;
	}
	
	/**
	 * sort the List<String> by shipping type descending (see ShippingPriority enum)
	 * @param input list of strings sorted by date descending.
	 * @return List<String> sorted by ShippingPriority then date
	 */
	private List<String[]> sortByShipping(List<String[]> input, int shippingIndex)
	{
		List<List<String[]>> categoryList = new ArrayList<List<String[]>>(ShippingPriority.size());
		
		for(int i = 0 ; i < ShippingPriority.size() ; ++i) {categoryList.add(new ArrayList<String[]>());}
		
		for (int i = 0 ; i < input.size() ; ++i)
		{
			categoryList.get( ShippingPriority.valueOf(input.get(i)[shippingIndex]).getPriority() )
						.add(input.get(i));
		}
		return reAssembleCategories(categoryList, ShippingPriority.size());
	}
	
	/**
	 * reassemble the categories into one list
	 * @param input List<List<String[]>>  the list of catagories
	 * @param size the size of the shipping priority enum
	 * @return category sorted list of strings with previous sort order preserved
	 */
	private List<String[]> reAssembleCategories(List<List<String[]>> input, int size)
	{
		List<String[]> result = new ArrayList<String[]>();
		
		for (int i = 0 ; i < size ; ++i)
		{
			result.addAll(input.get(i));
		}
		return result;
	}
}

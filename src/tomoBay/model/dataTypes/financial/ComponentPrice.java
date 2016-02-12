package tomoBay.model.dataTypes.financial;

import java.util.InputMismatchException;
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
 * This class provices functionality to provide pricing information on a compound item, 
 * i.e. a parent item that is made of smaller composite items. 
 * @author Jan P.C. Hanson
 *
 */
public final class ComponentPrice
{

	/**
	 * default ctor
	 */
	public ComponentPrice()
	{super();}

	/**
	 * This method returns an array of integers representing the prices of the individual child
	 * items. VAT is not taken into account. the array returned will be the same size as the 
	 * costs array as it assumes that you want the 1st element of the returned array to represent
	 * the individual price of the item represented by the first element of the costs array.
	 * @param childQuantities the quantities of the items (in units)
	 * @param childCosts the cost values of the child items (in pennies)
	 * @param parentPrice the cost of the parent item
	 * @return int[] an integer array representing the prices of the items based on the cost array.
	 */
	public static final int[] prices(int[] childQuantities, int[] childCosts, int parentPrice)
	{
		if(ComponentPrice.isValid(childQuantities, childCosts))
		{
			int totalCost=0;
			for(int i = 0 ; i < childCosts.length ; ++i)
			{totalCost+=(childCosts[i]*childQuantities[i]);}
			
			int[] prices = new int[childCosts.length];
			for(int i = 0 ; i < childCosts.length ; ++i)
			{
				Double tmp = new Double(((childCosts[i]/totalCost)*(parentPrice/childQuantities[i])));
				prices[i] = tmp.intValue();
			}
			
			return prices;
		}
		else
		{throw new InputMismatchException("your input arrays didnt match up");}
	}
	
	/**
	 * This method returns an array of doubles representing the prices of the individual child
	 * items. VAT is not taken into account. the array returned will be the same size as the 
	 * costs array as it assumes that you want the 1st element of the returned array to represent
	 * the individual price of the item represented by the first element of the costs array.
	 * @param childQuantities the quantities of the items (in units)
	 * @param childCosts the cost values of the child items (in pounds)
	 * @param parentPrice the cost of the parent item
	 * @return int[] an integer array representing the prices of the items based on the cost array.
	 */
	public static final double[] prices(int[] childQuantities, double[] childCosts, double parentPrice)
	{
		if(ComponentPrice.isValid(childQuantities, childCosts))
		{
			double totalCost=0;
			for(int i = 0 ; i < childCosts.length ; ++i)
			{totalCost+=(childCosts[i]*childQuantities[i]);}
			
			double[] prices = new double[childCosts.length];
			for(int i = 0 ; i < childCosts.length ; ++i)
			{prices[i] =  (((childCosts[i]/totalCost)*(parentPrice/childQuantities[i])));}
			
			return prices;
		}
		else
		{throw new InputMismatchException("your input arrays didnt match up");}
	}
	
	/**
	 * this method checks to make sure that the input arrays match up as if they do not then 
	 * the calculations will not make sense
	 * @param childQuantities
	 * @param childCosts
	 * @return true if valid, false otherwise
	 */
	private static final boolean isValid(int[] childQuantities, int[] childCosts)
	{return childQuantities.length==childCosts.length ? true : false;}
	
	/**
	 * this method checks to make sure that the input arrays match up as if they do not then 
	 * the calculations will not make sense
	 * @param childQuantities
	 * @param childCosts
	 * @return true if valid, false otherwise
	 */
	private static final boolean isValid(int[] childQuantities, double[] childCosts)
	{return childQuantities.length==childCosts.length ? true : false;}
}

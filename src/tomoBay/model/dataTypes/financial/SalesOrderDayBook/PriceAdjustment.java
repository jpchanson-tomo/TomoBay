package tomoBay.model.dataTypes.financial.SalesOrderDayBook;
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
import tomoBay.model.dataTypes.financial.VAT;
/**
 * This class represents an algorithm for adjusting the prices of an AbstractSalesDayBookLine 
 * so that the calculated total (i.e. the amount that is actually invoiced) is as close as 
 * physically possible to the listing price on ebay. This is necessary as the ebay based order 
 * price is inclusive of VAT however the number that I need to provide the winstock invoiceing 
 * system is inclusive of VAT. This is coupled with the fact that when listing items, the humans
 * responsible do not always figure VAT in when deciding on a price.
 * 
 * This class is final and ALL methods in this class are either protected or 
 * private so that this class cannot be subclassed and the methods in this class cannot be accessed
 * outside of this package....(package scope is silly)
 * @author Jan P.C. Hanson
 *
 */
public final class PriceAdjustment
{
	private static final int PLACEHOLDER = 99999999;
	
	/**
	 * Default ctor
	 */
	protected PriceAdjustment()
	{super();}
	
	/**
	 * calculate the adjustments necessary and apply them to the AbstractSalesDayBookLine provided
	 * as an argument
	 * @param line AbstractSalesDayBookLine to adjust
	 */
	protected void adjust(AbstractSalesDayBookLine line)
	{
		int noOfItems=this.noOfItems(line);
		int smallestQty = this.smallestQty(line);
		int[] testPrices = this.convertListToArray(noOfItems, line);
		int initialDiscrepancy = this.fitness(line, this.calculateTotal(testPrices,line));
		int adjustAmount = this.adjustmentAmt(initialDiscrepancy);
		int fitness = this.fitness(line, initialDiscrepancy);
		
		for(int i = 0 ; i < ((initialDiscrepancy)/smallestQty) ; ++i)
		{
			int bestChoice = PriceAdjustment.PLACEHOLDER;
			for(int j = 0 ; j < noOfItems ; ++j)
			{
				testPrices[j] = testPrices[j] + adjustAmount;
				int tmpFit = this.fitness(line, this.calculateTotal(testPrices,line));
				testPrices[j] = testPrices[j] - adjustAmount;
				if(tmpFit < fitness){bestChoice = j;fitness=tmpFit;}
			}
			if(bestChoice!=PriceAdjustment.PLACEHOLDER) {testPrices[bestChoice] += adjustAmount;}
		}
		this.performAdjustement(line, testPrices);
	}
	
	/**
	 * actually performs the adjustement
	 * @param line AbstractSalesDayBookLine to adjust
	 * @param newPrices the new prices that the AbstractSalesDayBookLine should be adjusted to
	 */
	private void performAdjustement(AbstractSalesDayBookLine line, int[] newPrices)
	{
		for (int i = 0 ; i < newPrices.length ; ++i)
		{
			int difference = newPrices[i] - line.getLineItem(i).price();
			line.getLineItem(i).adjustPrice(line, difference);
		}
	}
	
	/**
	 * convert the internal list of AbstractLineItem withing the AbstractSalesDayBookLine to an 
	 * array. 
	 * @param noOfItems the number of items excluding the postage item
	 * @param line AbstractSalesDayBookLine in question
	 */
	private int[] convertListToArray(int noOfItems, AbstractSalesDayBookLine line)
	{
		int[] result = new int[noOfItems];
		for(int i = 0 ; i < noOfItems ; ++i)
		{result[i] = line.getLineItem(i).price();}
		return result;
	}
	
	/**
	 * calculate the total cost (EX VAT) of the testPrices array. The AbstractSalesDayBookLine
	 * is necessary in case this AbstractSalesDayBookLine contains a POST part
	 * @param testPrices the array of prices to calculate the total (ex vat) from
	 * @param line AbstractSalesDayBookLine in question
	 * @return int representing the total price in pennies (ex VAT)
	 */
	private int calculateTotal(int[] testPrices, AbstractSalesDayBookLine line)
	{
		int calculatedTotal = 0;
		for(int i = 0 ; i < line.size() ; ++i)
		{
			if(line.getLineItem(i).partNo(line).contains("POST")==false)
			{calculatedTotal += testPrices[i]*line.getLineItem(i).quantity(line);}
			else {calculatedTotal+= line.getLineItem(i).price();}
		}
		return calculatedTotal;
	}
	
	/**
	 * returns the number of AbstractLineItems (minus postage line items) contained within this
	 * AbstractSalesDayBookLine.
	 * @param line AbstractSalesDayBookLine to analyse
	 * @return int representing the number of line items (minus postage lineItems)
	 */
	private int noOfItems(AbstractSalesDayBookLine line)
	{
		if(line.getLineItem(line.size()-1).partNo(line).contains("POST"))
		{return line.size()-1;}
		else
		{return line.size();}
		
	}
	
	/**
	 * this method represents a fitness function to be used when calculating the adjustments to
	 * the AbstractSalesDayBookLine. it is based around the difference between the actual total
	 * (as taken from eBay), and the calculated total, as worked out by the AbstractSalesDayBookLine
	 * object and this price adjustment class.
	 * @param line the AbstractSalesDayBookLine that this method applies to.
	 * @param calculatedTotal the total as calculated by the AbstractSalesDayBookLine object
	 * and this price Adjustment class
	 * @return int the number of pennies difference between the actualTotal and the calculatedTotal
	 */
	private int fitness(AbstractSalesDayBookLine line, int calculatedTotal)
	{return Math.abs(line.totalIncVat()-VAT.add(calculatedTotal));}
	
	/**
	 * The smallest quantity of the parts on this AbstractSalesDayBookLine. i.e. the smallest
	 * adjustement that can be made by the system e.g. a quantity of 1 would mean the smallest 
	 * adjustment possible to make is 1 penny. for a quantity of 11 the smallest possible adjustment
	 * is 11 pennies.
	 * @param line the AbstractSalesDayBookLine to analyse for the smallest part qwuantity.
	 * @return int representing the smallest quantity found in this AbstractSalesDayBookLine
	 */
	private int smallestQty(AbstractSalesDayBookLine line)
	{
		int result=PriceAdjustment.PLACEHOLDER;
		for(AbstractLineItem lineItem : line)
		{if(lineItem.quantity(line) < result) {result=lineItem.quantity(line);}}
		return result;
	}
	
	/**
	 * the incremental amount to adjust the price by. this will always be either +1 or -1 depending 
	 * on whether the initial discrepancy is positive or negative. This is so that it will adjust in the right
	 * direction.
	 * @param discrepancy the intitial difference between actual and calculated price
	 * @return int either +1 or -1
	 */
	private int adjustmentAmt(int discrepancy)
	{if(discrepancy > 0) {return 1;} else {return -1;}}
}

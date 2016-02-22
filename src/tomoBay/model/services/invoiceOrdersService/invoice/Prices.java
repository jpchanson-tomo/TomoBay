package tomoBay.model.services.invoiceOrdersService.invoice;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Arrays;

import org.apache.log4j.Logger;

import tomoBay.model.services.helpers.PartList;
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
import tomoBay.model.winstock.Stock;

/**
 *
 * @author Jan P.C. Hanson
 *
 */
public final class Prices
{
	static private Logger log = Logger.getLogger(Prices.class.getName());
	
	/**array of prices**/
	private int[] prices_M;
	/****/
	private int orderQty_M;
	/****/
	private Stock winstock_M;
	/****/
	private double[] costs_M;
	/****/
	private double totalCost_M;
	/****/
//	private double shippingCost=0.00;
	
	/**
	 * constructor, uses a populated parts list an itemPrice and a brandCode
	 * @param parts a populated PartsList
	 * @param itemPrice the total price for the listing inc VAT
	 * @param brandCode C = peugeot/citroen, F=Ford, P=prestige
	 */
	public Prices
	(PartList parts, String itemPrice, String brandCode, String orderQty, double postage)
	{
		super();
//		this.shippingCost = postage;
		this.orderQty_M = Integer.parseInt(orderQty);
		this.winstock_M = new Stock();
		this.prices_M = new int[parts.size()];
		this.generateCosts(parts, brandCode, itemPrice);
	}
	
	/**
	 * return the array of prices
	 * @return int[] containing the prices in the same order as the items in the PartList
	 */
	public int[] getPrices()
	{return this.prices_M;}
	
	/**
	 * 
	 * @param price
	 * @return
	 */
	public static int convertPriceToPennies(double price)
	{
//		log.warn(price);
		String priceChecked = Prices.convertToString(price);
		double numericalPrice = Double.parseDouble(priceChecked);
		int result = 0;
		
		result = new Double(numericalPrice*100).intValue();
//		System.out.println(result);
		return result;
	}
	
	/**
	 * 
	 * @param parts
	 * @param brandCode
	 * @param itemPrice
	 */
	private void generateCosts(PartList parts, String brandCode, String itemPrice)
	{
		double listingPrice = Double.parseDouble(itemPrice);
//		double orderPrice = this.priceIncVat(listingPrice) + (this.shippingCost);
		this.populateCostsArray(parts, brandCode);
		
//		log.warn(orderPrice+" = " + this.priceExVat(orderPrice)+"+"+this.vat(orderPrice));
		log.warn("ListingTotal: " + listingPrice + " orderQty: " + this.orderQty_M);
		
		this.generatePrices(this.costs_M, this.totalCost_M, listingPrice, parts);
	}
	
	/**
	 * 
	 * @param costsArray
	 * @param totalCost
	 * @param itemPrice
	 */
	private void generatePrices
	(double[] costsArray, double totalCost, double itemPrice, PartList parts)
	{
//		int totalCostworkedOut = 0;
//		
		for (int i = 0 ; i < this.costs_M.length ; ++i)
		{
			double individualPrice =  (((this.costs_M[i]/this.totalCost_M)*(this.priceExVat(itemPrice))/parts.getPartQty(i)));
			this.prices_M[i] = Prices.convertPriceToPennies(individualPrice);
			
			log.warn("part#: " + parts.getPartNumber(i) + " partQty: " + parts.getPartQty(i) + " part price: " + individualPrice);
//			totalCostworkedOut += this.prices_M[i]*parts.getPartQty(i);
		}
		
//		int remainder = Prices.convertPriceToPennies(this.priceExVat(itemPrice)) - totalCostworkedOut;
//		log.warn("remainder: "+remainder);
		this.prices_M[0] += this.remainder(itemPrice, parts);
		log.warn(Arrays.toString(this.prices_M));
	}
	
	/**
	 * 
	 * @param amount
	 * @return
	 */
	private static String convertToString(double amount)
	{
		DecimalFormat toDecimal = new DecimalFormat("##.##");
		toDecimal.setRoundingMode(RoundingMode.DOWN);
		return toDecimal.format(amount);
	}
	
//	private double priceIncVat(double itemPriceIncVat)
//	{return itemPriceIncVat * this.orderQty_M;}
	
	private double priceExVat(double itemPriceIncVat)
	{return itemPriceIncVat -this.vat(itemPriceIncVat);}
	
	private double vat(double itemPriceIncVat)
	{return itemPriceIncVat/6;}
	
	private void populateCostsArray(PartList parts, String brandCode)
	{
		this.costs_M = new double[parts.size()];
		for (int i = 0 ; i < this.costs_M.length ; ++i)
		{
			this.costs_M[i] = this.itemCost(parts.getPartNumber(i).toUpperCase(), brandCode);
			this.totalCost_M += this.costs_M[i];
		}
	}
	
	private double itemCost(String partNo, String brandCode)
	{return this.winstock_M.requestLastCost(partNo.toUpperCase(), brandCode);}
	
	
	private int totalPrice(PartList parts, int[] prices)
	{
		int result=0;
		for (int i = 0 ; i < parts.size() ; ++i)
		{result += prices[i] * parts.getPartQty(i);}
		return result;
	}
	
	private int remainder(double itemPrice, PartList parts)
	{
		int total = Prices.convertPriceToPennies(this.priceExVat(itemPrice));
		int currentTotal=this.totalPrice(parts, this.prices_M);
		int remainder = total - currentTotal;
		log.warn("Total="+ total + " currentTotal="+currentTotal+ " remainder="+remainder);
		
		int result=0;
		double before = this.totalPrice(parts, this.prices_M);
		
		for(int n = 0 ; n < remainder ; ++n)
		{
			
			int addition = ((n+1)*parts.getPartQty(0));
			double after = this.totalPrice(parts, this.prices_M) + addition;
			
			if (Math.abs(total-before)<Math.abs(total -after)){}
			else {before = after; result = n+1;}
		}
		return result;
	}
}

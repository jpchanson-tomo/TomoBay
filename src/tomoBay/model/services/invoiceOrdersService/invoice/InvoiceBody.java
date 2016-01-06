package tomoBay.model.services.invoiceOrdersService.invoice;
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
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.List;

import tomoBay.helpers.BrandToCode;
import tomoBay.helpers.DualList;
import tomoBay.model.services.helpers.PartList;
import tomoBay.model.winstock.Stock;
import tomoBay.model.winstock.payloads.PayloadType;
/**
 *
 * @author Jan P.C. Hanson
 *
 */
public class InvoiceBody
{
	/****/
	private List<String[]> dataFields_M;
	/****/
	private Stock winstock_M;
	/****/
	private int[] prices_M;
	/**
	 * default ctor
	 */
	public InvoiceBody(List<String[]> rawData)
	{
		super();
		this.dataFields_M = rawData;
		this.winstock_M = new Stock();
	}
	
	public DualList<String, PayloadType> generate()
	{
		DualList<String, PayloadType> body = new DualList<String, PayloadType>();
		
		body.put(String.valueOf(this.getNoInvLines()), PayloadType.INV_LINES);
		
		for(String[] data : this.dataFields_M)
		{
			PartList parts = new PartList(data[7]);
			this.populatePrices(parts, data[9], BrandToCode.convert(data[6]));
			
			for(int i = 0 ; i < parts.size() ; ++i)
			{
				body.put(this.getPartNo(i, parts), PayloadType.PART_NO);
				body.put(this.getDescription(i, parts, data[6]), PayloadType.DESCRIPTION);
				body.put(this.getQuantity(i, parts), PayloadType.QUANTITY);
				body.put(this.getPrice(i, data[9], parts), PayloadType.PRICE);
				body.put("1", PayloadType.INSTOCK);
			}
		}
		
		
		return body;
	}
	
	/**
	 * return the number of lines on the invoice
	 * @return int number of lines
	 */
	private int getNoInvLines()
	{
		int noOfParts=0;
		for(String[] data : this.dataFields_M) {noOfParts += data[7].split("\\(\\d*\\s*\\)").length;}
		return noOfParts;
	}
	
	/**
	 * 
	 * @param index
	 * @return
	 */
	private String getPartNo(int index, PartList parts)
	{return parts.getPartNumber(index).toUpperCase();}
	
	/**
	 * 
	 * @param index
	 * @return
	 */
	private String getDescription(int index, PartList parts, String brand)
	{
		String result = winstock_M
					.requestDescription(parts.getPartNumber(index), BrandToCode.convert(brand));
//		int endOfString = result.indexOf("�");
		int endOfString = result.indexOf("œ");
		result = result.substring(0, endOfString);
		return result;
	}
	
	/**
	 * 
	 * @param index
	 * @return
	 */
	private String getQuantity(int index, PartList parts)
	{return String.valueOf(parts.getPartQty(index));}
	
	/**
	 * 
	 * @param index
	 * @return
	 */
	private String getPrice(int index, String itemPrice, PartList parts)
	{
		int price = this.convertPriceToPennies(itemPrice)/this.getNoInvLines();
		
		
		return String.valueOf( (price*10)/12 );
	}
	
	/**
	 * 
	 * @param price
	 * @return
	 */
	private int convertPriceToPennies(String price)
	{
		int result;
		if(price.contains("."))
		{
			int preDecimal = Integer.parseInt(price.split("\\.")[1]);
			int postDecimal = (Integer.parseInt(price.split("\\.")[0])*100);
		
			if(preDecimal < 10) {preDecimal = preDecimal * 10;}
		
			result = (postDecimal+preDecimal);
		}
		else
		{
			result = (Integer.parseInt(price)*100);
		}
		return result;
	}
	////////////////////////////////////////////////////////////////////////////////PRICE OBJECT
	private void populatePrices(PartList parts, String itemPrice, String brandCode)
	{
		this.prices_M = new int[parts.size()];
		this.generateCosts(parts, brandCode, itemPrice);
	}
	
	private void generateCosts(PartList parts, String brandCode, String itemPrice)
	{
		double[] costs = new double[parts.size()]; 
		double totalCost= 0;
		double totalPrice = Double.parseDouble(itemPrice);
		for (int i = 0 ; i < costs.length ; ++i)
		{
			 costs[i] = this.winstock_M.requestLastCost(parts.getPartNumber(i).toUpperCase(), brandCode);
			 totalCost += costs[i];
		}
		
		this.generatePrices(costs, totalCost, totalPrice);
	}
	
	private void generatePrices(double[] costsArray, double totalCost, double itemPrice)
	{
		int totalCostworkedOut = 0;
		double priceMinusVAT = (itemPrice-(itemPrice/6));
		DecimalFormat toDecimal = new DecimalFormat("#.##");
		toDecimal.setRoundingMode(RoundingMode.DOWN);
		int remainder = 0;
		for (int i = 0 ; i < costsArray.length ; ++i)
		{
			double individualPrice =  (costsArray[i]/totalCost)*priceMinusVAT;
			this.prices_M[i] = this.convertPriceToPennies(toDecimal.format(individualPrice));
			totalCostworkedOut += this.prices_M[i];
			System.out.println("individualPrice = "+individualPrice);
		}
		remainder = this.convertPriceToPennies(toDecimal.format(priceMinusVAT)) - totalCostworkedOut;
		this.prices_M[0] += remainder;
		
//		System.out.println("calculated total = "+toDecimal.format(totalCostworkedOut));
//		System.out.println("actual total = " + toDecimal.format(priceMinusVAT));
//		System.out.println(this.prices_M[0] + " " + this.prices_M[1]);
	}
}

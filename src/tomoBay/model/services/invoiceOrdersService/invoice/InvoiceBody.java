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
import java.util.List;

import tomoBay.helpers.BrandToCode;
import tomoBay.model.dataTypes.DualList;
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
	
	private double extraPostage=0.00;
	
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
			this.prices_M = new Prices(parts,data[9],BrandToCode.convert(data[6]), data[8], this.extraPostage).getPrices();
			
			
			for(int i = 0 ; i < parts.size() ; ++i)
			{
				body.put(this.getPartNo(i, parts), PayloadType.PART_NO);
				body.put(this.getDescription(i, parts, data[6]), PayloadType.DESCRIPTION);
				body.put(this.getQuantity(i, parts, data[8]), PayloadType.QUANTITY);
				body.put(this.getPrice(i, data[9], parts), PayloadType.PRICE);
				body.put("1", PayloadType.INSTOCK);
			}
		}
		this.addPostage(body);
		
		return body;
	}
	
	/**
	 * return the number of lines on the invoice
	 * @return int number of lines
	 */
	private int getNoInvLines()
	{
		int noOfParts=0;
		for(String[] data : this.dataFields_M) 
		{
			noOfParts += data[7].split("\\(\\d*\\s*\\)").length;
			if (Double.parseDouble(data[18]) != 0.00){extraPostage=Double.parseDouble(data[18]);}
		}
		
		if(this.extraPostage != 0.00 && (this.dataFields_M.get(0)[14].toUpperCase()).contains("GSP")==false) 
		{return noOfParts+1;}
		else{return noOfParts;}
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
		int endOfString = result.indexOf("�");
//		int endOfString = result.indexOf("œ");
		result = result.substring(0, endOfString);
		return result;
	}
	
	/**
	 * 
	 * @param index
	 * @return
	 */
	private String getQuantity(int index, PartList parts, String orderQty)
	{
		int oQty = Integer.parseInt(orderQty);
		return String.valueOf(parts.getPartQty(index) * oQty);
	}
	
	/**
	 * 
	 * @param index
	 * @return
	 */
	private String getPrice(int index, String itemPrice, PartList parts)
	{return String.valueOf(this.prices_M[index]);}
	
	/**
	 * 
	 * @param invoiceBody
	 */
	private void addPostage(DualList<String, PayloadType> invoiceBody)
	{
		if (this.extraPostage != 0.00 && (this.dataFields_M.get(0)[14].toUpperCase()).contains("GSP")==false) 
		{
			invoiceBody.put("POST", PayloadType.PART_NO);
			invoiceBody.put("Postage and Packaging", PayloadType.DESCRIPTION);
			invoiceBody.put("1", PayloadType.QUANTITY);
			invoiceBody.put(String.valueOf(Prices.convertPriceToPennies(this.extraPostage/1.2)), PayloadType.PRICE);
			invoiceBody.put("1", PayloadType.INSTOCK);
		}
	}
}

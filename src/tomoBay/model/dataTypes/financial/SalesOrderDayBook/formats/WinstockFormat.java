package tomoBay.model.dataTypes.financial.SalesOrderDayBook.formats;

import tomoBay.helpers.BrandToCode;
import tomoBay.model.dataTypes.DualList;
import tomoBay.model.dataTypes.financial.SalesOrderDayBook.AbstractLineItem;
import tomoBay.model.dataTypes.financial.SalesOrderDayBook.AbstractSalesDayBookLine;
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
import tomoBay.model.winstock.payloads.PayloadType;

/**
 * 
 *
 * @author Jan P.C. Hanson
 *
 */
public final class WinstockFormat extends AbstractFormat
{

	/**
	 * 
	 */
	public WinstockFormat()
	{super();}

	/* (non-Javadoc)
	 * @see tomoBay.model.dataTypes.financial.SalesOrderDayBook.formats.AbstractFormat#format(tomoBay.model.dataTypes.financial.SalesOrderDayBook.AbstractSalesDayBookLine)
	 */
	@Override
	public DualList<String,PayloadType> format(AbstractSalesDayBookLine line)
	{
		DualList<String,PayloadType> result = new DualList<String,PayloadType>();
		result.put("34", PayloadType.TYPE);
		result.put(BrandToCode.convertToInt(line.orderInfo().transaction(0).listing().part(0).brand())+"", PayloadType.COMPANY);
		result.put("EBAY", PayloadType.INVOICE_ACCOUNT);
		result.put(this.shorten(line.orderInfo().buyer().name()), PayloadType.NAME);
		result.put(this.shorten(line.orderInfo().buyer().street1()),PayloadType.ADDRESS1);
		result.put(this.shorten(line.orderInfo().buyer().street2()),PayloadType.ADDRESS2);
		result.put(this.shorten(line.orderInfo().buyer().city()),PayloadType.CITY);
		result.put(this.shorten(line.orderInfo().buyer().county()),PayloadType.COUNTY);
		result.put(this.shorten(line.orderInfo().buyer().postcode().toUpperCase()),PayloadType.POSTCODE);
		result.put(this.shorten(String.valueOf(line.orderInfo().salesRecNo())),PayloadType.ORDER_NO);
		result.put(this.shorten(String.valueOf(line.size())), PayloadType.INV_LINES);
		
		for (AbstractLineItem item : line)
		{
			result.put(item.partNo(line).toUpperCase(), PayloadType.PART_NO);
			result.put(item.description(line), PayloadType.DESCRIPTION);
			result.put(String.valueOf(item.quantity(line)), PayloadType.QUANTITY);
			result.put(String.valueOf(item.price()), PayloadType.PRICE);
			result.put("1", PayloadType.INSTOCK);
		}
		
		return result;
	}
	
	private String shorten(String input)
	{
		if(input==null) {return "";}
		if(input.length()>=51) {return input.substring(0, 50);} else {return input;}
	}
}

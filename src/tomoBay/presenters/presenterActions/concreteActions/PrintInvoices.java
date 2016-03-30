package tomoBay.presenters.presenterActions.concreteActions;
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

import org.apache.log4j.Logger;

import tomoBay.helpers.BrandToCode;
import tomoBay.helpers.StackTraceToString;
import tomoBay.model.dataTypes.DualList;
import tomoBay.model.dataTypes.financial.SalesOrderDayBook.AbstractSalesDayBookLine;
import tomoBay.model.dataTypes.financial.SalesOrderDayBook.SalesDayBookLineFactory;
import tomoBay.model.dataTypes.financial.SalesOrderDayBook.SalesDayBookLineFactory.SalesDayBookLineType;
import tomoBay.model.dataTypes.order.Order;
import tomoBay.model.winstock.WinstockCommandInvoker;
import tomoBay.model.winstock.payloads.PayloadType;
import tomoBay.model.winstock.response.AbstractWinstockCommandResponse;
import tomoBay.model.winstock.response.ResultCodes;
import tomoBay.presenters.presenterActions.AbstractPresenterAction;
/**
 *
 * @author Jan P.C. Hanson
 *
 */
public final class PrintInvoices implements AbstractPresenterAction
{
	static final Logger log = Logger.getLogger(PrintInvoices.class.getName());
	/**
	 * default ctor
	 */
	public PrintInvoices()
	{super();}

	/* (non-Javadoc)
	 * @see tomoBay.presenters.presenterActions.AbstractPresenterAction#execute(java.lang.String)
	 */
	@Override
	public String execute(String data)
	{
		String[] orderNos = this.splitOrderNoString(data);			String result="";
		for(String orderNo : orderNos)
		{
			try
			{
				AbstractSalesDayBookLine line = SalesDayBookLineFactory.make(SalesDayBookLineType.INVOICE, new Order(orderNo));
				if(line.invoiceNumber()!=0 && line.invoiceNumber()!=1)
				{
					DualList<String, PayloadType> printThis 
								= this.formatAsDualList(
														String.valueOf(line.invoiceNumber()), 
														this.brandToCode(line.orderInfo().transaction(0).listing().part(0).brand()), 
														"1"
														);
					
					result += this.print(printThis, line);
				}
				else {result+= "("+orderNo + "not invoiced yet), ";}
			}
			catch(RuntimeException e) {result+="could not print ("+orderNo+" probably ancient order),";}
		}
		log.warn(result+"-----PRINTED");
		return result;
	}

	/**
	 * splits the 'data' string into a string array
	 * @param orderNos the 'data' string
	 * @return String[] containing all the orderNos in the original 'data' string
	 */
	private String[] splitOrderNoString(String orderNos)
	{return orderNos.split(",");}
	
	/**
	 * formats the AbstractSalesDayBookLine into a format that can be passed to the WinstockCommandInvoker.
	 * @param invoice the invoice to be formatted
	 * @return DualList<String, PayloadType> accepted by the WinstockCommandInvoker
	 */
	private DualList<String, PayloadType> formatAsDualList(String invoiceNo, String brand, String packingList)
	{
		DualList<String,PayloadType> result = new DualList<String,PayloadType>();
		result.put("35", PayloadType.TYPE);
		result.put(brand, PayloadType.COMPANY);
		result.put(invoiceNo, PayloadType.INVOICE_NO);
		result.put("1", PayloadType.PRINT_COPIES);
		result.put(packingList, PayloadType.PACKING_LISTS);
		return result;
	}
	
	/**
	 * convert a brandCode to a number winstock will accept in its company field
	 * @param brand the brand string from the invoice
	 * @return String containing one of the three value "0" for ford, "3" for citroen, "8" for
	 * prestige.
	 */
	private String brandToCode(String brand)
	{
		String brandCode = BrandToCode.convert(brand);
		if(brandCode.equals("F")){return "0";}
		else if(brandCode.equals("C")){return "3";}
		else{return "8";}
	}
	
	/**
	 * actually send the data to the winstock server to print the invoice
	 * @param printThis the data to print 
	 * @param line the AbstractSalesDayBookLine containing the line info
	 * @return String containing an appropriate response.
	 */
	private String print(DualList<String,PayloadType> printThis, AbstractSalesDayBookLine line)
	{
		String result="";
		try
		{
			AbstractWinstockCommandResponse response = 
					WinstockCommandInvoker.execute(WinstockCommandInvoker.WinstockCommandTypes.PrintInvoice, printThis);
			if(response.isSuccess()==ResultCodes.SUCCESS)
			{result+=line.invoiceNumber()+",";}
			else {result+="(did not print "+line.invoiceNumber()+")";}
		} 
		catch (Exception e)
		{
			log.error("problem printing invoice: "+StackTraceToString.toString(e));
			e.printStackTrace();
			result+="COULD NOT PRINT ("+line.invoiceNumber()+"),";
		}
		return result;
	}
 }

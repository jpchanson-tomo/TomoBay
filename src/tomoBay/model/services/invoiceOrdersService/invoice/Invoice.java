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
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.List;

import tomoBay.exceptions.PayloadException;
import tomoBay.exceptions.ServiceException;
import tomoBay.helpers.BrandToCode;
import tomoBay.helpers.DualList;
import tomoBay.model.sql.queries.QueryInvoker;
import tomoBay.model.sql.queries.QueryInvoker.QueryType;
import tomoBay.model.winstock.WinstockCommandInvoker;
import tomoBay.model.winstock.payloads.PayloadType;
import tomoBay.model.winstock.response.AbstractWinstockCommandResponse;
/**
 *
 * @author Jan P.C. Hanson
 *
 */
public class Invoice
{
	/**internal var holding all items in a particular order to be invoiced**/
	private int invNo_M;
	private List<String[]> dataFields_M;
	private DualList<String, PayloadType> invoiceData_M;
	private DualList<String, PayloadType> printData_M;
	
	/**
	 * default ctor
	 */
	public Invoice(String orderNo)
	{
		super();
		System.out.println(orderNo);
		this.retrieveOrderInfo(orderNo);
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean print()
	{
		this.printData_M = new DualList<String, PayloadType>();
		this.printData_M.put("35", PayloadType.TYPE);
		this.printData_M.put(this.brandToCode(this.dataFields_M.get(0)[6]), PayloadType.COMPANY);
		this.printData_M.put(String.valueOf(this.invNo_M), PayloadType.INVOICE_NO);
		this.printData_M.put("0", PayloadType.PRINT_COPIES);
		this.printData_M.put("0", PayloadType.PACKING_LISTS);
		
		AbstractWinstockCommandResponse response;
		try
		{
			response = 
					WinstockCommandInvoker.execute(WinstockCommandInvoker.WinstockCommandTypes.PrintInvoice, this.printData_M);
			System.out.println("print: "+response.isSuccess());
		} 
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	
	/**
	 * 
	 * @return
	 */
	public int generate()
	{
		InvoiceHeader header = new InvoiceHeader(this.dataFields_M);
		InvoiceBody body = new InvoiceBody(this.dataFields_M);
		
//		System.out.println(header.generate().toString());
		this.invoiceData_M = header.generate().append(body.generate());
		System.out.println(this.invoiceData_M.toString());
		
		this.invNo_M = Integer.parseInt(this.sendInvoice(this.invoiceData_M).getRecieved());
		return this.invNo_M;
	}
	
	
	
	/**
	 * fill the local list with all the items associated with the orderNo provided
	 * @param orderNo the orderNo for the order to invoice.
	 */
	private void retrieveOrderInfo(String orderNo)
	{this.dataFields_M = QueryInvoker.execute(QueryType.SELECT_FULL_ORDER_LINE, new String[] {orderNo});}
	
	private AbstractWinstockCommandResponse sendInvoice(DualList<String, PayloadType> invoice)
	{
		try
		{
			AbstractWinstockCommandResponse res = WinstockCommandInvoker.execute(WinstockCommandInvoker.WinstockCommandTypes.PutInvoice, this.invoiceData_M);
			System.out.println(res.isSuccess());
			return res;
		} catch (Exception e)
		{
			e.printStackTrace();
			throw new ServiceException("could not send invoice", e);
		} 
	}
	
	private String brandToCode(String brand)
	{
		String brandCode = BrandToCode.convert(brand);
		if(brandCode.equals("F"))
		{return "0";}
		else if(brandCode.equals("C"))
		{return "3";}
		else
		{return "8";}
		
	}
}

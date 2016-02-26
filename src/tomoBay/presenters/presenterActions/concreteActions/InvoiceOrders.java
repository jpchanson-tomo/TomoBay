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
import java.io.IOException;
import java.net.UnknownHostException;

import org.apache.log4j.Logger;

import tomoBay.exceptions.PayloadException;
import tomoBay.helpers.TimeStampCompare;
import tomoBay.model.dataTypes.DualList;
import tomoBay.model.dataTypes.financial.SalesOrderDayBook.AbstractSalesDayBookLine;
import tomoBay.model.dataTypes.financial.SalesOrderDayBook.SalesDayBookLineFactory;
import tomoBay.model.dataTypes.financial.SalesOrderDayBook.SalesDayBookLineFactory.SalesDayBookLineType;
import tomoBay.model.dataTypes.financial.SalesOrderDayBook.concreteLineTypes.StandardInvoice;
import tomoBay.model.dataTypes.financial.SalesOrderDayBook.formats.WinstockFormat;
import tomoBay.model.dataTypes.order.Order;
import tomoBay.model.net.email.GmailBuilder;
import tomoBay.model.net.email.MailClient;
import tomoBay.model.sql.queries.QueryInvoker;
import tomoBay.model.sql.queries.QueryInvoker.QueryType;
import tomoBay.model.winstock.WinstockCommandInvoker;
import tomoBay.model.winstock.payloads.PayloadType;
import tomoBay.model.winstock.response.AbstractWinstockCommandResponse;
import tomoBay.presenters.presenterActions.AbstractPresenterAction;
/**
 * This AbstractPresenterAction provides functionality to invoice a number of orders based on the 
 * order numbers provided as the data string to the execute method. This string should be a comma
 * separated string of valid order numbers i.e. real order numbers that are less than 90 days old.
 * @author Jan P.C. Hanson
 *
 */
public final class InvoiceOrders implements AbstractPresenterAction
{
	static final Logger log = Logger.getLogger(InvoiceOrders.class.getName());
	private static final String EMAILHEADER="<table border='1' style='width:100%'><thead><th>salesRecordNo</th>"
				+ "</th><th>created time</th><th>weight</th><th>Invoice Number</th></thead><tbody>";
	private static final String EMAILFOOTER="</tbody></table>";
	
	
	/**
	 * default ctor
	 */
	public InvoiceOrders()
	{super();}

	/* (non-Javadoc)
	 * @see tomoBay.presenters.presenterActions.AbstractPresenterAction#execute(java.lang.String)
	 */
	@Override
	public String execute(String data)
	{

		String[] orderIDs = this.splitOrderNoString(data);
		String result="";
		for(String orderId : orderIDs)
		{
			try
			{
				AbstractSalesDayBookLine invoice = SalesDayBookLineFactory.make(SalesDayBookLineType.INVOICE, new Order(orderId));
				if(invoice.invoiceNumber()==0 && TimeStampCompare.olderThan(30, invoice.orderInfo().createdTime())==false)
				{
					DualList<String, PayloadType> winstockInv = this.formatAsDualList(invoice);
					AbstractWinstockCommandResponse res;
					res = WinstockCommandInvoker.execute(WinstockCommandInvoker.WinstockCommandTypes.PutInvoice, winstockInv);
//					log.warn("raise Invoice: "+Integer.parseInt(res.getRecieved()[0])+" is "+res.isSuccess());
//					result+=res.getRecieved()[0]+",";
					result+=this.formatMailResult(res.getRecieved()[0], res.getRecieved()[1], invoice);
					this.updateDB(res.getRecieved()[0], orderId);
				}
				else {result+="("+invoice.orderInfo().salesRecNo()+" already Invoiced or too old"+")";}
			}
			catch (UnknownHostException e){e.printStackTrace(); result+= "(Error with "+orderId+"),";} 
			catch (IOException e){e.printStackTrace(); result+= "(Error with "+orderId+"),";}
			catch (PayloadException e){e.printStackTrace(); result+= "(Error with "+orderId+"),";}
//			catch (NotAValidResultCodeException e){e.printStackTrace(); result+= "(Error with "+orderId+"),";}
			catch (RuntimeException e) {result+= "(Error with "+orderId+"),";}
		}
		log.warn(result+"-----INVOICED");
		this.emailResults(result);
		return InvoiceOrders.EMAILHEADER + result + InvoiceOrders.EMAILFOOTER;
	}
	
	/**
	 * splits the 'data' string into a string array
	 * @param orderNos the 'data' string
	 * @return String[] containing all the orderNos in the original 'data' string
	 */
	private String[] splitOrderNoString(String orderNos)
	{return orderNos.split(",");}
	
	/**
	 * update the database entry for a particular order to include the invoice number in the 
	 * invoiced column of the orders table.
	 * @param invNo
	 * @param OrderNo
	 */
	private void updateDB(String invNo, String orderNo)
	{QueryInvoker.execute(QueryType.UPDATE_INVOICE_STATUS, new String[] {invNo,orderNo});}
	
	/**
	 * formats the AbstractSalesDayBookLine into a format that can be passed to the WinstockCommandInvoker.
	 * @param invoice the invoice to be formatted
	 * @return DualList<String, PayloadType> accepted by the WinstockCommandInvoker
	 */
	private DualList<String, PayloadType> formatAsDualList(AbstractSalesDayBookLine invoice)
	{return invoice.format(new WinstockFormat());}
	
	private String formatMailResult(String invNo, String weight, AbstractSalesDayBookLine invoice)
	{
		return "<tr>"
				+ "<td>"+invoice.orderInfo().salesRecNo()+"</td>"
				+ "<td>"+invoice.orderInfo().createdTime()+"</td>"
				+ "<td>"+weight+"</td>"
				+ "<td>"+invNo+"</td>"
			+ "</tr>";
	}
	
	private void emailResults(String result)
	{
		MailClient.send(InvoiceOrders.EMAILHEADER + result + InvoiceOrders.EMAILFOOTER, 
				"INVOICED ORDERS",
				new String[] {"tomomotorbay@gmail.com","steve@tomoparts.co.uk","paul@tomoparts.co.uk"}, 
				new String[] {}, 
				new String[] {}, 
				new GmailBuilder());
	}
}

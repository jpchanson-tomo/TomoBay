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
import java.util.Map;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.internet.AddressException;

import tomoBay.exceptions.NullEmailObjectException;
import tomoBay.exceptions.NullEmailServerObjectException;
import tomoBay.helpers.checkTime.CheckTime;
import tomoBay.model.net.email.Email;
import tomoBay.model.net.email.EmailDirector;
import tomoBay.model.net.email.GmailBuilder;
import tomoBay.model.net.email.MailServerSend;
import tomoBay.model.services.AbstractConfiguration;
import tomoBay.model.services.AbstractService;
import tomoBay.model.services.ServiceFactory;
import tomoBay.model.services.ServiceFactory.ServiceType;
import tomoBay.model.services.TriggerService;
import tomoBay.model.services.emailErrorsService.EmailErrorsConfig;
import tomoBay.model.services.helpers.PickeableStatus;
import tomoBay.model.services.invoiceOrdersService.invoice.Invoice;
import tomoBay.model.sql.DataBaseSchema;
/**
 * This service runs through all the orders on the system that havent yet been invoiced and 
 * checks them against stock levels to see how invoiceable they are (invoiceable/partially
 * invoiceable/not invoiceable) and raises invoices for the ones which are invoiceable. It also
 * records the current invoiceability status for all orders not currently invoiced on the database.
 * @author Jan P.C. Hanson
 *
 */
public class InvoiceService implements AbstractService
{

	/* (non-Javadoc)
	 * @see openDMS.model.services.AbstractService#run()
	 */
	@Override
	public String call()
	{
		System.out.println("invoicing started");
		if(CheckTime.isInRange())
		{
		ValidUninvoicedOrderList orderList = new ValidUninvoicedOrderList();
		CalculateInvoiceStatus orderStatus = new CalculateInvoiceStatus();
		DB db = new DB();
		List<String[]> invoicedOrders = new ArrayList<String[]>();
		orderList.sortList();
		List<Map<DataBaseSchema,String>> orders = orderList.get();
		
		for(Map<DataBaseSchema,String> order : orders)
		{
//			System.out.println(order.get(DataBaseSchema.ORD_ORDER_ID));
//			System.out.println("0");
			if(orderStatus.status(order.get(DataBaseSchema.ORD_ORDER_ID))==PickeableStatus.PICKEABLE)
			{
				Invoice invoice = new Invoice(order.get(DataBaseSchema.ORD_ORDER_ID));
				int invNo = invoice.generate();
				System.out.println(invNo);
				invoice.print();
				invoicedOrders.add(new String[] {order.get(DataBaseSchema.ORD_ORDER_ID), 
						order.get(DataBaseSchema.ORD_SALES_REC_NO), order.get(DataBaseSchema.ORD_CREATED_TIME),
						String.valueOf(invoice.getWeight()), String.valueOf(invNo)});
				db.updateInvStatus(order.get(DataBaseSchema.ORD_ORDER_ID));
			}
		}
		
		if(invoicedOrders.size() > 0)
		{
		String message="<table border='1' style='width:100%'><thead><th>orderID</th><th>salesRecordNo</th>"
				+ "</th><th>created time</th><th>weight</th><th>Invoice Number</th></thead><tbody>";
		for (String[] maildata : invoicedOrders)
		{
			message += "<tr><td>"+maildata[0]+"</td>";
			message += "<td>"+maildata[1]+"</td>"
					+ "<td>"+maildata[2]+"</td>"
					+ "<td>"+maildata[3]+"</td>"
					+ "<td>"+maildata[4]+"</td></tr>";
		}
		message+="</tbody></table>";
		
		try
		{
			EmailDirector mailmanager = new EmailDirector();
			mailmanager.constructEmailAndServer(new GmailBuilder());
			MailServerSend mailServer = mailmanager.getMailSendServer();
			Email email = mailmanager.getEmail();
		
			email.setRecipient(Message.RecipientType.TO, "tomomotorbay@gmail.com");
			email.setRecipient(Message.RecipientType.TO, "paul@tomoparts.co.uk");
			email.setRecipient(Message.RecipientType.TO, "steve@tomoparts.co.uk");
			email.setSubject("INVOICED ORDERS");
			email.setMessage(message);
		
			mailServer.send(email, "tomomotorbay@gmail.com", "3bay15myl1f3");
		}
		catch (NoSuchProviderException e)
		{
			e.printStackTrace();
		} 
		catch (NullEmailObjectException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NullEmailServerObjectException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AddressException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		return "invoicing finished";
		}
		return "out of business hours, nothing invoiced";
	}

	/* (non-Javadoc)
	 * @see openDMS.model.services.AbstractService#setConfig(openDMS.model.services.AbstractConfiguration)
	 */
	@Override
	public <E> void setConfig(AbstractConfiguration<E> config)
	{
		// TODO Auto-generated method stub

	}

}

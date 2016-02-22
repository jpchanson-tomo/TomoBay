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

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.internet.AddressException;
import java.util.List;
import tomoBay.exceptions.NullEmailObjectException;
import tomoBay.exceptions.NullEmailServerObjectException;
import tomoBay.model.net.email.Email;
import tomoBay.model.net.email.EmailDirector;
import tomoBay.model.net.email.GmailBuilder;
import tomoBay.model.net.email.MailServerSend;

/**
 *
 * @author Jan P.C. Hanson
 *
 */
public final class Mail
{
	public Mail()
	{super();}
	
	/**
	 * 
	 * @param invoicedOrders
	 * @return
	 */
	public String send(List<String[]> invoicedOrders)
	{
		try
		{
			EmailDirector mailmanager = new EmailDirector();
			mailmanager.constructEmailAndServer(new GmailBuilder());
			MailServerSend mailServer = mailmanager.getMailSendServer();
			Email email = this.setUpEmail(invoicedOrders, mailmanager);
			mailServer.send(email, "tomomotorbay@gmail.com", "3bay15myl1f3");
		}
		
		catch (NoSuchProviderException e){e.printStackTrace();} 
		catch (NullEmailObjectException e){e.printStackTrace();} 
		catch (NullEmailServerObjectException e){e.printStackTrace();} 
		catch (AddressException e){e.printStackTrace();} 
		catch (MessagingException e){e.printStackTrace();}
		
		
		return "sent";
	}
	
	/**
	 * 
	 * @param invoicedOrders
	 * @param mailmanager
	 * @param mailServer
	 * @return
	 * @throws AddressException
	 * @throws MessagingException
	 * @throws NullEmailObjectException
	 */
	private Email setUpEmail(List<String[]> invoicedOrders, EmailDirector mailmanager) 
			throws AddressException, MessagingException, NullEmailObjectException
	{
		Email email = mailmanager.getEmail();
	
		email.setRecipient(Message.RecipientType.TO, "tomomotorbay@gmail.com");
		email.setRecipient(Message.RecipientType.TO, "paul@tomoparts.co.uk");
		email.setRecipient(Message.RecipientType.TO, "steve@tomoparts.co.uk");
		email.setSubject("INVOICED ORDERS");
		email.setMessage(this.formatMessage(invoicedOrders));
		return email;
	}
	
	/**
	 * 
	 * @param invoicedOrders
	 * @return
	 */
	private String formatMessage(List<String[]> invoicedOrders)
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
		return message;
	}
}

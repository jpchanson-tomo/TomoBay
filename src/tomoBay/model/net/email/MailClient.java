package tomoBay.model.net.email;
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

import tomoBay.exceptions.NullEmailObjectException;
import tomoBay.exceptions.NullEmailServerObjectException;
import tomoBay.helpers.Config;
import tomoBay.helpers.ConfigReader;

/**
 *
 * @author Jan P.C. Hanson
 *
 */
public final class MailClient
{
	public MailClient()
	{super();}
	
	/**
	 * 
	 * @param message
	 * @param subject
	 * @param to
	 * @param cc
	 * @param bcc
	 * @param builder
	 * @return
	 */
	public static String send
	(String message, String subject, String[] to, String[] cc, String[] bcc, AbstractEmailBuilder builder)
	{
		try
		{
			EmailDirector mailmanager = new EmailDirector();
			mailmanager.constructEmailAndServer(builder);
			MailServerSend mailServer = mailmanager.getMailSendServer();
			Email email = MailClient.setUpEmail(message,subject,to,cc,bcc, mailmanager);
			String address = ConfigReader.getConf(Config.MAIL_ADDR);
			String pwd = ConfigReader.getConf(Config.MAIL_PWD);
			mailServer.send(email, address, pwd);
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
	private static Email setUpEmail(String message, String subject, String[] to, String[] cc, String[] bcc, EmailDirector mailmanager) 
			throws AddressException, MessagingException, NullEmailObjectException
	{
		Email email = mailmanager.getEmail();
		for(String t : to) {email.setRecipient(Message.RecipientType.TO, t);}
		for(String c : cc) {email.setRecipient(Message.RecipientType.CC, c);}
		for(String b : bcc) {email.setRecipient(Message.RecipientType.BCC, b);}
		email.setSubject(subject);
		email.setMessage(message);
		return email;
	}
}

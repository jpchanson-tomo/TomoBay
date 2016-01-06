package tomoBayTests.model.net.email;
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
import tomoBay.model.net.email.Email;
import tomoBay.model.net.email.EmailDirector;
import tomoBay.model.net.email.GmailBuilder;
import tomoBay.model.net.email.MailServerSend;
/**
 *
 * @author Jan P.C. Hanson
 *
 */
public class EmailTest
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		try
		{
			EmailDirector mailmanager = new EmailDirector();
			mailmanager.constructEmailAndServer(new GmailBuilder());
			MailServerSend mailServer = mailmanager.getMailSendServer();
			Email email = mailmanager.getEmail();
		
			email.setRecipient(Message.RecipientType.TO, "tomomotorbay@gmail.com");
			email.setSubject("auto test");
			email.setMessage("this is a test.....test");
		
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

}

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
import java.util.Map;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
/**
 * This class represents a MailServer send connection, it allows the sending of email from a 
 * specific address and going through the MailServer specified by the builder used. This class 
 * is NOT to be directly instantiated but should be created using the EmailDirector.
 * @author Jan P.C. Hanson
 *
 */
public class MailServerSend
{
	/**the properties of the mail server**/
	protected Properties mailServerProperties;
	/**transport protocol used to send the mail**/
	protected String transportProtocol;
	/**the gmail smtp server ip**/
	protected String serverIP_M;
	
	/**
	 * default ctor
	 */
	protected MailServerSend()
	{
		super();
		this.mailServerProperties = System.getProperties();
	}
	
	/**
	 * this method sends the given email using the userID and password provided in the arguments
	 * @param email The email object to send
	 * @param userID the userId to send as
	 * @param pwd the password associated with this userIS
	 * @throws MessagingException
	 */
	public void send(Email email, String userID, String pwd) throws MessagingException
	{	
		MimeMessage message = this.generateMimeMessage(email);
		Transport transport 
		= this.createMailServerSession().getTransport(this.transportProtocol);

		transport.connect(this.serverIP_M, userID, pwd);

		transport.sendMessage(message, message.getAllRecipients());
		transport.close();
		System.out.println("sent");
	}
	
	/**
	 * generates a MimeMessage from the Email object
	 * @param email the Email to convert to a MimeMessage
	 * @return MimeMessage that can be sent.
	 * @throws AddressException
	 * @throws MessagingException
	 */
	private MimeMessage generateMimeMessage(Email email) 
			throws AddressException, MessagingException
	{
		MimeMessage mimeMessage = new MimeMessage(this.createMailServerSession());
		
		for(Map.Entry<String, Message.RecipientType> recipient : email.recipients_M.entrySet())
		{mimeMessage.addRecipient(recipient.getValue(), new InternetAddress(recipient.getKey()));}
		
		mimeMessage.setSubject(email.subject_M);
		mimeMessage.setContent(email.messageBody_M, "text/html");
		return mimeMessage;
	}
	
	/**
	 * creates a mail server session.
	 */
	private Session createMailServerSession()
	{return Session.getDefaultInstance(mailServerProperties, null);}
}
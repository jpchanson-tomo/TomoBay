package tomoBay.model.services.emailErrorsService;
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
import java.util.HashMap;
import java.util.Map;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.internet.AddressException;

import tomoBay.exceptions.NullEmailObjectException;
import tomoBay.exceptions.NullEmailServerObjectException;
import tomoBay.exceptions.ServiceException;
import tomoBay.helpers.ConfigReader;
import tomoBay.model.net.email.Email;
import tomoBay.model.net.email.EmailDirector;
import tomoBay.model.net.email.GmailBuilder;
import tomoBay.model.net.email.MailServerSend;
import tomoBay.model.services.emailErrorsService.EmailErrorsService.emailDataType;
/**
 * This class encapsulates all the interactions this service has with the model.net.email system.
 * @author Jan P.C. Hanson
 *
 */
public class EmailErrorsMailActions
{
	/**the email Director**/
	private EmailDirector mailManager_M;
	/**the MailServer for sending the email**/
	private MailServerSend sendConnection;
	/**the email itself**/
	private Email email;
	/**map of Strings to RecipientType so the service can convert easily.**/
	@SuppressWarnings("serial")
	private static Map<EmailErrorsService.emailDataType,Message.RecipientType> recipients_M 
						= new HashMap<EmailErrorsService.emailDataType,Message.RecipientType>()
			{{
				put(EmailErrorsService.emailDataType.TO, Message.RecipientType.TO);
				put(EmailErrorsService.emailDataType.CC, Message.RecipientType.CC);
				put(EmailErrorsService.emailDataType.BCC, Message.RecipientType.BCC);
			}};
			
	/**
	 * default ctor
	 * @throws ServiceException
	 */
	public EmailErrorsMailActions() throws ServiceException
	{
		super();
		
		try
		{
			this.mailManager_M = new EmailDirector();
			this.mailManager_M.constructEmailAndServer(new GmailBuilder());
			this.sendConnection = this.mailManager_M.getMailSendServer();
			this.email = this.mailManager_M.getEmail();
		} 
		catch (Exception e){throw new ServiceException("could not create Email or MailServerSend object", e);}
	}
	
	/**
	 * handle the creation of the Email by passing in a map with the appropriate data inside it.
	 * @param mailData
	 * @throws ServiceException
	 */
	public void loadData(Map<String, emailDataType> mailData) throws ServiceException
	{
		try
		{
			for (Map.Entry<String, emailDataType> entry : mailData.entrySet()) 
			{
				switch (entry.getValue())
				{
				case TO: case CC: case BCC:
					this.addRecipient(entry.getValue(), entry.getKey());
					break;
				case SUBJECT:
					this.addSubject(entry.getKey());
					break;
				case MESSAGE:
					this.addMessage(entry.getKey());
					break;
				default:
					throw new ServiceException(entry.getValue()+" is not a valid data type");
				}
			}
		}
		catch(MessagingException e)
		{throw new ServiceException(" is not a valid data type", e);}
	}
	
	/**
	 * send the email 
	 */
	public void send()
	{
		String[] credentials = ConfigReader.read("./config/", "mail.conf");
		try{this.sendConnection.send(this.email, credentials[1], credentials[2]);}
		
		catch (Exception e) {throw new ServiceException("cant send email - check that all necessary fields exist: recipients/subject/message", e);}
	}
	
	/**
	 * add a message to the email
	 * @param message the message to add
	 * @throws MessagingException 
	 */
	public void addMessage(String message)
	{
		try{this.email.setMessage(message);}
		catch(Exception e) {throw new ServiceException("cant set message", e);}
	}
	
	/**
	 * add a recipient to the email
	 * @param type the type of recipient: 'TO'/'CC'/'BCC'
	 * @param address the email address of the recipient
	 * @throws MessagingException 
	 * @throws AddressException 
	 */
	private void addRecipient(EmailErrorsService.emailDataType type, String address) throws AddressException, MessagingException
	{this.email.setRecipient(EmailErrorsMailActions.recipients_M.get(type), address); }
	
	/**
	 * add a subject line to the email
	 * @param subject the subject line to add
	 * @throws MessagingException 
	 */
	private void addSubject(String subject) throws MessagingException
	{this.email.setSubject(subject);}
}

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
import gnu.trove.map.hash.THashMap;

import java.util.Map;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
/**
 * This class represents an email, it contains recipients a subject and a message body. This 
 * class is NOT to be directly instantiated, but should be created using the EmailDirector.
 * @author Jan P.C. Hanson
 *
 */
public class Email
{
	/**map containing the recipients**/
	protected Map<String, Message.RecipientType> recipients_M;
	/**String containing the subject line**/
	protected String subject_M;
	/**String containing the message body**/
	protected String messageBody_M;
	
	/**
	 * default ctor
	 */
	protected Email()
	{
		super();
		this.recipients_M = new THashMap<String, Message.RecipientType>();
	}
	
	/**
	 * set a recipient of the email, valid RecipientType listed in Message.RecipientType :
	 * TO/CC/BCC. 
	 * @param recipientType TO/CC/BCC
	 * @param address a string containing the email address of the recipient
	 * @throws MessagingException 
	 * @throws AddressException 
	 */
	public void setRecipient(Message.RecipientType recipientType, String address) 
			throws AddressException, MessagingException
	{this.recipients_M.put(address, recipientType);}
	
	/**
	 * set the subject line of the email.
	 * @param subject String containing the subject line of the email
	 * @throws MessagingException 
	 */
	public void  setSubject(String subject) throws MessagingException
	{this.subject_M = subject;}
	
	/**
	 * sets the email body
	 * @param message String containing the message body for the email
	 * @throws MessagingException 
	 */
	public void setMessage(String message) throws MessagingException
	{this.messageBody_M = message;}
}
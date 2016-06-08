package tomoBay.model.royalMail.calls;
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
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPConstants;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;

/**
 *
 * @author Jan P.C. Hanson
 *
 */
public class SoapMessage
{
	/****/
	private final SOAPMessage message_M;
	/****/
	private final SOAPEnvelope envelope_M;
	
	private final SoapHeader header_M;
	
	
	/**
	 * @throws SOAPException 
	 * 
	 */
	public SoapMessage() throws SOAPException
	{
		super();
		MessageFactory factory = MessageFactory.newInstance(SOAPConstants.DEFAULT_SOAP_PROTOCOL);
		this.message_M = factory.createMessage();
		this.envelope_M = this.message_M.getSOAPPart().getEnvelope();
		this.header_M = new SoapHeader(this.envelope_M);
	}
	
	/**
	 * @param endpoint
	 * @return
	 * @throws MalformedURLException
	 * @throws SOAPException
	 */
	public final SOAPMessage call(String endpoint) throws MalformedURLException, SOAPException
	{
		SOAPConnection con = SOAPConnectionFactory.newInstance().createConnection();
		return con.call(this.message_M, new URL(endpoint));
	}
	
	
	/**
	 * 
	 * @return
	 */
	protected MimeHeaders httpHeaders()
	{return this.message_M.getMimeHeaders();}
	
	/**
	 * 
	 * @return
	 */
	protected SOAPMessage message()
	{return this.message_M;}
	
}

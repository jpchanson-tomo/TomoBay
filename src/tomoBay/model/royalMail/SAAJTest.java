package tomoBay.model.royalMail;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPBodyElement;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPConstants;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPHeaderElement;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;

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

/**
 * A test of the SAAJ JAVA EE functionality.
 * 
 * @author Jan P.C. Hanson
 *
 */
public final class SAAJTest
{

	/**
	 * default ctor
	 */
	public SAAJTest()
	{super();}

	/**
	 * @param args
	 * @throws SOAPException 
	 * @throws IOException 
	 */
	public static void main(String[] args) throws SOAPException, IOException
	{
		String url = "https://api.ebay.com/wsapi";
		String queryString ="?siteid=0"
								+ "&routing=new"
								+ "&callname=GeteBayOfficialTime"
//								+ "&client=java"
								+ "&version=423"
								+ "&appid=JanPhill-6fd5-44bb-9622-332d18aba0b6";
		
		URL endPoint = new URL(url+queryString);
		URL endPointLocal = new URL("http://192.168.0.234:1234");
		MessageFactory factory = MessageFactory.newInstance(SOAPConstants.SOAP_1_1_PROTOCOL);
		MimeHeaders mimes = new MimeHeaders();
		mimes.addHeader("Content-Type", SOAPConstants.SOAP_1_1_CONTENT_TYPE);
		mimes.addHeader("SOAPAction", "zxcfxcfxcf ");
		SOAPMessage message = factory.createMessage();
		
		SOAPPart part = message.getSOAPPart();
		SOAPEnvelope envelope = part.getEnvelope();
		SOAPHeader messageHeader = envelope.getHeader();
		SOAPBody messageBody = envelope.getBody();
		
		
		envelope.removeNamespaceDeclaration("SOAP-ENV");
		envelope.setPrefix("soapenv");
		envelope.addNamespaceDeclaration("xsd", "http://www.w3.org/2001/XMLSchema");
		envelope.addNamespaceDeclaration("xsi", "http://www.w3.org/2001/XMLSchema-instance");
		
		
		messageHeader.setPrefix("soapenv");
		
		QName headerName = new QName("urn:ebay:apis:eBLBaseComponents","RequesterCredentials","ebl");
		SOAPHeaderElement headElement = messageHeader.addHeaderElement(headerName);
		QName mustUnderstand = new QName("","mustUnderstand","soapenv");
		headElement.addAttribute(mustUnderstand, "0");
		
		SOAPElement authToken = headElement.addChildElement("eBayAuthToken", "ebl");
		authToken.addTextNode("AgAAAA**AQAAAA**aAAAAA**0GbQVg**nY+sHZ2PrBmdj6wVnY+sEZ2PrA2dj6wMk4GnD5GDogSdj6x9nY+seQ**zycDAA**AAMAAA**vuf8mZAWVaWRvLQ3FV/HyJdJ6kfngurBszal33drU7jupoq3YVruEMlZdpeBjxqvkcqyNkMa64UotHZ+2H2Am3yJ7dUDTju5gAYxuqQt9p4+fTJVnQ3ndUpYJGtO/gCEWGTM4WP4i8sdTgrw+B4tsu9ZyQFr1uYdr6BYqPgD1K/CNV/xUOmtIqmoPI1m6guV5hpXI+Th3814tJub+zThmJBQIusb47qO8Lx7VSJc/gyDY6TQwctfu5Xvs3EN/8g4iuUR+wZzzg2/k8eL+6SuSgrC4W31ZDboFQWs13t3AiD7vsWhiNdeELTHigRZSokHbzbmq191pX7DdmWjYon3Z2G2nu/pdQuc5P2tAgGzhxcIlfN8XS+FCZupuWXM44FpRfYORKCHioE7gcvIAvOPbA5xRVUVOqRKr+Qz/Qq2ItiEwWDbv4DbyElLjmcMfCjioBd9L4BF2DvaZ/9n6DPK7XpHhbfDJHDelm2RV0Li7FNPWRyRFg52gmCKR2DN3f9GQ3xUpM1r9EgjdlauwFBr6e7hC3iZkV4AwEYBBG3k9UR330ZZISE7HFkFMSDJfFoLVj6zWsx3Vylky7WLzj+tvrWtEQTILP6x46WkQjAEz/it3t1z2ECthkdjBFh/1X1VMS16YErN45m6WJcvOg8F6nxQ5YxqWYHqqJXVzRzwCGe35yfAHargvftaVqVJgi1B5pxOjtbgLmoqknwYc9lsSQMkWPfCsjFGXqh1WZnfH1U5srQb64X+eF1bFAY/29VK");
		authToken.addNamespaceDeclaration("ebl", "urn:ebay:apis:eBLBaseComponents");
		
		
		messageBody.setPrefix("soapenv");
		
		QName bodyName = new QName("urn:ebay:apis:eBLBaseComponents","GeteBayOfficialTimeRequest","");
		SOAPBodyElement element = messageBody.addBodyElement(bodyName);
		
		SOAPElement detailLevel = element.addChildElement("DetailLevel");
		detailLevel.addTextNode("ReturnAll");
		
		SOAPElement version = element.addChildElement("Version");
		version.addTextNode("423");
		
		
		SOAPConnection con = SOAPConnectionFactory.newInstance().createConnection();
		SOAPMessage response = con.call(message, endPoint);
		
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		response.writeTo(out);
		String strMessage = new String(out.toByteArray());
		System.out.println(strMessage);
		
		con.call(message, endPointLocal);
		con.close();
		
		
//		//see results in wireshark
//		con = SOAPConnectionFactory.newInstance().createConnection();
//		con.call(message, endPointLocal);
//		con.close();
	}
}

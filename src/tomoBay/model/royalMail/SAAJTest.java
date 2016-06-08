package tomoBay.model.royalMail;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;

import javax.net.ssl.HttpsURLConnection;
import javax.xml.soap.SOAPException;

import com.royalmailgroup.api.ship.v2.CreateShipmentRequest;
import com.royalmailgroup.api.ship.v2.FaultResponse;
import com.royalmailgroup.api.ship.v2.ObjectFactory;
import com.royalmailgroup.api.ship.v2.RequestedShipment;
import com.royalmailgroup.api.ship.v2.ShippingAPI;
import com.royalmailgroup.api.ship.v2.ShippingAPIPortType;
import com.royalmailgroup.cm.referencedata.v3.ServiceFormatType;

import tomoBay.model.dataTypes.PartList;
import tomoBay.model.royalMail.calls.RoyalMailPOST;

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
	 * @throws FaultResponse 
	 */
	public static void main(String[] args) throws SOAPException, IOException, FaultResponse
	{
//		String url = "http://api.royalmail.net/shipping/v2";
//		
//		
//		URL endPoint = new URL(url);
//		URL endPointLocal = new URL("http://192.168.0.234:1234");
//		
//		MessageFactory factory = MessageFactory.newInstance(SOAPConstants.DEFAULT_SOAP_PROTOCOL);
//		SOAPMessage message = factory.createMessage();
//		
//		message.getMimeHeaders().removeHeader("Accept");
//		message.getMimeHeaders().addHeader("Accept", "application/xml");
//		message.getMimeHeaders().addHeader("Accept-Encoding", "gzip,deflate,sdch");
//		message.getMimeHeaders().addHeader("Accept-Language", "en-US,en;q=0.8,fa;q=0.6,sv;q=0.4");
//		message.getMimeHeaders().addHeader("SOAPAction", "createShipment ");
//		message.getMimeHeaders().addHeader("X-IBM-Client-Id", "34474f61-6e47-463b-8f40-c25a29a27fb6");
//		message.getMimeHeaders().addHeader("X-IBM-Client-Secret", "fS2wI1yU0jE4uP7jN3gR5cD0uX0qB7yF4oG2qY4gI5sL1cD3lV");
//		
//		SOAPPart part = message.getSOAPPart();
//		SOAPEnvelope envelope = part.getEnvelope();
//		SOAPHeader messageHeader = envelope.getHeader();
//		SOAPBody messageBody = envelope.getBody();
//		
//		//SOAP HEADER
//		QName headerName = new QName("http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd","Security","oas");
//		SOAPHeaderElement headElement = messageHeader.addHeaderElement(headerName);
//		headElement.addTextNode(" ");
////		headElement.adda
//		
//		//SOAP BODY
//		//CREATE SHIPMENT REQUEST
//		//INTEGRATION HEADER
//		//REQUESTED SHIPMENT
//		
////		SOAPElement authToken = headElement.addChildElement("eBayAuthToken", "ebl");
////		authToken.addTextNode("AgAAAA**AQAAAA**aAAAAA**0GbQVg**nY+sHZ2PrBmdj6wVnY+sEZ2PrA2dj6wMk4GnD5GDogSdj6x9nY+seQ**zycDAA**AAMAAA**vuf8mZAWVaWRvLQ3FV/HyJdJ6kfngurBszal33drU7jupoq3YVruEMlZdpeBjxqvkcqyNkMa64UotHZ+2H2Am3yJ7dUDTju5gAYxuqQt9p4+fTJVnQ3ndUpYJGtO/gCEWGTM4WP4i8sdTgrw+B4tsu9ZyQFr1uYdr6BYqPgD1K/CNV/xUOmtIqmoPI1m6guV5hpXI+Th3814tJub+zThmJBQIusb47qO8Lx7VSJc/gyDY6TQwctfu5Xvs3EN/8g4iuUR+wZzzg2/k8eL+6SuSgrC4W31ZDboFQWs13t3AiD7vsWhiNdeELTHigRZSokHbzbmq191pX7DdmWjYon3Z2G2nu/pdQuc5P2tAgGzhxcIlfN8XS+FCZupuWXM44FpRfYORKCHioE7gcvIAvOPbA5xRVUVOqRKr+Qz/Qq2ItiEwWDbv4DbyElLjmcMfCjioBd9L4BF2DvaZ/9n6DPK7XpHhbfDJHDelm2RV0Li7FNPWRyRFg52gmCKR2DN3f9GQ3xUpM1r9EgjdlauwFBr6e7hC3iZkV4AwEYBBG3k9UR330ZZISE7HFkFMSDJfFoLVj6zWsx3Vylky7WLzj+tvrWtEQTILP6x46WkQjAEz/it3t1z2ECthkdjBFh/1X1VMS16YErN45m6WJcvOg8F6nxQ5YxqWYHqqJXVzRzwCGe35yfAHargvftaVqVJgi1B5pxOjtbgLmoqknwYc9lsSQMkWPfCsjFGXqh1WZnfH1U5srQb64X+eF1bFAY/29VK");
////		authToken.addNamespaceDeclaration("ebl", "urn:ebay:apis:eBLBaseComponents");
////		
////		
////		
////		QName bodyName = new QName("urn:ebay:apis:eBLBaseComponents","GeteBayOfficialTimeRequest","");
////		SOAPBodyElement element = messageBody.addBodyElement(bodyName);
////		
////		SOAPElement detailLevel = element.addChildElement("DetailLevel");
////		detailLevel.addTextNode("ReturnAll");
////		
////		SOAPElement version = element.addChildElement("Version");
////		version.addTextNode("423");
//		
//		
//		
//		
//		
//		
//		SOAPConnection con = SOAPConnectionFactory.newInstance().createConnection();
//		SOAPMessage response = con.call(message, endPointLocal);
//		
//		
//		final StringWriter sw = new StringWriter();
//		try
//		{
//			TransformerFactory.newInstance().newTransformer().transform(new DOMSource(response.getSOAPPart()), new StreamResult(sw));
//		}
//		catch(TransformerException te)
//		{
//			te.printStackTrace();
//		}
//		
//		
//		ByteArrayOutputStream out = new ByteArrayOutputStream();
//		response.writeTo(out);
////		String strMessage = new String(out.toByteArray());
//		System.out.println(sw.toString());
//		
////		con.call(message, endPointLocal);
//		con.close();
//		
//		
////		//see results in wireshark
////		con = SOAPConnectionFactory.newInstance().createConnection();
////		con.call(message, endPointLocal);
////		con.close();
//		ObjectFactory fac = new ObjectFactory();
//		CreateShipmentRequest req = fac.createCreateShipmentRequest();
//		
//		RequestedShipment shipreq = fac.createRequestedShipment();
//		shipreq.setCustomerReference("C123456");
//		shipreq.setServiceFormat(new ServiceFormatType().);
//		req.setRequestedShipment(shipreq);
//		
//		
//		ShippingAPI ship = new ShippingAPI();
//		ShippingAPIPortType shipInstance = ship.getShippingAPIPort();
//		shipInstance.createShipment(req);
		
		String listing = "1417521(1)1417520(1)";
		PartList parts = new PartList(listing);
		for(int i = 0; i < parts.size() ; ++i)
		{
			System.out.println(parts.getPartNumber(i));
			System.out.println(parts.getPartQty(i));
		}
	}
}

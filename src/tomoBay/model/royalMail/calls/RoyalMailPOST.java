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
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import tomoBay.model.net.HttpResponse;

/**
 *
 * @author Jan P.C. Hanson
 *
 */
public class RoyalMailPOST
{

	/**
	 * 
	 */
	public RoyalMailPOST()
	{super();}
	
	public HttpResponse send(String content) throws IOException
	{
		String query ="<?xml version='1.0' encoding='UTF-8'?>";
		
		
		URL endpoint = new URL("https://api.royalmail.net/shipping/v2/");
//		URL endpoint = new URL("https://github.com");
		HttpsURLConnection con = (HttpsURLConnection) endpoint.openConnection();
		con.setSSLSocketFactory(con.getSSLSocketFactory());
		con.setRequestMethod("GET");
//		con.setRequestProperty("Content-Type","application/xml"); 
		con.setDoOutput(true); 
		con.setDoInput(true);
		
		DataOutputStream output = new DataOutputStream( con.getOutputStream() ); 

		// write out the data 
		output.writeBytes( query ); 
		output.close();
	
		System.out.println("Resp Code:"+con.getResponseCode()); 
		System.out.println("Resp Message:"+ con.getResponseMessage()); 
//		// get ready to read the response from the cgi script 
		DataInputStream input = new DataInputStream( con.getInputStream() );
//	
//		// read in each character until end-of-stream is detected 
		for( int c = input.read(); c != -1; c = input.read() ) 
			System.out.print( (char)c ); 
		input.close(); 
		return null;
	}

}

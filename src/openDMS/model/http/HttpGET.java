package openDMS.model.http;
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
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.URL;
/**
 *
 * @author Jan P.C. Hanson
 *
 */
public class HttpGET
{
	/**
	 * default constructor
	 */
	public HttpGET()
	{super();}
	
	/**
	 * perform an HTTP GET request for the specified url, returns the contents of the response
	 * as a string.
	 * @param targetURL
	 * @return String containing the value of the HTTP response
	 * @throws IOException
	 */
	public HttpResponse request(String targetURL)
	{
		try
		{
			URL url = new URL(targetURL);
		
			HttpURLConnection con = this.setUpConnection(url);
		
			int responseCode = con.getResponseCode();
		
			return new HttpResponse(responseCode, this.readConnection(responseCode, con));
		}
		catch (Exception e)
		{return new HttpResponse(37707, this.stackTraceToString(e));}
	}
	
	/**
	 * do setup for the HttpURLConnection object
	 * @param url URL representing the address you wish to visit
	 * @return HttpURLConnection to the specified URL
	 * @throws IOException
	 */
	private HttpURLConnection setUpConnection(URL url) throws IOException
	{
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("User-Agent", "Mozilla/5.0");
		return con;
	}
	
	/**
	 * reads from the HttpURLConnection and passes back a string containing the contents of the
	 * response.
	 * @param responseCode
	 * @param connection
	 * @return
	 * @throws IOException
	 */
	private String readConnection(int responseCode, HttpURLConnection connection) throws IOException
	{
		if(responseCode == HttpURLConnection.HTTP_OK)
		{
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) 
			{response.append(inputLine+"\n");}
			in.close();
			return response.toString();
		}
		else
		{return "GET request rejected:" + responseCode + " error";}
	}
	
	private String stackTraceToString(Exception e)
	{
		StringWriter stringWriter = new StringWriter();
		PrintWriter printWriter = new PrintWriter(stringWriter);
		e.printStackTrace(printWriter);
		return stringWriter.toString();
	}
}

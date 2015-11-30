package tomoBay.model.net;
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
 * data object that contains the response code and the response message associated with a
 * particular HttpGET request.
 * @author Jan P.C. Hanson
 *
 */
public class HttpResponse
{
	/**integer holder for the response code**/
	private int responseCode_M;
	/**String holder for the response message**/
	private String responseMessage_M;
	
	/**
	 * constructor, create a HttpResponse which contains a response code and a response message.
	 * @param responseCode the response code
	 * @param responseMessage the response message.
	 */
	public HttpResponse(int responseCode, String responseMessage)
	{
		this.responseCode_M = responseCode;
		this.responseMessage_M = responseMessage;
	}
	
	/**
	 * get the response code
	 * @return int representing the response code.
	 */
	public int getResponseCode()
	{return this.responseCode_M;}
	
	/**
	 * get the Response message
	 * @return String containing the value of the response
	 */
	public String getResponseMessage()
	{return this.responseMessage_M;}
}

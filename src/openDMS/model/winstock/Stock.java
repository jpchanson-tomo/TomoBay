package openDMS.model.winstock;
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
import openDMS.helpers.XMLParser;
import openDMS.model.http.HttpGET;
import openDMS.model.http.HttpResponse;
/**
 *
 * @author Jan P.C. Hanson
 *
 */
public class Stock
{
	/**the first part of the winstock url up to the first variable**/
	private static final String URL_PT1_M="http://192.168.0.100:7979/get?index=product&company=";
	/**the second part of the winstock url up to the second variable**/
	private static final String URL_PT2_M= "&find=";
	/**holder for the result**/
	private String result;
	
	/**
	 * default ctor
	 */
	public Stock()
	{super();}
	
	/**
	 * query winstock for the stock level of a particular part.
	 * @param partNo the manufacturer part number
	 * @param brandCode 'C'=citroen/peugeot/psa, 'F'=ford, 'P'=everything else
	 * @return int the number of the requested part in stock
	 */
	public int requestStockLevel(String partNo, String brandCode)
	{
		HttpGET get = new HttpGET();
		HttpResponse response = get.request(Stock.URL_PT1_M+brandCode+Stock.URL_PT2_M+partNo);
		//System.out.println(Stock.URL_PT1_M+brandCode+Stock.URL_PT2_M+partNo);
		result = this.postFormatXMLString(response);
		result = XMLParser.parse("QTY_EXIST", result);

		try{return Integer.parseInt(result);}
		catch(NumberFormatException nfe) {return -8008135;}
	}
	
	/**
	 * remove the header bumpf from the bottom of the response
	 * @param xmlResponse the response returned by the HttpGET.request()
	 * @return String containing just the XML
	 */
	private String postFormatXMLString(HttpResponse xmlResponse)
	{return xmlResponse.getResponseMessage().split("HTTP/1.1 ")[0];}
}

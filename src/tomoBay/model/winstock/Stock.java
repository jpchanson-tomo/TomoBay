package tomoBay.model.winstock;
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
import tomoBay.helpers.Config;
import tomoBay.helpers.ConfigReader;
import tomoBay.helpers.XMLParser;
import tomoBay.model.net.HttpGET;
import tomoBay.model.net.HttpResponse;
/**
 * This class is responsible for querying winstock for information. 
 * @author Jan P.C. Hanson
 *
 */
public final class Stock
{
	public static final int ERROR = -8008135;  
	
	private static final String HTTP_HEADER = "HTTP/1.1 ";
	/**the first part of the winstock url up to the first variable**/
	private static final String URL_PT1_M=ConfigReader.getConf(Config.WIN_URL1);
	/**the second part of the winstock url up to the second variable**/
	private static final String URL_PT2_M= ConfigReader.getConf(Config.WIN_URL2);
	/**the response from winstock for the last part number queried**/
	private HttpResponse response_M;
	
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
	public final int requestStockLevel(String partNo, String brandCode)
	{
		this.queryWinstockURL(partNo, brandCode);
		String result = this.postFormatXMLString(this.response_M);
		result = XMLParser.parse("QTY_EXIST", result);

		try{return Integer.parseInt(result);}
		catch(NumberFormatException nfe) {return Stock.ERROR;}
	}
	
	/**
	 * query winstock for the description of a particular part.
	 * @param partNo the manufacturer part number
	 * @param brandCode 'C'=citroen/peugeot/psa, 'F'=ford, 'P'=everything else
	 * @return int the number of the requested part in stock
	 */
	public final String requestDescription(String partNo, String brandCode)
	{
		String result;
		this.queryWinstockURL(partNo, brandCode);
		
		result = this.postFormatXMLString(this.response_M);
		result = XMLParser.parse("DESC", result);
		return result;
	}
	
	/**
	 * query winstock for the last cost price of a particular part.
	 * @param partNo the manufacturer part number
	 * @param brandCode 'C'=citroen/peugeot/psa, 'F'=ford, 'P'=everything else
	 * @return int the number of the requested part in stock
	 */
	public final double requestLastCost(String partNo, String brandCode)
	{
		String result;
		this.queryWinstockURL(partNo, brandCode);
		
		result = this.postFormatXMLString(this.response_M);
		result = XMLParser.parse("COST", result);
		try{return Double.parseDouble(result);}
		catch(NumberFormatException nfe) {return Stock.ERROR;}
	}
	
	/**
	 * query winstock for the weight of a particular invoice
	 * @param invoiceNo the number of the invoice
	 * @param brandCode brandCode '3'=citroen/peugeot/psa, '0'=ford, '8'=prestige
	 * @return int representing the invoice weight.
	 */
	public final int requestInvoiceWeight( int invoiceNo, int brandCode)
	{
		final String weightCallPt1 = ConfigReader.getConf(Config.WIN_WEIGHT_CALL1);
		final String weightCallPt2 = ConfigReader.getConf(Config.WIN_WEIGHT_CALL2);
		
		HttpGET get = new HttpGET();
		HttpResponse response = get.request(weightCallPt1+invoiceNo+weightCallPt2+brandCode);
		String result = this.postFormatXMLString(response);
		result = XMLParser.parse("invoiceweight", result);
		try{return Integer.parseInt(result);}
		catch(NumberFormatException nfe) {return Stock.ERROR;}
	}
	
	/**
	 * @param partNo
	 * @param brandCode
	 */
	private void queryWinstockURL(String partNo, String brandCode)
	{
			HttpGET get = new HttpGET();
//			System.out.println(Stock.URL_PT1_M+brandCode+Stock.URL_PT2_M+partNo.toUpperCase());
			this.response_M = get.request(Stock.URL_PT1_M+brandCode+Stock.URL_PT2_M+partNo.toUpperCase());
	}
	
	/**
	 * remove the header bumpf from the bottom of the response
	 * @param xmlResponse the response returned by the HttpGET.request()
	 * @return String containing just the XML
	 */
	private String postFormatXMLString(HttpResponse xmlResponse)
	{return xmlResponse.getResponseMessage().split(Stock.HTTP_HEADER)[0];}
}

package tomoBay.model.winstock.response;
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
import tomoBay.exceptions.NotAValidResultCodeException;
/**
 * 
 * @author Jan P.C. Hanson
 *
 */
public class PrintInvoiceResponse implements AbstractWinstockCommandResponse
{
	/**internal storage for the raw byte[] that comes back as a response from the socket**/
	private byte[] responseBytes_M;
	
	/**internal storage for the raw byte[] that gets sent to the winstock socket.**/
	private byte[] sentBytes_M;
	
	/**
	 * default ctor
	 */
	public PrintInvoiceResponse()
	{super();}

	/* (non-Javadoc)
	 * @see tomoBay.model.winstock.commands.AbstractWinstockCommandResponse#isSuccess()
	 */
	@Override
	public ResultCodes isSuccess() throws NotAValidResultCodeException
	{System.out.println(this.responseBytes_M[5]);
		return ResultCodes.forValue(this.responseBytes_M[5]);}

	/* (non-Javadoc)
	 * @see tomoBay.model.winstock.response.AbstractWinstockCommandResponse#setSentBytes(byte[])
	 */
	@Override
	public void setSentBytes(byte[] sentBytes)
	{this.sentBytes_M = sentBytes;}
	
	/* (non-Javadoc)
	 * @see tomoBay.model.winstock.response.AbstractWinstockCommandResponse#setResponseBytes(byte[])
	 */
	@Override
	public void setResponseBytes(byte[] responseBytes)
	{this.responseBytes_M = responseBytes;}

	
	/* (non-Javadoc)
	 * @see tomoBay.model.winstock.commands.AbstractWinstockCommandResponse#getData()
	 */
	@Override
	public String getRecieved()
	{
		String data="";
		for (byte element : this.responseBytes_M)
		{data += element + " ";}
		return data;
	}

	/* (non-Javadoc)
	 * @see tomoBay.model.winstock.response.AbstractWinstockCommandResponse#getSent()
	 */
	@Override
	public String getSent()
	{
		String data="";
		for (byte element : this.sentBytes_M)
		{data += element + " ";}
		return data;
	}
}
/**
 * the response from the server comes in the following form:
 * |DataType | Label    | Notes					  |
 * |:-------:|:--------:|:-----------------------:|
 * |byte     |Header[4] |WSCO					  |
 * |byte     |Type      |35    					  |
 * |byte     |Company   |0=ford, 3=citroen, 8=fiat|
 * |byte     |ResultCode|see ResultCodes enum     |
 * |byte     |terminator|170 (0xAA)               |
 */
package tomoBay.model.winstock.response;
import tomoBay.exceptions.NotAValidResultCodeException;
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
import tomoBay.helpers.NoImports;
/**
 * This class is the AbstractWinstockCommandResponse associated with the PutInvoiceCommand.
 * 
 * @author Jan P.C. Hanson
 *
 */
@SuppressWarnings("unused")
public final class PutInvoiceResponse implements AbstractWinstockCommandResponse
{
	/**internal storage for the raw byte[] that comes back as a response from the socket**/
	private byte[] responseBytes_M;
	
	/**internal storage for the raw byte[] that gets sent to the winstock socket.**/
	private byte[] sentBytes_M;
	
	/* (non-Javadoc)
	 * @see tomoBay.model.winstock.commands.AbstractWinstockCommandRepsonse#isSuccess()
	 */
	@Override
	public ResultCodes isSuccess() throws NotAValidResultCodeException
	{
		return ResultCodes.forValue(this.responseBytes_M[5]);
	}

	/* (non-Javadoc)
	 * @see tomoBay.model.winstock.response.AbstractWinstockCommandResponse#setResponseBytes(byte[])
	 */
	@Override
	public void setResponseBytes(byte[] responseBytes)
	{this.responseBytes_M = responseBytes;}
	
	/* (non-Javadoc)
	 * @see tomoBay.model.winstock.response.AbstractWinstockCommandResponse#setSentBytes(byte[])
	 */
	@Override
	public void setSentBytes(byte[] sentBytes)
	{this.sentBytes_M = sentBytes;}

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
	
	/* (non-Javadoc)
	 * @see tomoBay.model.winstock.commands.AbstractWinstockCommandResponse#getData()
	 */
	@Override
	public String[] getRecieved()
	{
		byte[] invNo = {this.responseBytes_M[6], this.responseBytes_M[7], this.responseBytes_M[8], this.responseBytes_M[9]};
		int result = java.nio.ByteBuffer.wrap(invNo).order(java.nio.ByteOrder.LITTLE_ENDIAN).getInt();
		
		byte[] weight = {this.responseBytes_M[10], this.responseBytes_M[11], this.responseBytes_M[12], this.responseBytes_M[13]};
		int result2 = java.nio.ByteBuffer.wrap(weight).order(java.nio.ByteOrder.LITTLE_ENDIAN).getInt();
		
		String[] output = {String.valueOf(result), String.valueOf(result2)};
		return output;
	}
}
/**
 *The response from the server follows the following specification (taken from winstock specs)
 * 
 * |DataType | Label       | Notes |
 * |:-------:|:-----------:|:-----:|
 * |byte[4]  |Header       |"WSC0" |
 * |byte     |Type         |34     |
 * |byte     |ErrorCode    |       |
 * |int      |InvoiceNumber|       |
 * |int      |InvoiceWeight|       |
 * |byte     |Terminator   |0xAA   |
 */
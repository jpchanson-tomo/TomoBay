package tomoBay.model.winstock.commands;
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
import java.io.IOException;
import java.net.UnknownHostException;

import tomoBay.exceptions.PayloadException;
import tomoBay.helpers.DualList;
import tomoBay.model.winstock.payloads.PayloadType;
import tomoBay.model.winstock.payloads.PrintInvoicePayload;
import tomoBay.model.winstock.response.PrintInvoiceResponse;
/**
 * This class represents a command to winstock to print an invoice.
 * @author Jan P.C. Hanson
 *
 */
public class PrintInvoiceCommand extends AbstractWinstockCommand
{
	/**constant holding the the length of the response in bytes**/
	private static final int RESPONSE_LENGTH = 7;
	/**the response object**/
	private PrintInvoiceResponse response_M;
	/**the payload object**/
	private PrintInvoicePayload payload_M;
	
	/**
	 * default ctor
	 * @throws UnknownHostException
	 * @throws IOException
	 */
	public PrintInvoiceCommand() throws UnknownHostException, IOException
	{
		super();
		this.response_M = new PrintInvoiceResponse();
		this.payload_M = new PrintInvoicePayload();
	}

	/* (non-Javadoc)
	 * @see tomoBay.model.winstock.commands.AbstractWinstockCommand#execute()
	 */
	@Override
	public PrintInvoiceResponse execute(DualList<String, PayloadType> commandInfo) throws IOException, PayloadException
	{
		byte[] payload = payload_M.getPayload(commandInfo);
		this.response_M.setSentBytes(payload);
		
		byte[] response = super.winstockConnection_M.send(payload, RESPONSE_LENGTH);
		this.response_M.setResponseBytes(response);
		
		super.winstockConnection_M.close();
		return this.response_M;
	}

}

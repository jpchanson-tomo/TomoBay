package tomoBay.model.winstock.commands;
import java.io.IOException;
import java.net.UnknownHostException;


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
import tomoBay.model.net.ClientSocket;
/**
 * this class instructs winstock to create an invoice given the data that is passed in.
 * The format of the message to create (as defined by winstock spec) is as follows:
 * 
 * |  DataType |   Label       |   Notes                  |
 * |:---------:|:-------------:|:------------------------:|
 * |byte[4]    | Header        | "WSC0"                   |
 * |byte       | Type          | 34                       |
 * |byte       | Company       | 0=ford, 3=citroen, 8=fiat|
 * |char       | AccountCode[9]| account identifier       |
 * |char       | ship1[51]     | name                     |
 * |char       | ship2[51]     | address line 1           |
 * |char       | ship3[51]     | address line 2           |
 * |char       | ship4[51]     | city                     |
 * |char       | ship5[51]     | county                   |
 * |char       | Postcode[10]  | postcode                 |
 * |char       | Order[21]     | order data               |
 * |short      | Lines         |                          |
 * |InvLine    | Il[1]         |                          |
 * |byte       | terminator    | 0xAA                     |
 * 
 * this class is a concrete command in a Gof style command pattern
 * 
 * @author Jan P.C. Hanson
 * @see https://dzone.com/articles/design-patterns-command
 *
 */
public class PutInvoiceCommand extends AbstractWinstockCommand
{
	/**
	 * default ctor
	 * @throws UnknownHostException
	 * @throws IOException
	 */
	public PutInvoiceCommand() throws UnknownHostException, IOException
	{super();}
	
	/* (non-Javadoc)
	 * @see tomoBay.model.winstock.AbstractWinstockCommand#execute()
	 */
	@Override
	public PutInvoiceResponse execute()
	{
		// TODO Auto-generated method stub
		return null;
	}
}

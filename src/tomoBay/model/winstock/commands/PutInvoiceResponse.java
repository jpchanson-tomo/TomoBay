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

/**
 * This class is the AbstractWinstockCommandResponse associated with the PutInvoiceCommand.
 * 
 * The response from the server follows the following specification (taken from winstock specs)
 * 
 * |DataType | Label       | Notes |
 * |:-------:|:-----------:|:-----:|
 * |byte[4]  |Header       |"WSC0" |
 * |byte     |Type         |34     |
 * |byte     |ErrorCode    |       |
 * |int      |InvoiceNumber|       |
 * |int      |InvoiceWeight|       |
 * |byte     |Terminator   |       |
 * @author Jan P.C. Hanson
 *
 */
public class PutInvoiceResponse implements AbstractWinstockCommandResponse
{

	/* (non-Javadoc)
	 * @see tomoBay.model.winstock.commands.AbstractWinstockCommandRepsonse#isSuccess()
	 */
	@Override
	public boolean isSuccess()
	{
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see tomoBay.model.winstock.commands.AbstractWinstockCommandRepsonse#getData()
	 */
	@Override
	public String getData()
	{
		// TODO Auto-generated method stub
		return null;
	}

}

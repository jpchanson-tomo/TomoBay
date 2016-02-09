package tomoBay.model.dataTypes.invoice;
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
 *
 * @author Jan P.C. Hanson
 *
 */
public class GSPInvoice extends AbstractInvoice
{

	/**
	 * @param orderID
	 */
	protected GSPInvoice(String orderID)
	{
		super(orderID);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see tomoBay.model.dataTypes.invoice.AbstractInvoice#noOfInvLines()
	 */
	@Override
	public int noOfInvLines()
	{
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see tomoBay.model.dataTypes.invoice.AbstractInvoice#invLine(int)
	 */
	@Override
	public InvoiceLine invLine(int invLineNo)
	{
		// TODO Auto-generated method stub
		return null;
	}

}

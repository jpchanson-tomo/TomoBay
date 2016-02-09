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
import tomoBay.model.dataTypes.order.Order;
/**
 *
 * @author Jan P.C. Hanson
 *
 */
public abstract class AbstractInvoice
{
	/****/
	protected Order order_M;
	
	/**
	 * does initial setup initialising an invoice for this order
	 * @param orderID
	 */
	protected AbstractInvoice(String orderID)
	{
		super();
		this.order_M=new Order("orderID");
	}
	
	public Order orderInfo()
	{return this.order_M;}
	
	/**
	 * the number of invoice lines associated with this invoice
	 * @return int the number of invoice lines
	 */
	public abstract int noOfInvLines();
	
	/**
	 * retrieve a particular invoice line from this invoice
	 * @param invLineNo the number of the invoice line to retrieve
	 * @return InvoiceLine holding the data for the invoice line requested.
	 */
	public abstract InvoiceLine invLine(int invLineNo);
}

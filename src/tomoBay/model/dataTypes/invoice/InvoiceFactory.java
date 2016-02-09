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
public class InvoiceFactory
{
	/**
	 * default ctor
	 */
	public InvoiceFactory()
	{super();}

	/**
	 * 
	 * @param orderID
	 * @return
	 */
	public AbstractInvoice make(String orderID)
	{
		Order order = new Order("orderID");
		if(order.shippingCost()!=0) {return new ExtraShippingInvoice(orderID);}
		else if (this.isGSP(order)) {return new GSPInvoice(orderID);}
		else{return new StandardInvoice(orderID);}
	}
	
	/**
	 * 
	 * @param order
	 * @return
	 */
	private boolean isGSP(Order order)
	{
		return order.buyerName().contains("GSP") || order.street1().contains("GSP")
				|| order.street2().contains("GSP") ? true : false;
	}
}

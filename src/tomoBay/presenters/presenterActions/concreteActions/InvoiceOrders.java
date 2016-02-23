package tomoBay.presenters.presenterActions.concreteActions;
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
import tomoBay.model.dataTypes.DualList;
import tomoBay.model.dataTypes.financial.SalesOrderDayBook.AbstractSalesDayBookLine;
import tomoBay.model.dataTypes.financial.SalesOrderDayBook.concreteLineTypes.StandardInvoice;
import tomoBay.model.dataTypes.order.Order;
import tomoBay.model.winstock.payloads.PayloadType;
import tomoBay.presenters.presenterActions.AbstractPresenterAction;
/**
 * This AbstractPresenterAction provides functionality to invoice a number of orders based on the 
 * order numbers provided as the data string to the execute method. This string should be a comma
 * seperated string of valid order numbers i.e. real order numbers that are less than 90 days old.
 * @author Jan P.C. Hanson
 *
 */
public final class InvoiceOrders implements AbstractPresenterAction
{

	/**
	 * default ctor
	 */
	public InvoiceOrders()
	{super();}

	/* (non-Javadoc)
	 * @see tomoBay.presenters.presenterActions.AbstractPresenterAction#execute(java.lang.String)
	 */
	@Override
	public String execute(String data)
	{
		String[] orderIDs = this.splitOrderNoString(data);
		for(String orderId : orderIDs)
		{
			AbstractSalesDayBookLine invoice = new StandardInvoice(new Order(orderId));
			DualList<String, PayloadType> winstockInv = this.formatAsDualList(invoice);
		}
		return null;
	}
	
	/**
	 * splits the 'data' string into a string array
	 * @param orderNos the 'data' string
	 * @return String[] containing all the orderNos in the original 'data' string
	 */
	private String[] splitOrderNoString(String orderNos)
	{return orderNos.split(",");}
	
	/**
	 * formats the AbstractSalesDayBookLine into a format that can be passed to the WinstockCommandInvoker.
	 * @param invoice the invoice to be formatted
	 * @return DualList<String, PayloadType> accepted by the WinstockCommandInvoker
	 */
	private DualList<String, PayloadType> formatAsDualList(AbstractSalesDayBookLine invoice)
	{
		return null;
	}

}

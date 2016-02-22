package tomoBay.model.dataTypes.financial.SalesOrderDayBook.factories;

import tomoBay.model.dataTypes.financial.SalesOrderDayBook.AbstractSalesDayBookLine;
import tomoBay.model.dataTypes.financial.SalesOrderDayBook.concreteLineTypes.StandardInvoiceWithShipping;
import tomoBay.model.dataTypes.order.Order;
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
public final class StandardInvoiceWithShippingFactory implements
		AbstractSalesDayBookLineFactory
{

	/**
	 * 
	 */
	public StandardInvoiceWithShippingFactory()
	{super();}

	/* (non-Javadoc)
	 * @see tomoBay.model.dataTypes.financial.SalesOrderDayBook.factories.AbstractSalesDayBookLineFactory#make(tomoBay.model.dataTypes.order.Order)
	 */
	@Override
	public AbstractSalesDayBookLine make(Order order)
	{return new StandardInvoiceWithShipping(order);}

}

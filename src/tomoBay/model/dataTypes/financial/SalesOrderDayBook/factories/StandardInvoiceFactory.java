package tomoBay.model.dataTypes.financial.SalesOrderDayBook.factories;
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
import tomoBay.model.dataTypes.financial.SalesOrderDayBook.AbstractSalesDayBookLine;
import tomoBay.model.dataTypes.financial.SalesOrderDayBook.concreteLineTypes.StandardInvoice;
/**
 *
 * @author Jan P.C. Hanson
 *
 */
public final class StandardInvoiceFactory implements
		AbstractSalesDayBookLineFactory
{

	/**
	 * default ctor
	 */
	public StandardInvoiceFactory()
	{super();}

	/* (non-Javadoc)
	 * @see tomoBay.model.dataTypes.financial.SalesOrderDayBook.factories.AbstractSalesDayBookLineFactory#make()
	 */
	@Override
	public AbstractSalesDayBookLine make(Order order)
	{return new StandardInvoice(order);}

}

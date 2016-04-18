package tomoBay.model.dataTypes.financial.SalesOrderDayBook.concreteLineTypes;

import java.util.ArrayList;
import java.util.List;

import tomoBay.model.dataTypes.financial.SalesOrderDayBook.AbstractLineItem;
import tomoBay.model.dataTypes.financial.SalesOrderDayBook.AbstractSalesDayBookLine;
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
public class GSPInvoice extends AbstractSalesDayBookLine
{

	/**
	 * default ctor
	 */
	public GSPInvoice(Order order)
	{super(order);}

	/* (non-Javadoc)
	 * @see tomoBay.model.dataTypes.financial.SalesOrderDayBook.AbstractSalesDayBookLine#generateLineItems()
	 */
	@Override
	protected List<AbstractLineItem> generateLineItems()
	{
		List<AbstractLineItem> result = new ArrayList<AbstractLineItem>();
		
		for(int i = 0 ; i < super.orderInfo().noOfTransactions(); ++i)
		{
			for(int j = 0 ; j < super.orderInfo().transaction(i).listing().noOfParts() ; ++j)
			{
				result.add(new GSPInvoiceLine(this, i, j));
			}
		}
		return result;
	}
}

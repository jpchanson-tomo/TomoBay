package tomoBay.model.dataTypes.financial.SalesOrderDayBook.concreteLineTypes;
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
import java.util.ArrayList;
import java.util.List;

import tomoBay.model.dataTypes.financial.SalesOrderDayBook.AbstractLineItem;
import tomoBay.model.dataTypes.financial.SalesOrderDayBook.AbstractSalesDayBookLine;
import tomoBay.model.dataTypes.order.Order;
/**
 * This class represents a standard invoice without extra shipping.
 * @author Jan P.C. Hanson
 *
 */
public class StandardInvoice extends AbstractSalesDayBookLine
{
	/**
	 * Constructor creates a StandardInvoice object using the order parameter passed in here
	 * @param order the Order object to create this StandardInvoice from.
	 */
	public StandardInvoice(Order order)
	{super(order);}
	
	/**
	 * This method generates the array of AbstractLineItems that make up this StandardInvoice.
	 * @return List<AbstractLineItem> the Contents of the invoice. 
	 */
	protected final List<AbstractLineItem> generateLineItems()
	{
		List<AbstractLineItem> result = new ArrayList<AbstractLineItem>();
		
		for(int i = 0 ; i < super.orderInfo().noOfTransactions(); ++i)
		{
			for(int j = 0 ; j < super.orderInfo().transaction(i).listing().noOfParts() ; ++j)
			{
				result.add(new StandardInvoiceLine(this, i, j));
			}
		}
		return result;
	}
}

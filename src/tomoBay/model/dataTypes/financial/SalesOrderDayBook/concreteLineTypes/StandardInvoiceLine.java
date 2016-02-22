package tomoBay.model.dataTypes.financial.SalesOrderDayBook.concreteLineTypes;

import tomoBay.model.dataTypes.financial.GBP;
import tomoBay.model.dataTypes.financial.VAT;
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
import tomoBay.model.dataTypes.financial.SalesOrderDayBook.AbstractLineItem;
import tomoBay.model.dataTypes.financial.SalesOrderDayBook.AbstractSalesDayBookLine;

/**
 *
 * @author Jan P.C. Hanson
 *
 */
public class StandardInvoiceLine extends AbstractLineItem
{
	/**
	 * creates an invoiceLine using the transactionNo and partIndex provided
	 * @param transactionNo the index of the transaction to use.
	 * @param partIndex the partIndex within the specified Transaction.
	 */
	public StandardInvoiceLine(AbstractSalesDayBookLine invoice, int transactionNo, int partIndex)
	{super(invoice, transactionNo, partIndex);}

	/* (non-Javadoc)
	 * @see tomoBay.model.dataTypes.invoice.AbstractInvoiceLine#unitPrice()
	 */
	@Override
	protected int unitPrice(AbstractSalesDayBookLine invoice)
	{
		double costOfItem = invoice.orderInfo().transaction(super.transactionIndex_M).listing().part(super.partIndex).cost()
															*
							invoice.orderInfo().transaction(super.transactionIndex_M).listing().qty(super.partIndex);
		
		double totalCost = invoice.orderInfo().transaction(super.transactionIndex_M).listing().listingCost();
		double priceExVat = VAT.subtract(invoice.orderInfo().transaction(super.transactionIndex_M).transactionPrice());
		
		double result = (costOfItem/totalCost)*(priceExVat/super.quantity(invoice));
		return GBP.toPennies(result);
	}
}

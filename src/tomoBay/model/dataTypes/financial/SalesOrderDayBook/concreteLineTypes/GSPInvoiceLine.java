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
import tomoBay.model.dataTypes.financial.GBP;
import tomoBay.model.dataTypes.financial.VAT;
import tomoBay.model.dataTypes.financial.SalesOrderDayBook.AbstractLineItem;
import tomoBay.model.dataTypes.financial.SalesOrderDayBook.AbstractSalesDayBookLine;
/**
 *
 * @author Jan P.C. Hanson
 *
 */
public class GSPInvoiceLine extends AbstractLineItem
{

	/**
	 * 
	 */
	public GSPInvoiceLine(AbstractSalesDayBookLine invoice, int transactionNo, int partIndex)
	{super(invoice, transactionNo, partIndex);}

	/* (non-Javadoc)
	 * @see tomoBay.model.dataTypes.financial.SalesOrderDayBook.AbstractLineItem#unitPrice(tomoBay.model.dataTypes.financial.SalesOrderDayBook.AbstractSalesDayBookLine)
	 */
	@Override
	protected int unitPrice(AbstractSalesDayBookLine line)
	{
		double costOfItem = line.orderInfo().transaction(super.transactionIndex_M).listing().part(super.partIndex).cost()
																				*
				line.orderInfo().transaction(super.transactionIndex_M).listing().qty(super.partIndex);
		
		double totalCost = line.orderInfo().transaction(super.transactionIndex_M).listing().listingCost();
		double priceExVat = VAT.subtract(line.orderInfo().transaction(super.transactionIndex_M).transactionPrice());
		
		double result = (costOfItem/totalCost)*(priceExVat/super.quantity(line));
		
		System.out.println(GBP.fromPennies(GBP.toPennies(result)));
		System.out.println(line.orderInfo().shippingCost());
		return GBP.toPennies(result);
		
		//
		
	}

}

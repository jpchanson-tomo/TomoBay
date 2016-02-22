package tomoBay.model.dataTypes.financial.SalesOrderDayBook.concreteLineTypes;

import tomoBay.model.dataTypes.financial.GBP;
import tomoBay.model.dataTypes.financial.VAT;
import tomoBay.model.dataTypes.financial.SalesOrderDayBook.AbstractLineItem;
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
import tomoBay.model.dataTypes.financial.SalesOrderDayBook.AbstractSalesDayBookLine;

/**
 *
 * @author Jan P.C. Hanson
 *
 */
public final class StandardInvoiceShippingLine extends AbstractLineItem
{

	/**
	 * Instantiates this StandardInvoiceShippingLine and initialises it using the parameters 
	 * provided.
	 * @param line The AbstractSalesDayBookLine that this lineItem belongs to.
	 * @param transactionNo the transactionNo associated with this lineItem.
	 * @param partIndex the index of the part (within the order listing) that is associated with 
	 * this line item.
	 */
	public StandardInvoiceShippingLine(AbstractSalesDayBookLine line,
			int transactionNo, int partIndex)
	{super(line, transactionNo, partIndex);System.out.println("shipping invoice");}

	/**
	 * retrieve the invoiced quantity of the part to be invoiced in this line item
	 * @return int representing the quantity
	 */
	@Override
	public int quantity(AbstractSalesDayBookLine line) 
	{return 1;}
	
	/**
	 * retrieve the description of the invoiced part
	 * @return String containing a description of the line item
	 */
	@Override
	public String description(AbstractSalesDayBookLine line) 
	{return "Postage and Packaging";}
	
	/**
	 * retrieve the part number associated with the part that has been invoiced
	 * @return String containing the part number for this line item
	 */
	@Override
	public String partNo(AbstractSalesDayBookLine line) 
	{return "POSTAGE";}
	
	/* (non-Javadoc)
	 * @see tomoBay.model.dataTypes.financial.SalesOrderDayBook.AbstractLineItem#unitPrice(tomoBay.model.dataTypes.financial.SalesOrderDayBook.AbstractSalesDayBookLine)
	 */
	@Override
	protected int unitPrice(AbstractSalesDayBookLine invoice)
	{return GBP.toPennies(VAT.subtract(invoice.orderInfo().shippingCost()));}

}

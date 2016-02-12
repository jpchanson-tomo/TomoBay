package tomoBay.model.dataTypes.financial.SalesOrderDayBook;
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
public abstract class AbstractLineItem
{
	/**the index of the part(within a transaction) that this lineItem corresponds to**/
	protected final int partIndex;
	/**this index represents the transaction number that this lineItem corresponds to**/
	protected final int transactionIndex_M;
	/**the sale price (EX VAT) of this line item**/
	private int price_M;

	/**
	 * create an AbstractLineItem using the parameters provided
	 * @param transactionNo transaction number that this lineItem corresponds to
	 * @param partIndex the part(within a transaction) that this lineItem corresponds to
	 */
	public AbstractLineItem(AbstractSalesDayBookLine invoice, int transactionNo, int partIndex)
	{
		super();
		this.partIndex = partIndex;
		this.transactionIndex_M = transactionNo;
		this.price_M = this.unitPrice(invoice);
	}
	
	/**
	 * add or subtract the given amount of pennies from this line item
	 * @param pennyAdjustment (+ve) values for positive adjustment (-ve) values for negative adjustment.
	 */
	public void adjustPrice(AbstractSalesDayBookLine invoice, int pennyAdjustment)
	{this.price_M = price_M + pennyAdjustment;}
	
	/**
	 * retrieve the invoiced quantity of the part to be invoiced in this line item
	 * @return int representing the quantity
	 */
	public int quantity(AbstractSalesDayBookLine invoice) 
	{
		int result = invoice.orderInfo().transaction(this.transactionIndex_M).qtyPurchased()
												*
					invoice.orderInfo().transaction(this.transactionIndex_M).listing().qty(partIndex);
		return result;
	}
	
	/**
	 * retrieve the description of the invoiced part
	 * @return String containing a description of the line item
	 */
	public String description(AbstractSalesDayBookLine invoice) 
	{return invoice.orderInfo().transaction(this.transactionIndex_M).listing().part(this.partIndex).description();}
	
	/**
	 * retrieve the part number associated with the part that has been invoiced
	 * @return String containing the part number for this line item
	 */
	public String partNo(AbstractSalesDayBookLine invoice) 
	{return invoice.orderInfo().transaction(this.transactionIndex_M).listing().part(this.partIndex).partNo();}
	
	/**
	 * retrieve the price of the quantity of parts invoiced (EX VAT)
	 * @return String containing the price of the line item
	 */
	public int price() {return this.price_M;}
	
	/**
	 * implementation specific code used to work out the unit price for a specific line item
	 * @return int representing the unit price(in pennies) of this line item. 
	 */
	protected abstract int unitPrice(AbstractSalesDayBookLine invoice);
}

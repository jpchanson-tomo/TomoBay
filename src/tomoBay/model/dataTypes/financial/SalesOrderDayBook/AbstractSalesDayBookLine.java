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
import java.util.List;

import tomoBay.helpers.checkTime.CheckTime;
import tomoBay.model.dataTypes.financial.GBP;
import tomoBay.model.dataTypes.financial.VAT;
import tomoBay.model.dataTypes.order.Order;
/**
 * This class represents an Abstract sales day book entry, i.e. either a credit note or an invoice
 * and provides functionality to create these entries.
 * @author Jan P.C. Hanson
 *
 */
public abstract class AbstractSalesDayBookLine
{
	/**the order that this SalesDayBookLine applies to**/
	private final Order order_M;
	/**the list of lineItems that make up this SalesDayBookLine**/
	private final List<AbstractLineItem> lineItems_M;
	/**the date and time this object was instantiated**/
	private final String createdTime_M = CheckTime.currentTimeStamp();
	
	/**
	 * CONSTRUCTOR, creates a SalesDayBookLine based on the Order passed in as a parameter.
	 * @param order 
	 */
	public AbstractSalesDayBookLine(Order order)
	{
		super();
		this.order_M =  order;
		this.lineItems_M = this.generateLineItems();
	}
	
	/**
	 * retrieve a particular AbstractLineItem from the list of items that make up this
	 * AbstractSalesDayBookLine
	 * @param index the index pointing to the LineItem to retrieve
	 * @return AbstractLineItem containing the data that it represents.
	 */
	public AbstractLineItem getLineItem(int index)
	{return this.lineItems_M.get(index);}
	
	/**
	 * retrieve the number of line items that make up this SalesDayBookLine.
	 * @return int representing the number of AbstractLineItems.
	 */
	public int size(){return this.lineItems_M.size();}
	
	/**
	 * retrieve the order that this AbstractSalesDayBookLine refers to.
	 * @return Order containing all information on the order this object refers to.
	 */
	public Order orderInfo() {return this.order_M;}
	
	/**
	 * Retrieve the timestamp at which this object was created.
	 * @return String representing the timestamp in yyyy-mm-dd hh:mm:ss format
	 */
	public String createdDate() {return this.createdTime_M;}
	
	/**
	 * retrieve the total (including VAT) price of this order
	 * @return int representing the price (including VAT)
	 */
	public int totalIncVat(){return GBP.toPennies(this.order_M.totalPrice());}
	
	/**
	 * retrieve the total (excluding VAT) price for this order
	 * @return int representing the price (excluding vat)
	 */
	public int totalExVat(){return VAT.subtract(this.totalIncVat());}
	
	/**
	 * Implementation specific code for the generation of AbstractLineItems from the data 
	 * found in the Order that this object refers to.
	 * @return List<AbstractLineItems> the list of line items that make up this SalesDayBookLine.
	 */
	protected abstract List<AbstractLineItem> generateLineItems();
}

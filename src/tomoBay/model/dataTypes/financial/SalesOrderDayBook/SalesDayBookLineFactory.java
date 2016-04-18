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
import java.util.HashMap;
import java.util.Map;

import tomoBay.model.dataTypes.financial.SalesOrderDayBook.factories.AbstractSalesDayBookLineFactory;
import tomoBay.model.dataTypes.financial.SalesOrderDayBook.factories.GSPInvoiceFactory;
import tomoBay.model.dataTypes.financial.SalesOrderDayBook.factories.StandardInvoiceFactory;
import tomoBay.model.dataTypes.financial.SalesOrderDayBook.factories.StandardInvoiceWithShippingFactory;
import tomoBay.model.dataTypes.order.Order;
/**
 *
 * @author Jan P.C. Hanson
 *
 */
public class SalesDayBookLineFactory
{
	public enum SalesDayBookLineType {INVOICE, CREDIT}
	
	private enum SalesDayBookLineType_M	{STANDARD_INVOICE, STANDARD_INVOICE_WITH_SHIPPING, GSP_INVOICE}

	/**maps the type string to an action**/
	@SuppressWarnings("serial")
	private static final Map<SalesDayBookLineType_M, AbstractSalesDayBookLineFactory> lineMap_M
		= new HashMap<SalesDayBookLineType_M, AbstractSalesDayBookLineFactory>()
		{{
			put(SalesDayBookLineType_M.STANDARD_INVOICE, new StandardInvoiceFactory());
			put(SalesDayBookLineType_M.STANDARD_INVOICE_WITH_SHIPPING, new StandardInvoiceWithShippingFactory());
			put(SalesDayBookLineType_M.GSP_INVOICE, new GSPInvoiceFactory());
		}};
	
	/**
	 * default ctor
	 */
	public SalesDayBookLineFactory()
	{super();}

	/**
	 * create the requested AbstractSalesDayBookLine.
	 * @param type the type of AbstractSalesDayBookLine that you wish to create
	 * @param order The order that this AbstractSalesDayBookLine should be associated with.
	 * @return
	 */
	public static AbstractSalesDayBookLine make(SalesDayBookLineType type, Order order)
	{
		AbstractSalesDayBookLineFactory result;
		
		if(order.shippingCost() == 0) 
		{result = SalesDayBookLineFactory.lineMap_M.get(SalesDayBookLineType_M.STANDARD_INVOICE);}
		
		else if(order.buyer().street2().toUpperCase().contains("GSP"))
		{result = SalesDayBookLineFactory.lineMap_M.get(SalesDayBookLineType_M.GSP_INVOICE);}
		
		else if(order.shippingCost() > 0 ) 
		{result = SalesDayBookLineFactory.lineMap_M.get(SalesDayBookLineType_M.STANDARD_INVOICE_WITH_SHIPPING);}
		
		else {result = null;}
		
		return result.make(order);
	}
}

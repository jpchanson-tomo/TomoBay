package tomoBay.model.services.invoiceOrdersService;
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
import tomoBay.model.services.helpers.PickeableStatus;
import tomoBay.model.services.invoiceOrdersService.invoice.Invoice;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import tomoBay.helpers.TimeStampCompare;
import tomoBay.model.dataTypes.dbType.DBSchema;
import tomoBay.model.services.AbstractServiceState;

/**
 *
 * @author Jan P.C. Hanson
 *
 */
public final class OnRunning implements AbstractServiceState
{
	static Logger log = Logger.getLogger(OnRunning.class.getName());
	
	/**
	 * default ctor
	 */
	public OnRunning()
	{super();}

	/* (non-Javadoc)
	 * @see tomoBay.model.services.AbstractServiceState#execute()
	 */
	@Override
	public String execute()
	{
		log.warn("invoicing started");
		ValidUninvoicedOrderList orderList = new ValidUninvoicedOrderList();
		CalculateInvoiceStatus orderStatus = new CalculateInvoiceStatus();
		DB db = new DB();
		List<String[]> invoicedOrders = new ArrayList<String[]>();
		orderList.sortList();
		List<Map<DBSchema,String>> orders = orderList.get();
		
		for(Map<DBSchema,String> order : orders)
		{
			if(orderStatus.status(order.get(DBSchema.ORD_ORDER_ID))==PickeableStatus.PICKEABLE 
					&& TimeStampCompare.olderThan(30, order.get(DBSchema.ORD_CREATED_TIME))==false)
			{
				Invoice invoice = new Invoice(order.get(DBSchema.ORD_ORDER_ID));
				int invNo = invoice.generate();
				System.out.println(invNo);
				invoice.print();
				invoicedOrders.add(new String[] {order.get(DBSchema.ORD_ORDER_ID), 
						order.get(DBSchema.ORD_SALES_REC_NO), order.get(DBSchema.ORD_CREATED_TIME),
						String.valueOf(invoice.getWeight()), String.valueOf(invNo)});
				db.updateInvStatus(order.get(DBSchema.ORD_ORDER_ID));
			}
		}
		
		if(invoicedOrders.size() > 0)
		{new Mail().send(invoicedOrders);
		}
		return "invoicing finished: "+invoicedOrders.size() +" invoices raised.";
	}
}

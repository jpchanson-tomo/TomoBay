package tomoBay.model.services.invoiceOrderService;
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

import tomoBay.model.services.AbstractConfiguration;
import tomoBay.model.services.AbstractService;
import tomoBay.model.sql.queries.QueryInvoker;
import tomoBay.model.sql.queries.QueryInvoker.QueryType;
/**
 * This service runs through all the orders on the system that havent yet been invoiced and 
 * checks them against stock levels to see how invoiceable they are (invoiceable/partially
 * invoiceable/not invoiceable) and raises invoices for the ones which are invoiceable. It also
 * records the current invoiceability status for all orders not currently invoiced on the database.
 * @author Jan P.C. Hanson
 *
 */
public class InvoiceService implements AbstractService
{

	/* (non-Javadoc)
	 * @see openDMS.model.services.AbstractService#run()
	 */
	@Override
	public void run()
	{
		CalculateInvoiceStatus status = new CalculateInvoiceStatus();
		List<String[]> orders = QueryInvoker.execute(QueryType.SELECT_UNINVOICED_ORDERS, new String[] {});
		
		for(String[] order : orders)
		{
			String statusCode = String.valueOf(status.status(order[0]).getStatusCode());
			QueryInvoker.execute(QueryType.UPDATE_INVOICE_STATUS, new String[] {statusCode,order[0]});
			//generate invoice for this order number here
			System.out.println("trying to generate invoice for order number: " + order[0]);
		}
	}

	/* (non-Javadoc)
	 * @see openDMS.model.services.AbstractService#setConfig(openDMS.model.services.AbstractConfiguration)
	 */
	@Override
	public <E> void setConfig(AbstractConfiguration<E> config)
	{
		// TODO Auto-generated method stub

	}

}

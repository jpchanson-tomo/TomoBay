package tomoBay.model.winstock.payloads;
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

import tomoBay.model.winstock.payloads.componentFactories.CompanyComponentFactory;
import tomoBay.model.winstock.payloads.componentFactories.InvoiceNoComponentFactory;
import tomoBay.model.winstock.payloads.componentFactories.PackingListsComponentFactory;
import tomoBay.model.winstock.payloads.componentFactories.PrintCopiesComponentFactory;
import tomoBay.model.winstock.payloads.componentFactories.TypeComponentFactory;
/**
 * This class converts data into a byte[] payload that can be used passed to a ClientSocket
 * object.
 * @author Jan P.C. Hanson
 *
 */
public class PrintInvoicePayload extends AbstractPayload
{	
	
	/**
	 * default ctor
	 */
	public PrintInvoicePayload()
	{
		super();
		super.payloadBuilder_M.put(PayloadType.TYPE, new TypeComponentFactory());
		super.payloadBuilder_M.put(PayloadType.COMPANY, new CompanyComponentFactory());
		super.payloadBuilder_M.put(PayloadType.INVOICE_NO, new InvoiceNoComponentFactory());
		super.payloadBuilder_M.put(PayloadType.PRINT_COPIES, new PrintCopiesComponentFactory());
		super.payloadBuilder_M.put(PayloadType.PACKING_LISTS, new PackingListsComponentFactory());
	}
}
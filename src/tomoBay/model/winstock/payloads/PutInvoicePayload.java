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

import java.util.ArrayList;
import java.util.HashMap;

import tomoBay.model.winstock.payloads.componentFactories.AbstractComponentFactory;
import tomoBay.model.winstock.payloads.componentFactories.AddressComponentFactory;
import tomoBay.model.winstock.payloads.componentFactories.CityComponentFactory;
import tomoBay.model.winstock.payloads.componentFactories.CompanyComponentFactory;
import tomoBay.model.winstock.payloads.componentFactories.CountyComponentFactory;
import tomoBay.model.winstock.payloads.componentFactories.DescriptionComponentFactory;
import tomoBay.model.winstock.payloads.componentFactories.InStockComponentFactory;
import tomoBay.model.winstock.payloads.componentFactories.InvLinesComponentFactory;
import tomoBay.model.winstock.payloads.componentFactories.InvoiceAccountComponentFactory;
import tomoBay.model.winstock.payloads.componentFactories.NameComponentFactory;
import tomoBay.model.winstock.payloads.componentFactories.OrderNoComponentFactory;
import tomoBay.model.winstock.payloads.componentFactories.PartNoComponentFactory;
import tomoBay.model.winstock.payloads.componentFactories.PostCodeComponentFactory;
import tomoBay.model.winstock.payloads.componentFactories.PriceComponentFactory;
import tomoBay.model.winstock.payloads.componentFactories.QuantityComponentFactory;
import tomoBay.model.winstock.payloads.componentFactories.TypeComponentFactory;
/**
 * PutInvoiceMessage
 * ==================
 * |  DataType |   Label       |   Notes                    |
 * |:---------:|:-------------:|:--------------------------:|
 * |byte[4]    | Header        | "WSC0"                     |
 * |byte       | Type          | 34                         |
 * |byte       | Company       | 0=ford, 3=citroen, 8=fiat  |
 * |char       | AccountCode[9]| account identifier         |
 * |char       | ship1[51]     | name                       |
 * |char       | ship2[51]     | address line 1             |
 * |char       | ship3[51]     | address line 2             |
 * |char       | ship4[51]     | city                       |
 * |char       | ship5[51]     | county                     |
 * |char       | Postcode[10]  | postcode                   |
 * |char       | Order[21]     | order data                 |
 * |short      | Lines         | the # of invlines to follow|
 * |InvLine    | Il[1]         | see below table		    |
 * |byte       | terminator    | 0xAA (-86)                 |
 * 
 * InvLine
 * ========
 * |  DataType |   Label       |   Notes                   |
 * |:---------:|:-------------:|:-------------------------:|
 * |char	   |part[17]	   |the part number			   |
 * |char	   |Description[31]|the description of the part|
 * |int		   |Quantity	   |						   |
 * |int		   |Price		   |						   |
 * |int		   |InStock		   |						   |
 * @author Jan P.C. Hanson
 *
 */
public class PutInvoicePayload extends AbstractPayload
{
	
	
	/**
	 * default ctor
	 */
	public PutInvoicePayload()
	{
		super();
		result_M = new ArrayList<Byte>();
		
		super.payloadBuilder_M = new HashMap<PayloadType, AbstractComponentFactory>();
		payloadBuilder_M.put(PayloadType.TYPE, new TypeComponentFactory());
		payloadBuilder_M.put(PayloadType.COMPANY, new CompanyComponentFactory());
		payloadBuilder_M.put(PayloadType.INVOICE_ACCOUNT, new InvoiceAccountComponentFactory());
		payloadBuilder_M.put(PayloadType.NAME, new NameComponentFactory());
		payloadBuilder_M.put(PayloadType.ADDRESS1, new AddressComponentFactory());
		payloadBuilder_M.put(PayloadType.ADDRESS2, new AddressComponentFactory());
		payloadBuilder_M.put(PayloadType.CITY, new CityComponentFactory());
		payloadBuilder_M.put(PayloadType.COUNTY, new CountyComponentFactory());
		payloadBuilder_M.put(PayloadType.POSTCODE, new PostCodeComponentFactory());
		payloadBuilder_M.put(PayloadType.ORDER_NO, new OrderNoComponentFactory());
		payloadBuilder_M.put(PayloadType.INV_LINES, new InvLinesComponentFactory());
		payloadBuilder_M.put(PayloadType.PART_NO, new PartNoComponentFactory());
		payloadBuilder_M.put(PayloadType.DESCRIPTION, new DescriptionComponentFactory());
		payloadBuilder_M.put(PayloadType.QUANTITY, new QuantityComponentFactory());
		payloadBuilder_M.put(PayloadType.PRICE, new PriceComponentFactory());
		payloadBuilder_M.put(PayloadType.INSTOCK, new InStockComponentFactory());
	}
}

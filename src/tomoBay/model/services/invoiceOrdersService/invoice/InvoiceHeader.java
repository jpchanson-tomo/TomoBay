package tomoBay.model.services.invoiceOrdersService.invoice;
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
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import tomoBay.helpers.BrandToCode;
import tomoBay.model.dataTypes.DualList;
import tomoBay.model.winstock.payloads.PayloadType;
/**
 *
 * @author Jan P.C. Hanson
 *
 */
public class InvoiceHeader
{
	private List<String[]> dataFields_M;
	private Map<AddressType_M, String> addressLines_M;
	private enum AddressType_M {NAME, LINE1, LINE2, CITY, COUNTY, POSTCODE}
	
	
	/**
	 * default ctor
	 */
	public InvoiceHeader(List<String[]> rawData)
	{
		super();
		this.dataFields_M = rawData;
		this.addressLines_M = new HashMap<AddressType_M, String>();
		this.populateAddressLines();
	}
	
	public DualList<String, PayloadType> generate()
	{
		DualList<String, PayloadType> header = new DualList<String, PayloadType>();
		
		header.put("34", PayloadType.TYPE);
		header.put(this.getCompany(), PayloadType.COMPANY);
		header.put("EBAY", PayloadType.INVOICE_ACCOUNT);
		header.put(this.getName(), PayloadType.NAME);
		header.put(this.getAddress(InvoiceHeader.AddressType_M.LINE1), PayloadType.ADDRESS1);
		header.put(this.getAddress(InvoiceHeader.AddressType_M.LINE2), PayloadType.ADDRESS2);
		header.put(this.getAddress(InvoiceHeader.AddressType_M.CITY), PayloadType.CITY);
		header.put(this.getAddress(InvoiceHeader.AddressType_M.COUNTY), PayloadType.COUNTY);
		header.put(this.getAddress(InvoiceHeader.AddressType_M.POSTCODE), PayloadType.POSTCODE);
		header.put(this.getInvoiceNo(), PayloadType.ORDER_NO);
		return header;
	}
	
	/**
	 * 
	 * @return
	 */
	private String getCompany()
	{
		if		(BrandToCode.convert(this.dataFields_M.get(0)[6]).equals("F")) {return "0";}
		else if	(BrandToCode.convert(this.dataFields_M.get(0)[6]).equals("C")) {return "3";}
		else	{return "8";}
	}
	
	/**
	 * 
	 * @return
	 */
	private String getName()
	{return this.dataFields_M.get(0)[12].replaceAll("null", "");}
	
	/**
	 * 
	 * @param addressType
	 * @return
	 */
	private String getAddress(AddressType_M addressType)
	{	
		String result = this.addressLines_M.get(addressType);
		if (result.length() > 50)
		{
			return result.substring(0,50);
		}
		return result;
	}
	
	/**
	 * 
	 * @return
	 */
	private String getInvoiceNo()
	{return this.dataFields_M.get(0)[2];}
	
	/**
	 * 
	 */
	private void populateAddressLines()
	{
		this.addressLines_M.put(AddressType_M.LINE1, this.dataFields_M.get(0)[13]);
		this.addressLines_M.put(AddressType_M.LINE2, this.dataFields_M.get(0)[14]);
		this.addressLines_M.put(AddressType_M.CITY, this.dataFields_M.get(0)[15]);
		this.addressLines_M.put(AddressType_M.COUNTY, this.dataFields_M.get(0)[16]);
		this.addressLines_M.put(AddressType_M.POSTCODE, this.dataFields_M.get(0)[17]);
	}
}

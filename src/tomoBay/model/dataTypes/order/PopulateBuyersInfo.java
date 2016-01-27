package tomoBay.model.dataTypes.order;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
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
import java.util.Map;

/**
 *
 * @author Jan P.C. Hanson
 *
 */
public class PopulateBuyersInfo
{
	/**raw data**/
	private List<String[]> rawData_M;
	/**map to hold the address data**/
	private Map<OrderDataFields, String> address_M;
	
	/**
	 * 
	 */
	public PopulateBuyersInfo(List<String[]> rawData)
	{
		super();
		this.rawData_M = rawData;
		for(String[] data : this.rawData_M)
		this.populateBuyerFields();
	}
	
	public Map<OrderDataFields, String> getInfo()
	{return this.address_M;}
	
	/**
	 * populate the address_M map with the address data stored in rawData_M
	 */
	private void populateBuyerFields()
	{
		this.address_M = new HashMap<OrderDataFields, String>();
		this.address_M.put(OrderDataFields.EBAY_ID , this.rawData_M.get(0)[11]);
		this.address_M.put(OrderDataFields.NAME    , this.rawData_M.get(0)[12]);
		this.address_M.put(OrderDataFields.STREET1 , this.rawData_M.get(0)[13]);
		this.address_M.put(OrderDataFields.STREET2 , this.rawData_M.get(0)[14]);
		this.address_M.put(OrderDataFields.CITY    , this.rawData_M.get(0)[15]);
		this.address_M.put(OrderDataFields.COUNTY  , this.rawData_M.get(0)[16]);
		this.address_M.put(OrderDataFields.POSTCODE, this.rawData_M.get(0)[17]);
	}
}

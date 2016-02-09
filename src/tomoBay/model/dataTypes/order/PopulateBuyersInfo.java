package tomoBay.model.dataTypes.order;
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
import java.util.HashMap;
import java.util.List;
/**
 *
 * @author Jan P.C. Hanson
 *
 */
public final class PopulateBuyersInfo
{
	/**
	 * 
	 */
	public PopulateBuyersInfo()
	{super();}
	
	/**
	 * 
	 * @param rawData
	 * @return
	 */
	public static final Map<OrderDataFields, String> getInfo(List<String[]> rawData)
	{
		Map<OrderDataFields, String> address = new HashMap<OrderDataFields, String>();
		address.put(OrderDataFields.EBAY_ID , rawData.get(0)[11]);
		address.put(OrderDataFields.NAME    , rawData.get(0)[12]);
		address.put(OrderDataFields.STREET1 , rawData.get(0)[13]);
		address.put(OrderDataFields.STREET2 , rawData.get(0)[14]);
		address.put(OrderDataFields.CITY    , rawData.get(0)[15]);
		address.put(OrderDataFields.COUNTY  , rawData.get(0)[16]);
		address.put(OrderDataFields.POSTCODE, rawData.get(0)[17]);
		return address;
	}
}

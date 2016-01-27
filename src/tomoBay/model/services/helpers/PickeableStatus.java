package tomoBay.model.services.helpers;
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
/**
 * this enum defines the different status's and status codes for the state of an order with 
 * respect to invoiceability.
 * @author Jan P.C. Hanson
 *
 */
public enum PickeableStatus 
{
	/**an invoice is fully invoiceable or already invoiced**/
	PICKEABLE(0), 
	/**this order is partially invoiceable, probably due to some parts being out of stock**/
	PARTIAL(1), 
	/**it is not possible to invoice this order at the present time**/
	UNPICKEABLE(2), 
	/**there has been an error somewhere along the line.....dufus**/
	ERROR(3);

	/**map for converting ints back to enum constants**/
	@SuppressWarnings("serial")
	private static final Map<Integer, PickeableStatus> fromInt_M = new HashMap<Integer,PickeableStatus>()
	{{
		put(3, PickeableStatus.ERROR);
		put(2 , PickeableStatus.UNPICKEABLE);
		put(1 , PickeableStatus.PARTIAL);
		put(0 , PickeableStatus.PICKEABLE);
	}};
	
	/**holder for the status code**/
	private int status_M;
	
	/**size of the enum**/
	private static final int size = PickeableStatus.values().length;
	
	/**
	 * private ctor so enum can hold int values
	 */
	private PickeableStatus(int status)
	{this.status_M = status;}
	
	/**
	 * retrieve the status code for a particular constant
	 * @return integer status code
	 */
	public int getStatusCode()
	{return this.status_M;}
	
	/**
	 * 
	 * @param statusCode
	 * @return
	 */
	public static PickeableStatus fromInt(int statusCode)
	{return PickeableStatus.fromInt_M.get(statusCode);}
	
	/**
	 * gets the number of constants held in this enum
	 * @return integer denoting the size of the enum
	 */
	public static int size()
	{return PickeableStatus.size;}
}
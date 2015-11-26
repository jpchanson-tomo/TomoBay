package tomoBay.model.services.updateOrderStatusService;
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
import tomoBay.helpers.NoImports;
/**
 * This enum defines options for the various state variables in the database orders table, these
 * can be used by the UpdateOrderConfiguration to provide the service with appropriate data.
 * @author Jan P.C. Hanson
 *
 */
@SuppressWarnings("unused")
public enum OrderStatus
{
	/****/
	PICKING_STARTED(10),
	/****/
	PICKING_FINISHED(11),
	/****/
	PACKING_STARTED(20),
	/****/
	PACKING_FINISHED(21),
	/****/
	SHIPPING_STARTED(30),
	/****/
	SHIPPING_FINISHED(31);
	
	/**holder for the status code**/
	private int status_M;
	
	/**
	 * private ctor so enum can hold int values
	 */
	private OrderStatus(int status)
	{this.status_M = status;}
	
	/**
	 * retrieve the status code for a particular constant
	 * @return integer status code
	 */
	public int getStatusCode()
	{return this.status_M;}
}

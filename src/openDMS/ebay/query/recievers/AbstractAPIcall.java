package openDMS.ebay.query.recievers;

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


/**
 * This is the abstract base class for all the recievers in this command pattern, it provides
 * a common way to initialise ebay API calls
 * @author Jan P.C. Hanson
 *
 */
public abstract class AbstractAPIcall
{
	/**holder for the user token string provided in the construction of this object**/
	protected String usrToken_M;
	/**holder for the server string provided in the construction of this object**/
	protected String server_M;
	
		
	/**
	 * this constructor initialises the Abstract query with a usr token and server string,
	 * these are needed so that it can properly assign an ApiContext to the call.
	 * @param usrToken very long string of digit obtained from ebay
	 * @param server string representing the server that the API Calls should be submitted to.
	 */
	protected AbstractAPIcall(String usrToken, String server)
	{
		super();
		this.usrToken_M = usrToken;
		this.server_M = server;
	}

}

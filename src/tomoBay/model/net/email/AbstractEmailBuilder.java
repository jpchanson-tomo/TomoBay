package tomoBay.model.net.email;
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
 *  This is the abstract base class for all the concrete email builders. Each derived class
 *  represents a different mail server.
 * @author Jan P.C. Hanson
 *
 */
public abstract class AbstractEmailBuilder
{
	/**holder for Sending Mail server**/
	protected MailServerSend mailServer_M;
	/**Holder for email object**/
	protected Email email_M;
	
	/**
	 * default constructor
	 */
	protected AbstractEmailBuilder()
	{
		super();
		this.mailServer_M = new MailServerSend();
	}
	
	/**
	 * populates the MailServerSend object with a specific configuration
	 */
	protected abstract void buildMailServerSendConnection();
	
	/**
	 * builds the Email object
	 */
	protected void buildEmail()
	{this.email_M = new Email();}
}

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
import gnu.trove.map.hash.THashMap;

import java.util.Map;
/**
 * This class represents the specifics necessary for initialising a Gmail send connection.
 * @author Jan P.C. Hanson
 *
 */
public final class GmailBuilder extends AbstractEmailBuilder
{
	/**This map contains all the values to be input into the MailServerSend properties**/
	private static final Map<String, String> properties = new THashMap<String, String>()
			{{
				put("mail.smtp.port", "587");
				put("mail.smtp.auth", "true");
				put("mail.smtp.starttls.enable", "true");
			}};
	/**String containing the transport protocol**/		
	private static final String transportProtocol = "smtp";
	/**String containing the Servers IP address**/
	private static final String serverIP = transportProtocol+".gmail.com"; 
	
	/**
	 * default constructor, creates an AbstractEmailBuilder that is used to define a 
	 *  Gmail type email.
	 */
	public GmailBuilder()
	{super();}

	/* (non-Javadoc)
	 * @see tomoBay.model.net.email.AbstractEmailBuilder#buildGmailConnection()
	 */
	@Override
	protected void buildMailServerSendConnection()
	{
		super.mailServer_M.transportProtocol = GmailBuilder.transportProtocol;
		super.mailServer_M.serverIP_M = GmailBuilder.serverIP;
		
		for(Map.Entry<String, String> property : GmailBuilder.properties.entrySet())
		{super.mailServer_M.mailServerProperties.put(property.getKey(), property.getValue());}
	}
}
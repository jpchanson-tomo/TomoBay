package tomoBay.model.winstock.commands;
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
import java.io.IOException;
import java.net.UnknownHostException;

import tomoBay.exceptions.PayloadException;
import tomoBay.model.dataTypes.DualList;
import tomoBay.model.net.ClientSocket;
import tomoBay.model.winstock.WinstockConfig;
import tomoBay.model.winstock.payloads.PayloadType;
import tomoBay.model.winstock.response.AbstractWinstockCommandResponse;
/**
 * This is the abstract base class for all Winstock commands, and acts as the abstract command
 * in a GoF style command pattern.
 * 
 * @author Jan P.C. Hanson
 * @see https://dzone.com/articles/design-patterns-command
 *
 */
public abstract class AbstractWinstockCommand
{
	/**client socket connection**/
	protected WinstockConfig config_M;
	/**the configuration details**/
	protected ClientSocket winstockConnection_M;
	
	/**
	 * default ctor, does preliminary initailisation of the config object and socket connection
	 * to Winstock.
	 * @throws UnknownHostException
	 * @throws IOException
	 */
	protected AbstractWinstockCommand() throws UnknownHostException, IOException
	{
		this.config_M = new WinstockConfig();
		this.winstockConnection_M = new ClientSocket(this.config_M.getMachineName(), this.config_M.getPort());
	}
	
	/**
	 * this method executes the AbstractWinstockCommand specific to the derived type.
	 * @return AbstractWinstockCommandRepsonse containing the results of the command.
	 */
	public abstract AbstractWinstockCommandResponse execute(DualList<String, PayloadType> commandInfo)
			throws IOException, PayloadException;
}

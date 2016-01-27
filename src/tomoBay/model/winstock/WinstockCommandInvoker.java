package tomoBay.model.winstock;
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
import java.util.HashMap;
import java.util.Map;

import tomoBay.exceptions.PayloadException;
import tomoBay.model.dataTypes.DualList;
import tomoBay.model.winstock.commandFactories.AbstractWinstockCommandFactory;
import tomoBay.model.winstock.commandFactories.PrintInvoiceCommandFactory;
import tomoBay.model.winstock.commandFactories.PutInvoiceCommandFactory;
import tomoBay.model.winstock.payloads.PayloadType;
import tomoBay.model.winstock.response.AbstractWinstockCommandResponse;
/**
 * This class acts as the Invoker in a GoF style command pattern, it is responsible for the
 * execution of AbstractWinstockCommands. In this case it is also a factory and as such is 
 * responsible for the creation of these concrete command objects. The internal Enum defines the
 * acceptable range of commands that can be created.
 * 
 * @author Jan P.C. Hanson
 * 
 * @see https://dzone.com/articles/design-patterns-command
 * @see https://dzone.com/articles/design-patterns-factory
 *
 */
public class WinstockCommandInvoker
{
	/**defensive enum used to limit the amount of acceptable inputs to this invoker**/
	public enum WinstockCommandTypes
		{
			/** represents a PutInvoiceCommand @see {@link tomoBay.model.winstock.commands.PutInvoiceCommand}**/
			PutInvoice,
			/** represents a PrintInvoiceCommand @see {@link tomoBay.model.winstock.commands.PrintInvoiceCommand}**/
			PrintInvoice
		}
	
	/**
	 * internal Map responsible for associating a WinstockCommandTypes with its corresponding
	 * AbstractWinstockCommandFactory object.
	 **/
	@SuppressWarnings("serial")
	private static final Map<WinstockCommandTypes, AbstractWinstockCommandFactory> factoryMap_M
	= new HashMap<WinstockCommandTypes, AbstractWinstockCommandFactory>()
		{{
			put(WinstockCommandInvoker.WinstockCommandTypes.PutInvoice, new PutInvoiceCommandFactory());
			put(WinstockCommandInvoker.WinstockCommandTypes.PrintInvoice, new PrintInvoiceCommandFactory());
		}};
	
	/**
	 * This method executes the AbstractWinstockCommand that the user has requested.
	 * @param commandType contains the info to @see{@link tomoBay.model.dataTypes.DualList}
	 * @see {@link tomoBay.model.winstock.WinstockCommandInvoker.WinstockCommandTypes}
	 * @return AbstractWinstockCommandResponse containing the servers response to this command.
	 * @throws IOException 
	 * @throws UnknownHostException 
	 * @throws PayloadException 
	 */
	public static AbstractWinstockCommandResponse execute
	(WinstockCommandInvoker.WinstockCommandTypes commandType, DualList<String, PayloadType> commandInfo) 
			throws UnknownHostException, IOException, PayloadException
	{return WinstockCommandInvoker.factoryMap_M.get(commandType).make().execute(commandInfo);}
}

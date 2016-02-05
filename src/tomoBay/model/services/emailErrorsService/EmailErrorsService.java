package tomoBay.model.services.emailErrorsService;
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

import org.w3c.dom.NodeList;

import tomoBay.exceptions.ServiceException;
import tomoBay.helpers.XMLParser;
import tomoBay.model.services.AbstractConfiguration;
import tomoBay.model.services.AbstractService;
/**
 * This service is responsible for generating a list of erroneous items that exist within the 
 * database and emailing it to appropriate parties.
 * @author Jan P.C. Hanson
 *
 */
public final class EmailErrorsService extends AbstractService
{
	/****/
	private Map<String, emailDataType> mailData_M;
	/****/
	protected enum emailDataType
							{
								TO,
								CC,
								BCC,
								SUBJECT,
								MESSAGE
							}

	public EmailErrorsService()
	{super();}

	/* (non-Javadoc)
	 * @see tomoBay.model.services.AbstractService#setConfig(tomoBay.model.services.AbstractConfiguration)
	 */
	@Override
	public <E> void setConfig(AbstractConfiguration<E> config)
	{
		this.mailData_M = new HashMap<String, emailDataType>();
		String xmlData = (String) config.configure();
		for (emailDataType type : emailDataType.values())
		{
			NodeList nodes = XMLParser.parseAll(type.toString(), xmlData);
			for(int i = 0 ; i < nodes.getLength() ; ++i)
			{
				if (this.mailData_M.containsKey(nodes.item(i).getTextContent()))
				{throw new ServiceException("\""+nodes.item(i).getTextContent()+"\" in \""+type+"\""+" is a duplicate of another field!!!" );}
				this.mailData_M.put(nodes.item(i).getTextContent(), type);	
			}
		}
	}

	/* (non-Javadoc)
	 * @see tomoBay.model.services.AbstractService#onRunning()
	 */
	@Override
	protected String onRunning() throws ServiceException
	{return new OnRunning(this.mailData_M).execute();}

	/* (non-Javadoc)
	 * @see tomoBay.model.services.AbstractService#onPaused()
	 */
	@Override
	protected String onPaused() throws ServiceException
	{return "Email Errors Paused";}

	/* (non-Javadoc)
	 * @see tomoBay.model.services.AbstractService#onStopped()
	 */
	@Override
	protected String onStopped() throws ServiceException
	{return "Server Stopped";}

	/* (non-Javadoc)
	 * @see tomoBay.model.services.AbstractService#onError()
	 */
	@Override
	protected String onError() throws ServiceException
	{return "Server Error";}
}

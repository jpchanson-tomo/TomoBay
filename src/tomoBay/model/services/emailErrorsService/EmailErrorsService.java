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
public class EmailErrorsService implements AbstractService
{
	/****/
	private Map<String, emailDataType> mailData_M;
	/****/
	enum emailDataType
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
	 * @see tomoBay.model.services.AbstractService#run()
	 */
	@Override
	public void run() throws ServiceException
	{	//make sure the service has been configured
		if (this.mailData_M == null) {throw new ServiceException("no AbstractConfiguration object set");}
		ErrorsList errors = new ErrorsList();
		
		if (errors.exist())
		{
			EmailErrorsMailActions email = new EmailErrorsMailActions();
			EmailErrorsDataFormat format = new EmailErrorsDataFormat();
			
			email.loadData(this.mailData_M);
			String message = format.asHTML(errors.get());
			email.addMessage(message);
			
			email.send();
		}
	}

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

}

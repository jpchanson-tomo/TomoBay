package tomoBay.model.services.emailErrorsService;
import java.util.Map;

import org.apache.log4j.Logger;



import tomoBay.exceptions.ServiceException;
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
import tomoBay.model.services.AbstractServiceState;
import tomoBay.model.services.emailErrorsService.EmailErrorsService.emailDataType;
/**
 *
 * @author Jan P.C. Hanson
 *
 */
public final class OnRunning implements AbstractServiceState
{
	static Logger log = Logger.getLogger(EmailErrorsService.class.getName());
	/****/
	private Map<String, emailDataType> mailData_M;
	
	/**
	 * 
	 */
	public OnRunning(Map<String, emailDataType> mailData)
	{
		super();
		this.mailData_M = mailData;
	}

	/* (non-Javadoc)
	 * @see tomoBay.model.services.AbstractServiceState#execute()
	 */
	@Override
	public String execute()
	{
		log.warn("email errors started");
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
			log.warn("Email containing errors sent");
		}
		return "email errors finished";
	}
}

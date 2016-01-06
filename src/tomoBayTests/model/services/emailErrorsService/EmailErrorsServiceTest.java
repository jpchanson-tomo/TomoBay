package tomoBayTests.model.services.emailErrorsService;
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
import tomoBay.model.services.ServiceFactory;
import tomoBay.model.services.TriggerService;
import tomoBay.model.services.ServiceFactory.ServiceType;
import tomoBay.model.services.emailErrorsService.EmailErrorsConfig;
/**
 *
 * @author Jan P.C. Hanson
 *
 */
public class EmailErrorsServiceTest
{
	public static void main(String[] args) throws Exception
	{
		System.setProperty("Log4jContextSelector", "org.apache.logging.log4j.core.async.AsyncLoggerContextSelector");
		
		
		String data = "<EMAIL>"
					+ "<TO>tomomotorbay@gmail.com</TO>"
					+ "<SUBJECT>ERRORS TO FIX!!!!!</SUBJECT>"
					+ "</EMAIL>";
		TriggerService.start(ServiceFactory.make(
												ServiceType.EMAIL_ERRORS_SERVICE,
												new EmailErrorsConfig().configure(data)
												));
		
	}
}

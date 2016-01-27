package tomoBay.model.services.reScanErrorsService;
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
import java.util.List;

import tomoBay.model.services.AbstractConfiguration;
import tomoBay.model.services.AbstractService;
/**
 *
 * @author Jan P.C. Hanson
 *
 */
public class ReScanErrorsService implements AbstractService
{
	/**
	 * default ctor.
	 */
	public ReScanErrorsService()
	{super();}

	/* (non-Javadoc)
	 * @see tomoBay.model.services.AbstractService#run()
	 */
	@Override
	public String call()
	{
		System.out.println("rescan errors started");
		ReScanErrorsDBActions database = new ReScanErrorsDBActions();
		ReScanErrorsWinstockActions winstock = new ReScanErrorsWinstockActions();
		
		List<String[]> errorList = database.retrieveAllErrorItems();
		
		for (String[] error : errorList)
		{
			ItemSpecifics item = new ItemSpecifics(error[0]);
			if (winstock.partNoHasError(item) == false)
			{database.updateDBwithCorrectedInfo(item);}
		}
		return "rescan errors finished";
	}

	/* (non-Javadoc)
	 * @see tomoBay.model.services.AbstractService#setConfig(tomoBay.model.services.AbstractConfiguration)
	 */
	@Override
	public <E> void setConfig(AbstractConfiguration<E> config)
	{/** TODO Auto-generated method stud**/}
}

package tomoBay.presenters.presenterActions.concreteActions;

import tomoBay.model.sql.queries.QueryInvoker;
import tomoBay.model.sql.queries.QueryInvoker.QueryType;
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
import tomoBay.presenters.presenterActions.AbstractPresenterAction;

/**
 *
 * @author Jan P.C. Hanson
 *
 */
public class MarkAsUninvoiced implements AbstractPresenterAction
{
	/**
	 * default ctor
	 */
	public MarkAsUninvoiced()
	{super();}

	/* (non-Javadoc)
	 * @see tomoBay.presenters.presenterActions.AbstractPresenterAction#execute()
	 */
	@Override
	public String execute(String data)
	{
		String invoiced = "0";
		
		String result= 
		QueryInvoker.execute(QueryType.UPDATE_INVOICE_STATUS_SRN, new String[] {invoiced,data})
		.get(0)[0];
		
		if (result.equalsIgnoreCase("1")) {result = "DONE";}
		else {result = "Sales Record Number does not exist .... or Jans done something wrong :(";}
		
		return result;
	}
}
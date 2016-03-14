package tomoBay.presenters.presenterActions.concreteActions;

import tomoBay.model.dataTypes.heteroTypeContainer.ClassRef;
import tomoBay.model.dataTypes.heteroTypeContainer.HeteroFieldContainer;
import tomoBay.model.eBayAPI.EbayAccounts;
import tomoBay.model.sql.queries.ModifyQueryInvoker;
import tomoBay.model.sql.queries.ModifyQueryInvoker.QueryType;
import tomoBay.model.sql.schema.nonDBFields.NonDBFields;
import tomoBay.model.sql.schema.ordersTable.OrdersTable;
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
		try 
		{
			int invoiced = 0;
			int listingID = Integer.parseInt(data.split("\\|")[0]);
			int accountID = EbayAccounts.id(data.split("\\|")[1]);
			
			HeteroFieldContainer params = new HeteroFieldContainer();
			params.add(OrdersTable.SALES_REC_NO, listingID);
			params.add(OrdersTable.ACCOUNT, accountID);
			params.add(OrdersTable.INVOICED, invoiced);
			
			int resultCode= 
						ModifyQueryInvoker.execute(QueryType.UPDATE_INVOICE_STATUS_SRN, params)
																	.get(NonDBFields.RESULT_CODE, ClassRef.INTEGER);
			String result="";
			if (resultCode==1) {result = "DONE";}
			else {result = "SalesRecNo or account does not exist .... or Jans done something wrong 8(";}
			
			return result;
		}
		catch(NullPointerException e){return "account probably does not exist, check spelling";}
	}
}
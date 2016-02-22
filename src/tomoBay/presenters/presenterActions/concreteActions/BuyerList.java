package tomoBay.presenters.presenterActions.concreteActions;

import java.util.Iterator;
import java.util.List;

import tomoBay.model.dataTypes.json.JSONentity_array;
import tomoBay.model.dataTypes.json.JSONentity_object;
import tomoBay.model.sql.queries.QueryInvoker;
import tomoBay.model.sql.queries.QueryInvoker.QueryType;
import tomoBay.presenters.presenterActions.AbstractPresenterAction;
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
import tomoBay.security.SaneInput;

/**
 *
 * @author Jan P.C. Hanson
 *
 */
public final class BuyerList implements AbstractPresenterAction
{

	/**
	 * 
	 */
	public BuyerList()
	{super();}

	/* (non-Javadoc)
	 * @see tomoBay.presenters.presenterActions.AbstractPresenterAction#execute(java.lang.String)
	 */
	@Override
	public String execute(String data)
	{
		String results = formatResults(BuyerList.getRawData());
		return new JSONentity_object().addBranch("tableData", new JSONentity_array().addPreFormatted("tableData", results)).toString();
	}

	/**
	 * retrieve a list of buyers and associated information from the database
	 * @return List<String[]> containing the list each buyer is an element in the list, each 
	 * element in the string array is a data field for that buyer.
	 */
	private static final List<String[]> getRawData()
	{return QueryInvoker.execute(QueryType.SELECT_EBAY_BUYERS, new String[] {});}
	
	/**
	 * format the results of the query as a JSON string
	 * @param buyers the results from the query
	 * @return String JSON encoded results.
	 */
	private static final String formatResults(List<String[]> buyers)
	{
		String results="";
		Iterator<String[]> iter = buyers.iterator();
		for(String[] buyer : buyers)
		{
			results += new JSONentity_object()
							.addLeaf("BuyerID", SaneInput.json(buyer[0]))
							.addLeaf("Name", SaneInput.json(buyer[1]))
							.toString();
			iter.next();
			if(iter.hasNext()) {results+= ",";}
		}
		
		return results;
	}
}

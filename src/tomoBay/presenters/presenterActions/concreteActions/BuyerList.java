package tomoBay.presenters.presenterActions.concreteActions;

import java.util.Iterator;
import java.util.List;

import tomoBay.model.dataTypes.heteroTypeContainer.ClassRef;
import tomoBay.model.dataTypes.heteroTypeContainer.HeteroFieldContainer;
import tomoBay.model.dataTypes.json.JSONentity_array;
import tomoBay.model.dataTypes.json.JSONentity_object;
import tomoBay.model.sql.framework.SelectQueryInvoker;
import tomoBay.model.sql.framework.SelectQueryInvoker.SelectQueryTypeNoParams;
import tomoBay.model.sql.schema.buyerTable.BuyerTable;
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
	private static final List<HeteroFieldContainer> getRawData()
	{return SelectQueryInvoker.execute(SelectQueryTypeNoParams.SELECT_EBAY_BUYERS);}
	
	/**
	 * format the results of the query as a JSON string
	 * @param buyers the results from the query
	 * @return String JSON encoded results.
	 */
	private static final String formatResults(List<HeteroFieldContainer> buyers)
	{
		String results="";
		Iterator<HeteroFieldContainer> iter = buyers.iterator();
		for(HeteroFieldContainer buyer : buyers)
		{
			results += new JSONentity_object()
							.addLeaf("BuyerID", SaneInput.json(buyer.get(BuyerTable.BUYERID, ClassRef.STRING)))
							.addLeaf("Name", SaneInput.json(buyer.get(BuyerTable.NAME, ClassRef.STRING)))
							.toString();
			iter.next();
			if(iter.hasNext()) {results+= ",";}
		}
		
		return results;
	}
}

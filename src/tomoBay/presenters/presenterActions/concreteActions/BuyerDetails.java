package tomoBay.presenters.presenterActions.concreteActions;

import java.util.List;

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
public final class BuyerDetails implements AbstractPresenterAction
{

	/**
	 * default ctor
	 */
	public BuyerDetails()
	{super();}

	/* (non-Javadoc)
	 * @see tomoBay.presenters.presenterActions.AbstractPresenterAction#execute(java.lang.String)
	 */
	@Override
	public String execute(String data)
	{
		List<String[]> rawData = BuyerDetails.getRawData(data);
		
		return new JSONentity_object()
									.addLeaf("buyerID", SaneInput.json(rawData.get(0)[0]))
									.addLeaf("name", SaneInput.json(rawData.get(0)[1]))
									.addLeaf("street1", SaneInput.json(rawData.get(0)[2]))
									.addLeaf("street2", SaneInput.json(rawData.get(0)[3]))
									.addLeaf("county", SaneInput.json(rawData.get(0)[4]))
									.addLeaf("city", SaneInput.json(rawData.get(0)[5]))
									.addLeaf("postcode", SaneInput.json(rawData.get(0)[6]))
									.addLeaf("email", SaneInput.json(rawData.get(0)[7]))
									.addLeaf("phone", SaneInput.json(rawData.get(0)[8]))
									.toString();
	}

	
	private static final List<String[]> getRawData(String buyerID)
	{return QueryInvoker.execute(QueryType.SELECT_EBAY_BUYER, new String[] {buyerID});}
}

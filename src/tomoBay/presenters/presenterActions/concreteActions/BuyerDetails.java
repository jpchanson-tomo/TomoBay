package tomoBay.presenters.presenterActions.concreteActions;

import java.util.List;

import tomoBay.model.dataTypes.heteroTypeContainer.ClassRef;
import tomoBay.model.dataTypes.heteroTypeContainer.HeteroFieldContainer;
import tomoBay.model.dataTypes.json.JSONentity_object;
import tomoBay.model.sql.queries.SelectQueryInvoker;
import tomoBay.model.sql.queries.SelectQueryInvoker.SelectQueryTypeParams;
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
		List<HeteroFieldContainer> db = BuyerDetails.getRawData(data);
		
		return new JSONentity_object()
									.addLeaf("buyerID", SaneInput.json(db.get(0).get(BuyerTable.BUYERID, ClassRef.STRING)))
									.addLeaf("name", SaneInput.json(db.get(0).get(BuyerTable.NAME, ClassRef.STRING)))
									.addLeaf("street1", SaneInput.json(db.get(0).get(BuyerTable.STREET1, ClassRef.STRING)))
									.addLeaf("street2", SaneInput.json(db.get(0).get(BuyerTable.STREET2, ClassRef.STRING)))
									.addLeaf("county", SaneInput.json(db.get(0).get(BuyerTable.COUNTY, ClassRef.STRING)))
									.addLeaf("city", SaneInput.json(db.get(0).get(BuyerTable.CITY, ClassRef.STRING)))
									.addLeaf("postcode", SaneInput.json(db.get(0).get(BuyerTable.POSTCODE, ClassRef.STRING)))
									.addLeaf("email", SaneInput.json(db.get(0).get(BuyerTable.EMAIL, ClassRef.STRING)))
									.addLeaf("phone", SaneInput.json(db.get(0).get(BuyerTable.PHONE, ClassRef.STRING)))
									.toString();
	}
	
	/**
	 * 
	 * @param buyerID
	 * @return
	 */
	private static final List<HeteroFieldContainer> getRawData(String buyerID)
	{
		HeteroFieldContainer param = new HeteroFieldContainer();
		param.add(BuyerTable.BUYERID, buyerID);
		return SelectQueryInvoker.execute(SelectQueryTypeParams.SELECT_EBAY_BUYER, param);
	}
}

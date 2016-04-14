package tomoBay.model.sql.queries.concreteQueries.update;
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
import java.sql.SQLException;

import tomoBay.model.dataTypes.heteroTypeContainer.HeteroFieldContainer;
import tomoBay.model.sql.framework.QueryUtility;
import tomoBay.model.sql.framework.queryTypes.modify.AbstractModifyQueryParams;
import tomoBay.model.sql.schema.buyerTable.BuyerTable;
/**
 * This class represents an sql query that updates a record the buyer table in the database with new
 * information.
 * 
 *  This query requires the following parameters:
 *  - BuyerTable.NAME
 *  - BuyerTable.STREET1
 *  - BuyerTable.STREET2
 *  - BuyerTable.CITY
 *  - BuyerTable.COUNTY
 *  - BuyerTable.POSTCODE
 *  - BuyerTable.EMAIL
 *  - BuyerTable.PHONE
 *  - BuyerTable.BUYERID
 *  
 *  These should be stored in a HeteroFieldContainer and passed to the execute(HeteroFieldContainer parameters)
 *  in order to run the query.
 *  
 * @author Jan P.C. Hanson
 *
 */
public final class UpdateEbayBuyer extends AbstractModifyQueryParams
{
	/**SQL query string**/
	private static final String query = "UPDATE ebay_buyers SET name=?,street1=?,street2=?, city=?,county=?,"
							+ "postcode=?, email=?, phoneNo=? WHERE buyerID=?;";
	//
	/**
	 * default constructor
	 */
	public UpdateEbayBuyer()
	{super();}

	/* (non-Javadoc)
	 * @see tomoBay.model.sql.framework.queryTypes.modify.AbstractModifyQueryParams#queryString()
	 */
	@Override
	protected String queryString()
	{return UpdateEbayBuyer.query;}

	/* (non-Javadoc)
	 * @see tomoBay.model.sql.framework.queryTypes.modify.AbstractModifyQueryParams#setParameters(tomoBay.model.dataTypes.heteroTypeContainer.HeteroFieldContainer)
	 */
	@Override
	protected void setParameters(HeteroFieldContainer parameter) throws ClassCastException, SQLException
	{
		QueryUtility.setVARCHARParam(this, parameter, BuyerTable.NAME, 1);
		QueryUtility.setVARCHARParam(this, parameter, BuyerTable.STREET1, 2);
		QueryUtility.setVARCHARParam(this, parameter, BuyerTable.STREET2, 3);
		QueryUtility.setVARCHARParam(this, parameter, BuyerTable.CITY, 4);
		QueryUtility.setVARCHARParam(this, parameter, BuyerTable.COUNTY, 5);
		QueryUtility.setVARCHARParam(this, parameter, BuyerTable.POSTCODE, 6);
		QueryUtility.setVARCHARParam(this, parameter, BuyerTable.EMAIL, 7);
		QueryUtility.setVARCHARParam(this, parameter, BuyerTable.PHONE, 8);
		QueryUtility.setVARCHARParam(this, parameter, BuyerTable.BUYERID, 9);
	}
}
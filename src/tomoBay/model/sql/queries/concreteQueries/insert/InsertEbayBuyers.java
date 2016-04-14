package tomoBay.model.sql.queries.concreteQueries.insert;
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
 * This class represents a query that inserts buyer details into the database
 * 
 * This query requires the following parameters:
 * - BuyerTable.BUYERID
 * - BuyerTable.NAME
 * - BuyerTable.STREET1
 * - BuyerTable.STREET2
 * - BuyerTable.CITY
 * - BuyerTable.COUNTY
 * - BuyerTable.POSTCODE
 * - BuyerTable.EMAIL
 * - BuyerTable.PHONE
 * 
 * These parameters should be stored in a HeteroFieldContainer and passed to the execute(HeteroFieldContainer parameters) 
 * method when you wish to run the query
 * 
 * @author Jan P.C. Hanson
 *
 */
public final class InsertEbayBuyers extends AbstractModifyQueryParams
{
	/**SQL query string**/
	private static final String query ="INSERT IGNORE INTO ebay_buyers "
			+ "(buyerID, name, street1, street2, city, county, postcode, email, phoneNo)"
			+ "VALUES (?,?,?,?,?,?,?,?,?) "
			+ "ON DUPLICATE KEY UPDATE buyerID=values(buyerID), name=values(name), "
			+ "street1=values(street1), street2=values(street2), city=values(city), "
			+ "county=values(county), postcode=values(postcode), email=values(email), "
			+ "phoneNo=values(phoneNo);";
	
	/**
	 * default constructor
	 */
	public InsertEbayBuyers()
	{super();}
	
	/* (non-Javadoc)
	 * @see tomoBay.model.sql.framework.queryTypes.modify.AbstractModifyQueryParams#queryString()
	 */
	@Override
	protected String queryString()
	{return InsertEbayBuyers.query;}

	/* (non-Javadoc)
	 * @see tomoBay.model.sql.framework.queryTypes.modify.AbstractModifyQueryParams#setParameters(tomoBay.model.dataTypes.heteroTypeContainer.HeteroFieldContainer)
	 */
	@Override
	protected void setParameters(HeteroFieldContainer parameter) throws ClassCastException, SQLException
	{
		QueryUtility.setVARCHARParam(this, parameter, BuyerTable.BUYERID, 1);
		QueryUtility.setVARCHARParam(this, parameter, BuyerTable.NAME, 2);
		QueryUtility.setVARCHARParam(this, parameter, BuyerTable.STREET1, 3);
		QueryUtility.setVARCHARParam(this, parameter, BuyerTable.STREET2, 4);
		QueryUtility.setVARCHARParam(this, parameter, BuyerTable.CITY, 5);
		QueryUtility.setVARCHARParam(this, parameter, BuyerTable.COUNTY, 6);
		QueryUtility.setVARCHARParam(this, parameter, BuyerTable.POSTCODE, 7);
		QueryUtility.setVARCHARParam(this, parameter, BuyerTable.EMAIL, 8);
		QueryUtility.setVARCHARParam(this, parameter, BuyerTable.PHONE, 9);
	}
}
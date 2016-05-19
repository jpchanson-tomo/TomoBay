package tomoBay.model.sql.queries.concreteQueries.select.params;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tomoBay.model.dataTypes.heteroTypeContainer.HeteroFieldContainer;
import tomoBay.model.sql.framework.QueryUtility;
import tomoBay.model.sql.framework.queryTypes.select.AbstractSelectParamsQuery;
import tomoBay.model.sql.schema.accountsTable.AccountsTable;
import tomoBay.model.sql.schema.buyerTable.BuyerTable;
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

/**
 * This class represents a query that selects the name, street1, street2, postcode and city values 
 * from the ebay_buyers table that correspond to a particular account and sales record number. It 
 * also grabs the invoice number that is associated with these keys.
 * 
 * This query takes the following parameter:
 * - AccountsTable.ACCOUNT_NAME
 * - OrdersTable.SALES_REC_NO
 * 
 * The query returns a List<HeteroFieldContainer> containing the following fields:
 * - BuyerTable.NAME
 * - BuyerTable.STREET1
 * - BuyerTable.STREET2
 * - BuyerTable.CITY
 * - BuyerTable.POSTCODE
 * - OrdersTable.INVOICED
 * 
 * @author Jan P.C. Hanson
 *
 */
public final class SelectBuyerByAccAndSRN extends AbstractSelectParamsQuery
{
	private static final String QUERY = 
	"SELECT name, street1, street2, postcode, city, invoiced FROM ebay_buyers "
	+"INNER JOIN ebay_orders ON ebay_buyers.buyerID=ebay_orders.buyerID "
	+"INNER JOIN ebay_accounts ON ebay_orders.account=ebay_accounts.id "
	+"WHERE ebay_accounts.accountName LIKE ? AND ebay_orders.salesRecNo = ?;";
	
	
	/**
	 * default ctor.
	 */
	public SelectBuyerByAccAndSRN()
	{super();}

	/* (non-Javadoc)
	 * @see tomoBay.model.sql.framework.queryTypes.select.AbstractSelectParamsQuery#setParameters(tomoBay.model.dataTypes.heteroTypeContainer.HeteroFieldContainer)
	 */
	@Override
	protected void setParameters(HeteroFieldContainer parameter) throws ClassCastException, SQLException
	{
		QueryUtility.setVARCHARParam(this, parameter, AccountsTable.ACCOUNT_NAME, 1);
		QueryUtility.setINTEGERParam(this, parameter, OrdersTable.SALES_REC_NO, 2);
	}

	/* (non-Javadoc)
	 * @see tomoBay.model.sql.framework.queryTypes.select.AbstractSelectQuery#format(java.sql.ResultSet)
	 */
	@Override
	protected List<HeteroFieldContainer> format(ResultSet resultSet) throws SQLException
	{
		List<HeteroFieldContainer> rows = new ArrayList<HeteroFieldContainer>();
		while (resultSet.next())
		{
			HeteroFieldContainer cols = new HeteroFieldContainer();
			cols.add(OrdersTable.INVOICED, resultSet.getInt("invoiced"));
			cols.add(BuyerTable.NAME, resultSet.getString("name"));
			cols.add(BuyerTable.STREET1, resultSet.getString("street1"));
			cols.add(BuyerTable.STREET2, resultSet.getString("street2"));
			cols.add(BuyerTable.POSTCODE, resultSet.getString("postcode"));
			cols.add(BuyerTable.CITY, resultSet.getString("city"));
			rows.add(cols);
		}
		return rows;
	}

	/* (non-Javadoc)
	 * @see tomoBay.model.sql.framework.queryTypes.AbstractDBQuery#queryString()
	 */
	@Override
	protected String queryString()
	{return SelectBuyerByAccAndSRN.QUERY;}

}

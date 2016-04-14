package tomoBay.model.sql.framework.queryTypes.modify;
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
import tomoBay.model.sql.ConnectionManager;
import tomoBay.model.sql.schema.nonDBFields.NonDBFields;
/**
 * This is the Abstract Base Class for all queries that modify the database in some way
 * (INSERT/UPDATE/DELETE) but do not require any parameters in order to run.
 * @author Jan P.C. Hanson
 *
 */
public abstract class AbstractModifyQueryNoParams extends AbstractModifyQuery
{
	/**
	 * default ctor
	 */
	public AbstractModifyQueryNoParams()
	{super();}

	/**
	 * Executes the query and returns a HeteroFieldContainer containing the result fields
	 * @return HeteroFieldContainer containing a NonDBFields.RESULT_CODE field only.
	 * @throws SQLException
	 */
	public HeteroFieldContainer execute() throws SQLException
	{
		int resultCode = this.initQuery(this.queryString());
		super.cleanup();
		HeteroFieldContainer result = new HeteroFieldContainer();
		result.add(NonDBFields.RESULT_CODE, resultCode);
		return result;
	}
	
	/**
	 * Used by derived classes to define the Query string to be used in the query.
	 * @return String containing the JDBC query string
	 */
	protected abstract String queryString();
	
	/**
	 * initialise the connection and statement and set transaction variables.
	 * @param query String containing the sql query
	 * @throws SQLException
	 */
	private int initQuery(String query) throws SQLException
	{
		this.connection_M = ConnectionManager.instance().getConnection();
		this.connection_M.setAutoCommit(false);
		this.statement_M = this.connection_M.prepareStatement(query);
		return this.statement_M.executeUpdate();
	}
}

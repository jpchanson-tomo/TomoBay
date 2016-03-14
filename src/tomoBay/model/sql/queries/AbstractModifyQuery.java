package tomoBay.model.sql.queries;
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
/**
 * This class defines the abstract base for all insert and update queries. i.e. all queries that 
 * modify the database
 * @author Jan P.C. Hanson
 *
 */
public abstract class AbstractModifyQuery extends AbstractDBQuery
{
	/**
	 * default ctor
	 */
	public AbstractModifyQuery()
	{super();}

	/**
	 * executes the insert query using the parameters passed in to populate the query with the relevant 
	 * information
	 * @param parameters the information needed by this query.
	 * @return String representing the output of a particular query.
	 */
	public abstract HeteroFieldContainer execute(HeteroFieldContainer parameters) throws SQLException;

	/**
	 * initialise the connection and statement and set transaction variables.
	 * @param query String containing the sql query
	 * @throws SQLException
	 */
	protected void initQuery(String query) throws SQLException
	{
		this.connection_M = ConnectionManager.instance().getConnection();
		this.connection_M.setAutoCommit(false);
		this.statement_M = this.connection_M.prepareStatement(query);
	}
}
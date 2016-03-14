package tomoBay.model.sql.queries;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
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


import tomoBay.model.dataTypes.heteroTypeContainer.HeteroFieldContainer;
import tomoBay.model.sql.ConnectionManager;

/**
 * This class defines the abstract base for all Select queries that take parameters.
 * @author Jan P.C. Hanson
 *
 */
public abstract class AbstractSelectParamsQuery extends AbstractSelectQuery
{

	/**
	 * default ctor
	 */
	public AbstractSelectParamsQuery()
	{super();}

	/**
	 * executes the query using the parameters passed in to populate the query with the relevant 
	 * information
	 * @param parameters
	 * @return String representing the output of a particular query.
	 */
	public abstract List<HeteroFieldContainer> execute(HeteroFieldContainer parameters) throws SQLException;
	
	/**
	 * the results from a select query come in the form of a ResultSet object, this needs to be closed
	 * before the connection can be closed, however once the Resultset is closed it is impossible to
	 * get any data from it, so before it is closed the data needs transferring to a DBFieldContainer
	 * object.
	 * @param resultSet the ResultSet to format
	 * @return DBFieldContainer containing the relevant data
	 */
	protected abstract List<HeteroFieldContainer> format(ResultSet resultSet)throws SQLException;
	
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
package tomoBay.model.sql.framework.queryTypes.select;
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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import tomoBay.model.dataTypes.heteroTypeContainer.HeteroFieldContainer;
import tomoBay.model.sql.ConnectionManager;
/**
 * This class defines the Abstract base for all Select queries that do not require parameters
 * @author Jan P.C. Hanson
 *
 */
public abstract class AbstractSelectNoParamsQuery extends AbstractSelectQuery
{

	/**
	 * default ctor
	 */
	public AbstractSelectNoParamsQuery()
	{super();}

	/**
	 * executes the query.
	 * @return List<HeteroFieldContainer> with each element of the List representing a single record
	 * from the database. Each of these HeteroFieldContainers contains the fields specific to this 
	 * derived query type.
	 */
	public List<HeteroFieldContainer> execute() throws SQLException
	{
		List<HeteroFieldContainer>  selectResults = this.format(this.initQuery(this.queryString()));
		super.cleanup();
		return selectResults;
	}
	
	/**
	 * initialise the connection and statement and set transaction variables.
	 * @param query String containing the sql query
	 * @throws SQLException
	 */
	protected ResultSet initQuery(String query) throws SQLException
	{
		this.connection_M = ConnectionManager.instance().getConnection();
		this.connection_M.setAutoCommit(false);
		this.statement_M = this.connection_M.prepareStatement(query);
		return super.statement_M.executeQuery();
	}
}
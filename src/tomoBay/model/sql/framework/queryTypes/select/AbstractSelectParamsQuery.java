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
import tomoBay.model.dataTypes.heteroTypeContainer.HeteroFieldContainer;
import tomoBay.model.sql.ConnectionManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
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
	 * @param parameters the parameters required by the specific derived query class.
	 * @return List<HeteroFieldContainer> containing a list of records from the database where each
	 * record is encapsulated as a HeteroFieldContainer with the fields specific to the derived query.
	 */
	public List<HeteroFieldContainer> execute(HeteroFieldContainer parameters) throws SQLException
	{
		this.initQuery(this.queryString());
		this.setParameters(parameters);
		
		ResultSet rs = this.statement_M.executeQuery();
		List<HeteroFieldContainer> selectResults = this.format(rs);

		this.cleanup();
		return selectResults;
	}
	
	/**
	 * Used by derived classes to set the parameters for this particular query
	 * @throws SQLException 
	 * @throws ClassCastException 
	 */
	protected abstract void setParameters(HeteroFieldContainer parameter) throws ClassCastException, SQLException;
	
	/**
	 * initialise the connection and statement and set transaction variables.
	 * @param query String containing the sql query
	 * @throws SQLException
	 */
	private void initQuery(String query) throws SQLException
	{
		this.connection_M = ConnectionManager.instance().getConnection();
		this.connection_M.setAutoCommit(false);
		this.statement_M = this.connection_M.prepareStatement(query);
	}
}
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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Interface that all database queries must adhere to. this is the Abstract command class for
 * this command pattern.
 * @author Jan P.C. Hanson
 *
 */
public abstract class AbstractDBQuery
{
	/**reference to the JDBC Statement**/
	protected PreparedStatement statement_M = null;
	/**reference to the JDBC Database connection**/
	protected Connection connection_M = null;
	
	/**
	 * do cleanup after the query has been executed
	 * @throws SQLException
	 */
	protected void cleanup() throws SQLException
	{
		this.connection_M.commit();
		if (this.statement_M != null) {this.statement_M.close();}
		if (connection_M != null) {connection_M.close();}
	}
}

package tomoBay.model.sql.queries;

import java.sql.SQLException;
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
import java.util.List;

/**
 * Interface that all database queries must adhere to. this is the Abstract command class for
 * this command pattern.
 * @author Jan P.C. Hanson
 *
 */
public interface AbstractDBQuery
{
	/**
	 * executes the query.
	 * @param Parameter(s) to use in the query, see concrete type's class documentation for more
	 * information
	 * @return String representing the output of a particular query.
	 */
	public  List<String[]> execute(String[] Parameter) throws SQLException;
}
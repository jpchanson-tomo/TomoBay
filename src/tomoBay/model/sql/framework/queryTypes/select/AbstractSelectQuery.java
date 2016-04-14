package tomoBay.model.sql.framework.queryTypes.select;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import tomoBay.model.dataTypes.heteroTypeContainer.HeteroFieldContainer;
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
import tomoBay.model.sql.framework.queryTypes.AbstractDBQuery;

/**
 *
 * @author Jan P.C. Hanson
 *
 */
public abstract class AbstractSelectQuery extends AbstractDBQuery
{

	/**
	 * default ctor
	 */
	public AbstractSelectQuery()
	{super();}
	
	/**
	 * the results from a select query come in the form of a ResultSet object, this needs to be closed
	 * before the connection can be closed, however once the Resultset is closed it is impossible to
	 * get any data from it, so before it is closed the data needs transferring to a DBFieldContainer
	 * object.
	 * @param resultSet the ResultSet to format
	 * @return DBFieldContainer containing the relevant data
	 */
	protected abstract List<HeteroFieldContainer> format(ResultSet resultSet)throws SQLException;
	
}

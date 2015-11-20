package tomoBay.model.sql;
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
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

import tomoBay.helpers.ConfigReader;

import com.mchange.v2.c3p0.ComboPooledDataSource;
/**
 * This class provides access to a pool of database connections. It is a threadsafe singleton
 * so always use the instance method to get an instance of this class, NEVER STORE THE INSTANCE.
 * @author Jan P.C. Hanson
 *
 */
public class ConnectionManager
{
	/**Singleton instance with eager instanciation**/
	private static ConnectionManager test = new ConnectionManager();
	/**C3P0 Data pool**/
	private ComboPooledDataSource cpds;
	
	/**
	 * singleton contstructor, initialises the connection pool
	 */
	private ConnectionManager()
	{
		
		cpds = new ComboPooledDataSource();
		try
		{cpds.setDriverClass("com.mysql.jdbc.Driver");}
		catch (PropertyVetoException e)
		{e.printStackTrace();}
		
		cpds.setJdbcUrl(ConfigReader.read("./config/", "db.cfg")[1]);
		cpds.setUser(ConfigReader.read("./config/", "db.cfg")[2]);
		cpds.setPassword(ConfigReader.read("./config/", "db.cfg")[3]);
		cpds.setMinPoolSize(3);
		cpds.setAcquireIncrement(5);
		cpds.setMaxPoolSize(20);
		cpds.setMaxStatements(180);
	}
	
	/**
	 * instance method returns an instance of the ConnectionManager class
	 * @return ConnectionManager instance
	 */
	public static ConnectionManager instance()
	{return test;}
	
	/**
	 * retrieves a database connection from the pool of available connections. When
	 * Connection.close is called the connection is returned to the pool.
	 * @return
	 * @throws SQLException
	 */
	public Connection getConnection() throws SQLException
	{return this.cpds.getConnection();}	
}

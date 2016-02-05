package tomoBay.model.dataTypes;
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
 *
 * @author Jan P.C. Hanson
 *
 */
public class ServerStatus
{
	/**singleton instance variable**/
	private static final ServerStatus instance_M = new ServerStatus();
	/**status variable**/
	private static RunLevel status_M;
	/**enum providing allowed ServerStatus values**/
	public enum RunLevel {ERROR, RUNNING, PAUSED, STOPPED};
	/**
	 * private constructor ensures singleton is never instantiated
	 */
	private ServerStatus()
	{super();}
	
	/**
	 * retrieve an instance of this object
	 * @return ServerStatus
	 */
	public static ServerStatus instance()
	{return ServerStatus.instance_M;}
	
	/**
	 * 
	 * @param status
	 */
	public synchronized void setStatus(ServerStatus.RunLevel status)
	{ServerStatus.status_M=status;}
	
	/**
	 * 
	 * @return
	 */
	public static synchronized ServerStatus.RunLevel getStatus()
	{return ServerStatus.status_M;}
}

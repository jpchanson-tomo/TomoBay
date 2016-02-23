package tomoBay.model.winstock;
import tomoBay.helpers.Config;
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
import tomoBay.helpers.ConfigReader;
/**
 * This class is responsible for grabbing and storing the contents of the winstock configuration
 * file, and providing that information to objects in need of this information.
 * @author Jan P.C. Hanson
 *
 */
public final class WinstockConfig
{
	/**
	 * default constructor
	 */
	public WinstockConfig()
	{super();}
	
	/**
	 * method used to get the string representing the name of the machine on which winstock is
	 * running, this could be a domain name or an IP address.
	 * @return String representing the name of the machine on which winstock is running.
	 */
	public String getMachineName()
	{return ConfigReader.getConf(Config.WIN_LOC);}
	
	/**
	 * method used to retrieve the port on which winstock is running.
	 * @return int representing the port number on which winstock is running.
	 */
	public int getPort()
	{return Integer.parseInt(ConfigReader.getConf(Config.WIN_PORT));}
}

package tomoBay.helpers.checkTime;

import tomoBay.helpers.Config;
import tomoBay.helpers.ConfigReader;
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
 * The start and end times for the working day on a monday.
 * @author Jan P.C. Hanson
 *
 */
public class Monday implements Day
{
	/**
	 * default ctor
	 */
	public Monday()
	{super();}

	/* (non-Javadoc)
	 * @see tomoBay.helpers.checkTime.Day#startTime()
	 */
	@Override
	public int startTime()
	{return Integer.parseInt(ConfigReader.getConf(Config.MON_ST));}

	/* (non-Javadoc)
	 * @see tomoBay.helpers.checkTime.Day#endTime()
	 */
	@Override
	public int endTime()
	{return Integer.parseInt(ConfigReader.getConf(Config.MON_END));}
}

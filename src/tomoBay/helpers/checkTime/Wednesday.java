package tomoBay.helpers.checkTime;
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
import tomoBay.helpers.Config;
import tomoBay.helpers.ConfigReader;
/**
 * This class encapsulates a friday, in terms of the start of business hours and the end of business
 * hours
 * 
 * @author Jan P.C. Hanson
 *
 */
public class Wednesday implements Day
{
	/**
	 * default ctor
	 */
	public Wednesday()
	{super();}

	/* (non-Javadoc)
	 * @see tomoBay.helpers.checkTime.Day#startTime()
	 */
	@Override
	public int startTime()
	{return Integer.parseInt(ConfigReader.getConf(Config.WED_ST));}

	/* (non-Javadoc)
	 * @see tomoBay.helpers.checkTime.Day#endTime()
	 */
	@Override
	public int endTime()
	{return Integer.parseInt(ConfigReader.getConf(Config.WED_END));}

}
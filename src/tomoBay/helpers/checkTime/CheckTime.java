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
import gnu.trove.map.hash.THashMap;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
/**
 * This class provides static access to functions relating time, primarily to see if the current time
 * is within the range set in the config file.
 * 
 * @author Jan P.C. Hanson
 *
 */
public class CheckTime
{
	/**static map which equates Calendar enum constants to Day objects**/
	private static Map<Integer, Day> today_M = new THashMap<Integer, Day>()
			{{
				put(Calendar.MONDAY, new Monday());
				put(Calendar.TUESDAY, new Tuesday());
				put(Calendar.WEDNESDAY, new Wednesday());
				put(Calendar.THURSDAY, new Thursday());
				put(Calendar.FRIDAY, new Friday());
				put(Calendar.SATURDAY, new Saturday());
				put(Calendar.SUNDAY, new Sunday());
			}};
	
	/**
	 * default ctor
	 */
	private CheckTime()
	{super();}
	
	/**
	 * tells you whether the current time is within the range specified in the config file.
	 * @return true iff time is within range(inclusive), false otherwise.
	 */
	public static boolean isInRange()
	{
		final int startTime = CheckTime.today_M.get(CheckTime.currentDay()).startTime();
		final int endTime = CheckTime.today_M.get(CheckTime.currentDay()).endTime();
		
		if(CheckTime.currentTime() >= startTime && CheckTime.currentTime() <= endTime) 
		{return true;} else {return false;}
	}
	
	/**
	 * if before the start time for today returns yesterdays date otherwise returns todays date.
	 * @return Calendar object returning the date that any out of hours should be registerd under
	 */
	public static Date OutOfHoursDate()
	{
		final Calendar outOfHoursDate = Calendar.getInstance();
		if(CheckTime.currentTime() < CheckTime.today_M.get(CheckTime.currentDay()).startTime())
		{outOfHoursDate.add(Calendar.DATE, -1);}
		
		return outOfHoursDate.getTime();
	}
	
	/**
	 * does what it says on the tin.
	 * @return String containing the current timestamp in the yyyy-mm-dd hh:mm:ss format
	 */
	public static String currentTimeStamp()
	{
		final Date result = new Date();
		SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		return dateFormatter.format(result);
	}
	
	/**
	 * queries the current time 
	 * @return int containing the current time
	 */
	private static int currentTime()
	{
		final Calendar now = Calendar.getInstance();
		int currentTime = (now.get(Calendar.HOUR_OF_DAY)*100) + (now.get(Calendar.MINUTE));
		return currentTime;
	}
	
	/**
	 * queries the current day
	 * @return integer representation of the current day, with 1 = Sunday, 7 = saturday.
	 */
	private static int currentDay()
	{return Calendar.getInstance().get(Calendar.DAY_OF_WEEK);}
}

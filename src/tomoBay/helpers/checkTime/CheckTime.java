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
 *
 * @author Jan P.C. Hanson
 *
 */
public class CheckTime
{
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
	 * 
	 */
	private CheckTime()
	{super();}
	
	/**
	 * tells you whether the current time is within the range specified. the times specified
	 * must be in 24hour format with no separators and no leading zeroes. i.e. 08:00 AM would 
	 * be 800, 01:30 PM would be 1330 etc.
	 * 
	 * this checks whether the current time is greater than or equal to the start time AND less
	 * than or equal to the end time. if these conditions are true it returns a value of true.
	 * otherwise it returns a value of false.
	 * @param startTime the start time for the time range
	 * @param endTime the end time for the time range.
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
	 * 
	 * @return
	 */
	public static Date OutOfHoursDate()
	{
		final Calendar outOfHoursDate = Calendar.getInstance();
		if(CheckTime.currentTime() < CheckTime.today_M.get(CheckTime.currentDay()).startTime())
		{outOfHoursDate.add(Calendar.DATE, -1);}
		
		return outOfHoursDate.getTime();
	}
	
	/**
	 * 
	 * @return
	 */
	public static String currentTimeStamp()
	{
		final Date result = new Date();
		SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		return dateFormatter.format(result);
	}
	
	/**
	 * queries the current time 
	 * @return
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

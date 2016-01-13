package tomoBay.helpers;

import java.util.Calendar;
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
public class CheckTime
{
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
	public static boolean isInRange(int startTime, int endTime)
	{
		Calendar now = Calendar.getInstance();
		int currentTime = (now.get(Calendar.HOUR_OF_DAY)*100) + (now.get(Calendar.MINUTE));
		
		if(currentTime >= startTime && currentTime <= endTime) {return true;}
		else {return false;}
	}
}

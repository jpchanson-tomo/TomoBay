package tomoBay.helpers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
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
import java.util.Date;

import tomoBay.exceptions.ServiceException;

/**
 *
 * @author Jan P.C. Hanson
 *
 */
public class TimeStampCompare
{
	
	/**
	 * this method compares the timestamp provided, with the current date to see if it is older
	 * than the specified number of days.
	 * @param daysAgo the number of days 
	 * @param timestamp the timestamp to compare, yyyy-MM-dd
	 * @return true iff timestamp is older than the specified number of days ELSE false.
	 * @throws ParseException 
	 */
	public static boolean olderThan(int days, String timestamp)
	{
		try
		{
			ZonedDateTime now = ZonedDateTime.now();
			ZonedDateTime limit = now.plusDays(-days);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date dateThen = sdf.parse(timestamp);
			return dateThen.toInstant().isBefore(limit.toInstant());
		}
		catch(ParseException pe)
		{throw new ServiceException("cannot compare timestamps", pe);}
	}
}

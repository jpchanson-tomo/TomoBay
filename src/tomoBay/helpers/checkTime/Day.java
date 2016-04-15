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
import tomoBay.helpers.NoImports;
/**
 * represents a working day on which the system should operate between specific hours.
 * @author Jan P.C. Hanson
 *
 */
@SuppressWarnings("unused")
public interface Day
{
	/**
	 * defines the start time for this Day derived class
	 * @return int representing the start of business hours for this derived Day object
	 */
	public int startTime();
	
	/**
	 * defines the end time for this Day derived class
	 * @return int representing the end of business hours for this derived Day object
	 */
	public int endTime();
}

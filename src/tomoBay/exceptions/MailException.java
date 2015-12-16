package tomoBay.exceptions;
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
 * Generic email exception
 * @author Jan P.C. Hanson
 *
 */ 
public class MailException extends Exception
{
	/**
	 * needed to avoid warnings
	 */
	private static final long serialVersionUID = 8735487713393434127L;
	
	/**
	 * default ctor
	 */
	public MailException()
	{
		super();
	}
	
	/**
	 * ctor with message
	 * @param message
	 */
	public MailException(String message)
	{
		super(message);
	}
}
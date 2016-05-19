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
 * This exception denotes that there is something wrong with a class in the 
 * tomoBay.presenters.presenterActions package.
 * 
 * @author Jan P.C. Hanson
 *
 */
public class PresenterActionException extends RuntimeException
{

	/**
	 * needed to avoid warnings
	 */
	private static final long serialVersionUID = 3383597969590028181L;

	/**
	 * default constructor
	 */
	public PresenterActionException()
	{super();}

	/**
	 * @param arg0 the message to show as the error message
	 */
	public PresenterActionException(String arg0)
	{super(arg0);}

	/**
	 * @param arg0 the cause of the exception
	 */
	public PresenterActionException(Throwable arg0)
	{
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param arg0 error message
	 * @param arg1 cause of the exception
	 */
	public PresenterActionException(String arg0, Throwable arg1)
	{
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}
}

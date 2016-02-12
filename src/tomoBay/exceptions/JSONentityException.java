package tomoBay.exceptions;

import com.sun.tools.ws.wsdl.document.jaxws.Exception;
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
public class JSONentityException extends RuntimeException
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7731803793751501786L;

	/**
	 * 
	 */
	public JSONentityException()
	{
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param name
	 */
	public JSONentityException(String name)
	{
		super(name);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param name
	 */
	public JSONentityException(String name, Throwable t)
	{
		super(name, t);
		// TODO Auto-generated constructor stub
	}

}

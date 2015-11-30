package tomoBay.model.winstock.commands;
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
 * This is the interface that all winstock command responses should subscribe to.
 * @author Jan P.C. Hanson
 *
 */
@SuppressWarnings("unused")
public interface AbstractWinstockCommandResponse
{
	/**
	 * method of descerning whether the AbstractWinstockCommand associated with this 
	 * AbstractWinstockCommandResponse has been successful.
	 * @return boolean true if successful false otherwise.
	 */
	public boolean isSuccess();
	
	/**
	 * method used to retrieve the results of the AbstractWinstockCommand associated with this 
	 * AbstractWinstockCommandResponse.
	 * @return String the data of the query
	 */
	public String getData();
}

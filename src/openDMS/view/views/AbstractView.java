package openDMS.view.views;
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
import openDMS.helpers.NoImports;
/**
 * Interface that all concrete views shoulde subscribe to.
 * 
 * @author Jan P.C. Hanson
 *
 */
@SuppressWarnings("unused")
public interface AbstractView
{
	/**
	 * This method constructs the part of the view that is requested in the parameters. 
	 * @param part should be taken from the internal Enum defined within this class. Each enum
	 * constant refers to a specific part of the view.
	 * @return String containing the HTML for the part of the view that has been requested.
	 */
	public String make(AbstractViewPart part);
}

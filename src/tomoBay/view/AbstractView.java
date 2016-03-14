package tomoBay.view;
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

import tomoBay.model.dataTypes.heteroTypeContainer.HeteroFieldContainer;
import java.util.List;
/**
 * this is the interface that all views must subscribe to. Views are responsible for formatting
 * the information provided to them by the presenters.
 * @author Jan P.C. Hanson
 *
 */
public interface AbstractView
{
	/**
	 * this method is responsible for formatting the data as required for the specific derived
	 * view
	 * @param input a List<String[]> containing the data to be formatted.
	 * @return String that can be output to the AJAX requester.
	 */
	public String format(List<HeteroFieldContainer> input);
}

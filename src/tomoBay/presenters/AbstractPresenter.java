package tomoBay.presenters;
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
import tomoBay.view.AbstractView;
import tomoBay.view.ViewFactory;
/**
 * provides an interface that all presenters should subscribe to.
 * 
 * @author Jan P.C. Hanson
 *
 */
public interface AbstractPresenter
{
	/**
	 * this method is called when you actually want to present the information to be displayed
	 * to the appropriate view for formatting returning a string that can be displayed by the
	 * servlet.
	 * @return String representing the html formatted information presented to the view by this
	 * presenter.
	 */
	public String present(AbstractView view);
	
	/**
	 * double dispatch method that allows the presenter to be responsible for creation of its
	 * associated view, through the use of the ViewFactory object passed in the arguments.
	 * @param viewFactory a ViewFactory object.
	 * @return AbstractView the view associated with this particular presenter.
	 */
	public AbstractView accept(ViewFactory viewFactory);
}

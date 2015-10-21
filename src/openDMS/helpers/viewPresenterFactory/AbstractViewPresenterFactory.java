package openDMS.helpers.viewPresenterFactory;
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
import openDMS.presenters.AbstractPresenter;
import openDMS.view.views.AbstractView;
/**
 * the interface that all concrete factories should subscribe to.
 * @author Jan P.C. Hanson
 *
 */
public interface AbstractViewPresenterFactory
{
	/**
	 * factory method that creates specific a view
	 * @return AbstractView the view that has been requested
	 */
	public AbstractView makeView();
	
	/**
	 * factory method that creates specific a presenter
	 * @return AbstractPresenter the presenter than has been requested.
	 */
	public AbstractPresenter makePresenter();
}

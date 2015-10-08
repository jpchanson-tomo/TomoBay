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
import openDMS.presenters.root.RootPresenter;
import openDMS.view.views.AbstractView;
import openDMS.view.views.RootView;
/**
 * RootAbstractFactory creates the presenter and view for the root view.
 * @author Jan P.C. Hanson
 *
 */
public class RootFactory implements AbstractViewPresenterFactory
{
	/* (non-Javadoc)
	 * @see openDMS.helpers.viewPresenterFactory.AbstractViewPresenterFactory#makeView()
	 */
	@Override
	public AbstractView makeView()
	{return new RootView();}

	/* (non-Javadoc)
	 * @see openDMS.helpers.viewPresenterFactory.AbstractViewPresenterFactory#makePresenter()
	 */
	@Override
	public AbstractPresenter makePresenter()
	{return new RootPresenter();}
}

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
import tomoBay.presenters.AbstractPresenter;
import tomoBay.presenters.error.ErrorPresenter;
import tomoBay.presenters.root.RootPresenter;
import tomoBay.presenters.sales.SalesOrderPresenter;
import tomoBay.view.factories.SalesOrderViewFactory;

import java.util.HashMap;
import java.util.Map;

import tomoBay.view.factories.AbstractViewFactory;
import tomoBay.view.factories.ErrorViewFactory;
import tomoBay.view.factories.RootViewFactory;
/**
 *
 * @author Jan P.C. Hanson
 *
 */
public class ViewFactory
{

			
	@SuppressWarnings("serial")
	private static final Map<Class<? extends AbstractPresenter>, AbstractViewFactory> viewMap_M 
						= new HashMap<Class<? extends AbstractPresenter>, AbstractViewFactory>()
			{{
				put(ErrorPresenter.class, new ErrorViewFactory());
				put(RootPresenter.class, new RootViewFactory());
				put(SalesOrderPresenter.class, new SalesOrderViewFactory());
			}};
			
	/**
	 * default constructor
	 */
	public ViewFactory()
	{super();}

	/**
	 * creates the presenter specified by one of the enum values defined in PresenterType
	 * @param presenter the enum value defined in the internal enum.
	 * @return AbstractPresenter the presenter requested.
	 */
	public static AbstractView make(AbstractPresenter presenter)
	{
		try
		{return ViewFactory.viewMap_M.get(presenter.getClass()).make();}
		
		catch(IllegalArgumentException e)
		{
			return ViewFactory.viewMap_M.get
				(ErrorPresenter.class).make();
		}
	}

}
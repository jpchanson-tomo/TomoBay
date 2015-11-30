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
	/** defencive enum limits the number of inputs to the make method**/
	public enum ViewType 
			{
				/**@see {@link tomoBay.presenters.error.ErrorPresenter}**/
				ERROR_VIEW,
				/**@see {@link tomoBay.presenters.root.RootPresenter}**/
				ROOT_VIEW,
				/**@see {@link tomoBay.presenters.sales.SalesOrderPresenter}**/
				SALES_ORDER_VIEW
			}
	
	/****/
	@SuppressWarnings("serial")
	private static final Map<ViewType, AbstractViewFactory> presenterMap_M 
						= new HashMap<ViewType, AbstractViewFactory>()
			{{
				put(ViewFactory.ViewType.ERROR_VIEW, new ErrorViewFactory());
				put(ViewFactory.ViewType.ROOT_VIEW, new RootViewFactory());
				put(ViewFactory.ViewType.SALES_ORDER_VIEW, new SalesOrderViewFactory());
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
	public static AbstractView make(String presenter)
	{
		try
		{return ViewFactory.presenterMap_M.get(ViewFactory.ViewType.valueOf(presenter)).make();}
		
		catch(IllegalArgumentException e)
		{
			return ViewFactory.presenterMap_M.get
				(ViewFactory.ViewType.ERROR_VIEW).make();
		}
	}

}
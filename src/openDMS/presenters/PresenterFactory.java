package openDMS.presenters;
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
import java.util.HashMap;
import java.util.Map;

import openDMS.presenters.factories.AbstractPresenterFactory;
import openDMS.presenters.factories.ErrorPresenterFactory;
import openDMS.presenters.factories.RootPresenterFactory;
import openDMS.presenters.factories.SalesPresenterFactory;
/**
 *
 * @author Jan P.C. Hanson
 *
 */
public class PresenterFactory
{
	/** defencive enum limits the number of inputs to the make method**/
	public enum PresenterType 
			{
				ERROR_PRESENTER, ROOT_PRESENTER, SALES_PRESENTER
			}
	
	/****/
	@SuppressWarnings("serial")
	private static final Map<PresenterType, AbstractPresenterFactory> presenterMap_M 
						= new HashMap<PresenterType, AbstractPresenterFactory>()
			{{
				put(PresenterFactory.PresenterType.ERROR_PRESENTER, new ErrorPresenterFactory());
				put(PresenterFactory.PresenterType.ROOT_PRESENTER, new RootPresenterFactory());
				put(PresenterFactory.PresenterType.SALES_PRESENTER, new SalesPresenterFactory());
			}};
	/**
	 * default constructor
	 */
	public PresenterFactory()
	{super();}

	/**
	 * creates the presenter specified by one of the enum values defined in PresenterType
	 * @param presenter the enum value defined in the internal enum.
	 * @return AbstractPresenter the presenter requested.
	 */
	public static AbstractPresenter make(String presenter)
	{
		try
		{return PresenterFactory.presenterMap_M.get(PresenterFactory.PresenterType.valueOf(presenter)).make();}
		
		catch(IllegalArgumentException e)
		{
			return PresenterFactory.presenterMap_M.get
				(PresenterFactory.PresenterType.ERROR_PRESENTER).make();
		}
	}

}

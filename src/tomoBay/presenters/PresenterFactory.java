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
import java.util.HashMap;
import java.util.Map;

import tomoBay.presenters.factories.AbstractPresenterFactory;
import tomoBay.presenters.factories.AdminServicePresenterFactory;
import tomoBay.presenters.factories.ErrorPresenterFactory;
import tomoBay.presenters.factories.OutOfHoursPresenterFactory;
import tomoBay.presenters.factories.RootPresenterFactory;
import tomoBay.presenters.factories.SalesHistoryPresenterFactory;
import tomoBay.presenters.factories.SalesOrderPresenterFactory;
/**
 * This class defines a factory method that creates the different types of presenter. The types
 * of presenter that can be created are defined in the PresenterType enum and the string that
 * is passed to the make() method **MUST** be equivalent to one of the predefined enum constants. 
 * @author Jan P.C. Hanson
 *
 */
public class PresenterFactory
{
	/** defencive enum limits the number of inputs to the make method**/
	public enum PresenterType 
			{
				/**@see {@link tomoBay.presenters.error.ErrorPresenter}**/
				ERROR_PRESENTER,
				/**@see {@link tomoBay.presenters.root.RootPresenter}**/
				ROOT_PRESENTER,
				/**@see {@link tomoBay.presenters.sales.SalesOrderPresenter}**/
				SALES_ORDER_PRESENTER,
				/**@see {@link tomoBay.presenters.sales.SalesHistoryPresenter}**/
				SALES_HISTORY_PRESENTER,
				/**@see {@link tomoBay.presenters.sales.OutOfHoursPresenter}**/
				OUT_OF_HOURS_PRESENTER,
				/**@see {@link tomoBay.presenters.sales.AdminServicePresenter}**/
				ADMIN_PRESENTER
			}
	
	/****/
	@SuppressWarnings("serial")
	private static final Map<PresenterType, AbstractPresenterFactory> presenterMap_M 
						= new HashMap<PresenterType, AbstractPresenterFactory>()
			{{
				put(PresenterFactory.PresenterType.ERROR_PRESENTER, new ErrorPresenterFactory());
				put(PresenterFactory.PresenterType.ROOT_PRESENTER, new RootPresenterFactory());
				put(PresenterFactory.PresenterType.SALES_ORDER_PRESENTER, new SalesOrderPresenterFactory());
				put(PresenterFactory.PresenterType.SALES_HISTORY_PRESENTER, new SalesHistoryPresenterFactory());
				put(PresenterFactory.PresenterType.OUT_OF_HOURS_PRESENTER, new OutOfHoursPresenterFactory());
				put(PresenterFactory.PresenterType.ADMIN_PRESENTER, new AdminServicePresenterFactory());
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

package tomoBay.presenters.orderDetails;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import tomoBay.model.sql.queries.QueryInvoker;
import tomoBay.presenters.AbstractPresenter;
import tomoBay.presenters.presenterActions.AbstractPresenterAction;
import tomoBay.presenters.presenterActions.LogFileViewer;
import tomoBay.presenters.presenterActions.PeriodicServicesController;
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
 *
 * @author Jan P.C. Hanson
 *
 */
public class OrderDetailsPresenter implements AbstractPresenter
{
	/**maps the type string to an action**/
	@SuppressWarnings("serial")
	private static final Map<String, AbstractPresenterAction> actionMap_M
				= new HashMap<String, AbstractPresenterAction>()
				{{
					put("PeriodicServices", new PeriodicServicesController());
					put("LOGFILE", new LogFileViewer());
				}};
	
	/* (non-Javadoc)
	 * @see tomoBay.presenters.AbstractPresenter#present(tomoBay.view.AbstractView)
	 */
	@Override
	public String present(AbstractView view, String type, String data)
	{
		String output = "";
		List<String[]> rows = QueryInvoker.execute
				(QueryInvoker.QueryType.SELECT_FULL_ORDER_LINE,new String[] {data});
		
		output += view.format(rows);
		
		return output;
	}

	/* (non-Javadoc)
	 * @see tomoBay.presenters.AbstractPresenter#accept(tomoBay.view.ViewFactory)
	 */
	@Override
	public AbstractView accept(ViewFactory viewFactory)
	{return viewFactory.visit(this);}

}

package tomoBay.presenters.sales;
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
import java.util.ArrayList;
import java.util.List;

import tomoBay.helpers.TimeStampCompare;
import tomoBay.model.sql.queries.QueryInvoker;
import tomoBay.presenters.AbstractPresenter;
/**
 *
 * @author Jan P.C. Hanson
 *
 */
public final class OutOfHoursPresenter implements AbstractPresenter
{
	
	private static final int OLD_ORDER_LIMIT = 30;

	/* (non-Javadoc)
	 * @see tomoBay.presenters.AbstractPresenter#present(tomoBay.view.AbstractView, java.lang.String, java.lang.String)
	 */
	@Override
	public String present(AbstractView view, String type, String data)
	{
		String output = "";
		List<String[]> rows = QueryInvoker.execute
				(QueryInvoker.QueryType.SELECT_OUT_OF_HOURS_ORDERS,new String[] {type, data});
		rows = this.removeOldOrders(rows);
		output += view.format(rows);
		
		return output;
	}

	/* (non-Javadoc)
	 * @see tomoBay.presenters.AbstractPresenter#accept(tomoBay.view.ViewFactory)
	 */
	@Override
	public AbstractView accept(ViewFactory viewFactory)
	{return viewFactory.visit(this);}
	
	/**
	 * remove orders older than the 
	 * @param orderList
	 * @return
	 */
	private List<String[]> removeOldOrders(List<String[]> orderList)
	{
		List<String[]> result = new ArrayList<String[]>();
		for(String[] order : orderList)
		{
			if(TimeStampCompare.olderThan(OLD_ORDER_LIMIT, order[2])==false)
			{result.add(order);}
		}
		
		return result;
	}

}

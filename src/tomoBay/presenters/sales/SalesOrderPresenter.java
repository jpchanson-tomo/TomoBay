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
import java.util.List;

import tomoBay.helpers.SortOrders;
import tomoBay.model.dataTypes.Pickeablity;
import tomoBay.model.sql.queries.QueryInvoker;
import tomoBay.presenters.AbstractPresenter;
import tomoBay.view.AbstractView;
import tomoBay.view.ViewFactory;
/**
 * This class is responsible for providing the dynamic data to the orders section of the 
 * sales 'Orders' area.
 * @author Jan P.C. Hanson
 *
 */
public class SalesOrderPresenter implements AbstractPresenter
{
	/**
	 * default constructor
	 */
	public SalesOrderPresenter()
	{super();}
	
	/* (non-Javadoc)
	 * @see openDMS.presenters.AbstractPresenter#present(openDMS.view.views.AbstractView)
	 */
	@Override
	public String present(AbstractView view, String type, String data)
	{
		String output = "";
		List<String[]> rows = QueryInvoker.execute
				(QueryInvoker.QueryType.SELECT_UNINVOICED_ORDERS,new String[] {""});
		this.checkPickability(rows);
		rows = new SortOrders().sortDefault(rows);

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
	 * this method checks the pickeability of the uninvoiced orders and modifies the invoiced
	 * column of the data appropriately col[8].
	 * @param orders the list of orders to be examined.
	 */
	private void checkPickability(List<String[]> orders)
	{
		Pickeablity pickeableStatus = new Pickeablity();
		for(String[] order : orders)
		{
			order[8] = String.valueOf(pickeableStatus.status(order[0]).getStatusCode());
		}
	}
}
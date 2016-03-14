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
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import tomoBay.helpers.TimeStampFunctions;
import tomoBay.model.dataTypes.heteroTypeContainer.ClassRef;
import tomoBay.model.dataTypes.heteroTypeContainer.HeteroFieldContainer;
import tomoBay.model.sql.queries.SelectQueryInvoker;
import tomoBay.model.sql.schema.nonDBFields.NonDBFields;
import tomoBay.model.sql.schema.outOfHoursTable.OutOfHoursTable;
import tomoBay.presenters.AbstractPresenter;
import tomoBay.view.AbstractView;
import tomoBay.view.ViewFactory;
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
		HeteroFieldContainer param = new HeteroFieldContainer();
		param.add(OutOfHoursTable.DATE, this.ToDate(type));
		param.add(NonDBFields.DATE_COMPARISON, this.ToDate(data));
		List<HeteroFieldContainer> rows = SelectQueryInvoker.execute
				(SelectQueryInvoker.SelectQueryTypeParams.SELECT_OUT_OF_HOURS_ORDERS, param);
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
	private List<HeteroFieldContainer> removeOldOrders(List<HeteroFieldContainer> orderList)
	{
		List<HeteroFieldContainer> result = new ArrayList<HeteroFieldContainer>();
		for(HeteroFieldContainer order : orderList)
		{
			if(TimeStampFunctions.olderThan(OLD_ORDER_LIMIT, order.get(NonDBFields.DATE_COMPARISON, ClassRef.DATE))==true)
			{result.add(order);}
		}
		return result;
	}
	
	/**
	 * 
	 * @param stringDate
	 * @return
	 */
	private Date ToDate(String stringDate)
	{return Date.valueOf(stringDate);}

}

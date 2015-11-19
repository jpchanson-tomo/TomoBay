package openDMS.presenters.sales;
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

import openDMS.model.sql.queries.QueryInvoker;
import openDMS.presenters.AbstractPresenter;
import openDMS.presenters.helpers.PickeableStatus;
import openDMS.presenters.helpers.SortOrders;
/**
 *
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
	public String present()
	{
		String output = "";
		List<String[]> rows = QueryInvoker.execute
				(QueryInvoker.QueryType.SELECT_EBAY_ORDERS,new String[] {""});
		
		rows = new SortOrders().sortDefault(rows);
		
		output += this.doStuff(rows);
		
		return output;
	}

	private String doStuff(List<String[]> input) 
	{
		String result = "";
		PickeableStatus status = new PickeableStatus();
			
			result+= "<table class='table table-condensed'> \n";
			result+= "<thead>\n<tr>\n"
					+ "<th>"+ "<input type='checkbox' class = 'chcktbl' />"  + "</th>\n"
					+ "<th>Name</th>\n"
					+ "<th>Date</th>\n"
					+ "<th>Shipping Type</th>\n"
					+ "<th>Details</th>\n"
					+ "<th>Status</th>\n"
					+ "</tr>\n</thead>\n <tbody>";
			for (String[] cols : input)
			{
				result+="<tr>\n";
				result+="<td class='checkbox'>"+ "<input type='checkbox' class = 'chcktbl' />"  + "</td>\n";
				result+="<td class='name'>"+ cols[1].trim() + "</td>\n";
				result+="<td class='date'>"+ cols[4].trim() + "</td>\n";
				result+="<td class='shippingType'>"+ cols[3].trim() + "</td>\n";
				result+="<td class='details'>"+ "<button class='btn btn-success' value='"+cols[0].trim()+"'>View</button>" + "</td>\n";
				result+="<td class='status'>"+ status.status(cols[0]);
				result+="</tr>\n";
			}
			
			result+="</tbody>\n</table>";
			
		return  result;
	}
}

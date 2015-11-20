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

import tomoBay.model.services.helpers.InvoiceableStatus;
import tomoBay.model.services.invoiceOrderService.CalculateInvoiceStatus;
import tomoBay.model.sql.queries.QueryInvoker;
import tomoBay.presenters.AbstractPresenter;
import tomoBay.presenters.helpers.SortOrders;
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

	/**
	 * 
	 * @param input
	 * @return
	 */
	private String doStuff(List<String[]> input) 
	{
		String result = "";
			
			for (String[] cols : input)
			{
				result+="<tr class='"+cols[0]+"'>\n";
				result+="<td>"+ "<input type='checkbox' class = 'chcktbl filterable-cell ' />"  + "</td>\n";
				result+="<td class='name filterable-cell '>"+ cols[1].trim() + "</td>\n";
				result+="<td class='date filterable-cell '>"+ cols[4].trim() + "</td>\n";
				result+="<td class='shippingType filterable-cell '>"+ cols[3].trim() + "</td>\n";
				result+="<td class='details filterable-cell '>"+ "<button class='btn btn-primary' value='"+cols[0].trim()+"'>View</button>" + "</td>\n";
				result+="<td class='status filterable-cell '>"+ this.pickeability(cols[8]) + "</td>";
				result+="</tr>\n";
			}
			
		result+="</table>";
		return  result;
	}
	
	/**
	 * 
	 * @param invoiced
	 * @return
	 */
	private String pickeability(String invoiced)
	{
		String pickeability="";
		if(Integer.parseInt(invoiced)==3){pickeability = "ERROR";}
		if(Integer.parseInt(invoiced)==2){pickeability = "Unpickeable";}
		if(Integer.parseInt(invoiced)==1){pickeability = "Partial";}
		if(Integer.parseInt(invoiced)==0){pickeability = "Pickeable";}
		
		return pickeability;
	}
}

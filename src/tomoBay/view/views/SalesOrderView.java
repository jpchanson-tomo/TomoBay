package tomoBay.view.views;
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
import java.util.List;
/**
 * This class is responsible for formatting the data passed to it by the SalesOrderPresenter and
 * providing a string that can be displayed by the AJAX requestor.
 * @author Jan P.C. Hanson
 *
 */
public class SalesOrderView implements AbstractView
{
	/**
	 * 
	 */
	public SalesOrderView()
	{super();}
	
	/**
	 * 
	 * @param input
	 * @return
	 */
	public String format(List<String[]> input) 
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

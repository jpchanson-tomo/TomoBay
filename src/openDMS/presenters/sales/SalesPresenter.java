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
import java.sql.SQLException;
import java.util.List;

import openDMS.model.sql.queries.QueryInvoker;
import openDMS.presenters.AbstractPresenter;
/**
 *
 * @author Jan P.C. Hanson
 *
 */
public class SalesPresenter implements AbstractPresenter
{
	/**
	 * default constructor
	 */
	public SalesPresenter()
	{super();}
	
	/* (non-Javadoc)
	 * @see openDMS.presenters.AbstractPresenter#present(openDMS.view.views.AbstractView)
	 */
	@Override
	public String present()
	{
		String output = "";
		
		output += this.doStuff();
		
		return output;
	}

	private String doStuff() 
	{
		String result = "";
		try
		{
			List<String[]> rows = QueryInvoker.execute
					(QueryInvoker.QueryType.SELECT_EBAY_ORDERS,new String[] {""});
			
			result+= "<table class='table table-condensed'> \n";
			result+= "<thead>\n<tr>\n"
					+ "<th>"+ "<input type='checkbox' class = 'chcktbl' />"  + "</th>\n"
					+ "<th>ID</th>\n"
					+ "<th>name</th>\n"
					+ "<th>Address</th>\n"
					+ "<th>Telephone</th>\n"
					+ "<th>Email</th>\n"
					+ "</tr>\n</thead>\n <tbody>";
			for (String[] cols : rows)
			{
				result+="<tr>\n";
				result+="<td>"+ "<input type='checkbox' class = 'chcktbl' />"  + "</td>\n";
				result+="<td>"+ cols[0].trim() + "</td>\n";
				result+="<td>"+ cols[1].trim() + "</td>\n";
				result+="<td>"+ cols[2].trim() + "</td>\n";
				result+="<td>"+ "07354463849" + "</td>\n";
				result+="<td>"+ "<a href='mailto:someone@example.com'>test.user.name@email.com</a>" + "</td>\n";
				result+="</tr>\n";
			}
			
			result+="</tbody>\n</table>";
			
		}
		catch(SQLException e)
		{e.printStackTrace();}
		
		return  result;
	}
}

package tomoBay.model.services.emailErrorsService;
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
/**
 *
 * @author Jan P.C. Hanson
 *
 */
public class EmailErrorsDataFormat
{
	/**The static HTML that start off the string**/
	private static final String HEADER = "<h1>Listing Errors</h1>"
										+ "<p>The following errors need fixing, please attend to this.......................</p>"
										+ "<br><br>"
										+ "<table border='1' style='width:100%'>"
										+ "<tr>"
										+ "<th>ListingID</th><th>Title</th>"
										+ "<th>Brand</th><th>PartNo</th><th>Notes</th>"
										+ "</tr>";
	/**The static HTML that finishes off the string**/
	private static final String FOOTER = "<table>";
	
	/**
	 * default ctor
	 */
	public EmailErrorsDataFormat()
	{super();}
	
	/**
	 * format the List of strings provided as a HTML string that can be sent as an email.
	 * @param listOfErrors List<String> containing the data to be formatted
	 * @return String formatted as HTML that can be sent by email.
	 */
	public String asHTML(List<String[]> listOfErrors)
	{
		String result = HEADER;
		for (String[] error : listOfErrors)
		{
			result += "<tr>";
			result += "<td><a href='http://www.ebay.co.uk/itm/"+error[0]+"'>"+error[0]+"</a></td>";
			result += "<td>"+error[1]+"</td>";
			result += "<td>"+error[3]+"</td>";
			result += "<td>"+error[4]+"</td>";
			result += "<td>"+error[7]+"</td>";
			result += "</tr>";
		}
		result += FOOTER;
		return result;
	}
}

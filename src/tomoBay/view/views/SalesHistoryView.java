package tomoBay.view.views;

import java.util.List;

import tomoBay.view.AbstractView;
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

/**
 *
 * @author Jan P.C. Hanson
 *
 */
public class SalesHistoryView implements AbstractView
{

	/* (non-Javadoc)
	 * @see tomoBay.view.AbstractView#format(java.util.List)
	 */
	@Override
	public String format(List<String[]> input)
	{
		String result = "{ \"tableData\":[\n";
		
		for (String[] cols : input)
		{
			result+="{";
			result+="\"Select\":\"<input type='checkbox' class = 'chcktbl filterable-cell ' />\", ";
			result+="\"Name\":\""+cols[1].trim()+"\", ";
			result+="\"Date\":\""+cols[4].trim()+"\", ";
			result+="\"SalesRecNo\":\""+cols[2].trim()+"\", ";
			result+="\"Details\":\"<button class='btn btn-primary' value='"+cols[0].trim()+"'>View</button>\"";
			result+="},\n";
		}
		
		result+=" ]}";
		return  this.replaceLast(result, ",", "");
	}

	
	private String replaceLast(String string, String target, String replacement)
	{
	  int index = string.lastIndexOf(target);
	  if (index == -1)
	    return string;
	  return string.substring(0, index) + replacement
	          + string.substring(index+target.length());
	}
}

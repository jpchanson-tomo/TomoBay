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
import tomoBay.model.dataTypes.ServerStatus;
import tomoBay.view.AbstractView;

import java.util.List;
/**
 * This class is responsible for formatting the data passed to it by the SalesOrderPresenter and
 * providing a string that can be displayed by the AJAX requestor. The data is formatted as a 
 * 6 column html table with the column headings: type=checkbox class=chckbl, 'Name' class=name,
 * 'Date' class=date, 'shippingType' class=shippingType, 'Details' class=details contains button,
 * 'Status' class=status.
 * @author Jan P.C. Hanson
 *
 */
public class SalesOrderView implements AbstractView
{
	/**
	 * default ctor.
	 */
	public SalesOrderView()
	{super();}
	
	/* (non-Javadoc)
	 * @see openDMS.view.views.AbstractView#format(openDMS.view.views.AbstractView)
	 */
	@Override
	public String format(List<String[]> input) 
	{
		String result = "{ \"tableData\":[\n";
		int n = 0;	
			for (String[] cols : input)
			{
				result+="{";
				result+=" \"Select\": \"<input type='checkbox' class='chcktbl'/><div style='visibility:hidden;'>"+n+"</div>\" ,";
				result+=" \"Name\": \""+cols[1].trim()+"\", ";
				result+=" \"Date\": \""+cols[4].trim()+"\", ";
				result+=" \"SalesRecNo\": \""+cols[2].trim()+"\", ";
				result+=" \"ShippingType\": \""+cols[3].trim()+"\", ";
				result+=" \"Details\": \""+"<button class='btn btn-primary' value='"+cols[0].trim()+"'>View</button>"+"\" ,";
				result+=" \"Status\": \""+this.pickeability(cols[8])+"\" ";
				result+="}, \n";
				n++;
			}
			
		result+=" ]}";
		return  this.replaceLast(result, ",", "");
	}
	
	/**
	 * defines a set of set of String values that equate to the 'invoiced' values grabbed from the
	 * database.
	 * @param invoiced int between 0 and 3 grabbed from the database: 0='Pickeable', 1='Partially 
	 * pickable', 2='Unpickeable', 3='ERROR'.
	 * @return one of the above string values Pickeable/Partial/Unpickeable/ERROR.
	 */
	private String pickeability(String invoiced)
	{
		String pickeability="";
		if(ServerStatus.getStatus()!=ServerStatus.RunLevel.RUNNING) {pickeability = "Services Not Running";}
		else if(Integer.parseInt(invoiced)==3){pickeability = "ERROR";}
		else if(Integer.parseInt(invoiced)==2){pickeability = "Unpickeable";}
		else if(Integer.parseInt(invoiced)==1){pickeability = "Partial";}
		else if(Integer.parseInt(invoiced)==0){pickeability = "Pickeable";}
		
		return pickeability;
	}
	
	/**
	 * replace the last instance of a particular character in a string with another.
	 * @param string the string to analyse
	 * @param target the String whose last instance is replaced by target
	 * @param replacement the String to replace the last instance of target with.
	 * @return String with the last instance of target replaced by replacement.
	 */
	private String replaceLast(String string, String target, String replacement)
	{
	  int index = string.lastIndexOf(target);
	  if (index == -1)
	    return string;
	  return string.substring(0, index) + replacement
	          + string.substring(index+target.length());
	}
}

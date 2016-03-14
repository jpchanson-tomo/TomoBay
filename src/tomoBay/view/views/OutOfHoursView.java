package tomoBay.view.views;

import java.util.List;

import tomoBay.model.dataTypes.heteroTypeContainer.ClassRef;
import tomoBay.model.dataTypes.heteroTypeContainer.HeteroFieldContainer;
import tomoBay.model.sql.schema.ordersTable.OrdersTable;
import tomoBay.model.sql.schema.outOfHoursTable.OutOfHoursTable;
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
public final class OutOfHoursView implements AbstractView
{

	/* (non-Javadoc)
	 * @see tomoBay.view.AbstractView#format(java.util.List)
	 */
	@Override
	public String format(List<HeteroFieldContainer> input)
	{
		String result = "{ \"tableData\":[\n";
		int n = 0;	
			for (HeteroFieldContainer cols : input)
			{
				result+="{";
				result+=" \"No.\": \""+n+"\", ";
				result+=" \"OutOfHours\": \""+cols.get(OutOfHoursTable.DATE, ClassRef.DATE).toString()+"\", ";
				result+=" \"SalesRecNo\": \""+cols.get(OrdersTable.SALES_REC_NO, ClassRef.INTEGER)+"\", ";
				result+=" \"CreatedTime\": \""+cols.get(OrdersTable.CREATED_TIME, ClassRef.TIMESTAMP).toString()+"\", ";
				result+=" \"OrderTotal\": \"<div class='price'>"+cols.get(OrdersTable.ORDER_TOTAL, ClassRef.FLOAT)+"</div>\", ";
				result+=" \"Details\": \""+"<button class='btn btn-primary' value='"+cols.get(OrdersTable.SALES_REC_NO, ClassRef.INTEGER)+"'>View</button>"+"\"";
				result+="}, \n";
				n++;
			}
			
		result+=" ]}";
		return  this.replaceLast(result, ",", "");
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

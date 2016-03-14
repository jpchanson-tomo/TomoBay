package tomoBay.view.views;

import java.util.List;

import tomoBay.model.dataTypes.heteroTypeContainer.ClassRef;
import tomoBay.model.dataTypes.heteroTypeContainer.HeteroFieldContainer;
import tomoBay.model.sql.schema.ordersTable.OrdersTable;
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
public final class SalesHistoryView implements AbstractView
{

	/* (non-Javadoc)
	 * @see tomoBay.view.AbstractView#format(java.util.List)
	 */
	@Override
	public String format(List<HeteroFieldContainer> input)
	{
		String result = "{ \"tableData\":[\n";
		
		for (HeteroFieldContainer cols : input)
		{
			result+="{";
			result+="\"Select\":\"<input type='checkbox' class = 'chcktbl filterable-cell ' />\", ";
			result+="\"Name\":\""+cols.get(OrdersTable.BUYERID, ClassRef.STRING).trim()+"\", ";
			result+="\"Date\":\""+cols.get(OrdersTable.CREATED_TIME, ClassRef.TIMESTAMP)+"\", ";
			result+="\"SalesRecNo\":\""+cols.get(OrdersTable.SALES_REC_NO, ClassRef.INTEGER)+"\", ";
			result+="\"Details\":\"<button class='btn btn-primary' value='"+cols.get(OrdersTable.ORDER_ID, ClassRef.STRING).trim()+"'>View</button>\"";
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

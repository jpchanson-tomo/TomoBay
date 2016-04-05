package tomoBay.view.views.salesOrderView;
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

import tomoBay.model.dataTypes.ServerStatus;
import tomoBay.model.dataTypes.heteroTypeContainer.ClassRef;
import tomoBay.model.dataTypes.heteroTypeContainer.HeteroFieldContainer;
import tomoBay.model.eBayAPI.EbayAccounts;
import tomoBay.model.sql.schema.ordersTable.OrdersTable;
import tomoBay.presenters.helpers.pickeability.PickeableStatus;
import tomoBay.view.AbstractView;
/**
 * This class is responsible for formatting the data passed to it by the SalesOrderPresenter and
 * providing a string that can be displayed by the AJAX requestor. The data is formatted as a 
 * 6 column html table with the column headings: type=checkbox class=chckbl, 'Name' class=name,
 * 'Date' class=date, 'shippingType' class=shippingType, 'Details' class=details contains button,
 * 'Status' class=status.
 * @author Jan P.C. Hanson
 *
 */
public final class SalesOrderView implements AbstractView
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
	public String format(List<HeteroFieldContainer> input) 
	{
		String result = "{ \"tableData\":[\n";
		int n = 0;	
			for (HeteroFieldContainer cols : input)
			{
				result+="{";
				result+=" \"Select\": \"<input type='checkbox' class='chcktbl' id='"
								+cols.get(OrdersTable.ORDER_ID, ClassRef.STRING).trim()
								+"'/><div style='visibility:hidden;'>"+n+"</div>\" ,";
				
				result+=" \"Name\": \""+cols.get(OrdersTable.BUYERID, ClassRef.STRING).trim()+"\", ";
				result+=" \"Date\": \""+cols.get(OrdersTable.CREATED_TIME, ClassRef.TIMESTAMP).toString().trim()+"\", ";
				result+=" \"SalesRecNo\": \""+cols.get(OrdersTable.SALES_REC_NO, ClassRef.INTEGER).toString().trim()+"\", ";
				result+="\"Account\":\""+EbayAccounts.name(cols.get(OrdersTable.ACCOUNT, ClassRef.INTEGER))+"\",";
				result+=" \"ShippingType\": \""+cols.get(OrdersTable.SHIPPING_TYPE, ClassRef.STRING).trim()+"\", ";
				result+=" \"Details\": \""+"<a href='/order.html?"+cols.get(OrdersTable.ORDER_ID, ClassRef.STRING).trim()+"?' class='btn btn-primary'>View</button>"+"\" ,";
				result+=" \"Status\": \""+this.pickeability(cols.get(OrdersTable.INVOICED, ClassRef.INTEGER))+"\" ";
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
	private String pickeability(int invoiced)
	{
		String pickeability="";
		if(ServerStatus.getStatus()!=ServerStatus.RunLevel.RUNNING) {pickeability = "Services Not Running";}
		else {pickeability = OrderStatusContext.get(invoiced);}
		
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

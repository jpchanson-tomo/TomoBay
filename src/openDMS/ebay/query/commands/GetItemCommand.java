package openDMS.ebay.query.commands;
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
import openDMS.ebay.query.data.ApiCallData;
import openDMS.ebay.query.recievers.ItemCall;
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
import com.ebay.soap.eBLBaseComponents.NameValueListType;
/**
 *
 * @author Jan P.C. Hanson
 *
 */
public class GetItemCommand extends AbstractEbayQuery
{

	/* (non-Javadoc)
	 * @see openDMS.ebay.query.commands.AbstractEbayQuery#execute(openDMS.ebay.query.data.ApiCallData, int, java.lang.String)
	 */
	@Override
	public String execute(ApiCallData callData, int NOTUSED, String itemID)
	{
		super.callData_M = callData;
		super.callData_M.accessItemData().clearData();
		
		ItemCall item = new ItemCall(super.callData_M.getUserToken(), super.callData_M.getServerString());
		item.call(super.callData_M.accessItemData(), itemID);
		
		NameValueListType[] tmp = super.callData_M.accessItemData().accessData(0).getItemSpecifics().getNameValueList();
        String result="<itemID>"+itemID+"</itemID>\n";
        result+= "<Title>"+super.callData_M.accessItemData().accessData(0).getTitle()+"</Title>\n";
    	result+= "<PrimaryCategory>"+super.callData_M.accessItemData().accessData(0).getPrimaryCategory().getCategoryName()+"</PrimaryCategory>\n";
    	result+= "<Condition>"+super.callData_M.accessItemData().accessData(0).getConditionDefinition()+"<Condition>\n";
    	
        for(int i = 0; i < tmp.length; ++i)
        {
        	result += "<"+tmp[i].getName().replaceAll("\\s","") + ">";
        	for (String itemSpecific : tmp[i].getValue())
        	{result+= itemSpecific;}
        	result += "</"+tmp[i].getName().replaceAll("\\s","") + ">\n";
        }
		return "<Item>\n"+result+"</Item>\n";
	}

	/* (non-Javadoc)
	 * @see openDMS.ebay.query.commands.AbstractEbayQuery#getCallData()
	 */
	@Override
	public ApiCallData getCallData()
	{
		// TODO Auto-generated method stub
		return null;
	}

}

package tomoBay.model.services.reScanErrorsService;
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
import tomoBay.helpers.BrandToCode;
import tomoBay.model.dataTypes.PartList;
import tomoBay.model.winstock.Stock;
/**
 * This class encapsulates all CheckErrorsService interactions with Winstock. 
 * @author Jan P.C. Hanson
 *
 */
public final class ReScanErrorsWinstockActions
{
	/**
	 * default ctor
	 */
	public ReScanErrorsWinstockActions()
	{super();}
	
	/**
	 * this method checks to see if a particular item (through the ItemSpecifics passed in as 
	 * an argument) has errors, if none of the part numbers contained in the ItemSpecifics are 
	 * erroneous then this method returns true, otherwise it will return false as soon as it 
	 * deiscovers an error i.e. does not get a valid response from WinStock
	 * @param item the ItemSpecifics for the item that we wish to check for errors
	 * @return true if no errors exist, false otherwise.
	 */
	public boolean partNoHasError(ItemSpecifics item)
	{
		try 
		{
			PartList partList = new PartList(item.get("ManufacturerPartNumber"));
			Stock errorCheck = new Stock();
			for (String partNo : partList.getPartNumbers())
			{
					int result = errorCheck.requestStockLevel(partNo, BrandToCode.convertToInt(item.get("Brand"))+"");
					if(result == -8008135) {return true;}
			}
		}
		catch (NullPointerException npe)
		{return true;}
		return false;
	}
}

package tomoBay.model.dataTypes.order;
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
import java.util.ArrayList;
import java.util.List;

import tomoBay.model.dataTypes.Part;
import tomoBay.model.services.helpers.PartList;

/**
 *
 * @author Jan P.C. Hanson
 *
 */
public final class PopulatePartInfo
{
	/**
	 * default ctor
	 */
	public PopulatePartInfo()
	{super();}
	
	/**
	 * 
	 * @return
	 */
	public final static List<Part> getInfo(List<String[]> rawData)
	{
		List<Part> partInfo_M = new ArrayList<Part>();
		for (int i = 0 ; i < rawData.size() ; ++i)
		{
			PartList parts = new PartList(rawData.get(i)[7]);
			
			for (int j = 0 ; j < parts.size() ; ++j)
			{
				partInfo_M.add(new Part(parts.getPartNumber(j), rawData.get(i)[6]));
			}
		}
		return partInfo_M;
	}
}

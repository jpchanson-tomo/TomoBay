package tomoBay.model.royalMail.calls.DI;
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
import gnu.trove.map.hash.THashMap;

import java.util.Map;
/**
 *
 * @author Jan P.C. Hanson
 *
 */
public final class RoyalMailDIContainer
{
	public enum RoyalMailObjType
	{
		SOAP_MESSAGE,
		SOAP_HEADER,
		SOAP_BODY
	}
	
	private static final Map<RoyalMailObjType, Object> DI 
										= new THashMap<RoyalMailObjType, Object>();
	{{
		DI.put(RoyalMailObjType.SOAP_HEADER, new SOAPHeaderFactory());
	}}
	
	/**
	 * 
	 */
	public RoyalMailDIContainer()
	{super();}

	@SuppressWarnings("unchecked")
	public <T> T getFactory(RoyalMailObjType object, Class<T> type)
	{
		Class<Integer> test = Integer.class;
		return (T)DI.get(object);
	}
}

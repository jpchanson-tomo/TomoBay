package tomoBay.model.winstock.payloads.components;

import java.util.List;
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

import tomoBay.exceptions.PayloadException;

/**
 *
 * @author Jan P.C. Hanson
 *
 */
public final class PostCodeComponent extends AbstractPayloadComponent
{
	/**the total length of the component**/
	private static final byte LENGTH = 10;
	/**
	 * default ctor
	 */
	public PostCodeComponent()
	{super();}

	/* (non-Javadoc)
	 * @see tomoBay.model.winstock.payloads.AbstractPayloadComponent#convert(java.lang.String)
	 */
	@Override
	public List<Byte> convert(String input) throws PayloadException
	{
		if (input.length() < LENGTH)
		{
			byte b = 0;
			List<Byte> output = super.addString(input);
			for(int i = input.length() ; i < LENGTH ; ++i) {output.add(b);}
			return output;
		}
		else
		{throw new PayloadException("Postcode too long: " + input.length()+"/"+LENGTH);}
	}
}

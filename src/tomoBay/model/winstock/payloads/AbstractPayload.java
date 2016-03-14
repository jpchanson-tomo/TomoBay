package tomoBay.model.winstock.payloads;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import tomoBay.exceptions.PayloadException;
import tomoBay.model.dataTypes.DualList;
import tomoBay.model.winstock.payloads.componentFactories.AbstractComponentFactory;
/**
 * This is the abstract base class for all Payload sub types. This allows a different payload 
 * to be created for each type of Winstock command that exists.
 * @author Jan P.C. Hanson
 *
 */
public class AbstractPayload
{	/**the header bytes as a string (add these to the start of the byte[])**/
	protected static final String HEADER_M = "WSC0";
	/**the header byte (add to end of byte[])**/
	protected static final byte FOOTER_M = (byte) 0xAA;
	/**the resulting list.**/
	protected List<Byte> result_M = new ArrayList<Byte>();
	
	protected Map<PayloadType, AbstractComponentFactory> payloadBuilder_M = 
			new HashMap<PayloadType, AbstractComponentFactory>();
	
	/**
	 * default ctor
	 */
	public AbstractPayload()
	{super();}
	
	/**
	 * This method contains the implementiation for the specific command that this payload is
	 * applicable to.
	 */
	public byte[] getPayload(DualList<String, PayloadType> input) throws PayloadException
	{
		//add header to start of List<Byte>
		for(byte head : AbstractPayload.HEADER_M.getBytes()) {this.result_M.add(head);}
				
		for (int i = 0 ; i < input.size() ; ++i)
		{
			this.result_M.addAll(this.payloadBuilder_M.get(input.getValue2(i)).make()
													.convert(input.getValue1(i)));
		}
				
		this.result_M.add(AbstractPayload.FOOTER_M); // add footer to the end of the List<Byte>
		return this.getResult();
	}
	
	/**
	 * reassembles the internal list as a byte[] that can be passed straight to the ClientSockets
	 * object.
	 * @param listToConvert
	 * @return
	 */
	private byte[] getResult()
	{
		byte[] endResult = new byte[this.result_M.size()];

		for(int i = 0 ; i < endResult.length ; ++i)
		{endResult[i] = this.result_M.get(i);}

		return endResult;
	}
}
package tomoBay.model.winstock.payloads.components;
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
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;

import tomoBay.exceptions.PayloadException;
/**
 *
 * @author Jan P.C. Hanson
 *
 */
public abstract class AbstractPayloadComponent
{
	/****/
	protected List<Byte> result_M;
	
	/**
	 * 
	 */
	public AbstractPayloadComponent()
	{
		super();
		this.result_M = new ArrayList<Byte>();
	}
	
	/**
	 * this method converts the string passed in as input to the call into a list of bytes as 
	 * appropriate to the specific AbstractPayloadComponent derived object.
	 * @param input String input to be converted
	 * @return List<Byte> appropriate to this specific instance
	 */
	public abstract List<Byte> convert(String input) throws PayloadException;
	

	/**
	 * converts the string into a byte[]
	 * @param string to be converted
	 * @return byte[] representing the string passed in.
	 */
	protected List<Byte> addString(String string)
	{
		this.result_M.clear();
		byte[] stringToAdd = string.getBytes();
		for(byte charInArray : stringToAdd) {this.result_M.add(charInArray);}
		return this.result_M;
	}
	
	/**
	 * add a byte to the byte list
	 * @param bite the byte in question
	 * @return
	 * @throws PayloadException
	 */
	protected List<Byte> addByte(String bite) throws PayloadException
	{
		this.result_M.clear();
		if (Integer.parseInt(bite) <= 255)
		{this.result_M.add(Byte.parseByte(bite));}
		else
		{throw new PayloadException("this is not a byte: "+bite);}
		return this.result_M;
	}
	
	/**
	 * converts the integer passed into this method into a byte[] in little endian format.
	 * @param integer the integer to be converted
	 * @return byte[] little endian representation of the integer passed in 
	 */
	protected List<Byte> addInt(String integer)
	{
		this.result_M.clear();
		ByteBuffer buffer = ByteBuffer.allocate(4);
		buffer.order(ByteOrder.LITTLE_ENDIAN);
		buffer.putInt(Integer.parseInt(integer));
		
		for(byte bt : buffer.array())
		{this.result_M.add(bt);}
		return this.result_M;
	}
	
	/**
	 * converts the short passed into this method into a byte[] in little endian format.
	 * @param smallInt the short to be converted
	 * @return
	 */
	protected List<Byte> addShort(String smallInt)
	{
		this.result_M.clear();
		ByteBuffer buffer = ByteBuffer.allocate(2);
		buffer.order(ByteOrder.LITTLE_ENDIAN);
		buffer.putShort(Short.parseShort(smallInt));
		
		for(byte bt : buffer.array())
		{this.result_M.add(bt);}
		return this.result_M;
	}
}

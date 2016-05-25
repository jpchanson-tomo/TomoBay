package tomoBay.model.royalMail;
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
import java.util.Base64;
import java.util.Random;

import tomoBay.security.AbstractNonce;

/**
 * This class represents the functionality to generate a nonce (number used once), and to encode it
 * as per the Royal Mail Technical User Guide specification (page 20).
 * 
 * @see <a href="https://developer.royalmail.net/api/docdownload/aHR0cHM6Ly9ldS5hcGltLmlibWNsb3VkLmNvbS92MS9wb3J0YWwvb3Jncy81NzJjNzQ4NzBjZjIzNjMyMjQyZWM1ZDEvYXBpcy81NjBkMTViZjBjZjI5M2Q5MzFhM2NmOGMvdjE4L2RvY3VtZW50cy9STUclMjBTaGlwcGluZyUyMEFQSSUyMCUyOFNPQVAlMjklMjBUZWNobmljYWwlMjBVc2VyJTIwR3VpZGUvZmlsZQ%3D%3D">
 * Royal Mail Technical User Guide</a>
 * 
 * @author Jan P.C. Hanson
 *
 */
public final class RoyalMailNonce implements AbstractNonce<String, Integer>
{
	private static final int MAXIMUM = 2147483645;
	/**
	 * default ctor
	 */
	public RoyalMailNonce()
	{super();}

	/** 
	 * get the nonce
	 * @return Integer nonce
	 * @see tomoBay.security.AbstractNonce#get()
	 */
	@Override
	public Integer get()
	{return new Random().nextInt(MAXIMUM);}
	
	/**
	 * convert the nonce into a Base64 encoded string
	 * @return String in Base64 encoding representing the nonce
	 */
	public String encode()
	{
		byte[] nonceInBytes = ByteBuffer.allocate(4).putInt(this.get()).array();
		return Base64.getEncoder().encodeToString(nonceInBytes);
	}
}
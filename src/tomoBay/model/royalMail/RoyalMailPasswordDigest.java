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
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;

import tomoBay.security.AbstractDigest;
/**
 * This class creates a password digest of the form seen below:
 * 
 * @code digest = base64_encode(SHA-11(nonce + creationdate + SHA-1(password)) @endcode
 * 
 * @author Jan P.C. Hanson
 *
 */
public final class RoyalMailPasswordDigest implements AbstractDigest<String>
{
	/**number used once**/
	private final int nonce_M;
	/**the date/time the api call was created, of the form: 2016-04-27T14:12:04.852Z**/
	private final Date createdDate_M;
	/**the API password**/
	private final String password_M;
	
	/**
	 * constructor initialises the RoyalMailPasswordDigest using the parameters: nonce, createdDate 
	 * and password.
	 * 
	 * @param nonce an integer value that MAY NOT repeat during at minimum a 5 minute window.
	 * @param createdDate the date/time that the API call was created, of the form: @code 2016-04-27T14:12:04.852Z @endcode
	 * @param password the API password
	 */
	public RoyalMailPasswordDigest(int nonce, Date createdDate, String password)
	{
		super();
		this.nonce_M = nonce;
		this.createdDate_M = createdDate;
		this.password_M = password;
	}

	/* (non-Javadoc)
	 * @see tomoBay.security.AbstractDigest#digest()
	 */
	@Override
	public String digest()
	{
		try
		{
			final String passwordConcat 
					= this.nonce_M + this.createdDate_M.toString() + this.sha1HashFn(this.password_M);
			final byte[] digest = this.sha1HashFn(passwordConcat);
			return Base64.getEncoder().encodeToString(digest);
			
		} 
		catch (NoSuchAlgorithmException e)
		{
			e.printStackTrace();
			return "problem converting password to sha-1";
		}
	}

	
	/**
	 * This method creates an SHA-1 hash of the message provided.
	 * @param message the message to find the SHA-1 hash of
	 * @return byte[] containing the hashed message
	 * @throws NoSuchAlgorithmException
	 */
	private final byte[] sha1HashFn(String message) throws NoSuchAlgorithmException
	{
		MessageDigest pwd = MessageDigest.getInstance("SHA-1");
		pwd.reset();
		pwd.update(message.getBytes());
		return pwd.digest();
	}
}

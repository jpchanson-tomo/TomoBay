package tomoBayTests.model.royalMail;
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
import static org.junit.Assert.fail;

import java.util.Base64;
import java.util.Date;

import org.junit.Test;

import tomoBay.model.royalMail.RoyalMailPasswordDigest;
import tomoBayTests.testHelpers.FieldReflection;
/**
 *	@test
 *		Unit test for the RoyalMailPasswordDigest class, the only tests that can be performed are to
 *	make sure that there is no unexpected behavior which would cause exceptions to be thrown. Due to 
 * the nature of hash functions(mathematically one way), there is no way (that i can see) of doing 
 * any other meaningful testing.
 *	@pre
 *	- none
 *	@post
 *	- the RoyalMailPasswordDigest object can be instantiated without unwanted behaviour
 *	- the creation of password digests causes no unwanted behaviour.
 *	
 * @author Jan P.C. Hanson
 *
 */
public class RoyalMailPasswordDigestTest implements FieldReflection
{

	/**
	 * @test
	 * This test case makes sure that the RoyalMailPasswordDigest object can be initialised without 
	 * unwanted behaviour.
	 * 
	 * @pre
	 * 	- none
	 * @post
	 * 	- RoyalMailPasswordDigest object can be initialised without unwanted behaviour
	 * 
	 * @see tomoBay.model.royalMail.RoyalMailPasswordDigest#RoyalMailPasswordDigest()
	 */
	@SuppressWarnings("unused")
	@Test
	public final void testRoyalMailPasswordDigest()
	{
		try
		{
			RoyalMailPasswordDigest test = new RoyalMailPasswordDigest(1234, new Date(), "password");
			test = new RoyalMailPasswordDigest(0, new Date(),"0password()[]{}@';:#~`¬|/?><,.") ;
			test = new RoyalMailPasswordDigest(0123, new Date(), "");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			fail("Exception during initialisation");
		}
	}

	/**
	 * @test
	 * This test makes sure that given a variety of inputs no unexpected behaviour(causing exceptions)
	 * happens while generating the digest.
	 * @pre
	 *		- none
	 *	@post
	 *	- the creation of password digests causes no unwanted behaviour.
	 *	
	 * @see tomoBay.model.royalMail.RoyalMailPasswordDigest#digest()
	 */
	@Test
	public final void testDigest() throws NoSuchFieldException, SecurityException
	{
		try
		{
			RoyalMailPasswordDigest test = new RoyalMailPasswordDigest(1234, new Date(), "password");
			byte[] decoded = Base64.getDecoder().decode(test.digest());
			@SuppressWarnings("unused")
			String result = new String(decoded);
			
			test = new RoyalMailPasswordDigest(0, new Date(),"0password()[]{}@';:#~`¬|/?><,.") ;
			decoded = Base64.getDecoder().decode(test.digest());
			result = new String(decoded);
			
			test = new RoyalMailPasswordDigest(0123, new Date(), "");
			decoded = Base64.getDecoder().decode(test.digest());
			result = new String(decoded);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			fail("Exception thrown: you aint getting more info than that");
		}
	}

}

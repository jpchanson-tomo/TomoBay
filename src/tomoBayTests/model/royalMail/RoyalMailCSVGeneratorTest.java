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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.Test;

import tomoBay.helpers.Config;
import tomoBay.helpers.ConfigReader;
import tomoBay.model.royalMail.RoyalMailCSVGenerator;
/**
 * Unit test case for tomoBay.model.royalMail.RoyalMailCSVGenerator
 * 
 * @test all functionality contained within the RoyalMailCSVGenerator class
 * 
 * @pre none
 * 
 * @post 
 * - a RoyalMailCSVGenerator object should behave reasonable as defined by the tests carried out. 
 * 
 * @see  tomoBay.model.royalMail.RoyalMailCSVGenerator
 * 
 * @author Jan P.C. Hanson
 *
 */
public class RoyalMailCSVGeneratorTest
{
	/**good test data set 1**/
	private static final String[] goodTestData1 
	= {"SR1","24"," jan bob hanson-baloon","2 lexington apartements","Railway terrace","sl2 5gq","Slough","GB","C123456","1","300","SF","L"};
	/**good test data set 2**/
	private static final String[] goodTestData2 
	= {"SR1","24"," jan bob hanson-baloon","2 lexington apartements","Railway terrace","sl2 5gq","Slough","GB","C123456","1","300","SF","L"};
	/**good test data set 3**/
	private static final String[] goodTestData3 
	= {"SR1","24"," jan bob hanson-baloon","2 lexington apartements","Railway terrace","sl2 5gq","Slough","GB","C123456","1","300","SF","L"};
	/**bad data set 1: extra quote in first column **/
	private static final String[] badTestData1 
	= {"SR1\"","24"," jan bob hanson-baloon","2 lexington apartements\"","Railway terrace","sl2 5gq","Slough","GB","C123456","1","300","SF","L"};
	/**bad data set 2: non allowed char in column 4**/
	private static final String[] badTestData2 
	= {"SR1","24"," jan bob hanson-baloon","<>2 lexington apartements","Railway terrace","sl2 5gq","Slough","GB","C123456","1","300","SF","L"};
	/**bad data set 3: invalid option in column 12**/
	private static final String[] badTestData3 
	= {"SR1","24"," jan bob hanson-baloon","<>2 lexington apartements","Railway terrace","sl2 5gq","Slough","GB","C123456^","1","300","ABC","L"};
	
	/**
	 * @test instantiation test of the RoyalMailCSVGenerator class, guaruntees that object can be 
	 * initialised without issue (default constructor).
	 * 
	 * @pre none
	 * 
	 * @post fully initialised instance of the RoyalMailCSVGenerator available for use.
	 * 
	 * @see tomoBay.model.royalMail.RoyalMailCSVGenerator#RoyalMailCSVGenerator().
	 */
	@Test
	public final void testRoyalMailCSVGenerator()
	{
		try 
		{
			RoyalMailCSVGenerator csv = new RoyalMailCSVGenerator();
			assertNotNull(csv);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			fail("initialisation threw an exception");
		}
	}

	/**
	 * @test guaruntees that the setSeparators method behaves as expected  the default quotes and
	 * commas are replaced with the chars presented.
	 * 
	 * @pre requires that the toString method works as expected.
	 * 
	 * @post separators will remain set until this method is called again. 
	 * 
	 * @see tomoBay.model.royalMail.RoyalMailCSVGenerator#setseparators(char, char).
	 */
	@Test
	public final void testSetseparators()
	{
		RoyalMailCSVGenerator csv = new RoyalMailCSVGenerator();
		csv.setseparators('@', '%');
		String idealResult = "%SR1%@%24%@% jan bob hanson-baloon%@%2 lexington apartements%@%Railway terrace%@%sl2 5gq%@%Slough%@%GB%@%C123456%@%1%@%300%@%SF%@%L%@\n";
		csv.addRow(goodTestData1);
		assertEquals(csv.toString(), idealResult);
	}

	/**
	 * @test makes sure that the addRow method will correctly add a row to the csv 
	 * 
	 * @pre
	 * - the toString method works as expected.
	 * - the array provided is the same size as the number of CSV_FIELD's in config/tomoBay.conf
	 * - the input for each column matches its corresponding regex validation string found in the 
	 * CSV_FIELD_VALIDATION tags in config/tomoBay.conf.
	 * 
	 * @post 
	 * - Data can be added to the csv file as stated in the pre-condition.
	 * - an ArrayStoreException will be thrown if the data provided fails validataion
	 * - an ArrayIndexOutOfBoundsException will be thrown if the size of the String[] provided is different
	 * from the number of fields available in the config file. The error message in the exception will reflect
	 * whether the array provided is too large or too small.
	 *
	 * 
	 * @see tomoBay.model.royalMail.RoyalMailCSVGenerator#addRow(java.lang.String[]).
	 */
	@Test
	public final void testAddRow()
	{
		RoyalMailCSVGenerator csv = new RoyalMailCSVGenerator();
		//case of ideal input
		try 
		{
			csv.addRow(RoyalMailCSVGeneratorTest.goodTestData1);
			csv.addRow(RoyalMailCSVGeneratorTest.goodTestData2);
			csv.addRow(RoyalMailCSVGeneratorTest.goodTestData3);
		}
		catch(Exception e)
		{fail("no exception should be thrown when passing in good data");}
		
		//case of dodgy inputs
		try
		{
			csv.addRow(RoyalMailCSVGeneratorTest.badTestData1);
			csv.addRow(RoyalMailCSVGeneratorTest.badTestData2);
			csv.addRow(RoyalMailCSVGeneratorTest.badTestData3);
		}
		catch(ArrayStoreException ase)
		{assertTrue(true);}
		catch(ArrayIndexOutOfBoundsException aioobe)
		{assertTrue(true);}
		catch(Exception e)
		{fail("an unrecognised exception has been thrown");}
	}

	/**
	 * @test makes sure that the addBatch method allows you to add batches of data in the form of a 
	 * List<String[]>
	 * 
	 * @pre 
	 * - the toString method works as expected:
	 * - the arrays provided in the List<String[]> are the same size as the number of CSV_FIELD's 
	 * in config/tomoBay.conf
	 * - the input for each column in an individual array of the List<String[]> matches its corresponding 
	 * regex validation string found in the CSV_FIELD_VALIDATION tags in config/tomoBay.conf.
	 * 
	 * @post
	 * - Data can be added to the csv file as stated in the pre-condition.
	 * - an ArrayStoreException will be thrown if the data provided fails validataion
	 * - an ArrayIndexOutOfBoundsException will be thrown if the size of the String[] provided is different
	 * from the number of fields available in the config file. The error message in the exception will reflect
	 * whether the array provided is too large or too small.
	 * 
	 * @see tomoBay.model.royalMail.RoyalMailCSVGenerator#addBatch(java.util.List).
	 */
	@Test
	public final void testAddBatch()
	{
		RoyalMailCSVGenerator csv = new RoyalMailCSVGenerator();
		
		//good data
		List<String[]> goodData = new ArrayList<String[]>();
		goodData.add(RoyalMailCSVGeneratorTest.goodTestData1);
		goodData.add(RoyalMailCSVGeneratorTest.goodTestData2);
		goodData.add(RoyalMailCSVGeneratorTest.goodTestData3);
		
		//bad data
		List<String[]> badData = new ArrayList<String[]>();
		badData.add(RoyalMailCSVGeneratorTest.badTestData1);
		badData.add(RoyalMailCSVGeneratorTest.badTestData2);
		badData.add(RoyalMailCSVGeneratorTest.badTestData3);
		
		//case:good data
		try 
		{csv.addBatch(goodData);}
		catch(Exception e)
		{fail("no exception should be thrown when passing in good data");}
		
		//case: bad data
		try
		{csv.addBatch(badData);}
		catch(ArrayStoreException ase)
		{assertTrue(true);}
		catch(ArrayIndexOutOfBoundsException aioobe)
		{assertTrue(true);}
		catch(Exception e)
		{fail("an unrecognised exception has been thrown");}
	}

	/**
	 * @test makes sure that the generate method produces a file, and that it is in the format required.
	 * 
	 * @pre
	 * - the addRow method behaves as expected
	 * - valid data is passed into the addRow method
	 * 
	 * @post
	 * - A file is produced that corresponds to the path and filename provided
	 * - this file is a properly formatted csv file 
	 * - if invalid data is passed in then an excetion should be thrown 
	 * see {@link tomoBayTests.model.royalMail.RoyalMailCSVGeneratorTest#testAddRow()}
	 * 
	 * @see tomoBay.model.royalMail.RoyalMailCSVGenerator#generate(java.lang.String, java.lang.String, java.lang.String).
	 */
	@Test
	public final void testGenerate()
	{
		RoyalMailCSVGenerator csv = new RoyalMailCSVGenerator();
		csv.addRow(RoyalMailCSVGeneratorTest.goodTestData1);
		csv.addRow(RoyalMailCSVGeneratorTest.goodTestData2);
		csv.addRow(RoyalMailCSVGeneratorTest.goodTestData3);
		try
		{
			csv.generate("RoyalMail.CSV", "./views/resources/", "UTF-8");
		} catch (IOException e)
		{e.printStackTrace();fail("something went wrong creating the file");}
		
		String csvRegex = "(\"([\\w\\d\\s-_:;'@+()&\\/,#]*)\",\n?)*";
		try
		{
			Scanner fileReader = new Scanner(new File("./logs/RoyalMail.CSV"));
			String fileContent = fileReader.useDelimiter("\\Z").next();
			fileReader.close();
			assertTrue(fileContent.matches(csvRegex));
			
		} catch (FileNotFoundException e)
		{e.printStackTrace();fail("something went wrong reading the file");}
		
	}

	/**
	 * @test makes sure that the size method returns an integer equal to the number of columns 
	 * specified in the config file (tomoBay.conf)
	 * 
	 * @pre tomoBay.helpers.ConfigReader behaves as expected
	 * 
	 * @post testSize returns an integer equal to the number of CSV_FIELD_NAME tag pairs in the config
	 * file
	 * 
	 * @see tomoBay.model.royalMail.RoyalMailCSVGenerator#size()
	 */
	@Test
	public final void testSize()
	{
		RoyalMailCSVGenerator csv = new RoyalMailCSVGenerator();
		int result = ConfigReader.size(Config.CSV_FIELD_NAME);
		assertEquals(result, csv.size());
	}

	/**
	 * @test makes sure that the toString method behaves appropriately given valid inputs
	 * 
	 * @pre 
	 * - the data provided to the toString method is valid and of the correct size.
	 * - the addRow method behaves as expected.
	 * 
	 * @post
	 * - the method will produce a well formatted csv string
	 * - linebreaks are placed at the end of eachline
	 * - only the special chars  -_:;'\@()\\/,\# are allowed within the csv
	 * 
	 * @see tomoBay.model.royalMail.RoyalMailCSVGenerator#toString().
	 * 
	 */
	@Test
	public final void testToStringGoodInput()
	{
		//magical regex, allows commas inside quotes
		String csvRegex = "(\"([\\w\\d\\s-_:;'@+()&\\/,#]*)\",\n?)*";
		
		//test the case where good data is passed in
		RoyalMailCSVGenerator csv = new RoyalMailCSVGenerator();
		for(int i = 0 ; i < 10 ; ++i)
		{
			csv.addRow(goodTestData1);
			csv.addRow(goodTestData2);
			csv.addRow(goodTestData3);
		}
		String result = csv.toString();
		assertTrue(result.matches(csvRegex));
	}

	/**
	 * @test makes sure that the toString method behaves appropriately given bad inputs.
	 * 
	 * @pre input contains:
	 * - quotes inside csv entry
	 * - special chars in places where they are not allowed
	 * - values other than those specified in option lists e.g. if valid options are AB or BC then try
	 * AA or CC etc
	 * 
	 * @post
	 * - the testString method will produce an ArrayStoreException indicating that the data provided is
	 * not acceptable.
	 * - no other exception will be thrown.
	 * 
	 * @see tomoBay.model.royalMail.RoyalMailCSVGenerator#toString().
	 */
	@Test
	public final void testToStringBadInput()
	{
		//magical regex, allows commas inside quotes
		String csvRegex = "(\"([\\w\\d\\s-_:;'@+()&\\/,#]*)\",\n?)*";
		
		//test the case where bad data is passed in
		RoyalMailCSVGenerator csv = new RoyalMailCSVGenerator();
		//catch dodgy inputs i.e. check validation
		try
		{
			for(int i = 0 ; i < 10 ; ++i)
			{
			
				csv.addRow(badTestData1);
				csv.addRow(badTestData2);
				csv.addRow(badTestData3);
			}
			//if there 
			String result = csv.toString();
			assertFalse(result.matches(csvRegex));
		}
		//if ArrayStoreException is produced then method behaves properly
		catch(ArrayStoreException e)
		{assertTrue(true);}
		//otherwise the behaviour is unexpected
		catch(Exception eeeee)
		{
			eeeee.printStackTrace();
			fail("unforseen exception thrown");
		}
	}
}

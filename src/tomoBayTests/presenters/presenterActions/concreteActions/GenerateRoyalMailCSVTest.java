package tomoBayTests.presenters.presenterActions.concreteActions;
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
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

import tomoBay.presenters.presenterActions.concreteActions.GenerateRoyalMailCSV;

import com.mchange.io.FileUtils;

/**
 * unit test for the tomoBay.presenters.presenterActions.concreteActions.GenerateRoyalMailCSV class
 * 
 *@test tests all functionality for this presenter, which is instantiation and execution.
 *
 *@pre
 *- input from the associated view is valid
 *- tomoBay.model.RoyalMail.RoyalMailCSVGenerator works as expected
 *
 *@post
 *- A CSV file is created logs/RoyalMail.CSV
 *- the execute method returns a String that can be coverted into a file by the frontend.
 *
 * @author Jan P.C. Hanson
 *
 */
public class GenerateRoyalMailCSVTest
{
	private final String goodDataSet =
	"FORD-1987-24-SF-L|"
	+"PSA-12765-48- -P|"
	+"Prestige - 150 - 48 - SF - L";
	
	private final String badDataSet =
	"FORD-999999-24-SF-L|"
	+"PSA-888888-48--Q|"
	+"Prestige-7777777-24-Belgium-P";
	
	private final String goodDataOutputExpected = 
	"\"SR1\",\"24\",\"FAO JOHN BARRASS FAST STOP BRAKE CENTRE\",\"UNIT 8 THE PARADE\",\"HENDON\",\"SR2 8NT\",\"SUNDERLAND\",\"GB\",\"F452906\",\"1\",\"33\",\"SF\",\"L\",\n"
	+"\"SR1\",\"48\",\"Jonathan  Creith\",\"4 seneril road\",\"\",\"BT57 8TR\",\"Bushmills\",\"GB\",\"C178779\",\"1\",\"658\",\"\",\"P\",\n"
	+"\"SR1\",\"48\",\"David Plimmer\",\"46 birch crescent\",\"\",\"B69 1UE\",\"Tividale\",\"GB\",\"P127060\",\"1\",\"20\",\"SF\",\"L\",\n";
	
	private final String invalidPartError = "invalid sales record number or account:";
	
	private final String noPartNoError = "you forgot to enter a part number for an entry";
	
	private final String noEntryError = "you forgot to enter information for an entry or you have not added an entry";
	
	/**
	 * @test makes sure that the GenerateRoyalMailCSVTest presenterAction can be instantiated
	 * as expected.
	 * 
	 * @pre none
	 * 
	 * @post A valie GenerateRoyalMailCSVTest object has been created and instantiated.
	 * 
	 * @see tomoBay.presenters.presenterActions.concreteActions.GenerateRoyalMailCSV#GenerateRoyalMailCSV().
	 */
	@Test
	public final void testGenerateRoyalMailCSV()
	{
		try 
		{
			GenerateRoyalMailCSV csv = new GenerateRoyalMailCSV();
			assertNotNull(csv);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			fail("initialisation threw an exception");
		}
	}

	/**
	 * @test makes sure that the execution of this presenter action behaves as expected providing both
	 * a file in the logs/ directory, and providing a String that can be sent to the frontend to 
	 * recreate the file for the user to download.
	 * 
	 * @pre
	 * - data input string is in the correct format
	 * - tomoBay.model.RoyalMailRoyalMailCSVGenerator performs as expected.
	 * - the database contains order data that can be used to generate the csv
	 * - it is possible to connect to winstock (in order to get weight values associated with an 
	 * invoice)
	 * 
	 * @post
	 * - A file 'RoyalMail.CSV' is produced in the logs/ directory
	 * - the execute method provides a well formed CSV string as a return type.
	 * 
	 * @see tomoBay.presenters.presenterActions.concreteActions.GenerateRoyalMailCSV#execute(java.lang.String)
	 */
	@Test
	public final void testExecute()
	{
		GenerateRoyalMailCSV csv = new GenerateRoyalMailCSV();
		
		//test that string returned is the same as the expected value
		String result = csv.execute(this.goodDataSet);
		assertEquals(result, this.goodDataOutputExpected);
		
		
		//test that the file created corresponds to the expected value
		try
		{
			String fileContent = FileUtils.getContentsAsString(new File("./views/resources/RoyalMail.csv"));
			assertEquals(fileContent, this.goodDataOutputExpected);
		} 
		catch (IOException e)
		{e.printStackTrace();fail("something went wrong reading the file");}
		
		
		//test that passing badly formatted data to this method results in a PresenterActionExceptio
		//being thrown.
		
		result = csv.execute(this.badDataSet);
		if(!(result.contains(this.noEntryError)||result.contains(this.noPartNoError)||result.contains(this.invalidPartError)))
		{fail("could not deal with: "+result);}
		
	}
}

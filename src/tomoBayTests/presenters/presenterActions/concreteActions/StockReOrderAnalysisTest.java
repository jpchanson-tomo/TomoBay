/** Copyright(C) 2016 Jan P.C. Hanson & Tomo Motor Parts Limited
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
package tomoBayTests.presenters.presenterActions.concreteActions;
import static org.junit.Assert.*;

import org.junit.Test;
import tomoBay.presenters.presenterActions.concreteActions.StockReOrderAnalysis;

/**
 * @test This class is a unit test of the StockReOrderAnalysis class in the presenterActions.concreteActions
 * package.
 * 
 * @pre
 * 	- database containing the tables referenced in 
 * tomoBay.model.sql.queries.concreteQueries.select.params.SelectEbayOrderHistoryLastNDays exists.
 * 	- tomoBay.model.sql.queries.concreteQueries.select.params.SelectEbayOrderHistoryLastNDays
 * works as expected.
 * 	- input to the execute method is a well formed JSON string containing the 'lookback' and
 * 'threshold' properties. 
 * 
 * @post
 * 	- A well formatted JSON string result
 * 	- result contains array of objects of the form [{partNo:"abc123", quantity:123},....]
 * 
 * @see tomoBay.presenters.presenterActions.concreteActions.StockReOrderAnalysis
 * 
 * @author Jan P.C. Hanson
 *
 */
public class StockReOrderAnalysisTest
{

	private final String goodData = "{lookback:28,threshold:2}";
	
	private final String badData1 = "{lookback:'28' threshold:'2'}";
	
	private final String badData2 = "{lookback:'28 ,threshold:'2'}";
	
	private final String badData3 = "{lookback:'28',threshold:'29'}";
	
	private final String validResult ="";
	
	/**
	 * @test initialisation of the StockReOrderAnalysis class
	 * 
	 * @pre 
	 * 	- none
	 * 
	 * @post
	 * 	- fully initialised StockReOrderAnalaysis object 
	 * 
	 * Test method for tomoBay.presenters.presenterActions.concreteActions.StockReOrderAnalysis#StockReOrderAnalysis()
	 */
	@Test
	public final void testStockReOrderAnalysis()
	{
		try {StockReOrderAnalysis test = new StockReOrderAnalysis();}
		catch(Exception e) {fail("exception thrown during instantiation");}
	}

	/**
	 * @test
	 *	
	 * @pre
	 * 	- correctly formatted JSON string, containing the 'lookback' and 'threshold' properties.
	 * * 	- database containing the tables referenced in 
	 * tomoBay.model.sql.queries.concreteQueries.select.params.SelectEbayOrderHistoryLastNDays exists.
	 * 	- tomoBay.model.sql.queries.concreteQueries.select.params.SelectEbayOrderHistoryLastNDays
	 * works as expected.
	 * 	- input to the execute method is a well formed JSON string containing the 'lookback' and
	 * 'threshold' properties. 
	 * @post
	 * 	- A well formatted JSON string result
	 * 	- result contains array of objects of the form [{partNo:"abc123", quantity:123},....]
	 * Test method for tomoBay.presenters.presenterActions.concreteActions.StockReOrderAnalysis#execute(java.lang.String)
	 */
	@Test
	public final void testExecuteGoodData()
	{
		StockReOrderAnalysis test = new StockReOrderAnalysis();
		String result = test.execute(goodData);
		System.out.println(result);
		boolean pass = result.matches(validResult);
		assertTrue(pass);
	}
	
	/**
	 * @test
	 *	
	 * @pre
	 * 	- correctly formatted JSON string, containing the 'lookback' and 'threshold' properties.
	 * * 	- database containing the tables referenced in 
	 * tomoBay.model.sql.queries.concreteQueries.select.params.SelectEbayOrderHistoryLastNDays exists.
	 * 	- tomoBay.model.sql.queries.concreteQueries.select.params.SelectEbayOrderHistoryLastNDays
	 * works as expected.
	 * 	- input to the execute method is a well formed JSON string containing the 'lookback' and
	 * 'threshold' properties. 
	 * @post
	 * 	- A well formatted JSON string result
	 * 	- result contains array of objects of the form [{partNo:"abc123", quantity:123},....]
	 * Test method for tomoBay.presenters.presenterActions.concreteActions.StockReOrderAnalysis#execute(java.lang.String)
	 */
	@Test
	public final void testExecuteBadData1()
	{
		StockReOrderAnalysis test = new StockReOrderAnalysis();
		String result = test.execute(badData1);
		boolean pass = result.matches(validResult);
		assertFalse(pass);
	}

	@Test
	public final void testExecuteBadData2()
	{
		StockReOrderAnalysis test = new StockReOrderAnalysis();
		String result = test.execute(badData2);
		boolean pass = result.matches(validResult);
		assertFalse(pass);
	}
	
	@Test
	public final void testExecuteBadData3()
	{
		StockReOrderAnalysis test = new StockReOrderAnalysis();
		String result = test.execute(badData3);
		boolean pass = result.matches(validResult);
		assertFalse(pass);
	}
}

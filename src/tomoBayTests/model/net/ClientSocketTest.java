package tomoBayTests.model.net;
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
import java.io.IOException;
import java.net.UnknownHostException;

import tomoBay.exceptions.NotAValidResultCodeException;
import tomoBay.exceptions.PayloadException;
import tomoBay.helpers.DualList;
import tomoBay.model.winstock.WinstockCommandInvoker;
import tomoBay.model.winstock.payloads.PayloadType;
import tomoBay.model.winstock.response.AbstractWinstockCommandResponse;
/**
 *
 * @author Jan P.C. Hanson
 *
 */
public class ClientSocketTest
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		System.setProperty("Log4jContextSelector", "org.apache.logging.log4j.core.async.AsyncLoggerContextSelector");
		System.out.println("start of test");
		DualList<String, PayloadType> printTest = new DualList<String, PayloadType>();
		printTest.put("35", PayloadType.TYPE);
		printTest.put("3", PayloadType.COMPANY);
		printTest.put("123399", PayloadType.INVOICE_NO);
		printTest.put("1", PayloadType.PRINT_COPIES);
		printTest.put("0", PayloadType.PACKING_LISTS);
	
		DualList<String, PayloadType> putTest = new DualList<String, PayloadType>();
		putTest.put("34", PayloadType.TYPE);
		putTest.put("3", PayloadType.COMPANY);
		putTest.put("EBAY", PayloadType.INVOICE_ACCOUNT);
		putTest.put("Mickey Mouse", PayloadType.NAME);
		putTest.put("Secret Location", PayloadType.ADDRESS1);
		putTest.put("Somewhere", PayloadType.ADDRESS2);
		putTest.put("DisneyWorld", PayloadType.CITY);
		putTest.put("Paris", PayloadType.COUNTY);
		putTest.put("75008", PayloadType.POSTCODE);
		putTest.put("8195", PayloadType.ORDER_NO);
		putTest.put("1", PayloadType.INV_LINES);
		putTest.put("1434C8", PayloadType.PART_NO);
		putTest.put("SLEEVE         ", PayloadType.DESCRIPTION);
		putTest.put("1", PayloadType.QUANTITY);
		putTest.put("1020", PayloadType.PRICE);
		putTest.put("1", PayloadType.INSTOCK);
		System.out.println("data object populated");
	
		try
		{
//			test(putTest,WinstockCommandInvoker.WinstockCommandTypes.PutInvoice);
			test(printTest, WinstockCommandInvoker.WinstockCommandTypes.PrintInvoice);
		} 
		catch (IOException | NotAValidResultCodeException e)
		{
			e.printStackTrace();
		}
		catch (PayloadException e)
		{
			e.printStackTrace();
		}
	}
	private static void test(DualList<String,PayloadType> data, WinstockCommandInvoker.WinstockCommandTypes command) 
			throws UnknownHostException, IOException, PayloadException, NotAValidResultCodeException
	{
		System.out.println("attempting to send winstock command: print");
		AbstractWinstockCommandResponse response = 
				WinstockCommandInvoker.execute(command, data);
		System.out.println("sent: "+response.getSent());
		System.out.println("recieved: "+response.getRecieved());
		System.out.println(response.isSuccess());
		System.out.println("Winstock command test finished: print");
	}
	
}

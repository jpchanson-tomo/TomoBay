package openDMS;
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
import openDMS.helpers.XMLParser;
import openDMS.model.http.HttpGET;
import openDMS.model.services.ServiceFactory;
import openDMS.model.services.ServiceScheduler;
import openDMS.model.services.TriggerService;
import openDMS.view.HttpServer;
/**
 * The entry point into the program
 * 
 * @author Jan P.C. Hanson
 *
 */
public class MAIN
{
	public static void main(String[] args) throws Exception
	{
		System.setProperty("Log4jContextSelector", "org.apache.logging.log4j.core.async.AsyncLoggerContextSelector");
		
		ServiceScheduler services = new ServiceScheduler(2);
		services.add(ServiceFactory.make(ServiceFactory.ServiceType.TEST_SERVICE), 0, 1);
		services.add(ServiceFactory.make(ServiceFactory.ServiceType.EBAY_SERVICE), 0, 10);
		
		HttpServer uiServer = new HttpServer();
		uiServer.start(Integer.parseInt(args[0]));
		
		services.start();
		
//		TriggerService.start(ServiceFactory.make(ServiceFactory.ServiceType.STOCK_UPDATE_SERVICE));
//		String test = "<?xml version='1.0' encoding='iso-8859-1'?><record><ID>71775900</ID><ALTID></ALTID><DESC>CAMSHAFT DRIVE SET    C œ69.45</DESC><CATEGORY>FIA</CATEGORY><LAST_SALE>20151020</LAST_SALE><SAL_PRICE>69.45</SAL_PRICE><MRP_PRICE>69.45</MRP_PRICE><DIS_CODE>C</DIS_CODE><DL_PRICE>48.61</DL_PRICE><COST>55.21</COST><LAST_COST>62.51</LAST_COST><TAG>F</TAG><QTY_EXIST>0</QTY_EXIST><QTY_ORDER>3</QTY_ORDER><QTY_FORWD>0</QTY_FORWD><QTY_ALLOC>0</QTY_ALLOC><VAT_CODE>A</VAT_CODE><BIN>B9-6</BIN><UNIT>1</UNIT><MINORDER>1</MINORDER><REORDER>0</REORDER><UPDATED></UPDATED><PRN_FLAG>Y</PRN_FLAG><HST_FLAG>N</HST_FLAG><SP_FLAG>N</SP_FLAG><S1_CODE>FAA</S1_CODE><S1_PRICE>62.51</S1_PRICE><S1_LAST>20151022</S1_LAST><S2_CODE></S2_CODE><S2_PRICE>0.00</S2_PRICE><S2_LAST></S2_LAST><S3_CODE></S3_CODE><S3_PRICE>0.00</S3_PRICE><S3_LAST></S3_LAST><ENT_DATE>20140527</ENT_DATE><UPD_DATE>20151019</UPD_DATE><COST_DATE>20151022</COST_DATE><LAST_QCHK>0</LAST_QCHK><LAST_DCHK></LAST_DCHK><NOTES>0</NOTES><S4_CODE></S4_CODE><S4_PRICE>0.00</S4_PRICE><S4_LAST></S4_LAST><Q1_CODE>RIC</Q1_CODE><Q1_PRICE>24.99</Q1_PRICE><Q1_DATE>20141202</Q1_DATE><Q2_CODE>DEL</Q2_CODE><Q2_PRICE>34.98</Q2_PRICE><Q2_DATE>20150305</Q2_DATE><Q3_CODE>BIP</Q3_CODE><Q3_PRICE>24.45</Q3_PRICE><Q3_DATE>20151005</Q3_DATE><Q4_CODE></Q4_CODE><Q4_PRICE></Q4_PRICE><Q4_DATE></Q4_DATE></record>";
		
	}
}

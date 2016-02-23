package tomoBay.model.eBayAPI;
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
import com.ebay.sdk.ApiContext;
import com.ebay.sdk.ApiCredential;
/**
 * This class contains functionality to provide an APIContext object which is used by API calls
 * in order to authorise an API call. It is a Singleton
 * 
 * @author Jan P.C. Hanson
 *
 */
public final class APIcontext
{
	/**instance variable holds singleton instance**/
	private static final APIcontext instance_M = new APIcontext();
	
	/**
	 * private constructor, Singleton
	 */
	private APIcontext()
	{super();}
	
	/**
	 * Used instead of constructor for getting an APIcontext instance
	 * @return the singleton instance
	 */
	public static APIcontext instance()
	{return APIcontext.instance_M;}
	
	/**
	 * used for getting an ApiContext object that can then be passed to individual API calls.
	 * 
	 * @param usrToken an eBay API user token
	 * @param server the server to use for api calls (https://api.sandbox.ebay.com/wsapi for
	 * testing and XXXXXXXXXXXXX for production)
	 * @return ApiContext object.
	 */
	public ApiContext apiContext(String usrToken, String server)
	{
		ApiContext apiContext = new ApiContext();

		//set Api Token to access eBay Api Server
		ApiCredential cred = apiContext.getApiCredential();
		cred.seteBayToken(usrToken);
		//set Api Server Url
		apiContext.setApiServerUrl(server);
	
		return apiContext;
	}
}

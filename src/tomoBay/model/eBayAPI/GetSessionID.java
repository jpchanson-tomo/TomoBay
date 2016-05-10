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
import com.ebay.sdk.ApiException;
import com.ebay.sdk.SdkException;
/**
 *
 * @author Jan P.C. Hanson
 *
 */
public class GetSessionID extends AbstractAPIcall
{
	
//	private GetSessionIDCall sesid;
	
//	private GetSessionIDRequestType sessidReq;
	
//	private ApiCall call;

	/**
	 * 
	 */
	public GetSessionID(String usrToken, String server)
	{
		super(usrToken, server);
//		this.sesid = new GetSessionIDCall(APIcontext.instance().apiContext(super.usrToken_M, super.server_M));
//		this.sessidReq = new GetSessionIDRequestType();
//		call = new ApiCall(APIcontext.instance().apiContext(super.usrToken_M, super.server_M));
	}

	public String call(String ruName) throws ApiException, SdkException, Exception
	{
//		sessidReq.setRuName("ruName");
//		GetSessionIDResponseType result = (GetSessionIDResponseType) sesid.execute(sessidReq);
//		return result.getSessionID();
		
//		sesid.setRuName(ruName);
//		sesid.getSessionID();
		return null;
	}
}

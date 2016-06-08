/**
 * 
 */
package tomoBay;

/**
 * @author Jan P.C. Hanson
 *
 */
import java.io.IOException;
import java.util.Arrays;

import com.ebay.sdk.ApiContext;
import com.ebay.sdk.ApiCredential;
import com.ebay.sdk.call.GetItemCall;
import com.ebay.sdk.call.GetOrdersCall;
import com.ebay.soap.eBLBaseComponents.DetailLevelCodeType;
import com.ebay.soap.eBLBaseComponents.GetItemRequestType;
import com.ebay.soap.eBLBaseComponents.GetOrdersRequestType;
import com.ebay.soap.eBLBaseComponents.NameValueListType;
import com.ebay.soap.eBLBaseComponents.OrderType;
import com.ebay.soap.eBLBaseComponents.TransactionType;

/**
 * A Hello World-like sample, 
 * showing how to call eBay API using eBay SDK.
 *  
 * @author boyang
 *
 */
public class POC {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	    try {

	        System.out.print("\n");
	        System.out.print("+++++++++++++++++++++++++++++++++++++++\n");
	        System.out.print("+ Welcome to eBay SDK for Java Sample +\n");
	        System.out.print("+  - ConsoleAddItem                   +\n");
	        System.out.print("+++++++++++++++++++++++++++++++++++++++\n");
	        System.out.print("\n");

	        // [Step 1] Initialize eBay ApiContext object
	  	System.out.println("===== [1] Account Information ====");
	        ApiContext apiContext = getApiContext();
	        
	        // [Step 2] Create call object and execute the call
	        GetOrdersCall order = new GetOrdersCall(apiContext);
	        GetOrdersRequestType ordreq = new GetOrdersRequestType();
	        
//	        GetItemRequestType itreq = new GetItemRequestType();
//	        GetItemCall item = new GetItemCall(apiContext);
	        
	        
	        
	        ordreq.setNumberOfDays(5);
	        order.executeByApiName("GetOrders", ordreq);
	        order.setNumberOfDays(5);
	        
	        
	        
//	        System.out.println("Start of call eBay API, please wait ... ");
	        OrderType[] ord = order.getOrders();
	        TransactionType[] trans = ord[0].getTransactionArray().getTransaction();
//	        System.out.println("End of call eBay API, show call result ...");
	        
	        
//	        DetailLevelCodeType[] detail = {DetailLevelCodeType.RETURN_ALL};
//	        itreq.setItemID(trans[0].getItem().getItemID());
//	        itreq.setIncludeItemSpecifics(true);
//	        itreq.setDetailLevel(detail);
//	        item.executeByApiName("GetItem", itreq);
//	        item.setItemID(trans[0].getItem().getItemID());
//	        item.setIncludeItemSpecifics(true);
//	        item.setDetailLevel(detail);
//	        String resp = item.getResponseXml();
	        
	        
	        
	        // [Setp 3] Handle the result returned
// 	        NameValueListType[] tmp = item.getItem().getItemSpecifics().getNameValueList();
//	        String result="";
//	        for(int i = 0; i < tmp.length; ++i)
//	        {
//	        	result += tmp[i].getName() + " : ";
//	        	result += Arrays.deepToString(tmp[i].getValue());
//	        }
	       
	        
	        System.out.println(ord[0].getOrderID());
	        System.out.println(order.getReturnedHasMoreOrders());
//	        System.out.println(ord[0].get);
//	        System.out.println(result);
	        
	    }
	    catch(Exception e) {
	        System.out.println("Fail to get eBay official time.");
	        e.printStackTrace();
	    }

	}
	
	  /**
	   * Populate eBay SDK ApiContext object with data input from user
	   * @return ApiContext object
	   */
	  private static ApiContext getApiContext() throws IOException {
		  String userToken = "AgAAAA**AQAAAA**aAAAAA**0GbQVg**nY+sHZ2PrBmdj6wVnY+sEZ2PrA2dj6wMk4GnD5GDogSdj6x9nY+seQ**zycDAA**AAMAAA**vuf8mZAWVaWRvLQ3FV/HyJdJ6kfngurBszal33drU7jupoq3YVruEMlZdpeBjxqvkcqyNkMa64UotHZ+2H2Am3yJ7dUDTju5gAYxuqQt9p4+fTJVnQ3ndUpYJGtO/gCEWGTM4WP4i8sdTgrw+B4tsu9ZyQFr1uYdr6BYqPgD1K/CNV/xUOmtIqmoPI1m6guV5hpXI+Th3814tJub+zThmJBQIusb47qO8Lx7VSJc/gyDY6TQwctfu5Xvs3EN/8g4iuUR+wZzzg2/k8eL+6SuSgrC4W31ZDboFQWs13t3AiD7vsWhiNdeELTHigRZSokHbzbmq191pX7DdmWjYon3Z2G2nu/pdQuc5P2tAgGzhxcIlfN8XS+FCZupuWXM44FpRfYORKCHioE7gcvIAvOPbA5xRVUVOqRKr+Qz/Qq2ItiEwWDbv4DbyElLjmcMfCjioBd9L4BF2DvaZ/9n6DPK7XpHhbfDJHDelm2RV0Li7FNPWRyRFg52gmCKR2DN3f9GQ3xUpM1r9EgjdlauwFBr6e7hC3iZkV4AwEYBBG3k9UR330ZZISE7HFkFMSDJfFoLVj6zWsx3Vylky7WLzj+tvrWtEQTILP6x46WkQjAEz/it3t1z2ECthkdjBFh/1X1VMS16YErN45m6WJcvOg8F6nxQ5YxqWYHqqJXVzRzwCGe35yfAHargvftaVqVJgi1B5pxOjtbgLmoqknwYc9lsSQMkWPfCsjFGXqh1WZnfH1U5srQb64X+eF1bFAY/29VK";
//	      String input;
	      ApiContext apiContext = new ApiContext();
	      
	      //set Api Token to access eBay Api Server
	      ApiCredential cred = apiContext.getApiCredential();
	      cred.seteBayToken(userToken);
	     
	      //set Api Server Url
	      apiContext.setApiServerUrl("https://api.ebay.com/wsapi");
	      
	      return apiContext;
	  }

}
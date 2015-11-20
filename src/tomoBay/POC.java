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
	        
	        GetItemRequestType itreq = new GetItemRequestType();
	        GetItemCall item = new GetItemCall(apiContext);
	        
	        
	        
	        ordreq.setNumberOfDays(5);
	        order.executeByApiName("GetOrders", ordreq);
	        order.setNumberOfDays(5);
	        
	        
	        
//	        System.out.println("Start of call eBay API, please wait ... ");
	        OrderType[] ord = order.getOrders();
	        TransactionType[] trans = ord[0].getTransactionArray().getTransaction();
//	        System.out.println("End of call eBay API, show call result ...");
	        
	        
	        DetailLevelCodeType[] detail = {DetailLevelCodeType.RETURN_ALL};
	        itreq.setItemID(trans[0].getItem().getItemID());
	        itreq.setIncludeItemSpecifics(true);
	        itreq.setDetailLevel(detail);
	        item.executeByApiName("GetItem", itreq);
	        item.setItemID(trans[0].getItem().getItemID());
	        item.setIncludeItemSpecifics(true);
	        item.setDetailLevel(detail);
//	        String resp = item.getResponseXml();
	        
	        
	        
	        // [Setp 3] Handle the result returned
 	        NameValueListType[] tmp = item.getItem().getItemSpecifics().getNameValueList();
	        String result="";
	        for(int i = 0; i < tmp.length; ++i)
	        {
	        	result += tmp[i].getName() + " : ";
	        	result += Arrays.deepToString(tmp[i].getValue());
	        }
	       
	        
	        System.out.println(ord[0].getOrderID());
	        System.out.println(order.getReturnedHasMoreOrders());
//	        System.out.println(ord[0].get);
	        System.out.println(result);
	        
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
		  String userToken = "AgAAAA**AQAAAA**aAAAAA**s6cKVg**nY+sHZ2PrBmdj6wVnY+sEZ2PrA2dj6wFk4GhDpGFoAidj6x9nY+seQ**MpQDAA**AAMAAA**4Aqt9SemYN6DehoPdEsoWuFqCELKvJyBaHL5q1gdWL40la/sjo+abdJSSvNmW8aGcgrgiEXsXJdO+C8RV4lVLvjLnZM0Sadri0BUqP1EK4OTdZWMh8DqaqAqiCi/RhzB+OvHmUd7g5aztZn+wTAIDdglX1cBsJNWnDo4Y9CmK0Et0tbiEiMabvPyO8zwR/Touug6qWkQK488NxJtdo+ZrNZKQ33XXOIoC+nwj8py85vXzxq029DvF31Wmk6ZZcnAuBnpWu8l6h1V+nEPy5V4f1lCIiJdSs++wKP0Dw8FkIXsiTOO4c4LF67gU35LNlaiE/GunY/yJuDeXQ6AJB0RLoFQck+LaEJ2OGH6ZPyzITTWTkf8qY6PBTRE7tCe8okI/Qnbcc6Y6Rol80uJtDQ27Jf7H1XoHoVOgQtTWcZa0BYP7Vbqo54lGyOsVnAHGZ4so+T9WvhZ/MJOacbou9YUptwPYfZwQsTnl0BvVgd6bt5XPsao54A+9ujPhZM5gk0/l9CnG4g47P+jiUtVyw4Gp4cD4fUzRMGK5hQ2jwm+/zK+kokExZbhpIiJBozA7n+5UPRwlmxh8fg1YBW0J0S7/BXBk4zNmpkYOwVQR4kj56/t5fcI9cYfzonRpnn7VUonD21KE6/1lZVsF0/OKoi8OU+xEJZlc8f1E3gv5MYN/qkcjDIn0lq6Fp+1fx6Yod2x1cUfIIXLsdQhqhcZ82LhdfWY/5QdoYGNN2M30yq+6tp4krIx5xBZvBzE8I1sqaRM";
//	      String input;
	      ApiContext apiContext = new ApiContext();
	      
	      //set Api Token to access eBay Api Server
	      ApiCredential cred = apiContext.getApiCredential();
	      cred.seteBayToken(userToken);
	     
	      //set Api Server Url
	      apiContext.setApiServerUrl("https://api.sandbox.ebay.com/wsapi");
	      
	      return apiContext;
	  }

}
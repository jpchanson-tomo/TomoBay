package openDMS.ebay.query.data;
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

/**
 *
 * @author Jan P.C. Hanson
 *
 */
public class ApiCallData
{
	/**enum used for switching in derived classes**/
	protected enum Data_Type {ORDER, TRANSACTION, ITEM}
	/**holder for order data**/
	private ApiOrderData orderData_M;
	/**holder for item data**/
	private ApiItemData itemData_M;
	/**holder for transaction data**/
	private ApiTransactionData transactionData_M;
	/**holder for User token**/
	private String userToken_M;
	/**holder for server string**/
	private String server_M;
	
	public ApiCallData(String usrToken, String server)
	{
		this.orderData_M = new ApiOrderData();
		this.itemData_M = new ApiItemData();
		this.transactionData_M = new ApiTransactionData();
		this.userToken_M = usrToken;
		this.server_M = server;
	}
	
	/**
	 * set the order data object to be stored in the ApiCallData
	 * @param orders the data object to add
	 */
	public void addOrderData(ApiOrderData orders)
	{this.orderData_M = orders;}
	
	/**
	 * set the item data object to be stored in the ApiCallData
	 * @param item the data object to add
	 */
	public void addItemData(ApiItemData item)
	{this.itemData_M = item;}
	
	/**
	 * set the transaction data object to be stored in the ApiCallData
	 * @param transaction
	 */
	public void addTransactionData(ApiTransactionData transaction)
	{this.transactionData_M = transaction;}
	
	/**
	 * get the order data object stored in this object
	 * @return ApiOrderData
	 */
	public ApiOrderData accessOrderData()
	{return this.orderData_M;}
	
	/**
	 * get the item data object stored in this object
	 * @return ApiItemData
	 */
	public ApiItemData accessItemData()
	{return this.itemData_M;}
	
	/**
	 * get the transaction data object stored in this object
	 * @return ApiTransactionData
	 */
	public ApiTransactionData accessTransactionData()
	{return this.transactionData_M;}
	
	/**
	 * retrieve the value for the user token.
	 * @return String representing user token.
	 */
	public String getUserToken()
	{return this.userToken_M;}
	
	/**
	 * retrieve the value of the server string
	 * @return String representing the server to call to.
	 */
	public String getServerString()
	{return this.server_M;}
}

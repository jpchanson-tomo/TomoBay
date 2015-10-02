package openDMS.ebay.query.data;

import java.util.ArrayList;
import java.util.List;

import com.ebay.soap.eBLBaseComponents.TransactionType;
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
public class ApiTransactionData
{
	/**holder for TransactionTypes**/
	private List<TransactionType> transactions_M;
	
	public ApiTransactionData()
	{this.transactions_M = new ArrayList<TransactionType>();}
	
	/**
	 * add TransactionType data to the ApiCallData
	 * @param transaction the TransactionType to add
	 */
	public void addData(TransactionType transaction)
	{this.transactions_M.add(transaction);}
	
	/**
	 * access TransactionType data of the ApiCallData
	 * @param index the index of the data you wish to access
	 * @return TransactionType
	 */
	public TransactionType accessData(int index)
	{return this.transactions_M.get(index);}
	
	/**
	 * removes data at a specific index
	 * @param index
	 */
	public void removeData(int index)
	{this.transactions_M.remove(index);}
	
	/**
	 * clears all data from this object
	 */
	public void clearData()
	{this.transactions_M.clear();}
}

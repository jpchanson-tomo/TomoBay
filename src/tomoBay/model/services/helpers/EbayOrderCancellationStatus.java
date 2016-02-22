package tomoBay.model.services.helpers;

import java.util.HashMap;
import java.util.Map;

import com.ebay.soap.eBLBaseComponents.CancelStatusCodeType;
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
public final class EbayOrderCancellationStatus
{
	/**
	 * map of status codes to boolean values, used to define the types of cancellation status
	 * that can be processed by the system.
	 */
	@SuppressWarnings("serial")
	private static final Map<CancelStatusCodeType, Boolean> canInvoiceMap_M = 
			new HashMap<CancelStatusCodeType, Boolean>()
			{{
				put(CancelStatusCodeType.CANCEL_CLOSED_FOR_COMMITMENT, true);
				put(CancelStatusCodeType.CANCEL_CLOSED_NO_REFUND, false);
				put(CancelStatusCodeType.CANCEL_CLOSED_UNKNOWN_REFUND, false);
				put(CancelStatusCodeType.CANCEL_CLOSED_WITH_REFUND, false);
				put(CancelStatusCodeType.CANCEL_COMPLETE, false);
				put(CancelStatusCodeType.CANCEL_FAILED, true);
				put(CancelStatusCodeType.CANCEL_PENDING, false);
				put(CancelStatusCodeType.CANCEL_REJECTED, true);
				put(CancelStatusCodeType.CANCEL_REQUESTED, false);
				put(CancelStatusCodeType.CUSTOM_CODE, false);
				put(CancelStatusCodeType.INVALID, true);
				put(CancelStatusCodeType.NOT_APPLICABLE, true);
			}};
			
	/**
	 * private ctor, ensure that the class never gets instantiated
	 */
	private EbayOrderCancellationStatus() {super();}
	
	/**
	 * return the true/false value associated with a particular cancellation status.
	 * @param cancelCode the CancelStatusCodeType from the eBay API associated with a particula
	 * order
	 * @return true if the system can handle this type of order, false otherwise.
	 */
	public static boolean isCancelled(CancelStatusCodeType cancelCode)
	{return EbayOrderCancellationStatus.canInvoiceMap_M.get(cancelCode);}
}

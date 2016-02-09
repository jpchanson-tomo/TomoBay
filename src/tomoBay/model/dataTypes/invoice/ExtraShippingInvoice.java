package tomoBay.model.dataTypes.invoice;
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
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Jan P.C. Hanson
 *
 */
public final class ExtraShippingInvoice extends AbstractInvoice
{
	private List<InvoiceLine> invLines_M;
	/**
	 * initialise this invoice with orderID provided
	 */
	public ExtraShippingInvoice(String orderID)
	{
		super(orderID);
		invLines_M = new ArrayList<InvoiceLine>();
	}

	/* (non-Javadoc)
	 * @see tomoBay.model.dataTypes.invoice.AbstractInvoice#noOfInvLines()
	 */
	@Override
	public int noOfInvLines()
	{
		int result=0;
		for(int i = 0 ; i < super.order_M.noOfTransactions() ; ++i)
		{
			result+= super.order_M.listingSize(i);
		}
		return result + 1;
	}

	/* (non-Javadoc)
	 * @see tomoBay.model.dataTypes.invoice.AbstractInvoice#invLine(int)
	 */
	@Override
	public InvoiceLine invLine(int invLineNo)
	{return this.invLines_M.get(invLineNo);}
	
	/**
	 * 
	 */
	private void generateInvoiceLines()
	{
		for(int i = 0 ; i < super.order_M.noOfTransactions() ; ++i)
		{
			for (int j = 0 ; j < super.order_M.listingSize(i); ++j)
			{
				this.invLines_M.add(this.generateInvoiceLine(i, j));
			}
		}
	}
	
	/**
	 * 
	 * @param transactionNo
	 * @param partIndex
	 * @return
	 */
	private InvoiceLine generateInvoiceLine(int transactionNo, int partIndex)
	{
		String partNo = super.order_M.partNo(transactionNo, partIndex);
		String description = super.order_M.partDescription(transactionNo, partIndex);
		int qty = super.order_M.partQuantity(transactionNo, partIndex) * super.order_M.purchasedQuantity(transactionNo);
		
		int unitPrice = 0;
		
		return null;
	}
	
	

}

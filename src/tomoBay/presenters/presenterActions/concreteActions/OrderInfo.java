package tomoBay.presenters.presenterActions.concreteActions;

import tomoBay.model.dataTypes.financial.GBP;
import tomoBay.model.dataTypes.financial.VAT;
import tomoBay.model.dataTypes.financial.SalesOrderDayBook.AbstractSalesDayBookLine;
import tomoBay.model.dataTypes.financial.SalesOrderDayBook.StandardInvoice;
import tomoBay.model.dataTypes.json.JSONentity;
import tomoBay.model.dataTypes.json.JSONentity_array;
import tomoBay.model.dataTypes.json.JSONentity_object;
import tomoBay.model.dataTypes.order.Buyer;
import tomoBay.model.dataTypes.order.Order;
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
import tomoBay.presenters.presenterActions.AbstractPresenterAction;

/**
 *
 * @author Jan P.C. Hanson
 *
 */
public final class OrderInfo implements AbstractPresenterAction
{

	/**
	 * 
	 */
	public OrderInfo()
	{super();}

	/* (non-Javadoc)
	 * @see tomoBay.presenters.presenterActions.AbstractPresenterAction#execute(java.lang.String)
	 */
	@Override
	public String execute(String data)
	{
		AbstractSalesDayBookLine invoice = new StandardInvoice(new Order(data));
		return new JSONentity_object()
					.addPreFormatted("order", this.formatResults(invoice)).toString();
	}
	
	/**
	 * 
	 * @param input
	 * @return
	 */
	private String formatResults(AbstractSalesDayBookLine input)
	{
		return new JSONentity_object()
					.addPreFormatted("summaryInfo", this.summaryInfo(input.orderInfo()))
					.addPreFormatted("buyerInfo", this.buyerInfo(input.orderInfo().buyer()))
					.addPreFormatted("transactionInfo", this.transactionInfo(input))
					.toString();	
	}
	
	/**
	 * 
	 * @param order
	 * @return
	 */
	private String summaryInfo(Order order)
	{
		return new JSONentity_object()
			.addLeaf("orderID",order.orderID())
			.addLeaf("salesRecNo",GBP.toString(order.salesRecNo()) )
			.addLeaf("shippingType",order.shippingType())
			.addLeaf("createdTime",order.createdTime())
			.addLeaf("orderTotalIncVAT",order.totalPrice()+"")
			.addLeaf("orderTotalExVAT",GBP.toString(VAT.subtract(order.totalPrice())) )
			.addLeaf("VAT", GBP.toString(VAT.due(order.totalPrice())) ).toString();
	}
	
	/**
	 * 
	 * @param buyer
	 * @return
	 */
	private String buyerInfo(Buyer buyer)
	{
		return new JSONentity_object().addLeaf
				("name",buyer.name()).addLeaf
				("buyerID",buyer.buyerID()).addLeaf
				("email",buyer.email()).addLeaf
				("phone",buyer.phoneNo()).addLeaf
				("street1",buyer.street1()).addLeaf
				("street2",buyer.street2()).addLeaf
				("city",buyer.city()).addLeaf
				("county",buyer.county()).addLeaf
				("postcode",buyer.postcode()).toString();
	}
	
	/**
	 * 
	 * @param invoice
	 * @return
	 */
	private String transactionInfo(AbstractSalesDayBookLine invoice)
	{
		JSONentity transactionArray = new JSONentity_array();
		for(int i = 0 ; i < invoice.orderInfo().noOfTransactions() ; ++i)
		{
			transactionArray.addBranch
				("", new JSONentity_object()
					.addLeaf("itemID", invoice.orderInfo().transaction(i).listing().listingID()+"")
					.addLeaf("title", invoice.orderInfo().transaction(i).listing().title())
					.addLeaf("purchasedPriceIncVAT", invoice.orderInfo().transaction(i).transactionPrice()+"")
					.addLeaf("purchasedPriceExVAT", VAT.subtract(invoice.orderInfo().transaction(i).transactionPrice())+"" )
					.addLeaf("shippingCost", invoice.orderInfo().transaction(i).shippingCost()+"")
					.addLeaf("purchasedQty", invoice.orderInfo().transaction(i).qtyPurchased()+"")
					.addLeaf("brand", invoice.orderInfo().transaction(i).listing().part(0).brand())
					.addLeaf("partNo", invoice.orderInfo().transaction(i).listing().partNos())
					.addPreFormatted("parts", this.parts(i, invoice))
					.addPreFormatted("partQtys", this.partQtys(i, invoice))
					.addPreFormatted("partPrices", this.partPrices(i, invoice))
					.addPreFormatted("partCosts", this.partcosts(i, invoice))
					.addPreFormatted("partDescs", this.partDescs(i, invoice))
				);
		}
		return transactionArray.toString();
	}
	
	/**
	 * 
	 * @param transactionNo
	 * @param invoice
	 * @return
	 */
	private String asArray(int transactionNo, AbstractSalesDayBookLine invoice)
	{
		JSONentity result= new JSONentity_array();
		
		for (int i = 0 ; i <  invoice.orderInfo().transaction(transactionNo).listing().noOfParts() ; ++i)
		{result.addLeaf("", invoice.getLineItem(i).partNo(invoice));}
		
		return result.toString();
	}
	
	/**
	 * 
	 * @param transactionNo
	 * @param invoice
	 * @return
	 */
	private String parts(int transactionNo, AbstractSalesDayBookLine invoice)
	{
		JSONentity result= new JSONentity_array();
		
		for (int i = 0 ; i <  invoice.orderInfo().transaction(transactionNo).listing().noOfParts() ; ++i)
		{result.addLeaf("", invoice.getLineItem(i).partNo(invoice));}
		
		return result.toString();
	}
	
	/**
	 * 
	 * @param transactionNo
	 * @param invoice
	 * @return
	 */
	private String partQtys(int transactionNo, AbstractSalesDayBookLine invoice)
	{
		JSONentity result= new JSONentity_array();
		
		for (int i = 0 ; i <  invoice.orderInfo().transaction(transactionNo).listing().noOfParts() ; ++i)
		{result.addLeaf("", invoice.getLineItem(i).quantity(invoice)+"");}
		
		return result.toString();
	}
	
	/**
	 * 
	 * @param transactionNo
	 * @param invoice
	 * @return
	 */
	private String partcosts(int transactionNo, AbstractSalesDayBookLine invoice)
	{
		JSONentity result= new JSONentity_array();
		
		for (int i = 0 ; i <  invoice.orderInfo().transaction(transactionNo).listing().noOfParts() ; ++i)
		{result.addLeaf("", invoice.orderInfo().transaction(transactionNo).listing().part(i).cost()+"");}
		
		return result.toString();
	}
	
	/**
	 * 
	 * @param transactionNo
	 * @param invoice
	 * @return
	 */
	private String partPrices(int transactionNo, AbstractSalesDayBookLine invoice)
	{
		JSONentity result= new JSONentity_array();
		
		for (int i = 0 ; i <  invoice.orderInfo().transaction(transactionNo).listing().noOfParts() ; ++i)
		{result.addLeaf("", invoice.getLineItem(i).price()+"");}
		
		return result.toString();
	}
	
	/**
	 * 
	 * @param transactionNo
	 * @param invoice
	 * @return
	 */
	private String partDescs(int transactionNo, AbstractSalesDayBookLine invoice)
	{
		JSONentity pqtys= new JSONentity_array();
		
		for (int i = 0 ; i <  invoice.orderInfo().transaction(transactionNo).listing().noOfParts() ; ++i)
		{pqtys.addLeaf("", invoice.getLineItem(i).description(invoice));}
		
		return pqtys.toString();
	}
}
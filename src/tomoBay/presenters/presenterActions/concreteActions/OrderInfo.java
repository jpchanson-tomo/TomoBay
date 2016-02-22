package tomoBay.presenters.presenterActions.concreteActions;

import tomoBay.model.dataTypes.financial.GBP;
import tomoBay.model.dataTypes.financial.VAT;
import tomoBay.model.dataTypes.financial.SalesOrderDayBook.AbstractSalesDayBookLine;
import tomoBay.model.dataTypes.financial.SalesOrderDayBook.SalesDayBookLineFactory;
import tomoBay.model.dataTypes.financial.SalesOrderDayBook.SalesDayBookLineFactory.SalesDayBookLineType;
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
import tomoBay.security.SaneInput;

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
		AbstractSalesDayBookLine invoice = SalesDayBookLineFactory.make(
																SalesDayBookLineType.INVOICE, 
																new Order(data)
																		); //new StandardInvoice(new Order(data));
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
					.addPreFormatted("shipping", this.shippingInfo(input))
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
			.addLeaf("orderTotalIncVAT",(order.totalPrice())+"")
			.addLeaf("orderTotalExVAT",GBP.toString((VAT.subtract(order.totalPrice()))))
			.addLeaf("VAT", GBP.toPennies(VAT.due(order.totalPrice()))+"" ).toString();
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
		JSONentity transactionObject;
		JSONentity part;
		JSONentity partQty;
		JSONentity partCost;
		JSONentity partPrice;
		JSONentity partDesc;
		
		
		int lineItemCount = 0;
		for(int i = 0 ; i < invoice.orderInfo().noOfTransactions() ; ++i)
		{
			int noOfParts = invoice.orderInfo().transaction(i).listing().noOfParts();
			
			transactionObject = new JSONentity_object();
			part= new JSONentity_array();
			partQty= new JSONentity_array();
			partCost= new JSONentity_array();
			partPrice= new JSONentity_array();
			partDesc= new JSONentity_array();
			
			
			transactionObject
			.addLeaf("itemID", invoice.orderInfo().transaction(i).listing().listingID()+"")
			.addLeaf("title", SaneInput.json(invoice.orderInfo().transaction(i).listing().title()))
			.addLeaf("purchasedPriceIncVAT", (invoice.orderInfo().transaction(i).transactionPrice())+"")
			.addLeaf("purchasedPriceExVAT", GBP.toString((VAT.subtract(invoice.orderInfo().transaction(i).transactionPrice()))))
			.addLeaf("shippingCost", (invoice.orderInfo().transaction(i).shippingCost())+"")
			.addLeaf("purchasedQty", invoice.orderInfo().transaction(i).qtyPurchased()+"")
			.addLeaf("brand", SaneInput.json(invoice.orderInfo().transaction(i).listing().part(0).brand()))
			.addLeaf("partNo", invoice.orderInfo().transaction(i).listing().partNos());
			
			for(int j = lineItemCount ; j < (lineItemCount + noOfParts) ; ++j)
			{
				part.addLeaf("", invoice.getLineItem(j).partNo(invoice));
				partQty.addLeaf("", invoice.getLineItem(j).quantity(invoice)+"");
				partCost.addLeaf("", (invoice.orderInfo().transaction(i).listing().part(j-lineItemCount).cost())+"");
				partPrice.addLeaf("", GBP.fromPennies(invoice.getLineItem(j).price())+"");
				partDesc.addLeaf("", SaneInput.json(invoice.getLineItem(j).description(invoice)));
			}
			
			transactionObject.addBranch("parts", part);
			transactionObject.addBranch("partQtys", partQty);
			transactionObject.addBranch("partCosts", partCost);
			transactionObject.addBranch("partPrices", partPrice);
			transactionObject.addBranch("partDescs", partDesc);
			
			transactionArray.addBranch("", transactionObject);
			lineItemCount += noOfParts;
		}
		return transactionArray.toString();
	}
	
	private String shippingInfo(AbstractSalesDayBookLine invoice)
	{ 
		if(invoice.orderInfo().shippingCost() > 0)
		{
			return new JSONentity_object()
			.addLeaf("shipPart",invoice.getLineItem(invoice.size()-1).partNo(invoice))
			.addLeaf("shipDesc",invoice.getLineItem(invoice.size()-1).description(invoice))
			.addLeaf("shipQty",invoice.getLineItem(invoice.size()-1).quantity(invoice)+"")
			.addLeaf("shipSubTotal",GBP.fromPennies(invoice.getLineItem(invoice.size()-1).price())+"")
			.addLeaf("shipTotal", invoice.orderInfo().shippingCost()+"")
			.toString();
		}
		
		else 
		{
			String res = "N/A";
			return new JSONentity_object()
			.addLeaf("shipPart", res)
			.addLeaf("shipDesc", res)
			.addLeaf("shipQty", res)
			.addLeaf("shipSubTotal", "0")
			.addLeaf("shipTotal", "0")
			.toString();
		}
	}
}
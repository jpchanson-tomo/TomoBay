////////////////////////////////////////////////////////////////////////////////////////IMPORTS
$("head").append("<link rel='stylesheet' href='css/order.css'>");
$("head").append("<script src='js/modules/addCommonContent.js'></script>");
//////////////////////////////////////////////////////////////////////////////////ENDOF IMPORTS

///////////////////////////////////////////////////////////////////////////////////////////MAIN
/**
 * 
 */
$(document).ready(function(){
	var orderId = window.location.href;
	var start = orderId.indexOf("?");
	var end = orderId.lastIndexOf("?");
	$.get("/res/?page=ORDER_DETAILS_PRESENTER&type=ORDER_INFO&data="+orderId.slice(start+1, end), function(data, textStatus)
	{
		var json = JSON.parse(data);
		insertCommonJSON(json);
		insertTransactionData(json);
		grandTotal();
	});
	
	
});
/////////////////////////////////////////////////////////////////////////////////////ENDOF MAIN

function insertCommonJSON(json)
{
	$("#orderID").text("OrderID: "+json.order.summaryInfo.orderID);
	$("#street1").text(json.order.buyerInfo.street1);
	$("#street2").text(json.order.buyerInfo.street2);
	$("#city").text(json.order.buyerInfo.city);
	$("#county").text(json.order.buyerInfo.county);
	$("#postcode").text(json.order.buyerInfo.postcode);
	$("#name").text(json.order.buyerInfo.name);
	$("#buyerID").text(json.order.buyerInfo.buyerID);
	$("#email").text(json.order.buyerInfo.email);
	$("#phone").text(json.order.buyerInfo.phone);
	$("#salesRecNo").text(json.order.summaryInfo.salesRecNo);
	$("#shippingType").text(json.order.summaryInfo.shippingType);
	$("#createdTime").text(json.order.summaryInfo.createdTime);
	$("#orderTotalIncVAT").text(json.order.summaryInfo.orderTotalIncVAT);
	$("#orderTotalExVAT").text(json.order.summaryInfo.orderTotalExVAT);
}

function insertTransactionData(json)
{
	var tableBody="";
	for(var i = 0 ; i < json.order.transactionInfo.length ; ++i)
	{
		var transactionHeader =
		"<table class='table table-condensed '><thead>"+
			"<tr class='transactionTable'>"+
			"<th>itemID</th>"+
			"<th>PartNo's</th>"+
			"<th>Title</th>"+
			"<th>Brand</th>"+
			"<th>Purchased Qty</th>"+
			"<th>SubTotal</th>"+
			"<th>Total</th>"+
			"</tr>"+
			"</thead>";
		
		var transactionLine =
			"<tr class='transactionTable'>"+
			"<td><a href='http://www.ebay.co.uk/itm/"+json.order.transactionInfo[i].itemID+"' target='_blank' class='listingLink'>"
			+json.order.transactionInfo[i].itemID+
			"</a></td>"+
			"<td>"+json.order.transactionInfo[i].partNo+"</td>"+
			"<td>"+json.order.transactionInfo[i].title+"</td>"+
			"<td>"+json.order.transactionInfo[i].brand+"</td>"+
			"<td>"+json.order.transactionInfo[i].purchasedQty+"</td>"+
			"<td>"+json.order.transactionInfo[i].purchasedPriceExVAT+"</td>"+
			"<td>"+json.order.transactionInfo[i].purchasedPriceIncVAT+"</td>"+
			"</tr>";
		
		var partsHeader =
			"<thead><tr class='partsTable'>"+
			"<th></th>"+
			"<th>PartNo</th>"+
			"<th>Description</th>"+
			"<th>Unit Cost</th>"+
			"<th>Part Qty</th>"+
			"<th>Unit Price</th>"+
			"<th>Line Total</th>"+
			"</tr></thead>"+
			"";
		
		var partLines="";
		var sumOfLines=0;
			for(var j = 0 ; j < json.order.transactionInfo[i].parts.length; ++j)
			{
				 partLines +=
					"<tr class='partsTable'>"+
					"<td></td>"+
					"<td>"+json.order.transactionInfo[i].parts[j]+"</td>"+
					"<td>"+json.order.transactionInfo[i].partDescs[j]+"</td>"+
					"<td>"+json.order.transactionInfo[i].partCosts[j]+"</td>"+
					"<td>"+json.order.transactionInfo[i].partQtys[j]+"</td>"+
					"<td>"+json.order.transactionInfo[i].partPrices[j]+"</td>"+
					"<td>"+((json.order.transactionInfo[i].partQtys[j])*(json.order.transactionInfo[i].partPrices[j])).toFixed(2)+"</td>"+
					"</tr>"+
					"";
				 sumOfLines+=(json.order.transactionInfo[i].partQtys[j])*(json.order.transactionInfo[i].partPrices[j])
			}
			
			sumOfLines=	"<tr><td></td><td></td><td></td><td></td><td></td>" +
						"<th class='partsTable'>&Sigma;(Lines):</th>" +
						"<td class='partsTable sumOfLines'>"+sumOfLines.toFixed(2)+"</td></tr>"
		
		
			tableBody += transactionHeader+transactionLine+partsHeader+partLines +sumOfLines+"</hr>";
	}
	
	var shippingLine = "<tr class='shippingLine'> " +
						"<td></td>" +
						"<td>"+json.order.shipping.shipPart+"</td>" +
						"<td>"+json.order.shipping.shipDesc+"</td> <td></td> " +
						"<td>"+json.order.shipping.shipQty+"</td> " +
						"<td class='sumOfLines'>"+json.order.shipping.shipSubTotal+"</td>" +
						"<td >"+json.order.shipping.shipTotal+"</td></tr>";
	
	var grandTotal = "<tr> <td></td> <td></td> <td></td> <td></td> <td></td>" +
					"<th class='grandTotal'>GrandTotal:</th>" +
					"<td class='grandTotal grandResult'></td></tr>";
	$(".table-responsive").append(tableBody+shippingLine+grandTotal+"</table>");
}

function grandTotal()
{
	var sum = 0;
	$('.sumOfLines').each(function(){sum += parseFloat($(this).text());});
	$(".grandResult").append((sum*1.2).toFixed(2));
}
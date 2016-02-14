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
	$.get("/res/?page=ORDER_DETAILS_PRESENTER&type=OrderInfo&data="+orderId.slice(start+1, end), function(data, textStatus)
	{
		var json = JSON.parse(data);
		insertCommonJSON(json);
		insertTransactionData(json);
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
	for(var i = 0 ; i < json.order.transactionInfo.length ; ++i)
	{
		var transactionHeader =
		"<table class='table table-condensed transactionTable'>"+
			"<tr>"+
			"<th>itemID</th>"+
			"<th>PartNo's</th>"+
			"<th>Purchased Qty</th>"+
			"<th>Title</th>"+
			"<th>Brand</th>"+
			"<th>SubTotal</th>"+
			"<th>Total</th>"+
			"</tr>"+
			"";
		
		var transactionLine =
			"<tr>"+
			"<td>"+json.order.transactionInfo[i].itemID+"</td>"+
			"<td>"+json.order.transactionInfo[i].partNo+"</td>"+
			"<td>"+json.order.transactionInfo[i].purchasedQty+"</td>"+
			"<td>"+json.order.transactionInfo[i].title+"</td>"+
			"<td>"+json.order.transactionInfo[i].brand+"</td>"+
			"<td>"+json.order.transactionInfo[i].purchasedPriceExVAT+"</td>"+
			"<td>"+json.order.transactionInfo[i].purchasedPriceIncVAT+"</td>"+
			"</tr>"+
		"</table>";
		
		var partsHeader =
		"<table class='table table-condensed partsTable'>"+
			"<tr>"+
			"<th>PartNo</th>"+
			"<th>Description</th>"+
			"<th>Part Qty</th>"+
			"<th>Unit Cost</th>"+
			"<th>Unit Price</th>"+
			"<th>Line Total</th>"+
			"</tr>"+
			"";
		
		var partLines="";
		
			for(var j = 0 ; j < json.order.transactionInfo[i].parts.length; ++j)
			{
				 partLines +=
					"<tr>"+
					"<td>"+json.order.transactionInfo[i].parts[j]+"</td>"+
					"<td>"+json.order.transactionInfo[i].partDescs[j]+"</td>"+
					"<td>"+json.order.transactionInfo[i].partQtys[j]+"</td>"+
					"<td>"+json.order.transactionInfo[i].partCosts[j]+"</td>"+
					"<td>"+json.order.transactionInfo[i].partPrices[j]+"</td>"+
					"<td>"+(json.order.transactionInfo[i].partQtys[j])*(json.order.transactionInfo[i].partPrices[j])+"</td>"+
					"</tr>"+
					"";
			}
//			$(".transactionData").append(partLines +"</div></br>");
			$(".table-responsive").append(transactionHeader+transactionLine+partsHeader+partLines +"</table>");
	}
}
////////////////////////////////////////////////////////////////////////////////////////IMPORTS
$("head").append("<link rel='stylesheet' href='css/order.css'>");
$("head").append("<script src='js/modules/addCommonContent.js'></script>");
//////////////////////////////////////////////////////////////////////////////////ENDOF IMPORTS

var testJSON=
"{\"order\":{\n"+
	"\"summaryInfo\":{\n"+
						"\"orderId\":\"202005061016\",\n"+
						"\"salesRecNo\":\"10335\",\n"+
						"\"shippingType\":\"UK_RoyaMailSecondClassStandard\",\n"+
						"\"createdTime\":\"2016-01-25 23:12:02\",\n"+
						"\"orderTotalIncVAT\":\"5.45\",\n"+
						"\"orderTotalExVAT\":\"4.54\",\n"+
						"\"VAT\":\"0.91\"\n"+
					"},\n"+
	"\"buyerInfo\":{\n"+
						"\"name\":\"Oscar Conti\",\n"+
						"\"buyerID\":\"OssiCont69\",\n"+
						"\"email\":\"blahblah@mymail.com\",\n"+
						"\"phone\":\"07865 258 698\",\n"+
						"\"street1\":\"A1273640261t\",\n"+
						"\"street2\":\"GSP Shipping Centre, 1 Langham Park\",\n"+
						"\"city\":\"South Normanton\",\n"+
						"\"county\":\"DerbyShire\",\n"+
						"\"postcode\":\"DE55 2GF\"\n"+
					"},\n"+
	"\"transactionInfo\":[\n"+
							"{\n"+
								"\"itemID\":\"331594867686\",\n"+
								"\"title\":\"PEUGEOT 206.207.208.406.407.expert - Engine Under Tray Clips x10 GENUINE 703018\",\n"+
								"\"purchasedPriceIncVAT\":\"2.65\",\n"+
								"\"purchasedPriceExVAT\":\"2.33\",\n"+
								"\"shippingCost\":\"0.0\",\n"+
								"\"purchasedQty\":\"1\",\n"+
								"\"brand\":\"PSA Peugeot Citroen (Genuine OE)\",\n"+
								"\"partNo\":\"703018(10)\",\n"+
								"\"parts\":[\"703018\"],\n"+
								"\"partQtys\":[\"10\"],\n"+
								"\"partPrices\":[\"0.23\"],\n"+
								"\"partCosts\":[\"0.05\"],\n"+
								"\"partDescs\":[\"HOG RING              7E\"]\n"+
							"},\n"+
							"{\n"+
								"\"itemID\":\"331594857708\",\n"+
								"\"title\":\"PEUGEOT ENGINE UNDERTRAY FIXING CLIPS X10 703016 206 207 406 407 508 806 807 \",\n"+
								"\"purchasedPriceIncVAT\":\"2.80\",\n"+
								"\"purchasedPriceExVAT\":\"2.21\",\n"+
								"\"shippingCost\":\"0.0\",\n"+
								"\"purchasedQty\":\"1\",\n"+
								"\"brand\":\"PSA Peugeot Citroen (Genuine OE)\",\n"+
								"\"partNo\":\"703016(10)\",\n"+
								"\"parts\":[\"703016\"],\n"+
								"\"partQtys\":[\"10\"],\n"+
								"\"partPrices\":[\"0.16\"],\n"+
								"\"partCosts\":[\"0.16\"],\n"+
								"\"partDescs\":[\"BUTTON                7E\"]\n"+
							"}\n"+
					"]\n"+
"}\n"+

"}";





///////////////////////////////////////////////////////////////////////////////////////////MAIN
/**
 * 
 */
$(document).ready(function(){
	var json = JSON.parse(testJSON);
	insertCommonJSON(json);
	insertTransactionData(json);
});
/////////////////////////////////////////////////////////////////////////////////////ENDOF MAIN

function insertCommonJSON(json)
{
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
		"<div class='row'>"+
			"<div class='col-xs-1'>Listing ID</div>"+
			"<div class='col-xs-1'>PartNo's</div>"+
			"<div class='col-xs-1'>Purchased Qty</div>"+
			"<div class='col-xs-5'>Title</div>"+
			"<div class='col-xs-2'>Brand</div>"+
			"<div class='col-xs-1'>Price(inc VAT)</div>"+
			"<div class='col-xs-1'>Price(ex VAT)</div>"+
			"</br>";
		
		var transactionLine =
			"<div class='col-xs-1'>"+json.order.transactionInfo[i].itemID+"</div>"+
			"<div class='col-xs-1'>"+json.order.transactionInfo[i].partNo+"</div>"+
			"<div class='col-xs-1'>"+json.order.transactionInfo[i].purchasedQty+"</div>"+
			"<div class='col-xs-5'>"+json.order.transactionInfo[i].title+"</div>"+
			"<div class='col-xs-2'>"+json.order.transactionInfo[i].brand+"</div>"+
			"<div class='col-xs-1'>"+json.order.transactionInfo[i].purchasedPriceIncVAT+"</div>"+
			"<div class='col-xs-1'>"+json.order.transactionInfo[i].purchasedPriceExVAT+"</div>"+
		"</div>";
		
		var partsHeader =
		"<div class='row'>"+
			"<div class='col-xs-1'></div>"+
			"<div class='col-xs-1'>PartNo</div>"+
			"<div class='col-xs-1'>Part Qty</div>"+
			"<div class='col-xs-5'>Description</div>"+
			"<div class='col-xs-2'></div>"+
			"<div class='col-xs-1'>Cost Price</div>"+
			"<div class='col-xs-1'>Sale Price</div>"+
			"</br>";
		
		var partLines="";
		
			for(var j = 0 ; j < json.order.transactionInfo[i].parts.length; ++j)
			{
				 partLines +=
					"<div class='col-xs-1'>"+"</div>"+
					"<div class='col-xs-1'>"+json.order.transactionInfo[i].parts[j]+"</div>"+
					"<div class='col-xs-1'>"+json.order.transactionInfo[i].partQtys[j]+"</div>"+
					"<div class='col-xs-5'>"+json.order.transactionInfo[i].partDescs[j]+"</div>"+
					"<div class='col-xs-2'></div>"+
					"<div class='col-xs-1'>"+json.order.transactionInfo[i].partCosts[j]+"</div>"+
					"<div class='col-xs-1'>"+json.order.transactionInfo[i].partPrices[j]+"</div>"+
					"</br>";
			}
//			$(".transactionData").append(partLines +"</div></br>");
			$(".transactionData").append(transactionHeader+transactionLine+partsHeader+partLines +"</div></br>");
	}
}
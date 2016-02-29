////////////////////////////////////////////////////////////////////////////////////////IMPORTS
$("head").append("<script src='js/external/list.min.js'></script>");
$("head").append("<script src='js/modules/ajaxTable.js'></script>");
$("head").append("<script src='js/modules/print.js'></script>");
$("head").append("<script src='js/modules/invoiceOrders.js'></script>");
$("head").append("<script src='js/modules/addCommonContent.js'></script>");
$("head").append("<script src='js/modules/colourCodeByStatus.js'></script>");
//////////////////////////////////////////////////////////////////////////////////ENDOF IMPORTS

///////////////////////////////////////////////////////////////////////////////////////////MAIN
/**
 * 
 */
$(document).ready(function(){
	var resultSelector=".sortable";
	var tableColumns=["Select", "Name","Date","SalesRecNo", "Account" , "ShippingType","Details","Status"];
	var sortableColumns=["Select", "Name","Date","SalesRecNo", "Account", "ShippingType","Status"];
	var queryString="/res/?page=SALES_ORDER_PRESENTER";
	var footerContent=	"<a class='btn btn-primary' onclick='invoiceAndPrint()'>Send to Warehouse</a>"+
	"<a class='btn btn-primary' href='/sales_orders.html'>Refresh</a>"+
	"<button onclick='printScreen()' class='btn btn-primary'>Print</button>";
	var headerContent="<h2>Sales - Orders </h2>";
	ajaxTable(resultSelector, tableColumns, sortableColumns, queryString, footerContent, headerContent, ajaxCallbacks);
	selectAllPickeableItems()
});
/////////////////////////////////////////////////////////////////////////////////////ENDOF MAIN

//-------------------------------------------------------------------------------AJAX CALLBACKS
/**
 * 
 */
function ajaxCallbacks()
{
	colourCode("Pickeable","Unpickeable", "Partial",".Status");
	selectAllPickeableItems();
	itemCount();
}
//-------------------------------------------------------------------------ENDOF AJAX CALLBACKS

//-------------------------------------------------------------------SELECT ALL PICKEABLE ITEMS
/**
 * 
 */
function selectAllPickeableItems()
{
	$("#autoTable").find("tr").each(function()
	{
		if($(this).find('.Status').text()=='Pickeable')
		{$(this).find('.Select>input').prop('checked', 'true');}
	});
}
//-------------------------------------------------------------ENDOF SELECT ALL PICKEABLE ITEMS

//-----------------------------------------------------------------------------------ITEM COUNT
/**
 * 
 */
function itemCount()
{
	var rows = $(".Status");
	rows = (rows.length - 1); //because of list.js template
	$("h2").append("<span class='badge'>"+rows+"</span>");
}
//-----------------------------------------------------------------------------ENDOF ITEM COUNT
/**
 * 
 */
function invoiceAndPrint()
{
	var orderNos="";

	$("#autoTable").find("tr").each(function()
	{
		if($(this).find('input[type="checkbox"]').is(':checked'))
		{orderNos += $(this).find('input[type="checkbox"]').prop('id')+",";}
	});
	invoiceOrders(orderNos);
}
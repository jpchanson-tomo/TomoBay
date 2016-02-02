////////////////////////////////////////////////////////////////////////////////////////IMPORTS
$("head").append("<script src='js/external/list.min.js'></script>");
$("head").append("<script src='js/modules/ajaxTable.js'></script>");
$("head").append("<script src='js/modules/addCommonContent.js'></script>");
//////////////////////////////////////////////////////////////////////////////////ENDOF IMPORTS


///////////////////////////////////////////////////////////////////////////////////////////MAIN
/**
 * 
 */
$(document).ready(function(){
	
	$("#datepicker1").datepicker({ dateFormat: "yy-mm-dd" }).val()
	$("#datepicker2").datepicker({ dateFormat: "yy-mm-dd" }).val()
	
});
/////////////////////////////////////////////////////////////////////////////////////ENDOF MAIN

function submitDates()
{
	var from = $('#datepicker1').datepicker({ dateFormat: 'dd-mm-yy' }).val();
	var to = $('#datepicker2').datepicker({ dateFormat: 'dd-mm-yy' }).val();
	
	var resultSelector=".sortable";
	var tableColumns=["No.", "OutOfHours","SalesRecNo","CreatedTime", "OrderTotal", "Details"];
	var sortableColumns=["No.", "OutOfHours","SalesRecNo","CreatedTime", "OrderTotal"];
	var queryString="/res/?page=OUT_OF_HOURS_PRESENTER&type="+from+"&data="+to;
	var footerContent=	"<div class='total'></div>"
	var headerContent="<h2>Out of Hours orders - <small class='warning'>From: </small>"+from+" <small class='warning'>To: </small> "+to+"</h2>";
	ajaxTable(resultSelector, tableColumns, sortableColumns, queryString, footerContent, headerContent, ajaxCallbacks);
}

function clearDates()
{
	$("#hacker-list").remove();
}

function ajaxCallbacks()
{
	var sum = 0;
	$('.price').each(function(){
	    sum += parseFloat($(this).text());
	    $(this).prepend("£");
	});
	
	$(".total").html("The Cumulative Total is: <big>£"+sum.toFixed(2)+"</big>");
}
////////////////////////////////////////////////////////////////////////////////////////IMPORTS
$("head").append("<script src='js/external/list.min.js'></script>");
$("head").append("<script src='js/modules/ajaxTable.js'></script>");
$("head").append("<script src='js/modules/print.js'></script>");
$("head").append("<script src='js/modules/colourCodeByStatus.js'></script>");
$("head").append("<script src='js/modules/addCommonContent.js'></script>");
//////////////////////////////////////////////////////////////////////////////////ENDOF IMPORTS

///////////////////////////////////////////////////////////////////////////////////////////MAIN
$(document).ready(function(){
		var resultSelector=".sortable";
		var tableColumns=["Select", "Name","Date","SalesRecNo","Details"];
		var sortableColumns=["Name","Date","SalesRecNo"];
		var queryString="/res/?page=SALES_HISTORY_PRESENTER";
		var footerContent=	"<a class='btn btn-primary'>Send to Warehouse</a>"+
		"<a class='btn btn-primary' href='/sales_history.html'>Refresh</a>"+
		"<button onclick='printScreen()' class='btn btn-primary'>Print</button>";
		var headerContent="<h2>Sales - History</h2>";
		ajaxTable(resultSelector, tableColumns, sortableColumns, queryString, footerContent, headerContent);
	});
/////////////////////////////////////////////////////////////////////////////////////ENDOF MAIN
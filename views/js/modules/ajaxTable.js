//////////////////////////////////STARTOF AJAX TABLE///////////////////////////////////////////
/**********************************************************************************************
 * 
 * @param resultSelector
 * @param tableColumns
 * @param sortableColumns
 * @param queryString
 * @param headerContent
 * @param footerContent
 * @returns void
 *********************************************************************************************/
function ajaxTable(resultSelector, tableColumns, sortableColumns, queryString, footerContent, headerContent)
{
	insertHTMLTemplate(resultSelector, tableColumns, sortableColumns, footerContent, headerContent);
	var options;
	var values;
	var hackerList;
	

	$(".spinnerDiv").html("<img class='spinner' src='images/ajax-loader.gif' alt='Wait' />");
	$(".spinnerDiv").append("<p class='spinner-text'><big>Loading data from Server</big></p>");
	$.get(queryString, function(data, textStatus)
	{
		$(".spinner").hide();
		$(".spinner-text").hide();
		options = {item: 'hacker-item'};
		values = JSON.parse(data);
		hackerList = new List('hacker-list', options, values.tableData);
	});
}

/**
 * 
 * @param resultSelector
 * @param tableColumns
 * @param sortableColumns
 * @param queryString
 * @param footerContent
 * @param headerContent
 * @param Callback
 */
function ajaxTable(resultSelector, tableColumns, sortableColumns, queryString, footerContent, headerContent, callback)
{
	insertHTMLTemplate(resultSelector, tableColumns, sortableColumns, footerContent, headerContent);
	var options;
	var values;
	var hackerList;
	

	$(".spinnerDiv").html("<img class='spinner' src='images/ajax-loader.gif' alt='Wait' />");
	$(".spinnerDiv").append("<p class='spinner-text'><big>Loading data from Server</big></p>");
	$.get(queryString, function(data, textStatus)
	{
		$(".spinner").hide();
		$(".spinner-text").hide();
		options = {item: 'hacker-item'};
		values = JSON.parse(data);
		hackerList = new List('hacker-list', options, values.tableData);
		callback();
	});
}

/**********************************************************************************************
 * 
 * @param resultSelector
 * @param tableColumns
 * @param sortableColumns
 * @param footerContent
 * @param headerContent
 * @returns void
 *********************************************************************************************/
function insertHTMLTemplate(resultSelector, tableColumns, sortableColumns, footerContent, headerContent)
{
	var headElements = createHeadElements(tableColumns, sortableColumns);
	var rowElements = createRowElements(tableColumns);
	$(resultSelector).append
	(
		"<div id='hacker-list' class='panel panel-default panel-primary'>" +
			"<div class='panel-heading'>"+
				headerContent+
				"<input class='search' style='float:right;margin-top:-1%;color:#337AB7;' placeholder='Search'/>" +
//				"<button class='btn btn-xs btn-success' style='float:right;margin-top:-1%;color:#000000;' onclick='defaultOrder()'>Default Order</button>" +
			"</div>"+
			"<div class='spinnerDiv'></div>"+
			"<div class='table table-responsive'>"+
				"<table class='table table-bordered table-striped table-condensed' id='autoTable'>"+
					"<thead>"+
						headElements +
					"</thead>"+
					"<tbody class='list'></tbody>"+
				"</table>"+
			"</div>"+
			"<div class='panel-footer panel-primary'>"+
				footerContent+
			"</div>"+
		"</div>"+

		"<div style='display:none;'>"+
			"<table>"+
				"<tbody class='list'>"+
					"<tr id='hacker-item'>"+
						rowElements +
      				"</tr>"+
      			"</tbody>"+
      		"</table>"+
      	"</div>"
	);
}

/**********************************************************************************************
 * 
 * @param tableColumns
 * @param sortableColumns
 * @returns String
 *********************************************************************************************/
function createHeadElements(tableColumns, sortableColumns)
{
	var headElements = "";
	for(var i=0 ; i < tableColumns.length ; ++i)
	{
		var tmp = "";
		for(var j=0 ; j < sortableColumns.length ; ++j)
		{
			
			if(tableColumns[i]==sortableColumns[j])
			{tmp = "<th class='sort' data-sort='"+tableColumns[i]+"'>"+tableColumns[i]+"</th>";break;}
			else
			{tmp = "<th>"+tableColumns[i]+"</th>";}
		}
		headElements += tmp
	}
	return headElements;
}

/**********************************************************************************************
 * 
 * @param tableColumns
 * @returns String
 *********************************************************************************************/
function createRowElements(tableColumns)
{
	var rowElements = "";
	
	for(var i=0 ; i < tableColumns.length ; ++i)
	{rowElements += "<td class='"+tableColumns[i]+"'></td>";}
	
	return rowElements;
}
///////////////////////////////ENDOF AJAX TABLE////////////////////////////////////////////////
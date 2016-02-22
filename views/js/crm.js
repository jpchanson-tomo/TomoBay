////////////////////////////////////////////////////////////////////////////////////////IMPORTS
$("head").append("<script src='js/external/list.min.js'></script>");
$("head").append("<script src='js/modules/ajaxTable.js'></script>");
$("head").append("<script src='js/modules/ajaxButton.js'></script>");
$("head").append("<script src='js/modules/addCommonContent.js'></script>");
//////////////////////////////////////////////////////////////////////////////////ENDOF IMPORTS

///////////////////////////////////////////////////////////////////////////////////////////MAIN
$(document).ready(function(){
		tableSetUp();
		
	});
/////////////////////////////////////////////////////////////////////////////////////ENDOF MAIN

/**********************************************************************************************
 * 
 *********************************************************************************************/
function tableSetUp()
{
	var resultSelector=".sortable";
	var tableColumns=["BuyerID", "Name", "Actions"];
	var sortableColumns=[""];
	var queryString="/res/?page=CRM_OVERVIEW_PRESENTER&type=BUYER_LIST";
	var footerContent=	"<h4><div class='label label-default resultLabel'>No actions performed</div></h4>";
	var headerContent="<h2>CRM - Buyers</h2>";
	
	$(".sortable").html("<img class='spinner' src='images/ajax-loader.gif' alt='Wait' />");
	$(".sortable").append("<p class='spinner-text'><big>Loading data from Server</big></p>");
	$.get(queryString, function(data, textStatus)
			{
				values = modifyJSON(JSON.parse(data));
				$(".spinner").hide();
				$(".spinner-text").hide();
				ajaxTable2(resultSelector, tableColumns, sortableColumns, values, footerContent, headerContent);
			});
}

/**********************************************************************************************
 * 
 * @param json
 * @returns
 *********************************************************************************************/
function modifyJSON(json)
{
	for(var i = 0 ; i < json.tableData.length ; ++i)
	{
		json.tableData[i].Actions = "<button class='btn btn-primary btn-sm' data-toggle='modal' data-target='#myModal' onclick='viewDetails("+i+")'>View Details</button>" +
									"<button class='btn btn-danger btn-sm' onclick='ajaxButtonDI(\""+json.tableData[i].BuyerID+"\", \"/res/?page=CRM_OVERVIEW_PRESENTER&type=RE_SCAN_BUYER&data=\", \".resultLabel\")'>Re-Scan</button>";
	}
	return json;
}

/**********************************************************************************************
 * 
 * @param index
 *********************************************************************************************/
function viewDetails( index)
{
	$(".modal-header").html(
			"<button type='button' class='close' data-dismiss='modal' aria-label='Close'><span aria-hidden='true'>&times;</span></button>"+
			"<h1><strong>BuyerID: </strong>"+values.tableData[index].BuyerID+"</h1>" 
							);
	
	$.get("/res/?page=CRM_DETAIL_PRESENTER&type=BUYER_DETAILS&data="+values.tableData[index].BuyerID, function(data, status)
	{
		var details = JSON.parse(data);
		$(".modal-body").html(
				"<h2>Name:  <small>" + details.name + "</small></h2>" +
				"<h2>Street1:  <small>" + details.street1 +"</small></h2>"+
				"<h2>Street1:  <small>" + details.street2 +"</small></h2>"+
				"<h2>City: <small>" + details.city +"</small></h2>"+
				"<h2>County: <small>" + details.county +"</small></h2>"+
				"<h2>PostCode: <small>" + details.postcode +"</small></h2>"+
				"<h2>Email: <small>" + details.email +"</small></h2>"+
				"<h2>Phone: <small>" + details.phone +"</small></h2>"
							)
							
		$(".modal-footer").html(
				"<button class='btn btn-sm btn-primary' onclick='emailBuyer(\""+details.email+"\")'>Send Email</button>"+
				"<button type='button' class='btn btn-sm btn-danger' data-dismiss='modal'>Close</button>"
								)
	});
}

/**********************************************************************************************
 * 
 * @param email
 *********************************************************************************************/
function emailBuyer(email)
{
	$('#myModal').modal('hide');
	
	$('#myModal').on('hidden.bs.modal', function () 
	{
		$(".modal-header").html(
				"<button type='button' class='close' data-dismiss='modal' aria-label='Close'><span aria-hidden='true'>&times;</span></button>"+
				"<h1><strong>To: </strong>"+email+"</h1>"
				);
		
		$(".modal-body").html( 
				"<div class='form-group'><label for='cc'>CC:</label><input type='text' class='form-control' id='cc'></div>" +
				"<div class='form-group'><label for='bcc'>BCC:</label><input type='text' class='form-control' id='bcc'></div>" +
				"<div class='form-group'><label for='subj'>Subject:</label><input type='text' class='form-control' id='subj'></div>" +
				"<div class='form-group'><label for='comment'>Message:</label><textarea class='form-control' rows='10' id='comment'></textarea></div>"
							);
		
		$(".modal-footer").html(
				"<button class='btn btn-sm btn-primary'>Send</button>"+
				"<button type='button' class='btn btn-sm btn-danger' data-dismiss='modal'>Close</button>");
				
		$('#myModal').modal('show');
		$('#myModal').off('hidden.bs.modal');
	})
}

/**********************************************************************************************
 * 
 *********************************************************************************************/
function rescanBuyer(index)
{
	alert(values.tableData[index].BuyerID);
}
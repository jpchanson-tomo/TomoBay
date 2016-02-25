/**
 * currently a dummy;
 * @param orderNos comma separated string of order numbers
 */
function invoiceOrders(orderNos)
{
	$('#myModal').modal();
	$(".modal-body").html("<img class='spinner' src='images/ajax-loader.gif' alt='Wait' />");
	$(".modal-body").append("<p class='spinner-text'><big>Loading data from Server</big></p>");
	$.get("/res/?page=ORDER_DETAILS_PRESENTER&type=INVOICE_ORDERS&data="+orderNos, function(data, textStatus)
	{
		$(".spinner").hide();
		$(".spinner-text").hide();
		$(".modal-header").html(
				"<button type='button' class='close' data-dismiss='modal' aria-label='Close'><span aria-hidden='true'>&times;</span></button>"+
				"<h1><strong>Invoiced</strong></h1>" 
								);
		var result = data.replace("/,/g",",</br>")
		$(".modal-body").html("<p>" + result + "</p>");
		
		$(".modal-footer").html("<button class='btn btn-info' onClick='printOrders(\""+orderNos+"\")' data-dismiss='modal'>Print</button>");
	});
}

/**
 * 
 */
function printOrders(orderNos)
{
	$('#myModal').on('hidden.bs.modal', function () 
	{
		$('#myModal').modal('show');
		$(".modal-body").html("<img class='spinner' src='images/ajax-loader.gif' alt='Wait' />");
		$(".modal-body").append("<p class='spinner-text'><big>Loading data from Server</big></p>");
		$.get("/res/?page=ORDER_DETAILS_PRESENTER&type=PRINT_INVOICES&data="+orderNos, function(data, textStatus)
		{
			$(".spinner").hide();
			$(".spinner-text").hide();
			
			$(".modal-header").html(
				"<button type='button' class='close' data-dismiss='modal' aria-label='Close' onclick='reloadPage()'><span aria-hidden='true'>&times;</span></button>"+
				"<h1>Printed</h1>"
									);
								
			var result = data.replace("/,/g",",</br>")
			$(".modal-body").html("<p>" + result + "</p>");
								
			$(".modal-footer").html("<button type='button' class='btn btn-info' data-dismiss='modal'>Close</button>");
		});
		$('#myModal').off('hidden.bs.modal');
	});
}

/**
 * 
 */
function reloadPage()
{location.reload();}
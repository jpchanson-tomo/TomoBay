/**
 * loads the orders from the data servlet using the parameter data=SALES_ORDER_PRESENTER
 */
$(document).ready(function()
{
	$.get("/res/?data=SALES_ORDER_PRESENTER", function(data, textStatus)
    {
		$(".table-condensed").append(data);
		colourCode();
    });
})
$(document).ready(function()
{
	$.get("/res/?data=SALES_ORDER_PRESENTER", function(data, textStatus)
        {
                $(".table-responsive").append(data);
                colourCode();
        });
})
$(document).ready(function()
{
	$.get("/res/?data=SALES_PRESENTER", function(data, textStatus)
        {
                $(".table-responsive").append(data);
        });
});
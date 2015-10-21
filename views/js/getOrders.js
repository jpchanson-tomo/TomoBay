$(document).ready(function()
{
	$.get("/res/?data=SALES_PRESENTER", function(data, textStatus)
        {
                $(".panel-body").append(data);
        });
});
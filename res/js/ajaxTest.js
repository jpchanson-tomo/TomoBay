$(document).ready(function()
{
	$.get("/res/", function(data, textStatus)
        {
                $(".panel-body").append(data);
        });
});
$(document).ready(function()
{
	$.get("/res/?data=ROOT_PRESENTER", function(data, textStatus)
        {
                $(".panel-body").append(data);
        });
});
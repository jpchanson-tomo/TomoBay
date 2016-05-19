function start()
{
	$.get("/res/?page=ADMIN_PRESENTER&type=PERIODIC_SERVICES_CONTROLLER&data=START", function(data, textStatus)
			{alert(data);});
}

function stop()
{
	$.get("/res/?page=ADMIN_PRESENTER&type=PERIODIC_SERVICES_CONTROLLER&data=PAUSE", function(data, textStatus)
			{alert(data);});
}

$(document).ready(function()
{
	
});
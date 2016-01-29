function start()
{
	$.get("/res/?page=ADMIN_SERVICE_PRESENTER&type=PeriodicServices&data=START", function(data, textStatus)
			{alert(data);});
}

function stop()
{
	$.get("/res/?page=ADMIN_SERVICE_PRESENTER&type=PeriodicServices&data=STOP", function(data, textStatus)
			{alert(data);});
}
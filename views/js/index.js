function start()
{
	$.get("/res/?page=ADMIN_PRESENTER&type=PeriodicServices&data=START", function(data, textStatus)
			{alert(data);});
}

function stop()
{
	$.get("/res/?page=ADMIN_PRESENTER&type=PeriodicServices&data=PAUSE", function(data, textStatus)
			{alert(data);});
}
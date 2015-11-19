function colourCode()
{
	pickeable = $(".status"); 
	
	for (var i = 0 ; i < pickeable.length ; ++i)
	{
		if(pickeable[i].innerHTML == "unpickeable")
		{
				pickeable[i].style.color="blue";
		}
	}
}

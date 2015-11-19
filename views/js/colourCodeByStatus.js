function colourCode()
{
	pickeable = $(".status"); 
	
	for (var i = 0 ; i < pickeable.length ; ++i)
	{
		if(pickeable[i].innerHTML == "Pickeable")
		{
				pickeable[i].parentElement.style.color="green";
		}
		else if (pickeable[i].innerHTML == "Unpickeable")
		{
			pickeable[i].parentElement.style.color="red"
		}
		else
		{
			pickeable[i].parentElement.style.color="orange"
		}
		
	}
}

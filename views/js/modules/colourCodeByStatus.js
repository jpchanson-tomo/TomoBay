///////////////////////////////////STARTOF COLOURCODE//////////////////////////////////////////
/**********************************************************************************************
 * colours rows of a table according to the pickeability of the contents of the status element.
 * @param selector selector for a list of elements who's innerHTML will be analysed
 * @param green if the selector.innerHTML == this value, colour the parent element green
 * @param red if the selector.innerHTML == this value, colour the parent element red
 * 
 * everything else is coloured amber
 *********************************************************************************************/
function colourCode(green, red, selector)
{
	var pickeable = $(selector);
	for (var i = 0 ; i < pickeable.length ; ++i)
	{
		if(pickeable[i].innerHTML == green)
		{pickeable[i].parentElement.style.color="green";}
		else if (pickeable[i].innerHTML == red)
		{pickeable[i].parentElement.style.color="red";}
		else
		{pickeable[i].parentElement.style.color="orange";}
	}
}
//////////////////////////////////////ENDOF COLOURCODE/////////////////////////////////////////
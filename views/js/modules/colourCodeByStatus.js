///////////////////////////////////STARTOF COLOURCODE//////////////////////////////////////////
/**********************************************************************************************
 * colours rows of a table according to the pickeability of the contents of the status element.
 * @param selector selector for a list of elements who's innerHTML will be analysed
 * @param green if the selector.innerHTML == this value, colour the parent element green
 * @param red if the selector.innerHTML == this value, colour the parent element red
 * 
 * everything else is coloured amber
 *********************************************************************************************/
function colourCode(green, red, amber, selector)
{
	var pickeable = $(selector);
	for (var i = 0 ; i < pickeable.length ; ++i)
	{
		if(pickeable[i].innerHTML == green)
		{pickeable[i].parentElement.style.color="green";}
		else if (pickeable[i].innerHTML == red)
		{pickeable[i].parentElement.style.color="red";}
		else if (pickeable[i].innerHTML == amber)
		{pickeable[i].parentElement.style.color="orange";}
		else
		{
			pickeable[i].parentElement.style.color="purple";
			blink(pickeable[i]);
		}
	}
}
//////////////////////////////////////ENDOF COLOURCODE/////////////////////////////////////////

function blink(element)
{
	setInterval(function()
	{
		if(element.parentElement.style.color=="purple")
		{element.parentElement.style.color="red";}
		else if (element.parentElement.style.color=="red")
		{element.parentElement.style.color="orange";}
		else
		{element.parentElement.style.color="purple";}
	}
	,100)
}
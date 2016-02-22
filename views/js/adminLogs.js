////////////////////////////////////////////////////////////////////////////////////////IMPORTS
$("head").append("<script src='js/modules/ajaxTable.js'></script>");
$("head").append("<script src='js/modules/addCommonContent.js'></script>");
$("head").append("<script src='js/modules/colourCodeByStatus.js'></script>");
$("head").append("<link rel='stylesheet' href='css/adminLogViewer.css'></link>");
//////////////////////////////////////////////////////////////////////////////////ENDOF IMPORTS

///////////////////////////////////////////////////////////////////////////////////////////MAIN
/**
 * 
 */
$(document).ready(function()
{
	 log = new LogFile(1, ".logFile", ".status");
	
});
/////////////////////////////////////////////////////////////////////////////////////ENDOF MAIN

//---------------------------------------------------------------------------------------------
/**
 * 
 */
function LogFile(minRefreshTime, logViewSelector, statusSelector)
{
	var logFile_M;
	
	var minRefreshTime_M = minRefreshTime;
	
	var runningStatus=true;
	
	
	/**
	 * 
	 */
	this.startPoll= function()
	{
		runningStatus=true;
		poll();
		$(statusSelector).html("<big>Running</big>");
	};
	
	/**
	 * 
	 */
	this.stopPoll = function()
	{
		runningStatus=false;
		$(statusSelector).html("<big>Stopped</big>");
	}
	
	/**
	 * 
	 */
	function poll()
	{
		if(runningStatus==true)
		{
			setTimeout(function()
			{
				$.get("/res/?page=ADMIN_PRESENTER&type=LOG_FILE_VIEWER", function(data, textStatus)
				{
					logFile_M = JSON.parse("{\"log\":["+data+"]}");
					$(logViewSelector).html(enumerateLogFile(logFile_M));
					poll();
				});
			}, (minRefreshTime_M*1000));
		}
	}
	
	/**
	 * 
	 * @param JSON
	 */
	function enumerateLogFile(JSON)
	{
		var result=	"<div class='container-fluid'><table class='table table-striped table-hover table-condensed'>" +
					"<thead><tr><th>Source</th><th>DateTime</th><th>Message</th></tr></thead><tbody>";
		
		for(var i = JSON.log.length-1 ; i >= 0 ; --i)
		{
			result += 	"<tr>" +
						"<td><em>"+JSON.log[i].source + "</em> </td>" +
						"<td>["+ JSON.log[i].time + "]</td> " + 
						"<td><strong>"+JSON.log[i].message+"</strong></td>"+
						"</tr>";
		}
		result += "</tbody></table></div>";
		return result;
	}
}
//---------------------------------------------------------------------------------------------
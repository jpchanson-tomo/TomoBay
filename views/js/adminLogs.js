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
				$.get("/res/?page=ADMIN_PRESENTER&type=LOGFILE", function(data, textStatus)
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
		var result="<div class='container-fluid'>";
		
		for(var i = JSON.log.length-1 ; i >= 0 ; --i)
		{
			result += 	"<div class='row'>" +
						"<div class='col-xs-2'><em>"+JSON.log[i].source + "</em> </div>" +
						"<div class='col-xs-2'>["+ JSON.log[i].time + "]</div> " + 
						"<big><strong>"+JSON.log[i].message+"</strong></big>"+
						"</div>";
		}
		result += "</div>";
		return result;
	}
}
//---------------------------------------------------------------------------------------------
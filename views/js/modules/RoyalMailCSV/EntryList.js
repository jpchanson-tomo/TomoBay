////////////////////////////////////////////////////////////////////////////////////////////////CTOR
/**
 * This class defines an List of entries to be submitted to the server so that a CSV file can be 
 * generated.
 * @param container a String containing the CSS selector that you wish the addbox to be created inside
 * @param entryTag the html tag (minus angle brackets) that you would like the entry to be wrapped in.
 * @param callback function to be called once the addbox has been created.
 * @dependancy ajaxButton
 */
function EntryList(resultContainer, entryTag, callback)
{	
	//the container for the AddBox widget
	this.container_M = resultContainer;
	//the tag to use for the entry
	this.tag_M = entryTag;
	//count of the number of entries in the list
	this.entryCount_M = 0;
	//inserts content for modal
	function insertModal()
	{
		$("body").append("<span id='ELModalContainer'></span>");
		$("#ELModalContainer").load("/js/modules/RoyalMailCSV/entryListModal.html");
	}
	insertModal();
	//perform callback if there is one
	if(callback!=null){callback();}
};
//////////////////////////////////////////////////////////////////////////////////////////ENDOF CTOR

///////////////////////////////////////////////////////////////////////////////////PROTOTYPE METHODS
/**
 * adds an entry to the list
 */
EntryList.prototype.addEntry = function()
{
	var entryID = "entry"+this.entryCount_M;
	var onClickAttr = " onclick='EntryList.prototype.lauchModal(this.id)' ";
	var openTag = "<"+this.tag_M+" id='"+entryID+"'"+onClickAttr+">";
	var closeTag = "</"+this.tag_M+">";
	var ENTRY = "<span id='entryList_account'>Click me to edit </span> - <span id='entryList_SRN'> </span> - " +
				"<span id='entryList_Service'> </span> - <span id='entryList_ServEnhance'> </span> - " +
				"<span id='entryList_Format'> </span> <span style='visibility:hidden;'>|</span>";
	
	$(this.container_M).append(openTag+ENTRY+closeTag);
	this.entryCount_M+=1;
};

/**
 * launches the modal to edit the entry
 * @param entrySelector the CSS selector associated with the entry to be modified.
 */
EntryList.prototype.lauchModal = function(entrySelector)
{
	//store the current values of the data for the entry clicked on
	var accCurrent = $("#"+entrySelector+" > #entryList_account").text();
	var srnCurrent = $("#"+entrySelector+" > #entryList_SRN").text();
	var serviceCurrent = $("#"+entrySelector+" > #entryList_Service").text();
	var enhanceCurrent = $("#"+entrySelector+" > #entryList_ServEnhance").text();
	var formatCurrent = $("#"+entrySelector+" > #entryList_Format").text();
	
	console.log(accCurrent+" "+srnCurrent+" "+serviceCurrent+" "+enhanceCurrent+" "+formatCurrent);
	
	//add onclick to modal 'OK' button
	$("#ELModalButton").attr("onclick","EntryList.prototype.updateList('"+entrySelector+"')");
	//attach placeholders 
	$("#ELMAccount").attr("placeholder",accCurrent);
	$("#ELMSRN").attr("placeholder", srnCurrent);
	$("#ELMSRN").val("");
	
	
	$("#EntryListModal").modal('toggle'); 
	//$("#ELModalBody").html(modalContent);
};

/**
 * 
 */
EntryList.prototype.updateList = function(entrySelector)
{
	if($("#ELMAccount").val()!=null)
	{$("#"+entrySelector+" > #entryList_account").text($("#ELMAccount").val());}
	if($("#ELMSRN").val()!="")
	{$("#"+entrySelector+" > #entryList_SRN").text($("#ELMSRN").val());}
	$("#"+entrySelector+" > #entryList_Service").text($("#ELMService").val());
	$("#"+entrySelector+" > #entryList_ServEnhance").text($("#ELMServiceEnhance").val());
	$("#"+entrySelector+" > #entryList_Format").text($("#ELMFormat").val());
}

/**
 * removes the last entry in the list
 */
EntryList.prototype.removeLastEntry = function()
{
	this.entryCount_M-=1;
	$(this.container_M +">"+"#entry"+this.entryCount_M).remove();
};

/**
 * 
 */
EntryList.prototype.submit = function()
{
	var entryData = $(this.container_M).text()
	$.get("/res/?page=ROOT_PRESENTER&type=GENERATE_ROYAL_MAIL_CSV&data="+entryData, function(data, status)
	{
		if(data.search("\"") == -1)
		{
			alert(data);
		}	
		else
		{
//			var uriContent = "data:text/octet-stream," + encodeURIComponent(data);
//			window.open(uriContent,"new_shipments");
			window.open("./resources/RoyalMail.csv","new_shipments");  //fallback solution
		}
	});
	//alert($(this.container_M).text());
}
/////////////////////////////////////////////////////////////////////////////ENDOF PROTOTYPE METHODS
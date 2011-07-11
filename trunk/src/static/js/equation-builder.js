

var checkFormula = function(f) {
	
	if (f[0] == "quant") {
		var a = new Array();
		for (var i =1;i<Object.size(f);i++) {
			checkFormula(a)
		}
	}
	
	
	
}

var checkBases = function() {
	var formula = Array(jQuery("#formula > li").size());
	for (var i=1;i<=jQuery("#formula > li").size();i++) {
		var current = jQuery("#formula li:nth-child(" + i + ")").attr("id");
		if (current == 'base') {
			formula[i] = checkSingleBase("#formula li:nth-child(" + i + ")");
		} else {
			if (current == "all" || current == "exist")
				formula[i] = "quant";
			else if (current == "(" || current == ")") {
				formula[i] = current;
			} else {
				if (current == "and" || current == "or" || current=="impl")
					formula[i] = "verk";
				else
					formula[i] = current;
			}
		}
	}
	return formula;
}

var checkSingleBase = function (item) {
	var varAusdruck = "^-\?\d\*[a-z]{1}((\\+\|-)\\d\*[a-z]{1})\*jQuery";
	var va = new RegExp(varAusdruck , "g");
	
	var numAusdruck = "^\\d\*jQuery";
	var num = new RegExp(numAusdruck , "g");
	
	if (va.test(jQuery(item + " .vars").val()) && num.test(jQuery(item + " .number").val())) 
		return "1";
	else
		return "0";
}

var makeFormula = function() {
	var output = "";
	for (var i=1;i<=jQuery("#formula > li").size();i++) {
		var current = jQuery("#formula > li:nth-child(" + i + ")").attr("id");
		switch (current) {
			case "all": output += "A" + jQuery("#formula > li:nth-child(" + i + ") select").val() + " "; break;
			case "exist": output += "E" + jQuery("#formula > li:nth-child(" + i + ") select").val() + " "; break;
			case "and": output += " && "; break;
			case "or": output += " || "; break;
			case "impl": output += " => "; break;
			case "not": output += "!"; break;
			case "base": 
				output += jQuery("#formula > li:nth-child(" + i + ") .vars").val(); 
				output += jQuery("#formula > li:nth-child(" + i + ") select").val();
				output += jQuery("#formula > li:nth-child(" + i + ") .number").val();
				break;
			case "braopen": output += "("; break;
			case "braclose": output += ")"; break;
		}
		
	}
	
	return output;
}

jQuery(function() {
  jQuery( "#equation-builder" ).dialog({
	  		autoOpen:false,
			modal: true,
			width: 710,
			height:350,
			buttons: {
				Validate : function() {
					
					jQuery.getJSON("/solver/" , 
							{
			                    request: "test",
			                    equation: makeFormula,
								clientId: 0
							}, function(data) {
								if (data["valid"]) {
									jQuery("#equation-builder-status").html("Congratulations, you have successfully created a valid formula!"); 
								} else {
									jQuery("#equation-builder-status").html("Sorry, this is not yet a valid formula.");
								}
							});
				},
				
				Ok: function() {
					jQuery("#equation" + jQuery("#equation-builderClientId").val()).val(makeFormula());
					jQuery("#formula").html("");
					jQuery( this ).dialog( "close" );
				}
  
			}
		});
  
  		
			
        jQuery( "li", jQuery("#sortableElements") ).draggable({
			cancel: "select , input", // clicking an icon won't initiate dragging
			revert: "invalid", // when not dropped, the item will revert back to its initial position
			helper: "clone",
			cursor: "move",
			connectToSortable:'#formula'
		});
			
		// let the trash be droppable, accepting the gallery items
		jQuery("#formula").droppable({
			accept: "#sortableElements > li",
			activeClass: "ui-state-highlight",
			drop: function( event, ui ) {
                jQuery("#formula").append("<div class='ui-state-default " + ui.draggable.html() + "'>" + ui.draggable.html() + "</div>");
			}
		});

        jQuery("#formula").sortable({
          update: function(event, ui) {}
        });
        jQuery( "#formula" ).disableSelection();
        
  });
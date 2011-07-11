jQuery.fn.selectRange = function(start, end) {
    return this.each(function() {
        if(this.setSelectionRange) {
            this.focus();
            this.setSelectionRange(start, end);
        } else if(this.createTextRange) {
            var range = this.createTextRange();
            range.collapse(true);
            range.moveEnd('character', end);
            range.moveStart('character', start);
            range.select();
        }
    });
};

//Checks if the browser support WebWorkers
function supports_web_workers() {
	  return !!window.Worker;
}

var macroCount = 1;
var macros = new Array(0);
var macroIds = new Array(0);

  var downloadURL = function(url)
  {
      var iframe;
      iframe = document.getElementById("hiddenDownloader");
      if (iframe === null)
      {
          iframe = document.createElement('iframe');  
          iframe.id = "hiddenDownloader";
          iframe.style.visibility = 'hidden';
          document.body.appendChild(iframe);
      }
      iframe.src = url;   
  }

  Object.size = function(obj) {
      var size = 0, key;
      for (key in obj) {
          if (obj.hasOwnProperty(key)) size++;
      }
      return size;
  };
  
    var length = 0;

  var solution = Array(1);
  
  	function paintGraph(url , canvas) {
		jQuery("#canviz"+canvas).html("<img src='" + url +"'><br>");
		//new Canviz('canviz' + canvas, url);
	}

    function buildAccordion(clientId) {
      jQuery("#accordion" + clientId).remove();
      jQuery("#exportAll" + clientId).remove();

      jQuery("#tabs-" + clientId).append("<div id=\'accordion" + clientId +  "' class='accordion'><h3><a href='#'>Solutions</a></h3><div><p id='gridText-" + clientId + "'></p></div><h3><a href='#'>Automaton</a></h3><div><div id='canviz" + clientId + "' class='canviz'></div><button id='export" + clientId + "' name='" + clientId + "'>Export to .gv</button></div></div>");
  
      jQuery("#accordion" + clientId).accordion({clearStyle:true,autoHeight:false});
      jQuery( "#export" + clientId )
			.button()
			.click(function(e) {
                  window.open('export/?file=' + solution[this.name]["solutionAut"],"_newtab");
              });
      jQuery("#accordion"+clientId).accordion("activate" , 0);
      
      jQuery("#tabs-" + clientId).append("<button id='exportAll" + clientId + "' name='" + clientId + "'>Export</button>");
      jQuery( "#exportAll" + clientId )
		.button()
		.click(function(e) {
			window.open(solution[this.name]["export"],"_newtab");
        });
      
    }

    function makeSolution(abs, data, id ,type) {
    	
    	var text = "";
    	if (abs == "-1")
			text = "There are &#8734; solutions to your formula.";
		  else {
			if (abs == "0")
				text = "This formula has no solutions.";
			else {
				if (abs == "1")
					text = "There is exactly " + abs + " solution to your formula.";
				else
					text = "There are " + abs + " solutions to your formula.";
			}
		  }
    	jQuery("#gridText-" + id).html(text +"<br>");
    	
    	if (type == "Max" || type == "Min") {
    		
    		if (data["OptimizedSolution"] == -1) {
    			jQuery("#gridText-" + id).append("<br>Your optimization could not be handled, since there are infinitly many solutions.");
    		}else {
    			jQuery("#gridText-" + id).append("<br>Here is your optimized solution:");
    			if (type == "Max")
    				jQuery("#gridText-" + id).append("<br>The maximal value of your term is " + data["OptimizedSolution"]);
    			
    			if (type == "Min")
        			jQuery("#gridText-" + id).append("<br>The minimal value of your term is " + data["OptimizedSolution"]);
    				
    			makeSolutionTable(id,data);
    		}
    		
    	} else {
    		if (data["varNum"] == 0) {
    			if (abs == -1)
    				jQuery("#gridText-" + id).html("<p>Since there is a solution to your formula and there are no free variables in your formula, your formula is a tautology.</p>");
    			else
    				jQuery("#gridText-" + id).html("<p>Since there is a solution to your formula and there are no free variables in your formula, your formula is a oxymoron.</p>");	
    		}
    		
    		if (data["Solutions"].size() >= 5000) {
    			askUser(
    				"There are " + data["Solutions"].size() + " solutions to be displayed. Do you really want to display them all? (This might take a while and block your browser)" , 
    				function() { makeSolutionTable(id , data); });
    		} else {
    			makeSolutionTable(id , data);
    		}
    	}
		
    }
    
    function makeSolutionTable(id, data) {
    	
    	jQuery("#gridText-" + id).append(makeHTMLTable(id,data));
		
		jQuery('#dataTable' + id).dataTable({
	        "bAutoWidth": true,
			"bFilter": false,
			"sPaginationType": "full_numbers",
			"bJQueryUI": true
		});
    	
		// Currently doesn't work in Firefox!
//    	if (supports_web_workers()) {
//    		var tableWorker = new Worker("/js/tableWorker.js");
//        	tableWorker.addEventListener('message', function(e) {
//        		jQuery("#gridText-" + id).append(e.data);
//        		
//        		jQuery('#dataTable' + id).dataTable({
//        	        "bAutoWidth": false,
//        			"bFilter": false,
//        			"sPaginationType": "full_numbers",
//        			"bJQueryUI": true
//        		});
//        	  }, false);
//
//        	tableWorker.postMessage({'id':id , 'data':data , 'make':makeHTMLTable});
//    	} else {
//    		jQuery("#gridText-" + id).append(makeHTMLTable(id,data));
//    		
//    		jQuery('#dataTable' + id).dataTable({
//    	        "bAutoWidth": false,
//    			"bFilter": false,
//    			"sPaginationType": "full_numbers",
//    			"bJQueryUI": true
//    		});
//    	}
    	
    }
    
    function makeHTMLTable(id , data) {
    	
    	var varNum = 0;
    	jQuery.each(data["Names"], function(i, val) {
			varNum++; 
		});
    	
    	var entryNum = 0;
    	jQuery.each(data["Solutions"][0], function(i, val) {
    		entryNum++;
		});
    	
    	var append = "";
		append = "<table id=\"dataTable" + id + "\" class=\"dataTable\" style=\"width:" + entryNum*100 + "px; align:center; margin:auto;\">";
		append += "<thead>";
		append += "<tr>";
		jQuery.each(data["Names"], function(i, val) {
			append += "<td style=\"width:100px;\">" + val + "</td>"; 
		});
		if (varNum < entryNum)
			append += "<td style=\"width:100px;\">Optimized</td>";
		append += "</tr>";
		append += "</thead>";
		append += "<tbody>";
		jQuery.each(data["Solutions"], function(i, val) {
			append += "<tr>";
			jQuery.each(val, function(j, sol) {
				if (data["Names"][j] === undefined) {
					append += "<td style=\"width:100px;\">" + data["OptimizedSolution"] + "</td>";
			} else {
				append += "<td>" + sol + "</td>";
			}
			});
			append += "</tr>";
		});
		append += "</tbody>";
		append += "</table>";
		
		return append;
    }
    
    function monitorStatus(id) {

        jQuery.getJSON("solver/" , 
				{
                    request: "status",
                    id: id
                  } , 
                  function(data) {
                  
                  if (data["status"] == "Timeout") {
                   	  error("Sorry, your formula ran into a timeout. Please try a smaller formula.");
                      jQuery("#equation" + data["clientId"] + "-text").html("<p>Sorry, your formula ran into a timeout. Please try a smaller formula.</p>");

                   	  return;
                  }
                	  
                  if (data["status"] == "Queue") {
                    jQuery("#equation" + data["clientId"] + "-text").html("We are working on your request. Your Equation is currently on position " + (data["Queue"]+1) + " in line.<br><br> <img src='Images/loader.gif'>");
                    var t=setTimeout("monitorStatus(" + id + ")",3000);
                  } else {
                    if (data["status"] == "Done") {
                      jQuery("#equation" + data["clientId"] + "-text").html("Your Request is done: ");
					  jQuery("#tabs").tabs("select" , data["clientId"]-1);
                      solution[data["clientId"]] = data;
                      buildAccordion(data["clientId"]);
                      paintGraph(data["url"] , data["clientId"]);
                      makeSolution(data["absSol"] , data["solution"] , data["clientId"] , data["type"]);
					  
                    } else {
                     if (data["status"] == "Working") {
                      jQuery("#equation" + data["clientId"] + "-text").html("Your Request is being calculated right now. You better get ready for the solution!<br><br> <img src='Images/loader.gif'>");
                      var t=setTimeout("monitorStatus(" + id + ")",1000);
                    } else {
                      if (data["status"] == "Error") {
                        error(data["desc"]);
                        jQuery("#equation" + data["clientId"] + "-text").html(data["desc"]);
                        
                        if (data["clientId"] != undefined && data["solutionAut"] != undefined && data["url"] != undefined) {
	                        jQuery("#equation" + data["clientId"] + "-text").html("Your Request is done: ");
	  					  	jQuery("#tabs").tabs("select" , data["clientId"]-2);
	                        solution[data["clientId"]] = data;
	                        buildAccordion(data["clientId"]);
	                        paintGraph(data["url"] , data["clientId"]);
	//                        makeSolution(data["absSol"] , data["solution"] , data["clientId"] , data["type"]);
                        }
                      } 
                    }
                  }
                  } 
                      
                  });
    
    }

  function addTab(index , name) {
	  index = index-1;
    jQuery("#tabs").tabs( "add", "#tabs-" + index, name ,index-1);
    jQuery("#tabs-"+index).append(""+
    		"<input type='text' id='tabName" + index +"' value='" + name +"' onKeyUp='propagateName("+ index + ")' class='heading' maxlength=25><br>"+
			"<button class=\"b" + index + "\" name=\"A :\" >&forall;</button>"+
			"<button class=\"b" + index + "\" name=\"E :\" >&exist;</button>"+
			"<button class=\"b" + index + "\" name=\"&&\" >&and;</button>"+
			"<button class=\"b" + index + "\" name=\"||\" >&or;</button>"+
			"<button class=\"b" + index + "\" name=\"->\" >&rArr;</button>"+
			"<button class=\"b" + index + "\" name=\"<\" ><</button>"+
			"<button class=\"b" + index + "\" name=\"<=\" >&le;</button>"+
			"<button class=\"b" + index + "\" name=\">\" >></button>"+
			"<button class=\"b" + index + "\" name=\">=\" >&ge;</button>"+
			"<button class=\"b" + index + "\" name=\"==\">=</button>"+
			"<button class=\"b" + index + "\" name=\"!=\" >&ne;</button>"+
			"<button class=\"b" + index + "\" name=\"(\">(</button>"+
			"<button class=\"b" + index + "\" name=\")\" >)</button>"+
			"<br>"+
			"<select name='macros-" + index + "' id='macros-" + index + "'>"+
			"<option value='' selected='selected'>Macros</option>" + 
			"</select>"+
			"<button class=\"b" + index + "\" name=\"u\" >u</button>"+
			"<button class=\"b" + index + "\" name=\"v\" >v</button>"+
			"<button class=\"b" + index + "\" name=\"w\" >w</button>"+
			"<button class=\"b" + index + "\" name=\"x\" >x</button>"+
			"<button class=\"b" + index + "\" name=\"y\" >y</button>"+
			"<button class=\"b" + index + "\" name=\"z\" >z</button>"+
			"<br><br>"+
		"<textarea type='text' name='equation' value='Insert your equation here!' class='equation' id='equation" + index + "'></textarea><br><br>"+ 
		"<fieldset>"+
		"<input type='radio' name='optimize-" + index + "' value='N' checked> Give me n solutions with n= <input type='text' id='nSol-" + index + "' value='1' class='short'><br>"+
		"<input type='radio' name='optimize-" + index + "' value='All'> Give me all solutions (Warning: There can be a lot and your browser might crash!)<br>"+
		"<input type='radio' name='optimize-" + index + "' value='Min'> Minimize the term <input type='text' id='minTerm-" + index + "' value='' class='middle'><br>"+
		"<input type='radio' name='optimize-" + index + "' value='Max'> Maximize the term <input type='text' id='maxTerm-" + index + "' value='' class='middle'><br>"+
		"</fieldset>"+		
		"<button id='uploader" + index + "' name='" + index + "'>Upload File</button>"+
		"<button id='add_equation" + index + "' name='" +index  + "'>Solve It!</button>"+
		"<button class='help'>Help me</button>"+
		"<p id='equation" + index +"-text'>Welcome to the Solver for Presburger Arithmetics! Just Click '+' to add a equation. </p>");
    
    jQuery("#minTerm-" + index).change(function() {jQuery(":radio[name=optimize-" + index + "][value=Min]").attr("checked" , true)})
    
    jQuery("#minTerm-" + index).click(function() {jQuery(":radio[name=optimize-" + index +"][value=Min]").attr("checked" , true)});
	jQuery("#maxTerm-"+index).click(function() {jQuery(":radio[name=optimize-" + index + "][value=Max]").attr("checked" , true)});
	jQuery("#nSol-"+index).click(function() {jQuery(":radio[name=optimize-" + index + "][value=N]").attr("checked" , true)});
    
    var select = jQuery("#macros-" + index);
    for (var x = 0; x < macros.length; x++) {
		jQuery("#macros-" + index).append("<option value='" + macros[x] +"' id='macros-" + index + "-" + macroIds[x] + "'>" + macros[x] + "</option>");
	}
    
	jQuery('select#macros-' + index).selectmenu({select: function(event, options) {
		var input = options.value;
		if (input != "") {
			jQuery("#equation" + index).val(jQuery("#equation"+index).val() + input);
            jQuery("#equation" + index).selectRange(jQuery("#equation"+index).val().length , jQuery("#equation" + index).val().length);

		}
		},
		style:'popup'});

    
	jQuery( "#uploader" + index )
			.button()
			.click(function() {
                openWindow("upload.html");
              });  
    
	jQuery( ".b" +index)
			.button()
			.click(function() {
                jQuery("#equation" + index).val(jQuery("#equation" + index).val() + this.name);
                jQuery("#equation" + index).selectRange(jQuery("#equation" + index).val().length);
              });
	
	jQuery('#equation' + index).click( function() { if (this.value == "Insert your equation here!") {
			this.value = "";
		} } );
	
    jQuery( "#add_equation"+index )
			.button()
			.click(function() {
				equation = jQuery( "#equation" + this.name ).val();
				if (jQuery("input[name='optimize-" + index +"']:checked").val() == "Min")
					var term = jQuery("#minTerm-"+index).val()
				else
					var term = jQuery("#maxTerm-"+index).val()
					
				jQuery.getJSON("/solver/" , 
				{
                    request: "test",
                    equation: equation,
                    solType: jQuery("input[name='optimize-" + index + "']:checked").val(),
                    numSol: jQuery("#nSol-" + index).val(),
                    term: term,
					clientId: this.name
				}, function(data) {
					if (data["valid"]) {
						jQuery.getJSON("solver/" , 
						{
							request: "new",
							equation: data["equation"],
							solType: data["solType"],
							numSol: data["numSol"],
							term: data["term"],
							clientId: data["clientId"],
						} , 
						function(data) {
							jQuery("#equation" + data["clientId"] + "-text").html("We are working on your request. Your Equation is currently on position " + data["Queue"] + " in line.<br><br> <img src='Images/loader.gif'>");
							setTimeout("monitorStatus(" + data["id"] + ")",100);
						});
					} else {
						jQuery("#equation" +data["clientId"]  +"-text").html("<p>Sorry, but your formula is in a invalid format. The first error occured at position " + data["indexFormula"] + "</p>");
					}
					});
				
				  
			});
    
    //Overlay Help Button
    jQuery(".help").button().click(function(){openHelp();});
  }

	jQuery(function() {
		jQuery( "#tabs" ).tabs({select: function(event,ui){
      		if (ui.index == jQuery( "#tabs" ).tabs("length")-1) {
      		    addTab(jQuery( "#tabs" ).tabs("length") , "E" + (jQuery( "#tabs" ).tabs("length")-1));
      		}
		},
		show: function(event, ui) {
      		if (ui.index === (jQuery("#tabs").tabs("length")-1)) {
          		jQuery("#tabs").tabs({ selected: (jQuery("#tabs").tabs("length")-3) });
          	}
          }
		});
		
		jQuery( "#add_equation1" )
			.button()
			.click(function() {
				equation = jQuery( "#equation" + this.name ).val();
				if (jQuery("input[name='optimize-1']:checked").val() == "Min")
					var term = jQuery("#minTerm-1").val()
				else
					var term = jQuery("#maxTerm-1").val()
					
				jQuery.getJSON("/solver/" , 
				{
                    request: "test",
                    equation: equation,
                    solType: jQuery("input[name='optimize-1']:checked").val(),
                    numSol: jQuery("#nSol-1").val(),
                    term: term,
					clientId: this.name
				}, function(data) {
					if (data["valid"]) {
						jQuery.getJSON("solver/" , 
						{
							request: "new",
							equation: data["equation"],
							solType: data["solType"],
							numSol: data["numSol"],
							term: data["term"],
							clientId: data["clientId"],
						} , 
						function(data) {
							jQuery("#equation" + data["clientId"] + "-text").html("We are working on your request. Your Equation is currently on position " + data["Queue"] + " in line.<br><br> <img src='Images/loader.gif'>");
							setTimeout("monitorStatus(" + data["id"] + ")",100);
						});
					} else {
						jQuery("#equation1-text").html("<p>Sorry, but your formula is in a invalid format. The first error occured at position " + data["indexFormula"] + " </p>");
						jQuery("#equation1").selectRange(data["indexFormula"] , data["indexFormula"]+1);
					}
					});
				
				  
				
			});
			
		jQuery("#minTerm-1").click(function() {jQuery(":radio[name=optimize-1][value=Min]").attr("checked" , true)});
		jQuery("#maxTerm-1").click(function() {jQuery(":radio[name=optimize-1][value=Max]").attr("checked" , true)});
		jQuery("#nSol-1").click(function() {jQuery(":radio[name=optimize-1][value=N]").attr("checked" , true)});
		
		jQuery( "#uploader1" )
			.button()
			.click(function() {
                openWindow("upload.html");
              });          
				 
		jQuery('#equation1').click( function() { if (this.value == "Insert your equation here!") {
			this.value = "";
		} } );
		
		jQuery( "#uploader1" )
			.button()
			.click(function() {
                openWindow("upload.html");
              });

		initMacroButtons();
		
		jQuery( ".b1" )
			.button()
			.click(function() {
				var input = jQuery("#equation1"); 
                input.val(jQuery("#equation1").val() + this.name);
                jQuery("#equation1").selectRange(jQuery("#equation1").val().length , jQuery("#equation1").val().length);
				});
		
		
	});
	
	
	function initMacroButtons() {

		jQuery( "#macroUpload1" )
		.button()
		.click(function() {
			testAndUploadMacro(1);
          });
		
		jQuery( "#addMacro" )
		.button()
		.click(function() {
			addMacroInput();
		});
		
		
		jQuery( "#fileUploadMacros" )
		.button()
		.click(function() {openWindow("uploadMacros.html")});
		
		
		jQuery( "#clearMacros" )
		.button()
		.click(
				function() {askUser("Do you really want to delete all Macros? There will be no way to get them back!" , function(){clearMacros();});}
		);
		
		jQuery( "#exportMacros" )
		.button()
		.click(
				function() {
					var result = "";
					jQuery(".macro").each(function() {
						if (jQuery(this).val() != "")
							result += jQuery(this).val()+"*";
						});
					downloadWindow("/export?file=" + result);
				}
		);
	}
	
	function clearMacros() {

		jQuery.getJSON("solver/" , 
				{
					request: "clearMacros"
				} , 
				function(data) {
					if (data["valid"]) {
						macroCount = 1;
						macros = Array(0);
						macroIds = Array(0);
						
						jQuery('#macro').html("<p>Welcome to the Macro Manager! Here you can add macros that you want to use in your formulae.</p>"+
												"<fieldset id='macroField'>"+
												"<input type='text' name='macro1' id='macro1' value='' class='macro'> " +
												"<button id='macroUpload1'>Save Macro</button><br>"+
												"</fieldset>"+
												"<button id='addMacro'>Add Macro</button>"+
												"<button id='fileUploadMacros'>Upload File</button>"+
												"<button id='clearMacros'>Clear</button>"+
												"<button id='exportMacros'>Export to File</button>");
						
						
						initMacroButtons();
						var limit = jQuery( "#tabs" ).tabs("length")-2;
						for (var x = 1; x <= limit; x++) {
							
							var item = jQuery('#macros-' + x).html("<option value='' selected='selected'>Macros</option>");
							
							jQuery('#macros-' + x).selectmenu({select: function(event, options) {
								var input = options.value;
								var num = options.option.id.substring(7,8);
									if (input != "") {
										jQuery("#equation" + num).val(jQuery("#equation"+num).val() + input);
							            jQuery("#equation"+num).selectRange(jQuery("#equation"+num).val().length , jQuery("#equation"+num).val().length);

									}
								},
								style:'popup'});
						}
					}
				});

	}
	
	jQuery(function(){
		jQuery('select#macros-1').selectmenu({select: function(event, options) {
				var input = options.value;
				if (input != "") {
					jQuery("#equation1").val(jQuery("#equation1").val() + input);
		            jQuery("#equation1").selectRange(jQuery("#equation1").val().length , jQuery("#equation1").val().length);
				}
				},
				style:'popup'});
	});
	
	function testAndUploadMacro(index) {
		
		var macro = jQuery("input[name=macro"+index+"]").val();
		var id = jQuery("input[name=macro"+index+"]").attr("id");
		
		jQuery.getJSON("/solver/" , 
				{
                    request: "testMacro",
                    id : id,
                    macro: macro,
                    clientId: index
				}, function(data) {
					if (data["error"] != undefined) {
						error(data["error"]);
					} else {
						if (!data["exists"])
							uploadMacro(data["index"]);
						else {
							//Ask the user if he really wants to override
							askUser("The Macro " + data["name"] + " already exists. Do you want to override the old macro?",function(){uploadMacro(data["index"]);});
						}
					}
				});
		
	}
	
	function uploadMacro(index) {
		var macro = jQuery("input[name=macro"+index+"]").val();
		var id = jQuery("input[name=macro"+index+"]").attr("id");
		
		
		//Let's add the Macro, no matter what..
		jQuery.getJSON("/solver/" , 
				{
                    request: "addMacro",
                    id : id,
                    macro: macro,
                    clientId: index
				}, function(data) {
					
					if (data["valid"]) {

						if (data["delete"] != "" && data["delete"] != undefined) {
							jQuery("#macroId"+data["delete"]).fadeOut(1000,function() {jQuery("#macroId"+data["delete"]).remove()});
							jQuery("button[name=macroId"+data["delete"]+"]").fadeOut(1000,function() {jQuery("button[name=macroId"+data["delete"]+"]").remove()});
							var limit = jQuery( "#tabs" ).tabs("length")-2;
							
							for (var x = 1; x <= limit; x++) {
								
								var item = jQuery('#macros-' + x);
								jQuery("#macros-" + x +"-" + data["delete"]).remove();
								item.selectmenu({select: function(event, options) {
									var input = options.value;
									var num = options.option.id.substring(7,8);
										if (input != "") {
											jQuery("#equation" + num).val(jQuery("#equation"+num).val() + input);
										}
									},
									style:'popup'});
								
							}
						}
						
						if (data["listDelete"] != "" && data["listDelete"] != undefined) {
							var limit = jQuery( "#tabs" ).tabs("length")-2;
							for (var x = 1; x <= limit; x++) {
								
								var item = jQuery('#macros-' + x);
								jQuery("#macros-" + x +"-" + data["listDelete"]).remove();
								item.selectmenu({select: function(event, options) {
									var input = options.value;
									var num = options.option.id.substring(7,8);
										if (input != "") {
											jQuery("#equation" + num).val(jQuery("#equation"+num).val() + input);
										}
									},
									style:'popup'});
								
							}
						}

						
						jQuery("input[name=macro" + data["clientId"]+"]").css("background" , "#90EE90");
						jQuery("input[name=macro" + data["clientId"]+"]").attr("id" , "macroId" + data["macroId"]);
						jQuery("#macroUpload" + data["clientId"]).attr("name" , "macroId" + data["macroId"]);

						
						var parts = data["macro"].split(":=");
						macros[macros.length] = parts[0];
						macroIds[macroIds.length] = data["macroId"];
						
						var limit = jQuery( "#tabs" ).tabs("length")-2;
						
						for (var x = 1; x <= limit; x++) {
							var item = jQuery('#macros-' + x);
							item.append("<option value='" + parts[0] +"' id='macros-" + x +"-" + data["macroId"] + "'>" + parts[0] + "</option>");
							
							item.selectmenu({select: function(event, options) {
								var input = options.value;
								var num = options.option.id.substring(7,8);
									if (input != "") {
										jQuery("#equation" + num).val(jQuery("#equation"+num).val() + input);
									}
								},
								style:'popup'});
						}
						

					} else {
						jQuery("input[name=macro" + data["clientId"]+"]").css("background" , "#FFC3CE");
						error(data["error"]);
					}
					});

	}
	
	var addMacroInput = function () {
		macroCount++;
		var m = macroCount;
		jQuery("#macroField").append("<input type='text' name='macro" + macroCount + "' id='macro" + macroCount + "' value='' class='macro'> <button id='macroUpload" + macroCount + "'>Save Macro</button><br>");
		jQuery( "#macroUpload"+macroCount )
		.button()
		.click(function() {
			testAndUploadMacro(m);
          });
	}
	
jQuery.getJSON("/solver/" , 
		{
            request: "getMacros"
		}, function(data) {
			if (data["valid"]) {
				jQuery.each(data["macros"], function(i, val) {
					jQuery("#macro" + macroCount)
						.val(val['macro'])
						.attr("id" , "macroId"+val['id'])
						.css("background" , "#90EE90");
					jQuery("#macroUpload" + macroCount).attr("name" , "macroId"+val['id']);
					
					var parts = val['macro'].split(":=");
					
					macros[macros.length] = parts[0];
					macroIds[macroIds.length] = val["id"];
						
					jQuery("#macros-1").append("<option value='" + parts[0] +"' id='macros-1-" + val["id"] + "'>" + parts[0] + "</option>");
					
					jQuery('select#macros-1').selectmenu({select: function(event, options) {
						var input = options.value;
						if (input != "") {
							jQuery("#equation1").val(jQuery("#equation1").val() + input);
				            jQuery("#equation1").selectRange(jQuery("#equation1").val().length, jQuery("#equation1").val().length);
						}
						},
						style:'popup'});
					
					addMacroInput();
				});
			}
		}
);


var addTabExt = function(equ,name) {
	var index = jQuery( "#tabs" ).tabs("length");
	addTab(index , name);
	jQuery("#equation"+(index-1)).val(equ);
}

function addMacroExt(equ) {
	if (jQuery(".macro:last").val() != "")
		addMacroInput();
	jQuery(".macro:last").val(equ);
	addMacroInput();
}

var openWindow = function (url) {
   fenster = window.open(url, "fenster1", "width=400,height=50,status=yes,scrollbars=yes,resizable=yes");
   fenster.focus();
}

var downloadWindow = function (url) {
	   fenster = window.open(url, "Download");
	   fenster.focus();
}

function propagateName(index) {
	var name = jQuery("#tabName"+index).val();
	jQuery("a[href=#tabs-"+index+"]").text(name);
}


//NOT RELATED TO AUTOMATA STUFF
jQuery( function(){

	jQuery( "#error-message" ).dialog({
		autoOpen: false,
		modal: true,
		buttons: {
			Ok: function() {
				jQuery( this ).dialog( "close" );
			}
		}
	});

	jQuery( "#dialog-message" ).dialog({
		autoOpen: false,
		modal: true,
		buttons: {
			Ok: function() {
				jQuery(this).dialog("close");
			},
			Cancel: function() {
				jQuery(this).dialog("close");
			}
		}
	});
	
});


function error(desc) {
	jQuery("#error-message-paragraph").html(desc);
    jQuery("#error-message").dialog("open");
}

function askUser(desc,callback) {
	jQuery("#dialog-message-paragraph").html(desc);
    
    jQuery( "#dialog-message" ).dialog({
    	autoOpen: false,
    	modal: true,
    	buttons: {
    		Ok: function() {
    			callback();
    			jQuery(this).dialog("close");
    		},
    		Cancel: function() {
    			jQuery(this).dialog("close");
    		}
    	}
    });
    
    jQuery( "#dialog-message" ).dialog("open");
}

function json_encode (mixed_val) {
    // Returns the JSON representation of a value  
    // 
    // version: 1103.1210
    // discuss at: http://phpjs.org/functions/json_encode
    // +      original by: Public Domain (http://www.json.org/json2.js)
    // + reimplemented by: Kevin van Zonneveld (http://kevin.vanzonneveld.net)
    // +      improved by: Michael White
    // +      input by: felix
    // +      bugfixed by: Brett Zamir (http://brett-zamir.me)
    // *        example 1: json_encode(['e', {pluribus: 'unum'}]);
    // *        returns 1: '[\n    "e",\n    {\n    "pluribus": "unum"\n}\n]'
/*
        http://www.JSON.org/json2.js
        2008-11-19
        Public Domain.
        NO WARRANTY EXPRESSED OR IMPLIED. USE AT YOUR OWN RISK.
        See http://www.JSON.org/js.html
    */
    var retVal, json = this.window.JSON;
    try {
        if (typeof json === 'object' && typeof json.stringify === 'function') {
            retVal = json.stringify(mixed_val); // Errors will not be caught here if our own equivalent to resource
            //  (an instance of PHPJS_Resource) is used
            if (retVal === undefined) {
                throw new SyntaxError('json_encode');
            }
            return retVal;
        }
 
        var value = mixed_val;
 
        var quote = function (string) {
            var escapable = /[\\\"\u0000-\u001f\u007f-\u009f\u00ad\u0600-\u0604\u070f\u17b4\u17b5\u200c-\u200f\u2028-\u202f\u2060-\u206f\ufeff\ufff0-\uffff]/g;
            var meta = { // table of character substitutions
                '\b': '\\b',
                '\t': '\\t',
                '\n': '\\n',
                '\f': '\\f',
                '\r': '\\r',
                '"': '\\"',
                '\\': '\\\\'
            };
 
            escapable.lastIndex = 0;
            return escapable.test(string) ? '"' + string.replace(escapable, function (a) {
                var c = meta[a];
                return typeof c === 'string' ? c : '\\u' + ('0000' + a.charCodeAt(0).toString(16)).slice(-4);
            }) + '"' : '"' + string + '"';
        };
 
        var str = function (key, holder) {
            var gap = '';
            var indent = '    ';
            var i = 0; // The loop counter.
            var k = ''; // The member key.
            var v = ''; // The member value.
            var length = 0;
            var mind = gap;
            var partial = [];
            var value = holder[key];
 
            // If the value has a toJSON method, call it to obtain a replacement value.
            if (value && typeof value === 'object' && typeof value.toJSON === 'function') {
                value = value.toJSON(key);
            }
 
            // What happens next depends on the value's type.
            switch (typeof value) {
            case 'string':
                return quote(value);
 
            case 'number':
                // JSON numbers must be finite. Encode non-finite numbers as null.
                return isFinite(value) ? String(value) : 'null';
 
            case 'boolean':
            case 'null':
                // If the value is a boolean or null, convert it to a string. Note:
                // typeof null does not produce 'null'. The case is included here in
                // the remote chance that this gets fixed someday.
                return String(value);
 
            case 'object':
                // If the type is 'object', we might be dealing with an object or an array or
                // null.
                // Due to a specification blunder in ECMAScript, typeof null is 'object',
                // so watch out for that case.
                if (!value) {
                    return 'null';
                }
                if ((this.PHPJS_Resource && value instanceof this.PHPJS_Resource) || (window.PHPJS_Resource && value instanceof window.PHPJS_Resource)) {
                    throw new SyntaxError('json_encode');
                }
 
                // Make an array to hold the partial results of stringifying this object value.
                gap += indent;
                partial = [];
 
                // Is the value an array?
                if (Object.prototype.toString.apply(value) === '[object Array]') {
                    // The value is an array. Stringify every element. Use null as a placeholder
                    // for non-JSON values.
                    length = value.length;
                    for (i = 0; i < length; i += 1) {
                        partial[i] = str(i, value) || 'null';
                    }
 
                    // Join all of the elements together, separated with commas, and wrap them in
                    // brackets.
                    v = partial.length === 0 ? '[]' : gap ? '[\n' + gap + partial.join(',\n' + gap) + '\n' + mind + ']' : '[' + partial.join(',') + ']';
                    gap = mind;
                    return v;
                }
 
                // Iterate through all of the keys in the object.
                for (k in value) {
                    if (Object.hasOwnProperty.call(value, k)) {
                        v = str(k, value);
                        if (v) {
                            partial.push(quote(k) + (gap ? ': ' : ':') + v);
                        }
                    }
                }
 
                // Join all of the member texts together, separated with commas,
                // and wrap them in braces.
                v = partial.length === 0 ? '{}' : gap ? '{\n' + gap + partial.join(',\n' + gap) + '\n' + mind + '}' : '{' + partial.join(',') + '}';
                gap = mind;
                return v;
            case 'undefined':
                // Fall-through
            case 'function':
                // Fall-through
            default:
                throw new SyntaxError('json_encode');
            }
        };
 
        // Make a fake root object containing our value under the key of ''.
        // Return the result of stringifying the value.
        return str('', {
            '': value
        });
 
    } catch (err) { // Todo: ensure error handling above throws a SyntaxError in all cases where it could
        // (i.e., when the JSON global is not available and there is an error)
        if (!(err instanceof SyntaxError)) {
            throw new Error('Unexpected error type in json_encode()');
        }
        this.php_js = this.php_js || {};
        this.php_js.last_error_json = 4; // usable by json_last_error()
        return null;
    }
}

///////// INFO OVERLAY

function openHelp() {
	jQuery("#shadow-overlay").css("display" , "block");
	jQuery("#info-overlay").css("display" , "block");
}

function closeHelp() {
	jQuery("#shadow-overlay").css("display" , "none");
	jQuery("#info-overlay").css("display" , "none");
}

jQuery(function() {
	jQuery("#info-overlay-close").click(function() {
		closeHelp();
	});
	
	jQuery(".help").button().click(function(){openHelp();});
});


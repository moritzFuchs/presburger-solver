
Object.prototype.foreach = function( callback ) {
  for( var k in this ) {
    if(this.hasOwnProperty(k)) {
     callback( k, this[ k ] );
    }
  }
}

self.addEventListener('message', function(e) {
  var data = e.data;
  var append = makeHTMLTable(data.id , data.data);
  
  self.postMessage(append);
}, false);

function makeHTMLTable(id , data) {
	var append = "";
	append = "<table id=\"dataTable" + id + "\" class=\"dataTable\">";
	append += "<thead>";
	append += "<tr>";
	data["Names"].foreach(function(i, val) {
		append += "<td>" + val + "</td>"; 
	});
	append += "</tr>";
	append += "</thead>";
	append += "<tbody>";
	data["Solutions"].foreach( function(i, val) {
		append += "<tr>";
		val.foreach( function(j, sol) {
			if (data["Names"][j] === undefined) {
				append += "<td>" + data["OptimizedSolution"] + "</td>";
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
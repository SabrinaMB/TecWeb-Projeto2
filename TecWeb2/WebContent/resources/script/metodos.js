window.onload = function() {
	
	var http = new XMLHttpRequest();

	http.onreadystatechange = function(){
		console.log(http);
	};

	http.open("GET", "notas.json", true);
	http.send();
	console.log("test");

};
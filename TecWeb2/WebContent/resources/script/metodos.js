window.onload = function() {
	
	var http = new XMLHttpRequest();


	router.route('/nota/:id?')
	  .get(nota.get)
	  .post(nota.post)
	  .put(nota.put)
	  .delete(nota.delete);
	

	
	http.onreadystatechange = function(){
		console.log(http);
		console.log("test");
		
	};
	
	http.open("GET", "http://localhost:8080/TecWeb2/nota/:id?", true);
	http.send();
	
};
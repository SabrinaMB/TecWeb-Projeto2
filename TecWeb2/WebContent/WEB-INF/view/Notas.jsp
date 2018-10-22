<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="mvc.*,java.util.*,java.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<title>📈 My title</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>
<!-- API do google font -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Karma">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Tangerine">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Mali">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Rubik">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Pacifico">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Quicksand">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Inconsolata">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Cabin">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=VT323">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Nunito">
<!-- Final dos imports da API -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-rc.2/css/materialize.min.css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-rc.2/js/materialize.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-rc.2/js/materialize.min.js"></script>
<script src="https://code.jquery.com/jquery-1.12.3.min.js"></script>
<script type="text/javascript"
	src="<c:url value="resources/script/metodos.js"/>"></script>
<link rel="stylesheet" href="resources/style/style.css">
<style>
body {
	font-family: 'Nunito', serif;
	font-size: 48px;
}
</style>
<body class="orange lighten-5">
	<jsp:useBean id="dao" class="mvc.model.DAO" />

	<!-- Barra de Navegacao -->
	<nav>
		<div class="nav-wrapper orange">
			<a href="#">&nbsp;<img
				src="<c:url value="resources/img/logoNoteNome.png"/>" class="logo"></a>

		</div>
	</nav>

	<!-- !PAGE CONTENT! -->
	<div class="w3-main w3-content w3-padding class3">

		<!-- First Notes Grid-->
		<div class="w3-row-padding w3-padding-16">
			<div class="row">
				<div class="col s12 ">
					<div class="card darken-1">
						<div class="card-content hoverable">
							<form action="adicionarNota" method="get">
								<div class="input-field col s12">
									<input id="id" name="id" type="number" style="display: none">
									<input id="titulo" name="titulo" type="text"> <label
										for="titulo">Título</label>
								</div>
								<div class="input-field col s12">
									<textarea id="nota" name="nota" class="materialize-textarea"></textarea>
									<label for="nota">Nota</label>
								</div>
								<div class="input-field col s12">
									<textarea id="font" name="font" class="materialize-textarea"></textarea>
									<label for="font">Fonte</label>
								</div>
								<input type="color" value="${cor.cor}" name="cor" id="cor">
								<button
									class="btn waves-effect waves-light orange darken-3
            "
									type="submit">Submit</button>
							</form>
						</div>
					</div>
				</div>
			</div>
			<div>
				<div id="map"
					style="width: 500px; height: 300px; background: yellow"></div>
				<script>
					function myMap() {
						var myLatLng = {
							lat : -23.598476,
							lng : -46.676665
						};
						var mapOptions = {
							center : myLatLng,
							zoom : 17,
						}
						var map = new google.maps.Map(document
								.getElementById('map'), mapOptions);
						var marker = new google.maps.Marker({
							position : myLatLng,
							map : map,
							title : 'Hello World'
						});
					}
				</script>
				<script async defer
					src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCpRHia2xSZ-fspxwcHA5AwMbXUXZMveJc&callback=myMap"></script>

			</div>


			<c:forEach var="nota" items="${dao.lista}" varStatus="id">
				<div class="row">
					<div class="col s12 ">
						<div
							style='background-color:${dao.getCor1(nota.id)}; font-family:${dao.getFont1(nota.id)};'
							class="card hoverable">
							<div class="card-content corcard">
								<span class="card-title">${nota.titulo}</span>
								<p>${nota.nota}</p>

								<div class="card-action wrap">
									<form action="editarCor">
										<input id="nota_id" name="nota_id" type="number"
											value="${nota.id}" style="display: none"> <input
											type="color" value="${cor.cor}" name="cor" id="cor">
										<button class="btn waves-effect waves-light orange darken-3"
											type="submit">Submit Color</button>
									</form>
									<form action="deletarNota" method="post">
										<input id="id" name="id" type="number" value="${nota.id}"
											style="display: none">
										<button
											class="btn waves-effect waves-light material-icons orange align"
											type="submit">delete</button>
									</form>
									<form action="editarNota" >
										<input id="id" name="id" type="number" value="${nota.id}"
											style="display: none"> <input id="titulo"
											name="titulo" type="text" value="${nota.titulo}"
											style="display: none"> <input id="nota" name="nota"
											type="text" value="${nota.nota}" style="display: none">
										<input id="cor" name="cor" type="text"
											value="${dao.getCor1(nota.id)}" style="display: none">
										<button
											class="btn waves-effect waves-light material-icons orange darken-3 align"
											type="submit">edit</button>
									</form>
									<form action='alteraFont'>
											<input id="nota_id" name="nota_id" type="number"
											value="${nota.id}" style="display: none">
												<select style="display: inline !important; font-size:20px;" name="font" id="font">
													<option data-value="Karma">Karma</option>
													<option data-value="Tangerine">Tangerine</option>
													<option data-value="Mali">Mali</option>
													<option data-value="Rubik">Rubik</option>
													<option data-value="Pacific">Pacific</option>
													<option data-value="Quicksand">Quicksand</option>
													<option data-value="Inconsolata">Inconsolata</option>
													<option data-value="Cabin">Cabin</option>
													<option data-value="VT323">VT323</option>
													<option data-value="Nunito">Nunito</option>
												</select><button class="btn waves-effect waves-light orange darken-3"
											type="submit">Submit Font</button>
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>


</body>
</html>
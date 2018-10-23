<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="mvc.*,java.util.*,java.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<title>📈Infinity Note</title>
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
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
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
									<select style="display: inline !important; font-size: 20px;"
										name="font" id="font">
										<option data-value="">Escolha uma fonte</option>
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
									</select>
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

				<div class="row">
					<div class="col s12 ">
						<div class="card hoverable">
							<div class="card-content corcard">
								<div class="card-action wrap">
									<span class="card-title" id="category">Categoria errada
										trivia não encontrada</span>
									<p id="question"
										style="display: inline !important; font-size: 15px;">Pergunta
										não encontrada</p>
									<form id="botoes">

										<label> <input name="group1" id="1"
											class="radioBtnClass" type="radio" /> <span id="resp1"></span>
										</label>

										<p>
											<label> <input name="group1" id="2"
												class="radioBtnClass" type="radio" /> <span id="resp2"></span>
											</label>
										</p>
										<p>
											<label> <input name="group1" id="3"
												class="radioBtnClass" type="radio" /> <span id="resp3"></span>
											</label>
										</p>
										<p>
											<label> <input name="group1" id="4"
												class="radioBtnClass" type="radio" /> <span id="resp4"></span>
											</label>
										</p>
										<p id="myDIV" style="display: none">resposta</p>

										<button onclick="myFunction()"
											class="btn waves-effect waves-light orange darken-3"
											type="button">answer</button>

									</form>
									<form action="entrarNota">
										<input class="btn waves-effect waves-light orange darken-3"
											type="submit" value="New Question">
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>

		</div>

		<script>
			var correct;
			$(document).ready(function() {
				$.ajax({
					
					type : "GET",
					url : 'https://opentdb.com/api.php?amount=1&type=multiple',
					contentType : 'application/x-www-form-urlencoded',
					success : function(data, status, xhr) {
						correct = data.results[0].correct_answer;
						console.log(data);
						trivia(data);
					},
					error : function(xhr, status, error) {
						alert("error");
					}
				});
			});

			function trivia(data) {
				var category = data.results[0].category;
				var question = data.results[0].question;
				var correct_answer = data.results[0].correct_answer;
				var incorrect_answers = data.results[0].incorrect_answers;
				var answers = incorrect_answers;
				answers.push(correct_answer);
				console.log(answers);
				var currentIndex = answers.length, temporaryValue, randomIndex;
				// While there remain elements to shuffle...
				while (0 !== currentIndex) {

					// Pick a remaining element...
					randomIndex = Math.floor(Math.random() * currentIndex);
					currentIndex -= 1;

					// And swap it with the current element.
					temporaryValue = answers[currentIndex];
					answers[currentIndex] = answers[randomIndex];
					answers[randomIndex] = temporaryValue;
				}

				console.log(answers);

				$("#category").text(category);
				$("#question").text(question);
				$("#resp1").text(answers[0]);
				$("#resp2").text(answers[1]);
				$("#resp3").text(answers[2]);
				$("#resp4").text(answers[3]);
				$("#myDIV").text(correct_answer);
				$("#1").attr("value", answers[0])
				$("#2").attr("value", answers[1])
				$("#3").attr("value", answers[2])
				$("#4").attr("value", answers[3])
				console.log(question);
				console.log(answers);

			}
			function myFunction() {
				var answer = document.querySelector('input[name = "group1"]:checked').value;
				if (answer == correct){
					alert("correto!!!")
				}else{
					alert("errado, o correto seria: " + correct)
				}
				
			}
		</script>

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
								<form action="editarNota">
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
										value="${nota.id}" style="display: none"> <select
										style="display: inline !important; font-size: 20px;"
										name="font" id="font">
										<option data-value="">Escolha uma fonte</option>
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
									</select>
									<button class="btn waves-effect waves-light orange darken-3"
										type="submit">Submit Font</button>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>


</body>
</html>
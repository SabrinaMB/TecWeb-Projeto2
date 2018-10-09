<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="br.edu.insper.*,java.util.*,java.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nome da Página</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Karma">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-rc.2/css/materialize.min.css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-rc.2/js/materialize.min.js"></script>

<link rel="stylesheet" href="style.css">

            

</head>
<body class="yellow lighten-5">
<jsp:useBean id="dao" class="br.edu.insper.DAO"/>

<!-- Barra de Navegacao -->
<nav>
  <div class="nav-wrapper orange">
    <a href="#" >&nbsp;<img src="logoNoteNome.png" class="logo"></a>

  </div>
</nav>
<%String cor = request.getParameter("cor");%>
<div class="w3-main w3-content w3-padding class3">
  <!-- First Notes Grid-->
  <div class="w3-row-padding w3-padding-16">
    <div class="row">
     <div class="col s12">
       <div class="card darken-1" style = "background-color:<%=cor%>">
        <div class="card-content blue-text">
          <form action="editarNota" method="post">
            <div class="input-field col s12">
            	<%String titulo = request.getParameter("titulo");%>
            	<%String nota = request.getParameter("nota");%>
            	<%String id = request.getParameter("id");%>
            	
            	<input id="id" name="id" type="number" style="display:none" value="<%=id%>" >
              	<input id="titulo" name="titulo" type="text" value="<%=titulo%>">
              	<label for="titulo">Título</label>
            </div>
            <div class="input-field col s12">
              <textarea id="nota" name="nota" class="materialize-textarea"><%=nota%></textarea>
              <label for="nota">Nota</label>
            </div>
            <input type="color" value="<%=cor%>" name="cor" id = "cor">
            <button class="btn waves-effect waves-light indigo darken-3" type="submit">Submit</button>
          </form>
        </div>
       </div>
     </div>
    </div>
   </div>
  </div>
</body>
</html>
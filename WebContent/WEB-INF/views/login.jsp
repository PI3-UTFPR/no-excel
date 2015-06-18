<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="img/no-excel.png">

    <title>NoExcel</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    
    <link href="css/material-fullpalette.min.css" rel="stylesheet">
		
    <link href="css/roboto.min.css" rel="stylesheet">
	
	<link href="css/ripples.min.css" rel="stylesheet">
	
    <link href="css/material.min.css" rel="stylesheet">
    
    <!-- Custom styles for this template -->
    <link href="css/signin.css" rel="stylesheet">
    
    <link href="css/style.css" rel="stylesheet">

  </head>

  <body class=" hasGoogleVoiceExt">
<div class="container">   
	 <c:if test="${error == true}">
	    <div class="alert alert-dismissable alert-danger">
	    <button type="button" class="close" data-dismiss="alert">×</button>
	    <strong>Usuário/senha incorretos.</strong>
</div>
    </c:if>
	<div class="col-xs-12 col-sm-8 col-sm-offset-2 col-md-6 col-md-offset-3">
      <h2 class="form-signin-heading text-center">Login no Sistema NoExcel</h2>
      <div class="card-s card-signin">
        <img class="img-circle profile-img" src="img/no-excel.png" alt="Noexcel">
        <form class="form-signin" action="<%= request.getContextPath() %>/login" method="POST">
          <div class="form-control-wrapper">
          <div class="form-group">
    		<input class="form-control" id="username" placeholder="Usuário" type="text" value="${username ? '' : username}" name="username">
		</div>
	
		<div class="form-group">
    		<input class="form-control" id="password" placeholder="Senha"  type="password" name="password">
		</div>
          <div class="form-group">
          <button class="btn btn-lg btn-primary btn-block" type="submit">Entrar</button>
		</div>
		
          <div class="togglebutton">
            <label>
              <input type="checkbox" name="remind"> Continuar logado
            </label>
          </div>
		</div>
        </form>
      </div>
	</div>
    </div> <!-- /container -->
    <script src="js/jquery-1.11.2.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/ripples.min.js"></script>
    <script src="js/material.min.js"></script>
    <script src="js/app.js"></script>
</body>
</html>
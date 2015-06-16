<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html lang="en">
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="img/no-excel.png">

    <title>NoExcel - Login usuario</title>

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
	<div>
	     <h2 class="form-signin-heading text-center">Login do usuário - NoExcel</h2>
	     <div class="card-s card-signin">
	       <img class="img-circle profile-img" src="img/no-excel.png" alt="">
	       <form class="form-signin" action="CustomerArea" method="POST">
	         <div class="form-control-wrapper">
	         <div class="form-group">
	   		<input class="form-control" id="userInput" placeholder="RA" type="text" name="ra">
		</div>
		
		<div class="form-group">
	   		<input class="form-control" id="pswdInput" placeholder="Senha"  type="password" name="password">
		</div>
	         <div class="form-group">
	         <button class="btn btn-lg btn-primary btn-block" type="submit">Entrar</button>
		</div>
		</div>
	       </form>
	     </div>
	</div>
</div>

<jsp:include page="../includes/footer.jsp"/>
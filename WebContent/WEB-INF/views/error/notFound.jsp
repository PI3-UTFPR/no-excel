<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!--
Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE HTML>
<html>
	<head>
		<title>Página não encontrada - NOExcel</title>
		<meta charset="utf-8" />
		<link href="<%= request.getContextPath() %>/css/not-found.css" rel="stylesheet" type="text/css"  media="all" />
	</head>
	<body>
		<!--start-wrap--->
		<div class="wrap">
			<!--start-content------>
			<div class="content">
				<img src="<%= request.getContextPath() %>/img/not-found/error-img.png" title="error" />
				<p><span><label>O</label>hh.....</span>A página requisitada não existe.</p>
				<a href="#" onclick="window.history.back();return false;">Voltar para a página.</a>
   			</div>
			<!--End-Cotent------>
		</div>
		<!--End-wrap--->
	</body>
</html>

    
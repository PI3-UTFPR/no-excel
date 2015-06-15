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
			<!---start-header---->
<%-- 				<div class="header">
					<div class="logo">
						<h1><a href="<%= request.getContextPath() %>"> Ohh cadê a página!!!</a></h1>
					</div>
				</div> --%>
			<!---End-header---->
			<!--start-content------>
			<div class="content">
				<img src="<%= request.getContextPath() %>/img/not-found/error-img.png" title="error" />
				<p><span><label>O</label>hh.....</span>A página requisitada não existe.</p>
				<a href="<%= request.getContextPath() %>">Voltar para a página inicial</a>
   			</div>
			<!--End-Cotent------>
		</div>
		<!--End-wrap--->
	</body>
</html>

    
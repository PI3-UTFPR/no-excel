<jsp:include page="../includes/header.jsp"/>
<jsp:include page="../includes/nav_admin.jsp"/>

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

<jsp:include page="../includes/footer.jsp"/>
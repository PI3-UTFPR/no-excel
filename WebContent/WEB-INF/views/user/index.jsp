<jsp:include page="../includes/header.jsp"/>

<jsp:include page="../includes/nav_user.jsp"/>

<form method="get" action="transaction">
<div class="container">
	<div class="panel panel-primary">
    <div class="panel-heading">
        <h3 class="panel-title">Busca de Aluno</h3>
    </div>
    <div class="panel-body">
        <div class="form-group">
    <label class="control-label" for="ra">RA do Aluno</label>
    <input type="text" class="form-control" id="ra">
    <button type="submit" class="btn btn-primary search">Buscar</button>
</div>
    </div>
</div>
</div>
</form>
<jsp:include page="../includes/footer.jsp"/>

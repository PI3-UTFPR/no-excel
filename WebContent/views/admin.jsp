<jsp:include page="header.jsp"/>

<jsp:include page="nav_admin.jsp"/>
<form method="get">
<div class="container">
	<div class="panel panel-primary">
    <div class="panel-heading">
        <h3 class="panel-title">Busca de Aluno</h3>
    </div>
    <div class="panel-body">
        <div class="form-group">
    <label class="control-label" for="raInput">RA do Aluno</label>
    <input type="text" class="form-control" id="raInput">
    <button type="submit" class="btn btn-primary search">Buscar</button>
</div>
    </div>
</div>
</div>
</form>
<jsp:include page="footer.jsp"/>
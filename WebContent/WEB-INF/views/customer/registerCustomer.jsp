<jsp:include page="/WEB-INF/views/includes/header.jsp"></jsp:include>
<jsp:include page="/WEB-INF/views/includes/nav_admin.jsp"></jsp:include>

<div class="container">

<%
String flashMessage = (request.getAttribute("flash-message") != null) ? request.getAttribute("flash-message").toString() : "";
%>
<% if(flashMessage.length() != 0){ %>
	<div class="alert alert-dismissable alert-<%= request.getAttribute("flash-type") %>">
	    <button type="button" class="close" data-dismiss="alert">×</button>
	    <strong>OK!</strong> <%= request.getAttribute("flash-message") %>.
	</div>
<%} %>

    <div class="panel panel-primary">
        <div class="panel-heading">
            <h3 class="panel-title">Registro</h3>
        </div>
        <div class="panel-body">
            <form action="cliente" method="post" class="form-customer">
                <div class="form-group ra">
                    <label class="control-label" for="disabledInput">RA</label>
                    <input class="form-control" name="ra" type="text" placeholder="Ra" required>
                </div>
                <div class="form-group name">
                    <label class="control-label" for="disabledInput">Nome</label>
                    <input class="form-control" name="name" type="text" placeholder="Nome" required>
                </div>
                <div class="form-group type-person">	
                    <label for="select" class="form-group control-label">Tipo de Pessoa</label>
                    <div class="form-group">
                        <select class="form-control" name="type" required>
                            <option value="Aluno">Aluno</option>
                            <option value="Professor">Professor</option>
                            <option value="Servidor">Técnico</option>
                        </select>	
                    </div>
                </div>
                <div class="form-group" name="showColleger" id="showColleger">
                    <label class="form-group">Bolsista</label>
                    <div class="form-group">
                        <div class="radio radio-primary">
                            <label>
                                <input type="radio" name="colleger" id="yes" value="yes" checked="">
                                Sim	
                            </label>
                        </div>
                        <div class="radio radio-primary">
                            <label>
                                <input type="radio" name="colleger" id="no" value="no">
                                Não
                            </label>
                        </div>
                    </div>
                </div>
                <div class="form-group value">
                    <label class="control-label">Valor</label>
                    <div class="input-group">
                        <span class="input-group-addon">R$</span>
                        <input type="text" name="value" data-thousands="." data-decimal="," class="form-control">
                    </div>
                </div>
                <div class="input-group-btn submit">
                	<button class="btn btn-primary" type="submit">Finalizar</button>
                </div>
            </form>
        </div>
    </div>
</div>

<jsp:include page="/WEB-INF/views/includes/footer.jsp"></jsp:include>
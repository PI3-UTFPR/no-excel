<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/views/includes/header.jsp"></jsp:include>
<jsp:include page="/WEB-INF/views/includes/nav_admin.jsp"></jsp:include>

<div class="container">

	<c:forEach var="entry" items="${flashMessage}">
		<div class="alert alert-dismissable alert-${flashType}">
			<button type="button" class="close" data-dismiss="alert">×</button>
	    		<strong>${entry.key}</strong> ${entry.value}.
		</div>
	</c:forEach>

    <div class="panel panel-primary">
        <div class="panel-heading">
            <h3 class="panel-title">Editar cliente</h3>
        </div>
        <div class="panel-body">
            <form action="<%= request.getContextPath() %>/manager/edit-customer" method="post" class="form-customer">
                <div class="form-group ra">
                    <input class="form-control" name="login" type="text" value="${login}">
                </div>
                <div class="form-group name">
                    <input class="form-control" name="name" type="text" value="${name}">
                </div>
                <div class="form-group name">
                    <input class="form-control" name="password" type="password" placeholder="Insira uma nova senha">
                </div>
                <div class="form-group type-person">	
                    <div class="form-group">
                        <select class="form-control" name="type" required>
                            <option value="">Tipo de Cliente</option>
                            <option value="Aluno" <%= (request.getAttribute("type").equals("Aluno")) ? "selected" : "" %> >Aluno</option>
                            <option value="Professor" <%= (request.getAttribute("type").equals("Professor")) ? "selected" : "" %>  >Professor</option>
                            <option value="Servidor" <%= (request.getAttribute("type").equals("Servidor")) ? "selected" : "" %>  >Técnico</option>                         
                        </select>	
                    </div>
                </div>
                <div class="form-group" name="showColleger" style="<%= !(request.getAttribute("type").equals("Aluno")) ? "display:none" : "" %>" >
                    <label class="form-group">Bolsista</label>
                    <div class="form-group">
                        <div class="radio radio-primary">
                            <label>
                                <input type="radio" name="colleger" value="yes" <%= (request.getAttribute("colleger").equals("yes")) ? "checked" : "" %> >Sim	
                            </label>
                        </div>
                        <div class="radio radio-primary">
                            <label>
                                <input type="radio" name="colleger" value="no" <%= (request.getAttribute("colleger").equals("no")) ? "checked" : "" %> >Não
                            </label>
                        </div>
                    </div>
                </div>
                <div class="form-group value">
                    <label class="control-label">Valor</label>
                    <div class="input-group">
                        <!-- <span class="input-group-addon">R$</span> -->
                        <input type="text" name="value" value="${value}" data-thousands="." data-decimal="," class="form-control">
                    </div>
                </div>
                <div class="input-group-btn submit">
                	<button class="btn btn-primary pull-right" type="submit">Salvar</button>
                	<a href="<%= request.getContextPath() %>/manager/control-customer"><button class="btn btn-warning pull-left" type="button">Voltar</button></a>
                </div>
            </form>
 
        </div>
    </div>
</div>

<jsp:include page="/WEB-INF/views/includes/footer.jsp"></jsp:include>
<script type="text/javascript" src="<%= request.getContextPath() %>/js/customer.js"></script>
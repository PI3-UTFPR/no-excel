<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/views/includes/header.jsp"></jsp:include>
<jsp:include page="/WEB-INF/views/includes/nav_admin.jsp"></jsp:include>

<div class="container">

	<c:forEach var="entry" items="${flashMessage}">
		<div class="alert alert-dismissable alert-${flashType}">
			<button type="button" class="close" data-dismiss="alert">×</button>
	    		<strong>${entry.key}: </strong> ${entry.value}.
		</div>
	</c:forEach>
	
	<div class="buttons">
		<a href="<%= request.getContextPath() %>/admin/customers/save"><button class="btn btn-primary" type="button">Cadastrar novo cliente</button></a>
		<a href="#" class="editar"><button class="btn btn-primary" type="button">Editar/Ver cliente cadastrado</button></a>
	</div>

    <div class="panel panel-primary registro" style="display:none">
        <div class="panel-heading">
            <h3 class="panel-title">Encontrar e editar cliente</h3>
        </div>
        <div class="panel-body">
            <form action="<%= request.getContextPath() %>/admin/customers/edit" method="get">
                <div class="form-group ra">
                    <!-- <label class="control-label">Login (Ra)</label> -->
                    <input class="form-control" name="find" type="text" placeholder="Buscar cliente por login" required>
                </div>
                
                <div class="input-group-btn submit">
                	<button class="btn btn-primary" type="submit">Buscar</button>
                </div>
            </form>
        </div>
    </div>	

</div>

<jsp:include page="/WEB-INF/views/includes/footer.jsp"></jsp:include>
<script type="text/javascript" src="<%= request.getContextPath() %>/js/customer.js"></script>
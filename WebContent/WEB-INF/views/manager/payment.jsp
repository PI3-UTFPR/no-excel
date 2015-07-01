<jsp:include page="../includes/header.jsp" />
<jsp:include page="../includes/nav_admin.jsp" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="container">
	<c:if test="${error == true}">
		<div class="alert alert-dismissable alert-danger">
			<button type="button" class="close" data-dismiss="alert">×</button>
			<strong>${error_message}</strong>
		</div>
	</c:if>
	<div class="panel panel-primary">
		<div class="panel-heading">
			<h3 class="panel-title">Transação</h3>
		</div>
		<div class="panel-body">
			<form action="" method="POST">
			
				<input type="hidden" name="id" value="${customer.id}" />
				<div class="form-group">
					<label class="control-label" for="disabledInput">RA</label> <input
						class="form-control" id="ra" type="text" placeholder="Ra"
						value="${customer.colleger}" disabled>
				</div>
				<div class="form-group">
					<label class="control-label" for="disabledInput">Nome</label> <input
						class="form-control" id="name" type="text" placeholder="Nome"
						value="${customer.name}" disabled>
				</div>
				<div class="form-group">
					<label class="control-label" for="disabledInput">Foto</label>
					<div>
						<img src="img/img.svg" name="photoImg" alt="..."
							class="img-rounded">
					</div>
				</div>

				<div class="form-group">
					<label class="control-label">Saldo</label> <input type="text"
						name="balace" id="balance" class="form-control"
						value="<fmt:formatNumber value="${customer.value / 100}" type="currency"/>"
						disabled>
				</div>

				<div class="form-group">
					<label class="control-label">Operação</label>

					<div class="panel panel-primary">
						<div class="panel-heading">
							<h3 class="panel-title">Fazer Pagamento</h3>
						</div>
						<div class="panel-body">
							<div class="radio radio-primary">
								<label> <input type="radio" name="type" id="type"
									value="debit" checked=""> Débito
								</label>
							</div>
						</div>
					</div>
					<div class="panel panel-primary">
						<div class="panel-heading">
							<h3 class="panel-title">Adicionar Créditos</h3>
						</div>
						<div class="panel-body">
							<div class="radio radio-primary">
								<label> <input type="radio" name="type" id="type"
									value="credit"> Crédito
								</label>
							</div>
						</div>
					</div>

				</div>


				<div class="form-group">
					<label class="control-label">Valor</label>
					<div class="input-group">
						<span class="input-group-addon">R$</span> <input type="text"
							name="value" id="value" data-thousands="." data-decimal=","
							class="form-control"> <span class="input-group-btn">
							<button class="btn btn-primary" type="submit">Finalizar</button>
						</span>
					</div>
				</div>
			</form>
		</div>
	</div>


</div>

<jsp:include page="../includes/footer.jsp" />
<jsp:include page="header.jsp"/>
<jsp:include page="nav_admin.jsp"/>

<div class="container">

	<div class="panel panel-primary">
    <div class="panel-heading">
        <h3 class="panel-title">Pagamento</h3>
    </div>
    <div class="panel-body">
        <form action="">
        	<div class="form-group">
   			 	<label class="control-label" for="disabledInput">RA</label>
    		 	<input class="form-control" id="raIpt" type="text" placeholder="Ra" disabled>
			</div>
			<div class="form-group">
   			 	<label class="control-label" for="disabledInput">Nome</label>
    		 	<input class="form-control" id="nameIpt" type="text" placeholder="Nome" disabled>
			</div>
			<div class="form-group">
   			 	<label class="control-label" for="disabledInput">Foto</label>
    		 	<div><img src="../img/img.svg" name="photoImg" alt="..." class="img-rounded"></div>
			</div>
			
			<div class="form-group">
    			<label class="control-label">Saldo</label>
    			<div class="input-group">
        			<span class="input-group-addon">R$</span>
        			<input type="text" name="balaceIpt" id="balanceIpt" class="form-control" disabled>
    			</div>
			</div>
			
			<div class="form-group">
            <label class="control-label">Operação</label>
            <div class="col-lg-10">
                <div class="radio radio-primary">
                    <label>
                        <input type="radio" name="typeRadios" id="typeRadios" value="debit" checked="">
                        Débito
                    </label>
                </div>
                <div class="radio radio-primary">
                    <label>
                        <input type="radio" name="typeRadios" id="typeRadios" value="credit">
                        Crédito
                    </label>
                </div>
            </div>
        </div>
			
			<div class="form-group">
    			<label class="control-label">Valor</label>
    			<div class="input-group">
        			<span class="input-group-addon">R$</span>
        			<input type="text" name="valueIpt" id="valueIpt" data-thousands="." data-decimal="," class="form-control">
        		<span class="input-group-btn">
            		<button class="btn btn-primary" type="submit">Finalizar</button>
       		 	</span>
    			</div>
			</div>
        </form>
    </div>
</div>
	
	
</div>

<jsp:include page="footer.jsp"/>
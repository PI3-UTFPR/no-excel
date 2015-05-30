<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="nav_admin.jsp"></jsp:include>

<div class="container">

	<div class="panel panel-primary">
    <div class="panel-heading">
        <h3 class="panel-title">Registro</h3>
    </div>
    <div class="panel-body">
        <form action="customer" method="post">
        	<div class="form-group">
   			 	<label class="control-label" for="disabledInput">RA</label>
    		 	<input class="form-control" id="ra" type="text" placeholder="Ra" required>
			</div>
			<div class="form-group">
   			 	<label class="control-label" for="disabledInput">Nome</label>
    		 	<input class="form-control" id="name" type="text" placeholder="Nome" required>
			</div>
			<div class="form-group">	
            <label for="select" class="form-control">Tipo de Pessoa</label>
                <div class="form-group">
                <select class="form-control" id="type" required>
                    <option value="Aluno">Aluno</option>
                    <option value="Professor">Professor</option>
                    <option value="Servidor">Servidor</option>
                </select>	
                </div>
   			 </div>
   			 
   			 <div class="form-group">
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
			
			<div class="form-group">
    			<label class="control-label">Valor</label>
    			<div class="input-group">
        			<span class="input-group-addon">R$</span>
        			<input type="text" name="valueIpt" id="value" data-thousands="." data-decimal="," class="form-control">
        		<span class="input-group-btn">
            		<button class="btn btn-primary" type="submit">Finalizar</button>
       		 	</span>
    			</div>
			</div>
			
			
        </form>
    </div>
</div>
	

</div>

<jsp:include page="footer.jsp"></jsp:include>
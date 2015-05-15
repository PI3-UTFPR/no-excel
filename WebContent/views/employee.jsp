<jsp:include page="header.jsp"/>

<jsp:include page="nav_admin.jsp"/>
<div class="container">
<a href="#modalNew" class="btn btn-primary" data-toggle="modal" data-target="#modalNew">Novo</a>
	<div class="panel panel-primary">
	    <div class="panel-heading">
	        <h3 class="panel-title">Lista de Funcionários</h3>
	    </div>
    <div class="panel-body">
        <div class="list-group">
    <div class="list-group-item">
        <div class="row-action-primary">
            <i class="mdi-file-folder"></i>
        </div>
        <div class="row-content">
            <div class="least-content icon-preview"><span class="mdi-image-edit"></span><i class="mdi-action-delete"></i></div>
            <h4 class="list-group-item-heading">Nome</h4>
            <p class="list-group-item-text">Cargo</p>
        </div>
    </div>
    <div class="list-group-separator"></div>
    <div class="list-group-item">
        <div class="row-action-primary">
            <i class="mdi-file-folder"></i>
        </div>
        <div class="row-content">
            <div class="least-content icon-preview"><span class="mdi-image-edit"></span><i class="mdi-action-delete"></i></div>
            <h4 class="list-group-item-heading">Nome</h4>
            <p class="list-group-item-text">Cargo</p>
        </div>
    </div>
    <div class="list-group-separator"></div>
    <div class="list-group-item">
        <div class="row-action-primary">
            <i class="mdi-file-folder"></i>
        </div>
         <div class="row-content">
            <div class="least-content icon-preview"><span class="mdi-image-edit"></span><i class="mdi-action-delete"></i></div>
            <h4 class="list-group-item-heading">Nome</h4>
            <p class="list-group-item-text">Cargo</p>
        </div>
    </div>
</div>
    </div>
</div>
</div>


<div class="modal" id="modalNew">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button>
                <h4 class="modal-title">Cadastro de funcionário</h4>
            </div>
            <div class="modal-body">
                <form class="form-signin">
          <div class="form-control-wrapper">
          
          <div class="form-group">
    		<input class="form-control" id="nameInput" placeholder="Nome" type="text">
		</div>
          
          <div class="form-group">
    		<input class="form-control" id="userInput" placeholder="Usuário" type="text">
		</div>
		
		<div class="form-group">
    		<input class="form-control" id="pswdInput" placeholder="Senha"  type="password">
		</div>
		</div>
        </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
                <button type="button" class="btn btn-primary">Salvar</button>
            </div>
        </div>
    </div>
</div>

<jsp:include page="footer.jsp"/>
<%@page import="java.util.HashMap"%>
<jsp:include page="header.jsp"/>
<jsp:useBean id="user" scope="request" type="br.edu.utfpr.model.User" />

<jsp:include page="nav_admin.jsp"/>
<div class="container">
<div class="row">
	<% 
	HashMap<String, String> msgs = (HashMap)request.getAttribute("msg");
	if(msgs != null){
		for(String key : msgs.keySet()){ 
			String msg = msgs.get(key);
		%>
			<span class="col-md-12 alert alert-<%= key %>"><%= msg %></span>
		<% } %>	
	<% } %>
</div>
<br>
<a href="#modalNew" class="btn btn-primary" data-toggle="modal" data-target="#modalNew">Novo</a>
	<div class="panel panel-primary">
	    <div class="panel-heading">
	        <h3 class="panel-title">Lista de Usuários</h3>
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


<div  id="modalNew" aria-labelledby="modalNew">
	<form class="form-signin" method="POST" action="">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button>
                <h4 class="modal-title">Cadastro de usuário</h4>
            </div>
            <div class="modal-body">
          <div class="form-control-wrapper">
          
          <div class="form-group">
    		<input class="form-control" name="name" value="${user.getName()}" id="nameInput" placeholder="Nome" type="text">
		</div>
          
          <div class="form-group">
    		<input class="form-control" name="login" value="${user.getLogin()}" id="userInput" placeholder="Usuário" type="text">
		</div>
		
		<div class="form-group">
    		<input class="form-control" id="pswdInput" name="password" value="${user.getPassword()}" placeholder="Senha"  type="password">
		</div>
		</div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
                <input type="submit" class="btn btn-primary" value="Salvar" />
            </div>
        </div>
    </div>
    </form>
</div>

<jsp:include page="footer.jsp"/>
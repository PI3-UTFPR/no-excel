<%@page import="br.edu.utfpr.util.Constants"%>
<%@page import="br.edu.utfpr.model.User"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<jsp:include page="../includes/header.jsp"/>
 
<jsp:include page="../includes/nav_admin.jsp"/>

<div class="container">
	<div class="row">
	  <%
	  HashMap<String, String> msgs = (HashMap)request.getAttribute("msg");
	  
	  if(msgs != null){
	    
		  for(String key : msgs.keySet()){
	      	String msg = msgs.get(key);
	  %>
	  	  	<span class="col-md-12 alert alert-<%= key %>"><%= msg %></span>	    
		  <% 
		  } 
		  %>	  
	  <% 
	  } 
	  %>
	</div>
	
	<br>
	<button class="btn btn-primary" data-toggle="modal" data-target="#complete-dialog">Novo</button>
 
  	<div class="panel panel-primary">   
      	<div class="panel-heading">   
          <h3 class="panel-title">Lista de Usu�rios</h3>
      	</div>
    
    	<div class="panel-body">
      		<%  List<User> users = (List<User>) request.getAttribute(Constants.MANAGER_LIST_KEY);
        		for(int i=0; i < users.size(); i++){
          			User u = users.get(i); 
          	%>
		        <div class="list-group">
		          <div class="list-group-item">
		              <div class="row-action-primary">
		                  <i class="mdi-file-folder"></i>
		              </div>
		              <div class="row-content">
		                  <div class="least-content icon-preview"><a href="<%= request.getContextPath() %>/admin/delete-manager?id=<%= u.getId() %>"></span><i class="mdi-action-delete"></i></a></div>
		                  <h4 class="list-group-item-heading"><%= u.getName() %></h4>
		                  <p class="list-group-item-text"><%= u.getUsername() %></p>
		              </div>
		          </div>
		          <div class="list-group-separator"></div>
		      </div>
      		<% } %>
    	</div>
	</div>
</div>

<div id="complete-dialog" class="modal fade" tabindex="-1">
  	<form class="form-signin" method="POST" action="<%= request.getContextPath() %>/admin/register-manager">
    	<div class="modal-dialog">
        	<div class="modal-content">
        	        	
            	<div class="modal-header">
                	<button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button>
                	<h4 class="modal-title">Cadastro de usu�rio</h4>
            	</div>
            	
            	<div class="modal-body">
          			<div class="form-control-wrapper">
		          		<div class="form-group">
		        			<input class="form-control" name="name" value="${user.getName()}" id="nameInput" placeholder="Nome" type="text">
		    			</div>
		
		          		<div class="form-group">
		        			<input class="form-control" name="login" value="${user.getLogin()}" id="userInput" placeholder="Usu�rio" type="text">
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

<jsp:include page="../includes/footer.jsp"/>
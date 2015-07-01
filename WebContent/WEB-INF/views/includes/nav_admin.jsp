<%@page import="br.edu.utfpr.util.Constants"%>
<div class="navbar navbar-default shadow-z-2">
    <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-responsive-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="javascript:void(0)"><img alt="NoExcel" src="<%= request.getContextPath() %>/img/noexcel.png" class="logo"></a>
    </div>
    <div class="navbar-collapse collapse navbar-responsive-collapse">
        <ul class="nav navbar-nav">
            <li class="active"><a href="<%= request.getContextPath() + Constants.ADMIN_PATH %>"> <span class="glyphicon mdi-action-home"></span> Início</a></li>
            <li><a href="/No-excel/manager/transaction"><span class="glyphicon mdi-action-credit-card"></span> Transações</a></li>            
            <li><a href="<%= request.getContextPath() %>/manager/control-customer"><span class="glyphicon mdi-social-person-add"></span> Clientes</a></li>
            <li><a href="<%= request.getContextPath() %>/admin/register-manager"><span class="glyphicon mdi-action-assignment-ind"></span> Funcionários</a></li>
            <li><a href="report_admin.jsp"><span class="glyphicon mdi-action-assignment"></span> Relatórios</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="<%= request.getContextPath() %>/manager/logout"><span class="glyphicon mdi-action-exit-to-app"></span> Sair</a></li>
        </ul>
    </div>
</div>
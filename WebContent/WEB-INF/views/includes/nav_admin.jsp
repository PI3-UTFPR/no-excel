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
            <li class="active"><a href="admin.jsp"> <span class="glyphicon mdi-action-home"></span> Início</a></li>
            <li><a href="transaction"><span class="glyphicon mdi-action-credit-card"></span> Transações</a></li>
            <li class="dropdown">
                <a href="bootstrap-elements.html" data-target="#" class="dropdown-toggle" data-toggle="dropdown"><span class="glyphicon mdi-social-person-add"></span>Registrar <b class="caret"></b></a>
                <ul class="dropdown-menu">
                    <li><a href="<%= request.getContextPath() %>/admin/customers">Novo Cliente</a></li>
                    <li><a href="<%= request.getContextPath() %>/admin/users">Novo Administrador</a></li>
                </ul>
            </li>
            <li><a href="employee.jsp"><span class="glyphicon mdi-action-assignment-ind"></span> Funcionários</a></li>
            <li><a href="report_admin.jsp"><span class="glyphicon mdi-action-assignment"></span> Relatórios</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="javascript:void(0)"><span class="glyphicon mdi-action-exit-to-app"></span> Sair</a></li>
        </ul>
    </div>
</div>
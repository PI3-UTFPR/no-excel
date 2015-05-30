<jsp:include page="header.jsp"/>
<jsp:include page="nav_admin.jsp"/>
<div class="container">
<div class="panel panel-primary">
    <div class="panel-heading">
        <h3 class="panel-title">Relatório de Transações</h3>
    </div>
    <div class="panel-body">
    	<div class="form-group">
    <label class="control-label">Data</label>
    <div class="input-group">
        <input type="text" class="form-control" name="date" id="date">
        <span class="input-group-btn">
            <button class="btn btn-primary" type="button">Buscar</button>
        </span>
    </div>
</div>
        <table class="table table-bordered table-hover">
  			<thead>
        <tr>
          <th>Id</th>
          <th>RA</th>
          <th>Valor</th>
          <th>Data</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <th scope="row">1</th>
          <td>123456</td>
          <td>R$ 2,50</td>
          <td>12/03/2015 13:00</td>
        </tr>
        <tr>
          <th scope="row">2</th>
          <td>234551</td>
          <td>R$ 5,00</td>
          <td>12/03/2015 13:01</td>
        </tr>
        <tr>
          <th scope="row">3</th>
          <td>134567</td>
          <td>R$ 6,50</td>
          <td>12/03/2015 13:02</td>
        </tr>
      </tbody>
		</table>
    </div>
</div>
</div>	
<jsp:include page="footer.jsp"/>
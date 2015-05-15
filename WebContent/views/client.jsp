<jsp:include page="header.jsp"/>

<jsp:include page="nav_client.jsp"/>

<div class="container">

	<div class="panel panel-primary">
    <div class="panel-heading">
        <h3 class="panel-title">Saldo</h3>
    </div>
    <div class="panel-body">
			<div class="form-group">
    			<div class="input-group">
        			<span class="input-group-addon">R$</span>
        			<label name="balaceIpt" id="balanceIpt" class="form-control"/>
    			</div>
			</div>
			
        </div>
	</div>
	<div class="panel panel-primary">
    <div class="panel-heading">
        <h3 class="panel-title">Extrato</h3>
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
          <th>Valor</th>
          <th>Transação</th>
          <th>Saldo Anterior</th>
          <th>Data</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <th scope="row">1</th>
          <td>R$ 3,00</td>
          <td>Crédito</td>
          <td>R$ 12,50</td>
          <td>12/03/2015 20:40</td>
        </tr>
        <tr>
          <th scope="row">2</th>
          <td>R$ 2,50</td>
          <td>Débito</td>
          <td>R$ 15,00</td>
          <td>11/03/2015 20:30</td>
        </tr>
        <tr>
          <th scope="row">3</th>
          <td>R$ 2,50</td>
          <td>Débito</td>
          <td>R$ 17,50</td>
          <td>10/03/2015 20:15</td>
        </tr>
      </tbody>
		</table>
    </div>
</div>
	
</div>

<jsp:include page="footer.jsp"/>
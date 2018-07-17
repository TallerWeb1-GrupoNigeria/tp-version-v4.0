
<%@ include file="_header.jsp" %>
<%@ include file="_menuAdmin.jsp" %>

  
  <div class="py-2">
    <div class="container">
      <div class="row">
        <div class="col-md-12">
          <table class="table">
           
            <thead>
              <tr>
              	<th>Portada</th>
                <th>Nombre</th>
                <th>Descripcion</th>
                <th>Fecha</th>
                <th>HoraInicio</th>
                <th>HoraFin</th>
                <th>Direccion</th>
                <th>Mostrar</th>
                <th>Acciones</th>
              </tr>
            </thead>
            
            <tbody>
            	<c:forEach items="${ keyListarEventos }" var="evento">
            		<tr>
            			<td class="align-middle">
            				<a href="#" class="thumbnail"><img src="img/${ evento.getImagen1() }" alt="miniMagen" width="75" height="auto"></a>
    					</td>
		            	<td class="align-middle">${ evento.getNombre() }</td>
		                <td class="align-middle">${ evento.getDescripcion() }</td>
		                <td class="align-middle">${ evento.getFecha() }</td>
		                <td class="align-middle">${ evento.getHoraInicio() }</td>
		                <td class="align-middle">${ evento.getHoraFin() }</td>
		                <td class="align-middle">${ evento.getDireccion().getFormatted_address() }</td>
		                <td class="align-middle text-center">${ evento.getMostrar() }</td>
		                <td class="align-middle">
		                	<a href="actualizarEvento?id=${ evento.getId() }">Modificar </a>|
		                	<a href="detalleEvento?id=${ evento.getId() }">Detalle</a>
		                </td>
	                </tr>
            	</c:forEach>
            </tbody>
            
          </table>
        </div>
      </div>
    </div>
  </div>

  
 <%@ include file="_footer.jsp" %>
 
 
 
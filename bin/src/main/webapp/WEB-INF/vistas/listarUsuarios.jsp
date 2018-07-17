
<%@ include file="_header.jsp" %>
<%@ include file="_menuAdmin.jsp" %>

  
  <div class="py-2">
    <div class="container">
      <div class="row">
        <div class="col-md-12">
          <table class="table">
           
            <thead>
              <tr>
              	<th>ID</th>
              	<th>Nombre</th>
                <th>Email</th>
                <th>Password</th>
                <th>Rol</th>
                <th>Acciones</th>
              </tr>
            </thead>
            
            <tbody>
            	<c:forEach items="${ keyListarUsuarios }" var="usuario">
            		<tr>
            			<td class="align-middle">${ usuario.getId() }</td>
		            	<td class="align-middle">${ usuario.getNombre() }</td>
		                <td class="align-middle">${ usuario.getEmail() }</td>
		                <td class="align-middle">${ usuario.getPassword() }</td>
		                <td class="align-middle">${ usuario.getRol() }</td>
		                <td class="align-middle">
		                <%-- 	<a href="actualizarEvento?id=${ usuario.getId() }">Modificar </a>|
		                	<a href="detalleEvento?id=${ usuario.getId() }">Detalle</a> --%>
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
 
 
 
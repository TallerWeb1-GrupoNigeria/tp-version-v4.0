
<%@ include file="_header.jsp" %>
<%@ include file="_menuAdmin.jsp" %>


 <div class="container" id="contenedor_form">    
	 
	  <br />
	  <form:form action="validarActualizarEvento" method="POST" modelAttribute="keyEvento">
	
	   <form:input path="id" type="hidden" id="id" class="input form-control" placeholder="${ evento.getId() }"/>
	
	   <div class="form-group">
	    <label>Nombre del Evento:</label>
	       <form:input path="nombre" type="text" id="nombre" class="input form-control" placeholder="${ evento.getNombre() }"/>
	   </div>

	   <div class="form-group">
	    <label>Descripcion:</label>
	       <form:input path="descripcion" type="text" id="descripcion" class="input form-control" placeholder="${ evento.getDescripcion() }"/>
	   </div>
	
	   <div class="form-group">
	    <label>Fecha:</label>
	    <form:input path="fecha" type="date" id="fecha" class="input form-control" placeholder="${ evento.getFecha() }"/>
	   </div>
	
	   <div class="form-group">
	    <label>Hora de Inicio:</label>
	       <form:input path="horaInicio" type="text" id="horaInicio" class="input form-control" placeholder="${ evento.getHoraInicio() }"/>
	   </div>
	   
	   <div class="form-group">
	    <label>Hora de Finalizacion:</label>
	       <form:input path="horaFin" type="text" id="horaFin" class="input form-control" placeholder="${ evento.getHoraFin() }"/>
	   </div>
	   
	   <div class="form-group">
	    <label>Telefono:</label>
	       <form:input path="telefono" type="text" id="telefono" class="input form-control" placeholder="${ evento.getTelefono() }"/>
	   </div>
	   
	   <div class="form-group">
		    <label>Imagen 1:
		    	<small class="form-text text-muted">(Importante!) Seleccione imagenes que esten dentro de la carpeta img/</small>
		    </label><br/>
	        <form:input path="imagen1" type="file" accept=".jpg,.jpeg,.png" id="imagen1" name="imagen1" class="" value="${ evento.getImagen1() }"/>
	    </div>
	    
	    <div class="form-group">
		    <label>Imagen 2:</label><br/>
	        <form:input path="imagen2" type="file" accept=".jpg,.jpeg,.png" id="imagen2" name="imagen2" class="" value="${ evento.getImagen2() }"/>
	    </div>
	    
	    <div class="form-group">
		    <label>Imagen 3:</label><br/>
	        <form:input path="imagen3" type="file" accept=".jpg,.jpeg,.png" id="imagen3" name="imagen3" class="" value="${ evento.getImagen3() }"/>
	    </div>
	    
	    <div class="form-group">
	    <label>Correo:</label>
	       <form:input path="correo" type="text" id="correo" class="input form-control" placeholder="${ evento.getCorreo() }"/>
	   </div>
	   
	   <div class="form-group">
	    <label>Facebook:</label>
	       <form:input path="facebook" type="text" id="facebook" class="input form-control" placeholder="${ evento.getFacebook() }"/>
	   </div>
	   
	   <div class="form-group">
	    <label>Twitter:</label>
	       <form:input path="twitter" type="text" id="twitter" class="input form-control" placeholder="${ evento.getTwitter() }"/>
	   </div>
	   
	   <div class="form-group">
	    <label>Instagram:</label>
	       <form:input path="instagram" type="text" id="instagram" class="input form-control" placeholder="${ evento.getInstagram() }"/>
	   </div>
	   
	   <div class="form-group">
	    <label>Mostrar:</label>
	       <form:select path="mostrar" id="mostrar" class="input form-control">
	      <form:option value="si">Si</form:option>
	      <form:option value="no">No</form:option>
	    </form:select>
	   </div>
		
		<br />
	   <div class="form-group botones">
	    <button class="btn btn-primary boton" type="submit">Modificar Evento</button>&nbsp;&nbsp;
	    <a href="homeAdmin" class="btn btn-danger boton">Cancelar</a>
	   </div>
	
	  </form:form>
  
 </div>

<br />
 
<%@ include file="_footer.jsp" %>
 
 
 
 
 
 
 
 
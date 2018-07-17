
<%@ include file="_header.jsp" %>
<%@ include file="_menuAdmin.jsp" %>

<link type="text/css" rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500">
<link rel="stylesheet" href="css/css-mapa2.css" type="text/css">

<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAKsOyLppGoYEHhTvwny8xDgKj96ZzSIFU&libraries=places&callback=initAutocomplete" async defer></script>
<script src="js/mapas2.js"></script>

 <div class="container" id="contenedor_form">    
	 
	  <br />
	
	<div class="row">
		<div class="col-md-2"></div>
		<div class="col-md-8">
			<div class="alert alert-warning alert-dismissable">
			  <button type="button" class="close" data-dismiss="alert">&times;</button>
			  <strong>¡Cuidado!</strong>${keyMsjEvento}
			</div>
		</div>
	</div>
	<div class="row">
	 		
	 <div class="col-md-7">

	  <form:form action="crearEvento" method="POST" modelAttribute="keyEvento">
	
	   <div class="form-group">
	    <label>Nombre:</label>
	       <form:input path="nombre" type="text" id="nombre" class="input form-control" />
	       <small class="form-text text-muted">Nombre que tendra el evento</small>
	   </div>
	   
	   <div class="form-group">
	    <label>Descripcion:</label>
	       <form:input path="descripcion" type="text" id="descripcion" class="input form-control"/>
	   </div>

	   <div class="form-group">
	    <label>Fecha:</label>
	    <form:input path="fecha" type="date" id="fecha" class="input form-control" />
	   </div>
	
	   <div class="form-group">
	    <label>Hora de Inicio:</label>
	       <form:input path="horaInicio" type="text" id="horaInicio" class="input form-control"/>
	   </div>
	   
	   <div class="form-group">
	    <label>Hora de Fin:</label>
	       <form:input path="horaFin" type="text" id="horaFin" class="input form-control"/>
	   </div>
	   
	   <div class="form-group">
	    <label>Telefono:</label>
	       <form:input path="telefono" type="text" id="telefono" class="input form-control"/>
	   </div>
	   
	    <div class="form-group">
		    <label>Imagen 1:
		    	<small class="form-text text-muted">(Importante!) Seleccione imagenes que esten dentro de la carpeta img/</small>
		    </label><br/>
	        <form:input path="imagen1" type="file" accept=".jpg,.jpeg,.png" id="imagen1" name="imagen1" class=""/>
	    </div>
	    
	    <div class="form-group">
		    <label>Imagen 2:</label><br/>
	        <form:input path="imagen2" type="file" accept=".jpg,.jpeg,.png" id="imagen2" name="imagen2" class=""/>
	    </div>
	    
	    <div class="form-group">
		    <label>Imagen 3:</label><br/>
	        <form:input path="imagen3" type="file" accept=".jpg,.jpeg,.png" id="imagen3" name="imagen3" class=""/>
	    </div>
	    
	    <div class="form-group">
	    <label>Correo:</label>
	       <form:input path="correo" type="text" id="correo" class="input form-control"/>
	   </div>
	   
	   <div class="form-group">
	    <label>Facebook:</label>
	       <form:input path="facebook" type="text" id="facebook" class="input form-control"/>
	   </div>
	   
	   <div class="form-group">
	    <label>Twitter:</label>
	       <form:input path="twitter" type="text" id="twitter" class="input form-control"/>
	   </div>
	   
	   <div class="form-group">
	    <label>Instagram:</label>
	       <form:input path="instagram" type="text" id="instagram" class="input form-control"/>
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
	    <button class="btn btn-primary boton" type="submit">Crear Evento</button>&nbsp;&nbsp;
	    <button class="btn btn-danger boton" type="reset">Reset</button>
	   </div>
	
	  </form:form> <!-- Fomulario keyEvento  -->
    </div>
    
    <div class="col-md-5">
   <!-- MAPA CON BUSCADOR -->
		<div id="locationField">
	      <input id="autocomplete" placeholder="Ingrese su dirección" onFocus="geolocate()" type="text"></input>
	    </div>
	    
		<div id="map"></div>
		
		
	    <!-- form:form action="valida-direccion" method="POST" modelAttribute="keyEvento.direcion"-->
	    
	    	<div class="form-row">
	    		<div class="form-group col-md-4">
			      <label for="street_number">Nro calle</label>
			      <input type="text" class="form-control" id="street_number" placeholder=""/>
			    </div>
			    <div class="form-group col-md-8">
			      <label for="route">Calle</label>
			      <input type="text" class="form-control" id="route" placeholder="">
			    </div>
	    	</div>
	    	<div class="form-row">
	    		<div class="form-group col-md-12">
	    			<label for="locality">Ciudad</label> 
					<input type="text"	class="form-control" id="locality"/>
	    		</div>
	    	</div>
			<div class="form-row">
				<div class="form-group col-md-8">
					<label for="administrative_area_level_1">Localidad</label> 
					<input  type="text"	class="form-control" id="administrative_area_level_1"/>
				</div>
				
				<div class="form-group col-md-4">
					<label for="postal_code">Codigo postal</label> 
					<input type="text" 	class="form-control" id="postal_code"/>
				</div>
			</div>
			<div class="form-row">
	    		<div class="form-group col-md-12">
	    			<label for="country">Pais</label> 
					<input type="text"	class="form-control" id="country"/>
	    		</div>
	    	</div>
	    	
		<!-- /form:form-->
    </div>
    
   </div>
 </div>

<br />
 
<%@ include file="_footer.jsp" %>
 
 
 
 
 
 
 
 
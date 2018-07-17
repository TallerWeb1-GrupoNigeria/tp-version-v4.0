
<%@ include file="_header.jsp" %>



<div class="container" id="contenedor_form">    
	 
	  <br />
	<div class="row">

	 <div class="col-md-12">

	  <form:form action="registrovalidar" method="POST" modelAttribute="usuarioRegistro">
	
	   <div class="form-group">
	    <label>Nombre:</label>
	       <form:input path="nombre" type="text" id="nombre" class="input form-control" />
	       <small class="form-text text-muted">Nombre</small>
	   </div>
	   
	   <div class="form-group">
	    <label>Email:</label>
	       <form:input path="email" type="text" id="email" class="input form-control"/>
	   </div>
	
	   <div class="form-group">
	    <label>Contraseña:</label>
	    <form:input path="password" type="password" id="password" class="input form-control" />
	   </div>
	   
	  <%--  <c:if test="${ not empty user } "> --%>
	   		<div class="form-group">
	    		<label>Rol:</label>
	       		<form:select path="rol" id="rol" class="input form-control">
			    	<form:option value="user">Usuario</form:option>
			    </form:select>
	   		</div>	   
<%-- 	   </c:if> --%>
	   
	   <c:if test="${ not empty admin } ">
	   		<div class="form-group">
			    <label>Rol:</label>
			    <form:select path="rol" id="rol" class="input form-control">
			    	<form:option value="user">Usuario</form:option>
			      	<form:option value="admin">Administrador</form:option>
			    </form:select>
			 </div>
	   
	   </c:if>
	   
	   
	   
	   
	    <div class="form-group">
		    <label>Foto:
		    	<small class="form-text text-muted">(Importante!) Seleccione una foto que esten dentro de la carpeta img/</small>
		    </label><br/>
	        <form:input path="foto" type="file" accept=".jpg,.jpeg,.png" id="foto" name="foto" class=""/>
	    </div>	
	    
		<br />
	   <div class="form-group botones">
	    <button class="btn btn-primary boton" type="submit">Crear</button>&nbsp;&nbsp;
	    <button class="btn btn-danger boton" type="reset">Reset</button>
	   </div>
	
	  </form:form>
    </div>
    
    
   </div>
 </div>

<br />
 
<%@ include file="_footer.jsp" %>
 
 
 
 
 
 
 
 
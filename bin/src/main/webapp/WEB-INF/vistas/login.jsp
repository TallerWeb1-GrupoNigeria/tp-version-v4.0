<%@ include file="_header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
 	 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="css/bootstrap-select.min.css">
<link rel="stylesheet" href="css/estilo-mapa.css" type="text/css">

 <script src='https://cdnjs.cloudflare.com/ajax/libs/bootstrap-validator/0.5.3/js/bootstrapValidator.min.js'></script>
 <script src='https://cdnjs.cloudflare.com/ajax/libs/bootstrap-validator/0.5.3/js/language/es_ES.min.js'></script>
<script src="js/bootstrap-select.min.js" defer></script>
<script src="js/mapas.js"></script>
<script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAKsOyLppGoYEHhTvwny8xDgKj96ZzSIFU&libraries=places&callback=initAutocomplete"> </script>

		<div class = "container" align="center">
			<div id="loginbox" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
				<%--Definicion de un form asociado a la accion /validar-login por POST. Se indica ademas que el model attribute se--%>
				<%--debe referenciar con el nombre usuario, spring mapea los elementos de la vista con los atributos de dicho objeto--%>
					<%--para eso debe coincidir el valor del elemento path de cada input con el nombre de un atributo del objeto --%>
				<form:form action="validar-login" method="POST" modelAttribute="usuario">
			    	<!-- h3 class="form-signin-heading">Taller Web I</h3>
					<hr class="colorgraph"--><br>
			    	<h3 class="form-signin-heading"> 
			    	<c:if test="${empty error}">
				    	<c:if test="${not empty mensaje}">
				    	 	 <span class="alert alert-success">${mensaje}</span>  
				    	 </c:if>	
			    	 </c:if>
			    	 <%--Bloque que es visible si el elemento error no está vacío	--%>
					<c:if test="${not empty error}">
				       <h4><span class="alert alert-warning">${error}</span></h4>
				        <br>
		        	</c:if>	
					<hr class="colorgraph"><br>

					<%--Elementos de entrada de datos, el elemento path debe indicar en que atributo del objeto usuario se guardan los datos ingresados--%>
					<p>Email: </p>
					<form:input path="email" id="email" type="email" class="form-control" required="required" />
					<br/>
					<p>Contrase�a</p>
					<form:input path="password" type="password" id="password" class="form-control" required="required"/>     		  
					<br/>
					<button class="btn btn-lg btn-primary btn-block" Type="Submit">Login</button>
				</form:form>
			</div>
		</div>
		
		<h4></h4>
		<!-- Placed at the end of the document so the pages load faster -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
		<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>
	<div>
	
	
	</div>


  <%@ include file="_footer.jsp" %>

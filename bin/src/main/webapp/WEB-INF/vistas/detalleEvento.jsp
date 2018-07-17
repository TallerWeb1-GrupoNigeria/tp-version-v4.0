<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ include file="_header.jsp" %>
<%@ include file="_menuAdmin.jsp" %>


<div class="py-2">
    <div class="container">
      <div class="row">
        
        <div class="col-md-6">
          
			<form:form class="" modelAttribute="keyEvento">
			
				<div class="form-group">
			    	<h3 >${ keyEvento.getNombre() }</h3>
				</div>
				
				<table class="table">
					<tr>
						<td>Descripcion:</td>
						<td class="font-weight-bold">${ keyEvento.getDescripcion() }</td>
					</tr>
					<tr>
						<td>Fecha:</td>
						<td class="font-weight-bold">${ keyEvento.getFecha() }</td>
					</tr>
					<tr>
						<td>Hora de Inicio:</td>
						<td class="font-weight-bold">${ keyEvento.getHoraInicio() }</td>
					</tr>
					<tr>
						<td>Hora de Finalizacion:</td>
						<td class="font-weight-bold">${ keyEvento.getHoraFin() }</td>
					</tr>
					<tr>
						<td>Telefono:</td>
						<td class="font-weight-bold">${ keyEvento.getTelefono() }</td>
					</tr>
					<tr>
						<td>Correo:</td>
						<td class="font-weight-bold">${ keyEvento.getCorreo() }</td>
					</tr>
					<tr>
						<td>Facebook:</td>
						<td class="font-weight-bold">${ keyEvento.getFacebook() }</td>
					</tr>
					<tr>
						<td>Twitter:</td>
						<td class="font-weight-bold">${ keyEvento.getTwitter() }</td>
					</tr>
					<tr>
						<td>Instagram:</td>
						<td class="font-weight-bold">${ keyEvento.getInstagram() }</td>
					</tr>
					<tr>
						<td>Mostrar?</td>
						<td class="text-uppercase font-weight-bold">${ keyEvento.getMostrar() }</td>
					</tr>
				</table>
	  		</form:form>
        
        </div>
          	
			<div class="col-md-6">
				
				<!-- CARROUSEL -->
				<div id="carousel" class="carousel slide" data-ride="carousel">
					<div class="carousel-inner">
					
						<div class="carousel-item active">
							<img class="d-block img-fluid w-100" src="img/${ keyEvento.getImagen1() }" />
							<div class="carousel-caption"><h3>IMG 1: ${ keyEvento.getImagen1() }</h3></div>
						</div>

						<div class="carousel-item">
							<img class="d-block img-fluid w-100" src="img/${ keyEvento.getImagen2() }" />
							<div class="carousel-caption"><h3>IMG 2: ${ keyEvento.getImagen2() }</h3></div>
						</div>
						
						<div class="carousel-item">
							<img class="d-block img-fluid w-100" src="img/${ keyEvento.getImagen3() }" />
							<div class="carousel-caption"><h3>IMG 3: ${ keyEvento.getImagen3() }</h3></div>
						</div>
						
					</div>
					
					<a class="carousel-control-prev" href="#carousel" role="button" data-slide="prev"> 
						<span class="carousel-control-prev-icon"></span>
						<span class="sr-only">Anterior</span>
					</a> 
					<a class="carousel-control-next" href="#carousel" role="button" data-slide="next"> 
						<span class="carousel-control-next-icon"></span>
						<span class="sr-only">Siguente</span>
					</a>
				</div>
			
			    <!--The div element for the map -->
			    <div id="map"></div>
		    
  			</div>

      </div>
      <div>
      		<h4><a href=<c:url value="homeAdmin" /> >Volver a la lista</a></h4>
      		<!-- tambien funciona asi: <h4><a href="./homeAdmin">Volver a la lista</a></h4> -->
      		
      </div>
    </div>
  </div>

  <br/>
  
  

	<!-- SCRIPT GOOGLE MAPS API ***************************************************** -->
	<script>
		// Initialize and add the map
		function initMap() {
	  		// The location of Uluru
	  		var uluru = {lat: -34.6704143 }, lng: -58.56292880000001 }};
	  		// The map, centered at Uluru
	  		var map = new google.maps.Map( document.getElementById('map'), {zoom: 16, center: uluru} );
	  		// The marker, positioned at Uluru
	  		var marker = new google.maps.Marker({position: uluru, map: map});
		}
    </script>
    <!--Load the API from the specified URL
    * The async attribute allows the browser to render the page while the API loads
    * The key parameter will contain your own API key (which is not needed for this tutorial)
    * The callback parameter executes the initMap() function
    -->
    <script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAKsOyLppGoYEHhTvwny8xDgKj96ZzSIFU&callback=initMap"></script>
  	<!--  ***************************************************************************  -->
  

<%@ include file="_footer.jsp" %>
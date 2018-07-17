<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>

<head>
  	<meta charset="utf-8">
  	<meta name="viewport" content="width=device-width, initial-scale=1">
  
  	<!--  	CSSs ACA 		************************************************************************* -->
	<link rel="stylesheet" href="css/bootstrap.min.css">
  	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" type="text/css">	
  	<link rel="stylesheet" href="css/theme.css" type="text/css">
	
	<!-- 	SCRIPTS ACA		************************************************************************* -->
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
  	<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
  	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
	<!-- script src="js/bootstrap.min.js" defer></script-->
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    
  	<!-- script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAKsOyLppGoYEHhTvwny8xDgKj96ZzSIFU&callback=initMap"> </script-->
    
</head>
<body>

<nav class="navbar navbar-expand-md bg-primary navbar-dark">
	<div class="container">
		<a class="navbar-brand" href="#"><i class="fa d-inline fa-lg fa-beer"></i><b>&nbsp;BARAPP</b></a>
      
      <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbar2SupportedContent">
      		<span class="navbar-toggler-icon"></span>
      </button>
      
      <div class="collapse navbar-collapse text-center justify-content-end" id="navbar2SupportedContent">
        <ul class="navbar-nav">
          	<c:if test="${ empty nombre }">
	          	<li class="nav-item"><a class="nav-link" href="registroUsuario"><i class="fa d-inline fa-lg fa-sign-in"></i> Registrarme</a></li>
          	</c:if>
          	<c:if test="${ not empty nombre }">
	          	<li> Bienvenido, ${ nombre } </li>
          	</c:if>
          	
        </ul>
        
       <c:if test="${not empty nombre}">
	        <a class="btn navbar-btn ml-2 text-white btn-secondary" href="desloguearse"><i class="fa fa-user-times"></i>&nbsp;Cerrar Sesion</a>
	          
			<c:if test="${not empty foto}">
		          <div class="col-md-1">	 
					   <div class="card"><img class="card-img-top" src="img/${foto}" alt="Card image cap"></div>
				 </div>
			</c:if>
			 
		</c:if>
	         
		<c:if test="${empty nombre}">
			<a class="btn navbar-btn ml-2 text-white btn-secondary" href="login">
			<i class="fa d-inline fa-lg fa-user-circle-o"></i>&nbsp;Login</a>
		</c:if>
	      
      </div>
    </div>
</nav>
  
  <div class="">
    <div class="container">
      <div class="row">
        <div class="col-md-12">
          <ul class="nav nav-pills">
            <li class="nav-item">
              <a href="inicioHome" class="nav-link">
                <i class="fa fa-home fa-home"></i>&nbsp;Inicio</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">Eventos
                <br>
              </a>
            </li>
            
            <c:if test="${ not empty nombre }">
	          	<li class="nav-item"><a class="nav-link" href="misEventos">Mis Eventos<br></a></li>
          	</c:if>
            
            <li class="nav-item">
              <a href="#" class="nav-link">Nosotros</a>
            </li>
            <li class="nav-item">
              <a href="#" class="nav-link">Contacto</a>
            </li>
            
            <c:if test="${not empty admin }">
            	<li class="nav-item"><a href="homeAdmin" class="nav-link">_Menu Admin_</a></li>
            </c:if>
            
            <%-- <c:if test="${not empty user}">
            	<li class="nav-item"><a href="homeUsuario" class="nav-link">Menu Usuario</a></li>
            </c:if> --%>
            
          </ul>
        </div>
      </div>
    </div>
  </div>
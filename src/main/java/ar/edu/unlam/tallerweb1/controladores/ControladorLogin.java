package ar.edu.unlam.tallerweb1.controladores;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;

@Controller
public class ControladorLogin {

	
	// La anotacion @Inject indica a Spring que en este atributo se debe setear (inyeccion de dependencias)
	// un objeto de una clase que implemente la interface ServicioLogin, dicha clase debe estar anotada como
	// @Service o @Repository y debe estar en un paquete de los indicados en applicationContext.xml
	@Inject
	private ServicioLogin servicioLogin;

	
	public ServicioLogin getServicioLogin() {
		return servicioLogin;
	}

	public void setServicioLogin(ServicioLogin servicioLogin) {
		this.servicioLogin = servicioLogin;
	}

	
	// Este metodo escucha la URL localhost:8080/NOMBRE_APP/login si la misma es invocada por metodo http GET
	@RequestMapping("/login")
	public ModelAndView irALogin() {

		ModelMap modelo = new ModelMap();
		// Se agrega al modelo un objeto del tipo Usuario con key 'usuario' para que el mismo sea asociado
		// al model attribute del form que esta definido en la vista 'login'
		Usuario usuario = new Usuario();
		modelo.put("usuario", usuario);
		// Se va a la vista login (el nombre completo de la lista se resuelve utilizando el view resolver definido en el archivo spring-servlet.xml)
		// y se envian los datos a la misma  dentro del modelo
		return new ModelAndView("login", modelo);
	}

	
	// Este metodo escucha la URL validar-login siempre y cuando se invoque con metodo http POST
	// El método recibe un objeto Usuario el que tiene los datos ingresados en el form correspondiente y se corresponde con el modelAttribute definido en el
	// tag form:form
	@RequestMapping(path = "/validar-login", method = RequestMethod.POST)
	public ModelAndView validarLogin(@ModelAttribute("usuario") Usuario usuario, HttpServletRequest request) {
		ModelMap model = new ModelMap();
		// invoca el metodo consultarUsuario del servicio y hace un redirect a la URL /home, esto es, en lugar de enviar a una vista
		// hace una llamada a otro action a traves de la URL correspondiente a ésta
		Usuario usuarioBuscado = servicioLogin.consultarUsuario(usuario);
		if (usuarioBuscado != null) {
			request.getSession().setAttribute("nombre", usuarioBuscado.getNombre());
			request.getSession().setAttribute("idUsuario", usuarioBuscado.getId());
			request.getSession().setAttribute("foto", usuarioBuscado.getFoto());
		    //request.getSession().setAttribute("rol", usuarioBuscado.getRol());
		    String rol = usuarioBuscado.getRol();
			    if(rol.equalsIgnoreCase("admin") ) {
			    	// le agrego un tiempo de vida a la session
					request.getSession().setMaxInactiveInterval(120);
					request.getSession().setAttribute("admin", "es admin" );
					return new ModelAndView("redirect:/homeAdmin");
			    }else {
			    	request.getSession().setAttribute("user", "es user" );
					request.getSession().setMaxInactiveInterval(600);
					//return new ModelAndView("redirect:/homeUsuario");
					return new ModelAndView("redirect:/inicioHome");
			    }
		} else {
			// si el usuario no existe agrega un mensaje de error en el modelo.
			model.put("error", "Usuario o clave incorrecta");
		}
		return new ModelAndView("login", model);
	}
	
	
//	@RequestMapping("/homeUsuario")
//	public ModelAndView iraMenuUsuario() {
//		ModelMap modelo = new ModelMap();
//		// Se agrega al modelo un objeto del tipo Usuario con key 'usuario' para que el mismo sea asociado
//		// al model attribute del form que esta definido en la vista 'login'
//		Usuario usuario = new Usuario();
//		modelo.put("usuario", usuario);
//		// Se va a la vista login (el nombre completo de la lista se resuelve utilizando el view resolver definido en el archivo spring-servlet.xml)
//		// y se envian los datos a la misma  dentro del modelo
//		return new ModelAndView("homeUsuario", modelo);
//	}
	
	
	//deslogueo al usuario mata a la session actual
	@RequestMapping(path = "/desloguearse")
	public ModelAndView desloguearse(HttpServletRequest request) {
		request.getSession().invalidate();
		return new ModelAndView("redirect:/inicioHome");
	}
	
	
	//Cargo el modelo al Registro
	@RequestMapping(path = "/registroUsuario")
	public ModelAndView RegistroUsuario() {
		Usuario usuario = new Usuario();
		ModelMap modelo = new ModelMap();
		modelo.put("usuarioRegistro",usuario);		
		
		return new ModelAndView ("registroUsuario",modelo);
	}
	
	
	//Cargo los datos del registro a la vista de usuarios
	@RequestMapping(path = "/registrovalidar", method = RequestMethod.POST)
	public ModelAndView cargarDatosUsuario(@ModelAttribute("usuarioRegistro")Usuario usuarioReg, HttpServletRequest request) {
		 ModelMap model = new ModelMap();
		 String email = usuarioReg.getEmail();
		 if (servicioLogin.validarUsuario(email) == null) {
		    servicioLogin.registrarUsuario(usuarioReg);
		    request.getSession().setAttribute("mensaje","bienvenido inicia sesion");
		    
		    return new ModelAndView ("redirect:login");
		 }
		 
		 else { 
			 model.put("error", "Email en uso - intente nuevamente"); 
		 }
		 
		 return new ModelAndView ("registroUsuario", model);
	}


}

package ar.edu.unlam.tallerweb1.controladores;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Carrito;
import ar.edu.unlam.tallerweb1.modelo.Evento;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioCarrito;
import ar.edu.unlam.tallerweb1.servicios.ServicioEvento;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;


@Controller
public class ControladorCarrito {
	
	
	@Inject
	private ServicioEvento servicioEvento;
	
	@Inject
	private ServicioCarrito servicioCarrito;
	
	@Inject
	private ServicioUsuario servicioUsuario;
	

	public ServicioCarrito getServicioCarrito() {
		return servicioCarrito;
	}

	public void setServicioCarrito(ServicioCarrito servicioCarrito) {
		this.servicioCarrito = servicioCarrito;
	}
	
	public ServicioEvento getServicioEvento() {
		return servicioEvento;
	}

	public void setServicioEvento(ServicioEvento servicioEvento) {
		this.servicioEvento = servicioEvento;
	}
	
	
	
	// AGREGAR EVENTO CARRITO
	@RequestMapping(path = "/agregarEventoAlCarrito")
	public ModelAndView agregarEventoAlCarrito(@RequestParam("id") Long idEvento, HttpServletRequest request) {		
		
		Long idUsuario = (Long) request.getSession().getAttribute("idUsuario");
		Usuario usuario = servicioUsuario.buscarUsuarioXIdSERVICE(idUsuario);
		Evento evento = servicioEvento.buscarEventoPorIdService(idEvento);
		servicioCarrito.agregarEventoACarritoSERVICE(usuario, evento);

		return new ModelAndView("redirect:/misEventos");
	}
	
	
	// LISTAR EVENTOS POR USUARIO
	@RequestMapping(path="/misEventos")
	public ModelAndView misEventos(HttpServletRequest request){ 
		
		Long idUsuario = (Long) request.getSession().getAttribute("idUsuario");
		Usuario usuario = servicioUsuario.buscarUsuarioXIdSERVICE(idUsuario);
		List<Carrito> listadoDelCarrito = servicioCarrito.listarEventosDeCarritoXUsuarioSERVICE(usuario);
		
		ModelMap model = new ModelMap();
		model.put("keyListadoCarritoDelUsuario", listadoDelCarrito );
		
		return new ModelAndView("misEventos",model);
	 }
	
	
	// ELIMINAR EVENTO DE CARRITO
	@RequestMapping(path = "/eliminarEventoDeCarrito")
	public ModelAndView eliminarEventoDeCarrito(@RequestParam("id") Long idCarrito) {

		servicioCarrito.eliminarEventoDeCarritoSERVICE(idCarrito);

		return new ModelAndView("redirect:/misEventos");
	}
	
	
	// VACIAR CARRITO
	@RequestMapping(path = "/vaciarCarrito")
	public ModelAndView vaciarCarrito(HttpServletRequest request) {
		
		Long idUser = (Long) request.getSession().getAttribute("idUsuario");
		Usuario usuario = servicioUsuario.buscarUsuarioXIdSERVICE(idUser);
		servicioCarrito.vaciarCarritoSERVICE(usuario);

		return new ModelAndView("redirect:/misEventos");
	}
	
	

	
}

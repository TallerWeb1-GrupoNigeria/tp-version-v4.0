package ar.edu.unlam.tallerweb1.controladores;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Direccion;
import ar.edu.unlam.tallerweb1.modelo.Evento;
import ar.edu.unlam.tallerweb1.modelo.UbicacionJson;
import ar.edu.unlam.tallerweb1.servicios.ServicioEvento;

@Controller
public class ControladorEvento {
	
	@Inject
	private ServicioEvento servicioEvento;
	
	public ServicioEvento getServicioEvento() {
		return servicioEvento;
	}

	public void setServicioEvento(ServicioEvento servicioEvento) {
		this.servicioEvento = servicioEvento;
	}


	// FORMULARIO PARA LA CREACION DEL EVENTO
	@RequestMapping(path = "/crearEvento")
	public ModelAndView crearEvento(HttpServletRequest request) {

		Evento evento = new Evento();
		Direccion direccion = new Direccion();
		evento.setDireccion(direccion);
		ModelMap model = new ModelMap();

		model.put("keyEvento", evento);
		
		return new ModelAndView ("crearEvento",model);
	}
	
	// DATOS CARGADOS DEL EVENTO VAN A LA BASE DE DATOS
	@RequestMapping(path="/crearEvento", method= RequestMethod.POST)
	public ModelAndView CargarEventoABD(@ModelAttribute("keyEvento") Evento evento , HttpServletRequest request){
		
		ModelMap modelo = new ModelMap();
		
		String nro_calle = (String)request.getSession().getAttribute( "street_number");
		String calle =(String)request.getSession().getAttribute( "route");
		String localidad = (String)request.getSession().getAttribute( "administrative_area_level_1");
		
		if (evento.getDescripcion().equals("") || nro_calle.equals("") || calle.equals("") || localidad.equals("") ){
			modelo.put("keyMsjEvento", "El fomulario no esta completo");
		}else{
			Direccion d = new Direccion();
			
			d.setFormatted_address			((String)request.getSession().getAttribute( "formatted_address"));
			d.setLatitud					((String)request.getSession().getAttribute( "latitud"));	
			d.setLongitud					((String)request.getSession().getAttribute( "longitud"));
			d.setStreet_number				((String)request.getSession().getAttribute( "street_number"));
			d.setRoute						((String)request.getSession().getAttribute( "route"));
			d.setLocality					((String)request.getSession().getAttribute( "locality"));	
			d.setAdministrative_area_level_1((String)request.getSession().getAttribute( "administrative_area_level_1"));	
			d.setCountry					((String)request.getSession().getAttribute( "country"));	
			d.setPostal_code				((String)request.getSession().getAttribute( "postal_code"));	
			
			evento.setDireccion(d);
			
			servicioEvento.crearEventoService(evento);
				
			return new ModelAndView("redirect:/homeAdmin");
		}
		return new ModelAndView("crearEvento", modelo);
	}
	
	@RequestMapping(path = "/valida-direccion",method=RequestMethod.POST)
	public ModelAndView validarDireccion(@RequestBody UbicacionJson ubicacion, HttpServletRequest request, @ModelAttribute("keyEvento") Evento evento) {
				
		System.out.println("dire:"+ubicacion.getFormatted_address());
		request.getSession().setAttribute("msjDireccion", "");
		if (ubicacion.getStreet_number().equals("") || ubicacion.getRoute().equals("") || ubicacion.getAdministrative_area_level_1().equals("") ) {
			request.getSession().setAttribute( "street_number"				, ubicacion.getStreet_number());
		    request.getSession().setAttribute( "route"						, ubicacion.getRoute());
		    request.getSession().setAttribute( "administrative_area_level_1", ubicacion.getAdministrative_area_level_1());
		}else{
			
			request.getSession().setAttribute( "formatted_address"			, ubicacion.getFormatted_address());
		    request.getSession().setAttribute( "latitud"					, ubicacion.getLatitud());
		    request.getSession().setAttribute( "longitud"					, ubicacion.getLongitud());
		    request.getSession().setAttribute( "street_number"				, ubicacion.getStreet_number());
		    request.getSession().setAttribute( "route"						, ubicacion.getRoute());
		    request.getSession().setAttribute( "locality"					, ubicacion.getLocality());
		    request.getSession().setAttribute( "administrative_area_level_1", ubicacion.getAdministrative_area_level_1());
		    request.getSession().setAttribute( "country"					, ubicacion.getCountry());
		    request.getSession().setAttribute( "postal_code"				, ubicacion.getPostal_code());
		}
		
		
		return new ModelAndView ("redirect:/crearEvento");
	}
	
	// EDITAR EVENTO
	@RequestMapping(value = "/actualizarEvento")
	public ModelAndView actualizarEvento( @RequestParam("id") Long id) {
		
		Evento evento = servicioEvento.buscarEventoPorIdService(id);
		ModelMap model = new ModelMap();
		model.put("keyEvento", evento);
		
		return new ModelAndView("actualizarEvento", model);
	}
	
	
	@RequestMapping(path = "/validarActualizarEvento", method = RequestMethod.POST)
	public ModelAndView validarActualizarEvento(@ModelAttribute("evento") Evento evento) {
		
		servicioEvento.actualizarEventoService(evento);		

		return new ModelAndView("redirect:/homeAdmin");

	}
	
	// MOSTRAR DETALLE DEL EVENTO
	@RequestMapping(path = "/detalleEvento")
	public ModelAndView detalleEvento(@RequestParam("id") Long id) {
		
		ModelMap model = new ModelMap();
		Evento evento = servicioEvento.buscarEventoPorIdService(id);
		model.put("keyEvento", evento);
		
		return new ModelAndView("detalleEvento", model);
	}
	
	
	// BUSCAR EVENTOS
	@RequestMapping(path = "/filtros-Busqueda", method = RequestMethod.POST)
	public ModelAndView buscarEventos(@ModelAttribute("evento") Evento evento) {
		ModelMap model = new ModelMap();
		
		List<Evento> ResultadoDeEventos = servicioEvento.buscarEventosService(evento.getNombre());
		
		if(ResultadoDeEventos.size() == 0) {
			
			model.put("error", "No se ecnontraron resultados con los parametros ingresados");
			
			
		}else {
			
			model.put("keyListarEventos", ResultadoDeEventos);
			
		}
		
		return new ModelAndView("inicio", model);
	}

	//public ModelAndView validarActualizarEvento(@ModelAttribute("evento") Evento evento, HttpServletRequest request) {
	public ModelAndView validarActualizarEvento(@ModelAttribute("evento") Evento evento, HttpServletRequest request) {
		
		servicioEvento.actualizarEventoService(evento);		

		return new ModelAndView("redirect:/homeAdmin");

	}
	

	
	
} // FIN CONTROLLER

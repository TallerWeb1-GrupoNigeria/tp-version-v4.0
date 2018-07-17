package ar.edu.unlam.tallerweb1.controladores;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Evento;
import ar.edu.unlam.tallerweb1.servicios.ServicioEvento;

@Controller
public class ControladorHome {

	
	@Inject
	private ServicioEvento servicioEvento;

	
	// Escucha la url /, y redirige a la URL /login, es lo mismo que si se invoca la url /login directamente.
	@RequestMapping(path = "/", method = RequestMethod.GET)
	public ModelAndView inicio() {
		return new ModelAndView("redirect:/inicioHome");
	}
	
	
	// Escucha la URL /home por GET, y redirige a una vista.
	@RequestMapping(path = "/home", method = RequestMethod.GET)
	public ModelAndView irAHome() {
		return new ModelAndView("home");
	}

	
	@RequestMapping(path = "/inicio", method = RequestMethod.GET)
	public ModelAndView irAInicio() {
		return new ModelAndView("inicio");
	}
	
	
	@RequestMapping(path = "/inicioHome")
	public ModelAndView inicio(@ModelAttribute("evento") Evento evento) {
		
		ModelMap model = new ModelMap();
		
	//	model.put("keySelectPrestaciones", servicioPrestacion.listarPrestacionService());
		
		model.put("keyListarEventos", servicioEvento.listarTodosEventosService());

		List<Evento> listaCorru1 = servicioEvento.listarEventosCarrouselService();
		if (!listaCorru1.isEmpty()) {
			Evento eve1;
			Evento eve2;
			Evento eve3;
			eve1 = listaCorru1.get(0);
			eve2 = listaCorru1.get(1);	
			eve3 = listaCorru1.get(2);
			
			model.put("keyEventos1", eve1);
			model.put("keyEventos2", eve2);
			model.put("keyEventos3", eve3);
		}else{
			
			model.put("errorlista", "lista vacia");
		}
		
		return new ModelAndView ("inicio",model);
	}

	@RequestMapping(path="/homeAdmin")
	public ModelAndView homeAdmin(){ 
		
		ModelMap model = new ModelMap();
		model.put("keyListarEventos", servicioEvento.listarTodosEventosService());
		
		//model.put("keySelectPrestaciones", servicioPrestacion.listarPrestacionService());
		return new ModelAndView("homeAdmin",model);
	 }
		
	

}

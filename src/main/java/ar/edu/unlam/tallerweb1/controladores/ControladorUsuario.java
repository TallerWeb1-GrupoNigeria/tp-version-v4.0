package ar.edu.unlam.tallerweb1.controladores;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;


@Controller
public class ControladorUsuario {
	
	
	@Inject
	ServicioUsuario servicioUsuario;
	
	
	// LISTAR TODOS LOS USUARIOS
	@RequestMapping(path = "/listarUsuarios")
	public ModelAndView listarUsuarios() {
		
		ModelMap model = new ModelMap();
		model.put("keyListarUsuarios", servicioUsuario.listarTodosLosUsuariosSERVICE());
		
		return new ModelAndView ("listarUsuarios",model);
	}
	
	
}
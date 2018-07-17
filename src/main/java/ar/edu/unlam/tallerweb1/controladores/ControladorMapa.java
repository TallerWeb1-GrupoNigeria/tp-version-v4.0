package ar.edu.unlam.tallerweb1.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Direccion;


@Controller
public class ControladorMapa {
	@RequestMapping(path = "/valida-direccion")
	public ModelAndView crearDireccion() {
		
		Direccion direccion = new Direccion();
		
		ModelMap model = new ModelMap();
		model.put("keyDirecion", direccion);
		
		return new ModelAndView ("crearEvento",model);
	}
	
//	@RequestMapping(path = "/valida-direccion",method=RequestMethod.POST)
//	public ModelAndView validarDireccion(@RequestBody UbicacionJson ubicacion, HttpServletRequest request, @ModelAttribute("keyDirecion") Direccion direccion) {
//		
//		ModelMap model = new ModelMap();
//
//		System.out.println("dire:"+ubicacion.getFormatted_address());
//		
//		if (ubicacion.getStreet_number().equals("") || ubicacion.getRoute().equals("") || ubicacion.getAdministrative_area_level_1().equals("") ) {
//			model.put("error", "La dirección esta incompleta.");
//			
//		}else{
//			request.getSession().setAttribute( "formatted_address"			, ubicacion.getFormatted_address());
//		    request.getSession().setAttribute( "latitud"					, ubicacion.getLatitud());
//		    request.getSession().setAttribute( "longitud"					, ubicacion.getLongitud());
//		    request.getSession().setAttribute( "street_number"				, ubicacion.getStreet_number());
//		    request.getSession().setAttribute( "route"						, ubicacion.getRoute());
//		    request.getSession().setAttribute( "locality"					, ubicacion.getLocality());
//		    request.getSession().setAttribute( "administrative_area_level_1", ubicacion.getAdministrative_area_level_1());
//		    request.getSession().setAttribute( "country"					, ubicacion.getCountry());
//		    request.getSession().setAttribute( "postal_code"				, ubicacion.getPostal_code());
//		    
//		   
//			
//			model.put("ok", "La direción es valida!");
//			
//		}
//		
//		return new ModelAndView ("crearEvento",model);
//	}

}

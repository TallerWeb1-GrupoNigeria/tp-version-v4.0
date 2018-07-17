package ar.edu.unlam.tallerweb1;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.controladores.ControladorEvento;
import ar.edu.unlam.tallerweb1.modelo.Evento;
import ar.edu.unlam.tallerweb1.servicios.ServicioEvento;

public class EventoControllerMock extends SpringTest {

    HttpServletRequest requestMock = mock(HttpServletRequest.class);
    HttpSession sessionMock = mock(HttpSession.class);
    Evento eventoMock = mock(Evento.class);

    ServicioEvento servicioEventoMock = mock(ServicioEvento.class);
    
    ControladorEvento controladorEvento = new ControladorEvento();
	
    
    @Before
	public void init(){
	controladorEvento.setServicioEvento(servicioEventoMock);
	}
	
	
	@Test
	@Transactional
    @Rollback(true)
	public void alCargarEventoABDDeberiaIrAHomeAdmin() {
		
		servicioEventoMock.crearEventoService(eventoMock);
		//ModelAndView mav = controladorEvento.CargarEventoABD(eventoMock);
		//assertThat(mav.getViewName()).isEqualTo("redirect:/homeAdmin");	
	}
	
	
	@Test
	@Transactional
    @Rollback(true)
	public void alActualizarEventoDeberiaIrALaVistaActualizarEvento() {
		
		when(servicioEventoMock.buscarEventoPorIdService(eventoMock.getId())).thenReturn(eventoMock);
		ModelAndView mav = controladorEvento.actualizarEvento(eventoMock.getId());
		assertThat(mav.getViewName()).isEqualTo("actualizarEvento");	
	}
	
	
	@Test
	@Transactional
    @Rollback(true)
	public void alValidarLaActualizacionDelEventoDeberiaIrAHomeAdmin() {
		
		servicioEventoMock.actualizarEventoService(eventoMock);
		ModelAndView mav = controladorEvento.validarActualizarEvento(eventoMock, requestMock);
		assertThat(mav.getViewName()).isEqualTo("redirect:/homeAdmin");	
	}
	
	
	@Test
	@Transactional
    @Rollback(true)
	public void alIrADetalleDelEventoDeberiaIrALaVistaDetalleEvento() {
		
		when(servicioEventoMock.buscarEventoPorIdService(eventoMock.getId())).thenReturn(eventoMock);
		ModelAndView mav = controladorEvento.detalleEvento(eventoMock.getId());
		assertThat(mav.getViewName()).isEqualTo("detalleEvento");	
	}
	
	
	@Test
	@Transactional
    @Rollback(true)
	public void alBuscarEventosDeberiaIrALaVistaInicio() {
		
		//when(servicioEventoMock.buscarEventosService(eventoMock.getNombre())).thenReturn(List<eventoMock>);
		ModelAndView mav = controladorEvento.buscarEventos(eventoMock);
		assertThat(mav.getViewName()).isEqualTo("inicio");	
	}

	
	
	
	
	
	
}

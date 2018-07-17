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

import ar.edu.unlam.tallerweb1.controladores.ControladorCarrito;
import ar.edu.unlam.tallerweb1.modelo.Carrito;
import ar.edu.unlam.tallerweb1.modelo.Evento;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioCarrito;
import ar.edu.unlam.tallerweb1.servicios.ServicioEvento;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;


public class CarritoControllerMock extends SpringTest {
	
    HttpServletRequest requestMock = mock(HttpServletRequest.class);
    HttpSession sessionMock = mock(HttpSession.class);
    Usuario usuarioMock = mock(Usuario.class);
    Evento eventoMock = mock(Evento.class);
    Carrito carritoMock = mock(Carrito.class);
    
    ServicioCarrito servicioCarritoMock = mock(ServicioCarrito.class);
    ServicioEvento servicioEventoMock = mock(ServicioEvento.class);
    ServicioUsuario servicioUsuarioMock = mock(ServicioUsuario.class);
    
    ControladorCarrito controladorCarrito = new ControladorCarrito();
	
    
    @Before
	public void init(){
	controladorCarrito.setServicioCarrito(servicioCarritoMock);
	controladorCarrito.setServicioEvento(servicioEventoMock);
	}
	
    
    @Test
    @Transactional
    @Rollback(true)
    public void agregarEventoAlCarritoDeberiaIrAMisEventos() {
    	when(requestMock.getSession()).thenReturn(sessionMock);
        
    	when(servicioEventoMock.buscarEventoPorIdService(eventoMock.getId())).thenReturn(eventoMock);
        when(servicioUsuarioMock.buscarUsuarioXIdSERVICE((Long) requestMock.getSession().getAttribute("idUsuario"))).thenReturn(usuarioMock);
        servicioCarritoMock.agregarEventoACarritoSERVICE(usuarioMock, eventoMock);
        requestMock.setAttribute("idUsuario", usuarioMock.getId());
    
        
        ModelAndView mav = controladorCarrito.agregarEventoAlCarrito(eventoMock.getId(), requestMock);
        assertThat(mav.getViewName()).isEqualTo("redirect:/misEventos");
    }
    
    
    @Test
    @Transactional
    @Rollback(true)
    public void alEliminarEventoDelCarritoDeberiaIraMisEventos() {
        when(requestMock.getSession()).thenReturn(sessionMock);
        
        servicioCarritoMock.eliminarEventoDeCarritoSERVICE(carritoMock.getId());
        
        ModelAndView mav = controladorCarrito.eliminarEventoDeCarrito(carritoMock.getId());
        assertThat(mav.getViewName()).isEqualTo("redirect:/misEventos");
    }
    
    
    @Test
    @Transactional
    @Rollback(true)
    public void alVaciarCarritoDeberiaIrAMisEventos() {
        when(requestMock.getSession()).thenReturn(sessionMock);
        
        when(servicioUsuarioMock.buscarUsuarioXIdSERVICE((Long) requestMock.getSession().getAttribute("idUsuario"))).thenReturn(usuarioMock);
        servicioCarritoMock.vaciarCarritoSERVICE(usuarioMock);
        
        ModelAndView mav = controladorCarrito.vaciarCarrito(requestMock);
        assertThat(mav.getViewName()).isEqualTo("redirect:/misEventos");
    }
    

}

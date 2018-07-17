/*package ar.edu.unlam.tallerweb1.ServicesMockTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.dao.EventoDao;
import ar.edu.unlam.tallerweb1.modelo.Evento;
import ar.edu.unlam.tallerweb1.servicios.ServicioEvento;
import ar.edu.unlam.tallerweb1.servicios.ServicioEventoImpl;

public class EventoServicesMock extends SpringTest {
	
	Evento eventoMock = mock(Evento.class);

	@Mock
	private EventoDao eventoDaoMock;
    
	@InjectMocks
    private ServicioEvento servicioEventoMock;
	private SessionFactory sessionFactoryMock;

    @Before
	public void init(){
    	MockitoAnnotations.initMocks(this);
	}
	
	
	@Test
	@Transactional
    @Rollback(true)
	public void testCrearEventoDevuelveUnNuevoEvento() {
		//when(sessionFactoryMock.getCurrentSession().save(eventoMock)).thenReturn(eventoMock);
		eventoDaoMock.crearEvento(eventoMock);
		
		//assertThat(servicioEventoMock.crearEventoService(eventoMock));
		
	}

}
*/
package ar.edu.unlam.tallerweb1;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.EventoDao;
import ar.edu.unlam.tallerweb1.modelo.Evento;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/test-applicationContext.xml" })
public class EventoDAOTest {

	@Inject
	private EventoDao eventoDao;
	
	
	@Test
	@Transactional
	@Rollback(true)
	public void testCrearYListarEventos() {
		
		// INICIALIZACION
		Evento evento1 = new Evento(1L,"PrimerEvento", "Este es el primer evento","01/01/2001","21:00","23:00");
		Evento evento2 = new Evento(2L,"SegundoEvento", "Este es el segundo evento","01/01/2001","21:00","23:00");
		Evento evento3 = new Evento(3L,"TercerEvento", "Este es el tercer evento","01/01/2001","21:00","23:00");
		
		// OPERACION
		eventoDao.crearEvento(evento1);
		eventoDao.crearEvento(evento2);
		eventoDao.crearEvento(evento3);
		
		//VERIFICACION
		List<Evento> listadoDeEventos = eventoDao.listarTodosLosEventos();
				
		assertThat(listadoDeEventos).hasSize(3);		
	}
	
	
	@Test
	@Transactional
	@Rollback(true)
	public void testBuscarEvento() {
		
		// INICIALIZACION
		Evento evento1 = new Evento(1L,"PrimerEvento", "Este es el primer evento","01/01/2001","21:00","23:00");
		Evento evento2 = new Evento(2L,"SegundoEvento", "Este es el segundo evento","01/01/2001","21:00","23:00");
		Evento evento3 = new Evento(3L,"TercerEvento", "Este es el tercer evento","01/01/2001","21:00","23:00");
		
		eventoDao.crearEvento(evento1);
		eventoDao.crearEvento(evento2);
		eventoDao.crearEvento(evento3);
		
		// OPERACION
		List<Evento> eventoBuscado = eventoDao.buscarEvento("SegundoEvento");

		
		//VERIFICACION	
		assertThat(eventoBuscado).hasSize(1);
		
		for (Evento e : eventoBuscado) {
			assertThat(e.getNombre()).isEqualTo("SegundoEvento");
		}
	}
	
	
	@Test
	@Transactional
	@Rollback(true)
	public void testBuscarEventoXId() {
		
		// INICIALIZACION
		Evento evento1 = new Evento(1L,"PrimerEvento", "Este es el primer evento","01/01/2001","21:00","23:00");
		Evento evento2 = new Evento(2L,"SegundoEvento", "Este es el segundo evento","01/01/2001","21:00","23:00");
		Evento evento3 = new Evento(3L,"TercerEvento", "Este es el tercer evento","01/01/2001","21:00","23:00");
		
		eventoDao.crearEvento(evento1);
		eventoDao.crearEvento(evento2);
		eventoDao.crearEvento(evento3);
		
		// OPERACION
		Evento eventoBuscado = eventoDao.buscarEventoPorId(evento1.getId());

		//VERIFICACION	
		assertThat(eventoBuscado.getNombre()).isEqualTo("PrimerEvento");
		
	}
	
	
	@Test
	@Transactional
	@Rollback(true)
	public void testActualizarEvento() {
		
		// INICIALIZACION
		Evento evento1 = new Evento(1L,"PrimerEvento", "Este es el primer evento","01/01/2001","21:00","23:00");
		Evento evento2 = new Evento(2L,"SegundoEvento", "Este es el segundo evento","01/01/2001","21:00","23:00");
		Evento evento3 = new Evento(3L,"TercerEvento", "Este es el tercer evento","01/01/2001","21:00","23:00");
		
		eventoDao.crearEvento(evento1);
		eventoDao.crearEvento(evento2);
		eventoDao.crearEvento(evento3);
		
		// OPERACION
		evento2.setNombre("SegundoEventoCambiado");
		eventoDao.actualizarEvento(evento2);

		//VERIFICACION	
		assertThat(evento2.getNombre()).isEqualTo("SegundoEventoCambiado");
	}
	

}		// FIN EVENTO TEST



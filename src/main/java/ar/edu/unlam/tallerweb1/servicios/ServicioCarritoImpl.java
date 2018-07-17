package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.CarritoDao;
import ar.edu.unlam.tallerweb1.modelo.Carrito;
import ar.edu.unlam.tallerweb1.modelo.Evento;
import ar.edu.unlam.tallerweb1.modelo.Usuario;


@Service("servicioCarrito")
@Transactional
public class ServicioCarritoImpl implements ServicioCarrito {

	
	@Inject
	private CarritoDao carritoDao;
	
	
	@Override
	public void agregarEventoACarritoSERVICE(Usuario usuario, Evento evento) {
		carritoDao.agregarEventoACarrito(usuario, evento);
	}
	
	@Override
	public List<Carrito> listarTodoCarritoSERVICE() {
		return carritoDao.listarTodoCarrito();
	}
	
	@Override
	public void vaciarCarritoSERVICE(Usuario usuario) {
		carritoDao.vaciarCarrito(usuario);
	}
	
	@Override
	public void eliminarEventoDeCarritoSERVICE(Long idCarrito) {
		carritoDao.eliminarEventoDeCarrito(idCarrito);
	}
	
	@Override		
	public List<Carrito> listarEventosDeCarritoXUsuarioSERVICE(Usuario usuario) {
		return carritoDao.listarEventosDeCarritoXUsuario(usuario);
	}
	
	
	
}

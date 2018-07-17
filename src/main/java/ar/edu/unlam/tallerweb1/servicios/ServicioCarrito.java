package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Carrito;
import ar.edu.unlam.tallerweb1.modelo.Evento;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface ServicioCarrito {

	public void agregarEventoACarritoSERVICE(Usuario usuario, Evento evento);
	public List<Carrito> listarTodoCarritoSERVICE();
	public void vaciarCarritoSERVICE(Usuario usuario);
	public void eliminarEventoDeCarritoSERVICE(Long idCarrito);
	public List<Carrito> listarEventosDeCarritoXUsuarioSERVICE(Usuario usuario);

}

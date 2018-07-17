package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Carrito;
import ar.edu.unlam.tallerweb1.modelo.Evento;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface CarritoDao {
	
	public void crearCarrito(Carrito carrito);
	public void agregarEventoACarrito(Usuario usuario, Evento evento);
	public List<Carrito> listarTodoCarrito();
	public void vaciarCarrito(Usuario usuario);
	public void eliminarEventoDeCarrito(Long idCarrito);
	public List<Carrito> listarEventosDeCarritoXUsuario(Usuario usuario);

}

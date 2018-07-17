package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Evento;


public interface ServicioEvento	{

	public void crearEventoService(Evento evento);
	public List<Evento> listarTodosEventosService();
	public List<Evento> listarEventosCarrouselService();
	public void actualizarEventoService(Evento evento);
	public List<Evento> buscarEventosService(String dato);
	public Evento buscarEventoPorIdService(Long id);
	
}

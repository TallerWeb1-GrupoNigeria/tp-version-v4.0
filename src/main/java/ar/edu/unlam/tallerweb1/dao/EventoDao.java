package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Evento;


public interface EventoDao {

	public void crearEvento(Evento evento);
	public List<Evento> listarTodosLosEventos();
	public List<Evento> listarLosEventosCarusel();
	public void actualizarEvento(Evento evento);
	public List<Evento> buscarEvento(String ParametroNombre);
	public Evento buscarEventoPorId(Long id);
	
}

package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Prestacion;

public interface PrestacionDao {
	
	public void crearPrestacionService(Prestacion Prestacion);
	public List<Prestacion> listarPrestacionService();
	public void actualizarPrestacionService(Prestacion Prestacion);
	public List<Prestacion> buscarPrestacionService(String dato);
	public Prestacion buscarPrestacionPorIdService(Long id);
}

package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface ServicioUsuario {

	public void crearUsuarioSERVICE(Usuario usuario);
	public Usuario buscarUsuarioXIdSERVICE(Long id);
	public Usuario existeUsuarioEnBDSERVICE(Usuario usuario);
	public List<Usuario> listarTodosLosUsuariosSERVICE();
}

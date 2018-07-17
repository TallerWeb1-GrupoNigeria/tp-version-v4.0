package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Usuario;

// Interface que define los metodos del DAO de Usuarios.
public interface UsuarioDao {
	
	public void crearUsuario(Usuario usuario);
	public Usuario consultarUsuario (Usuario usuario);
	public Usuario buscarUsuarioXId(Long id);
	public Usuario existeUsuarioEnBD(Usuario usuario);
	public Usuario validarUsuario (String email);
	public void registrarUsuario(Usuario usuario);
	public Usuario buscarUsuarioPorId(Long id);
	public void actualizarUsuario(Usuario usuario);
	public List<Usuario> listarTodosLosUsuarios();
}

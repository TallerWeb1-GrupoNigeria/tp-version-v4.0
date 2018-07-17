package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.UsuarioDao;
import ar.edu.unlam.tallerweb1.modelo.Usuario;


@Service("servicioUsuario")
@Transactional
public class ServicioUsuarioImpl implements ServicioUsuario {

	
	@Inject
	private UsuarioDao usuarioDao;

	
	@Override
	public void crearUsuarioSERVICE(Usuario usuario) {
		usuarioDao.crearUsuario(usuario);
	}

	@Override
	public Usuario buscarUsuarioXIdSERVICE(Long id) {
		return usuarioDao.buscarUsuarioXId(id);
	}
	
	@Override
	public Usuario existeUsuarioEnBDSERVICE(Usuario usuario) {
		return usuarioDao.existeUsuarioEnBD(usuario);
	}
	
	@Override
	public List<Usuario> listarTodosLosUsuariosSERVICE() {
		return usuarioDao.listarTodosLosUsuarios();
	}

	
	

	
	
	
	
	
}

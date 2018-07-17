package ar.edu.unlam.tallerweb1.dao;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import javax.inject.Inject;

// implelemtacion del DAO de usuarios, la anotacion @Repository indica a Spring que esta clase es un componente que debe
// ser manejado por el framework, debe indicarse en applicationContext que busque en el paquete ar.edu.unlam.tallerweb1.dao
// para encontrar esta clase.
@Repository("usuarioDao")
public class UsuarioDaoImpl implements UsuarioDao {

	// Como todo dao maneja acciones de persistencia, normalmente estará inyectado el session factory de hibernate
	// el mismo está difinido en el archivo hibernateContext.xml
	@Inject
    private SessionFactory sessionFactory;

	
	@Transactional
	@Override
	public void crearUsuario(Usuario usuario) {
		Session session = sessionFactory.getCurrentSession();
		session.save(usuario);
	}	
	
	
	@Override
	public Usuario consultarUsuario(Usuario usuario) {

		// Se obtiene la sesion asociada a la transaccion iniciada en el servicio que invoca a este metodo y se crea un criterio
		// de busqueda de Usuario donde el email y password sean iguales a los del objeto recibido como parametro
		// uniqueResult da error si se encuentran más de un resultado en la busqueda.
		final Session session = sessionFactory.getCurrentSession();
		return (Usuario) session.createCriteria(Usuario.class)
				.add(Restrictions.eq("email", usuario.getEmail()))
				.add(Restrictions.eq("password", usuario.getPassword()))
				.uniqueResult();
	}
	
	@Transactional
	@Override
	public Usuario existeUsuarioEnBD(Usuario usuario) {
		final Session session = sessionFactory.getCurrentSession();
		Usuario usuarioExistente = (Usuario) session.createCriteria(Usuario.class)
									.add(Restrictions.eq("id", usuario.getId()))
									.uniqueResult();
		return usuarioExistente;
	}
	
	@Override
	public Usuario buscarUsuarioXId(Long id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Usuario.class, id);
	}
	@Transactional
	@Override
	public void registrarUsuario(Usuario usuario) {
		Session session = sessionFactory.getCurrentSession();
		session.save(usuario);
	}
	
	@Transactional
	@Override
	public Usuario buscarUsuarioPorId(Long id){
		Session session = sessionFactory.getCurrentSession();	
		return session.get(Usuario.class,id); 
	}
	
	@Transactional
	@Override
	public void actualizarUsuario(Usuario usuario) {
		Session session = sessionFactory.getCurrentSession();
		//evento.setMostrarEvento(mostrar);
		session.update(usuario);
	}


	//Validar registro de Mails
 	@Transactional(readOnly = true)	 
	@Override	 
	public Usuario validarUsuario(String email){
		  Session session = sessionFactory.getCurrentSession();
		  return (Usuario) session.createCriteria(Usuario.class)
			    .add(Restrictions.eq("email", email))
			    .setMaxResults(1)
	            .uniqueResult();
			 }
 	
 	
	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public List<Usuario> listarTodosLosUsuarios() {
		Session session = sessionFactory.getCurrentSession();
		List<Usuario> listado = session.createCriteria(Usuario.class).list();
		return listado;
	}

}

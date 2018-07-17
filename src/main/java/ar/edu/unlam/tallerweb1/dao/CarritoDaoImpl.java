package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.Carrito;
import ar.edu.unlam.tallerweb1.modelo.Evento;
import ar.edu.unlam.tallerweb1.modelo.Usuario;


@SuppressWarnings("unchecked")
@Repository("CarritoDao")
public class CarritoDaoImpl implements CarritoDao {

	@Inject
	private SessionFactory sessionFactory;
	
	Carrito carrito = new Carrito();
	
	
	@Transactional
	@Override
	public void crearCarrito(Carrito carrito) {
		Session session = sessionFactory.getCurrentSession();
		session.save(carrito);
	}
	
	
	@Transactional
	@Override
	public void agregarEventoACarrito(Usuario usuario, Evento evento) {
		Session session = sessionFactory.getCurrentSession();
		carrito.setUsuario(usuario);
		carrito.setEvento(evento);
		session.save(carrito);
	}
	
	
	@Transactional
	@Override
	public List<Carrito> listarTodoCarrito() {
		Session session = sessionFactory.getCurrentSession();
		List<Carrito> listado = session.createCriteria(Carrito.class).list();
		return listado;
	}
	
	
	@Transactional
	@Override
	public void eliminarEventoDeCarrito(Long idCarrito) {
		Session session = sessionFactory.getCurrentSession();
		Carrito carritoABorrar = session.get(Carrito.class, idCarrito);
		session.delete(carritoABorrar);
	}
	
	
	@Transactional
	@Override
	public void vaciarCarrito(Usuario usuario) {
		Session session = sessionFactory.getCurrentSession();
		
		List<Carrito> borrarListaCarritoDeUsuario = session.createCriteria(Carrito.class)
													.createAlias("usuario", "u")
													.add(Restrictions.eq("u.id", usuario.getId())).list();
		
		for (Carrito c : borrarListaCarritoDeUsuario) {
			session.delete(c);
		}
	}
	
	
	@Transactional
	@Override
	public List<Carrito> listarEventosDeCarritoXUsuario(Usuario usuario) {
		Session session = sessionFactory.getCurrentSession();
		List<Carrito> listado = session.createCriteria(Carrito.class)
								.createAlias("usuario", "u")
								.add(Restrictions.eq("u.id", usuario.getId()))
								.list();
		return listado;
	}
	
	
}

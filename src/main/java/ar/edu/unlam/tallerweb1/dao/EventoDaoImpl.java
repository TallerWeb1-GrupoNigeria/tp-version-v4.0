package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.Evento;


@SuppressWarnings("unchecked")
@Repository("EventoDao")
public class EventoDaoImpl implements EventoDao{

	@Inject
	private SessionFactory sessionFactory;

	
	@Transactional
	@Override
	public void crearEvento(Evento evento) {
		Session session = sessionFactory.getCurrentSession();
		session.save(evento);
	}
	
	
	@Transactional
	@Override
	public List<Evento> listarTodosLosEventos() {
		Session session = sessionFactory.getCurrentSession();
		List<Evento> listado = session.createCriteria(Evento.class)
								.list();
		return listado;
	}
	
	@Override
	public List<Evento> listarLosEventosCarusel() {
		Session session = sessionFactory.getCurrentSession();
		List<Evento> listado = session.createCriteria(Evento.class)				
								.addOrder(Order.asc("fecha"))
								.addOrder(Order.asc("horaInicio"))
								.setMaxResults(3)
								.list();
		return listado;
	}

	
	@Transactional
	@Override
	public void actualizarEvento(Evento evento) {
		Session session = sessionFactory.getCurrentSession();
		session.update(evento);
	}
	
	
	@Transactional
	@Override
	public List<Evento> buscarEvento(String ParametroNombre) {
		Session session = sessionFactory.getCurrentSession();
		List<Evento> eventosList = session.createCriteria(Evento.class)
									.add(Restrictions.like("nombre", "%"+ParametroNombre+"%")).list();
		return eventosList;
	}
	

	@Transactional
	@Override
	public Evento buscarEventoPorId(Long id){
		Session session = sessionFactory.getCurrentSession();
		
		return session.get(Evento.class,id); 
	}

	
}

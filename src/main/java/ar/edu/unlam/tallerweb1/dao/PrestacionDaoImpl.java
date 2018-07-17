package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.Prestacion;

@SuppressWarnings("unchecked")
@Repository("PrestacionDao")
public class PrestacionDaoImpl implements PrestacionDao {

	@Inject
	private SessionFactory sessionFactory;
	
	
	@Transactional
	@Override
	public void crearPrestacionService(Prestacion Prestacion) {
		// TODO Auto-generated method stub
		
	}

	
	@Transactional
	@Override
	public List<Prestacion> listarPrestacionService() {
		Session session = sessionFactory.getCurrentSession();
		List<Prestacion> resultado = session.createCriteria(Prestacion.class).list();
		return resultado;
	}

	
	@Transactional
	@Override
	public void actualizarPrestacionService(Prestacion Prestacion) {
		// TODO Auto-generated method stub
		
	}

	
	@Transactional
	@Override
	public List<Prestacion> buscarPrestacionService(String dato) {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Transactional
	@Override
	public Prestacion buscarPrestacionPorIdService(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}

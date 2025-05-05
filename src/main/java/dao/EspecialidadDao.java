package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Especialidad;

public class EspecialidadDao {
	private static Session session;
	private Transaction tx;
	
	private void iniciaOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}
	
	private void manejaExcepcion(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso a datos", he);
	}
	public int agregar(Especialidad objeto) {
		int id = 0;
		try {
			iniciaOperacion();
			session.persist(objeto);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
		} finally {
			session.close();
		}
		return id;
	}
	public void actualizar(Especialidad objeto) {
		try {
			iniciaOperacion();
			session.merge(objeto);
			tx.commit();
			
		} catch (HibernateException he) {
			manejaExcepcion(he);
		} finally {
			session.close();
		}
	}
	
	public void eliminar(Especialidad objeto) {
		try {
			iniciaOperacion();
			session.remove(objeto);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
		} finally {
			session.close();
		}
	}
	public Especialidad traer(long id) {
		Especialidad objeto = null;
		try {
			iniciaOperacion();
			objeto = (Especialidad) session.get(Especialidad.class, id);
			
		} finally {
			session.close();
		}
		return objeto;
	}
		
	public List<Especialidad> traerTodos(){
		List<Especialidad> especialidades = new ArrayList<>();
		
		try {
			iniciaOperacion();
			String query = "from Especialidad e order by e.id asc" ;
			especialidades = (List<Especialidad>) session.createQuery(query, Especialidad.class).getResultList();
		} finally {
			session.close();
		}
		
		return especialidades;
	}
		
}

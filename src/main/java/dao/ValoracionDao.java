package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Valoracion;

public class ValoracionDao {
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
	public int agregar(Valoracion objeto) {
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
	public void actualizar(Valoracion objeto) {
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
	
	public void eliminar(Valoracion objeto) {
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
	public Valoracion traer(long id) {
		Valoracion objeto = null;
		try {
			iniciaOperacion();
			objeto = (Valoracion) session.get(Valoracion.class, id);
			
		} finally {
			session.close();
		}
		return objeto;
	}
		
	public List<Valoracion> traerTodos(){
		List<Valoracion> valoraciones = new ArrayList<>();
		
		try {
			iniciaOperacion();
			String query = "from Valoracion v order by v.id asc" ;
			valoraciones = (List<Valoracion>) session.createQuery(query, Valoracion.class).getResultList();
		} finally {
			session.close();
		}
		
		return valoraciones;
	}
}

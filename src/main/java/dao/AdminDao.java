package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Admin;



public class AdminDao {
	private static Session session;
	private Transaction tx;
	
	private void iniciaOperacion() throws HibernateException{
		session = HibernateUtil.getSessionFactory().openSession(); 
		tx = session.beginTransaction(); 
	}
	
	private void manejaExcepcion (HibernateException he) throws HibernateException{
		tx.rollback();
		throw new HibernateException ("ERROR en la capa de acceso de datos", he); 
	}
	
	public void agregar(Admin admin) {
		try {
			iniciaOperacion(); 
			session.persist(admin);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he); 
			throw he; 
		}finally {
			session.close(); 
		}
	}
	
	public void actualizar(Admin admin) {
		try {
			iniciaOperacion();
			session.merge(admin);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
	}
	
	public void eliminar (Admin admin) {
		try {
			iniciaOperacion(); 
			session.remove(admin);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
	}
	
	
	public Admin traer (String cuil) {
		Admin a = null; 
		
		try {
			iniciaOperacion(); 
			a = session.get(Admin.class, cuil); 
		} catch (HibernateException he) {
			manejaExcepcion (he); 
		} finally {
			session.close();
		}
		return a; 
	}
	
}

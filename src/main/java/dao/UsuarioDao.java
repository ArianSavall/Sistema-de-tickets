package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import datos.Usuario;


public class UsuarioDao {
	protected static Session session;
	protected Transaction tx;
	
	protected void iniciaOperacion() throws HibernateException{
		session = HibernateUtil.getSessionFactory().openSession(); 
		tx = session.beginTransaction(); 
	}
	
	protected void manejaExcepcion (HibernateException he) throws HibernateException{
		tx.rollback();
		throw new HibernateException ("ERROR en la capa de acceso de datos", he); 
	}
	
	public void agregar(Usuario usuario) {
		try {
			iniciaOperacion(); 
			session.persist(usuario);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he); 
			throw he; 
		}finally {
			session.close(); 
		}
	}
	
	public void actualizar(Usuario usuario) {
		try {
			iniciaOperacion();
			session.merge(usuario);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
	}
	
	public void eliminar (Usuario usuario) {
		try {
			iniciaOperacion(); 
			session.remove(usuario);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
	}

}

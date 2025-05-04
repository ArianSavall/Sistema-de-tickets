package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Tarea;

public class TareaDao {
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

	public long agregar(Tarea objeto) {
	    long id = 0;
	    try {
	        iniciaOperacion();
	        session.persist(objeto);  // persistir el objeto
	        tx.commit();
	        id = objeto.getId();      
	    } catch (HibernateException he) {
	        manejaExcepcion(he);
	        throw he;
	    } finally {
	        session.close();
	    }
	    return id;
	}

	public void actualizar(Tarea objeto) {
	    try {
	        iniciaOperacion();
	        session.merge(objeto);  // merge combina los datos del objeto con el existente en la BD
	        tx.commit();
	    } catch (HibernateException he) {
	        manejaExcepcion(he);
	        throw he;
	    } finally {
	        session.close();
	    }
	}
	
	public void eliminar(Tarea objeto) {
	    try {
	        iniciaOperacion();
	        session.remove(objeto);  // elimina el objeto de la base de datos
	        tx.commit();
	    } catch (HibernateException he) {
	        manejaExcepcion(he);
	        throw he;
	    } finally {
	        session.close();
	    }
	}

	public Tarea traer(long id) {
		Tarea objeto = null;
		try {
			iniciaOperacion();
			objeto = (Tarea) session.get(Tarea.class, id);
		} finally {
			session.close();
		}
			return objeto;
		}
}

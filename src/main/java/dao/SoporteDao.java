package dao;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Soporte;

public class SoporteDao {
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
	
	public void agregar(Soporte soporte){
		try {
			iniciaOperacion(); 
			session.persist(soporte);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he); 
			throw he; 
		}
		finally {
			session.close(); 
		}
	}
	
	public void actualizar(Soporte soporte) {
		try {
			iniciaOperacion();
			session.merge(soporte);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
	}
	
	public void eliminar (Soporte soporte) {
		try {
			iniciaOperacion(); 
			session.remove(soporte);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
	}
	
	
	public Soporte traer (String cuil) {
		Soporte soporte = null; 
		
		try {
			iniciaOperacion(); 
			soporte = session.get(Soporte.class, cuil); 
		} catch (HibernateException he) {
			manejaExcepcion (he); 
		} finally {
			session.close();
		}
		return soporte; 
	}
	
	public List<Soporte> traerLista() throws HibernateException {
		List <Soporte> lista = null; 
		try {
			iniciaOperacion (); 
			lista = session.createSelectionQuery(
					"from Soporte s ", Soporte.class).getResultList();
		} finally {
			session.close();
		}
		return lista; 
	}
	
	public List<Soporte> traerPorEspecialidad(String nombre) {
	    List<Soporte> lista = null;
	    try {
	        iniciaOperacion();
	        lista = session.createQuery(
	            "select s from Soporte s join s.especialidades e  where e.nombre = :nombreEspecialidad ", Soporte.class)
	            .setParameter("nombreEspecialidad", nombre).getResultList();
	    } finally {
	        session.close();
	    }
	    return lista;
	}
}

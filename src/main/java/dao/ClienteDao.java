package dao;

import java.util.*;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Cliente;
import datos.Usuario;


public class ClienteDao {
	
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
	
	public void agregar(Cliente cliente) {
		try {
			iniciaOperacion(); 
			session.persist(cliente);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he); 
			throw he; 
		}finally {
			session.close(); 
		}
	}
	
	public void actualizar(Cliente cliente) {
		try {
			iniciaOperacion();
			session.merge(cliente);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
	}
	
	public void eliminar (Cliente cliente) {
		try {
			iniciaOperacion(); 
			session.remove(cliente);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
	}
	
	public Cliente traer (String cuil) {
		Cliente c = null; 
		try {
			iniciaOperacion(); 
			c = session.get(Cliente.class, cuil); 
		} catch (HibernateException he) {
			manejaExcepcion (he); 
		} finally {
			session.close();
		}
		return c; 
	}
	
	public List<Cliente> traerLista() throws HibernateException {
		List <Cliente> lista = null; 
		try {
			iniciaOperacion (); 
			lista = session.createSelectionQuery(
					"from Cliente u order by apellido asc, nombre asc", Cliente.class).getResultList();
		} finally {
			session.close();
		}
		return lista; 
	}
	
	public List<Cliente> traerClientesPorArea (String area)throws HibernateException{
		List <Cliente> lista = null; 
		try {
			iniciaOperacion (); 
			String hql ="from Cliente c where c.area = :area";
			lista = session.createQuery (hql, Cliente.class).setParameter("area", area).getResultList(); 
		} finally {
			session.close(); 
		}
		return lista; 
	}

}

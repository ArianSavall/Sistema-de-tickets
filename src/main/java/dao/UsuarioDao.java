package dao;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import datos.Usuario;

public class UsuarioDao {
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
	
	public int agregar(Usuario objeto) {
		int id = 0; 
		try {
			iniciaOperacion(); 
			session.persist(objeto);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he); 
		}finally {
			session.close(); 
		}
		
		return id; 
	}
	
	
}

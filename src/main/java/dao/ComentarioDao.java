package dao;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import datos.Comentario;

public class ComentarioDao {
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
	public int agregar(Comentario objeto) {
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
	public void actualizar(Comentario objeto) {
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
	
	public void eliminar(Comentario objeto) {
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
	public Comentario traer(long id) {
		Comentario objeto = null;
		try {
			iniciaOperacion();
			objeto = (Comentario) session.get(Comentario.class, id);
			
		} finally {
			session.close();
		}
		return objeto;
	}
		
	public List<Comentario> traerTodos(){
		List<Comentario> comentarios = new ArrayList<>();
		
		try {
			iniciaOperacion();
			String query = "from Comentario c order by c.id asc" ;
			comentarios = (List<Comentario>) session.createQuery(query, Comentario.class).getResultList();
		} finally {
			session.close();
		}
		
		return comentarios;
	}
		
}

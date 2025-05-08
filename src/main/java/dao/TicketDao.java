package dao;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Estado;
import datos.Soporte;
import datos.Ticket;

public class TicketDao {
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
	
	public long agregar(Ticket objeto) {
		long id = 0;
	    try {
	        iniciaOperacion();
	        session.persist(objeto);  
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
	
	public void actualizar(Ticket objeto) {
	    try {
	        iniciaOperacion();
	        session.merge(objeto);  
	        tx.commit();
	    } catch (HibernateException he) {
	        manejaExcepcion(he);
	        throw he;
	    } finally {
	        session.close();
	    }
	}
	
	
	public void eliminar(Ticket objeto) {
	    try {
	        iniciaOperacion();
	        session.remove(objeto);  
	        tx.commit();
	    } catch (HibernateException he) {
	        manejaExcepcion(he);
	        throw he;
	    } finally {
	        session.close();
	    }
	}
	
	public Ticket traer(long id) throws HibernateException {
	    Ticket objeto = null;
	    try {
	        iniciaOperacion();            
	        String hql = "from Ticket t where t.id = :id";
	        objeto = session.createQuery(hql, Ticket.class).setParameter("id", id).uniqueResult();
	        if (objeto != null) {
	            Hibernate.initialize(objeto.getTareas());
	            Hibernate.initialize(objeto.getComentarios());
	        }
	    } finally {
	        session.close();
	    }
	    return objeto;
	}
	

	public List<Ticket> traer() throws HibernateException {
	    List<Ticket> lista = null;
	    try {
	        iniciaOperacion(); 
	        String hql = "from Ticket t " +
                    	"left join fetch t.tareas " +
                    	"left join fetch t.comentarios " +
                    	"order by t.fechaAlta desc, t.prioridad asc";;
	        lista = session.createSelectionQuery(hql, Ticket.class).getResultList();
	    } finally {
	        session.close();
	    }
	    return lista;
	}

	public List<Ticket> traerPorFechaAltaEntre(LocalDateTime desde, LocalDateTime hasta) {
		List<Ticket> lista = null;
		try {
			iniciaOperacion();
			String hql = "SELECT DISTINCT t FROM Ticket t " +
		             "LEFT JOIN FETCH t.tareas " +
		             "LEFT JOIN FETCH t.comentarios " +
		             "WHERE t.fechaAlta BETWEEN :desde AND :hasta";
			lista = session.createQuery(hql, Ticket.class)
					.setParameter("desde", desde)
					.setParameter("hasta", hasta)
					.getResultList();
		}  catch (HibernateException he) {
	        manejaExcepcion(he);
	        throw he;
	    }finally {
			session.close();
		}
		return lista;
	}
	
	public List<Ticket> traerTicketsCerradosEntre(LocalDateTime desde, LocalDateTime hasta) {
		List<Ticket> lista = null;
		try {
			iniciaOperacion();
			String hql = "SELECT DISTINCT t FROM Ticket t " +
			             "LEFT JOIN FETCH t.tareas " +
			             "LEFT JOIN FETCH t.comentarios " +
			             "WHERE t.estado = :estado AND t.fechaBaja BETWEEN :desde AND :hasta";
			lista = session.createQuery(hql, Ticket.class)
				.setParameter("estado", Estado.COMPLETADO)
				.setParameter("desde", desde)
				.setParameter("hasta", hasta)
				.getResultList();
		} finally {
			session.close();
		}
		return lista;
	}
	
	public List<Ticket> traerTicketsPorCuil(String cuil){
		List<Ticket> tickets = new ArrayList<>();
		try {
			iniciaOperacion();
			String hql = "from Ticket t where t.soporte.cuil = :cuil OR t.cliente.cuil = :cuil";
			tickets = session.createQuery(hql, Ticket.class).setParameter("cuil", cuil).getResultList();
				
		} finally {
			session.close();
		}
		return tickets;
	}
}

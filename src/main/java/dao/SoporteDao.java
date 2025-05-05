package dao;

import java.util.List;
import org.hibernate.HibernateException;
import datos.Soporte;

public class SoporteDao extends UsuarioDao {
	
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
					"from soporte s order by s.apellido asc, s.nombre asc", Soporte.class).getResultList();
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

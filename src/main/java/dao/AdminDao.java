package dao;


import org.hibernate.HibernateException;
import datos.Admin;


public class AdminDao extends UsuarioDao {
	
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

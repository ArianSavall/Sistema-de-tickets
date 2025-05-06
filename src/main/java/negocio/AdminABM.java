package negocio;

import dao.AdminDao;
import datos.Admin;

public class AdminABM {
	AdminDao dao = new AdminDao(); 
	
	public void agregar (Admin admin) {
		dao.agregar(admin);
	}
	
	public void modificar (String cuil) {
		Admin a = dao.traer(cuil); 
		dao.actualizar(a);
	}
	
	public void eliminar (String cuil) {
		Admin a = dao.traer(cuil); 
		dao.eliminar(a);
	}
	
	public Admin traer (String cuil) {
		return dao.traer(cuil); 
	}
}

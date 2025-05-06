package negocio;

import dao.TareaDao;
import datos.Tarea;
import datos.Ticket;

public class TareaABM {
	TareaDao dao = new TareaDao();
	
	public long agregar(String descripcion, String nombre, Ticket ticket) {
		Tarea t = new Tarea(descripcion, false, nombre, ticket);
		return dao.agregar(t);
	}
	
	public Tarea traer(long id) {
		return dao.traer(id);
	}
	
	public void modificar(Tarea tarea) {
		dao.actualizar(tarea);
	}
	
	public void eliminar(long id) {
		Tarea t = dao.traer(id);
		dao.eliminar(t);
	}
	
}

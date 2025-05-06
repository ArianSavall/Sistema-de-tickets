package negocio;
import java.time.LocalDateTime;
import java.util.List;

import dao.EspecialidadDao;
import datos.Especialidad;
import datos.Ticket;
import datos.Usuario;

public class EspecialidadABM {
	EspecialidadDao dao = new EspecialidadDao();
	
	public Especialidad traer(long idEspecialidad) {
		return dao.traer(idEspecialidad);
	}
	
	public int agregar(String nombre, String descripcion) {
		Especialidad e = new Especialidad(nombre, descripcion);
		return dao.agregar(e);
	}
	public void modificar(Especialidad e) {
		try {
			dao.actualizar(e);
		}catch(Exception ex) {
			System.out.println(ex);
		}
		
	}
	public void eliminar(long idEspecialidad) {
	
		Especialidad e = dao.traer(idEspecialidad);
	// Implementar que si es null que arroje la excepción la Excepción de que el comentario no existe
		dao.eliminar(e);
	}
	public List<Especialidad> traer() {
		return dao.traerTodos();
	}
}

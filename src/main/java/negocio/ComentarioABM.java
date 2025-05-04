package negocio;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import dao.ComentarioDao;
import datos.Comentario;
import datos.Ticket;
import datos.Usuario;
public class ComentarioABM {
	
	ComentarioDao dao = new ComentarioDao();
	
	public Comentario traer(long idComentario) {
		return dao.traer(idComentario);
	}
	
	public int agregar(String descripcion, Usuario emisor, Ticket ticketAsociado) {
		Comentario c = new Comentario(LocalDateTime.now(), descripcion, emisor, ticketAsociado);
		return dao.agregar(c);
	}
	public void modificar(Comentario c) {
		try {
			dao.actualizar(c);
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}
	public void eliminar(long idComentario) {
	
		Comentario c = dao.traer(idComentario);
	// Implementar que si es null que arroje la excepción la Excepción de que el comentario no existe
		dao.eliminar(c);
	}
	public List<Comentario> traer() {
		return dao.traerTodos();
	}

}

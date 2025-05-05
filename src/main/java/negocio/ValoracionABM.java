package negocio;

import java.time.LocalDateTime;
import java.util.List;

import dao.ValoracionDao;
import datos.Ticket;
import datos.Valoracion;

public class ValoracionABM {
	ValoracionDao dao = new ValoracionDao();
	
	public Valoracion traer(long idValoracion) {
		return dao.traer(idValoracion);
	}
	
	public int agregar(int puntaje, LocalDateTime fecha, String comentario, Ticket ticketAsociado) {
		Valoracion e = new Valoracion(puntaje, fecha, comentario, ticketAsociado);
		return dao.agregar(e);
	}
	public void modificar(Valoracion e) {
		try {
			dao.actualizar(e);
		}catch(Exception ex) {
			System.out.println(ex);
		}
		
	}
	public void eliminar(long idValoracion) {
	
		Valoracion e = dao.traer(idValoracion);
	// Implementar que si es null que arroje la excepción la Excepción de que el comentario no existe
		dao.eliminar(e);
	}
	public List<Valoracion> traer() {
		return dao.traerTodos();
	}
}

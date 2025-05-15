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
		dao.eliminar(e);
	}
	public List<Valoracion> traer() {
		return dao.traerTodos();
	}
	
	public List<Valoracion> traerValoracionesEntreFechas(LocalDateTime desde, LocalDateTime hasta) {
		return dao.traerValoracionesEntreFechas(desde, hasta);
	}
	
	public List<Valoracion> traerValoracionesPorFechaYPuntaje(LocalDateTime fecha, int puntajeMinimo) {
		return dao.traerValoracionesPorFechaYPuntaje(fecha, puntajeMinimo);
	}
}

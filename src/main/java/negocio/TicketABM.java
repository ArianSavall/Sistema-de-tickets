package negocio;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;

import dao.TicketDao;
import datos.Cliente;
import datos.Estado;
import datos.Prioridad;
import datos.Ticket;

public class TicketABM {
	TicketDao dao = new TicketDao();
	
	public long agregar(String asunto, String descripcion, LocalDateTime fechaAlta, Prioridad prioridad, Estado estado, Cliente cliente) {
		Ticket t = new Ticket(asunto, descripcion, fechaAlta, null, prioridad, estado, null, cliente, new HashSet<>(), new HashSet<>(), null);
		return dao.agregar(t);
	}
	
	public Ticket traer(long id) {
		return dao.traer(id);
	}
	
	public void modificar(Ticket ticket) {
		dao.actualizar(ticket);
	}
	
	public void eliminar(long id) {
		Ticket t = dao.traer(id);
		dao.eliminar(t);
	}
	
	public List<Ticket> traer() {
		return dao.traer();
	}
	
	public Ticket traerTicketCompleto(long id) {
		return dao.traerTicketCompleto(id);
	}
	
}

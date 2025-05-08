package negocio;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;

import dao.TicketDao;
import datos.Cliente;
import datos.Estado;
import datos.Prioridad;
import datos.Soporte;
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
	
	public List<Ticket> traerPorFechaAltaEntre(LocalDateTime desde, LocalDateTime hasta) {
		return dao.traerPorFechaAltaEntre(desde, hasta);
	}
	public List<Ticket> traerTicketsCerradosEntre(LocalDateTime desde, LocalDateTime hasta) {
		return dao.traerTicketsCerradosEntre(desde, hasta);
	}
	
	public List<Ticket> traerTicketsPorSoporte(Soporte soporte){
		return dao.traerTicketsPorCuil(soporte.getCuil());
	}
	
	public List<Ticket> traerTicketsPorCliente(Cliente cliente){
		return dao.traerTicketsPorCuil(cliente.getCuil());
	}
	public void asignarSoporte(Ticket ticket, Soporte soporte) {
		ticket.setSoporte(soporte);
		ticket.setEstado(Estado.EN_PROCESO);
		dao.actualizar(ticket);
	}
}

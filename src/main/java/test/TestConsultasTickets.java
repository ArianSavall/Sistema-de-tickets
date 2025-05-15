package test;

import java.util.List;

import datos.Cliente;
import datos.Soporte;
import datos.Ticket;
import negocio.ClienteABM;
import negocio.SoporteABM;
import negocio.TicketABM;

public class TestConsultasTickets {
	public static void main(String[] args) {
		TicketABM abmTicket = new TicketABM();
		SoporteABM abmSoporte = new SoporteABM();
		
		Soporte soporte = abmSoporte.traer("20-12345678-9");
		System.out.println("----POR SOPORTE---");
		List<Ticket> ticketsSoporte = abmTicket.traerTicketsPorSoporte(soporte);
		
		for(Ticket t : ticketsSoporte) {
			System.out.println(t.getId());
			System.out.println(t.getAsunto());
			System.out.println(t.getDescripcion());
			System.out.println(t.getFechaAlta());
			System.out.println(t.getPrioridad());
			System.out.println(t.getEstado());
			System.out.println(t.getCliente());
			System.out.println(t.getSoporte());
		}
		
		System.out.println("----POR CLIENTE---");
		ClienteABM abmCliente = new ClienteABM();
		Cliente cliente = abmCliente.traer("20-23456789-9");
		List<Ticket> ticketsCliente = abmTicket.traerTicketsPorCliente(cliente);
		
		for(Ticket t : ticketsCliente) {
			System.out.println(t.getId());
			System.out.println(t.getAsunto());
			System.out.println(t.getDescripcion());
			System.out.println(t.getFechaAlta());
			System.out.println(t.getPrioridad());
			System.out.println(t.getEstado());
			System.out.println(t.getCliente());
			System.out.println(t.getSoporte());
		}
		
		
	}
}

package test;

import java.time.LocalDateTime;
import java.util.List;

import datos.Cliente;
import datos.Estado;
import datos.Prioridad;
import datos.Ticket;
import negocio.ClienteABM;
import negocio.TicketABM;

public class TestABMTicket {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TicketABM abm = new TicketABM();
		ClienteABM abmCliente = new ClienteABM();
		Cliente cliente = abmCliente.traer("20-23456789-9");
		abm.agregar("Asunto ejemplo 2", "Descripcion ejemplo 2", LocalDateTime.now(), Prioridad.BAJA, Estado.NUEVO, cliente);
		abm.agregar("Asunto ejemplo 3", "Descripcion ejemplo 3", LocalDateTime.now(), Prioridad.ALTA, Estado.NUEVO, cliente);
		
		Ticket ticket = abm.traer(1);
		System.out.println("TICKET 1: " + ticket);
		
		System.out.print("LISTA DE TICKETS: ");
        List<Ticket> tickets = abm.traer();
        for(Ticket t : tickets) {
			System.out.println(t.toString());
		}
        
        System.out.println("ELIMINANDO EL TICKET 1");
        abm.eliminar(1);
        
        Ticket ticketAModificar = abm.traer(2);
        ticketAModificar.setAsunto("Asunto modificado");
        abm.modificar(ticketAModificar);
        System.out.println("TICKET MODIFICADO: " + ticketAModificar);
				
	}

}

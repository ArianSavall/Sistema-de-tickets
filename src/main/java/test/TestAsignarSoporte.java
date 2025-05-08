package test;

import datos.Soporte;
import datos.Ticket;
import negocio.SoporteABM;
import negocio.TicketABM;

public class TestAsignarSoporte {

	public static void main(String[] args) {
		TicketABM abmTicket = new TicketABM();
		SoporteABM abmSoporte = new SoporteABM();
		
		Ticket ticket = abmTicket.traer(7);
		Soporte soporte = abmSoporte.traer("20-12345678-9");
		abmTicket.asignarSoporte(ticket, soporte);
	}

}

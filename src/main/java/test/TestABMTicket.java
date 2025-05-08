package test;

import java.time.LocalDateTime;

import datos.Cliente;
import datos.Estado;
import datos.Prioridad;
import negocio.ClienteABM;
import negocio.TicketABM;

public class TestABMTicket {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TicketABM abm = new TicketABM();
		ClienteABM abmCliente = new ClienteABM();
		Cliente cliente = abmCliente.traer("20-23456789-9");
		abm.agregar("Asunto ejemplo 2", "Descripcion ejemplo 2", LocalDateTime.now(), Prioridad.BAJA, Estado.NUEVO, cliente);
		
		
	}

}

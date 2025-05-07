package test;

import java.time.LocalDateTime;
import java.util.List;

import datos.*;
import negocio.*;

public class TestIntervaloFechas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Mi test intervalo fechas");

		TicketABM ticketABM = new TicketABM();

		LocalDateTime desde = LocalDateTime.of(2023, 5, 9, 0, 0);
		LocalDateTime hasta = LocalDateTime.of(2024, 5, 8, 23, 59);

		List<Ticket> lista = ticketABM.traerPorFechaAltaEntre(desde, hasta);

		System.out.println("Tickets con fechaAlta entre " + desde + " y " + hasta + ":");
		for (Ticket t : lista) {
			System.out.println(t);
		}

		List<Ticket> ticketsCerrados = ticketABM.traerTicketsCerradosEntre(desde, hasta);
		System.out.println("\nTickets cerrados (estado COMPLETADO) entre " + desde + " y " + hasta + ":");
		for (Ticket t : ticketsCerrados) {
			System.out.println(t);
		}
		
		ComentarioABM comentarioABM = new ComentarioABM();
		
		LocalDateTime desdeComentario = LocalDateTime.of(2024, 5, 2, 0, 0);
		LocalDateTime hastaComentario = LocalDateTime.of(2024, 5, 8, 23, 59);

		List<Comentario> comentarios = comentarioABM.traerComentariosEntreFechas(desdeComentario, hastaComentario);
		
		System.out.println("\nComentarios realizados entre " + desdeComentario + " y " + hasta + ":");
		for (Comentario c : comentarios) {
			System.out.println(c);
		}
		
	}

}

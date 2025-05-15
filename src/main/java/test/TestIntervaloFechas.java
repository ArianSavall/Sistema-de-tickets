package test;

import java.time.LocalDateTime;
import java.util.List;

import datos.*;
import negocio.*;

public class TestIntervaloFechas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Mi test intervalo fecha\n **PUNTO 1.5**");

		TicketABM ticketABM = new TicketABM();

		LocalDateTime desde = LocalDateTime.of(2023, 5, 9, 0, 0);
		LocalDateTime hasta = LocalDateTime.of(2024, 5, 8, 23, 59);

		List<Ticket> ticketFechas = ticketABM.traerPorFechaAltaEntre(desde, hasta);

		System.out.println("Tickets con fechaAlta entre " + desde + " y " + hasta + ":");
		for (Ticket t : ticketFechas) {
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
		
		ValoracionABM valoracionABM = new ValoracionABM();
		
		LocalDateTime desdeValoracion = LocalDateTime.of(2024, 5, 2, 0, 0);
		LocalDateTime hastaValoracion = LocalDateTime.of(2024, 5, 9, 23, 59);
		
		List<Valoracion> valoraciones = valoracionABM.traerValoracionesEntreFechas(desdeComentario, hastaComentario);
		
		System.out.println("\nValoraciones realizados entre " + desdeValoracion + " y " + hastaValoracion + ":");
		for (Valoracion v : valoraciones) {
			System.out.println(v);
		}
		
		
		System.out.println("\nMi test intervalo fecha y atributo\n **PUNTO 1.6**");
		LocalDateTime fecha1 = LocalDateTime.of(2024, 5, 1, 10, 30);
		LocalDateTime fecha2 = LocalDateTime.of(2024, 5, 8, 12, 15);
		LocalDateTime fecha3 = LocalDateTime.of(2024, 5, 1, 16, 0);
		LocalDateTime fecha4 = LocalDateTime.of(2024, 5, 8, 12, 15);
		
		List<Ticket> ticketPorFechaYPrioridad = ticketABM.traerTicketsPorFechaAltaYPrioridad(fecha1, Prioridad.ALTA);
		List<Ticket> ticketPorFechaYEstado = ticketABM.traerTicketsPorFechaBajaYEstado(fecha2, Estado.COMPLETADO);;
		List<Comentario> comentarioPorFechaYCuilUsuario = comentarioABM.traerComentariosPorFechaYUsuario(fecha3, "20305556666");
		List<Valoracion> valoracionPorFechaYPuntaje = valoracionABM.traerValoracionesPorFechaYPuntaje(fecha4, 5);
		
		System.out.println("\nTickets de " + fecha1 + " con prioridad " + Prioridad.ALTA + ":");

		for (Ticket t : ticketPorFechaYPrioridad) {
			System.out.println(t);
		}
		
		System.out.println("\nTickets de " + fecha2 + " con estado " + Estado.COMPLETADO+ ":");
		for (Ticket t : ticketPorFechaYEstado) {
			System.out.println(t);
		}
		
		System.out.println("\nComentarios realizados en " + fecha2 + " por usuario con cuil " + 2323232 );
		for (Comentario c : comentarioPorFechaYCuilUsuario) {
			System.out.println(c);
		}
		
		System.out.println("\nValoraciones realizados entre " + fecha4 + " con puntaje mayor o igual a  " + 5 + ":");
		for (Valoracion v : valoracionPorFechaYPuntaje) {
			System.out.println(v);
		}
	
	}

}

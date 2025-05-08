package datos;

import java.time.LocalDateTime;

public class Valoracion {
	private long id;
	private int puntaje;
	private LocalDateTime fecha;
	private String comentario;
	private Ticket ticketAsociado;
	
	public Valoracion() {
		super();
	}
	
	public Valoracion(int puntaje, LocalDateTime fecha, String comentario, Ticket ticketAsociado) {
		super();
		this.puntaje = puntaje;
		this.fecha = fecha;
		this.comentario = comentario;
		this.ticketAsociado = ticketAsociado;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getPuntaje() {
		return puntaje;
	}
	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}
	public LocalDateTime getFecha() {
		return fecha;
	}
	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public Ticket getTicketAsociado() {
		return ticketAsociado;
	}
	public void setTicketAsociado(Ticket ticketAsociado) {
		this.ticketAsociado = ticketAsociado;
	}


	@Override
	public String toString() {
		return "Valoracion [id=" + id + ", puntaje=" + puntaje + ", fecha=" + fecha + ", comentario=" + comentario
				+ ", ticketAsociado=" + ticketAsociado + "]";
	}
	
	
}

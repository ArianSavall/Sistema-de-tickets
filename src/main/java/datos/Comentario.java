package datos;

import java.time.LocalDateTime;

public class Comentario {
	private long id;
	private LocalDateTime fechaHora;
	private String descripcion;
	private Usuario emisor;
	private Ticket ticketAsociado;
	
	public Comentario() {
		
	}
	
	public Comentario(LocalDateTime fechaHora, String descripcion, Usuario emisor, Ticket ticketAsociado) {
		this.fechaHora = fechaHora;
		this.descripcion = descripcion;
		this.emisor = emisor;
		this.ticketAsociado = ticketAsociado;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDateTime getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(LocalDateTime fechaHora) {
		this.fechaHora = fechaHora;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Usuario getEmisor() {
		return emisor;
	}

	public void setEmisor(Usuario emisor) {
		this.emisor = emisor;
	}

	public Ticket getTicketAsociado() {
		return ticketAsociado;
	}

	public void setTicketAsociado(Ticket ticketAsociado) {
		this.ticketAsociado = ticketAsociado;
	}

	
	
	
}

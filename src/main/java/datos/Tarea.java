package datos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString @NoArgsConstructor
public class Tarea {
	private long id;
	private String descripcion;
	private boolean completada;
	private String nombre;
	private Ticket ticket;
	
	public Tarea() {}
	
	public Tarea(String descripcion, boolean completada, String nombre, Ticket ticket) {
		this.descripcion = descripcion;
		this.completada = completada;
		this.nombre = nombre;
		this.ticket = ticket;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public boolean isCompletada() {
		return completada;
	}

	public void setCompletada(boolean completada) {
		this.completada = completada;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	@Override
	public String toString() {
		return "Tarea [id=" + id + ", descripcion=" + descripcion + ", completada=" + completada + ", nombre=" + nombre
				+ ", ticket=" + ticket + "]";
	}
	
	
}

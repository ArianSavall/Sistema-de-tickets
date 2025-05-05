package datos;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;


public class Ticket {
	private long id;
	private String asunto;
	private String descripcion;
	private LocalDateTime fechaAlta;
	private LocalDateTime fechaBaja;
	private Prioridad prioridad;
	private Estado estado;
	private Soporte soporte;
	private Cliente cliente;
	private Set<Tarea> tareas;
	private Set<Comentario> comentarios;
	private Valoracion valoracion;
	
	public Ticket(){}
	
	public Ticket(String asunto, String descripcion, LocalDateTime fechaAlta, LocalDateTime fechaBaja,
			Prioridad prioridad, Estado estado, Soporte soporte, Cliente cliente, Set<Tarea> tareas,
			Set<Comentario> comentarios, Valoracion valoracion) {
		this.asunto = asunto;
		this.descripcion = descripcion;
		this.fechaAlta = fechaAlta;
		this.fechaBaja = fechaBaja;
		this.prioridad = prioridad;
		this.estado = estado;
		this.soporte = soporte;
		this.cliente = cliente;
		this.tareas = tareas;
		this.comentarios = comentarios;
		this.valoracion = valoracion;
	}

	public long getId() {
		return id;
	}

	protected void setId(long id) {
		this.id = id;
	}

	public String getAsunto() {
		return asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public LocalDateTime getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(LocalDateTime fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public LocalDateTime getFechaBaja() {
		return fechaBaja;
	}

	public void setFechaBaja(LocalDateTime fechaBaja) {
		this.fechaBaja = fechaBaja;
	}

	public Prioridad getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(Prioridad prioridad) {
		this.prioridad = prioridad;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Soporte getSoporte() {
		return soporte;
	}

	public void setSoporte(Soporte soporte) {
		this.soporte = soporte;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Set<Tarea> getTareas() {
		return tareas;
	}

	public void setTareas(Set<Tarea> tareas) {
		this.tareas = tareas;
	}

	public Set<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(Set<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	public Valoracion getValoracion() {
		return valoracion;
	}

	public void setValoracion(Valoracion valoracion) {
		this.valoracion = valoracion;
	}
	
}

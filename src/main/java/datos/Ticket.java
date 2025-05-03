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
}

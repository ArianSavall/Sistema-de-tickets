package datos;

import java.time.LocalDateTime;
import java.util.List;

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
	private List<Tarea> tareas;
	private List<Comentario> comentarios;
	private Valoracion valoracion;
}

package datos;

import java.time.LocalDateTime;
import java.util.Set;

public class Soporte extends Usuario{
	private Set<Especialidad> especialidades;
	private LocalDateTime fechaIngreso; 
	private Turno turno; 

	public Soporte() {}

	public Soporte(String nombre, String apellido, String email, String password, String cuil, String fotoPerfil, Set<Especialidad> especialidades, LocalDateTime fechaIngreso, Turno turno) {
		super(nombre, apellido, email, password, cuil, fotoPerfil);
		this.especialidades = especialidades;
		this.fechaIngreso = fechaIngreso;
		this.turno = turno;
	}

	public Set<Especialidad> getEspecialidades() {
		return especialidades;
	}

	public void setEspecialidades(Set<Especialidad> especialidades) {
		this.especialidades = especialidades;
	}

	public LocalDateTime getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(LocalDateTime fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Turno getTurno() {
		return turno;
	}

	public void setTurno(Turno turno) {
		this.turno = turno;
	}

	@Override
	public String toString() {
	    return "Soporte{" +
	           super.toString() + 
	           ", especialidad=" + especialidades +
	           ", fecha de ingreso=" + fechaIngreso +
	           ", turno=" + turno;
	}

	
	
	
	
	
	
	
}

package datos;

import java.util.Set;

public class Soporte extends Usuario{
	private Set<Especialidad> especialidades;

	public Soporte() {}

	public Soporte(String nombre, String apellido, String email, String password, String cuil, String fotoPerfil, Set<Especialidad> especialidades) {
		super(nombre, apellido, email, password, cuil, fotoPerfil);
		this.especialidades = especialidades;
	}

	public Set<Especialidad> getEspecialidades() {
		return especialidades;
	}

	public void setEspecialidades(Set<Especialidad> especialidades) {
		this.especialidades = especialidades;
	}

	@Override
	public String toString() {
	    return "Soporte{" +
	           "cuil='" + getCuil() + '\'' +
	           ", nombre='" + getNombre() + '\'' +
	           ", apellido='" + getApellido() + '\'' +
	           ", email='" + getEmail() + '\'' +
	           '}';
	}

	
	
	
	
	
	
	
}

package datos;

import java.util.Objects;

public abstract class Usuario {
	protected String nombre;
	protected String apellido;
	protected String email;
	protected String password;
	protected String cuil;
	protected String fotoPerfil;
	
	public Usuario() {}

	public Usuario(String nombre, String apellido, String email, String password, String cuil, String fotoPerfil) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.password = password;
		this.cuil = cuil;
		this.fotoPerfil = fotoPerfil;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCuil() {
		return cuil;
	}

	public void setCuil(String cuil) {
		this.cuil = cuil;
	}

	public String getFotoPerfil() {
		return fotoPerfil;
	}

	public void setFotoPerfil(String fotoPerfil) {
		this.fotoPerfil = fotoPerfil;
	}

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", apellido=" + apellido + ", email=" + email + ", password=" + password
				+ ", cuil=" + cuil + ", fotoPerfil=" + fotoPerfil + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(cuil);
	}	
}

package datos;

import java.util.Set;

public class Especialidad {
	private long id;
	private String nombre;
	private String descripcion;
	private Set<Soporte> soportes;
	
	public Especialidad() {
		
	}
	
	public Especialidad(String nombre, String descripcion) { 
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	

	public Set<Soporte> getSoportes() {
	    return soportes;
	}

	public void setSoportes(Set<Soporte> soportes) {
	    this.soportes = soportes;
	}
	
	
}

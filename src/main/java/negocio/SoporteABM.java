package negocio;

import java.sql.SQLIntegrityConstraintViolationException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import Excepciones.CuilDuplicadoException;
import dao.SoporteDao;
import datos.Especialidad;
import datos.Soporte;
import datos.Turno;

public class SoporteABM {
	SoporteDao dao = new SoporteDao (); 
	
	public void agregar (String nombre, String apellido, String email, String password, String cuil, String fotoPerfil, Set<Especialidad> especialidades, LocalDateTime fechaIngreso, Turno turno) {
		Soporte s = new Soporte (nombre, apellido, email, password, cuil, fotoPerfil, especialidades, fechaIngreso, turno);
		dao.agregar(s);
	}
	
	public void modificar (Soporte s) {
		dao.actualizar(s);
	}
	
	public void eliminar (String cuil) {
		Soporte s = dao.traer(cuil); 
		dao.eliminar(s);
	}
	
	public Soporte traer (String cuil) {
		return dao.traer(cuil); 
	}
	
	public List<Soporte> traerSoportes (){
		return dao.traerLista(); 
	}
	
	public List<Soporte> traerSoportePorEspecialidad (Especialidad especialidad){
		return dao.traerPorEspecialidad(especialidad.getNombre()); 
	}
	
	public List<Soporte> traerSoportePorTurno (Turno turno){
		return dao.traerPorTurno(turno);
	}
}

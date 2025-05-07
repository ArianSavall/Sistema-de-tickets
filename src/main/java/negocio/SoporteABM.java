package negocio;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.Set;

import Excepciones.CuilDuplicadoException;
import dao.SoporteDao;
import datos.Especialidad;
import datos.Soporte;

public class SoporteABM {
	SoporteDao dao = new SoporteDao (); 
	
	public void agregar (String nombre, String apellido, String email, String password, String cuil, String fotoPerfil, Set<Especialidad> especialidades) {
		Soporte s = new Soporte (nombre, apellido, email, password, cuil, fotoPerfil, especialidades);
		dao.agregar(s);
	}
	
	public void modificar (String cuil) {
		Soporte s = dao.traer(cuil); 
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
	
	public List<Soporte> traerSoportePorEspecialidad (String nombre){
		return dao.traerPorEspecialidad(nombre); 
	}
}

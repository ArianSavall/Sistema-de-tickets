package negocio;

import java.util.List; 
import dao.ClienteDao;
import datos.Cliente;

public class ClienteABM {
	ClienteDao dao = new ClienteDao(); 
	
	public void agregar (String nombre, String apellido, String email, String password, String cuil, String fotoPerfil, String area) {
		Cliente c = new Cliente (nombre, apellido, email, password, cuil, fotoPerfil, area); 
		dao.agregar(c);
	}
	
	public void modificarNombre(String cuil, String nombre) {
		Cliente cliente = dao.traer(cuil);
		cliente.setNombre(nombre);
		dao.actualizar(cliente);
	}
	
	public void eliminar (String cuil){
		Cliente cliente = dao.traer(cuil); 
		dao.eliminar(cliente);
	}
	
	public Cliente traer (String cuil) {
		return dao.traer(cuil); 
	}
	
	public List<Cliente> traerClientes() {
		return dao.traerLista(); 
	}
	
	public List<Cliente> traerClientesPorArea (String area){
		return dao.traerClientesPorArea(area); 
	}
}

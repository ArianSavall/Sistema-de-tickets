package test;

import negocio.SoporteABM;

import java.util.HashSet;
import java.util.Set; 
import datos.Especialidad;
import negocio.EspecialidadABM;

public class TestABMSoporte {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SoporteABM abm = new SoporteABM(); 
		
	      /* Set<Especialidad> especialidades = new HashSet<>();
	        especialidades.add(new Especialidad("Redes", "Manejo de redes"));
	        especialidades.add(new Especialidad("Hardware", "Reparación de hardware"));
*/
	        
	        //abm.agregar("Juan", "Pérez", "juan@mail.com", "1234", "20-12345678-9", "foto.jpg", especialidades);
		System.out.println(abm.traer("20-12345678-9"));
	}

}

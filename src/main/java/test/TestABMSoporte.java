package test;

import negocio.EspecialidadABM;
import negocio.SoporteABM;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set; 
import datos.Especialidad;
import datos.Turno;

public class TestABMSoporte {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SoporteABM abm = new SoporteABM(); 
		EspecialidadABM abmEspecialidad = new EspecialidadABM();
	    Set<Especialidad> especialidades = new HashSet<>();
	    especialidades.add(new Especialidad("Matenimiento", "Matentenimiento de software"));
	    
	    abm.agregar("Juan", "Pérez", "juan@mail.com", "1234", "20-12345678-9", "foto.jpg", especialidades, LocalDateTime.now(), Turno.TARDE);
		abm.agregar("Martín", "González", "martin@mail.com", "4321", "20-87654321-9", "foto.jpg", especialidades, LocalDateTime.now(), Turno.MAÑANA);

	}

}

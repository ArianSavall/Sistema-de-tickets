package test;

import java.util.List;

import datos.Especialidad;
import datos.Soporte;
import datos.Turno;
import negocio.EspecialidadABM;
import negocio.SoporteABM;

public class TestConsultasSoporte {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SoporteABM abmSoporte = new SoporteABM(); 
		EspecialidadABM abmEspecialidad = new EspecialidadABM();
		
		Especialidad especialidad1 = abmEspecialidad.traer(1);
		List<Soporte> soportes = abmSoporte.traerSoportePorEspecialidad(especialidad1);
		
		for(Soporte s : soportes) {
			System.out.println(s.toString());
		}
		
		List<Soporte> turnos = abmSoporte.traerSoportePorTurno(Turno.NOCHE); 
		
		for (Soporte s: turnos) {
			System.out.println(s.toString());
		}
		
		
	}

}

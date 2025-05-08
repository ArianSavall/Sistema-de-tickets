package test;

import negocio.ClienteABM;


public class TestABMCliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClienteABM abm = new ClienteABM(); 
		
		abm.agregar("Juan", "Pérez", "juan@mail.com", "1234", "20-23456789-9", "foto.jpg", "Tecnología");
		
	}

}

package test;

import negocio.ClienteABM;


public class TestABMCliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClienteABM cliente = new ClienteABM(); 
		
		//cliente.agregar("More", "Rios", "moreri@gmail.com", "toto30", "20-46873097-4", "20301258567", "Administracion");
		
		//cliente.modificarNombre("20-46873097-4", "Morena");
		
		System.out.println(cliente.traer("20-46873097-4")); 
		
		
	}

}

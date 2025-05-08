package test;

import java.util.List;

import datos.Cliente;
import negocio.ClienteABM;

public class TestClientePorArea {

	public static void main(String[] args) {
		ClienteABM abmCliente = new ClienteABM();
		
		List<Cliente> clientesPorArea = abmCliente.traerClientesPorArea("Tecnología");
		
		for(Cliente c : clientesPorArea) {
			System.out.println(c.toString());
		}
	}

}

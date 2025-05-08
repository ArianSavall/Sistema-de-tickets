package Excepciones;

public class CuilDuplicadoException extends Exception{

	public CuilDuplicadoException() {
		super("YA EXISTE UN USER CON ESE CUIL");
	}
	
}

package datos;
import java.util.List;

public class Cliente extends Usuario {
	private String area;

	public Cliente(){}

	public Cliente(String nombre, String apellido, String email, String password, String cuil, String fotoPerfil, String area) {
		super(nombre, apellido, email, password, cuil, fotoPerfil);
		this.area = area;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	@Override
	public String toString() {
		return "Cliente [" + super.toString() +"area=" + area + "]";
	} 
	
	
	
	
}

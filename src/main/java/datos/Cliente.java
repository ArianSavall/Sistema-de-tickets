package datos;

import java.util.List;


public class Cliente {
	private String area;

	
	
	public Cliente() {
		super();
	}

	@Override
	public String toString() {
		return "Cliente [area=" + area + "]";
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}
	
}

package clase;

public class bebidas {
	
	String nombre;
	int calorias;
	int precio;
	

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getCalorias() {
		return calorias;
	}
	public void setCalorias(int calorias) {
		this.calorias = calorias;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	public bebidas(String nombre, int calorias, int precio) {
		super();
		this.nombre = nombre;
		this.calorias = calorias;
		this.precio = precio;
	}

	
}

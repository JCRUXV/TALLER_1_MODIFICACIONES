package clase;

public class ingrediente 
{
	
	
	String nombre;
	int CostoAdicional;
	int calorias;
	
	public ingrediente(String nombre, int costoAdicional, int calorias) {
		super();
		this.nombre = nombre;
		CostoAdicional = costoAdicional;
		this.calorias = calorias;
	}
	public int getCalorias() {
		return calorias;
	}
	public void setCalorias(int calorias) {
		this.calorias = calorias;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getCostoAdicional() {
		return CostoAdicional;
	}
	public void setCostoAdicional(int costoAdicional) {
		CostoAdicional = costoAdicional;
	}
	public ingrediente(String nombre, int costoAdicional) {
		super();
		this.nombre = nombre;
		CostoAdicional = costoAdicional;
	}
	
	
	
}
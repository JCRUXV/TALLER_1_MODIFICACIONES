package clase;

public class ProductoMenu 
{
	
	public ProductoMenu(int precioBase, String nombre, int calorias) {
		super();
		PrecioBase = precioBase;
		this.nombre = nombre;
		this.calorias = calorias;
	}
	int PrecioBase;
	String nombre;
	int calorias;
	
	
	public int getCalorias() {
		return calorias;
	}



	public void setCalorias(int calorias) {
		this.calorias = calorias;
	}



	public ProductoMenu(int precioBase, String nombre) {
		super();
		PrecioBase = precioBase;
		this.nombre = nombre;
	}

	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getPrecioBase() {
		return PrecioBase;
	}
	public void setPrecioBase(int precioBase) {
		PrecioBase = precioBase;
	}
	
	

}

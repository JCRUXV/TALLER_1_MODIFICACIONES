
package procesamiento;import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import clase.ProductoMenu;
import clase.bebidas;
import clase.combo;
import clase.ingrediente;
import clase.pedido;


public class Restaurante { 
	
	public Restaurante() {
}
	
	
private final List<ProductoMenu> ProductoDelMenu = new ArrayList<>();

public List<ProductoMenu> getlistaProductos() {
	
	
return ProductoDelMenu;
}
public ArrayList<ProductoMenu> cargarMenu() throws FileNotFoundException, IOException{
String currentDirectory = new File("").getAbsolutePath();
BufferedReader br = new BufferedReader(new FileReader(currentDirectory +"\\data\\"+"menu.txt"));
String st;
while ((st = br.readLine()) != null){
String[] words=st.split(";");
int precio=Integer.parseInt(words[1]);
int calorias=Integer.parseInt(words[2]);
this.ProductoDelMenu.add(new ProductoMenu(precio, words[0], calorias));
}
return (ArrayList<ProductoMenu>) ProductoDelMenu;

	
	
}


private final List<ingrediente> ingredientes = new ArrayList<>();

public List<ingrediente> getlistaIngredientes() {
	
	
return ingredientes;
}

public ArrayList<ingrediente> cargarIngredientes() throws FileNotFoundException, IOException
{
	String currentDirectory = new File("").getAbsolutePath();
	BufferedReader br = new BufferedReader(new FileReader(currentDirectory +"\\data\\ingredientes.txt"));
	String st;
	while ((st = br.readLine()) != null){
		String[] words=st.split(";");
		int precio=Integer.parseInt(words[1]);
		int calorias = Integer.parseInt(words[2]);
		this.ingredientes.add(new ingrediente(words[0], precio, calorias));
	}
		
	return (ArrayList<ingrediente>) ingredientes;
}

	private final List<bebidas> LasBebidas = new ArrayList<>();
	public List<bebidas> getListaBebidas()
	{
		return LasBebidas;
	}

	public ArrayList<bebidas> cargarBebidas() throws FileNotFoundException, IOException
	{
		String currentDirectory = new File("").getAbsolutePath();
		BufferedReader br = new BufferedReader(new FileReader(currentDirectory +"\\data\\bebidas.txt"));
		String st;
		while ((st = br.readLine()) != null){
			String[] words=st.split(";");
			int precio=Integer.parseInt(words[1]);
			int calorias = Integer.parseInt(words[2]);
			this.LasBebidas.add(new bebidas(words[0], calorias, precio));
		}
		return (ArrayList<bebidas>) LasBebidas;
		}


	private final List<combo> combos = new ArrayList<>();
	public List<combo> getlistaCombos() {
		
		
		return combos;
		}
	
	public List<combo> cargarCombos() throws FileNotFoundException, IOException
	{
		String currentDirectory = new File("").getAbsolutePath();
		BufferedReader br = new BufferedReader(new FileReader(currentDirectory +"\\data\\combos.txt"));
		String st;
		while ((st = br.readLine()) != null){
			String[] words=st.split(";");
			ArrayList<String> ingredientesCombo = new ArrayList<>();
			ingredientesCombo.add(words[3]);
			ingredientesCombo.add(words[4]);
			ingredientesCombo.add(words[5]);
			String[] porcentaje = words[1].split("%");
			double descuentoAplicado = Double.parseDouble(porcentaje[0]);
			int ValorCalorias = Integer.parseInt(words[2]);
			this.combos.add(new combo(words[0], descuentoAplicado, ingredientesCombo, ValorCalorias));
				
	} 
		
		return combos;
}
	private final List<pedido> pedidos = new ArrayList<>();
	
	public List<pedido> getListaPedidos()

	{
	return pedidos;
	}
	private final List<ProductoMenu> productosMenuPedido= new ArrayList<>();
	public List<pedido> iniciarPedido(String nombreCliente, String direccionCliente,List<ProductoMenu> productosDelMenu,List<ingrediente> ingredientes,List<combo> combos, List<bebidas> LasBebidas)
	{
	
		int min = 1;
		int max = 1000;

		Random random = new Random();

		int value = random.nextInt(max + min) + min;
		this.pedidos.add(new pedido(agregarProductos(productosDelMenu), AgregarCombo(combos), agregarIngrediente(ingredientes),agregarBebidas(LasBebidas), nombreCliente, direccionCliente, value));
	
		

    
		return pedidos;
	}
	private final List<combo> combosPedido= new ArrayList<>();
	private final List<ingrediente> ingredientesPedido = new ArrayList<>();
	public List<ProductoMenu> agregarProductos (List<ProductoMenu> productoDelMenu){
		boolean agregar=true;
		while (agregar==true){
			for (int i=0;i<productoDelMenu.size();i++) {
				System.out.println(i+" "+productoDelMenu.get(i).getNombre());
			}
			System.out.println("19. Para dejar de agregar o no agregar nada");
			Scanner myObj = new Scanner(System.in);  // Create a Scanner object
		    System.out.println("Selecciona el producto que desea agregar: ");
		    String userName = myObj.nextLine();
		    int opciones=Integer.parseInt(userName);
		    if (userName.equals("19")) {
		        agregar=false;
		}else {
			this.productosMenuPedido.add(productoDelMenu.get(opciones));
		}
	}
		return productosMenuPedido;
}
	public List<ingrediente> agregarIngrediente (List<ingrediente> Ingredientes){
		boolean agregar=true;
		while (agregar==true){
			for (int i=0;i<Ingredientes.size();i++) {
				System.out.println(i+" "+Ingredientes.get(i).getNombre());
			}
			System.out.println("16. Para dejar de agregar o no agregar nada");
			Scanner myObj = new Scanner(System.in);  // Create a Scanner object
		    System.out.println("Selecciona el producto que desea agregar: ");
		    String userName = myObj.nextLine();
		    int opciones=Integer.parseInt(userName);
		    if (userName.equals("16")) {
		        agregar=false;
		}else {
			this.ingredientesPedido.add(Ingredientes.get(opciones));
		}
	}
		return ingredientesPedido;
}

	
	public List<combo> AgregarCombo(List<combo> combos)
	{
	boolean agregar = true;
	while (agregar==true) 
	{
	for (int i=0; i<combos.size();i++) 
	{
		System.out.println(i+" "+combos.get(i).getNombreCombo());	
	}
	
	System.out.println("4. para dejar de agregar o no agregar ningun combo");
	Scanner myObj = new Scanner(System.in);
	System.out.println("por favor selecciona el combo que deseas agregar: ");
	String userName = myObj.nextLine();
	int opciones=Integer.parseInt(userName);
	if (userName.equals("4")) 
	{
		agregar = false;
	}
	
	else 
	{
		this.combosPedido.add(combos.get(opciones));
	}
	
	
	}
	return combosPedido;
	}
	
	private final List<bebidas> pedidoBebidas = new ArrayList<>();
	public List<bebidas> agregarBebidas (List<bebidas> LasBebidas){
		boolean agregar=true;
		while (agregar==true){
			for (int i=0;i<LasBebidas.size();i++) {
				System.out.println(i+" "+LasBebidas.get(i).getNombre());
			}
			System.out.println("3. Para dejar de agregar o no agregar nada");
			Scanner myObj = new Scanner(System.in);  // Create a Scanner object
		    System.out.println("Selecciona el producto que desea agregar: ");
		    String userName = myObj.nextLine();
		    int opciones=Integer.parseInt(userName);
		    if (userName.equals("3")) {
		        agregar=false;
		}else {
			this.pedidoBebidas.add(LasBebidas.get(opciones));
		}
	}
		return pedidoBebidas;
}
	public int combosPrecio(List<combo> combos, List<combo> combosPedido,List<ProductoMenu> productosMenu){
        List<ArrayList<String>> ingredientes = new ArrayList<>();
        List<Double> descuentos= new ArrayList<>();
        for (int i=0;i<combosPedido.size();i++)
        {
            ingredientes.add((ArrayList<String>) combosPedido.get(i).getCombos());
            descuentos.add(combosPedido.get(i).getDescuento());
        }
        List<Integer> precios= new ArrayList<>();
        
            for (int j=0;j<ingredientes.size();j++){
                for (int z=0;z<ingredientes.get(j).size();z++){
                    for (int i=0;i<productosMenu.size();i++){
                    if (ingredientes.get(j).get(z).equals(productosMenu.get(i).getNombre()))
                    
                    {
                        precios.add(productosMenu.get(i).getPrecioBase());
                        
                 }
              }
           }
        }
            List<List<Integer>> sublistas = new ArrayList<>();
            int size = 3;
            for (int start = 0; start < precios.size(); start += size) {
            int end = Math.min(start + size, precios.size());
            List<Integer> sublist = precios.subList(start, end);
            sublistas.add(sublist);
        }
            double precioCompra=0;
            for (int i=0;i<sublistas.size();i++){
                int sum = sublistas.get(i).stream().mapToInt(Integer::intValue).sum();
                precioCompra=precioCompra+(sum-((sum*descuentos.get(i))/100));
                
            }
            precioCompra = precioCompra+(precioCompra*0.19);
            return (int) precioCompra;
            
        }
	
	public int precioIngredientesyProductos(List<ingrediente> ingredientesPedido, List<ProductoMenu> productosPedido)
	{
        List<Integer> precios = new ArrayList<>();
        for (int i=0;i<ingredientesPedido.size();i++){
            precios.add(ingredientesPedido.get(i).getCostoAdicional());
        }
        for (int j=0;j<productosPedido.size();j++){
            precios.add(productosPedido.get(j).getPrecioBase());
        }
        int precioTotal = precios.stream().mapToInt(Integer::intValue).sum();
        precioTotal = (int) (precioTotal+(precioTotal*0.19));
        return precioTotal;
    }

	
	public int combosPrecioBebidas(List<combo> combos, List<combo> comboPedido,List<bebidas> LasBebidas){
		List<ArrayList<String>> ingredientes = new ArrayList<>();
		List<Double> descuentos= new ArrayList<>();
		for (int i=0;i<comboPedido.size();i++){
		ingredientes.add((ArrayList<String>) comboPedido.get(i).getCombos());
		descuentos.add(comboPedido.get(i).getDescuento());
		}
		List<Integer> precios= new ArrayList<>();
		for (int j=0;j<ingredientes.size();j++){
		for (int z=0;z<ingredientes.get(j).size();z++){
		for (int i=0;i<LasBebidas.size();i++){
		if (ingredientes.get(j).get(z).equals(LasBebidas.get(i).getNombre())){
		precios.add(LasBebidas.get(i).getPrecio());
		}
		}
		}
		}
		List<List<Integer>> sublistas = new ArrayList<>();
		int size = 1;
		for (int start = 0; start < precios.size(); start += size) {
		int end = Math.min(start + size, precios.size());
		List<Integer> sublist = precios.subList(start, end);
		sublistas.add(sublist);
		}
		double precioCompra=0;
		for (int i=0;i<sublistas.size();i++){
		int sum = sublistas.get(i).stream().mapToInt(Integer::intValue).sum();
		precioCompra=precioCompra+(sum-((sum*descuentos.get(i))/100));
		}
		return (int) precioCompra;
		}
	
	

      }
	
	



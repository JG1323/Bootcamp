import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class T7ejercicio3 {
	Scanner scanner = new Scanner(System.in);
	
	Map<String, Integer> agregarProductolent = new HashMap<>();
private static void agregarProducto(Map<String, Map<String, Object>> stockProductos, String string, int i, double d) {

	agregarProducto(stockProductos, "Manzanas", 20, 2.5);
	agregarProducto(stockProductos, "Plátanos", 15, 1.8);
	agregarProducto(stockProductos, "Leche", 30, 1.2);
	agregarProducto(stockProductos, "Pan", 25, 0.9);
	agregarProducto(stockProductos, "Huevos", 40, 3.0);
	agregarProducto(stockProductos, "Arroz", 50, 1.5);
	agregarProducto(stockProductos, "Aceite", 35, 2.8);
	agregarProducto(stockProductos, "Azúcar", 45, 1.0);
	agregarProducto(stockProductos, "Sal", 40, 0.8);
	agregarProducto(stockProductos, "Café", 20, 4.0);

}
private static void agregarProducto(Map<String, Map<String, Object>> productosMap, Scanner scanner) {
	System.out.print("Introduzca el nombre del nuevo producto: ");
	String nombreProducto = scanner.nextLine();

	if (productosMap.containsKey(nombreProducto)) {
		System.out.println("El producto ya existe en la base de datos.");
		return;
	}

	Map<String, Object> datosProducto = new HashMap<>();

	System.out.print("Introduzca la cantidad del producto: ");
	int cantidad = scanner.nextInt();
	scanner.nextLine();
	datosProducto.put("cantidad", cantidad);

	System.out.print("Introduzca el precio del producto: ");
	double precio = scanner.nextDouble();
	scanner.nextLine();
	datosProducto.put("precio", precio);

	productosMap.put(nombreProducto, datosProducto);

	System.out.println("Producto añadido correctamente.");

}
}
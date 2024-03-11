import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class CheckpointT7ej3 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Bienvenido a la Base de Datos:");
		System.out.println("Empecemos");

		Map<String, Map<String, Object>> productosMap = new HashMap<>();
		Map<String, Object> datosProductos = new HashMap<>();
		baseDeDatos(productosMap, datosProductos);

		System.out.println(productosMap);
		System.out.println("Perfecto!");

		while (true) {
			System.out.println("\n---- Menú Principal ----");
			System.out.println("\n--- Que Quieres Hacer? ---");
			System.out.println("1. Añadir artículo");
			System.out.println("2. Consultar artículo");
			System.out.println("3. Listar todos los artículos");
			System.out.println("4. Salir");
			System.out.print("Seleccione una opción: ");

			String opcion = scanner.nextLine();

			switch (opcion) {
			case "1":
				 anadirArticulo(productosMap, scanner);
				System.out.println("1");

				break;
			case "2":
				System.out.println("2");
				break;
			case "3":
				System.out.println(productosMap);

				break;
			case "4":
				System.out.println("¡Hasta luego!");
				scanner.close();
				System.exit(0);
			default:
					System.out.println("Opción no válida. Inténtelo de nuevo.");

					}
			}
					
	}
			
			private static void anadirArticulo(Map<String, Map<String, Object>> productosMap, Scanner scanner) {
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
			public static void mostrarListaProductos(Map<String, Map<String, Object>> productosMap) {
		        System.out.println("Lista de todos los productos:");
		        for (Map.Entry<String, Map<String, Object>> entry : productosMap.entrySet()) {
		            String producto = entry.getKey();
		            Map<String, Object> datos = entry.getValue();
		            int cantidad = (int) datos.get("cantidad");
		            int precio = (int) datos.get("precio");

		            System.out.println("Producto: " + producto + ", Cantidad: " + cantidad + ", Precio: €" + precio);
		        }
		    }
		

	private static void baseDeDatos(Map<String, Map<String, Object>> productosMap, Map<String, Object> datosProductos) {
		datosProductos.put("cantidad", 1);
		datosProductos.put("cantidad", 1);
		datosProductos.put("cantidad", 1);
		datosProductos.put("cantidad", 1);
		datosProductos.put("cantidad", 1);
		datosProductos.put("cantidad", 1);
		datosProductos.put("cantidad", 1);
		datosProductos.put("cantidad", 1);
		datosProductos.put("cantidad", 1);
		datosProductos.put("cantidad", 1);

		datosProductos.put("precio", 1);
		datosProductos.put("precio", 1);
		datosProductos.put("precio", 1);
		datosProductos.put("precio", 1);
		datosProductos.put("precio", 1);
		datosProductos.put("precio", 1);
		datosProductos.put("precio", 1);
		datosProductos.put("precio", 1);
		datosProductos.put("precio", 1);
		datosProductos.put("precio", 1);

		productosMap.put("producto1", datosProductos);
		productosMap.put("producto2", datosProductos);
		productosMap.put("producto3", datosProductos);
		productosMap.put("producto4", datosProductos);
		productosMap.put("producto5", datosProductos);
		productosMap.put("producto6", datosProductos);
		productosMap.put("producto7", datosProductos);
		productosMap.put("producto8", datosProductos);
		productosMap.put("producto9", datosProductos);
		productosMap.put("producto10", datosProductos);

		
		
	}
}